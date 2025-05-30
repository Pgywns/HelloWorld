delete from member
where id = 'gywns1';

delete from board
where title = 'title';

drop table board;
drop table product;

CREATE SEQUENCE auto_increment_no
START  WITH 1
INCREMENT BY 1;

DROP SEQUENCE auto_increment_no;

CREATE SEQUENCE auto_increment_productno
START  WITH 1
INCREMENT BY 1;

DROP SEQUENCE auto_increment_productno;

select * from member;
select * from board;
select * from product;

/* 테이블 생성, 값 추가 구문 */
CREATE TABLE member (
    id     VARCHAR2(10) PRIMARY KEY,
    pw     VARCHAR2(10) NOT NULL,
    name   VARCHAR2(20) NOT NULL,
    phone  VARCHAR2(15),
    email  VARCHAR2(20),
    admin  VARCHAR2(10) DEFAULT 'user'
);

INSERT INTO member (id, pw, name, phone, email, admin)
VALUES ('gywns', '1234', '박효준', '1234-5678', 'gywns@naver.com', 'user');

INSERT INTO member (id, pw, name, admin)
VALUES ('admin', 'admin', 'admin', 'admin');


CREATE TABLE board (
    no          NUMBER        DEFAULT auto_increment_no.NEXTVAL PRIMARY KEY,
    title       VARCHAR2(50)  NOT NULL,
    content     VARCHAR2(100),
    uploaddate  VARCHAR2(30)  DEFAULT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI'),
    writer      VARCHAR2(20)
);

INSERT INTO board (title, content, writer)
VALUES ('title', 'content', 'gywns');

CREATE TABLE product (
    no         NUMBER       DEFAULT auto_increment_productno.NEXTVAL PRIMARY KEY,
    name       VARCHAR2(20) UNIQUE NOT NULL,
    ea         NUMBER,
    price      NUMBER,
    country    VARCHAR2(20)
);

INSERT INTO product (name, price, ea, country)
VALUES ('이클립스', 2000, 50, 'KOREA');

CREATE TABLE order (
    no         NUMBER       DEFAULT auto_increment_productno.NEXTVAL PRIMARY KEY,
    name       VARCHAR2(20) NOT NULL,
    ea         NUMBER,
    price      NUMBER,
    country    VARCHAR2(20)
);