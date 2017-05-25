--Drops

drop table users1;
drop table announcements;
drop table meetings;
drop table users;
drop table realEstates;
drop table realEstates_types;
drop table zone;
/

--Table for import users_data
  CREATE TABLE "USERS1" 
   (	"ID" NUMBER(10,0), 
	"NAME" VARCHAR2(255 BYTE), 
	"USERNAME" VARCHAR2(255 BYTE), 
	"USER_ROLE" VARCHAR2(255 BYTE), 
	"CREATED_AT" TIMESTAMP (6), 
	"UPDATED_AT" TIMESTAMP (6)
   );
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (232,'Alexandra Citea','alexandra.citea','user',to_timestamp('18-OCT-16 02.14.36.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 02.14.36.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (234,'Mihaela Lazar','mihaela.lazar','user',to_timestamp('18-OCT-16 02.31.33.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 02.31.33.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (238,'Valentin Damoc','valentin.damoc','user',to_timestamp('18-OCT-16 02.42.43.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('15-NOV-16 04.29.43.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (239,'Andreea Ghergu','andreea.ghergu','user',to_timestamp('18-OCT-16 02.43.41.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 02.43.41.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (240,'Alexandru Vlad','alexandru.vlad','user',to_timestamp('18-OCT-16 02.47.10.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 02.47.10.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (241,'Cosmin Chiriac','cosmin.chiriac','user',to_timestamp('18-OCT-16 02.53.09.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 02.53.09.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (242,'Eduard Tuduri','eduard.tuduri','user',to_timestamp('18-OCT-16 02.54.35.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 02.54.35.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (243,'Camelia Macariu','camelia.macariu','user',to_timestamp('18-OCT-16 02.55.08.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 02.55.08.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (244,'Adina Ababei','adina.ababei','user',to_timestamp('18-OCT-16 03.00.24.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 03.00.24.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (245,'Ema Balica','ema.balica','user',to_timestamp('18-OCT-16 03.00.33.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 03.00.33.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (246,'Victor Boca','victor.boca','user',to_timestamp('18-OCT-16 03.06.31.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 03.06.31.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (247,'Breaban Mihaela','pmihaela','admin',to_timestamp('18-OCT-16 03.10.51.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('31-OCT-16 07.59.10.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (248,'Alexandru Miron','alexandru.miron','user',to_timestamp('18-OCT-16 03.11.21.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 03.11.21.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (249,'Paula Carp','paula.carp','user',to_timestamp('18-OCT-16 03.15.23.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 03.15.23.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (250,'Marius Danila','marius.danila','user',to_timestamp('18-OCT-16 03.21.04.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 03.21.04.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (252,'Catalin Crainiceanu','catalin.crainiceanu','user',to_timestamp('18-OCT-16 03.35.46.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 03.37.27.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (253,'Dan Hutanu','dan.hutanu','user',to_timestamp('18-OCT-16 03.46.38.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 03.46.38.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (254,'Ana Chistol','ana.chistol','user',to_timestamp('18-OCT-16 03.59.17.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 03.59.17.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (255,'Cristian Ionesi','cristian.ionesi','user',to_timestamp('18-OCT-16 04.06.47.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 04.06.47.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (256,'Denise Goldan','denise.goldan','user',to_timestamp('18-OCT-16 04.14.45.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 05.57.16.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (259,'Niculita Ciucanu','niculita.ciucanu','user',to_timestamp('18-OCT-16 05.34.43.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 05.34.43.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (260,'Victor Vrabie','victor.vrabie','user',to_timestamp('18-OCT-16 05.49.42.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 06.37.23.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (261,'Andrei Chitic','andrei.chitic','user',to_timestamp('18-OCT-16 05.50.49.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 05.50.49.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (262,'Nicolae Dimache','nicolae.dimache','user',to_timestamp('18-OCT-16 05.54.53.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 05.54.53.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (263,'Anca Filibiu','anca.filibiu','user',to_timestamp('18-OCT-16 06.35.17.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 06.35.17.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (264,'Cosmin Dochitei','cosmin.dochitei','user',to_timestamp('18-OCT-16 07.17.36.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 11.54.17.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (265,'Alexandru Rosca','alexandru.rosca','user',to_timestamp('18-OCT-16 07.46.30.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 07.46.58.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (266,'Andrei Corodescu','andrei.corodescu','user',to_timestamp('18-OCT-16 07.55.16.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 07.55.16.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (268,'Vladimir Ventaniuc','vladimir.ventaniuc','user',to_timestamp('18-OCT-16 08.00.29.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 08.00.29.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (269,'Codrin Harpa','codrin.harpa','user',to_timestamp('18-OCT-16 08.07.16.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 08.07.16.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (270,'Ioan Robu','ioan.robu','user',to_timestamp('18-OCT-16 08.07.41.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 08.07.41.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (271,'Silviu Munteanu','silviu.munteanu','user',to_timestamp('18-OCT-16 08.09.08.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 08.09.08.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (273,'Dan Alexandru','dan.alexandru','user',to_timestamp('18-OCT-16 09.13.54.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 10.08.46.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (275,'Silviu Patras','silviu.patras','user',to_timestamp('18-OCT-16 10.38.53.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 10.38.53.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (276,'Tudor Motrescu','tudor.motrescu','user',to_timestamp('18-OCT-16 10.41.54.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('18-OCT-16 10.41.54.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (277,'Diana Andrian','diana.andrian','user',to_timestamp('19-OCT-16 05.24.45.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 05.24.45.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (278,'Simina Covatariu','simina.covatariu','user',to_timestamp('19-OCT-16 05.58.31.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 05.58.31.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (280,'Florian Corduneanu','florian.corduneanu','user',to_timestamp('19-OCT-16 06.13.53.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 06.13.53.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (281,'Andra Botezatu','andra.botezatu','user',to_timestamp('19-OCT-16 06.40.42.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 06.40.42.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (282,'Cristian Huma','cristian.huma','user',to_timestamp('19-OCT-16 07.10.32.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 07.10.32.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (283,'Cosmin Pascaru','cosmin.pascaru','user',to_timestamp('19-OCT-16 07.15.56.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 07.15.56.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (284,'Madalina Rusu','madalina.rusu','user',to_timestamp('19-OCT-16 08.07.40.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 08.07.40.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (286,'George Moscu','george.moscu','user',to_timestamp('19-OCT-16 09.12.47.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 09.12.47.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (287,'Ioana Lupu','ioana.lupu','user',to_timestamp('19-OCT-16 10.08.10.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 10.08.10.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (288,'Razvan Cimpoesu','razvan.cimpoesu','user',to_timestamp('19-OCT-16 10.31.34.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 10.31.34.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (289,'Andrei Rusu','andrei.rusu','user',to_timestamp('19-OCT-16 10.44.06.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 10.44.06.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (290,'Anca Popa','anca.popa','user',to_timestamp('19-OCT-16 10.47.44.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 10.47.44.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (291,'Radu Iacob','radu.iacob','user',to_timestamp('19-OCT-16 11.03.48.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 11.03.48.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (292,'Andrei Tesu','andrei.tesu','user',to_timestamp('19-OCT-16 11.03.53.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 11.03.53.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (293,'Andrei Craciunas','andrei.craciunas','user',to_timestamp('19-OCT-16 11.06.32.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 11.06.32.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (294,'Giani Ciornei','giani.ciornei','user',to_timestamp('19-OCT-16 11.09.01.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 11.09.01.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (296,'Catalin Lupu','catalin.lupu','user',to_timestamp('19-OCT-16 11.11.09.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 11.11.09.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (297,'Mircea Netedu','mircea.netedu','user',to_timestamp('19-OCT-16 11.16.05.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 11.16.05.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (298,'Andreea Samson','andreea.samson','user',to_timestamp('19-OCT-16 11.17.57.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 11.17.57.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (299,'Stefan Platon','stefan.platon','user',to_timestamp('19-OCT-16 11.19.45.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 11.19.45.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (318,'Petruta Maties','petruta.maties','user',to_timestamp('19-OCT-16 05.58.18.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('19-OCT-16 05.58.18.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (336,'Richard Mihailescu','richard.mihailescu','user',to_timestamp('20-OCT-16 09.05.21.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('20-OCT-16 09.05.21.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (471,'Dorin Edu','dorin.edu','user',to_timestamp('24-OCT-16 10.05.19.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('24-OCT-16 10.05.19.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into USERS1 (ID,NAME,USERNAME,USER_ROLE,CREATED_AT,UPDATED_AT) values (478,'Catalin Manole','catalin.manole','user',to_timestamp('24-OCT-16 05.05.47.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('24-OCT-16 05.05.47.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));

--Create
/
CREATE TABLE announcements
  (
    announcement_id INTEGER NOT NULL ,
    user_id   INTEGER NOT NULL ,
    realEstate_id INTEGER NOT NULL ,
    post_date   DATE NOT NULL ,
    expire_date DATE ,
    view_number INTEGER
  ) ;
ALTER TABLE announcements ADD CONSTRAINT announcements_PK PRIMARY KEY ( announcement_id ) ;

CREATE TABLE users
  (
    user_id    INTEGER NOT NULL ,
    first_name   VARCHAR2 (50) NOT NULL,
    last_name    VARCHAR2 (50)  NOT NULL,
    email        VARCHAR2 (100) ,
    phone_number NUMBER (10,0) NOT NULL
  ) ;
ALTER TABLE users ADD CONSTRAINT Client_PK PRIMARY KEY ( user_id ) ;

CREATE TABLE realEstates
  (
    realEstate_id INTEGER NOT NULL ,
    type_id     INTEGER NOT NULL ,
    zone_id     INTEGER NOT NULL ,
    area        INTEGER NOT NULL ,
    room_number INTEGER ,
    description CLOB ,
    photo_1 BLOB ,
    photo_2 BLOB ,
    photo_3 BLOB ,
    photo_4 BLOB ,
    photo_5 BLOB
  ) ;
ALTER TABLE realEstates ADD CONSTRAINT Immobile_PK PRIMARY KEY ( realEstate_id ) ;

CREATE TABLE Zone
  (
    zone_id            INTEGER NOT NULL ,
    name               VARCHAR2 (30) NOT NULL ,
    post_code          NUMBER(6,0) ,
    latitude           NUMBER (9,6) NOT NULL ,
    longitude          NUMBER (9,6) NOT NULL ,
    noise_pollution  NUMBER(1,0) NOT NULL ,
    chimic_pollution NUMBER(1,0) NOT NULL ,
    waste_pollution  NUMBER(1,0) NOT NULL ,
    facility_1         NUMBER(1,0)  ,
    facility_2         NUMBER(1,0)  ,
    facility_3         NUMBER(1,0)  ,
    facility_4         NUMBER(1,0)  ,
    facility_5         NUMBER(1,0)  ,
    facility_6         NUMBER(1,0)  ,
    minus_1            NUMBER(1,0)  ,
    minus_2            NUMBER(1,0)  ,
    minus_3            NUMBER(1,0) 
  ) ;
ALTER TABLE Zone ADD CONSTRAINT Zone_PK PRIMARY KEY ( zone_id ) ;

CREATE TABLE meetings
  (
    meeting_id INTEGER NOT NULL ,
    user_id_1    INTEGER NOT NULL ,
    user_id_2    INTEGER NOT NULL
  ) ;
ALTER TABLE meetings ADD CONSTRAINT meetings_PK PRIMARY KEY ( meeting_id ) ;


CREATE TABLE realEstates_types
  (
    type_id INTEGER NOT NULL ,
    name    VARCHAR2 (30) NOT NULL
  ) ;
ALTER TABLE realEstates_types ADD CONSTRAINT immobile_type_PK PRIMARY KEY ( type_id ) ;

-- create FK

ALTER TABLE realEstates ADD CONSTRAINT Immobile_Zone_FK FOREIGN KEY ( zone_id ) REFERENCES Zone ( zone_id ) ;

ALTER TABLE meetings ADD CONSTRAINT meetings_Client_FK FOREIGN KEY ( user_id_1 ) REFERENCES users ( user_id ) ;

ALTER TABLE meetings ADD CONSTRAINT meetings_Client_FKv1 FOREIGN KEY ( user_id_2 ) REFERENCES users ( user_id ) ;

ALTER TABLE announcements ADD CONSTRAINT user_id FOREIGN KEY ( user_id ) REFERENCES users ( user_id ) ;

ALTER TABLE announcements ADD CONSTRAINT realEstate_id FOREIGN KEY ( realEstate_id ) REFERENCES realEstates ( realEstate_id ) ;

ALTER TABLE realEstates ADD CONSTRAINT type_id FOREIGN KEY ( type_id ) REFERENCES realEstates_types ( type_id ) ;

-- Insert data

declare
cursor lista_studenti is select id,name from users1 where id is not null ;
v_nume varchar2(50);
v_prenume varchar2(50);
v_telefon varchar2(11);
v_email varchar2(100);
v_id number(5) :=1;
begin
for i in lista_studenti loop
   v_nume:=substr(i.name,instr(i.name,' '));
   v_prenume:=substr(i.name,1,instr(i.name,' ',1,1));
   if(v_prenume is not null and v_nume is not null) then
   v_email:=trim(lower(v_prenume))||'.'||trim(lower(v_nume))||'@yahoo.com';
   v_telefon:='7'||to_char(round(dbms_random.value(10000000,99999999)));
   Insert into users values (i.id,trim(v_nume),v_prenume,v_email,v_telefon);
   v_id:=v_id+1;
   end if;
end loop;
end;
  
--Zone
/
insert into zone(zone_id, name, post_code, latitude, longitude, noise_pollution, chimic_pollution, waste_pollution)
 values (1, 'Bucium', dbms_random.value(100000, 999999), dbms_random.value(-999.999999, 999.999999), 
 dbms_random.value(-999.999999, 999.999999), dbms_random.value(0,9), dbms_random.value(0,9), dbms_random.value(0,9));
 
 insert into zone(zone_id, name, post_code, latitude, longitude, noise_pollution, chimic_pollution, waste_pollution)
 values (2, 'Podu Ros', dbms_random.value(100000, 999999), dbms_random.value(-999.999999, 999.999999), 
 dbms_random.value(-999.999999, 999.999999), dbms_random.value(0,9), dbms_random.value(0,9), dbms_random.value(0,9));
 
  insert into zone(zone_id, name, post_code, latitude, longitude, noise_pollution, chimic_pollution, waste_pollution)
 values (3, 'Mircea cel Batran', dbms_random.value(100000, 999999), dbms_random.value(-999.999999, 999.999999), 
 dbms_random.value(-999.999999, 999.999999), dbms_random.value(0,9), dbms_random.value(0,9), dbms_random.value(0,9));
 
  insert into zone(zone_id, name, post_code, latitude, longitude, noise_pollution, chimic_pollution, waste_pollution)
 values (4, 'Pallas', dbms_random.value(100000, 999999), dbms_random.value(-999.999999, 999.999999), 
 dbms_random.value(-999.999999, 999.999999), dbms_random.value(0,9), dbms_random.value(0,9), dbms_random.value(0,9));
  
  insert into zone(zone_id, name, post_code, latitude, longitude, noise_pollution, chimic_pollution, waste_pollution)
 values (5, 'Podu de Piatra', dbms_random.value(100000, 999999), dbms_random.value(-999.999999, 999.999999), 
 dbms_random.value(-999.999999, 999.999999), dbms_random.value(0,9), dbms_random.value(0,9), dbms_random.value(0,9));
  
  insert into zone(zone_id, name, post_code, latitude, longitude, noise_pollution, chimic_pollution, waste_pollution)
 values (6, 'Tatarasi', dbms_random.value(100000, 999999), dbms_random.value(-999.999999, 999.999999), 
 dbms_random.value(-999.999999, 999.999999), dbms_random.value(0,9), dbms_random.value(0,9), dbms_random.value(0,9));
  
  insert into zone(zone_id, name, post_code, latitude, longitude, noise_pollution, chimic_pollution, waste_pollution)
 values (7, 'Tudor', dbms_random.value(100000, 999999), dbms_random.value(-999.999999, 999.999999), 
 dbms_random.value(-999.999999, 999.999999), dbms_random.value(0,9), dbms_random.value(0,9), dbms_random.value(0,9));
  
  insert into zone(zone_id, name, post_code, latitude, longitude, noise_pollution, chimic_pollution, waste_pollution)
 values (8, 'Piata Unirii', dbms_random.value(100000, 999999), dbms_random.value(-999.999999, 999.999999), 
 dbms_random.value(-999.999999, 999.999999), dbms_random.value(0,9), dbms_random.value(0,9), dbms_random.value(0,9));
  
  insert into zone(zone_id, name, post_code, latitude, longitude, noise_pollution, chimic_pollution, waste_pollution)
 values (9, 'Pacurari', dbms_random.value(100000, 999999), dbms_random.value(-999.999999, 999.999999), 
 dbms_random.value(-999.999999, 999.999999), dbms_random.value(0,9), dbms_random.value(0,9), dbms_random.value(0,9));

  insert into zone(zone_id, name, post_code, latitude, longitude, noise_pollution, chimic_pollution, waste_pollution)
 values (10, 'Dacia', dbms_random.value(100000, 999999), dbms_random.value(-999.999999, 999.999999), 
 dbms_random.value(-999.999999, 999.999999), dbms_random.value(0,9), dbms_random.value(0,9), dbms_random.value(0,9));
 
 
--realEstates_types
/
 insert into realEstates_types values (1, 'teren');
 insert into realEstates_types values (2, 'casa');
 insert into realEstates_types values (3, 'garsoniera');
 insert into realEstates_types values (4, 'apartament');
 insert into realEstates_types values (5, 'spatiu comercial');


 --realEstates
 /
  declare
 id integer := 1;
 begin
 
 for contor in 1 .. 100 loop
 
 insert into realEstates (realEstate_id, type_id, zone_id, area, room_number)
 values(
    id, 
    (select type_id from ( select * from realEstates_types order by dbms_random.random) where rownum < 2),
    (select zone_id from ( select * from zone order by dbms_random.random) where rownum < 2),
    dbms_random.value(20, 90),
    dbms_random.value(0,4)
   );
   id := id + 1;
  end loop;
end;

--announcements
 /
 declare
 id integer := 1;
 begin
 
 for contor in 1 .. 100 loop
 
 insert into announcements (announcement_id, user_id, realEstate_id, post_date)
 values(
    id, 
    (select user_id from ( select * from users order by dbms_random.random) where rownum < 2),
    (select realEstate_id from ( select * from realEstates order by dbms_random.random) where rownum < 2),
    (select to_date(trunc( dbms_random.value(to_char(date '2015-01-01','J') ,to_char(date '2017-12-31','J') ) ),'J') from dual)
   );
   id := id + 1;
  end loop;
end;

--meetings
/
 declare
 id integer := 1;
 begin
 
 for contor in 1 .. 50 loop
 
 insert into meetings (meeting_id, user_id_1, user_id_2)
 values(
    id, 
    (select user_id from ( select * from users order by dbms_random.random) where rownum < 2),
    (select user_id from ( select * from users order by dbms_random.random) where rownum < 2)
   );
   id := id + 1;
  end loop;
end;
/
--drop import table
drop table users1;