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
function updateUser(user, success, fail) {
  axios
      .put('/api/auth/update', user)
      .then(response => {
          const updatedUser = response.data.user;
          const newToken = response.data.token;
          store.commit('setUser', updatedUser);
          store.commit('setToken', newToken);
          success(response);
      })
      .catch(fail);
}
export { login, signup, fetchUser, updateUser};
