-- 1 : n

-- 1 : 1

USE mydb1;

CREATE TABLE my_table37_employee(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(20),
    birth DATE
);

CREATE TABLE  my_table38_employee_info(
    id INT REFERENCES my_table37_employee(id),
    salary INT,
    address VARCHAR(20)
);

-- 책(350p)
-- n : m ( 다 대 다 )
-- 1 : n , 1 : m 인 중간 테이블이 생성되어야 한다.
CREATE TABLE my_table39_person(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(20)

);

CREATE  TABLE  my_table40_skill(
    id INT PRIMARY KEY  AUTO_INCREMENT,
    skill VARCHAR(20)
);

CREATE  TABLE  my_table41_person_Skill(
    person_id INT REFERENCES my_table39_person(id),
    skill_id INT REFERENCES my_table40_skill(id),
    PRIMARY KEY (person_id,skill_id)
);









