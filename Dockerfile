# 第一阶段：构建应用
FROM eclipse-temurin:21-jdk AS builder

# 设置工作目录
WORKDIR /app

# 复制 Maven 配置文件和源代码
COPY pom.xml .
COPY src ./src

# 构建应用（跳过测试）
RUN --mount=type=cache,target=/root/.m2 \
    ./mvnw clean package -DskipTests

# 提取 JAR 文件
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# 第二阶段：运行时环境
FROM eclipse-temurin:21-jre

# 设置时区（可选）
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 创建应用目录
WORKDIR /app

# 从构建阶段复制依赖和类文件
COPY --from=builder /app/target/dependency/BOOT-INF/lib ./lib
COPY --from=builder /app/target/dependency/META-INF ./META-INF
COPY --from=builder /app/target/dependency/BOOT-INF/classes ./classes

# 暴露应用端口
EXPOSE 8080

# 设置启动命令
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-Xmx512m", "-jar", "app.jar"]