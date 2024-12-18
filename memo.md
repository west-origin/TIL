memo
===
```sql
<insert id="insertCategoryReserve" parameterType="...VO">
  <selectKey order = "BEFORE" keyProperty="categoryId" resultType="string">
    SELECT LPAD((MAX(category_id))+1, 4, '0') FROM portal.TB_DC_CATEGORIES
</selectKey>
INSERT INTO
  portal.TB_DC_CATEGORIES (category_id, category_name)
VALUES
  (#{categoryId}, #{cateogoryName})
```

