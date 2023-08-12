
/* 무인택배함 DB설계 */
drop database if exists sqldb7web;
create database sqldb7web;
use sqldb7web; 

/* 테이블 설계 */
# 1. 무인택배함 테이블
create table anmdtable( 
    bnumber mediumint unique not null,    -- 함번호 
    bsituation varchar(2) not null,       -- 보관상태   
    bpw varchar(20) ,           		  -- 비밀번호
    primary key(bnumber)
    );             
select * from anmdtable;
# 2. 물건 테이블
create table objecttable( 
    bitem  varchar(20) not null unique , -- 물건코드 
    bname varchar(10) not null,       	 -- 물건이름
    bsituation varchar(2) not null , 	 -- 보관상태
    primary key(bitem) 
    );    
select * from objecttable;
# 3. 택배함보관내역 테이블
drop table if exists archistable; 
create table archistable( 
    cnumer Smallint not null,          	-- 번호 
    bnumber mediumint unique not null ,       	-- 함번호  
    storagedate datetime default now() not null,      -- 보관일시 
    visitdate datetime ,		-- 찾아간일시 
    primary key(cnumer) , 
    foreign key(bnumber)  references anmdtable(bnumber) on update cascade on delete set null
    );      
select * from archistable;
# 4. 택배기사 테이블 
create table couriertale( 
    barticle varchar(30) not null unique,      -- 기사코드
    barname varchar(5) not null,        -- 기사이름 
    barphone varchar(20) not null unique,		-- 기사전화번호
    primary key(barticle)
    );      
select * from couriertale; 

/* 5. 게시판 테이블 */
drop table if exists bulletin_board;
create table bulletin_board (
	Post_number smallint auto_increment not null ,			-- 게시물번호
    Post_title varchar(15) not null,				-- 게시물제목
    Content_Posts longtext not null, 			-- 게시물내용
    Writer_phone_number varchar(20) not null,	-- 작성자전화번호
    Date_Created datetime default now()		--  작성 일시
    );
select * from bulletin_board;
/* 6. 배송 현황 테이블 */
drop table if exists Delivery_status;
create table Delivery_status ( 
	lineNumber	int auto_increment   ,					-- 행번호 , 자동부여 			
	InvoiceNumber varchar(30) not null,  					-- 송장번호
    bitem varchar(20) not null, 							-- 물건코드
    barticle varchar(30) not null ,							-- 기사코드
    Customer_phone_numbe int not null, 				-- 고객전화번호
    Delivery_status boolean default true not null,				-- 배송상태
    primary key(line_number) ,
    primary key(Customer_phone_numbe) ,
    foreign key(bitem) references objecttable(bitem) on update cascade on delete set null,
    foreign key(barticle) references couriertale(barticle) on update cascade on delete set null
    );
select * from Delivery_status;

drop table if exists texting;
/* 7. 문자 테이블 */
create table texting (
	Customer_phone_numbe int , 			   -- 고객전화번호
    bnumber mediumint unique not null, 			   -- 함번호
    foreign key(Customer_phone_numbe) references Delivery_status(Customer_phone_numbe) on delete no action on update cascade,
    foreign key(bnumber) references anmdtable(bnumber) on update cascade
    );	
select * from texting;

# 1. 무인택배함 테이블 레코드 
insert into anmdtable( bnumber , bsituation , bpw ) values( 1 , '실온' , 'null' );
insert into anmdtable( bnumber , bsituation , bpw ) values( 2 , '냉장' , 'null' );
insert into anmdtable( bnumber , bsituation , bpw ) values( 3 , '냉동' , 'null' );
insert into anmdtable( bnumber , bsituation , bpw ) values( 4 , '실온' , 'null' );
insert into anmdtable( bnumber , bsituation , bpw ) values( 5 , '냉장' , 'null' );
insert into anmdtable( bnumber , bsituation , bpw ) values( 6 , '냉동' , 'null' );
insert into anmdtable( bnumber , bsituation , bpw ) values( 7 , '실온' , 'null' );
insert into anmdtable( bnumber , bsituation , bpw ) values( 8 , '냉장' , 'null' );
insert into anmdtable( bnumber , bsituation , bpw ) values( 9 , '냉동' , 'null' );
insert into anmdtable( bnumber , bsituation , bpw ) values( 10 , '실온' , 'null' );
insert into anmdtable( bnumber , bsituation , bpw ) values( 11 , '냉장' , 'null' );
insert into anmdtable( bnumber , bsituation , bpw ) values( 12 , '냉동' , 'null' );
insert into anmdtable( bnumber , bsituation , bpw ) values( 13 , '실온' , 'null' );
insert into anmdtable( bnumber , bsituation , bpw ) values( 14 , '냉장' , 'null' );
insert into anmdtable( bnumber , bsituation , bpw ) values( 15 , '냉동' , 'null' );

