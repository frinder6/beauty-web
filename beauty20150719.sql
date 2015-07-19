/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/7/19 17:30:08                           */
/*==============================================================*/


drop table if exists beauty_authority;

drop table if exists beauty_authority_resource;

drop table if exists beauty_menu;

drop table if exists beauty_resource;

drop table if exists beauty_role;

drop table if exists beauty_role_authority;

drop table if exists beauty_user;

drop table if exists beauty_user_extra;

drop table if exists beauty_user_role;

/*==============================================================*/
/* Table: beauty_authority                                      */
/*==============================================================*/
create table beauty_authority
(
   id                   bigint not null auto_increment,
   code                 varchar(50) not null default '',
   name                 varchar(100) not null default '',
   group_id             bigint not null default '0',
   type                 tinyint not null default '2' comment '区分菜单权限与资源权限，1：菜单  2：资源',
   remark               varchar(200) not null default '',
   create_time          datetime not null default '1980-01-01 00:00:00',
   creater              varchar(50) not null default 'admin',
   last_update_time     datetime not null default '1980-01-01 00:00:00',
   modifier             varchar(50) not null default 'admin',
   is_deleted           tinyint not null default '1' comment '是否有效，1：有效， 0：无效',
   def1                 varchar(50) not null default '',
   def2                 varchar(50) not null default '',
   def3                 datetime not null default '1980-01-01 00:00:00',
   primary key (id)
);

alter table beauty_authority comment '系统权限表';

/*==============================================================*/
/* Table: beauty_authority_resource                             */
/*==============================================================*/
create table beauty_authority_resource
(
   id                   bigint not null auto_increment,
   authority_id         bigint not null comment '权限id',
   resource_id          bigint not null comment '菜单/资源id',
   primary key (id)
);

alter table beauty_authority_resource comment '一个权限可以对应多个菜单或资源';

/*==============================================================*/
/* Table: beauty_menu                                           */
/*==============================================================*/
create table beauty_menu
(
   id                   bigint not null auto_increment,
   code                 varchar(50) not null default '',
   name                 varchar(100) not null default '',
   url                  varchar(200) not null default '',
   parent_id            bigint not null default '0',
   level                tinyint not null default '0',
   group_id             bigint not null default '0',
   remark               varchar(200) not null default '',
   create_time          datetime not null default '1980-01-01 00:00:00',
   creater              varchar(50) not null default 'admin',
   last_update_time     datetime not null default '1980-01-01 00:00:00',
   modifier             varchar(50) not null default 'admin',
   is_deleted           tinyint not null default '1' comment '是否有效，1：有效， 0：无效',
   def1                 varchar(50) not null default '',
   def2                 varchar(50) not null default '',
   def3                 datetime not null default '1980-01-01 00:00:00',
   primary key (id)
);

alter table beauty_menu comment '系统菜单表';

/*==============================================================*/
/* Table: beauty_resource                                       */
/*==============================================================*/
create table beauty_resource
(
   id                   bigint not null auto_increment,
   code                 varchar(50) not null default '',
   name                 varchar(100) not null default '',
   url                  varchar(200) not null default '',
   group_id             bigint not null default '0',
   remark               varchar(200) not null default '',
   create_time          datetime not null default '1980-01-01 00:00:00',
   creater              varchar(50) not null default 'admin',
   last_update_time     datetime not null default '1980-01-01 00:00:00',
   modifier             varchar(50) not null default 'admin',
   is_deleted           tinyint not null default '1' comment '是否有效，1：有效， 0：无效',
   def1                 varchar(50) not null default '',
   def2                 varchar(50) not null default '',
   def3                 datetime not null default '1980-01-01 00:00:00',
   primary key (id)
);

alter table beauty_resource comment '系统资源表';

/*==============================================================*/
/* Table: beauty_role                                           */
/*==============================================================*/
create table beauty_role
(
   id                   bigint not null auto_increment,
   code                 varchar(50) not null default '',
   name                 varchar(100) not null default '',
   group_id             bigint not null default '0',
   remark               varchar(200) not null default '',
   create_time          datetime not null default '1980-01-01 00:00:00',
   creater              varchar(50) not null default 'admin',
   last_update_time     datetime not null default '1980-01-01 00:00:00',
   modifier             varchar(50) not null default 'admin',
   is_deleted           tinyint not null default '1' comment '是否有效，1：有效， 0：无效',
   def1                 varchar(50) not null default '',
   def2                 varchar(50) not null default '',
   def3                 datetime not null default '1980-01-01 00:00:00',
   primary key (id)
);

alter table beauty_role comment '系统角色表';

/*==============================================================*/
/* Table: beauty_role_authority                                 */
/*==============================================================*/
create table beauty_role_authority
(
   id                   bigint not null auto_increment,
   role_id              bigint not null comment '角色id',
   authority_id         bigint not null comment '权限id',
   primary key (id)
);

alter table beauty_role_authority comment '一个角色可以拥有多个权限';

/*==============================================================*/
/* Table: beauty_user                                           */
/*==============================================================*/
create table beauty_user
(
   id                   bigint not null auto_increment,
   account              varchar(50) not null default '',
   name                 varchar(100) not null default '',
   password             varchar(50) not null default '',
   gender               tinyint not null default '0' comment '0:保密，1:男，2:女',
   mobile               varchar(20) not null default '',
   email                varchar(50) not null default '',
   remark               varchar(200) not null default '',
   create_time          datetime not null default '1980-01-01 00:00:00',
   creater              varchar(50) not null default 'admin',
   last_update_time     datetime not null default '1980-01-01 00:00:00',
   modifier             varchar(50) not null default 'admin',
   is_deleted           tinyint not null default '1' comment '是否有效，1：有效， 0：无效',
   def1                 varchar(50) not null default '',
   def2                 varchar(50) not null default '',
   def3                 datetime not null default '1980-01-01 00:00:00',
   primary key (id)
);

alter table beauty_user comment '用户基本信息表';

/*==============================================================*/
/* Table: beauty_user_extra                                     */
/*==============================================================*/
create table beauty_user_extra
(
   id                   bigint not null auto_increment,
   user_id              bigint not null default '0',
   qq                   varchar(20) not null default '',
   wx_no                varchar(50) not null default '',
   address              varchar(100) not null default '',
   favor                varchar(50) not null default '',
   remark               varchar(200) not null default '',
   create_time          datetime not null default '1980-01-01 00:00:00',
   creater              varchar(50) not null default 'admin',
   last_update_time     datetime not null default '1980-01-01 00:00:00',
   modifier             varchar(50) not null default 'admin',
   is_deleted           tinyint not null default '1' comment '是否有效，1：有效， 0：无效',
   def1                 varchar(50) not null default '',
   def2                 varchar(50) not null default '',
   def3                 datetime not null default '1980-01-01 00:00:00',
   primary key (id)
);

/*==============================================================*/
/* Table: beauty_user_role                                      */
/*==============================================================*/
create table beauty_user_role
(
   id                   bigint not null auto_increment,
   user_id              bigint not null comment '用户id',
   role_id              bigint not null comment '角色id',
   primary key (id)
);

alter table beauty_user_role comment '一个用户对应多个角色';
