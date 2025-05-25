# 使用官方JDK 21基础镜像（用于生产环境）
FROM openjdk:21-ea-jdk-oracle AS base

# 设置环境变量
ARG APP_NAME=homework
ARG APP_VERSION=1.0.0
ARG MAVEN_CACHE_DIR=/root/.m2

# 创建应用用户和工作目录
RUN groupadd -r app && useradd -r -g app app
USER app
WORKDIR /app

# ----------------------
# 阶段 1：构建应用程序
# ----------------------
FROM maven:3.9.9-amazoncorretto-21-debian AS build

# 设置相同的环境变量
ARG APP_NAME=homework
ARG APP_VERSION=1.0.0
ARG MAVEN_CACHE_DIR=/root/.m2

# 创建缓存目录（如果不存在）
RUN mkdir -p ${MAVEN_CACHE_DIR}

# 挂载Maven缓存（加速依赖下载）
RUN --mount=type=cache,target=${MAVEN_CACHE_DIR} \
    mkdir -p ${MAVEN_CACHE_DIR} && \
    echo "Maven cache directory created"

# 复制Maven配置和POM文件
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
# 下载依赖（利用Docker缓存）
RUN --mount=type=cache,target=${MAVEN_CACHE_DIR} \
    ./mvnw dependency:go-offline -B

# 复制完整代码并构建
COPY src ./src
RUN --mount=type=cache,target=${MAVEN_CACHE_DIR} \
    ./mvnw package -DskipTests

# ----------------------
# 阶段 2：生产环境镜像
# ----------------------
FROM base AS production

# 复制构建好的JAR包（从build阶段复制）
COPY --from=build --chown=app:app target/${APP_NAME}-${APP_VERSION}.jar app.jar

# 暴露端口
EXPOSE 8080

# 优化JVM配置
ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=256m \
               -XX:+UseG1GC -XX:MaxGCPauseMillis=200 \
               -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/app/heapdump.hprof"

# 启动命令
CMD [ "sh", "-c", "java $JAVA_OPTS -jar /app/app.jar" ]