<template>
  <div class="card">
    <div class="card-header py-3" >
      <div class="row align-items-center">
    <h4 class="col-lg-3">QnA 게시판</h4>

    <div class="col-lg-4"></div>

    <div class="col-lg-5">
        <div class="row nog rounded-custom align-items-center">
            <input type="text" name="word" v-model="keyword" placeholder="검색어를 입력하세요" class="rounded-custom custom-input col-lg-5 ms-9">
            <select name="condition" v-model="option" class=" rounded-custom custom-select col-lg-3 mx-2">
                <option value="title">제목</option>
                <option value="name">글쓴이</option>
            </select>
            <input type="button" class="custom-button rounded-custom btn btn-primary col-lg-2 m-2" value="검색" id="btnSearch" @click="searchQna">
        </div>
    </div>
</div>

    </div>
   


    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center mb-0">
          <thead>
            <tr>
              <th class="text-center text-uppercase text-dark text-s font-weight-bolder opacity-7" style="width: 1%;">
                번호 
              </th>
              <th class="text-center text-uppercase text-dark text-s font-weight-bolder opacity-7" style="width: 7%;">
                상태
              </th>
              <th class="text-center text-uppercase text-dark text-s font-weight-bolder opacity-7" style="width: 30%;">
                제목
              </th>
              <th class="text-center text-uppercase text-dark text-s font-weight-bolder opacity-7" style="width: 10%;">
                작성자
              </th>
              
              <th class="text-center text-uppercase text-dark text-s font-weight-bolder opacity-7" style="width: 5%;">
                조회수
              </th>
              <th class="text-center text-uppercase text-dark text-s font-weight-bolder opacity-7" style="width: 10%;">
                게시일
              </th>
            </tr>
          </thead>
          <!-- Table Body -->
          <tbody>
            <tr v-for="(qna,idx) in qnaList" :key="qna.num">
              <td class = "number-column">
                <div class="d-flex  justify-content-center">
                  <p class="text-s font-weight-bold mt-3">{{ idx+1 }}</p>
                </div>
              </td>

              <td class="number-column align-middle text-center text-s">
                <span
                  :class="['badge badge-sm', qna.status === 'unresolved' ? 'bg-gradient-secondary' : 'bg-gradient-success']">
                  {{ qna.status }}
                </span>
              </td>


              <td class = "number-column">
                <RouterLink :to="{
                        name: 'QnaDetail',
                        params: { num: qna.num }
                      }">

                  <div class="d-flex justify-content-center">
                    <h6 class="mb-0 mx-2 text-s">{{ qna.title }}
                    </h6>
                  </div>
              </RouterLink>
              </td>

              <td class = "number-column">
                <div class="d-flex px-2 py-1 justify-content-center">
                    <img src="../../assets/img/team-2.jpg" class="avatar avatar-sm me-3" alt="user1" />
                  <p class="text-s font-weight-bold mt-1">{{ qna.writer }}</p>
                </div>
              </td>

              <td class = "number-column">
                <div class="d-flex px-2 py-1 justify-content-center">
                  <p class="text-s font-weight-bold mt-2">{{ qna.count }}</p>
                </div>
              </td>

              <td class="align-middle text-center number-column">
                <span class="text-secondary text-s font-weight-bold">{{ qna.wdate }}</span>
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
    max-height: 35px; /* 원하는 크기로 설정 */
  }

.custom-input {
  width: 250px; /* 원하는 크기로 설정 */
  max-height: 35px; /* 원하는 크기로 설정 */
}

.custom-button {
    width: 80px; /* 원하는 크기로 설정 */
  max-height: 50px; /* 원하는 크기로 설정 */
}
/* 번호 열에 수직선 추가 */
td.number-column {
    border-right: 1px solid #f0f0f0; /* 원하는 색상과 두께로 설정 */
  }
.nog {
  margin-right: 0;
  margin-left: 0;
}

.rounded-custom {
        border-radius: 10px; /* 원하는 픽셀 값으로 설정 */
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