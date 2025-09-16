# 使用 Maven 和 Java 17 作为构建阶段
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# 复制 pom.xml 和源代码
COPY pom.xml .
COPY src ./src

# 构建应用（跳过测试）
RUN mvn clean package -DskipTests

# 使用轻量级 JRE 作为运行环境
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# 从构建阶段复制生成的 jar 包
COPY --from=build /app/target/*.jar app.jar

# 暴露应用端口（根据您的应用配置调整）
EXPOSE 8080

# 设置时区（可选）
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

# 启动应用
ENTRYPOINT ["java", "-jar", "app.jar"]