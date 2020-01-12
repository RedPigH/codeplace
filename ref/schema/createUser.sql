-- 유저 생성 --

CREATE USER CPADMIN IDENTIFIED BY CPADMIN
	DEFAULT TABLESPACE "TBSCODEPLACE"
	TEMPORARY TABLESPACE "TBSCODEPLACETEMP"
	QUOTA UNLIMITED ON "TBSCODEPLACE"
	QUOTA UNLIMITED ON "TBSCODEPLACEINDEX"
	PROFILE "DEFAULT";

GRANT "CONNECT" TO CPADMIN;
GRANT "RESOURCE" TO CPADMIN;
GRANT CREATE VIEW TO CPADMIN;