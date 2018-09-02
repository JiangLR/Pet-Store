/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/9/2 10:26:31                            */
/*==============================================================*/


drop table if exists appointment_info;

drop table if exists brands;

drop table if exists goods_info;

drop table if exists goods_order;

drop table if exists goods_order_r;

drop table if exists goods_race;

drop table if exists log_info;

drop table if exists master_info;

drop table if exists pet_info;

drop table if exists photos;

drop table if exists service_appointment_r;

drop table if exists service_race;

drop table if exists staff_info;

/*==============================================================*/
/* Table: appointment_info                                      */
/*==============================================================*/
create table appointment_info
(
   appointment_id       int not null auto_increment,
   pet_id               int,
   appointment_start    datetime not null,
   primary key (appointment_id)
);

/*==============================================================*/
/* Table: brands                                                */
/*==============================================================*/
create table brands
(
   brands_id            int not null auto_increment,
   brands_name          char(20) not null,
   primary key (brands_id)
);

/*==============================================================*/
/* Table: goods_info                                            */
/*==============================================================*/
create table goods_info
(
   goods_id             int not null auto_increment,
   brands_id            int,
   race_id              int,
   goods_name           char(50) not null,
   goods_price          float(10) not null,
   on_sale              float(10) not null,
   goods_barcode        char(20) not null,
   primary key (goods_id)
);

/*==============================================================*/
/* Table: goods_order                                           */
/*==============================================================*/
create table goods_order
(
   order_id             int not null auto_increment,
   master_id            int,
   order_num            int not null,
   order_price          float(10) not null,
   order_status         bool not null,
   primary key (order_id)
);

/*==============================================================*/
/* Table: goods_order_r                                         */
/*==============================================================*/
create table goods_order_r
(
   goods_order_id       int not null auto_increment,
   goods_id             int,
   order_id             int,
   primary key (goods_order_id)
);

/*==============================================================*/
/* Table: goods_race                                            */
/*==============================================================*/
create table goods_race
(
   race_id              int not null auto_increment,
   race_name            char(20) not null,
   race_describe        char(100),
   primary key (race_id)
);

/*==============================================================*/
/* Table: log_info                                              */
/*==============================================================*/
create table log_info
(
   log_id               int not null,
   staff_id             int,
   staff_in_time        datetime,
   staff_out_time       datetime,
   primary key (log_id)
);

/*==============================================================*/
/* Table: master_info                                           */
/*==============================================================*/
create table master_info
(
   master_id            int not null auto_increment,
   master_name          char(50) not null,
   master_sex           char(10) not null,
   master_tel           char(20) not null,
   master_mail          char(50),
   primary key (master_id)
);

/*==============================================================*/
/* Table: pet_info                                              */
/*==============================================================*/
create table pet_info
(
   pet_id               int not null auto_increment,
   master_id            int,
   pet_name             char(50) not null,
   pet_nickname         char(50),
   pet_sex              char(10),
   pet_race             char(20) not null,
   primary key (pet_id)
);

/*==============================================================*/
/* Table: photos                                                */
/*==============================================================*/
create table photos
(
   photo_id             int not null auto_increment,
   pet_id               int,
   img_src              char(100),
   primary key (photo_id)
);

/*==============================================================*/
/* Table: service_appointment_r                                 */
/*==============================================================*/
create table service_appointment_r
(
   service_appointment_id int not null auto_increment,
   appointment_id       int,
   service_id           int,
   finish_status        bool not null,
   finish_time          datetime,
   primary key (service_appointment_id)
);

/*==============================================================*/
/* Table: service_race                                          */
/*==============================================================*/
create table service_race
(
   service_id           int not null auto_increment,
   service_name         char(50) not null,
   service_describe     char(100),
   service_price        float(10) not null,
   primary key (service_id)
);

/*==============================================================*/
/* Table: staff_info                                            */
/*==============================================================*/
create table staff_info
(
   staff_id             int not null auto_increment,
   staff_name           char(50) not null,
   staff_rank           char(5) not null,
   staff_account        char(10) not null,
   staff_pwd            char(20) not null,
   primary key (staff_id)
);

alter table appointment_info add constraint FK_Reference_7 foreign key (pet_id)
      references pet_info (pet_id) on delete restrict on update restrict;

alter table goods_info add constraint FK_Reference_3 foreign key (brands_id)
      references brands (brands_id) on delete restrict on update restrict;

alter table goods_info add constraint FK_Reference_4 foreign key (race_id)
      references goods_race (race_id) on delete restrict on update restrict;

alter table goods_order add constraint FK_Reference_6 foreign key (master_id)
      references master_info (master_id) on delete restrict on update restrict;

alter table goods_order_r add constraint FK_Reference_10 foreign key (order_id)
      references goods_order (order_id) on delete restrict on update restrict;

alter table goods_order_r add constraint FK_Reference_9 foreign key (goods_id)
      references goods_info (goods_id) on delete restrict on update restrict;

alter table log_info add constraint FK_Reference_13 foreign key (staff_id)
      references staff_info (staff_id) on delete restrict on update restrict;

alter table pet_info add constraint FK_Reference_2 foreign key (master_id)
      references master_info (master_id) on delete restrict on update restrict;

alter table photos add constraint FK_Reference_1 foreign key (pet_id)
      references pet_info (pet_id) on delete restrict on update restrict;

alter table service_appointment_r add constraint FK_Reference_11 foreign key (appointment_id)
      references appointment_info (appointment_id) on delete restrict on update restrict;

alter table service_appointment_r add constraint FK_Reference_12 foreign key (service_id)
      references service_race (service_id) on delete restrict on update restrict;

