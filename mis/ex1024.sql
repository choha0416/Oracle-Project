CREATE OR REPLACE PROCEDURE user_create (
    a_userid        IN  users.userid%TYPE, 
    a_username      IN  users.username%TYPE,
    a_userpassword  IN  users.userpassword%TYPE,
    a_userage       IN  users.userage%TYPE,
    a_useremail     IN  users.useremail%TYPE,
    a_rows          OUT PLS_INTEGER
) 
IS
BEGIN
    INSERT INTO users (userid, username, userpassword, userage, useremail)
    VALUES (a_userid, a_username, a_userpassword,  a_userage, a_useremail);
    a_rows := SQL%ROWCOUNT;
    COMMIT;
END;
/
CREATE SEQUENCE SEQ_BNO NOCACHE;


select * from users;





CREATE OR REPLACE FUNCTION user_login(
    a_userid    users.userid%TYPE,
    a_userpassword  users.userpassword%TYPE
) RETURN PLS_INTEGER
IS
    v_userpassword  users.userpassword%TYPE;
    v_result PLS_INTEGER;
BEGIN
    SELECT userpassword INTO v_userpassword
    FROM users
    WHERE userid = a_userid;
    
    IF v_userpassword = a_userpassword THEN
        RETURN 0;
    ELSE
        RETURN 1;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 2;
END;        
commit;

CREATE TABLE accounts(
ano varchar2(20) primary key,
owner varchar2(20) not null,
balance number not null);

select * from accounts;

insert into accounts (ano, owner, balance) 
values ('111-111-1111', '한여름', 1000000);

insert into accounts (ano, owner, balance) 
values ('222-222-2222', '한겨울', 0);

commit;



