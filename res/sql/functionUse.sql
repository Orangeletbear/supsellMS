--内置函数   注: 用Dual哑表测试
--字符函数-------------------------------------------
--大写转为小写
select Upper('fjdWFwjkgGRE') from Dual;

--小写转为大写
select Lower('fjdWFwjkgGRE') from Dual;

--首字母大写,其它小写
select InitCap('fjdWFwjkgGRE') from Dual;

--字符连接(参数可为数字,日期)
select Concat('fef','zzz') from Dual;
--函数内嵌
select Concat('contect',concat('fef','zzz')) from Dual;

--截取字符串(下标为正负都可,为负则倒过来
select substr('fbekgkef',1,5) from Dual;  --fbekg
select substr('fbekgkef',0,5) from Dual;  --fbekg
select substr('fbekgkef',-2,5) from Dual;  --ef

--首次下标的位置,不存在返回0
select Instr('fefje43k5','z') from Dual;

--去除字符:指定方向第一个找,找到则删除否则停止  LTrim(),RTrim(),Trim();
select LTrim('fefje43k5','43') from Dual;  --je43k5
select LTrim('fefje43k5','43') from Dual;  --fefje43k5

select RTrim('fefje43k5','k5') from Dual;  --fefje43
select RTrim('fefje43k5','43') from Dual;  --fefje43k5
--两头空格
select Trim('  fefje 43k5  ') from Dual;  --fefje 43k5
--求长度(汉字为一个)
select length('fefje') from Dual;  --5
select length('邝燕南') from Dual;  --3

--数学函数---------------------------------------------------
--四舍五入
select Round(1223.32564,2) from Dual;  --1223.33
select Round(1223.32564,0) from Dual;  --1223
select Round(1223.32564,-2) from Dual;  --1200

--截断  小数直接丢了 整数为O
select Trunc(1223.32564,2) from Dual;  --1223.32
select Trunc(1223.32564,0) from Dual;  --1223
select Round(1223.32564,-2) from Dual;  --1200

--N的P次方
select power(2,3) from Dual;  -- 8

--返回小于等于N的最大整数
select Floor(23.19) from Dual;  -- 23
select Floor(-23.89) from Dual;  -- -24

--返回大于等于N的最小整数
select ceil(23.19) from Dual;  -- 24
select ceil(-23.89) from Dual;  -- -23
--n的绝对值
select abs(-565) from Dual;  -- 565

--求佘
select mod(23,25) from Dual;  -- 23
select mod(-21,25) from Dual;  -- -21
select mod(-21,-25) from Dual;  -- -21
select mod(21,-25) from Dual;  -- 21


--日期函数---------------------------------------
--系统时间,服务器时间
select sysdate from Dual;   --2009-9-29 20:17:36
--一个日期加天数
select sysdate+6 from Dual;  --2009-10-5 20:19:41
--日期加减小时数
select sysdate+ 2/24 from Dual;  --2009-9-29 22:21:06
--加减分钟数
select sysdate+ 2/1440 from Dual;  --2009-9-29 20:23:27
--两日期之的天数
select to_date('2010-5-30','yyyy-mm-dd')-to_date('2009-5-30','yyyy-mm-dd')  from Dual; --365
--两日期间的月份
select months_Between( to_date('2010-5-30','yyyy-mm-dd'),
                       to_date('2009-5-30','yyyy-mm-dd'))
  from Dual; --12
  
--给定日期加N个月
select add_months( to_date('2010-5-30','yyyy-mm-dd'),10)
   from Dual; --2011-3-30
--date 求之后的第一个 星期几 的日期
select next_day(sysdate,'星期一') from Dual; --为中文环境
select next_day(sysdate,'Monday') from Dual;  --英文环境
--DATE所在月的最后一天的日期
select Last_day(sysdate) from Dual;

--改语言环境(注删表的修改)
Alter session set NLS_Language = 'American'; --英文
Alter session set NLS_Language = 'Simplified chinese';  --简体中文

--日期的四舍五入
--根据 星期 来舍入
select Round(sysdate,'day') from Dual;  --2009-9-29 20:23:27
--根据 日 来舍入(以15 ,16号为中间点)
select Round(to_date('2010-5-16','yyyy-mm-dd'),'month') from Dual;  --2010-5-1
--根据 月 来舍入 (6月30为中间点)
select Round(to_date('2010-6-30','yyyy-mm-dd'),'year') from Dual;  --2010-1-1
--根据 时间 来舍入(12.0.0 为中间点)
select Round(to_date('2010-6-30 12:20:30 ','yyyy-mm-dd hh24:MI:ss')) from Dual;  --2010-7-1


--转换函数
--字符转为数字() to_number()
select  to_number('12.234') from Dual;   --12.234
select  to_number('12.2','9999.00') from Dual;   --12.2
select  to_number('12.234','0999.00') from Dual;  --无效数字 格式两头都要大于给出的数字

select  '12.234'*2 from Dual;   --24.468  自动转换

--数字转为字符  to_char()
select to_char(1223.23) from Dual;   --1223.23
select to_char(1223.2563,'99999.00') from Dual;   --  1223.26  四舍五入
select to_char(1223.2563,'99999') from Dual;   --  1223.26  四舍五入
select to_char(1223.2233,'99999.00') from Dual;   --  1223.22
select to_char(1223.2233,'099999.00') from Dual;   --  001223.22
select to_char(1223.2233,'FM$99999.00') from Dual;   --  $1223.22 
select to_char(1223.2233,'fm99999.00') from Dual;   --  1223.22  (对空格 fm)
select to_char(1223.2233,'fmL99999.00') from Dual;   --RMB1223.22
select to_char(1223.2233,'L99999.00') from Dual;   --RMB1223.22

--日期转为字符  to_date()
select to_date('2010-6','yyyy-mm') from Dual;  --2010-6-30 12:20:30
select to_date('2010-6-30 10:20:30 ','YY-mm-dd hh:MI:ss AM') from Dual;  --2010-6-30 12:20:30

--其它函数NVL
select NVL(null,23) from Dual;  --返回第一个为非空的值

select NVL2('fff',123.12,null) from Dual;  --第一项为空返回第三项,非空返回第二项

select coalEsce('fff','434','123') from Dual;  --返回第一个为非空的值

