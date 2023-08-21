
/* 무인택배함 DB설계 */
drop database if exists projectCsb;
create database projectCsb;
use projectCsb; 

/* 테이블 설계 */
# 1. 무인택배함 테이블
create table anmdtable( 
    bnumber mediumint unique not null,    -- 함번호 
    bsituation varchar(2) not null,       -- 보관상태   
    bpw varchar(20) ,           		  -- 비밀번호
    primary key(bnumber)
    );             
select * from anmdtable;
update anmdtable set bpw = null where bnumber = 1;
# 2. 물건 테이블
create table objecttable( 
    bitem  int not null unique , 		-- 물건코드 
    bname varchar(20) not null,       	 -- 물건이름
    bsituation varchar(2) not null , 	 -- 보관상태
    primary key(bitem) 
    );    
select * from objecttable;
# 3. 택배함보관내역 테이블
drop table if exists archistable; 
create table archistable( 
    cnumer Smallint auto_increment not null,          			-- 번호 
    bnumber mediumint not null ,       							-- 함번호  
    storagedate datetime default now() not null,    			-- 보관일시 
    visitdate datetime default null,							-- 찾아간일시 
    primary key(cnumer) , 	
    foreign key(bnumber)  references anmdtable(bnumber) on update cascade
    );      
select * from archistable;

# 4. 택배기사 테이블 
create table couriertale( 
    barticle int not null unique,     			 -- 기사코드
    barname varchar(5) not null,        		-- 기사이름 
    barphone varchar(20) not null unique,		-- 기사전화번호
    primary key(barticle)
    );      
select * from couriertale; 

/* 5. 게시판 테이블 */
drop table if exists bulletinBoard;
create table bulletinBoard (
	postNumber int auto_increment not null ,			-- 게시물번호
    contentPosts longtext not null, 						-- 게시물내용
    writerPhoneNumber varchar(20) not null,					-- 작성자전화번호
    dateCreatedDatetime datetime default now() ,						--  작성 일시
    primary key(postNumber)
    );
select * from bulletinBoard;
/* 6. 배송 현황 테이블 */
drop table if exists deliveryStatus;
create table deliveryStatus ( 
	lineNumber	int auto_Increment   ,							-- 행번호 , 자동부여 						
	InvoiceNumber varchar(25) not null ,  								-- 송장번호				
    bitem int not null, 										-- 물건코드
    barticle int not null ,										-- 기사코드
    customerPhoneNumbe varchar(13) not null, 					-- 고객전화번호
    dstatus boolean default false not null,				-- 배송상태
    primary key(lineNumber) ,
    foreign key(bitem) references objecttable(bitem) on update cascade ,
    foreign key(barticle) references couriertale(barticle) on update cascade 
    );
select * from deliveryStatus;
drop table if exists texting;
select count(lineNumber) from deliveryStatus;
/* 7. 문자 테이블 */
create table texting (
	customerPhoneNumbe varchar(20) , 			  	 -- 고객전화번호
    bnumber mediumint not null, 		 -- 함번호
    dateReceipt datetime default now() ,
    foreign key(bnumber) references anmdtable(bnumber) on update cascade
    );	
select * from texting;
select * from texting , anmdtable;
select a.bnumber , a.bpw , date_format(dateReceipt , '%y/%m/%d %H시 %i분 %S초' ) from anmdtable a , texting t where a.bnumber = t.bnumber and customerPhoneNumbe = '01033332222';

# 1. 무인택배함 테이블 레코드 
insert into anmdtable( bnumber , bsituation , bpw ) values( 1 , '실온' , null );
insert into anmdtable( bnumber , bsituation , bpw ) values( 2 , '냉장' , null );
insert into anmdtable( bnumber , bsituation , bpw ) values( 3 , '냉동' , null );
insert into anmdtable( bnumber , bsituation , bpw ) values( 4 , '실온' , null );
insert into anmdtable( bnumber , bsituation , bpw ) values( 5 , '냉장' , null );
insert into anmdtable( bnumber , bsituation , bpw ) values( 6 , '냉동' , null );
insert into anmdtable( bnumber , bsituation , bpw ) values( 7 , '실온' , null );
insert into anmdtable( bnumber , bsituation , bpw ) values( 8 , '냉장' , null );
insert into anmdtable( bnumber , bsituation , bpw ) values( 9 , '냉동' , null );
insert into anmdtable( bnumber , bsituation , bpw ) values( 10 , '실온' , null );
insert into anmdtable( bnumber , bsituation , bpw ) values( 11 , '냉장' , null );
insert into anmdtable( bnumber , bsituation , bpw ) values( 12 , '냉동' , null );
insert into anmdtable( bnumber , bsituation , bpw ) values( 13 , '실온' , null );
insert into anmdtable( bnumber , bsituation , bpw ) values( 14 , '냉장' , null );
insert into anmdtable( bnumber , bsituation , bpw ) values( 15 , '냉동' , null );

