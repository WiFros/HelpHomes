<template>
  <div class="card ">
    <div class="card-header pb-0 " >
      <div class = "row">

        <h6 class="col-lg-1">QnA 게시판</h6>

        <div class = "col-lg-6"></div>

        <div class = "col-lg-5 nog">

        <div class = "row nog">
            <select name="condition" v-model ="option"  class = "custom-select col-lg-2  mx-2">
              <option value="title" >제목</option>
              <option value="name" >글쓴이</option>
            </select>

            <input type="text" name="word" v-model="keyword"  class = "custom-input col-lg-4  mx-2">

          <input type="button" class="btn btn-primary col-lg-2 mx-2" value="검색" id="btnSearch" @click="searchQna" />
        </div>
        </div>
      </div>
    </div>
   


    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center mb-0">
          <thead>
            <tr>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                게시물
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                작성자
              </th>
              <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                상태
              </th>
              <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                게시일
              </th>
              <th class="text-secondary opacity-7"></th>
            </tr>
          </thead>
          <!-- Table Body -->
          <tbody>
            <tr v-for="qna in qnaList" :key="qna.num">
              <td>
                <div class="d-flex px-2 py-1">
                  <div>
                    <img src="../../assets/img/team-2.jpg" class="avatar avatar-sm me-3" alt="user1" />
                  </div>
                  <div class="d-flex flex-column justify-content-center">
                    <h6 class="mb-0 text-sm">
                      <RouterLink :to="{
                        name: 'QnaDetail',
                        params: { num: qna.num }
                      }">{{ qna.title }}
                      </RouterLink>
                    </h6>
                    <p class="text-xs text-secondary mb-0">
                      {{ qna.email }}
                    </p>
                  </div>
                </div>
              </td>
              <td>
                <p class="text-xs font-weight-bold mb-0">{{ qna.writer }}</p>
                <p class="text-xs text-secondary mb-0">{{ qna.region }}</p>
              </td>
              <td class="align-middle text-center text-sm">
                <span
                  :class="['badge badge-sm', qna.status === 'unresolved' ? 'bg-gradient-secondary' : 'bg-gradient-success']">
                  {{ qna.status }}
                </span>
              </td>
              <td class="align-middle text-center">
                <span class="text-secondary text-xs font-weight-bold">{{ qna.wdate }}</span>
              </td>
              <td class="align-middle">
                <a href="javascript:;" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip"
                  data-original-title="Edit user">Edit</a>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <button class="btn btn-sm btn-success" style="margin-left: 20px;">
        <RouterLink :to="{
                        name: 'insert',
                      }">글쓰기
                      
        </RouterLink>
      </button>
    </div>
  </div>
</template>

<style>
.custom-select {
    width: 70px; /* 원하는 크기로 설정 */
    max-height: 27px; /* 원하는 크기로 설정 */
  }

.custom-input {
  width: 160px; /* 원하는 크기로 설정 */
  max-height: 27px; /* 원하는 크기로 설정 */
}

.nog {
  margin-right: 0;
  margin-left: 0;
}
</style>

<script setup>
import { onMounted, ref } from 'vue';
import { selectAll,search } from '../../api/qna.js';
import { RouterLink } from 'vue-router';

const qnaList = ref([]);
const keyword = ref("");
const option = ref("");


onMounted(() => {
  selectAll(
    (response) => {
      console.log(response.data);
      qnaList.value = response.data;
    },
    (error) => {
      console.error(error);
    }
  );
});

function searchQna(){
  const param = {
    condition : option.value,
    word : keyword.value
  }
  search(param,
    (response) => {

      qnaList.value = response.data;
    },
    (error) => {
      console.error(error);
    });
  }
</script>