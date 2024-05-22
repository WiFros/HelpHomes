<template>
  <div class="container top-0 position-sticky z-index-sticky">
    <div class="row">
      <div class="col-12">
        <navbar
          isBlur="blur  border-radius-lg my-3 py-2 start-0 end-0 mx-4 shadow"
          v-bind:darkMode="true"
          isBtn="bg-gradient-success"
        />
      </div>
    </div>
  </div>
  <main class="mt-0 main-content">
    <section>
      <div class="page-header min-vh-100">
        <div class="container">
          <div class="row">
            <div class="mx-auto col-xl-4 col-lg-5 col-md-7 d-flex flex-column mx-lg-0">
              <div class="card card-plain">
                <div class="pb-0 card-header text-start">
                  <h4 class="font-weight-bolder">로그인</h4>
                  <p class="mb-0">이메일과 비밀번호를 입력하세요</p>
                </div>
                <div class="card-body">
                  <div class="mb-3">
                    <argon-input
                      id="email"
                      type="email"
                      placeholder="Email"
                      name="email"
                      size="lg"
                      v-model="email"
                    />
                  </div>
                  <div class="mb-3">
                    <argon-input
                      id="password"
                      type="password"
                      placeholder="Password"
                      name="password"
                      size="lg"
                      v-model="password"
                    />
                  </div>
                  <argon-switch id="rememberMe" name="remember-me">이메일 저장</argon-switch>
                  <div class="text-center">
                    <argon-button
                      class="mt-4"
                      variant="gradient"
                      color="success"
                      fullWidth
                      size="lg"
                      @click="loginProcess"
                    >
                      로그인
                    </argon-button>
                  </div>
                </div>
                <div class="px-1 pt-0 text-center card-footer px-lg-2">
                  <p class="mx-auto mb-4 text-sm">
                    계정이 없으신가요?
                    <router-link to="/signup" class="text-success text-gradient font-weight-bold">회원가입</router-link>
                  </p>
                </div>
              </div>
            </div>
            <div
              class="top-0 my-auto text-center col-6 d-lg-flex d-none h-100 pe-0 position-absolute end-0 justify-content-center flex-column"
            >
              <div
                class="position-relative bg-gradient-primary h-100 m-3 px-7 border-radius-lg d-flex flex-column justify-content-center overflow-hidden"
                style="
                  background-image: url(&quot;https://raw.githubusercontent.com/creativetimofficial/public-assets/master/argon-dashboard-pro/assets/img/signin-ill.jpg&quot;);
                  background-size: cover;
                "
              >
                <span class="mask bg-gradient-success opacity-6"></span>
                <h4 class="mt-5 text-white font-weight-bolder position-relative">
                  도와줘 홈즈
                </h4>
                <p class="text-white position-relative">
                  새로운 집을 찾거나 내 집을 팔고 싶다면 도와줘 홈즈를 통해 부동산 자산을 관리 할 수 있습니다.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </main>
</template>

<script setup>
import { ref, onBeforeMount, onBeforeUnmount } from "vue";
import { useStore } from "vuex";
import { useRouter } from "vue-router";
import Navbar from "@/examples/PageLayout/Navbar.vue";
import ArgonInput from "@/components/ArgonInput.vue";
import ArgonSwitch from "@/components/ArgonSwitch.vue";
import ArgonButton from "@/components/ArgonButton.vue";

// login 용 import
import { login } from "../api/user.js";

const email = ref("");
const password = ref("");

const store = useStore();
const router = useRouter();

function loginProcess() {
  const login_user = {
    email: email.value,
    password: password.value
  };
  console.log('Login attempt with:', login_user);  // 로그인 시도 로그 출력

  login(
    login_user,
    response => {
      console.log('Login response:', response.data);  // 로그인 응답 로그 출력
      
      const token = response.data;
      if (token) {
        console.log('Token stored in localStorage:', token);  // 저장된 토큰 로그 출력

        store.dispatch('login', { token }).then(() => {
          return store.dispatch('fetchUser', token);
        }).then(() => {
          router.push('/dashboard-default');  // 로그인 후 이동
        }).catch(error => {
          console.error('Error fetching user:', error);
          alert('사용자 정보를 가져오는 데 실패했습니다.');
        });
      } else {
        console.error('Invalid token received from server');
        alert('Invalid token received from server');  // 토큰이 없는 경우 에러 로그 alert 로 출력
      }
    },
    error => {
      alert('로그인 실패');  // 로그인 실패 alert 출력
      console.error('Login error:', error);  // 로그인 에러 로그 출력
    }
  );
}







const body = document.getElementsByTagName("body")[0];

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
</script>
