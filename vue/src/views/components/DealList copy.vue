

<script setup>
import { RouterLink } from 'vue-router';
import { defineProps, defineEmits, watch, ref } from 'vue';
import BillingCard from './BillingCard.vue';


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

<template>
  <div class="card">
    <div class="card-header pb-0">
      <h6>매물 목록</h6>
    </div>


    <div class="card-body px-0 pt-0 pb-2 ">
      <div class="table-responsive p-0">
        

          <!-- Table Body -->
        <div class = "scrollable-content">

            <ul class="list-group">
              <li
                v-for="(aptDeal, index) in aptDealList" :key="aptDeal.aptCode"
                class="list-group-item border-0 d-flex bg-gray-100 border-radius-lg"
              >
                <div class="d-flex flex-column">
                  <h6 class="mb-3 text-sm">{{ aptDeal.aptName }}</h6>
                  <span class="mb-2 text-xs">
                    Company Name:
                    <span class="text-dark font-weight-bold ms-sm-2"
                      ><RouterLink :to="{
                        name: 'DealDetail',
                        params: { aptCode: aptDeal.aptCode ,floor : aptDeal.floor}
                      }">
                    {{ aptDeal.aptName }} {{ aptDeal.floor }}층
                      </RouterLink></span
                    >
                  </span>
                  <span class="mb-2 text-xs">
                    Email Address:
                    <span class="text-dark ms-sm-2 font-weight-bold"
                      > {{ aptDeal.floor }}층</span
                    >
                  </span>
                  <span class="text-xs">
                    {{ aptDeal }} 억
                    <span class="text-dark ms-sm-2 font-weight-bold">FRB1235476</span>
                  </span>
                </div>
                <div class = "col-lg-1">
                    <i v-if="viewMarkList[index]" @click="unMark(aptDeal,index)" class='fas fa-bookmark' style='font-size:24px'></i>
                    <i v-else @click="mark(aptDeal,index)" class='far fa-bookmark' style='font-size:24px'></i>
                  </div>
              </li>
              
            </ul>

        </div>
      </div>
    </div>
  </div>
</template>


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