<script setup>
// import Carousel from "./components/Carousel.vue";
import MiniStatisticsCard from "@/examples/Cards/MiniStatisticsCard.vue";
import GradientLineChart from "@/examples/Charts/GradientLineChart.vue";
import Map from "./components/Map.vue";
import { onMounted, ref } from 'vue';
import { searchByAptCode } from '../api/aptDeal.js';
import { useRoute } from "vue-router";
const currentRoute = useRoute();
const param = {
  aptCode: ref(currentRoute.params.aptCode),
  floor : ref(currentRoute.params.floor)
}
const aptDealList = ref([]);

const amountGraphX = ref([]);
const amountGraphY = ref([]);

const amountMax = ref(0);
const amountMin = ref(0);
const amountAvg = ref(0);
const dealCount = ref(0);

onMounted(() => {
  searchByAptCode(param,
    (response) => {
      console.log(response.data);
      console.log(response.data.length+"개의 해당매물 거래 정보를 불러왔습니다.");
      console.log(response.data);
      aptDealList.value = response.data;

      const newGraphX = [];
      const newGraphY = [];

      let max = 0;
      let min = 10000000000;

      for (let i = 0; i < aptDealList.value.length; i++){

        // 그래프의 x축인 날짜와 y축인 가격을 저장
        const dealDate = aptDealList.value[i].dealYear+'.' + aptDealList.value[i].dealMonth + '.' + aptDealList.value[i].dealDay;
        newGraphX.push(dealDate );
        
        const dealAmount = aptDealList.value[i].dealAmount.replace(',', ''); // 콤마 제거
        const amount = parseInt(dealAmount); // 정수형으로 변환
        newGraphY.push(amount);

        // 최댓값,최솟값,평균가를 구하기 위한 코드
        max = Math.max(max, amount);
        min = Math.min(min, amount);
        amountAvg.value += amount;
        
       }
       amountAvg.value = amountAvg.value / aptDealList.value.length;
       amountMax.value = max;
       amountMin.value = min;
       dealCount.value = aptDealList.value.length;

      amountToBillion();

       amountGraphX.value = newGraphX;
       amountGraphY.value = newGraphY;
    },
    (error) => {
      console.error(error);
    }
  );
});

function amountToBillion(){
  amountMax.value = amountMax.value / 1000;
  amountMin.value = amountMin.value / 1000;
  amountAvg.value = amountAvg.value / 1000;
}

</script>
<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-lg-12">
        <div class="row">
          <div class="col-lg-3 col-md-6 col-12">
            <mini-statistics-card
              title="매물 평균가"
              :value="amountAvg.toFixed(2) + '억'"
              description="<span
                class='text-sm font-weight-bolder text-success'
                >+55%</span> 전일 대비"
              :icon="{
                component: 'ni ni-money-coins',
                background: 'bg-gradient-primary',
                shape: 'rounded-circle',
              }"
            />
          </div>
          <div class="col-lg-3 col-md-6 col-12">
            <mini-statistics-card
              title="거래량"
              :value="dealCount"
              description="<span
                class='text-sm font-weight-bolder text-success'
                >+3%</span> 전주 대비"
              :icon="{
                component: 'ni ni-world',
                background: 'bg-gradient-danger',
                shape: 'rounded-circle',
              }"
            />
          </div>
          <div class="col-lg-3 col-md-6 col-12">
            <mini-statistics-card
              title="매물 최고가"
              :value="amountMax.toFixed(2) + '억'"
              description="<span
                class='text-sm font-weight-bolder text-danger'
                >-2%</span> 이전 분기 대비"
              :icon="{
                component: 'ni ni-paper-diploma',
                background: 'bg-gradient-success',
                shape: 'rounded-circle',
              }"
            />
          </div>
          <div class="col-lg-3 col-md-6 col-12">
            <mini-statistics-card
              title="매물 최저가"
              :value="amountMin.toFixed(2) + '억'"
              description="<span
                class='text-sm font-weight-bolder text-success'
                >+5%</span> 전월 대비"
              :icon="{
                component: 'ni ni-cart',
                background: 'bg-gradient-warning',
                shape: 'rounded-circle',
              }"
            />
          </div>
        </div>
        <div class="row">
          <div class="col-lg-7 mb-lg">
            <!-- line chart -->
            <div class="card z-index-2">
              <gradient-line-chart
                id="chart-line"
                title="연간 매매가 추이"
                description="<i class='fa fa-arrow-up text-success'></i>
      <span class='font-weight-bold'>4% more</span> in 2021"
                :chart="{
                  labels: amountGraphX,
                  datasets: [
                    {
                      label: 'Mobile Apps',
                      data: amountGraphY,
                    },
                  ],
                }"
              />
            </div>
          </div>
          <div class="col-lg-5">
            <!-- <carousel /> -->
            <div class="card">
              <Map :aptMarkerList="aptDealList" />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
