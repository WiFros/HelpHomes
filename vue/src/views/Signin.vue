<template>
  <div class="container top-0 position-sticky z-index-sticky">
    <div class="row">
      <div class="col-12">
        <navbar
          isBlur="blur  border-radius-lg my-3 py-2 start-0 end-0 mx-4 shadow"
          isBtn="bg-gradient-success"
          v-bind:darkMode="true"
        />
      </div>
    </div>
  </div>
  <main class="mt-0 main-content">
    <section>
      <div class="page-header min-vh-100">
        <div class="container">
          <div class="row">
            <div
              class="mx-auto col-xl-4 col-lg-5 col-md-7 d-flex flex-column mx-lg-0"
            >
              <div class="card card-plain">
                <div class="pb-0 card-header text-start">
                  <h4 class="font-weight-bolder">로그인</h4>
                  <p class="mb-0">이메일과 비밀번호를 입력하세요</p>
                </div>
                <div class="card-body">
                  <div class="mb-3">
                    <argon-input
                      id="email"
                      v-model="email"
                      name="email"
                      placeholder="Email"
                      size="lg"
                      type="email"
                    />
                  </div>
                  <div class="mb-3">
                    <argon-input
                      id="password"
                      v-model="password"
                      name="password"
                      placeholder="Password"
                      size="lg"
                      type="password"
                    />
                  </div>
                  <argon-switch id="rememberMe" name="remember-me"
                    >이메일 저장</argon-switch
                  >
                  <div class="text-center">
                    <argon-button
                      class="mt-4"
                      color="success"
                      fullWidth
                      size="lg"
                      variant="gradient"
                      @click="loginProcess"
                    >
                      로그인
                    </argon-button>
                  </div>
                </div>
                <div class="px-1 pt-0 text-center card-footer px-lg-2">
                  <p class="mx-auto mb-4 text-sm">
                    계정이 없으신가요?
                    <router-link
                      class="text-success text-gradient font-weight-bold"
                      to="/signup"
                      >회원가입</router-link
                    >
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
                <h4
                  class="mt-5 text-white font-weight-bolder position-relative"
                >
                  Help Homes!
                </h4>
                <p class="text-white position-relative">
                  새로운 집을 찾거나 내 집을 팔고 싶다면 Help Homes 를 통해
                  부동산 자산을 관리 할 수 있습니다.
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
import { useToast } from "vue-toastification";

// login 용 import
import { login } from "../api/user.js";

const email = ref("");
const password = ref("");
const toast = useToast();
const store = useStore();
const router = useRouter();

function loginProcess() {
  const login_user = {
    email: email.value,
    password: password.value,
  };
  console.log("Login attempt with:", login_user); // 로그인 시도 로그 출력

  login(
    login_user,
    (response) => {
      console.log("Login response:", response.data); // 로그인 응답 로그 출력

      const token = response.data;
      if (token) {
        console.log("Token stored in localStorage:", token); // 저장된 토큰 로그 출력

        store
          .dispatch("login", { token })
          .then(() => {
            return store.dispatch("fetchUser", token);
          })
          .then(() => {
            toast.success("로그인 성공");
            router.push("/dashboard-default"); // 로그인 후 이동
          })
          .catch((error) => {
            console.error("Error fetching user:", error);
            toast.error("사용자 정보를 가져오는 중에 오류가 발생했습니다.");
          });
      } else {
        console.error("Invalid token received from server");
        toast.error("서버에서 유효하지 않은 토큰을 받았습니다.");
      }
    },
    (error) => {
      toast.error("로그인 실패"); // 로그인 실패 alert 출력
      console.error("Login error:", error); // 로그인 에러 로그 출력
    },
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
