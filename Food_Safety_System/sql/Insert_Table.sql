-------Insert ADMIN Table-------
INSERT INTO admin
(admin_id, admin_username, admin_password) 
VALUES(1,'raju@gmail.com','12345');
INSERT INTO admin
(admin_id, admin_username, admin_password) 
VALUES(2,'admin','admin');

-------Insert USER Table-------
INSERT INTO user
(user_id, user_username, user_password) 
VALUES(1,'govind@gmail.com','54321');

-------Insert FOOD Table-------
INSERT INTO food
(food_id, food_name, m_f_date, expiry_date)
VALUES(1,'milk',TO_DATE('2020-04-13', 'YYYY-MM-DD'),TO_DATE('2020-04-14', 'YYYY-MM-DD'));
select * from food;
INSERT INTO food
(food_id, food_name, m_f_date, expiry_date)
VALUES(2,'Tomato',TO_DATE('2020-04-13', 'YYYY-MM-DD'),TO_DATE('2020-04-20', 'YYYY-MM-DD')); 

--------Insert CATEGORY Table-------
INSERT INTO category
(category_id, category_name)
VALUES(1,'One Day Life Span');
INSERT INTO subcategory
(category_id, category_name)
VALUES(2,'Two Day Life Span');
INSERT INTO category
(category_id, category_name)
VALUES(3,'One Week Life Span');
INSERT INTO category
(category_id, category_name)
VALUES(4,'Long Day Life Span');

--------Insert SUB_CATEGORY Table-------
INSERT INTO sub_category
(sub_category_id, sub_category_name)
VALUES(1,'Dairy Foods');
INSERT INTO sub_category
(sub_category_id, sub_category_name)
VALUES(2,'Vegetables');
INSERT INTO sub_category
(sub_category_id, sub_category_name)
VALUES(3,'Grains');
INSERT INTO sub_category
(sub_category_id, sub_category_name)
VALUES(4,'Meats');

--------Insert MAIN_CATEGORY Table-------
INSERT INTO main_category
(main_category_id, sub_category_id, category_id,food_id)
VALUES(1,1,1,1);
INSERT INTO main_category
(main_category_id, sub_category_id, category_id,food_id)
VALUES(2,2,3,2);
INSERT INTO main_category
(main_category_id, sub_category_id, category_id,food_id)
VALUES(3,3,3,3);
INSERT INTO main_category
(main_category_id, sub_category_id, category_id,food_id)
VALUES(4,4,1,4);
INSERT INTO main_category
(main_category_id, sub_category_id, category_id,food_id)
VALUES(5,1,3,5);
INSERT INTO main_category
(main_category_id, sub_category_id, category_id,food_id)
VALUES(6,2,3,6);
INSERT INTO main_category
(main_category_id, sub_category_id, category_id,food_id)
VALUES(7,3,3,7);
INSERT INTO main_category
(main_category_id, sub_category_id, category_id,food_id)
VALUES(8,4,1,8);
INSERT INTO main_category
(main_category_id, sub_category_id, category_id,food_id)
VALUES(9,1,1,9);
INSERT INTO main_category
(main_category_id, sub_category_id, category_id,food_id)
VALUES(10,2,3,10);
INSERT INTO main_category
(main_category_id, sub_category_id, category_id,food_id)
VALUES(11,3,3,11);
INSERT INTO main_category
(main_category_id, sub_category_id, category_id,food_id)
VALUES(12,4,1,12);
INSERT INTO main_category
(main_category_id, sub_category_id, category_id,food_id)
VALUES(13,1,4,13);
INSERT INTO main_category
(main_category_id, sub_category_id, category_id,food_id)
VALUES(14,5,4,14);

SELECT food.food_id,food.food_name FROM food JOIN main_category ON food.food_id=main_category.food_id
INNER JOIN category on category.category_id=main_category.category_id
WHERE main_category.category_id=1;
