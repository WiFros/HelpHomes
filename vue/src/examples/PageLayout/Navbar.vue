<script setup>
defineProps({
  btnBackground: {
    type: String,
    default: "",
  },
  isBlur: {
    type: String,
    default: "",
  },
  darkMode: {
    type: Boolean,
    default: false,
  },
  isBtn: { type: String, default: "bg-gradient-light" },
});
</script>
<template>
  <!-- Navbar -->
  <nav
    :class="isBlur ? isBlur : 'shadow-none my-2 navbar-transparent w-100'"
    class="navbar navbar-expand-lg top-0 z-index-3 position-absolute mt-4"
  >
    <div class="container ps-2 pe-0">
      <router-link
        :class="darkMode ? 'text-black' : 'text-white'"
        class="navbar-brand font-weight-bolder ms-lg-0 ms-3"
        to="/"
        >HelpHomes!</router-link
      >
      <button
        aria-controls="navigation"
        aria-expanded="false"
        aria-label="Toggle navigation"
        class="shadow-none navbar-toggler ms-2"
        data-bs-target="#navigation"
        data-bs-toggle="collapse"
        type="button"
      >
        <span class="mt-2 navbar-toggler-icon">
          <span class="navbar-toggler-bar bar1"></span>
          <span class="navbar-toggler-bar bar2"></span>
          <span class="navbar-toggler-bar bar3"></span>
        </span>
      </button>
      <div id="navigation" class="collapse navbar-collapse">
        <ul class="navbar-nav mx-auto">
          <li class="nav-item">
            <router-link
              aria-current="page"
              class="nav-link d-flex align-items-center me-2 active"
              to="/dashboard-default"
            >
              <i
                :class="isBlur ? 'text-dark' : 'text-white'"
                aria-hidden="true"
                class="fa fa-chart-pie opacity-6 me-1"
              ></i>
              대시보드
            </router-link>
          </li>
          <!--          <li class="nav-item">-->
          <!--            <router-link class="nav-link me-2" to="/signin">-->
          <!--              <i-->
          <!--                :class="isBlur ? 'text-dark' : 'text-white'"-->
          <!--                aria-hidden="true"-->
          <!--                class="fa fa-user opacity-6 me-1"-->
          <!--              ></i>-->
          <!--              로그인-->
          <!--            </router-link>-->
          <!--          </li>-->
          <li class="nav-item">
            <router-link class="nav-link me-2" to="/signup">
              <i
                :class="isBlur ? 'text-dark' : 'text-white'"
                aria-hidden="true"
                class="fas fa-user-circle opacity-6 me-1"
              ></i>
              회원가입
            </router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link me-2" to="/signin">
              <i
                :class="isBlur ? 'text-dark' : 'text-white'"
                aria-hidden="true"
                class="fas fa-key opacity-6 me-1"
              ></i>
              로그인
            </router-link>
          </li>
        </ul>
        <ul class="navbar-nav d-lg-block d-none">
          <!-- <li class="nav-item">
            <a
              href="https://www.creative-tim.com/product/vue-argon-dashboard"
              class="btn btn-sm mb-0 me-1"
              :class="isBtn"
              >Free download</a
            >
          </li> -->
        </ul>
      </div>
    </div>
  </nav>
  <!-- End Navbar -->
</template>
