import request from '@/utils/request'

// 查询角色列表
export function listRole(query) {
  return request({
    url: '/role/list',
    method: 'get',
    params: query
  })
}
// 查询所有角色
export function listAllRole() {
  return request({
    url: '/role/listAllRole',
    method: 'get'
  })
}
// 新增角色
export function addRole(data) {
    return request({
      url: '/role/addRole',
      method: 'post',
      data: data
    })
  }

  // 删除角色
export function delRole(roleId) {
    return request({
      url: '/role/delRole/' + roleId,
      method: 'delete'
    })
  }

export function changeRoleStatus(roleId,status){
 const data={
     roleId,
     status
  }
  return request({
    url: '/role/changeStatus',
    method: 'put',
    data: data
  })
}

// 获取角色信息
export function getRole(roleId) {
  return request({
    url: '/role/getRole/'+roleId,
    method: 'get',
  })
}
// 更新角色信息
export function updateRole(data) {
  return request({
    url: '/role',
    method: 'put',
    data: data
  })
}