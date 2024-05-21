module.exports = {
    devServer: {
      proxy: {
        '/api': {
          target: 'http://localhost:80', // 백엔드 서버 주소
          changeOrigin: true
        }
      }
    }
  };
  