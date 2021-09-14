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
   customer_id          datetime comment '0 代表女
            1 代表男',
   money                double(5,2),
   qzrq                 datetime comment '起租时间',
   tzrq                 datetime comment '退租时间',
   create_time          datetime,
   paymoney             varchar(200),
   djr                  varchar(20) comment '登记人',
   update_time          datetime,
   xgr                  varchar(20),
   rent_id              int(10),
   primary key (id)
);

alter table contract comment '合同信息表';

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer
(
   id                   int not null auto_increment,
   identity             varchar(20),
   custname             varchar(20),
   password             varchar(20),
   sex                  varchar(20) comment '0 代表女1 代表男',
   address              varchar(120),
   phone                varchar(20),
   career               varchar(20),
   remarks              varchar(200),
   create_time          datetime,
   djr                  varchar(20) comment '登记人',
   update_time          datetime,
   xgr                  varchar(20),
   primary key (id)
);

alter table customer comment '租户信息表';

/*==============================================================*/
/* Table: dept                                                  */
/*==============================================================*/
create table dept
(
   id                   int not null auto_increment,
   parent_id            int(20),
   name                 varchar(20),
   type                 int(10),
   sort                 int(10) comment '0 代表女
            1 代表男',
   status               int(10),
   create_time          datetime,
   create_by            varchar(20),
   update_time          datetime,
   primary key (id)
);

alter table dept comment '部门信息表';

/*==============================================================*/
/* Table: houses                                                */
/*==============================================================*/
create table houses
(
   id                   int not null auto_increment,
   numbers              varchar(20) comment '房屋编号',
   owner_id             int(10) comment '房东id',
   address              varchar(200),
   area                 double(5,2),
   imgs                 varchar(200),
   province             intvarchar(200),
   city                 varchar(200),
   county               varchar(200),
   price                double(5,2) comment '0 代表女
            1 代表男',
   status               int(10) comment '0 未出租1出租',
   remarks              varchar(200),
   create_time          datetime,
   create_by            varchar(20) comment '创建人',
   update_time          datetime,
   primary key (id)
);

alter table houses comment '房屋信息管理';

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
   stutas               int(2) comment '0 未看房1 已看房',
   primary key (id)
);

alter table lookhouse comment '看房信息表';

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

alter table lookhouse2 comment '看房信息表';

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   id                   int not null auto_increment,
   parent_id            int(10),
   name                 varchar(20),
   type                 int(10),
   sort                 int(10) comment '0 代表女
            1 代表男',
   status               int(10),
   url                  varchar(20),
   permission           varchar(20),
   icon                 varchar(20),
   create_time          datetime,
   create_by            varchar(20),
   update_time          datetime,
   primary key (id)
);

alter table menu comment '菜单信息表';

/*==============================================================*/
/* Table: owner                                                 */
/*==============================================================*/
create table owner
(
   id                   int not null auto_increment,
   identity             varchar(20) comment '身份证号码',
   custname             varchar(20) comment '房东姓名',
   sex                  varchar(20) comment '0 代表女
            1 代表男',
   address              varchar(120),
   phone                varchar(20),
   career               varchar(20) comment '职业',
   remarks              varchar(200),
   create_time          datetime,
   djr                  varchar(20) comment '登记人',
   primary key (id)
);

alter table owner comment '房东信息表';

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
   ksrq                 datetime comment '开始日期',
   jzrq                 datetime comment '截至日期',
   jfr                  varchar(200) comment '租金交付人',
   remarks              varchar(200),
   date                 datetime,
   djr                  varchar(20),
   update_time          datetime,
   xgr                  varchar(20),
   primary key (id)
);

alter table rentals comment '收租信息表';

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

alter table rentinfo comment '租赁信息表';

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
   date                 datetime comment '登记时间',
   djr                  varchar(20),
   update_time          datetime,
   xgr                  varchar(20),
   status               int(2) comment '0 未修复1 已经修',
   primary key (id)
);

alter table repair comment '报修信息表';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   int not null auto_increment,
   parent_id            int(10),
   name                 varchar(20),
   type                 int(10),
   sort                 int(10) comment '0 代表女
            1 代表男',
   status               int(10),
   remarks              varchar(200),
   create_time          datetime,
   create_by            varchar(20),
   update_time          datetime,
   primary key (id)
);

alter table role comment '角色信息表';

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

alter table role_menu comment '角色菜单关联表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null auto_increment,
   dept_id              int(10),
   username             varchar(20),
   password             varchar(20) comment '0 代表女
            1 代表男',
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

alter table user comment '用户信息表';

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

alter table user_role comment '用户角色关联表';

