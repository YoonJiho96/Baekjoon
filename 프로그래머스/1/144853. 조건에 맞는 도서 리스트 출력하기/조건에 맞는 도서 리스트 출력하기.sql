-- 코드를 입력하세요
SELECT BOOK_ID, DATE_FORMAT(published_date, '%Y-%m-%d') 'PUBLISHED_DATE' 
from book 
where category = '인문'
and YEAR(PUBLISHED_DATE) = 2021 
order by published_date;