<script setup>
import MiniDealSearchBar from './components/MiniDealSearchBar.vue';
import MiniQnABoard from './components/MiniQnABoard.vue';
import MarkDealList from './components/MarkDealList.vue';
import MiniLogin from './components/MiniLogin.vue';
import ProfileCard from './components/ProfileCard.vue';
import MiniMap from './components/MiniMap.vue';
import { useStore } from 'vuex';
import { ref } from 'vue';

import MiniNoticeCard from '@/examples/Cards/MiniNoticeCard.vue';

const e1 = ref('현재 매물 등록기능에 오류발생...');
const e2 = ref('전세사기 피해에 유의 바랍니다...');
const n = ref('내 지역 아파트 검색 기능이 추가...');

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
        <div class="mb-3">
          <MiniLogin v-if="!store.getters.isAuthenticated" />
          <ProfileCard v-else />
        </div>

        <MiniNoticeCard
          title="[ 공지사항 ]"
          :value="e1"
          issueColor="text-danger"
          emergencyType="<긴급>"
          :icon="{
            component: 'fas fa-exclamation-triangle',
            background: 'bg-gradient-danger',
            shape: 'rounded-circle',
          }"
        />

        <MiniNoticeCard
          title="[ 공지사항 ]"
          :value="e2"
          issueColor="text-danger"
          emergencyType="<긴급>"
          :icon="{
            component: 'fas fa-exclamation-triangle',
            background: 'bg-gradient-danger',
            shape: 'rounded-circle',
          }"
        />

        <MiniNoticeCard
          title="[ 공지사항 ]"
          :value="n"
          issueColor="text-success"
          emergencyType="<알림>"
          :icon="{
            component: 'fas fa-bullhorn',
            background: 'bg-gradient-success',
            shape: 'rounded-circle',
          }"
        />
      </div>
      <div class="col-lg-4 mb-lg">
        <MarkDealList @clickRocation="showRocation" />
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
