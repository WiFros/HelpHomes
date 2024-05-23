<template>
  <div class="card">
    <div class="card-header pb-0">
      <h6>QnA 게시판</h6>
    </div>

    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <div class="scrollable-table">
          <table class="table align-items-center mb-0"></table>
        </div>
        <!-- Table Body -->

        <div class="scrollable-content">
          <table class="table align-items-center mb-0">
            <thead>
              <tr>
                <th class="text-uppercase text-xs">게시물 제목</th>
                <th
                  class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
                ></th>

                <th
                  class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                >
                  게시일
                </th>
                <th
                  class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                >
                  작성자
                </th>
              </tr>
            </thead>

            <tbody>
              <tr v-for="qna in qnaList" :key="qna.num">
                <td>
                  <div class="d-flex px-2 py-1">
                    <div class="d-flex flex-column justify-content-center">
                      <h6 class="mb-0 text-sm">
                        <RouterLink
                          :to="{
                            name: 'QnaDetail',
                            params: { num: qna.num },
                          }"
                          >{{ qna.title }}
                        </RouterLink>
                      </h6>
                    </div>
                  </div>
                </td>

                <td>
                  <div class="d-flex px-2 py-1">
                    <div class="d-flex flex-column justify-content-center">
                      <h6 class="mb-0 text-sm"></h6>
                    </div>
                  </div>
                </td>

                <td class="align-middle text-center">
                  <span class="text-secondary text-xs font-weight-bold">{{
                    qna.wdate.substring(0, 11)
                  }}</span>
                </td>

                <td class="align-middle text-center">
                  <span class="text-dark text-xs font-weight-bold">
                    운영자
                  </span>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { selectAll } from '../../api/qna.js';
import { RouterLink } from 'vue-router';

const qnaList = ref([]);

onMounted(() => {
  selectAll(
    (response) => {
      console.log(response.data);
      qnaList.value = response.data;
    },
    (error) => {
      console.error(error);
    },
  );
});
</script>

<style scoped>
.scrollable-table {
  overflow-x: auto;
}
.scrollable-content {
  min-height: 700px; /* 내용이 표시될 최대 높이 */
  max-height: 150px; /* 내용이 표시될 최대 높이 */
  overflow-y: auto; /* 세로 스크롤 추가 */
}
</style>
