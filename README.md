## 说明
在根目录执行mvn eclipse将项目转成eclipse项目，或者使用ideal导入项目
项目使用的是spring mvc框架+JDBC+mysql ，IDE是ideal        

需要在本地数据库建立两张表，建表语句分别为   
<code>      
  CREATE TABLE `user` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(1024) NOT NULL,
  `balance` BIGINT NOT NULL default 0,
  PRIMARY KEY (`id`));

  CREATE TABLE `relation` (
  `id` BIGINT NOT NULL,
  `from_user_id`BIGINT NOT NULL,
  `to_user_id`BIGINT NOT NULL,
  `balance` BIGINT NOT NULL ,
  PRIMARY KEY (`id`));</code>       


将如下mysql配置文件
WEB-INF/common/mysql-config.xml    
中的      
<code>jdbc:mysql://localhost:3306/demo</code>
替换成本地数据库，其中'demo'是我在本地建立的数据库名，并将该配置文件的username和password替换成本地数据库的配置        





