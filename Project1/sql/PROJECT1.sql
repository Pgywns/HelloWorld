CREATE TABLE member (
    id     VARCHAR2(10) PRIMARY KEY,
    pw     VARCHAR2(10) NOT NULL,
    name   VARCHAR2(20) NOT NULL,
    phone  VARCHAR2(15),
    email  VARCHAR2(20),
    admin  VARCHAR2(10) DEFAULT 'user'
);