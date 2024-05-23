<template>
  <div
    id="sidenav-collapse-main"
    class="collapse navbar-collapse w-auto h-auto h-100"
  >
    <ul class="navbar-nav">
      <li class="nav-item">
        <sidenav-item
          :class="getRoute() === 'dashboard-default' ? 'active' : ''"
          :navText="isRTL ? 'لوحة القيادة' : '대시보드'"
          to="/dashboard-default"
        >
          <template v-slot:icon>
            <i class="ni ni-tv-2 text-primary text-sm opacity-10"></i>
          </template>
        </sidenav-item>
      </li>

      <li class="nav-item">
        <sidenav-item
          :class="getRoute() === 'dealService' ? 'active' : ''"
          :navText="isRTL ? 'اشتراك' : '매물찾기'"
          to="/dealService"
        >
          <template v-slot:icon>
            <i class="ni ni-collection text-info text-sm opacity-10"></i>
          </template>
        </sidenav-item>
      </li>

      <li class="nav-item">
        <sidenav-item
          :class="getRoute() === 'qna' ? 'active' : ''"
          :navText="isRTL ? 'الجداول' : 'QnA 게시판'"
          to="/qna"
        >
          <template v-slot:icon>
            <i
              class="ni ni-calendar-grid-58 text-warning text-sm opacity-10"
            ></i>
          </template>
        </sidenav-item>
      </li>

      <!--      &lt;!&ndash; 매물등록 메뉴: 로그인 필요 &ndash;&gt;-->
      <!--      <li v-if="isAuthenticated" class="nav-item">-->
      <!--        <sidenav-item-->
      <!--            to="/billing"-->
      <!--            :class="getRoute() === 'billing' ? 'active' : ''"-->
      <!--            :navText="isRTL ? 'الفواتیر' : '매물등록'"-->
      <!--        >-->
      <!--          <template v-slot:icon>-->
      <!--            <i class="ni ni-credit-card text-success text-sm opacity-10"></i>-->
      <!--          </template>-->
      <!--        </sidenav-item>-->
      <!--      </li>-->

      <li class="mt-3 nav-item">
        <h6
          v-if="isRTL"
          :class="isRTL ? 'me-4' : 'ms-2'"
          class="text-xs ps-4 text-uppercase font-weight-bolder opacity-6"
        >
          صفحات المرافق
        </h6>

        <h6
          v-else
          :class="isRTL ? 'me-4' : 'ms-2'"
          class="text-xs ps-4 text-uppercase font-weight-bolder opacity-6"
        >
          내 계정
        </h6>
      </li>

      <!-- 프로필 메뉴: 로그인 필요 -->
      <li v-if="isAuthenticated" class="nav-item">
        <sidenav-item
          :class="getRoute() === 'profile' ? 'active' : ''"
          :navText="isRTL ? 'حساب تعريفي' : '프로필'"
          to="/profile"
        >
          <template v-slot:icon>
            <i class="ni ni-single-02 text-dark text-sm opacity-10"></i>
          </template>
        </sidenav-item>
      </li>

      <!-- 로그인/회원가입 메뉴: 비로그인 상태에서만 보임 -->
      <li v-else class="nav-item">
        <sidenav-item
          :class="getRoute() === 'signin' ? 'active' : ''"
          :navText="isRTL ? 'تسجيل الدخول' : '로그인'"
          to="/signin"
        >
          <template v-slot:icon>
            <i class="ni ni-single-copy-04 text-danger text-sm opacity-10"></i>
          </template>
        </sidenav-item>
      </li>

      <li v-if="!isAuthenticated" class="nav-item">
        <sidenav-item
          :class="getRoute() === 'signup' ? 'active' : ''"
          :navText="isRTL ? 'اشتراك' : '회원가입'"
          to="/signup"
        >
          <template v-slot:icon>
            <i class="ni ni-collection text-info text-sm opacity-10"></i>
          </template>
        </sidenav-item>
      </li>
    </ul>
  </div>

  <div class="pt-3 mx-3 mt-3 sidenav-footer">
    <sidenav-card
      :card="{
        title: 'Need Help?',
        description: 'Please check our docs',
        links: [
          {
            label: 'Documentation',
            route:
              'https://www.creative-tim.com/learning-lab/vue/overview/argon-dashboard/',
            color: 'dark',
          },
          {
            label: 'Buy now',
            route:
              'https://www.creative-tim.com/product/vue-argon-dashboard-pro?ref=vadp',
            color: 'success',
          },
        ],
      }"
    />
  </div>
</template>

<script setup>
import { computed } from "vue";
import { useRoute } from "vue-router";
import { useStore } from "vuex";

import SidenavItem from "./SidenavItem.vue";
import SidenavCard from "./SidenavCard.vue";

const store = useStore();
const isRTL = computed(() => store.state.isRTL);
const isAuthenticated = computed(() => store.getters.isAuthenticated);

const getRoute = () => {
  const route = useRoute();
  const routeArr = route.path.split("/");
  return routeArr[1];
};
</script>

<style scoped>
/* 스타일 정의 */
</style>
