-- 코드를 작성해주세요
with front_end_skil_code as (
    select CODE from SKILLCODES where category = 'Front End'
)


select distinct ID, EMAIL , FIRST_NAME ,LAST_NAME from 
DEVELOPERS join front_end_skil_code on SKILL_CODE & CODE 
order by ID
