<template>
  <div class="card">
    <div class="card-header pb-0">
      <h6>관심 매물</h6>
    </div>

    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <div class="scrollable-table">
          <table class="table align-items-center mb-0">
            <thead></thead>
          </table>
        </div>

        <!-- Table Body -->
        <div class="scrollable-content">
          <table class="table align-items-center mb-0">
            <thead>
              <tr>
                <th class="text-uppercase text-xs">매물 이름</th>

                <th
                  class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                >
                  도로명 주소
                </th>
                <th
                  class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                >
                  상세보기
                </th>
                <th
                  class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                >
                  위치
                </th>
              </tr>
            </thead>

            <tbody>
              <tr v-for="markApt in markAptList" :key="markApt.aptCode">
                <td>
                  <div class="d-flex px-2 py-1">
                    <div class="d-flex flex-column justify-content-center">
                      <h6 class="mb-0 text-sm">{{ markApt.apartMentName }}</h6>
                    </div>
                  </div>
                </td>

                <td class="align-middle text-center">
                  <span class="text-secondary text-xs font-weight-bold">{{
                    markApt.roadName
                  }}</span>
                </td>

                <td class="align-middle text-center">
                  <RouterLink
                    :to="{
                      name: 'DealDetail',
                      params: { aptCode: markApt.aptCode, floor: 1 },
                    }"
                  >
                    <span class="text-dark text-xs font-weight-bold">
                      <i
                        class="fas fa-search"
                        style="font-size: 20px"
                      ></i> </span
                  ></RouterLink>
                </td>

                <td class="align-middle text-center">
                  <span class="text-dark text-xs font-weight-bold">
                    <i
                      class="fas fa-map-marker-alt"
                      style="font-size: 24px"
                      @click="showRocation(markApt.lng, markApt.lat)"
                    ></i>
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
import { useStore } from 'vuex';

import { selectAllMarkApart } from '../../api/aptDeal';
import { computed, ref, watch } from 'vue';

const store = useStore();

const user = computed(() => store.state.user);

const markAptList = ref([]);

const emits = defineEmits(['clickRocation']);

watch(
  () => user.value,
  (newValue) => {
    if (newValue) {
      console.log('User value changed:', newValue);
      selectAllMarkApart(
        newValue.id,
        (response) => {
          markAptList.value = response.data;
          console.log('찜한 아파트 불러오기');
          console.log(markAptList.value);
        },
        (err) => {
          console.log(err);
        },
      );
    } else {
      markAptList.value = [];
    }
  },
  { immediate: true },
);

function showRocation(lng, lat) {
  const params = {
    lng: lng,
    lat: lat,
  };
  emits('clickRocation', params);
}
</script>

<style scoped>
.scrollable-table {
  overflow-x: auto;
}
.scrollable-content {
  min-height: 300px; /* 내용이 표시될 최대 높이 */
  max-height: 150px; /* 내용이 표시될 최대 높이 */
  overflow-y: auto; /* 세로 스크롤 추가 */
}
</style>
