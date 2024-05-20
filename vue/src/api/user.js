import axios from "@/utils/axios.common.js";

function login(user, success, fail) {
    console.log("login:", user);  // 로그인 시도 로그 출력

    axios
        .post(`/api/auth/login`, user)
        .then(response => {
            console.log("Login response data:", response.data);  // 로그인 응답 데이터 로그 출력
            success(response);
        })
        .catch(fail);
}

export { login };
