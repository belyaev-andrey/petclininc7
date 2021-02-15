-- begin PETCLININC_PET
create table PETCLININC_PET (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PET_TYPE_ID uuid not null,
    OWNER_ID uuid,
    --
    primary key (ID)
)^
-- end PETCLININC_PET
-- begin PETCLININC_VISIT
create table PETCLININC_VISIT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PET_ID uuid not null,
    VETERINARIAN_ID uuid not null,
    DATE_ timestamp not null,
    DURATION integer not null,
    DESCRIPTION text,
    AMOUNT decimal(19, 2),
    --
    primary key (ID)
)^
-- end PETCLININC_VISIT
-- begin PETCLININC_CONSUMABLE
create table PETCLININC_CONSUMABLE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TITLE varchar(255) not null,
    DESCRIPTION text,
    PRICE decimal(19, 2),
    --
    primary key (ID)
)^
-- end PETCLININC_CONSUMABLE
-- begin PETCLININC_PET_TYPE
create table PETCLININC_PET_TYPE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end PETCLININC_PET_TYPE
-- begin PETCLININC_OWNER
create table PETCLININC_OWNER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    EMAIL varchar(255) not null,
    PHONE_NO varchar(255),
    --
    primary key (ID)
)^
-- end PETCLININC_OWNER
-- begin PETCLININC_VETERINARIAN
create table PETCLININC_VETERINARIAN (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID uuid not null,
    HOURLY_RATE decimal(19, 2),
    --
    primary key (ID)
)^
-- end PETCLININC_VETERINARIAN
-- begin PETCLININC_VISIT_CONSUMABLE_LINK
create table PETCLININC_VISIT_CONSUMABLE_LINK (
    VISIT_ID uuid,
    CONSUMABLE_ID uuid,
    primary key (VISIT_ID, CONSUMABLE_ID)
)^
-- end PETCLININC_VISIT_CONSUMABLE_LINK
