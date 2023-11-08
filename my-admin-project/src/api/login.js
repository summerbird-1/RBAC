import request from '@/utils/request'

// 用户登录
export function login(username, password) {
  const data = {
    username,
    password
  }
  return request({
    url: '/user/login',
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
