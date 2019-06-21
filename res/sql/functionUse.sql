--���ú���   ע: ��Dual�Ʊ����
--�ַ�����-------------------------------------------
--��дתΪСд
select Upper('fjdWFwjkgGRE') from Dual;

--СдתΪ��д
select Lower('fjdWFwjkgGRE') from Dual;

--����ĸ��д,����Сд
select InitCap('fjdWFwjkgGRE') from Dual;

--�ַ�����(������Ϊ����,����)
select Concat('fef','zzz') from Dual;
--������Ƕ
select Concat('contect',concat('fef','zzz')) from Dual;

--��ȡ�ַ���(�±�Ϊ��������,Ϊ���򵹹���
select substr('fbekgkef',1,5) from Dual;  --fbekg
select substr('fbekgkef',0,5) from Dual;  --fbekg
select substr('fbekgkef',-2,5) from Dual;  --ef

--�״��±��λ��,�����ڷ���0
select Instr('fefje43k5','z') from Dual;

--ȥ���ַ�:ָ�������һ����,�ҵ���ɾ������ֹͣ  LTrim(),RTrim(),Trim();
select LTrim('fefje43k5','43') from Dual;  --je43k5
select LTrim('fefje43k5','43') from Dual;  --fefje43k5

select RTrim('fefje43k5','k5') from Dual;  --fefje43
select RTrim('fefje43k5','43') from Dual;  --fefje43k5
--��ͷ�ո�
select Trim('  fefje 43k5  ') from Dual;  --fefje 43k5
--�󳤶�(����Ϊһ��)
select length('fefje') from Dual;  --5
select length('������') from Dual;  --3

--��ѧ����---------------------------------------------------
--��������
select Round(1223.32564,2) from Dual;  --1223.33
select Round(1223.32564,0) from Dual;  --1223
select Round(1223.32564,-2) from Dual;  --1200

--�ض�  С��ֱ�Ӷ��� ����ΪO
select Trunc(1223.32564,2) from Dual;  --1223.32
select Trunc(1223.32564,0) from Dual;  --1223
select Round(1223.32564,-2) from Dual;  --1200

--N��P�η�
select power(2,3) from Dual;  -- 8

--����С�ڵ���N���������
select Floor(23.19) from Dual;  -- 23
select Floor(-23.89) from Dual;  -- -24

--���ش��ڵ���N����С����
select ceil(23.19) from Dual;  -- 24
select ceil(-23.89) from Dual;  -- -23
--n�ľ���ֵ
select abs(-565) from Dual;  -- 565

--����
select mod(23,25) from Dual;  -- 23
select mod(-21,25) from Dual;  -- -21
select mod(-21,-25) from Dual;  -- -21
select mod(21,-25) from Dual;  -- 21


--���ں���---------------------------------------
--ϵͳʱ��,������ʱ��
select sysdate from Dual;   --2009-9-29 20:17:36
--һ�����ڼ�����
select sysdate+6 from Dual;  --2009-10-5 20:19:41
--���ڼӼ�Сʱ��
select sysdate+ 2/24 from Dual;  --2009-9-29 22:21:06
--�Ӽ�������
select sysdate+ 2/1440 from Dual;  --2009-9-29 20:23:27
--������֮������
select to_date('2010-5-30','yyyy-mm-dd')-to_date('2009-5-30','yyyy-mm-dd')  from Dual; --365
--�����ڼ���·�
select months_Between( to_date('2010-5-30','yyyy-mm-dd'),
                       to_date('2009-5-30','yyyy-mm-dd'))
  from Dual; --12
  
--�������ڼ�N����
select add_months( to_date('2010-5-30','yyyy-mm-dd'),10)
   from Dual; --2011-3-30
--date ��֮��ĵ�һ�� ���ڼ� ������
select next_day(sysdate,'����һ') from Dual; --Ϊ���Ļ���
select next_day(sysdate,'Monday') from Dual;  --Ӣ�Ļ���
--DATE�����µ����һ�������
select Last_day(sysdate) from Dual;

--�����Ի���(עɾ����޸�)
Alter session set NLS_Language = 'American'; --Ӣ��
Alter session set NLS_Language = 'Simplified chinese';  --��������

--���ڵ���������
--���� ���� ������
select Round(sysdate,'day') from Dual;  --2009-9-29 20:23:27
--���� �� ������(��15 ,16��Ϊ�м��)
select Round(to_date('2010-5-16','yyyy-mm-dd'),'month') from Dual;  --2010-5-1
--���� �� ������ (6��30Ϊ�м��)
select Round(to_date('2010-6-30','yyyy-mm-dd'),'year') from Dual;  --2010-1-1
--���� ʱ�� ������(12.0.0 Ϊ�м��)
select Round(to_date('2010-6-30 12:20:30 ','yyyy-mm-dd hh24:MI:ss')) from Dual;  --2010-7-1


--ת������
--�ַ�תΪ����() to_number()
select  to_number('12.234') from Dual;   --12.234
select  to_number('12.2','9999.00') from Dual;   --12.2
select  to_number('12.234','0999.00') from Dual;  --��Ч���� ��ʽ��ͷ��Ҫ���ڸ���������

select  '12.234'*2 from Dual;   --24.468  �Զ�ת��

--����תΪ�ַ�  to_char()
select to_char(1223.23) from Dual;   --1223.23
select to_char(1223.2563,'99999.00') from Dual;   --  1223.26  ��������
select to_char(1223.2563,'99999') from Dual;   --  1223.26  ��������
select to_char(1223.2233,'99999.00') from Dual;   --  1223.22
select to_char(1223.2233,'099999.00') from Dual;   --  001223.22
select to_char(1223.2233,'FM$99999.00') from Dual;   --  $1223.22 
select to_char(1223.2233,'fm99999.00') from Dual;   --  1223.22  (�Կո� fm)
select to_char(1223.2233,'fmL99999.00') from Dual;   --RMB1223.22
select to_char(1223.2233,'L99999.00') from Dual;   --RMB1223.22

--����תΪ�ַ�  to_date()
select to_date('2010-6','yyyy-mm') from Dual;  --2010-6-30 12:20:30
select to_date('2010-6-30 10:20:30 ','YY-mm-dd hh:MI:ss AM') from Dual;  --2010-6-30 12:20:30

--��������NVL
select NVL(null,23) from Dual;  --���ص�һ��Ϊ�ǿյ�ֵ

select NVL2('fff',123.12,null) from Dual;  --��һ��Ϊ�շ��ص�����,�ǿշ��صڶ���

select coalEsce('fff','434','123') from Dual;  --���ص�һ��Ϊ�ǿյ�ֵ

