<template>
  <div class="card">
    <div class="card-header pb-0">
      <h6>관심 매물</h6>
    </div>


    <div class="card-body px-0 pt-0 pb-2 ">
      <div class="table-responsive p-0">
        
        <div class = "scrollable-table">
        <table class="table align-items-center mb-0">
          <thead>
          </thead>
          </table>
        </div>

          <!-- Table Body -->
        <div class = "scrollable-content">
        <table class=" table align-items-center mb-0">
          <tbody>
            <tr v-for="aptDeal in aptDealList" :key="aptDeal.aptCode">
              <td>
                <div class="d-flex px-2 py-1">
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
import { defineProps } from 'vue';

defineProps({
  aptDealList: Array
})



</script>


<style scoped>
.scrollable-table {
  overflow-x: auto;
}
.scrollable-content {
  min-height: 260px; /* 내용이 표시될 최대 높이 */
  max-height: 150px; /* 내용이 표시될 최대 높이 */
  overflow-y: auto; /* 세로 스크롤 추가 */
}
</style>