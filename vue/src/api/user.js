import axios from "@/utils/axios.common.js";

function login(user, success, fail) {
    console.log("login:", user);
    axios
        .post(`/users/login`, user)
        .then(success)
        .catch(fail);
}

export { login };