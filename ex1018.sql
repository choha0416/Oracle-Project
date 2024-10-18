select *
FROM EMP
WHERE UPPER(ENAME)= UPPER('scott');

select * 
from emp
where upper(ename) like upper('%scott%');

SELECT ename,length(ename)
from emp;

//���ڿ� ����
select ename,length(ename)
from emp
where length(ename)>=5;

//���� �Լ�
select *
from emp
where instr(ename,'s')>0;

select 'oracle',
LPAD('oracle',10,'#') as lpad_1,
RPAD('oracle',10,'*') as rpad_1,
RPAD('oracle',10) as rpad_2
from dual;

//���ڿ� ��ġ��
SELECT CONCAT(EMPNO,ENAME),
CONCAT(EMPNO,CONCAT(':',ENAME))
FROM EMP
WHERE ENAME = 'SCOTT';

SELECT '['||TRIM(' __ORACLE__ ')||']' AS TRIM

FROM DUAL;

//�ݿø�
SELECT ROUND(1234.5678) AS ROUND,
ROUND(1234.5678,0) AS ROUND_0,
ROUND(1234.5678,1) AS ROUND_1,
ROUND(1234.5678,-1) AS ROUND_MINUS1
FROM DUAL;

//TRUNC ����
SELECT TRUNC(1234.5678) AS TRUNC,
TRUNC(1234.5678,0) AS TRUNC_0,
TRUNC(1234.5678,2) AS TRUNC_1,
TRUNC(1234.5678,2) AS TRUNC_2,
TRUNC(1234.5678,-1) AS TRUNC_M1,
TRUNC(1234.5678,-2) AS TRUNC_M2
FROM DUAL;

//CEIL FLOOR

SELECT CEIL(3.14),
FLOOR(3.14),
CEIL(-3.14),
FLOOR(-3.14)
FROM DUAL;

//MOD ������

SELECT MOD(15,6),
MOD(10,2),
MOD(11,2)
FROM DUAL;

//SYSDATE ���� ��¥�� �ð�
SELECT SYSDATE AS NOW,
SYSDATE-1 AS YESTERDAY,
SYSDATE+1 AS TOMORROW
FROM DUAL;

//ADD_MONTHS ��� ���� ��¥

SELECT SYSDATE,
ADD_MONTHS(SYSDATE,3)
FROM DUAL;

SELECT EMPNO, ENAME, HIREDATE,
ADD_MONTHS(HIREDATE,120) AS WORK10YEAR
FROM EMP;

//MONTHS_BETWEEN
SELECT EMPNO, ENAME, HIREDATE, SYSDATE,
MONTHS_BETWEEN(SYSDATE,HIREDATE)
FROM EMP;

//NEXT_DAY LAST_DAY
SELECT SYSDATE,
NEXT_DAY(SYSDATE,'������'),
LAST_DAY(SYSDATE)
FROM DUAL;

//�ڷ��� ��ȯ
SELECT SYSDATE,
TO_CHAR(SYSDATE, 'HH24:MI:SS') AS HHMISS,
TO_CHAR(SYSDATE, 'HH12:MI:SS AM') AS HHMISS_AM,
TO_CHAR(SYSDATE, 'HH24:MI:SS P.M') AS HHMISS_PM
FROM DUAL;

//�ڷ��� ��ȯ

SELECT TO_NUMBER('1,300','999,999') -
TO_NUMBER('1,500','999,999')
FROM DUAL;

//NULL NVL
SELECT EMPNO, ENAME,SAL,COMM,
SAL+COMM,
NVL(COMM,0),
SAL+NVL(COMM,0)
FROM EMP;

//NVL2
SELECT EMPNO, ENAME, COMM,
NVL2(COMM, 'O', 'X'),
NVL2(COMM, SAL*12+COMM, SAL*12)AS ANNSAL
FROM EMP;

//DECODE
SELECT EMPNO, ENAME, JOB, SAL,
DECODE(JOB,
'MANAGER',SAL*1.1,
'SALESMAN', SAL*1.05,
'ANALYST',SAL,
SAL*1.03) AS UPSAL
FROM EMP;

//CASE
SELECT EMPNO, ENAME,JOB,SAL,
CASE JOB
WHEN'MANAGER'THEN SAL*1.1
WHEN'SALESMAN'THEN SAL*1.05
WHEN'ANALYST'THEN SAL
ELSE SAL*1.03
END AS UPSAL
FROM EMP;

SELECT EMPNO, ENAME, COMM,
CASE
WHEN COMM IS NULL THEN'�ش����'
WHEN COMM = 0 THEN'�������'
WHEN COMM>0 THEN '����: ' ||COMM
END AS COMM_TEXT
FROM EMP;