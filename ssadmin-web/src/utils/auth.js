const AccessTokenKey = 'ACCESS_TOKEN'
//const RefreshTokenKey = 'REFRESH_TOKRN'
// 获取 Token
export function getAccessToken() {
  return localStorage.getItem(AccessTokenKey)
}
// export function getRefreshToken(){
//   return localStorage.getItem(RefreshTokenKey)
// }

// 设置 Token
export function setToken(accessToken) {
  localStorage.setItem(AccessTokenKey, accessToken)
  //localStorage.setItem(RefreshTokenKey, refreshToken)
}

// 删除 Token
export function removeToken() {
  localStorage.removeItem(AccessTokenKey)
  //localStorage.removeItem(RefreshTokenKey)
}
