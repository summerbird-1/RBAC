import Vue from 'vue'
import VueRouter from 'vue-router'

/* Layout */
import Layout from '@/layout'
// 防止连续点击多次路由报错
let routerPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(err => err)
}

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: Layout, // 修改为 Layout 组件
    children: [
      {
        path: '',
        component: () => import( '../views/HomeView.vue'),
        name: 'home'
      },
    {
      path: '/user-management',
        component: () => import( '../views/User.vue'),
    },
    {
      path: '/role-management',
        component: () => import( '../views/Role.vue'),
    },
    {
      path: '/menu-management',
        component: () => import( '../views/Menu.vue'),
    }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/Login.vue')
}
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
