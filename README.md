科内特企业运营管理系统
=====
### 1.概述
内部运营除了系统管理和工作流模块,其他模块都后台数据都是通过API接口的方式去访问。

### 2.环境
tomcat,maven,jdk1.8

### 3.相关配置
1. 数据库配置  
数据库配置在resource/rapid-development.properties配置文件中.  
2. 微服务API模块添加到运维系统配置  
配置resource/moduleLinks.json文件添加对应模块和URL


