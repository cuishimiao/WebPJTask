/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/12/9 22:24:14                           */
/*==============================================================*/


drop table if exists category;

drop table if exists good_article;

drop table if exists post_article;

drop table if exists reply_article;

drop table if exists request_article;

drop table if exists user;

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category
(
   category_id          int not null auto_increment,
   category_name        varchar(20) not null,
   primary key (category_id)
)
charset = UTF8;

/*==============================================================*/
/* Table: good_article                                          */
/*==============================================================*/
create table good_article
(
   id                   int not null auto_increment,
   article_id           int,
   primary key (id)
)charset = UTF8;;

/*==============================================================*/
/* Table: post_article                                          */
/*==============================================================*/
create table post_article
(
   article_id           int not null auto_increment,
   author_id            varchar(20) not null,
   title                varchar(20),
   content              text,
   create_time          timestamp,
   category_id          int,
   article_top          int,
   primary key (article_id)
)
charset = UTF8;

/*==============================================================*/
/* Table: reply_article                                         */
/*==============================================================*/
create table reply_article
(
   article_id           numeric(10,0),
   responder_id         numeric(10,0),
   context              text,
   reply_time           timestamp,
   id                   int not null auto_increment,
   primary key (id)
)
charset = UTF8;

/*==============================================================*/
/* Table: request_article                                       */
/*==============================================================*/
create table request_article
(
   id                   int not null auto_increment,
   user_id              numeric(10,0),
   content              text,
   create_time          timestamp,
   primary key (id)
)
charset = UTF8;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              int not null auto_increment,
   username             varchar(20) not null,
   password             varchar(20) not null,
   email                varchar(20) not null,
   phone                varchar(20),
   work                 varchar(20),
   address              varchar(20),
   is_admin             varchar(20),
   primary key (user_id)
)
charset = UTF8;

alter table good_article add constraint FK_Reference_8 foreign key (article_id)
      references post_article (article_id) on delete restrict on update restrict;

alter table post_article add constraint FK_Reference_1 foreign key (author_id)
      references user (user_id) on delete restrict on update restrict;

alter table post_article add constraint FK_Reference_2 foreign key (category_id)
      references category (category_id) on delete restrict on update restrict;

alter table reply_article add constraint FK_Reference_5 foreign key (article_id)
      references post_article (article_id) on delete restrict on update restrict;

alter table reply_article add constraint FK_Reference_6 foreign key (responder_id)
      references user (user_id) on delete restrict on update restrict;

alter table request_article add constraint FK_Reference_7 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

