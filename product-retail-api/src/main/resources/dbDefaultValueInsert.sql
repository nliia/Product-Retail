INSERT INTO users (id, name, surname, is_superuser, password, phone_number, role, username)
VALUES (33, 'Суперюзер', 'Суперюзерович', TRUE, '$2a$10$ELUROh8MX9106LuZW26ujOPVf78oxonIuu0vZqSQln3MnUto48e9e',
        '88005553535', 'SUPERUSER', 'admin');
INSERT INTO department (id, address, name, is_warehouse) VALUES (1, 'Адрес', 'Основной склад', TRUE);
INSERT INTO department (id, address, name, is_warehouse, parent_id)
VALUES (2, 'Адрес магазина', 'Магазин 1', FALSE, (SELECT id
                                                  FROM department
                                                  WHERE name = 'Основной склад' AND is_warehouse IS TRUE));
INSERT INTO department (id, address, name, is_warehouse, parent_id)
VALUES (3, 'Адрес магазина', 'Магазин 2', FALSE, (SELECT id
                                                  FROM department
                                                  WHERE name = 'Основной склад' AND is_warehouse IS TRUE));
INSERT INTO department (id, address, name, is_warehouse, parent_id)
VALUES (4, 'Адрес магазина', 'Магазин 3', FALSE, (SELECT id
                                                  FROM department
                                                  WHERE name = 'Основной склад' AND is_warehouse IS TRUE));
INSERT INTO department (id, address, name, is_warehouse, parent_id)
VALUES (5, 'Адрес магазина', 'Магазин 4', FALSE, (SELECT id
                                                  FROM department
                                                  WHERE name = 'Основной склад' AND is_warehouse IS TRUE));
INSERT INTO department (id, address, name, is_warehouse, parent_id)
VALUES (6, 'Адрес магазина', 'Магазин 5', FALSE, (SELECT id
                                                  FROM department
                                                  WHERE name = 'Основной склад' AND is_warehouse IS TRUE));

INSERT INTO users (id, name, surname, is_superuser, password, phone_number, role, username, status)
VALUES
  (1, 'Вася', 'Пупкин', FALSE, '$2a$10$ELUROh8MX9106LuZW26ujOPVf78oxonIuu0vZqSQln3MnUto48e9e', '88005553535',
   'WAREHOUSE_WORKER', 'worker', 'working');
INSERT INTO users (id, name, surname, is_superuser, password, phone_number, role, username, status)
VALUES
  (2, 'Иван', 'Иванов', FALSE, '$2a$10$ELUROh8MX9106LuZW26ujOPVf78oxonIuu0vZqSQln3MnUto48e9e', '88005553535',
   'WAREHOUSE_WORKER', 'worker2', 'vacation');
INSERT INTO users (id, name, surname, is_superuser, password, phone_number, role, username, status)
VALUES
  (3, 'Максим', 'Горький', FALSE, '$2a$10$ELUROh8MX9106LuZW26ujOPVf78oxonIuu0vZqSQln3MnUto48e9e', '88005553535',
   'WAREHOUSE_WORKER', 'worker3', 'working');

INSERT INTO users (id, name, surname, is_superuser, password, phone_number, role, username, status)
VALUES
  (4, 'Антон', 'Городецкий', FALSE, '$2a$10$ELUROh8MX9106LuZW26ujOPVf78oxonIuu0vZqSQln3MnUto48e9e', '88005553535',
   'SELLER', 'seller', 'sick');

INSERT INTO users (id, name, surname, is_superuser, password, phone_number, role, username, status)
VALUES
  (5, 'Лев', 'Толстой', FALSE, '$2a$10$ELUROh8MX9106LuZW26ujOPVf78oxonIuu0vZqSQln3MnUto48e9e', '88005553535',
   'SELLER', 'seller2', 'working');

INSERT INTO users (id, name, surname, is_superuser, password, phone_number, role, username, status)
VALUES
  (6, 'Федор', 'Тютчев', FALSE, '$2a$10$ELUROh8MX9106LuZW26ujOPVf78oxonIuu0vZqSQln3MnUto48e9e', '88005553535',
   'SELLER', 'seller3', 'working');