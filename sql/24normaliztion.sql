-- normalization : 정규화


-- 예) 이름, 최종학력, 특기
USE mydb1;

CREATE TABLE  my_table21_person(
    name VARCHAR(100) NOT NULL ,
    schools VARCHAR(100),
    skill VARCHAR(1000)
);

INSERT INTO  my_table21_person(name, schools, skill)
VALUE ('손흥민','대학','축구,노래');

INSERT INTO  my_table21_person(name, schools, skill)
    VALUE ('이강인','대학원','야구,농구');

INSERT INTO  my_table21_person(name, schools, skill)
    VALUE ('김민재','대학원','배구');

SELECT * FROM my_table21_person;

--  책 209쪽 규칙 2
-- 원자적 테이터로 구성된 테이블은 같은 타입의 데이터를 여러 열에 가질 수 없다.
CREATE TABLE my_table22_person(
    name VARCHAR(20) NOT NULL ,
    schools VARCHAR(100) ,
    skil1 VARCHAR(100),
    skil2 VARCHAR(100),
    skil3 VARCHAR(100)
);

INSERT INTO my_table22_person(name, schools, skil1, skil2, skil3)
VALUE ('흥민','대학교','축구','노래',null);

INSERT INTO my_table22_person(name, schools, skil1, skil2, skil3)
    VALUE ('강인','대학원','야구','농구',null);

INSERT INTO my_table22_person(name, schools, skil1, skil2, skil3)
    VALUE ('민재','대학웍','배구',null,null);
SELECT * FROM my_table22_person;


CREATE TABLE my_table23_person(
    name VARCHAR(100) NOT NULL ,
    schools VARCHAR(100),
    skill VARCHAR(1000)
);


INSERT INTO my_table23_person(name,schools,skill)
    VALUE ('흥민','대학교','축구');

INSERT INTO my_table23_person(name,schools,skill)
    VALUE ('흥민','대학교','노래');


INSERT INTO my_table23_person(name,schools,skill)
    VALUE ('강인','대학원','야구');


INSERT INTO my_table23_person(name,schools,skill)
    VALUE ('강인','대학원','농구');

SELECT * FROM my_table23_person;

-- KEY : 각 행을 구분하는 컬럼(들)

-- 책 215 정규화
-- 각 행의 데이터들은 원자적 값을 가져야 한다.
-- 각 행은 유일무이한 식별자인 기본키(primary key)를 가지고 있어야 한다.

CREATE TABLE my_table24_person(
    ssn VARCHAR(10) NOT NULL UNIQUE ,
    name VARCHAR(10) NOT NULL ,
    school VARCHAR(10),
    skill VARCHAR(10)
);

-- 책 216쪽
-- 기본키(primary key) 조건
-- 기본키는 NULL이 될 수 없음
-- 기본키는 레코드가 삽입될 떄  값이 있어야 함.
-- 기본키는 간결해야
-- 기본키의 값은 변경 불가함
--

CREATE TABLE my_table25_person(
    id INT NOT NULL UNIQUE  AUTO_INCREMENT,  -- AUTO_INCREMENT : 1부터 자동으로 증가된
    ssn VARCHAR(10) NOT NULL ,
    name VARCHAR(10) NOT NULL ,
    shcool VARCHAR(10),
    SKill VARCHAR(10)
);

DROP TABLE my_table25_person;

INSERT INTO my_table25_person(ssn, name, shcool, skill)
VALUE ('080101','흥민','대학','축구');


INSERT INTO my_table25_person(ssn, name, shcool, skill)
    VALUE ('080101','흥민','대학','야구');

SELECT *
FROM my_table25_person;


CREATE TABLE my_table26_person(
      id INT PRIMARY KEY  AUTO_INCREMENT,  --  PRIMARY KEY : NOT NU::
      ssn VARCHAR(10) NOT NULL ,
      name VARCHAR(10) NOT NULL ,
      shcool VARCHAR(10),
      SKill VARCHAR(10)
);

DESC  my_table25_person;
DESC my_table26_person;