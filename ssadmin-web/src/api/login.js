import request from '@/utils/request'

// 用户登录
export function login(username, password) {
  const data = {
    username,
    password
  }
  return request({
    url: '/login',
    method: 'post',
    data: data
  })
}


// 获取用户信息
export function getInfo() {
  return request({
    url: '/user/getInfo',
    method: 'get'
  })
}


// 获取用户信息
export function getAllUser() {
  return request({
    url: '/user/getAllUser',
    method: 'get'
  })
}


// 刷新访问令牌
export function refreshToken(Token) {
  return service({
    url: '/refreshToken/' + Token,
    method: 'post'
  })
}

// 退出方法
export function logout() {

  return request({
    url: '/logout',
    method: 'post'
  })
}