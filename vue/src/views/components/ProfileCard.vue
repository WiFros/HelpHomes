<template>
  <div v-if="user" class="card card-profile">
    <img
      src="../../assets/img/bg-profile.jpg"
      alt="Image placeholder"
      class="card-img-top"
    />
    <div class="row justify-content-center">
      <div class="col-4 col-lg-4 order-lg-2">
        <div class="mt-n4 mt-lg-n6 mb-4 mb-lg-0">
          <a href="javascript:;">
            <img
              src="../../assets/img/team-2.jpg"
              class="rounded-circle img-fluid border border-2 border-white"
            />
          </a>
        </div>
      </div>
    </div>
    <div class="card-header text-center border-0 pt-0 pt-lg-2 pb-4 pb-lg-3">
      <div class="d-flex justify-content-between">
        <a
          href="javascript:;"
          class="btn btn-sm btn-info mb-0 d-none d-lg-block"
          >Connect</a
        >
        <a
          href="javascript:;"
          class="btn btn-sm btn-info mb-0 d-block d-lg-none"
        >
          <i class="ni ni-collection"></i>
        </a>
        <a
          href="javascript:;"
          class="btn btn-sm btn-dark float-right mb-0 d-none d-lg-block"
          >Message</a
        >
        <a
          href="javascript:;"
          class="btn btn-sm btn-dark float-right mb-0 d-block d-lg-none"
        >
          <i class="ni ni-email-83"></i>
        </a>
      </div>
    </div>
    <div class="card-body pt-0">
      <div class="row">
        <div class="col">
          <div class="d-flex justify-content-center">
            <div class="d-grid text-center">
              <span class="text-lg font-weight-bolder">22</span>
              <span class="text-sm opacity-8">Friends</span>
            </div>
            <div class="d-grid text-center mx-4">
              <span class="text-lg font-weight-bolder">10</span>
              <span class="text-sm opacity-8">Photos</span>
            </div>
            <div class="d-grid text-center">
              <span class="text-lg font-weight-bolder">89</span>
              <span class="text-sm opacity-8">Comments</span>
            </div>
          </div>
        </div>
      </div>
      <div class="text-center mt-4">
        <h5>
          {{ user.name }}
          <!-- <span class="font-weight-light">, {{ user.age }}</span> -->
        </h5>
        <div class="h6 font-weight-300">
          <i class="ni location_pin mr-2"></i>{{ user.address }}
        </div>
        <div class="h6 mt-4">
          <i class="ni business_briefcase-24 mr-2"></i>{{ user.phone }}
        </div>
        <argon-button
          class="mt-4"
          variant="gradient"
          color="danger"
          @click="logoutProcess"
        >
          로그아웃
        </argon-button>
      </div>
    </div>
  </div>
  <div v-else>Loading...</div>
</template>

<script setup>
import { computed } from 'vue';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';

const store = useStore();
const router = useRouter();
const user = computed(() => store.getters.getUser);
function logoutProcess() {
  store.dispatch('logout').then(() => {
    router.push('/dashboard-default');
  });
}
</script>
