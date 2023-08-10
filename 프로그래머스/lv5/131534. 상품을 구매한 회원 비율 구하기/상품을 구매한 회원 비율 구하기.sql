-- 코드를 입력하세요
WITH tot AS (
	SELECT count(*)
    FROM USER_INFO
    WHERE year(JOINED) = '2021'
)
select 
year(os.sales_date) as YEAR
,month(os.sales_date) as MONTH
,count(distinct os.user_id) as PUCHASED_USERS
,round(count(distinct os.user_id)/(select * from tot), 1)as PUCHASED_RATIO
from ONLINE_SALE os
left outer join USER_INFO ui on os.user_id =  ui.user_id
where year(ui.JOINED) = '2021'
group by YEAR, MONTH
order by YEAR, MONTH

# select 
# *
# from ONLINE_SALE os
# left outer join USER_INFO ui on os.user_id =  ui.user_id
# where year(ui.JOINED) = '2021'