# 2. 물건테이블 레코드
insert into objecttable( bitem , bname , bsituation )   values('33332222' , '에어팟' , '실온');
insert into objecttable( bitem , bname , bsituation )   values('33335555' , '삼겹살' , '냉장');
insert into objecttable( bitem , bname , bsituation )   values('33335556' , '냉동 새우' , '냉동');
insert into objecttable( bitem , bname , bsituation )   values('33335557' , '런닝화' , '실온');
insert into objecttable( bitem , bname , bsituation )   values('33335558' , '사과' , '냉장');
insert into objecttable( bitem , bname , bsituation )   values('33335559' , '냉동 만두' , '냉동');
insert into objecttable( bitem , bname , bsituation )   values('333355510' , '슬리퍼' , '실온');
insert into objecttable( bitem , bname , bsituation )   values('333355511' , '상추' , '냉장');
insert into objecttable( bitem , bname , bsituation )   values('333355512' , '냉동 치킨' , '냉동');
insert into objecttable( bitem , bname , bsituation )   values('333355513' , '반팔' , '실온');
insert into objecttable( bitem , bname , bsituation )   values('333355514' , '동원참치' , '냉장');
insert into objecttable( bitem , bname , bsituation )   values('333355515' , '냉동 새우' , '냉동');
insert into objecttable( bitem , bname , bsituation )   values('333355516' , '긴팔' , '실온');
insert into objecttable( bitem , bname , bsituation )   values('333355517' , '고추장' , '냉장');

# 3. 택배함보관내역 레코드 
 insert into archistable(cnumer , bnumber , storagedate , visitdate) values( 1 , 1 , '2023-08-08 17:53:01' , '2023-08-09 08:00:01' );
 insert into archistable(cnumer , bnumber , storagedate , visitdate ) values( 2 , 2 , '2023-08-08 17:53:02' , '2023-08-09 08:00:02' );
 insert into archistable(cnumer , bnumber , storagedate , visitdate ) values( 3 , 3 ,  '2023-08-08 17:53:03' , '2023-08-09 08:00:03' );
 
 # 4. 택배기사 레코드 
insert into couriertale(barticle , barname , barphone ) values('230808101' , '홍길동' , '010-1111-2222');
insert into couriertale(barticle , barname , barphone ) values('230808102' , '유재석' , '010-1111-3333');
insert into couriertale(barticle , barname , barphone ) values('230808103' , '강호동' , '010-1111-4444');
insert into couriertale(barticle , barname , barphone ) values('230808104' , '신동엽' , '010-1111-5555');
insert into couriertale(barticle , barname , barphone ) values('230808105' , '김근배' , '010-1111-6666');
insert into couriertale(barticle , barname , barphone ) values('230808106' , '정희락' , '010-1111-7777');
insert into couriertale(barticle , barname , barphone ) values('230808107' , '한승우' , '010-1111-8888');
insert into couriertale(barticle , barname , barphone ) values('230808108' , '김현수' , '010-1111-9999');
insert into couriertale(barticle , barname , barphone ) values('230808109' , '이성호' , '010-2222-1111');
insert into couriertale(barticle , barname , barphone ) values('230808110' , '김규리' , '010-2222-2222');
insert into couriertale(barticle , barname , barphone ) values('230808111' , '고연진' , '010-2222-3333');
insert into couriertale(barticle , barname , barphone ) values('230808112' , '황기준' , '010-2222-4444');
insert into couriertale(barticle , barname , barphone ) values('230808113' , '김준희' , '010-2222-5555');
insert into couriertale(barticle , barname , barphone ) values('230808114' , '이환희' , '010-2222-6666');
insert into couriertale(barticle , barname , barphone ) values('230808115' , '이진형' , '010-2222-7777');

#  5. 게시판 레코드 
insert into bulletin_board( Post_number , Post_title , Content_Posts ,  Writer_phone_number , Date_Created ) values( 1 , '잘썼습니다' , '좋은보관함입니다' , '010-1234-0000' , '2023-08-07 14:00:00' );
insert into bulletin_board( Post_number , Post_title , Content_Posts ,  Writer_phone_number , Date_Created ) values( 2 , '2번 칸 수리요망' , '문이 삐그덕 거리네요' , '010-4343-2121' , '2023-08-08 12:00:00' );

# 6. 배송 현황 레코드 
insert into Delivery_status( Invoice_number , bitem , barticle , Customer_phone_numbe , Delivery_status ) values('20230808170001' , '33332222' , '230808100' , 01033332222, true );
insert into Delivery_status( Invoice_number , bitem , barticle , Customer_phone_numbe , Delivery_status ) values('20230808170002' , '33335555' , '2308101' , 01022225555 ,true);
       
# 7. 문자  레코드         
insert into texting ( Customer_phone_numbe , bnumber) values( '010-3333-2222' , 1);
insert into texting ( Customer_phone_numbe , bnumber) values( '010-2222-5555' , 2);

# 배달현황 테이블 수정 
update Delivery_status set Invoice_number = ? , bitem = ? , barticle = ? , Customer_phone_numbe = ? , Delivery_status = ? where line_number = ?;

# 배달현황 테이블 삭제 
delete from Delivery_status where line_number = ? ;







