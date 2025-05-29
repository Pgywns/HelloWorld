delete from member
where id = 'gywns1';

select * from member;
select * from board;

select * from board;

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
    no          NUMBER        PRIMARY KEY,
    title       VARCHAR2(50)  NOT NULL,
    content     VARCHAR2(100),
    uploaddate  VARCHAR2(30)  DEFAULT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),
    writer      VARCHAR2(20)
);

INSERT INTO board (no, title, content, writer)
VALUES (1, 'title', 'content', 'gywns');
