# Focus

一个基于 Java 的刷题网站单体项目

简介
- 项目名称：Focus
- 简短说明：Focus 是一个用来管理题库、用户与提供 AI 辅助问答（Chat）接口的后端项目。项目采用模块化结构，包含数据传输对象、公共返回包装、以及 AI 聊天控制器等模块，适合作为在线练习/答题或自动化辅导系统的后端基础。

仓库结构
- focus-ai —— 与 AI 聊天（Chat）相关的模块，包含 AIController（/chat 接口）。
- focus-common —— 公共模块，包含统一返回格式（Result）、异常类与常量等。
- focus-pojo —— POJO / DTO / VO / Entity 定义（Question、User、Repository、各类 DTO/VO 等）。
- focus-service —— 业务逻辑模块，包含 QuestionService、UserService、RepositoryService 等。


- 主要技术栈
- 框架：Spring Boot 3.2.3
- ORM：MyBatis + PageHelper（分页）
- 数据库：MySQL
- 安全：JWT 身份认证
- 文件处理：Apache POI（Word 解析）
- AI 集成：Spring AI Alibaba（通义千问）
- 构建工具：Maven
- 容器化：Docker

快速开始（在仓库根目录执行）
1. 克隆仓库
    - git clone https://github.com/kleinyumoretti/Focus.git
    - cd Focus

2. 构建（Maven，多模块）
    - mvn clean package -DskipTests
    - 说明：项目为多模块顶层 pom，上述命令会构建所有子模块；如单模块请进入具体模块执行 mvn clean package。

3. 数据库初始化
    - 确保 MySQL 已启动，端口为 3306（默认）
    - 执行 focus-common 模块下的 SQL 脚本（src/main/resources/sql/init.sql）初始化数据库结构与默认数据。
    - 说明：脚本会创建数据库 focus（如不存在），并初始化用户表、题库表、题目表等。


配置
- 应用配置通常位于 application.properties / application.yml
- 示例 application.properties：
  ```
  server.port=8080

  # 数据库配置
  spring:
    datasource:
        druid:
            driver-class-name: com.mysql.cj.jdbc.Driver
            url: jdbc:mysql://mysql:3306/focus
            username: root    //为自己的数据库用户名
            password: 123456  //为自己的数据库密码
    ai:
        dashscope:
            api-key: //获取 通义千问的 API Key 密钥 并替换
            chat:
                model: qwq-32b
  ```



已识别的重要类与用途
- com.klein.ai.AIController — 提供 /chat 接口，使用 Spring AI ChatClient。
- com.klein.result.Result — 后端统一返回结果封装（code/msg/data）。
- com.klein.entity.Question / QuestionList / Option — 题目与选项数据结构。
- com.klein.entity.User / Repository — 用户与题库实体。
- focus-pojo 下的 DTO/VO 类 — 用于前后端/模块间数据传输（如 SubjectIdDTO、UserLoginDTO、DataVO 等）。
- focus-common 下的异常与常量 — BaseException、RegisterException、UserIdConstant（线程本地用户 ID 存储）。


打包与部署
- 本地打包（Maven）:
    - mvn clean package

开发者提示 / 注意事项
- Lombok 被大量使用：请在 IDE 中安装 Lombok 插件并启用注解处理器。
- 检查 Spring AI 依赖的配置：AIController 构造中使用 ChatClient.Builder 并设置了默认 system 提示（"你的名字是Focus..."），请根据需要修改系统提示与模型配置。
- Result 返回格式：后端统一使用 Result<T>，成功 code=1，失败 code=0，前端需兼容该格式。
- 线程本地用户 ID 存储（UserIdConstant.UserId）已存在，请注意在请求处理完成后清理，以防内存/线程局部污染。

贡献
1. Fork 本仓库
2. 新建分支：git checkout -b feat/your-feature
3. 提交代码：git commit -m "feat: 简要说明"
4. 推送分支并发起 PR
5. 请保证新增逻辑有对应测试，并遵循项目代码风格

