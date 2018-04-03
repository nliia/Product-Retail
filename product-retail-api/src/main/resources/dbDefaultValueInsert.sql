INSERT INTO users(id, name, surname, is_superuser, password, phone_number, role, username)
    VALUES (33,'Суперюзер', 'Суперюзерович', TRUE , '$2a$10$ELUROh8MX9106LuZW26ujOPVf78oxonIuu0vZqSQln3MnUto48e9e', '88005553535', 'SUPERUSER', 'admin');
INSERT INTO department(id, address, name, is_warehouse) VALUES (1, 'Адрес', 'Основной склад', TRUE );
INSERT INTO department(id, address, name, is_warehouse, parent_id) VALUES (2, 'Адрес магазина', 'Магазин 1', FALSE , (SELECT id from department where name = 'Основной склад' and is_warehouse is true));
INSERT INTO department(id, address, name, is_warehouse, parent_id) VALUES (3, 'Адрес магазина', 'Магазин 2', FALSE , (SELECT id from department where name = 'Основной склад' and is_warehouse is true));
INSERT INTO department(id, address, name, is_warehouse, parent_id) VALUES (4, 'Адрес магазина', 'Магазин 3', FALSE , (SELECT id from department where name = 'Основной склад' and is_warehouse is true));
INSERT INTO department(id, address, name, is_warehouse, parent_id) VALUES (5, 'Адрес магазина', 'Магазин 4', FALSE , (SELECT id from department where name = 'Основной склад' and is_warehouse is true));
INSERT INTO department(id, address, name, is_warehouse, parent_id) VALUES (6, 'Адрес магазина', 'Магазин 5', FALSE , (SELECT id from department where name = 'Основной склад' and is_warehouse is true));