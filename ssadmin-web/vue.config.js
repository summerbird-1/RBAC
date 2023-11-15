const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      "/api": {
        target: "http://localhost:7777",
        changeOrigin: true,
        pathRewrite: {
          "^/api": ''
        }
      }
    }
  }
})
