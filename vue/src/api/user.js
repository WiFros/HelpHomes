import axios from "@/utils/axios.common.js";
import store from "@/store";

function login(user, success, fail) {
    console.log("login:", user);  // 로그인 시도 로그 출력

    axios
    .post(`/api/auth/login`, user)
    .then(response => {
      console.log("Login response data:", response.data);  // 로그인 응답 데이터 로그 출력
      const token = response.data;
      store.dispatch('login', { token })  // Vuex에 토큰 저장
        .then(() => {
          return store.dispatch('fetchUser', token);  // 사용자 정보 가져오기
        })
        .then(() => {
          success(response);
        })
        .catch(fail);
    })
    .catch(fail);
}

export { login };
