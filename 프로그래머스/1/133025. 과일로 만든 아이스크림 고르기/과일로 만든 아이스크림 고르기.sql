select fh.FLAVOR from first_half fh
join icecream_info it
on fh.flavor = it.flavor
where it.ingredient_type = "fruit_based"
and fh.flavor in (select flavor 
from FIRST_HALF
where TOTAL_ORDER > 3000)
order by fh.total_order desc;

