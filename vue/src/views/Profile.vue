<script setup>
import { onBeforeMount, onMounted, onBeforeUnmount, computed } from "vue";
import { useStore } from "vuex";
import { updateUser } from "@/api/user";
import setNavPills from "@/assets/js/nav-pills.js";
import setTooltip from "@/assets/js/tooltip.js";
import ProfileCard from "./components/ProfileCard.vue";
import ArgonInput from "@/components/ArgonInput.vue";
import ArgonButton from "@/components/ArgonButton.vue";
import { openDaumPostcode } from "@/utils/daumPost.js";
import { useToast } from "vue-toastification";
const body = document.getElementsByTagName("body")[0];

const store = useStore();
const user = computed(() => store.getters.getUser);
console.log("User:", user.value);
const toast = useToast();

const updateUserProfile = () => {
  updateUser(
    user.value,
    () => {
      // 성공 시 콜백
      toast.success("업데이트 성공");
    },
    () => {
      // 실패 시 콜백
      toast.error("업데이트 실패");
    },
  );
};

const openAddressSearch = () => {
  openDaumPostcode((data) => {
    user.value.address = data.jibunAddress;
    user.value.dongCode = data.bcode;
    console.log("Address:", user.value.dongCode, data.bcode);
  });
};

onMounted(() => {
  store.state.isAbsolute = true;
  setNavPills();
  setTooltip();
});

onBeforeMount(() => {
  store.state.imageLayout = "profile-overview";
  store.state.showNavbar = false;
  store.state.showFooter = true;
  store.state.hideConfigButton = true;
  body.classList.add("profile-overview");
});

onBeforeUnmount(() => {
  store.state.isAbsolute = false;
  store.state.imageLayout = "default";
  store.state.showNavbar = true;
  store.state.showFooter = true;
  store.state.hideConfigButton = false;
  body.classList.remove("profile-overview");
});
</script>

<template>
  <main>
    <div class="container-fluid">
      <div
        class="page-header min-height-300"
        style="
          background-image: url(&quot;https://images.unsplash.com/photo-1531512073830-ba890ca4eba2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1920&q=80&quot;);
          margin-right: -24px;
          margin-left: -34%;
        "
      >
        <span class="mask bg-gradient-success opacity-6"></span>
      </div>
      <div class="card shadow-lg mt-n6">
        <div class="card-body p-3">
          <div class="row gx-4">
            <div class="col-auto">
              <div class="avatar avatar-xl position-relative">
                <img
                  alt="profile_image"
                  class="shadow-sm w-100 border-radius-lg"
                  src="../assets/img/team-2.jpg"
                />
              </div>
            </div>
            <div class="col-auto my-auto">
              <div class="h-100">
                <h5 class="mb-1">{{ user.name }}</h5>
                <p class="mb-0 font-weight-bold text-sm">일반 사용자</p>
              </div>
            </div>
            <div
              class="mx-auto mt-3 col-lg-4 col-md-6 my-sm-auto ms-sm-auto me-sm-0"
            >
              <div class="nav-wrapper position-relative end-0"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="py-4 container-fluid">
      <div class="row">
        <div class="col-md-8">
          <div class="card">
            <div class="card-header pb-0">
              <div class="d-flex align-items-center">
                <p class="mb-0">프로필 수정</p>
                <argon-button
                  class="ms-auto"
                  color="success"
                  size="sm"
                  @click="updateUserProfile"
                  >저장</argon-button
                >
              </div>
            </div>
            <div class="card-body">
              <p class="text-uppercase text-sm">사용자 정보</p>
              <div class="row">
                <div class="col-md-6">
                  <label class="form-control-label" for="name-input"
                    >이름</label
                  >
                  <input
                    id="name-input"
                    v-model="user.name"
                    class="form-control"
                    type="name"
                  />
                </div>

                <div class="col-md-6">
                  <label class="form-control-label" for="email-input"
                    >이메일</label
                  >
                  <input
                    id="email-input"
                    v-model="user.email"
                    class="form-control"
                    readonly
                    type="email"
                  />
                </div>

                <div class="col-md-6">
                  <label class="form-control-label" for="phone-input"
                    >연락처</label
                  >
                  <argon-input
                    id="phone-input"
                    v-model="user.phone"
                    type="text"
                  />
                </div>
              </div>
              <hr class="horizontal dark" />
              <p class="text-uppercase text-sm">주소 정보</p>
              <div class="row">
                <div class="col-md-12">
                  <label class="form-control-label" for="address-input"
                    >주소</label
                  >
                  <div class="input-group">
                    <input
                      id="address-input"
                      v-model="user.address"
                      class="form-control"
                      readonly
                      type="text"
                      @click="openAddressSearch"
                    />
                  </div>
                </div>
              </div>
              <hr class="horizontal dark" />
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <profile-card />
        </div>
      </div>
    </div>
  </main>
</template>
