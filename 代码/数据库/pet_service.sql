/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/8/31 15:08:51                           */
/*==============================================================*/


drop table if exists appointment_info;

drop table if exists brands;

drop table if exists goods_info;

drop table if exists goods_order;

drop table if exists goods_race;

drop table if exists master_info;

drop table if exists pet_info;

drop table if exists photos;

drop table if exists service_info;

drop table if exists staff_info;

/*==============================================================*/
/* Table: appointment_info                                      */
/*==============================================================*/
create table appointment_info
(
   appointment_id       int not null,
   pet_id               int not null,
   service_id           int not null,
   appointment_pet_id   int not null,
   appointment_start    date not null,
   appointment_finish   date not null,
   appointment_status   bool not null,
   primary key (appointment_id)
);

/*==============================================================*/
/* Table: brands                                                */
/*==============================================================*/
create table brands
(
   brands_id            int not null,
   brands_name          char(20) not null,
   primary key (brands_id)
);

/*==============================================================*/
/* Table: goods_info                                            */
/*==============================================================*/
create table goods_info
(
   goods_id             int not null,
   brands_id            int not null,
   race_id              int not null,
   goods_name           char(50) not null,
   goods_price          float(10) not null,
   goods_barcode        char(20) not null,
   primary key (goods_id)
);

/*==============================================================*/
/* Table: goods_order                                           */
/*==============================================================*/
create table goods_order
(
   order_id             int not null,
   goods_id             int not null,
   master_id            int not null,
   order_num            int not null,
   order_price          float(10) not null,
   order_status         bool not null,
   primary key (order_id)
);

/*==============================================================*/
/* Table: goods_race                                            */
/*==============================================================*/
create table goods_race
(
   race_id              int not null,
   race_name            char(20) not null,
   race_describe        char(100) not null,
   primary key (race_id)
);

/*==============================================================*/
/* Table: master_info                                           */
/*==============================================================*/
create table master_info
(
   master_id            int not null,
   master_name          char(50) not null,
   master_sex           char(10) not null,
   master_tel           char(20) not null,
   master_mail          char(50) not null,
   primary key (master_id)
);

/*==============================================================*/
/* Table: pet_info                                              */
/*==============================================================*/
create table pet_info
(
   pet_id               int not null,
   master_id            int not null,
   pet_name             char(50) not null,
   pet_nickname         char(50) not null,
   pet_sex              char(10) not null,
   pet_master           char(50) not null,
   pet_race             char(20) not null,
   primary key (pet_id)
);

/*==============================================================*/
/* Table: photos                                                */
/*==============================================================*/
create table photos
(
   photo_id             int not null,
   pet_id               int not null,
   img_src              char(100) not null,
   primary key (photo_id)
);

/*==============================================================*/
/* Table: service_info                                          */
/*==============================================================*/
create table service_info
(
   service_id           int not null,
   service_name         char(50) not null,
   service_price        float(10) not null,
   service_describe     char(100) not null,
   primary key (service_id)
);

/*==============================================================*/
/* Table: staff_info                                            */
/*==============================================================*/
create table staff_info
(
   staff_id             int not null,
   staff_name           char(50) not null,
   staff_rank           char(5) not null,
   staff_pw             char(20) not null,
   primary key (staff_id)
);

alter table appointment_info add constraint FK_Reference_7 foreign key (pet_id)
      references pet_info (pet_id) on delete restrict on update restrict;

alter table appointment_info add constraint FK_Reference_8 foreign key (service_id)
      references service_info (service_id) on delete restrict on update restrict;

alter table goods_info add constraint FK_Reference_3 foreign key (brands_id)
      references brands (brands_id) on delete restrict on update restrict;

alter table goods_info add constraint FK_Reference_4 foreign key (race_id)
      references goods_race (race_id) on delete restrict on update restrict;

alter table goods_order add constraint FK_Reference_5 foreign key (goods_id)
      references goods_info (goods_id) on delete restrict on update restrict;

alter table goods_order add constraint FK_Reference_6 foreign key (master_id)
      references master_info (master_id) on delete restrict on update restrict;

alter table pet_info add constraint FK_Reference_2 foreign key (master_id)
      references master_info (master_id) on delete restrict on update restrict;

alter table photos add constraint FK_Reference_1 foreign key (pet_id)
      references pet_info (pet_id) on delete restrict on update restrict;

