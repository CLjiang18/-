/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/11/12 10:10:38                          */
/*==============================================================*/


drop table if exists contract;

drop table if exists customer;

drop table if exists dept;

drop table if exists houses;

drop table if exists lookhouse;

drop table if exists lookhouse2;

drop table if exists menu;

drop table if exists owner;

drop table if exists rentals;

drop table if exists rentinfo;

drop table if exists repair;

drop table if exists role;

drop table if exists role_menu;

drop table if exists user;

drop table if exists user_role;

/*==============================================================*/
/* Table: contract                                              */
/*==============================================================*/
create table contract
(
   id                   int(10) not null auto_increment,
   houses_id            int(10),
   customer_id          datetime comment '0 ����Ů
            1 ������',
   money                double(5,2),
   qzrq                 datetime comment '����ʱ��',
   tzrq                 datetime comment '����ʱ��',
   create_time          datetime,
   paymoney             varchar(200),
   djr                  varchar(20) comment '�Ǽ���',
   update_time          datetime,
   xgr                  varchar(20),
   rent_id              int(10),
   primary key (id)
);

alter table contract comment '��ͬ��Ϣ��';

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer
(
   id                   int not null auto_increment,
   identity             varchar(20),
   custname             varchar(20),
   password             varchar(20),
   sex                  varchar(20) comment '0 ����Ů1 ������',
   address              varchar(120),
   phone                varchar(20),
   career               varchar(20),
   remarks              varchar(200),
   create_time          datetime,
   djr                  varchar(20) comment '�Ǽ���',
   update_time          datetime,
   xgr                  varchar(20),
   primary key (id)
);

alter table customer comment '�⻧��Ϣ��';

/*==============================================================*/
/* Table: dept                                                  */
/*==============================================================*/
create table dept
(
   id                   int not null auto_increment,
   parent_id            int(20),
   name                 varchar(20),
   type                 int(10),
   sort                 int(10) comment '0 ����Ů
            1 ������',
   status               int(10),
   create_time          datetime,
   create_by            varchar(20),
   update_time          datetime,
   primary key (id)
);

alter table dept comment '������Ϣ��';

/*==============================================================*/
/* Table: houses                                                */
/*==============================================================*/
create table houses
(
   id                   int not null auto_increment,
   numbers              varchar(20) comment '���ݱ��',
   owner_id             int(10) comment '����id',
   address              varchar(200),
   area                 double(5,2),
   imgs                 varchar(200),
   province             intvarchar(200),
   city                 varchar(200),
   county               varchar(200),
   price                double(5,2) comment '0 ����Ů
            1 ������',
   status               int(10) comment '0 δ����1����',
   remarks              varchar(200),
   create_time          datetime,
   create_by            varchar(20) comment '������',
   update_time          datetime,
   primary key (id)
);

alter table houses comment '������Ϣ����';

/*==============================================================*/
/* Table: lookhouse                                             */
/*==============================================================*/
create table lookhouse
(
   id                   int(10) not null auto_increment,
   houses_id            int(10),
   customer_id          int(10),
   look_date            datetime,
   remarks              varchar(200),
   date                 datetime,
   djr                  varchar(20),
   update_time          datetime,
   xgr                  varchar(20),
   stutas               int(2) comment '0 δ����1 �ѿ���',
   primary key (id)
);

alter table lookhouse comment '������Ϣ��';

/*==============================================================*/
/* Table: lookhouse2                                            */
/*==============================================================*/
create table lookhouse2
(
   id                   int(10) not null auto_increment,
   remarks              varchar(200),
   date                 datetime,
   djr                  varchar(20),
   primary key (id)
);

alter table lookhouse2 comment '������Ϣ��';

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   id                   int not null auto_increment,
   parent_id            int(10),
   name                 varchar(20),
   type                 int(10),
   sort                 int(10) comment '0 ����Ů
            1 ������',
   status               int(10),
   url                  varchar(20),
   permission           varchar(20),
   icon                 varchar(20),
   create_time          datetime,
   create_by            varchar(20),
   update_time          datetime,
   primary key (id)
);

