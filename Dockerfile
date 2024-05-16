# 베이스 이미지 설정
FROM openjdk:17-jdk-alpine

# 애플리케이션 jar 파일을 추가
COPY spring\target\SpringBootMVCRest-0.0.1-SNAPSHOT.jar /app.jar

# 컨테이너가 시작될 때 실행할 명령어
ENTRYPOINT ["java", "-jar", "/app.jar"]
