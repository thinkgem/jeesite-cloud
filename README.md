## 引言

JeeSite Cloud 具备 [JeeSite 4.x](https://gitee.com/thinkgem/jeesite4) 的所有功能，是在 JeeSite 4.x 基础之上，完成的 [Spring Cloud](https://spring.io/projects/spring-cloud) 分布式系统套件的整合。它利用 JeeSite 5.x 的开发便利性巧妙地简化了分布式系统开发。

JeeSite Cloud 并没有重复制造轮子，它只是将目前比较成熟的、经得起实际考验的服务框架组合起来，通过 Spring Boot 风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。

集成阿里优秀组件 Nacos 服务治理与配置中心、集成 Sentinel 流量卫兵；集成 Zipkin 链路追踪；集成 Seata 分布式事务等，详见技术选型章节。

**特点：用经典开发模式，开发分布式应用，两个字【简单】，一个字【快】。**

源码仓库地址：<https://gitee.com/thinkgem/jeesite4-cloud>

## 优势（只写别人没有的）

1. 在 JeeSite 单应用基础之上，完成的 Cloud 功能，使用经典开发模式，就像开发单应用一样开发分布式应用
2. 它提供了微服务模块的代码生成工具，快速生成开发微服务功能，包含微服务的发布和调用接口
3. 我们将 api 和 client 合体为一个工程，自动适应自己调用自己 client 的影响，简化工程数量
4. 解决 Feign 接口不能多重继承问题，如一些通用操作（增删改查）微服务接口基类实现，这些都不用自己写了
5. 统一的授权认证、基础数据微服务，都已经提供查询 client 接口，其他微服务应用模块中可直接获取用户、组织、权限、字典等基础数据。微服务之间调用中，出现的会话及缓存的一致性统一得到解决。
6. 如 UserUtils、EmpUtils、EmpUserService、OfficeService 等等众多的基础服务工具类，都可以直接从基础数据的微服务中获取数据，你不必考虑跨 web 服务的数据交互，我们已经帮你做了。
7. 微服务组件 Nacos、Sentinel、Zipkin 提供源码方式启动部署，方便开发调试。
8. 写一个别人有的，使用柔性事务入侵性小，跨 web 服务的情况，支持单个微服务独立数据库。
9. 集成工作流，提供BPM引擎独立的服务，客户端只需调用API，无需加载复杂流程引擎。
10. 其它优势（按 Ctrl + Shift 点击链接）：<http://jeesite.com/docs/feature/>

## 技术选型

* 分布式系统套件版本：Spring Cloud 2021.0.4 + Alibaba 2021.0.4
* 服务治理注册与发现：Spring Cloud Eureka / Consul / Nacos 2.1
* 分布式统一配置中心：Spring Cloud Config / Nacos 2.1
* 网关路由代理调用：Spring Cloud Gateway (动态网关)
* 声明式服务调用：Spring Cloud OpenFeign
* 客户端负载均衡：Spring Cloud LoadBalancer
* 阿里流量防卫兵：Sentinel 1.8 (限流、熔断降级、负载保护)
* 分布式事务框架：Seata 1.5 (可选组件)
* 分布式链路追踪：Zipkin 2.23 (可选组件)
* 工作流引擎框架：Flowable 6.6 (可选组件)

## 子项目介绍

* 服务注册：jeesite-cloud-eureka ： <http://127.0.0.1:8970>
* 配置中心：jeesite-cloud-config ： <http://127.0.0.1:8971/project/default>
* **服务注册和配置中心 Nacos 版本**（推荐） ：<http://127.0.0.1:8848/nacos/index.html>
* 网关路由：jeesite-cloud-gateway ： <http://127.0.0.1:8980/js/a/login>
* 核心模块（**统一授权认证服务、平台基础数据服务**）：
  - 核心主项目：jeesite-cloud-module-core ： <http://127.0.0.1:8981/js>
  - 客户端项目（提供其它模块调用）：jeesite-cloud-module-core-client
* 测试模块1（单表增删改查示例）：
  - 模块1主项目：jeesite-cloud-module-test1 ： <http://127.0.0.1:8982/js>
  - 模块1客户端项目（提供其它模块调用）：jeesite-cloud-module-test1-client
* 测试模块2（树表增删改查示例）：
  - 模块2主项目：jeesite-cloud-module-test2 ： <http://127.0.0.1:8983/js>
  - 模块2客户端项目（提供其它模块调用）：jeesite-cloud-module-test2-client
* 测试模块3（代码生成的模块和代码生成的增删改查，**该模块完全没有手写，全部为生成的**）：
  - 模块3主项目：jeesite-cloud-module-test3 ： <http://127.0.0.1:8985/js>
  - 模块3客户端项目（提供其它模块调用）：jeesite-cloud-module-test3-client
* 业务流程基础服务（流程引擎服务，客户端只需调用接口，无需加载引擎逻辑）：
  - 流程主项目：jeesite-cloud-module-bpm ： <http://127.0.0.1:8990>
  - 客户端项目（提供其它模块调用）：jeesite-cloud-module-bpm-client
* 分布式事务 Seata 服务（1.5之后新增监控界面，端口7091）：
  - 服务主项目：jeesite-cloud-module-seata ： <http://127.0.0.1:7091>
  - 客户端项目（提供其它模块调用）：jeesite-cloud-module-seata-client
* 熔断限流：jeesite-cloud-sentinel ： <http://127.0.0.1:9311>
* 链路追踪：jeesite-cloud-zipkin ： <http://127.0.0.1:9411>
* 解释：主项目为服务提供者、客户端项目为服务消费者

## 快速运行

### 初始化数据库

JeeSite Cloud 版本的数据库与 JeeSite 单机版数据库相同，你可以 [下载最新的mysql脚本](https://gitee.com/thinkgem/jeesite4/attach_files)
或者使用 [init-data.bat(sh)](http://jeesite.com/docs/install-deploy/#初始化数据库) 命令完成初始化（支持多种数据库）。

### 安装 Redis

Redis 是一个缓存数据库，主要用来集中式管理共享会话和系统缓存的，如果你已安装 Redis，可以忽略这个步骤。

由于 Windows 版本的 Redis 安装不太方便，所以我们提供了该版本的安装文件和安装脚本。

下载地址：<https://gitee.com/thinkgem/jeesite4-cloud/attach_files> 找到 `Redis-x64-4.0.2.2.zip` 下载文件。

解压  `Redis-x64-4.0.2.2.zip` 压缩包，运行 `service-install.bat` 安装 Windows 系统服务。

默认地址：127.0.0.1；默认端口：6379；默认密码：1234，可根据自己需要修改 conf 文件。

### 启动 Nacos 服务

Nacos 致力于帮助您发现、配置和管理微服务。
Nacos 提供了一组简单易用的特性集，帮助您快速实现动态服务发现、服务配置、服务元数据及流量管理。
Nacos 帮助您更敏捷和容易地构建、交付和管理微服务平台。
Nacos 是构建以“服务”为中心的现代应用架构 (例如微服务范式、云原生范式) 的服务基础设施。

如果使用 Nacos 就不用部署 `jeesite-cloud-eureka` 和 `jeesite-cloud-config` 了。

JeeSite Cloud 提供了 2 种部署方式，你可以下载 jar 也可以 src 方式运行：

**jar 方式：**

1. 下载地址：<https://github.com/alibaba/nacos/releases/download/2.1.1/nacos-server-2.1.1.zip>
2. 解压 `nacos-server-2.1.1.zip` 压缩包，运行 `/bin/startup.cmd(sh)` 启动服务。

**src 方式：**

1. 在 Eclipse 或 IDEA 中 找到 jeesite-cloud-nacos 项目。
2. 运行 NacosApplication 类的 main 方法，即可启动服务。

**配置 mysql 存储：**

1. 默认情况 Nacos 采用 Derby 数据库，你可以将数据库切换到 MySQL 下。
2. 找到 /nacos/src/main/resources/config/nacos-mysql.sql 文件导入数据表。
3. 找到 Nacos 的配置文件 application.properties 如下：

```properties
spring.datasource.platform=mysql

### Count of DB:
db.num=1

### Connect URL of DB:
db.url.0=jdbc:mysql://127.0.0.1:3306/nacos?useSSL=false&characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&serverTimezone=UTC
db.user=root
db.password=123456

# 如果是 application.properties 文件，将 key 后的冒号换为等号即可。
```

**启动完成后：**

浏览器访问：<http://127.0.0.1:8848/nacos/index.html>  用户名密码：nacos

登录后，进入菜单 `配置管理 -> 配置列表` 点击 `导入配置` 按钮，选择 `/config/src/main/resources/jeesite-cloud-yml.zip` 上传文件。

然后编辑 Data Id 为 `application.yml` 的文件里的 JDBC 和 Redis 信息。

### 启动 Sentinel 服务

随着微服务的流行，服务和服务之间的稳定性变得越来越重要。
Sentinel 是面向分布式服务架构的流量控制组件，主要以流量为切入点，
从流量控制、熔断降级、系统自适应保护等多个维度来帮助您保障微服务的稳定性。

1. 在 Eclipse 或 IDEA 中 找到 jeesite-cloud-sentinel 项目。
2. 运行 SentinelApplication 类的 main 方法，即可启动服务。

浏览器访问：<http://127.0.0.1:9311>  用户名密码：sentinel

### 启动 Zipkin 服务

Zipkin 是一个开放源代码分布式的跟踪系统，每个服务向 Zipkin 报告计时数据，Zipkin会根据调用关系通过 Zipkin UI 生成依赖关系图。

1. 在 Eclipse 或 IDEA 中 找到 jeesite-cloud-zipkin 项目。
2. 运行 ZipkinApplication 类的 main 方法，即可启动服务。

浏览器访问：<http://127.0.0.1:9411>

### 启动微服务项目

* 在每个微服务中可以找的 `config/bootstrap.yml` 配置服务注册和配置中心地址。
* 按顺序运行以下启动类的main方法：（因为服务直接有依赖，请启动完成一个再启下一个）
  - /jeesite-cloud-gateway/../GatewayApplication.java
  - /jeesite-cloud-module-core/../CoreApplication.java
  - /jeesite-cloud-module-test1/../Test1Application.java
  - /jeesite-cloud-module-test2/../Test2Application.java
* 以上都启动成功后，浏览器访问网关项目地址即可：
  - 访问地址：<http://127.0.0.1:8980/js>  用户名密码： system  admin
  - 若访问报错，请再等待一会，可能服务未完全启动完成

![](https://images.gitee.com/uploads/images/2020/0120/235836_b3da5155_6732.png)

## 调用实例演示

### 网关代理模块调用

* 代理 test1 模块（单表）：<http://127.0.0.1:8980/js/a/test1/testData/list>
  - 控制器位置：/jeesite-cloud-module-test1/../web/TestData1Controller.java
* 代理 test2 模块（树表）：<http://127.0.0.1:8980/js/a/test2/testTree/list>
  - 控制器位置：/jeesite-cloud-module-test2/../web/TestTree2Controller.java

### 模块之间互相调用

* test2 模块调用 test1 模块（单表）：<http://127.0.0.1:8980/js/a/test2/testData/list>
  - 服务消费者位置：/jeesite-cloud-module-test2/../web/TestData2Controller.java
  - 服务提供者位置：/jeesite-cloud-module-test1/../service/TestDataService.java
* test1 模块调用 test2 模块（树表）：<http://127.0.0.1:8980/js/a/test1/testTree/list>
  - 服务消费者位置：/jeesite-cloud-module-test1/../web/TestTree1Controller.java
  - 服务提供者位置：/jeesite-cloud-module-test2/../service/TestTreeService.java

## 新增微服务工程

### 1、新建模块

1）进入菜单：系统管理 -> 系统设置 -> 模块管理，新建一个模块，填写：

- 模块名称：测试模块
- 模块编码：test3
- 生成基础路径：填写新建模块的根目录
- 代码生成模板：生成微服务模块代码（Cloud）

点击 “保存并生成代码” 按钮，即可完成微服务模块的工程代码新建。

2）新建微服务功能，进入代码生成器功能菜单，生成时选择 Cloud 的代码生成模板即可。

**v4.2.2之前版本：**

由于之前版本没有微服务模块生成器功能，所以需要参考其它模块。举例新增一个微服务模块模块叫 `test3`，该模块的所有映射地址均在 `${adminPath}/test3/**` 这个路径下，该模块可以参照 `test1` 进行，步骤如下：

拷贝 jeesite-cloud-module-test1 项目为 jeesite-cloud-module-test3 文件夹：

1）修改 pom.xml 中的应用名：

```xml
<artifactId>jeesite-cloud-module-test1</artifactId>
替换为：
<artifactId>jeesite-cloud-module-test3</artifactId>
```

```xml
<artifactId>jeesite-cloud-module-test1-client</artifactId>
替换为：
<artifactId>jeesite-cloud-module-test3-client</artifactId>
```

2）修改 application.yml 中的应用名：

```yml
spring:
  application:
    name: jeesite-cloud-module-test3
```

3）修改 *Client.java 里的应用名：

```
service.test1 替换为 service.test3
```

4）修改 *Controller.java 里的映射路径：

```
${adminPath}/test1 替换为 ${adminPath}/test3
```

### 2、配置服务参数

在 jeesite-config 或 Nacos 的微服务配置文件 application.yml 中，新增微服务：

```yml
# 微服务列表
service:
  test3:
    name: jeesite-cloud-module-test3
    path: ${server.servlet.context-path}
```

### 3、配置网关映射

在 jeesite-cloud-gateway 配置文件中新增网关路由

```yml
spring:
  cloud:
    gateway:
      routes:
        # 测试模块3
        - id: test3
          uri: lb://jeesite-cloud-module-test3
          predicates:
            - Path=/js/a/test3/**,/js/a/jeesite-cloud-module-test3/**,/js/static/modules/test3/**
```
注意：新增的配置请放到 core 基础权限模块之上。

## 微服务增删改查

进入 “代码生成器” 菜单，同单机版使用方法，只需在生成代码时，选择 Cloud 版本的生成模板即可。


## 授权协议声明

1. 基于 Apache License Version 2.0 协议发布，但必须遵守以下补充条款。
2. 不得将本软件应用于危害国家安全、荣誉和利益的行为，不能以任何形式用于非法为目的的行为。
3. 在延伸的代码中（修改和有源代码衍生的代码中）需要带有原来代码中的协议、版权声明和其他原作者
   规定需要包含的说明（请尊重原作者的著作权，不要删除或修改文件中的`Copyright`和`@author`信息）
   更不要，全局替换源代码中的 jeesite 或 ThinkGem 等字样，否则你将违反本协议条款承担责任。
4. 您若套用本软件的一些代码或功能参考，请保留源文件中的版权和作者，需要在您的软件介绍明显位置
   说明出处，举例：本软件基于 JeeSite 快速开发平台，并附带链接：http://jeesite.com
5. 任何基于本软件而产生的一切法律纠纷和责任，均于我司无关。
6. 如果你对本软件有改进，希望可以贡献给我们，共同进步。
7. 本项目已申请软件著作权，请尊重开源，感谢阅读。
8. 本项目仅用于学习和交流，不能用到正式环境。

### 获得技术服务支持：<http://s.jeesite.com>

* 我们深知，没有资金的支撑就很难得到发展，特别是一个好的产品，如果 JeeSite 帮助了您，请为我们点赞。支持我们，您可以得到一些回报，有了这些我们会把开源事业做的更好，回报社区和社会，请给我们一些动力吧，在此非常感谢已支持我们的朋友！

# 技术交流方式

* QQ 群号：`127515876`、`209330483`、`223507718`、`709534275`、`730390092`、`1373527`、`183903863(外包)`
* 问题反馈：<https://gitee.com/thinkgem/jeesite4-cloud/issues> 　[【新手必读】](http://www.dianbo.org/9238/stone/tiwendezhihui.htm)
* 码云Gitee：<https://gitee.com/thinkgem/jeesite4-cloud>
* GitHub：<https://github.com/thinkgem/jeesite4-cloud>
* 作者博客：<https://my.oschina.net/thinkgem>
* 官方网站：<http://jeesite.com>
* 官方论坛：<http://jeesite.net>
* 微信公众号：

![JeeSite4微信公众号](https://images.gitee.com/uploads/images/2020/0120/235836_3018847b_6732.jpeg "JeeSite4微信公众号")

# Git 全局设置技巧

```
1、提交检出均不转换换行符

git config --global core.autocrlf false

2、拒绝提交包含混合换行符的文件

git config --global core.safecrlf true
```