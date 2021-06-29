import Vue from "vue";
import VueRouter from "vue-router";
import PostTable from "../components/PostTable.vue";
import PostDetail from "../components/PostDetail.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "PostTable",
    component: PostTable,
  },
  {
    path: "/post/:id",
    name: "PostDetail",
    component: PostDetail,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
