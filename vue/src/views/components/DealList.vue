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
              <!-- <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                거래금액
              </th> -->
              <th class="text-secondary opacity-7"></th>
            </tr>
          </thead>
          </table>
        </div>

          <!-- Table Body -->
        <div class = "scrollable-content">
        <table class=" table align-items-center mb-0">
          <tbody>
            <tr v-for="(aptDeal, index) in aptDealList" :key="aptDeal.aptCode">
              <td>
                <div class="d-flex px-2 py-1">

                
                  <button v-if="viewMarkList[index]" @click="unMark(aptDeal,index)">
                      찜해제
                    </button>
                    <button v-else @click="mark(aptDeal,index)">
                      찜하기
                    </button>
                  <div class="d-flex flex-column justify-content-center">
                    <h6 class="mb-0 text-sm">
                      <RouterLink :to="{
                        name: 'DealDetail',
                        params: { aptCode: aptDeal.aptCode ,floor : aptDeal.floor}
                      }">
                    {{ aptDeal.aptName }} {{ aptDeal.floor }}층
                      </RouterLink>
                    </h6>
                    <p class="text-xs text-secondary mb-0">
                      {{ aptDeal.dealAmount }} 억
                    </p>
                  </div>
                  
                </div>
              </td>
              <!-- <td>
                <p class="text-xs font-weight-bold mb-0">{{ aptDeal.writer }}</p>
                <p class="text-xs text-secondary mb-0">{{ aptDeal.region }}</p>
              </td> -->
            </tr>
          </tbody>
        </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { RouterLink } from 'vue-router';
import { defineProps,defineEmits,watch,ref } from 'vue';


const props = defineProps({
  aptDealList: Array,
  aptMarkList: Array
});

const viewMarkList = ref([]);

const emits = defineEmits(['dealMark']);

// aptDealList가 변경될 때마다 viewMarkList 업데이트
watch(() => props.aptDealList, (newVal) => {
  updateViewMarkList(newVal);
});

// viewMarkList 업데이트 함수
function updateViewMarkList(dealList) {
  for (let i = 0; i < dealList.length; i++) {
  viewMarkList.value.push( props.aptMarkList.includes(dealList[i].aptCode));
  }

}

function mark(aptDeal,index) {
  emits('dealMark', aptDeal);
  viewMarkList.value[index] = true;
} 

function unMark(aptDeal,index) {
  emits('dealUnMark', aptDeal);
  viewMarkList.value[index] = false;
}
</script>


<style scoped>
.scrollable-table {
  overflow-x: auto;
}
.scrollable-content {
  min-height: 480px; /* 내용이 표시될 최대 높이 */
  max-height: 300px; /* 내용이 표시될 최대 높이 */
  overflow-y: auto; /* 세로 스크롤 추가 */
}
</style>