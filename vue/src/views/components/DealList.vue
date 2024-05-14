<template>
  <div class="card">
    <div class="card-header pb-0">
      <h6>매물 목록</h6>
    </div>


    <div class="card-body px-0 pt-0 pb-2 ">
      <div class="table-responsive p-0">
        
        <div class = "scrollable-table">
        <table class="table align-items-center mb-0">
          <thead>
            <tr>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                아파트 이름
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                거래금액
              </th>
              <th class="text-secondary opacity-7"></th>
            </tr>
          </thead>
          </table>
        </div>

          <!-- Table Body -->
        <div class = "scrollable-content">
        <table class=" table align-items-center mb-0">
          <tbody>
            <tr v-for="qna in qnaList" :key="qna.num">
              <td>
                <div class="d-flex px-2 py-1">
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
    }
  );
});

</script>


<style scoped>
.scrollable-table {
  overflow-x: auto;
}
.scrollable-content {
  min-height: 400px; /* 내용이 표시될 최대 높이 */
  max-height: 400px; /* 내용이 표시될 최대 높이 */
  overflow-y: auto; /* 세로 스크롤 추가 */
}
</style>