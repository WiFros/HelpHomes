<script setup>
import MiniDealSearchBar from "./components/MiniDealSearchBar.vue";
import MiniQnABoard from "./components/MiniQnABoard.vue";
import MarkDealList from "./components/MarkDealList.vue";
import MiniLogin from "./components/MiniLogin.vue";
// import Carousel from "./components/Carousel.vue";
import Map from "./components/Map.vue";

import { ref } from 'vue';

const aptDealList = ref([]);



</script>
<template>

  <div class="py-4 container-fluid">
    
        <div class="row">
          <div class="col-lg-3 mb-lg ">
            <MiniLogin/>
          </div>

          <div class="col-lg-4 mb-lg ">
            <!-- line chart -->
            <MarkDealList/>
          <div class="py-2">
            <MiniQnABoard />
          </div>
          </div>
          <div class="col-lg-5 map">
            <div class="col">
              <MiniDealSearchBar/>
            <!-- <carousel /> -->
          <div class="py-3">
              <Map :aptMarkerList="aptDealList" />
          </div>
            </div>
          </div>
        </div>
  </div>
</template>
