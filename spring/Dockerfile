# 기본 이미지
FROM eclipse-temurin:17-jdk

# 애플리케이션 파일 복사
COPY ./target/myapplication-0.0.1-SNAPSHOT.jar /app.jar

# 실행할 커맨드
ENTRYPOINT ["java", "-jar", "/app.jar"]
