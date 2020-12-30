# BookManagementSystem（数据库综合实验的图书管理系统)

最近在做数据库综合实验的大作业需要设计一个项目，由于时间紧迫便在GitHub上拉取了一个图书管理项目，但是这个图书管理项目的代码冗余，ssm框架用得很混乱，业务逻辑实现以及控制层的书写实在是让本人抓狂，特别是jsp页面的书写，没有进行分块开发，特别混乱，因此本人花了一天多时间对该项目进行了重新架构，去掉沉冗，使得项目更加清晰明了，并且在原来项目的基础上增加了分页功能，对每次查询进行分页操作，减轻服务器的查询压力，同时采用了[adminlte](https://adminlte.io/)模板对jsp页面进行适配，大大减少了沉冗的代码，使得二次开发更加容易。**本项目基于GitHub开源的原有项目：[图书馆管理系统](https://github.com/zhanghuanhao/LibrarySystem)基础上修改而来**。感兴趣的可以去原作者GitHub上看看。

## 1.功能需求：

**管理员登录：读者管理，图书管理，借阅卡管理，借阅记录管理，对这些操作的增删查改，使用分页展示数据。**

**读者登录：个人管理，图书搜索，图书分类，还书记录，借书记录，借还记录，借阅，还书，使用分页展示。**

## 2.数据库设计：

共有6个表：

#### 1. 图书书目表book_info

| 名           | 类型    | 长度 | 小数点 | NULL | 用途     | 键   |
| ------------ | ------- | ---- | ------ | ---- | -------- | ---- |
| book_id      | bigint  | 20   | 0      | 否   | 图书号   | ✔    |
| name         | varchar | 20   | 0      | 否   | 书名     |      |
| author       | varchar | 15   | 0      | 否   | 作者     |      |
| publish      | varchar | 20   | 0      | 否   | 出版社   |      |
| ISBN         | varchar | 15   | 0      | 否   | 标准书号 |      |
| introduction | text    | 0    | 0      | 是   | 简介     |      |
| language     | varchar | 4    | 0      | 否   | 语言     |      |
| price        | decimal | 10   | 2      | 否   | 价格     |      |
| pub_date     | date    | 0    | 0      | 否   | 出版时间 |      |
| class_id     | int     | 11   | 0      | 是   | 分类号   |      |
| number       | int     | 11   | 0      | 是   | 剩余数量 |      |

#### 2. 数据库管理员表admin

| 名       | 类型    | 长度 | 小数点 | NULL | 用途   | 键   |
| -------- | ------- | ---- | ------ | ---- | ------ | ---- |
| admin_id | bigint  | 20   | 0      | 否   | 账号   | ✔    |
| password | varchar | 15   | 0      | 否   | 密码   |      |
| username | varchar | 15   | 0      | 是   | 用户名 |      |

#### 3. 图书分类表class_info

| 名         | 类型    | 长度 | 小数点 | NULL | 用途   | 键   |
| ---------- | ------- | ---- | ------ | ---- | ------ | ---- |
| class_id   | int     | 11   | 0      | 否   | 类别号 | ✔    |
| class_name | varchar | 15   | 0      | 否   | 类别名 |      |

#### 4. 借阅信息表lend_list

| 名        | 类型   | 长度 | 小数点 | NULL | 用途     | 键   |
| --------- | ------ | ---- | ------ | ---- | -------- | ---- |
| ser_num   | bigint | 20   | 0      | 否   | 流水号   | ✔    |
| book_id   | bigint | 20   | 0      | 否   | 图书号   |      |
| reader_id | bigint | 20   | 0      | 否   | 读者证号 |      |
| lend_date | date   | 0    | 0      | 是   | 借出日期 |      |
| back_date | date   | 0    | 0      | 是   | 归还日期 |      |

#### 5. 借阅卡信息表reader_card

| 名        | 类型    | 长度 | 小数点 | NULL | 用途     | 键   |
| --------- | ------- | ---- | ------ | ---- | -------- | ---- |
| reader_id | bigint  | 20   | 0      | 否   | 读者证号 | ✔    |
| password  | varchar | 15   | 0      | 否   | 密码     |      |
| username  | varchar | 15   | 0      | 是   | 用户名   |      |

#### 6. 读者信息表reader_info

| 名        | 类型    | 长度 | 小数点 | NULL | 用途     | 键   |
| --------- | ------- | ---- | ------ | ---- | -------- | ---- |
| reader_id | bigint  | 20   | 0      | 否   | 读者证号 | ✔    |
| name      | varchar | 10   | 0      | 否   | 姓名     |      |
| sex       | varchar | 2    | 0      | 否   | 性别     |      |
| birth     | date    | 0    | 0      | 否   | 生日     |      |
| address   | varchar | 50   | 0      | 否   | 地址     |      |
| phone     | varchar | 15   | 0      | 否   | 电话     |      |







### 2.1管理员：

```
CREATE TABLE `admin` (
  `admin_id` bigint(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `username` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


```

### 2.2图书信息：

```
CREATE TABLE `book_info` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `author` varchar(15) NOT NULL,
  `publish` varchar(20) NOT NULL,
  `ISBN` varchar(15) NOT NULL,
  `introduction` text,
  `language` varchar(4) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `pub_date` date NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;


```

### 2.3图书分类：

```
CREATE TABLE `class_info` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(15) NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


```

### 2.4借书记录：

```
CREATE TABLE `lend_list` (
  `ser_num` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_id` bigint(20) NOT NULL,
  `reader_id` bigint(20) NOT NULL,
  `lend_date` date DEFAULT NULL,
  `back_date` date DEFAULT NULL,
  PRIMARY KEY (`ser_num`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;


```

### 2.5借书卡：

```
CREATE TABLE `reader_card` (
  `reader_id` bigint(20) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`reader_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


```

### 2.6读者信息：

```
CREATE TABLE `reader_info` (
  `reader_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `birth` date NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  PRIMARY KEY (`reader_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10012 DEFAULT CHARSET=utf8;


```

### 3.使用的框架

### 3.1后端：SSM（Spring+SpringMVC+mybatis）

### 3.2前端：boostrap+adminlte模板

## 4.页面展示分析



![image-20201230113128537](E:\JavaWorkSpace\idea-workspace\booksystem1\readmeimages\image-20201230113128537.png)

![image-20201230113258554](E:\JavaWorkSpace\idea-workspace\booksystem1\readmeimages\image-20201230113258554.png)

**基于[adminlte](https://adminlte.io/)二次开发，如想再次基础上再开发，可参考具体的模板。**真正开发的时候只需要开发body模块即可。



## 5.已经实现的功能

### 5.1管理员![image-20201230113816403](E:\JavaWorkSpace\idea-workspace\booksystem1\readmeimages\image-20201230113816403.png)



![image-20201230120804530](E:\JavaWorkSpace\idea-workspace\booksystem1\readmeimages\image-20201230120804530.png)



![image-20201230120836685](E:\JavaWorkSpace\idea-workspace\booksystem1\readmeimages\image-20201230120836685.png)

![image-20201230120918230](E:\JavaWorkSpace\idea-workspace\booksystem1\readmeimages\image-20201230120918230.png)



![image-20201230120942570](E:\JavaWorkSpace\idea-workspace\booksystem1\readmeimages\image-20201230120942570.png)







### 5.2用户

![image-20201230114158669](E:\JavaWorkSpace\idea-workspace\booksystem1\readmeimages\image-20201230114158669.png)

![image-20201230121042190](E:\JavaWorkSpace\idea-workspace\booksystem1\readmeimages\image-20201230121042190.png)



![image-20201230121135810](E:\JavaWorkSpace\idea-workspace\booksystem1\readmeimages\image-20201230121135810.png)

### 5.3登录

![image-20201230114243150](E:\JavaWorkSpace\idea-workspace\booksystem1\readmeimages\image-20201230114243150.png)

管理者账号：123456/123456 

读者账号：10000/123456 

由于时间紧迫尚未增加退出登录功能。这个功能也简单，感兴趣的的可以自己实现试试。

## 6.项目运行

### 6.1环境

idea2020，Tomcat8，maven3.6，MySQL8，druid数据库连接池，本人jdk11,也可以使用jdk8，在 pom.xml中修改为1.8即可
![image-20201230123651977](E:\JavaWorkSpace\idea-workspace\booksystem1\readmeimages\image-20201230123651977.png)

### 6.2这是一个基于maven管理的项目，拉取项目到本地后导入项目到idea

```
git clone https://github.com/LJF2402901363/BookManagementSystem.git
```

然后配置Tomcat
![image-20201230122827584](E:\JavaWorkSpace\idea-workspace\booksystem1\readmeimages\image-20201230122827584.png)

### 6.3在Navicat或者其他数据库客户端中首先新建一个Library数据库，然后导入项目中libray.sql文件即可。

如果你新建的数据库名字 不是library，那么请修改druid.properties文件中的配置：

![image-20201230123510084](E:\JavaWorkSpace\idea-workspace\booksystem1\readmeimages\image-20201230123510084.png)

#### 6.4启动Tomcat进入登录页面