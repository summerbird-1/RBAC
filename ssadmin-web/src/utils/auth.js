const AccessTokenKey = 'ACCESS_TOKEN'

// 获取 Token
export function getAccessToken() {
  return localStorage.getItem(AccessTokenKey)
}

// 设置 Token
export function setToken(accessToken) {
  localStorage.setItem(AccessTokenKey, accessToken)
}

// 删除 Token
export function removeToken() {
  localStorage.removeItem(AccessTokenKey)
}
