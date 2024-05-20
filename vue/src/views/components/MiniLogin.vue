<script setup>
import {ref } from "vue";
import ArgonInput from "@/components/ArgonInput.vue";
import ArgonSwitch from "@/components/ArgonSwitch.vue";
import ArgonButton from "@/components/ArgonButton.vue";

// login 용 import
import {login} from "@/api/user.js";

const email = ref("");
const password = ref("");

function loginProcess(){
  const login_user = {
    email : email.value,
    password : password.value
  }
  login(login_user,response=>{
    console.log(response.data);
  },error=>{
    console.log(error);
  })
}
// login 용 코드


</script>
<template>
              <div class="card">
                <div class=" card-header text-start">
                  <h4 class="font-weight-bolder">Sign In</h4>
                  <p class="mb-0">Enter your email and password to sign in</p>
                </div>
                <div class="card-body">
                    <div class="mb-3">
                      <argon-input
                        id="email"
                        type="email"
                        placeholder="email"
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
                    <argon-switch id="rememberMe" name="remember-me"
                      >Remember me</argon-switch
                    >

                    <div class="text-center">
                      <argon-button
                        class="mt-4"
                        variant="gradient"
                        color="success"
                        fullWidth
                        size="lg"
                        @click="loginProcess()"
                        >Sign in</argon-button
                      >
                    </div>
                </div>
                <div class="px-1 pt-0 text-center card-footer px-lg-2">
                  <p class="mx-auto mb-4 text-sm">
                    Don't have an account?
                    <a
                      href="javascript:;"
                      class="text-success text-gradient font-weight-bold"
                      >Sign up</a
                    >
                  </p>
                </div>
              </div>
</template>
