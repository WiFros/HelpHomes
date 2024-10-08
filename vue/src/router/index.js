import { createRouter, createWebHistory } from "vue-router";
import Dashboard from "../views/Dashboard.vue";
import Qna from "../views/Qna.vue";
import QnaInsert from "../views/QnaInsert.vue";
import Billing from "../views/Billing.vue";
import VirtualReality from "../views/VirtualReality.vue";
import RTL from "../views/Rtl.vue";
import Profile from "../views/Profile.vue";
import Signup from "../views/Signup.vue";
import Signin from "../views/Signin.vue";
import DealService from "../views/DealService.vue";

// qna detail
import QnaDetail from "../views/QnaDetail.vue";
// deal detail
import DealDetail from "../views/DealDetail.vue";

const routes = [
  {
    path: "/",
    name: "/",
    redirect: "/dashboard-default",
  },
  {
    path: "/dashboard-default",
    name: "Dashboard",
    component: Dashboard,
    meta: { requiresAuth: true },
  },
  {
    path: "/dealService",
    name: "DealService",
    component: DealService,
    meta: { requiresAuth: true },
  },
  {
    path: "/qna",
    name: "Qna",
    component: Qna,
    meta: { requiresAuth: true },
  },
  {
    path: "/qna/insert",
    name: "insert",
    component: QnaInsert,
    meta: { requiresAuth: true },
  },
  {
    path: "/billing",
    name: "Billing",
    component: Billing,
    meta: { requiresAuth: true },
  },
  {
    path: "/virtual-reality",
    name: "Virtual Reality",
    component: VirtualReality,
    meta: { requiresAuth: true },
  },
  {
    path: "/rtl-page",
    name: "RTL",
    component: RTL,
    meta: { requiresAuth: true },
  },
  {
    path: "/profile",
    name: "Profile",
    component: Profile,
    meta: { requiresAuth: true },
  },
  {
    path: "/signin",
    name: "Signin",
    component: Signin,
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup,
  },
  {
    path: "/qnaDetail/:num",
    name: "QnaDetail",
    component: QnaDetail,
    meta: { requiresAuth: true },
  },
  {
    path: "/dealDetail/:aptCode/:floor",
    name: "DealDetail",
    component: DealDetail,
    meta: { requiresAuth: true },
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
  linkActiveClass: "active",
});

export default router;