# 2. 물건테이블 레코드
insert into objecttable( bitem , bname , bsituation )   values(33332222 , '에어팟' , '실온');
insert into objecttable( bitem , bname , bsituation )   values(33335555 , '삼겹살' , '냉장');
insert into objecttable( bitem , bname , bsituation )   values(33335556 , '냉동 새우' , '냉동');
insert into objecttable( bitem , bname , bsituation )   values(33335557 , '런닝화' , '실온');
insert into objecttable( bitem , bname , bsituation )   values(33335558 , '사과' , '냉장');
insert into objecttable( bitem , bname , bsituation )   values(33335559 , '냉동 만두' , '냉동');
insert into objecttable( bitem , bname , bsituation )   values(333355510 , '슬리퍼' , '실온');
insert into objecttable( bitem , bname , bsituation )   values(333355511 , '상추' , '냉장');
insert into objecttable( bitem , bname , bsituation )   values(333355512 , '냉동 치킨' , '냉동');
insert into objecttable( bitem , bname , bsituation )   values(333355513 , '반팔' , '실온');
insert into objecttable( bitem , bname , bsituation )   values(333355514 , '동원참치' , '냉장');
insert into objecttable( bitem , bname , bsituation )   values(333355515 , '냉동 새우' , '냉동');
insert into objecttable( bitem , bname , bsituation )   values(333355516 , '긴팔' , '실온');
insert into objecttable( bitem , bname , bsituation )   values(333355517 , '고추장' , '냉장');
 
 # 4. 택배기사 레코드 
insert into couriertale(barticle , barname , barphone ) values(230808101 , '홍길동' , '01011112222');
insert into couriertale(barticle , barname , barphone ) values(230808102 , '유재석' , '01011113333');
insert into couriertale(barticle , barname , barphone ) values(230808103 , '강호동' , '01011114444');
insert into couriertale(barticle , barname , barphone ) values(230808104 , '신동엽' , '01011115555');
insert into couriertale(barticle , barname , barphone ) values(230808105 , '김근배' , '01011116666');
insert into couriertale(barticle , barname , barphone ) values(230808106, '정희락' , '01011117777');
insert into couriertale(barticle , barname , barphone ) values(230808107 , '한승우' , '01011118888');
insert into couriertale(barticle , barname , barphone ) values(230808108 , '김현수' ,'01011119999');
insert into couriertale(barticle , barname , barphone ) values(230808109 , '이성호' , '01022221111');
insert into couriertale(barticle , barname , barphone ) values(230808110 , '김규리' , '01022222222');
insert into couriertale(barticle , barname , barphone ) values(230808111 , '고연진' , '01022223333');
insert into couriertale(barticle , barname , barphone ) values(230808112 , '황기준' , '01022224444');
insert into couriertale(barticle , barname , barphone ) values(230808113 , '김준희' , '01022225555');
insert into couriertale(barticle , barname , barphone ) values(230808114 , '이환희' , '01022226666');
insert into couriertale(barticle , barname , barphone ) values(230808115 , '이진형' , '01022227777');

#  5. 게시판 레코드 
insert into bulletinBoard( postNumber , contentPosts ,  writerPhoneNumber   ) values( 1 ,  '좋은보관함입니다' , '010-1234-0000' );
insert into bulletinBoard( postNumber  , contentPosts ,  writerPhoneNumber   ) values( 2 ,  '문이 삐그덕 거리네요' , '010-4343-2121');


       

