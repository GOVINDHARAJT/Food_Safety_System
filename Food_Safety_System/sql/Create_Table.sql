------Create ADMIN Table--------
CREATE TABLE admin (
admin_id NUMBER(10) NOT NULL,
admin_username VARCHAR(20) NOT NULL,
admin_password VARCHAR(20) NOT NULL,
CONSTRAINT pk_admin PRIMARY KEY(admin_id)
);

------Create USER Table--------
CREATE TABLE usertable (
user_mobileno NUMBER(20) NOT NULL,
user_username VARCHAR(20) NOT NULL,
user_password VARCHAR(20) NOT NULL,
CONSTRAINT pk_user PRIMARY KEY(user_mobileno)
);

------Create FOOD Table--------
CREATE TABLE food (
food_id NUMBER(10) NOT NULL,
food_type VARCHAR(20) NOT NULL,
food_name VARCHAR(20) NOT NULL,
m_f_date DATE NOT NULL,
expiry_date DATE NOT NULL,
CONSTRAINT pk_food PRIMARY KEY(food_id)
);

------Create CATEGORY Table--------
CREATE TABLE category (
category_id NUMBER(10) NOT NULL,
category_name VARCHAR(20) NOT NULL,
CONSTRAINT pk_category PRIMARY KEY(category_id)
);

------Create SUB_CATEGORY Table--------
CREATE TABLE sub_category (
sub_category_id NUMBER(10) NOT NULL,
sub_category_name VARCHAR(20) NOT NULL,
CONSTRAINT pk_subcategory PRIMARY KEY(sub_category_id)
);

------Create MAIN_CATEGORY Table--------
CREATE TABLE main_category(
main_category_id NUMBER(10) NOT NULL,
sub_category_id NUMBER(10) NOT NULL,
category_id NUMBER(10) NOT NULL,
food_id NUMBER(10) NOT NULL,
CONSTRAINT main_category PRIMARY KEY(main_category_id),
CONSTRAINT fk_maincategory1 FOREIGN KEY(sub_category_id) REFERENCES sub_category(sub_category_id),
CONSTRAINT fk_maincategory2 FOREIGN KEY(category_id) REFERENCES category(category_id),
CONSTRAINT fk_maincategory3 FOREIGN KEY(food_id) REFERENCES food(food_id)
);

-------Create FEEDBACK Table---------
CREATE TABLE feedbacks(
user_mobileno NUMBER(20) NOT NULL,
user_username VARCHAR(30) NOT NULL,
food_name VARCHAR(30) NOT NULL,
comments VARCHAR(50) NOT NULL,
CONSTRAINT fk_feedbacks1 FOREIGN KEY(user_mobileno) REFERENCES usertable(user_mobileno)
);