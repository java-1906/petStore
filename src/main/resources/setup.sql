CREATE TABLE animal (
	id number(10) PRIMARY KEY,
	name varchar2(255) NOT NULL check(LENGTH(name)>1),
	safty number(2) NOT NULL CHECK(safty > 0 AND safty <= 10) 
);

CREATE TABLE pet (
	id NUMBER(10) PRIMARY KEY,
	name varchar2(255) NOT NULL CHECK(LENGTH(name) > 1),
	age number(3) CHECK(age > 0),
	animal_id number(10) NOT NULL,
	CONSTRAINT pet_animal FOREIGN KEY (animal_id) 
        REFERENCES ANIMAL (id) ON DELETE CASCADE
);

DROP SEQUENCE animal_seq;
CREATE SEQUENCE animal_seq
    start with 1
    increment by 1;


CREATE OR REPLACE TRIGGER animal_seq_trigger 
BEFORE INSERT ON animal
FOR EACH ROW
BEGIN 
    SELECT animal_seq.nextval INTO :NEW.id from dual;
END;    


INSERT INTO animal (NAME, safty)
VALUES ('Dog', 10);

SELECT * FROM ANIMAL;
SELECT * FROM Pet;

INSERT INTO PET (id, name, age, ANIMAL_ID) VALUES(1, 'Cain', 20, 1);


CREATE OR REPLACE PROCEDURE create_puppy(name IN varchar2, age IN NUMBER, animal_id IN NUMBER, pet_id OUT number)
IS
BEGIN
   INSERT INTO PET (id, name, age, ANIMAL_ID) VALUES (animal_seq.nexval, name, age, ANIMAL_ID);
   pet_id := animal_seq.curval;
END;


DECLARE
    id number(10);
BEGIN
    create_puppy('qu', 5, 1, id);
END;
