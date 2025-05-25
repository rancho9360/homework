# DockerFile构建

```powershell
# 构建镜像
docker build -t homework:1.0.0 .

# 启动容器
docker run -d --name homework-app  -p 8080:8080 homework:1.0.0
```




# 依赖说明

以下是项目依赖的说明表格：

| 依赖 | 说明 |
| --- | --- |
| `spring-boot-starter-web` | 提供Spring MVC和嵌入式Servlet容器（如Tomcat），用于构建RESTful API和Web应用 |
| `spring-boot-starter-data-jpa` | 集成Spring Data JPA，简化数据库访问，支持Hibernate等JPA实现 |
| `spring-boot-starter-validation` | 提供Java Bean Validation（JSR 380）支持，用于请求参数校验 |
| `mysql-connector-j` | MySQL数据库驱动，版本9.3.0，用于连接MySQL数据库 |
| `lombok` | 通过注解减少样板代码（如Getter/Setter、构造函数等） |
| `mapstruct` | 代码生成器，用于简化Java Bean之间的映射（对象转换） |
| `mapstruct-processor` | MapStruct的注解处理器，编译时生成映射实现类 |
| `spring-boot-starter-test` | 提供测试框架（JUnit、Spring Test等）和测试工具类 |
| `mockito-core` |  mocking框架，用于单元测试中创建和管理mock对象 |
| `assertj-core` | 提供流式断言API，增强测试代码的可读性和表达力 |
| `spring-test` | Spring的测试工具包，包含Spring MVC测试支持和JSONPath等工具 |

关键依赖补充说明：
1. **数据库相关**：
   - 当前使用MySQL作为生产数据库，若需切换为H2（内存数据库），可取消H2依赖的注释
   - JPA配置通过`application.properties`或`application.yml`文件完成
2. **开发效率工具**：
   - Lombok通过注解自动生成getter/setter等方法，减少样板代码
   - MapStruct在编译期自动生成对象映射代码，避免手动编写转换逻辑
3. **测试栈**：
   - 集成了Spring Test、Mockito和AssertJ，覆盖单元测试、集成测试和控制器测试
   - JSONPath用于在控制器测试中解析和断言JSON响应

