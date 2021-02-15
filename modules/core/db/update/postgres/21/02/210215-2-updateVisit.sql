alter table PETCLININC_VISIT add column DURATION integer ^
update PETCLININC_VISIT set DURATION = 0 where DURATION is null ;
alter table PETCLININC_VISIT alter column DURATION set not null ;
