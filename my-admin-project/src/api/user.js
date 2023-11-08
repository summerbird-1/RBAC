import request from '@/utils/request'

// 查询用户列表
export function listUser(query) {
  return request({
    url: '/user/list',
    method: 'get',
    params: query
  })
}
// 新增用户
export function addUser(data) {
  return request({
    url: '/user',
    method: 'post',
    data: data
  })
}
// 删除用户
export function delUser(userId) {
  return request({
    url: '/user/' + userId,
    method: 'delete'
  })
}

//更新用户
export function updateUser(data){
  return request({
    url: '/user',
    method: 'put',
    data: data
  })
}

//根据id获取用户信息
export function getUser(userId){
  return request({
    url: '/user/' + userId,
    method: 'get'
  })
}

export function changeUserStatus(userId,status){
  const data = {
    userId,
    status
  }
  return request({
    url: '/user/changeStatus',
    method: 'put',
    data: data
  })
}