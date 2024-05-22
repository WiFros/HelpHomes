<script setup>
import MiniDealSearchBar from "./components/MiniDealSearchBar.vue";
import MiniQnABoard from "./components/MiniQnABoard.vue";
import MarkDealList from "./components/MarkDealList.vue";
import MiniLogin from "./components/MiniLogin.vue";
import ProfileCard from "./components/ProfileCard.vue";
import Map from "./components/Map.vue";
import { useStore } from 'vuex';

const store = useStore();
</script>

<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-lg-3 mb-lg">
        <MiniLogin v-if="!store.getters.isAuthenticated" />
        <ProfileCard v-else />
      </div>
      <div class="col-lg-4 mb-lg">
        <MarkDealList />
        <div class="py-2">
          <MiniQnABoard />
        </div>
      </div>
      <div class="col-lg-5 map">
        <div class="col">
          <MiniDealSearchBar />
          <div class="py-3">
            <Map :aptMarkerList="[]" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
