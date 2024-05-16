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



onMounted(() => {
  searchByAptCode(param,
    (response) => {
      console.log(response.data);
      console.log(response.data.length+"개의 해당매물 거래 정보를 불러왔습니다.");
      console.log(response.data);
      aptDealList.value = response.data;

      const newGraphX = [];
      const newGraphY = [];
      for (let i = 0; i < aptDealList.value.length; i++){

        const dealDate = aptDealList.value[i].dealYear+'.' + aptDealList.value[i].dealMonth + '.' + aptDealList.value[i].dealDay;
        newGraphX.push(dealDate );
        
        const dealAmount = aptDealList.value[i].dealAmount.replace(',', ''); // 콤마 제거
        const amount = parseInt(dealAmount); // 정수형으로 변환
        newGraphY.push(amount);


        
       }

       amountGraphX.value = newGraphX;
       amountGraphY.value = newGraphY;
    },
    (error) => {
      console.error(error);
    }
  );
});

</script>
<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-lg-12">
        <div class="row">
          <div class="col-lg-3 col-md-6 col-12">
            <mini-statistics-card
              title="매물 평균가"
              value="53,000만원"
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
              value="2,300"
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
              title="최고가"
              value="+3,462"
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
              title="최저가"
              value="$103,430"
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
