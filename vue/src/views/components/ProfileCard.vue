<template>
  <div v-if="user" class="card card-profile">
    <img
      alt="Image placeholder"
      class="card-img-top"
      src="../../assets/img/bg-profile.jpg"
    />
    <div class="row justify-content-center">
      <div class="col-4 col-lg-4 order-lg-2">
        <div class="mt-n4 mt-lg-n6 mb-4 mb-lg-0">
          <a href="javascript:">
            <img
              class="rounded-circle img-fluid border border-2 border-white"
              src="../../assets/img/team-2.jpg"
            />
          </a>
        </div>
      </div>
    </div>
    <div class="card-header text-center border-0 pt-0 pt-lg-2 pb-4 pb-lg-3">
      <div class="d-flex justify-content-between">
        <a
          class="btn btn-sm btn-info mb-0 d-none d-lg-block"
          href="javascript:"
          @click="toProfile"
          >프로필</a
        >
        <a
          class="btn btn-sm btn-info mb-0 d-block d-lg-none"
          href="javascript:"
        >
          <i class="ni ni-collection"></i>
        </a>
        <a
          class="btn btn-sm btn-dark float-right mb-0 d-none d-lg-block"
          href="javascript:"
          @click="logoutProcess"
          >로그아웃</a
        >
        <a
          class="btn btn-sm btn-dark float-right mb-0 d-block d-lg-none"
          href="javascript:"
        >
          <i class="ni ni-email-83"></i>
        </a>
      </div>
    </div>
    <div class="card-body pt-0">
      <div class="row"></div>
      <div class="text-center mt-4">
        <h5>
          {{ user.name }}
          <!-- <span class="font-weight-light">, {{ user.age }}</span> -->
        </h5>
        <div class="h6 font-weight-300">
          <i class="ni location_pin mr-2"></i>{{ user.address }}
        </div>
        <div class="h6 mt-2">
          <i class="ni business_briefcase-24 mr-2"></i>{{ user.phone }}
        </div>
      </div>
    </div>
  </div>
  <div v-else>Loading...</div>
</template>

<script setup>
import { computed } from "vue";
import { useStore } from "vuex";
import { useRouter } from "vue-router";

const store = useStore();
const router = useRouter();
const user = computed(() => store.getters.getUser);
function logoutProcess() {
  store.dispatch("logout").then(() => {
    router.push("/dashboard-default");
  });
}
function toProfile() {
  router.push("/profile");
}
</script>
