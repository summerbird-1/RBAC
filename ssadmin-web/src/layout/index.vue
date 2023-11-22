<template>
    <div>
      <div class="side-bar">
        <el-menu class="el-menu-vertical-demo" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
          <el-menu-item index="/" @click="$router.push('/')">
            <i class="el-icon-house"></i>
            <span slot="title">首页</span>
          </el-menu-item>
          <el-menu-item index="/user-management" @click="$router.push('/user-management')">
            <i class="el-icon-user"></i>
            <span slot="title">用户管理</span>
          </el-menu-item>
          <el-menu-item index="/role-management" @click="$router.push('/role-management')">
            <i class="el-icon-s-custom"></i>
            <span slot="title">角色管理</span>
          </el-menu-item>
          <el-menu-item index="/permission-management" @click="$router.push('/menu-management')">
            <i class="el-icon-s-order"></i>
            <span slot="title">菜单管理</span>
          </el-menu-item>
          <el-menu-item index="/logout" @click="logout">
            <i class="el-icon-switch-button"></i>
            <span slot="title">退出</span>
          </el-menu-item>
        </el-menu>
  
        <div class="main-content">
          <router-view />
        </div>
      </div>
    </div>
  </template>
  
<script>
import { removeToken} from '@/utils/auth'
import {logout} from '@/api/login'

export default {
  name: "MyComponent",
  methods: {
    logout() {
      this.$confirm('确定注销并退出系统吗？', '提示').then(() => {
        logout()
        removeToken() // 清除token
        this.$router.push({ path: '/login' }) // 重定向到登录页面
      }).catch(() => {});
    },
  },
};
</script>
  <style lang="scss" scoped>
  .side-bar {
  display: flex;
  height: 100vh;
  }
  
  .main-content {
  flex: 1;
  padding: 20px;
  }
  
  </style>
  