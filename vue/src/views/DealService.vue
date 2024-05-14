<script setup>
import DealList from "./components/DealList.vue";
import DealSearchBar from "./components/DealSearchBar.vue";
// import Carousel from "./components/Carousel.vue";
import Map from "./components/Map.vue";

</script>
<template>

  <div class="py-4 container-fluid">
    
  <DealSearchBar/>
    <div class="row">
      <div class="col-lg-12 py-3">
        <div class="row">
          <div class="col-lg-3 mb-lg ">
            <!-- line chart -->
           <DealList/>  
          </div>
          <div class="col-lg-9 map">
            <!-- <carousel /> -->
            <div class="card">
              <Map />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