alter table menu comment '�˵���Ϣ��';

/*==============================================================*/
/* Table: owner                                                 */
/*==============================================================*/
create table owner
(
   id                   int not null auto_increment,
   identity             varchar(20) comment '���֤����',
   custname             varchar(20) comment '��������',
   sex                  varchar(20) comment '0 ����Ů
            1 ������',
   address              varchar(120),
   phone                varchar(20),
   career               varchar(20) comment 'ְҵ',
   remarks              varchar(200),
   create_time          datetime,
   djr                  varchar(20) comment '�Ǽ���',
   primary key (id)
);

alter table owner comment '������Ϣ��';

/*==============================================================*/
/* Table: rentals                                               */
/*==============================================================*/
create table rentals
(
   id                   int(10) not null auto_increment,
   houses_id            int(10),
   customer_id          int(10),
   money                int(5),
   address2             varchar(200),
   ksrq                 datetime comment '��ʼ����',
   jzrq                 datetime comment '��������',
   jfr                  varchar(200) comment '��𽻸���',
   remarks              varchar(200),
   date                 datetime,
   djr                  varchar(20),
   update_time          datetime,
   xgr                  varchar(20),
   primary key (id)
);

alter table rentals comment '������Ϣ��';

/*==============================================================*/
/* Table: rentinfo                                              */
/*==============================================================*/
create table rentinfo
(
   id                   int(10) not null auto_increment,
   houses_id            int(10),
   customer_id          int(10),
   contract_id          int(10),
   address              varchar(200),
   remarks              varchar(200),
   create_time          datetime,
   djr                  varchar(20),
   update_time          datetime,
   xgr                  varchar(20),
   status               int(2),
   primary key (id)
);

alter table rentinfo comment '������Ϣ��';

/*==============================================================*/
/* Table: repair                                                */
/*==============================================================*/
create table repair
(
   id                   int(10) not null auto_increment,
   houses_id            int(10),
   customer_id          int(10),
   content              varchar(200),
   address              varchar(200),
   remarks              varchar(200),
   name                 varchar(20),
   date                 datetime comment '�Ǽ�ʱ��',
   djr                  varchar(20),
   update_time          datetime,
   xgr                  varchar(20),
   status               int(2) comment '0 δ�޸�1 �Ѿ���',
   primary key (id)
);

alter table repair comment '������Ϣ��';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   int not null auto_increment,
   parent_id            int(10),
   name                 varchar(20),
   type                 int(10),
   sort                 int(10) comment '0 ����Ů
            1 ������',
   status               int(10),
   remarks              varchar(200),
   create_time          datetime,
   create_by            varchar(20),
   update_time          datetime,
   primary key (id)
);

alter table role comment '��ɫ��Ϣ��';

/*==============================================================*/
/* Table: role_menu                                             */
/*==============================================================*/
create table role_menu
(
   id                   int not null auto_increment,
   menu_id              int(10),
   role_id              int(10),
   primary key (id)
);

alter table role_menu comment '��ɫ�˵�������';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null auto_increment,
   dept_id              int(10),
   username             varchar(20),
   password             varchar(20) comment '0 ����Ů
            1 ������',
   realname             varchar(120),
   sex                  varchar(20),
   tel                  varchar(20),
   email                varchar(20),
   avatar               varchar(20),
   job_title            varchar(20),
   status               int(10),
   sort                 int(10),
   del_flag             int,
   create_by            varchar(20),
   update_time          datetime,
   create_time          datetime,
   primary key (id)
);

alter table user comment '�û���Ϣ��';

/*==============================================================*/
/* Table: user_role                                             */
/*==============================================================*/
create table user_role
(
   id                   int(10) not null auto_increment,
   user_id              int(10),
   role_id              int(10),
   create_by            varchar(20),
   update_time          datetime,
   primary key (id)
);

alter table user_role comment '�û���ɫ������';

