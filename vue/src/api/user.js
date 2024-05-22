import axios from "@/utils/axios.common.js";
import store from "@/store";

function login(user, success, fail) {
    axios
    .post(`/api/auth/login`, user)
    .then(response => {
      const token = response.data;
      store.dispatch('login', { token })
        .then(() => store.dispatch('fetchUser', token))
        .then(() => success(response))
        .catch(fail);
    })
    .catch(fail);
}

function signup(user, success, fail) {
    axios
    .post(`/api/auth/signup`, user)
    .then(response => success(response))
    .catch(fail);
}

function fetchUser(token, success, fail) {
    axios
    .post('/api/auth/me', {}, {
      headers: {
        Authorization: `Bearer ${token}`
      }
    })
    .then(response => {
      store.commit('setUser', response.data);
      success(response.data);
    })
    .catch(fail);
}

export { login, signup, fetchUser };
