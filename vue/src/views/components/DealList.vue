<script setup>
import { RouterLink } from 'vue-router';
import { defineProps, defineEmits, watch, ref } from 'vue';

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
  viewMarkList.value.length = 0;
  viewMarkList.value = dealList.map(deal => props.aptMarkList.includes(deal.aptCode));
}

function mark(aptDeal, index) {
  emits('dealMark', aptDeal);
  viewMarkList.value[index] = true;
}

function unMark(aptDeal, index) {
  emits('dealUnMark', aptDeal);
  viewMarkList.value[index] = false;
}
</script>

<template>
  <div class="card">
    <div class="card-header pb-0">
      <h6>매물 목록</h6>
    </div>
    <div class="card-body pt-1 p-2">
      <div class="table-responsive p-0">
        <!-- Table Body -->
        <div class="scrollable-content">
          <ul class="list-group">
            <li
              v-for="(aptDeal, index) in aptDealList"
              :key="aptDeal.aptCode"
              class="list-group-item border-0 m-1 bg-gray-200 border-radius-lg d-flex align-items-center custom-list-item"
            >
              <div class="col-lg-4 ">
                <div class="text-dark font-weight-bold pt-1 pl-1" style="font-size:16px;">
                  {{ aptDeal.aptName }}
                </div>
                <RouterLink
                  :to="{
                    name: 'DealDetail',
                    params: { aptCode: aptDeal.aptCode, floor: aptDeal.floor }
                  }"
                >
                  <button type="button" class="btn btn-secondary custom-btn">
                    상세 <i class="fas fa-search" style="font-size: 12px"></i>
                  </button>
                </RouterLink>
              </div>
              <div class="col-lg-7">
                <div class="text-xs">
                  층수 :
                  <span class="text-dark font-weight-bold ms-sm-1">{{ aptDeal.floor }}층</span>
                </div>
                <div class="text-xs">
                  매매가 :
                  <span class="text-dark ms-sm-1 font-weight-bold">{{ aptDeal.dealAmount }} 억</span>
                </div>
                <div class="text-xs">
                  주소 :
                  <span class="text-dark ms-sm-1 font-weight-bold">{{ aptDeal.roadName }}</span>
                </div>
              </div>
              <div class="col-lg-1 p-0">
                <i
                  v-if="viewMarkList[index]"
                  @click="unMark(aptDeal, index)"
                  class="fas fa-bookmark"
                  style="font-size:24px;"
                ></i>
                <i
                  v-else
                  @click="mark(aptDeal, index)"
                  class="far fa-bookmark"
                  style="font-size:24px;"
                ></i>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.scrollable-content {
  min-height: 600px; /* 내용이 표시될 최대 높이 */
  max-height: 300px; /* 내용이 표시될 최대 높이 */
  overflow-y: auto; /* 세로 스크롤 추가 */
}

.custom-btn {
  font-size: 12px;
  padding: 2px 6px;
}

.custom-list-item {
  display: flex;
  align-items: center;
}
</style>
