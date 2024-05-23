<script setup>
import MiniDealSearchBar from './components/MiniDealSearchBar.vue';
import MiniQnABoard from './components/MiniQnABoard.vue';
import MarkDealList from './components/MarkDealList.vue';
import MiniLogin from './components/MiniLogin.vue';
import ProfileCard from './components/ProfileCard.vue';
import MiniMap from './components/MiniMap.vue';
import { useStore } from 'vuex';
import { ref } from 'vue';

const store = useStore();
const markerList = ref([]);

function showRocation(params) {
  markerList.value = [params];
}

</script>

<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-lg-3 mb-lg">
        <MiniLogin v-if="!store.getters.isAuthenticated" />
        <ProfileCard v-else />
      </div>
      <div class="col-lg-4 mb-lg">
        <MarkDealList  @clickRocation="showRocation"/>
        <div class="py-2">
          <MiniQnABoard />
        </div>
      </div>
      <div class="col-lg-5 map">
        <div class="col">
          <MiniDealSearchBar />
          <div class="py-3">
            <MiniMap :aptMarkerList="markerList" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
