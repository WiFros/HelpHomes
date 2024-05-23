import { createStore } from "vuex";
import axios from 'axios';
import { signup } from '@/api/user';

export default createStore({
  state: {
    hideConfigButton: false,
    isPinned: false,
    showConfig: false,
    sidebarType: "bg-white",
    isRTL: false,
    mcolor: "",
    darkMode: false,
    isNavFixed: true,
    isAbsolute: false,
    showNavs: true,
    showSidenav: true,
    showNavbar: true,
    showFooter: true,
    showMain: true,
    layout: "default",
    token: localStorage.getItem('token') || '', // 추가된 상태
    user: JSON.parse(localStorage.getItem('user')) || null, // 추가된 상태
  },
  mutations: {
    toggleConfigurator(state) {
      state.showConfig = !state.showConfig;
    },
    sidebarMinimize(state) {
      let sidenav_show = document.querySelector("#app");
      if (state.isPinned) {
        sidenav_show.classList.add("g-sidenav-hidden");
        sidenav_show.classList.remove("g-sidenav-pinned");
        state.isPinned = false;
      } else {
        sidenav_show.classList.add("g-sidenav-pinned");
        sidenav_show.classList.remove("g-sidenav-hidden");
        state.isPinned = true;
      }
    },
    sidebarType(state, payload) {
      state.sidebarType = payload;
    },
    navbarFixed(state) {
      state.isNavFixed = !state.isNavFixed;
    },
    setToken(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
    },
    clearToken(state) {
      state.token = '';
      localStorage.removeItem('token');
    },
    setUser(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    clearUser(state) {
      state.user = null;
      localStorage.removeItem('user');
    }
  },
  actions: {
    toggleSidebarColor({ commit }, payload) {
      commit("sidebarType", payload);
    },
    login({ commit }, { token }) {
      commit('setToken', token);
      return Promise.resolve();
    },
    logout({ commit }) {
      commit('clearToken');
      commit('clearUser');
    },
    fetchUser({ commit }, token) {
      return axios.post('/api/auth/me', {}, {
        headers: {
          Authorization: `Bearer ${token}`
        }
      }).then(response => {
        commit('setUser', response.data);
        return response.data;
      });
    },
    // eslint-disable-next-line no-unused-vars
    signup({ commit }, signupData) {
      return new Promise((resolve, reject) => {
        signup(signupData, response => {
          console.log('회원가입 성공:', response);
          resolve(response);
        }, error => {
          console.error('회원가입 실패:', error.response.data);
          reject(error);
        });
      });
    }
  },
  getters: {
    isAuthenticated: state => !!state.token,
    getUser: state => state.user
  }
});
