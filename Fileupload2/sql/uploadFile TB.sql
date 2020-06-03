DROP TABLE uploadfile;
CREATE TABLE uploadfile (
    fileno NUMBER PRIMARY KEY,
    origin_name VARCHAR2(500),
    stored_name VARCHAR2(500)
);

DROP SEQUENCE uploadfile_seq;
CREATE SEQUENCE uploadfile_seq;