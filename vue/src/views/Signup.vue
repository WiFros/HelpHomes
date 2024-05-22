<script setup>
import { ref, onBeforeUnmount, onBeforeMount } from "vue";
import { useStore } from "vuex";

import Navbar from "@/examples/PageLayout/Navbar.vue";
import AppFooter from "@/examples/PageLayout/Footer.vue";
import ArgonInput from "@/components/ArgonInput.vue";
//import ArgonCheckbox from "@/components/ArgonCheckbox.vue";
import ArgonButton from "@/components/ArgonButton.vue";
const body = document.getElementsByTagName("body")[0];

const store = useStore();
onBeforeMount(() => {
  store.state.hideConfigButton = true;
  store.state.showNavbar = false;
  store.state.showSidenav = false;
  store.state.showFooter = false;
  body.classList.remove("bg-gray-100");
});
onBeforeUnmount(() => {
  store.state.hideConfigButton = false;
  store.state.showNavbar = true;
  store.state.showSidenav = true;
  store.state.showFooter = true;
  body.classList.add("bg-gray-100");
});

const name = ref("");
const email = ref("");
const password = ref("");
const address = ref("");
const phoneNumber = ref("");

function handleAddressClick() {
  new daum.Postcode({
    oncomplete: function(data) {
      address.value = data.address;
    }
  }).open();
}
function register() {
  // 회원가입 로직 구현
  console.log({
    name: name.value,
    email: email.value,
    password: password.value,
    address: address.value,
    phoneNumber: phoneNumber.value
  });
}

</script>
<template>
  <div class="container top-0 position-sticky z-index-sticky">
    <div class="row">
      <div class="col-12">
        <navbar isBtn="bg-gradient-light" />
      </div>
    </div>
  </div>
  <main class="main-content mt-0">
    <div
      class="page-header align-items-start min-vh-50 pt-5 pb-11 m-3 border-radius-lg"
      style="
        background-image: url(&quot;https://raw.githubusercontent.com/creativetimofficial/public-assets/master/argon-dashboard-pro/assets/img/signup-cover.jpg&quot;);
        background-position: top;
      "
    >
      <span class="mask bg-gradient-dark opacity-6"></span>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-5 text-center mx-auto">
            <h1 class="text-white mb-2 mt-5">안녕하세요!</h1>
            <p class="text-lead text-white">
              도와줘 홈즈에 오신 것을 환영합니다. 
            </p>
          </div>
        </div>
      </div>
    </div>
    <div class="container">
      <div class="row mt-lg-n10 mt-md-n11 mt-n10 justify-content-center">
        <div class="col-xl-4 col-lg-5 col-md-7 mx-auto">
          <div class="card z-index-0">
            <div class="card-header text-center pt-4">
              <h5>회원가입</h5>
            </div>
            <div class="card-body">
              <form role="form">
                <argon-input
                  id="name"
                  type="text"
                  placeholder="이름"
                  aria-label="Name"
                />
                <argon-input
                  id="email"
                  type="email"
                  placeholder="이메일"
                  aria-label="Email"
                />
                <argon-input
                  id="password"
                  type="password"
                  placeholder="비밀번호"
                  aria-label="Password"
                />
                <argon-input
                  v-model="address"
                  type="text"
                  placeholder="주소"
                  aria-label="Address"
                  @focus="handleAddressClick"
                />
                <argon-input
                  v-model="phoneNumber"
                  type="text"
                  placeholder="번호"
                  aria-label="PhoneNumber"
                />
                <div class="text-center">
                  <argon-button
                    fullWidth
                    color="dark"
                    variant="gradient"
                    class="my-4 mb-2"
                    @click="register"
                    >가입</argon-button
                  >
                </div>
                <p class="text-sm mt-3 mb-0">
                  이미 계정이 있으신가요?
                  <a href="javascript:;" class="text-dark font-weight-bolder"
                    >로그인</a
                  >
                </p>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
  <app-footer />
</template>
