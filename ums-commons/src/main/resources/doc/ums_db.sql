-- 创建并使用数据库：ums_db
drop database if exists ums_db;
create database ums_db character set utf8mb4;
use ums_db;

-- 创建用户信息表：sys_user
drop table if exists sys_user;
create table sys_user(
                         id int(10) not null auto_increment comment '主键',
                         name varchar(255) comment '用户姓名',
                         cellphone varchar(100) not null comment '手机号码',
                         password varchar(500) not null comment '登录密码，使用 MD5 加密',
                         avatar varchar(500) comment '头像',
                         createTime timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
                         updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
                         primary key (id)
)Engine=InnoDB charset=utf8mb4 comment='用户信息表';