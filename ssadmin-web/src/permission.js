import router from './router'
//import jwt from 'jsonwebtoken'
import { getAccessToken } from '@/utils/auth'
// 解析Token（假设Token是一个JWT）
// function getTokenExpirationDate(token) {
//   const decoded = jwt.verify(token); // 请确保你引入了合适的JWT库
//   if (decoded.exp === undefined) {
//     return null;
//   }
//   return new Date(decoded.exp * 1000); // JWT中exp表示秒，将其转换为毫秒
// }
router.beforeEach((to, from, next) => {
  // 获取当前时间戳
  const currentTime = Date.now();
  if (getAccessToken()) { // 如果有token
    // 获取Token的过期时间
   // const tokenExpirationDate = getTokenExpirationDate(getAccessToken());
    //if (tokenExpirationDate && currentTime <= tokenExpirationDate) {
      if (to.path === '/login') {
        next({ path: '/' }) // 如果是去登录页，重定向到首页
      } else {
        next() // 正常跳转
      }
   // }
  } else { // 没有token
    if (to.path === '/login') {
      next() // 如果是去登录页，正常跳转
    } else {
      next('/login') // 否则重定向到登录页
    }
  }
})

router.afterEach(() => {
  // 这里可以添加一些在路由跳转后需要执行的代码
})
