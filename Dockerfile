# Base image có sẵn JDK 17
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy jar vào container
COPY target/*.jar app.jar

# Mở port 8080
EXPOSE 8080

# Chạy app
ENTRYPOINT ["java","-jar","app.jar"]
