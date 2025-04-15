# Stage 1: Build
FROM maven:3.8.6-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
# chuẩn bị môi trường offline cho maven(tải tất cả các phụ thuộc cần thiết)
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# Xmx512m thiết lập bộ nhớ tối đa cho Heap mà JVM có thể sử dụng là 512MB (container)
# Xms256m thiết lập bộ nhớ tối thiểu cho Heap mà JVM có thể sử dụng là 256MB (tạo sẵn)
ENV JAVA_OPTS="-Xmx512m -Xms256m"

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar"]