# freshDay-Market
## 介绍：
This is an online shopping fresh food Market.<br>
本项目以天天生鲜购物系统为主题，主要结构参尚硅谷的gulimall项目<br>
主要后端采用 Spirngboot 2.3.1.RELEASE，前端使用Vue.js。

## 技术栈：
    JavaSe
    Springboot
    Mysql
    Vue
    阿里云oss
    Springcloud ： nacos , openfeign ， gateway 等

## 软件架构：
天天生鲜超市购物系统的设计与开发采用分布式技术，整个系统分为Common、Member、Product、Cart、Order、Auth、TraceSource和Gateway八大模块，并通过SpringCloud Feign进行远程调用来进行多种组合和实现系统功能。模块设计具体如下：
1.Freshday-common：存放各模块共需的共有包，其中包括共同的依赖，常量，统一异常处理，一些工具类等，供其他模块引入使用。<br>
2.Freshday-member：提供用户管理的相关服务。<br>
3.Freshday-product：提供包括商品的增删改查、上下架、详情等在内的商品服务。<br>
4.Freshday-cart：提供购物车管理的相关服务。<br>
5.Freshday-order：提供订单管理的相关服务。<br>
6.Freshday-auth-server：提供中央认证服务，包括用户的注册和登录。<br>
7.Freshday-traceSource：提供区块链管理中溯源管理的相关服务。<br>
8.Freshday-gateway：提供网关服务 , 进行服务转发和负载均衡。
## 安装教程：
    1.确保安装环境，安装node-js v10.2.4 以上，安装地址 http://nodejs.cn/
    2.安装git 版本控制 https://gitforwindows.org/
    3.安装mysql5.7 https://www.mysql.com/
    4.git终端 下载项目 git clone https://github.com/HaoliangZhou/freshDay-Market.git
    5.使用 IDEA 或者 Eclipse 进行打开 Eclipse安装地址 https://www.eclipse.org/ IDEA安装地址 https://www.jetbrains.com/idea/
    6.建数据库。
## 使用教程
    1.导入sql文件（sql文件放在每一个微服务的resource文件下的sql文件架中）
    2.修改各微服务的 application.yml 文件对应自己的数据库地址和数据库名称，用户，密码
    3.安装nacos，并在application.yml 中配置nacos的注册地址，启动nacos
    4.修改application.yml 将其修改为自己的。
    5.启动上述各个微服务。
    6.前端服务在 https://github.com/HaoliangZhou/freshDay-Market-VUE.git
    7.进入安装目录，在终端使用命令
    8.npm run dev
    9.项目启动成功，访问 localhost:8001
