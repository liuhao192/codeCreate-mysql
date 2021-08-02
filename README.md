# Mysql-MybatisPlus代码生成器
使用jdbc+freemarker实现业务代码生成器
功能说明： 一键生成的代码（包括：controller、service、mapper、entity）

### 功能模块

```
  '        |-- java',
  '        |   |-- ren',
  '        |       |-- kura',
  '        |           |-- config',
  '        |           |   |-- OutPathConfig.java',     输出文件的配置类
  '        |           |-- core',				
  '        |           |   |-- codemake',
  '        |           |   |   |-- CodeMake.java',      生成代码主要类
  '        |           |   |-- constants',              读取ftl路径的静态变量目录
  '        |           |   |-- dto',										替换信息类目录
  '        |           |   |-- enums',                  生成类型文件的枚举目录
  '        |           |   |-- utils',                  工具类（生成文件、mysql查询、驼峰转换）
  '        |           |-- create',
  '        |               |-- MysqlCodeCreate.java',   主启动类
  '        |-- resources',
  '        |   |-- create_info.properties',             配置文件
  '        |   |-- make',	                        ftl配置文件目录
  '        |-- out',                                默认输出目录
```

## 开发环境

- 语言：Java 11
- IDE(JAVA)： IDEA 安装lombok插件
- 依赖管理：Maven 3.8.1
- 数据库：MySQL 8.0

#### 依赖包

- 模版文件：freemarker 2.3.31
- JDBC：mysql-connector-java 8.0.21
- 其他：lombok 1.18.16、commons-lang3 3.11

## 流程图

 ![image-20210801184529968](https://www.kura.ren/upload/2021/08/image-20210801184529968-5736ce5323fc46679d06bc6c65ef25c4.png)

### 技术文档 
[项目工具:使用freemarker实现业务代码生成器](https://www.kura.ren/archives/codecreate)








