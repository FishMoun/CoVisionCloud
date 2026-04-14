# CoVision - 智能协同云图库平台

<p align="center">
  <strong>一个企业级的图片管理和协同编辑平台</strong>
</p>

---

## 📋 目录

- [项目介绍](#项目介绍)
- [核心功能](#核心功能)
- [技术栈](#技术栈)
- [系统架构](#系统架构)
- [快速开始](#快速开始)
- [API 文档](#api-文档)
- [项目结构](#项目结构)
- [主要特性](#主要特性)
- [数据库设计](#数据库设计)
- [贡献指南](#贡献指南)

---

## 项目介绍

**CoVision** 是一个功能全面的云图库管理平台，专为团队协作设计。它提供强大的图片管理、智能分析、实时协编以及 AI 辅助功能，帮助用户高效管理和利用图片资源。

### 🎯 核心价值
- **团队协作**：支持多人共享空间，灵活的权限管理
- **智能管理**：图片搜索、分析、分类等智能功能
- **实时编辑**：基于 WebSocket 的实时图片协同编辑
- **AI 赋能**：集成阿里云 AI、图片搜索等能力
- **安全可靠**：企业级权限控制、数据加密存储

---

## 核心功能

### 👤 用户管理
- ✅ 用户注册、登录、认证
- ✅ 用户信息管理（头像、昵称、个人简介等）
- ✅ 基于 Sa-Token 的权限认证框架
- ✅ 支持管理员角色和普通用户角色

### 🗂️ 空间管理
- ✅ 创建、编辑、删除私有空间
- ✅ 多层级空间支持（普通版、专业版、旗舰版）
- ✅ 空间容量和文件数量限制
- ✅ 基于空间的权限隔离

### 🖼️ 图片管理
- ✅ 单张/批量图片上传
- ✅ 图片 URL 导入
- ✅ 图片信息编辑（标题、描述、分类、标签）
- ✅ 图片审核流程管理
- ✅ 腾讯云 COS 对象存储集成

### 🔍 智能功能
- ✅ **色彩搜索**：通过相似颜色快速检索图片
- ✅ **图片搜索**：基于内容的相似图片查找
- ✅ **AI 扩图**：集成阿里云 AI 的图片外扩功能
- ✅ **智能分析**：生成空间使用情况、分类分布、用户贡献等多维度分析报告

### 📊 数据分析
- ✅ 空间使用统计
- ✅ 图片尺寸分布分析
- ✅ 标签热度分析
- ✅ 分类占比分析
- ✅ 用户贡献排行

### 🤝 协同编辑
- ✅ WebSocket 实时连接
- ✅ 多人同时编辑状态同步
- ✅ 高性能消息队列（Disruptor）
- ✅ 编辑操作实时推送

### 🔐 权限管理
- ✅ 细粒度空间权限控制
- ✅ 多种角色支持（Owner、Editor、Viewer）
- ✅ 基于权限注解的方法级控制
- ✅ 空间成员管理

---

## 技术栈

### 后端框架
| 技术 | 版本 | 用途 |
|------|------|------|
| Spring Boot | 2.6.13 | 核心框架 |
| Spring MVC | - | Web 框架 |
| Spring Data Redis | - | Redis 集成 |
| Spring Session | - | 分布式会话管理 |
| Spring WebSocket | - | 实时通信 |
| Spring AOP | - | 面向切面编程 |

### 数据访问
| 技术 | 版本 | 用途 |
|------|------|------|
| MyBatis-Plus | 3.5.9 | ORM 框架 |
| MySQL | 8.0+ | 关系型数据库 |
| ShardingSphere | 5.2.0 | 分库分表 |

### 缓存和消息
| 技术 | 版本 | 用途 |
|------|------|------|
| Redis | - | 缓存/会话存储 |
| Caffeine | 2.9.3 | 本地缓存 |
| Disruptor | 3.4.2 | 高性能无锁队列 |

### 安全认证
| 技术 | 版本 | 用途 |
|------|------|------|
| Sa-Token | 1.37.0 | 权限认证框架 |
| Sa-Token Redis | 1.37.0 | Redis 会话存储 |

### 文件存储和 AI
| 技术 | 版本 | 用途 |
|------|------|------|
| 腾讯云 COS | 5.6.227 | 对象存储服务 |
| 阿里云 AI | - | 图片外扩等 AI 功能 |
| Jsoup | 1.15.3 | HTML 解析 |

### 工具库
| 技术 | 版本 | 用途 |
|------|------|------|
| Lombok | - | 代码简化 |
| Hutool | 5.8.26 | Java 工具库 |
| Knife4j | 4.4.0 | API 文档 UI |
| SpringDoc OpenAPI | 1.7.0 | OpenAPI 文档生成 |

---

## 系统架构

### 高层架构
```
┌─────────────────────────────────────────────────────┐
│                   前端应用                            │
└────────────────┬────────────────────────────────────┘
                 │
                 ▼
┌─────────────────────────────────────────────────────┐
│              Spring Boot REST API                    │
│  ┌───────────────────────────────────────────────┐  │
│  │  控制层 (Controller)                           │  │
│  │  - UserController  (用户管理)                 │  │
│  │  - SpaceController (空间管理)                 │  │
│  │  - PictureController (图片管理)               │  │
│  │  - SpaceAnalyzeController (数据分析)          │  │
│  └───────────────────────────────────────────────┘  │
│                     ▼                                │
│  ┌───────────────────────────────────────────────┐  │
│  │  业务层 (Service)                             │  │
│  │  - UserService          - SpaceService        │  │
│  │  - PictureService       - SpaceAnalyzeService │  │
│  │  - SpaceUserService                          │  │
│  └───────────────────────────────────────────────┘  │
│                     ▼                                │
│  ┌───────────────────────────────────────────────┐  │
│  │  数据访问层 (Mapper)                           │  │
│  │  - 基于 MyBatis-Plus                          │  │
│  │  - ShardingSphere 分库分表                    │  │
│  └───────────────────────────────────────────────┘  │
│                     ▼                                │
│  ┌───────────────────────────────────────────────┐  │
│  │  基础组件                                      │  │
│  │  - 认证管理 (Sa-Token)                        │  │
│  │  - 文件管理 (CosManager)                      │  │
│  │  - WebSocket (PictureEditHandler)             │  │
│  │  - 缓存管理 (Redis + Caffeine)                │  │
│  └───────────────────────────────────────────────┘  │
└──────┬──────────────────────────────────────────────┘
       │
       ├──────────────┬──────────────┬──────────────┐
       ▼              ▼              ▼              ▼
    MySQL         Redis         Tencent COS    阿里云AI
   数据库         缓存/会话       文件存储       AI服务
```

### 模块说明

**控制层 (Controller)**
- `UserController`: 用户注册、登录、信息管理
- `SpaceController`: 空间 CRUD、成员管理
- `PictureController`: 图片上传、编辑、搜索、删除
- `SpaceAnalyzeController`: 生成各类分析数据
- `SpaceUserController`: 空间成员权限管理

**业务层 (Service)**
- 实现核心业务逻辑
- 处理事务和缓存策略
- 调用外部 API（阿里云 AI、COS 等）

**数据访问层 (Mapper)**
- MyBatis-Plus 代码生成器生成
- 支持分库分表操作
- 自动化 SQL 生成

**基础组件**
- `AuthInterceptor`: 认证拦截器
- `CosManager`: 腾讯云 COS 管理器
- `FileManager`: 本地文件管理
- `PictureEditHandler`: WebSocket 消息处理
- `SpaceUserAuthManager`: 空间权限管理

---

## 快速开始

### 前置要求
- **Java 8** 或更高版本
- **MySQL 8.0+**
- **Redis 5.0+**
- **Maven 3.6+**
- **腾讯云 COS** 账户（可选，用于文件存储）
- **阿里云 AI** 账户（可选，用于 AI 功能）

### 环境配置

#### 1️⃣ 克隆项目
```bash
git clone <repository-url>
cd CoVision
```

#### 2️⃣ 数据库初始化
```bash
# 创建数据库
mysql -u root -p < sql/create_table.sql

# 执行其他初始化脚本
mysql -u root -p < sql/create_space.sql
mysql -u root -p < sql/create_picture.sql
mysql -u root -p < sql/create_space_user.sql
```

#### 3️⃣ 配置文件设置

创建 `src/main/resources/application.yml` 或 `application-dev.yml`：

```yaml
spring:
  application:
    name: CoVision
  
  datasource:
    url: jdbc:mysql://localhost:3306/covision?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC
    username: root
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
  
  redis:
    host: localhost
    port: 6379
    password: 
    database: 0
    timeout: 1800000
    jedis:
      pool:
        max-active: 20
        max-idle: 10
        min-idle: 5
        max-wait: -1ms
  
  # WebSocket 配置
  session:
    store-type: redis

# 服务器端口
server:
  port: 8080

# MyBatis-Plus 配置
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.fishmoun.covision.model.entity

# Sa-Token 配置
sa-token:
  token-name: Authorization
  timeout: 2592000
  activity-timeout: -1
  is-concurrent: true
  is-share: false
  token-style: uuid
  is-log: true

# 腾讯云 COS 配置（可选）
cos:
  secret-id: your_secret_id
  secret-key: your_secret_key
  bucket: your_bucket
  region: ap-beijing

# 阿里云 AI 配置（可选）
aliyun:
  access-key-id: your_access_key
  access-key-secret: your_secret_key
```

#### 4️⃣ 构建项目
```bash
mvn clean package
```

#### 5️⃣ 运行项目
```bash
# 方式一：使用 Maven
mvn spring-boot:run

# 方式二：运行 JAR
java -jar target/CoVision-0.0.1-SNAPSHOT.jar
```

服务将在 `http://localhost:8080` 启动。

### API 文档访问
项目启动后，访问以下地址查看 API 文档：
- **Knife4j 文档**: http://localhost:8080/doc.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

---

## API 文档

### 核心 API 端点

#### 用户管理
| 方法 | 端点 | 描述 |
|------|------|------|
| POST | `/user/register` | 用户注册 |
| POST | `/user/login` | 用户登录 |
| POST | `/user/logout` | 用户登出 |
| GET | `/user/get/login` | 获取当前登录用户 |
| PUT | `/user/update` | 更新用户信息 |
| GET | `/user/list` | 获取用户列表（管理员） |

#### 空间管理
| 方法 | 端点 | 描述 |
|------|------|------|
| POST | `/space/add` | 创建空间 |
| POST | `/space/delete` | 删除空间 |
| PUT | `/space/edit` | 编辑空间 |
| GET | `/space/get` | 获取空间详情 |
| GET | `/space/list` | 获取空间列表 |

#### 图片管理
| 方法 | 端点 | 描述 |
|------|------|------|
| POST | `/picture/upload` | 上传图片 |
| POST | `/picture/upload/batch` | 批量上传图片 |
| POST | `/picture/delete` | 删除图片 |
| PUT | `/picture/edit` | 编辑图片信息 |
| GET | `/picture/get` | 获取图片详情 |
| GET | `/picture/list` | 获取图片列表 |
| POST | `/picture/search/color` | 色彩搜索 |
| POST | `/picture/search/by-picture` | 图片搜索 |

#### 数据分析
| 方法 | 端点 | 描述 |
|------|------|------|
| POST | `/space-analyze/usage` | 获取使用统计 |
| POST | `/space-analyze/category` | 获取分类分析 |
| POST | `/space-analyze/tag` | 获取标签分析 |
| POST | `/space-analyze/size` | 获取尺寸分析 |
| POST | `/space-analyze/user` | 获取用户贡献分析 |

详细的请求和响应模式，请参考启动后的 API 文档。

---

## 项目结构

```
CoVision/
├── sql/                                    # SQL 脚本
│   ├── create_table.sql                   # 基础表创建
│   ├── create_space.sql                   # 空间表
│   ├── create_picture.sql                 # 图片表
│   ├── create_space_user.sql              # 空间成员表
│   └── update_*.sql                       # 表更新脚本
│
├── src/main/java/com/fishmoun/covision/
│   ├── CoVisionApplication.java           # 应用启动类
│   │
│   ├── controller/                        # 控制层
│   │   ├── UserController.java
│   │   ├── SpaceController.java
│   │   ├── PictureController.java
│   │   ├── SpaceAnalyzeController.java
│   │   ├── SpaceUserController.java
│   │   └── FileController.java
│   │
│   ├── service/                           # 业务层
│   │   ├── UserService.java
│   │   ├── SpaceService.java
│   │   ├── PictureService.java
│   │   ├── SpaceAnalyzeService.java
│   │   ├── SpaceUserService.java
│   │   └── impl/                          # 实现类
│   │
│   ├── mapper/                            # 数据访问层
│   │   ├── UserMapper.java
│   │   ├── SpaceMapper.java
│   │   ├── PictureMapper.java
│   │   └── SpaceUserMapper.java
│   │
│   ├── model/                             # 数据模型
│   │   ├── entity/                        # 数据库实体
│   │   │   ├── User.java
│   │   │   ├── Space.java
│   │   │   ├── Picture.java
│   │   │   ├── SpaceUser.java
│   │   │   └── ...
│   │   ├── dto/                           # 数据传输对象
│   │   │   ├── user/
│   │   │   ├── space/
│   │   │   ├── picture/
│   │   │   └── ...
│   │   ├── vo/                            # 视图对象
│   │   │   ├── UserVO.java
│   │   │   ├── SpaceVO.java
│   │   │   ├── PictureVO.java
│   │   │   └── ...
│   │   └── enums/                         # 枚举类
│   │       ├── UserRoleEnum.java
│   │       ├── SpaceLevelEnum.java
│   │       ├── PictureReviewStatusEnum.java
│   │       └── ...
│   │
│   ├── manager/                           # 管理器层
│   │   ├── auth/                          # 认证授权
│   │   │   ├── StpKit.java
│   │   │   ├── StpInterfaceImpl.java
│   │   │   ├── SpaceUserAuthManager.java
│   │   │   └── annotation/
│   │   │
│   │   ├── websocket/                     # WebSocket 相关
│   │   │   ├── PictureEditHandler.java
│   │   │   ├── WsHandshakeInterceptor.java
│   │   │   ├── model/
│   │   │   └── model/discruptor/          # Disruptor 配置
│   │   │
│   │   ├── sharding/                      # 分库分表
│   │   │   ├── PictureShardingAlgorithm.java
│   │   │   └── DynamicShardingManager.java
│   │   │
│   │   ├── upload/                        # 文件上传
│   │   │   ├── PictureUploadTemplate.java
│   │   │   ├── FilePictureUpload.java
│   │   │   └── UrlPictureUpload.java
│   │   │
│   │   ├── CosManager.java                # 腾讯云 COS 管理
│   │   └── FileManager.java               # 文件管理
│   │
│   ├── api/                               # 外部 API 集成
│   │   ├── imagesearch/                   # 图片搜索
│   │   │   ├── ImageSearchApiFacade.java
│   │   │   └── sub/
│   │   │
│   │   └── aliyunai/                      # 阿里云 AI
│   │       ├── sub/AliYunAiApi.java
│   │       └── model/
│   │
│   ├── config/                            # 配置类
│   │   ├── CosClientConfig.java
│   │   ├── RedisConfig.java
│   │   ├── WebSocketConfig.java
│   │   ├── CorsConfig.java
│   │   ├── RequestWrapper.java
│   │   ├── HttpRequestWrapperFilter.java
│   │   └── PictureEditEventDisruptorConfig.java
│   │
│   ├── annotation/                        # 自定义注解
│   │   ├── AuthCheck.java
│   │   └── SaSpaceCheckPermission.java
│   │
│   ├── aop/                               # AOP 切面
│   │   └── AuthInterceptor.java
│   │
│   ├── exception/                         # 异常处理
│   │   ├── BusinessException.java
│   │   ├── ErrorCode.java
│   │   ├── ThrowUtils.java
│   │   └── GlobalExceptionHandler.java
│   │
│   ├── common/                            # 通用类
│   │   ├── BaseResponse.java              # 统一响应格式
│   │   ├── ResultUtils.java               # 结果工具
│   │   ├── PageRequest.java               # 分页请求
│   │   ├── DeleteRequest.java
│   │   ├── SpaceAnalyzeRequest.java
│   │   └── SpaceUserAuthContext.java
│   │
│   ├── utils/                             # 工具类
│   │   └── ColorSimilarUtils.java         # 颜色相似度算法
│   │
│   └── constant/                          # 常数定义
│       └── UserConstant.java
│
├── src/test/java/                         # 测试代码
│
├── pom.xml                                # Maven 配置
├── README.md                              # 本文件
└── HELP.md                                # 帮助文档
```

---

## 主要特性

### 🔐 安全性
- **Sa-Token 框架**：提供完整的认证和授权解决方案
- **权限隔离**：基于空间的数据隔离
- **CORS 跨域**：安全的跨域资源共享配置
- **请求包装**：HttpServletRequest 包装过滤

### ⚡ 性能优化
- **Redis 缓存**：分布式缓存提升查询性能
- **Caffeine 本地缓存**：热点数据的本地缓存
- **Disruptor 高性能队列**：异步处理编辑事件
- **分库分表**：ShardingSphere 数据分片
- **Connection Pool**：数据库连接池管理

### 🔄 可扩展性
- **模板方法模式**：PictureUploadTemplate 提供扩展点
- **策略模式**：支持多种上传方式（文件、URL）
- **服务接口**：清晰的服务抽象
- **配置驱动**：通过配置文件灵活调整

### 📡 实时通信
- **WebSocket**：实时双向通信
- **事件驱动**：基于 Disruptor 的高效事件处理
- **消息推送**：实时编辑状态同步

### 🤖 AI 能力
- **阿里云 AI**：图片外扩功能
- **图片搜索**：相似图片检索
- **颜色搜索**：色彩相似度匹配

---

## 数据库设计

### 核心表结构

#### user 表
```sql
CREATE TABLE user (
    id BIGINT PRIMARY KEY COMMENT '用户ID',
    user_account VARCHAR(256) UNIQUE COMMENT '账号',
    user_password VARCHAR(512) COMMENT '密码',
    user_name VARCHAR(256) COMMENT '昵称',
    user_avatar VARCHAR(1024) COMMENT '头像',
    user_profile TEXT COMMENT '个人简介',
    user_role VARCHAR(256) DEFAULT 'user' COMMENT '用户角色',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_delete TINYINT DEFAULT 0 COMMENT '是否删除'
);
```

#### space 表
```sql
CREATE TABLE space (
    id BIGINT PRIMARY KEY COMMENT '空间ID',
    user_id BIGINT COMMENT '创建者ID',
    space_name VARCHAR(256) COMMENT '空间名称',
    space_level INT DEFAULT 0 COMMENT '空间级别',
    max_size BIGINT COMMENT '最大容量',
    max_count BIGINT COMMENT '最大文件数',
    total_size BIGINT DEFAULT 0 COMMENT '当前容量',
    total_count BIGINT DEFAULT 0 COMMENT '当前文件数',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_delete TINYINT DEFAULT 0
);
```

#### picture 表
```sql
CREATE TABLE picture (
    id BIGINT PRIMARY KEY COMMENT '图片ID',
    url VARCHAR(1024) COMMENT '图片URL',
    name VARCHAR(256) COMMENT '图片名称',
    introduction TEXT COMMENT '简介',
    category VARCHAR(256) COMMENT '分类',
    tags JSON COMMENT '标签',
    pic_size BIGINT COMMENT '文件大小',
    pic_width INT COMMENT '图片宽度',
    pic_height INT COMMENT '图片高度',
    pic_scale DECIMAL(8,2) COMMENT '宽高比',
    pic_format VARCHAR(32) COMMENT '图片格式',
    review_status INT DEFAULT 0 COMMENT '审核状态',
    space_id BIGINT COMMENT '所属空间ID',
    user_id BIGINT COMMENT '上传者ID',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_delete TINYINT DEFAULT 0
);
```

#### space_user 表
```sql
CREATE TABLE space_user (
    id BIGINT PRIMARY KEY COMMENT '记录ID',
    space_id BIGINT COMMENT '空间ID',
    user_id BIGINT COMMENT '用户ID',
    space_role VARCHAR(256) COMMENT '空间角色',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_delete TINYINT DEFAULT 0
);
```

---

## 贡献指南

### 开发工作流

1. **创建分支**
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. **提交代码**
   ```bash
   git add .
   git commit -m "feat: add your feature description"
   ```

3. **推送到远程**
   ```bash
   git push origin feature/your-feature-name
   ```

4. **发起 Pull Request**
   - 清晰描述功能或修复内容
   - 提供测试证明

### 代码规范

- **命名规范**：遵循 Java 标准命名规范
- **代码格式**：使用 IDE 自动格式化
- **注释**：为复杂逻辑添加有意义的注释
- **异常处理**：使用自定义异常和统一异常处理

### 提交消息规范

```
<type>(<scope>): <subject>

<body>

<footer>
```

类型：
- `feat`: 新功能
- `fix`: 修复 bug
- `docs`: 文档修改
- `style`: 代码格式调整
- `refactor`: 代码重构
- `perf`: 性能优化
- `test`: 测试相关
- `chore`: 构建配置等

---

## 许可证

本项目采用 [MIT License](LICENSE) 许可证。

---

## 联系方式

- **项目维护者**：CoVision Team
- **问题反馈**：提交 Issue 或联系维护者

---

## 相关链接

- [Sa-Token 文档](https://sa-token.cc/)
- [MyBatis-Plus 文档](https://baomidou.com/pages/24112f/)
- [Spring Boot 文档](https://spring.io/projects/spring-boot)
- [Knife4j 文档](https://doc.xiaominfo.com/)

---

**最后更新**: 2026-04-14  
**版本**: 0.0.1-SNAPSHOT
