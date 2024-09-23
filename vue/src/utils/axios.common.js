import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://localhost:80',
    headers: {
        'Content-type': 'application/json',
    },
    withCredentials: true
});

instance.interceptors.request.use(
    (config) => {
        // 로그인 요청이 아닌 경우에만 토큰을 포함합니다.
        if (!config.url.includes('/api/auth/login')) {
            const token = localStorage.getItem('token');
            console.log('Intercepted token:', token);  // 토큰 로그 출력

            if (token) {
                config.headers.Authorization = `Bearer ${token}`;
            }
        }
        console.log('Request config:', config);  // 요청 설정 로그 출력
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

instance.interceptors.response.use(
    (response) => {
        console.log('Response received:', response);  // 응답 로그 출력
        return response;
    },
    (error) => {
        console.error('Response error:', error);  // 응답 에러 로그 출력
        return Promise.reject(error);
    }
);

export default instance;
