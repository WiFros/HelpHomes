<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";

import ArgonInput from "@/components/ArgonInput.vue";
import ArgonSwitch from "@/components/ArgonSwitch.vue";
import ArgonButton from "@/components/ArgonButton.vue";

// login 용 import
import { login } from "@/api/user.js";
import toast from "bootstrap/js/src/toast";
const router = useRouter();
const email = ref("");
const password = ref("");

function loginProcess() {
  const login_user = {
    email: email.value,
    password: password.value,
  };

  console.log("Login attempt with:", login_user);

  login(
    login_user,
    (response) => {
      console.log(response.data);
      router.push("/dashboard-default");
    },
    (error) => {
      toast.error("로그인 실패");
      console.error("Login error:", error);
    },
  );
}
// login 용 코드
</script>
<template>
  <div class="card">
    <div class="card-header text-start">
      <h4 class="font-weight-bolder">로그인</h4>
      <p class="mb-0">이메일과 비밀번호를 입력하세요</p>
    </div>
    <div class="card-body">
      <div class="mb-3">
        <argon-input
          id="email"
          v-model="email"
          name="email"
          placeholder="email"
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
          @click="loginProcess()"
          >로그인</argon-button
        >
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
</template>
