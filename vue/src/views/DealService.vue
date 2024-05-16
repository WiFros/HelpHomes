<script setup>
import DealList from "./components/DealList.vue";
import DealSearchBar from "./components/DealSearchBar.vue";
// import Carousel from "./components/Carousel.vue";
import Map from "./components/Map.vue";

import { onMounted, ref } from 'vue';
import { searchByDong } from '../api/aptDeal.js';

const aptDealList = ref([]);


onMounted(() => {
  searchByDong(
    (response) => {
      console.log(response.data.length+"개의 아파트 거래 정보를 불러왔습니다.");
      aptDealList.value = response.data;
    },
    (error) => {
      console.error(error);
    }
  );
});

</script>
<template>

  <div class="py-4 container-fluid">
    
  <DealSearchBar/>
    <div class="row">
      <div class="col-lg-12 py-3">
        <div class="row">
          <div class="col-lg-3 mb-lg ">
            <!-- line chart -->
            <DealList :aptDealList="aptDealList"/> <!-- aptDealList를 dealList.vue로 전달합니다. -->
    
          </div>
          <div class="col-lg-9 map">
            <!-- <carousel /> -->
              <Map :aptDealList="aptDealList" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
