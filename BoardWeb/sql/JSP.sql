create sequence board_seq;

delete seqeunce board_seq;

create table tbl_board (
    board_no   NUMBER         primary key,
    title      VARCHAR2(100)  not null,
    content    VARCHAR2(1000) not null,
    writer     VARCHAR2(30)   not null,
    write_date DATE   DEFAULT sysdate,
    read_cnt   NUMBER DEFAULT 0
);

insert into tbl_board(board_no, title, content, writer)
values(board_seq.nextval, '게시글연습', '글 등록 연습 중입니다', 'user01');

insert into tbl_board(board_no, title, content, writer)
values(board_seq.nextval, '게시글연습1', '글 등록 연습 중입니다1', 'user02');

insert into tbl_board(board_no, title, content, writer)
values(board_seq.nextval, '게시글연습2', '글 등록 연습 중입니다2', 'user03');

insert into tbl_board(board_no, title, content, writer)
values(board_seq.nextval, '게시글연습3', '글 등록 연습 중입니다3', 'user04');

select to_char(write_date, 'yyyy-mm-dd hh24:mi:ss')
from tbl_board;

select * from tbl_board;

select b.*
from   (select rownum rn, a.*
        from   (select   *
                from     tbl_board
                order by board_no desc) a) b
        where  b.rn >= (:page -1) * 5
        and    b.rn <= :page * 5;
        
insert into tbl_board (board_no, title, content, writer)
select board_seq.nextval, title, content, writer
from tbl_board;

create table tbl_member (
    member_id      varchar2(30)  primary key,
    member_name    varchar2(100) not null,
    password       varchar2(50)  not null,
    responsibility varchar2(10)  default 'User' -- 'Admin'
);

insert into tbl_member (member_id, member_name, password)
values ('user06', 'user06', 'user06');

insert into tbl_member (member_id, member_name, password, responsibility)
values ('admin', 'admin', 'admin', 'Admin');

select * from tbl_member;

create sequence reply_seq;
-- 댓글테이블
create table tbl_reply (
     reply_no number
    ,board_no number NOT NULL
    ,reply VARCHAR2(300) NOT NULL
    ,replyer VARCHAR2(100) NOT NULL
    ,reply_date DATE DEFAULT SYSDATE);
    
alter table tbl_reply add constraint pk_reply primary key (reply_no);

insert into tbl_reply(reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 213, '213번의 댓글입니다.', 'user01');

insert into tbl_reply(reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 213, '213번은 누구입니까?', 'user01');

insert into tbl_reply(reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 213, '213번은 나다', 'user01');

select * from tbl_reply
where board_no = 7;

select a.*
from (select   rownum rn, r.*
      from     tbl_reply r
      where    board_no = :bno) a
where a.rn > (:page - 1) * 5
and   a.rn <= (:page * 5);

insert into tbl_reply (reply_no, board_no, reply, replyer)
select reply_seq.nextval, board_no, reply, replyer
from tbl_reply;

select count(*)
from tbl_reply
where board_no = 7;

select writer, member_name, count(1)
from tbl_board b
join tbl_member m
on b.writer = m.member_id
group by writer, member_name;

drop table tbl_events;

create table tbl_events (
    title   VARCHAR2(100) not null,
    startDt VARCHAR2(100) not null,
    endDt   VARCHAR2(100) not null
);

select * from tbl_events;

insert into tbl_events
values ('test1', '2025-06-01', '2025-06-03');

delete from tbl_events
where title = '11';