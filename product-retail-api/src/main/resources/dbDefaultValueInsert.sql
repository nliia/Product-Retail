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

INSERT INTO users (id, name, surname, is_superuser, password, phone_number, role, username, status, department_id)
VALUES
  (1, 'Вася', 'Пупкин', FALSE, '$2a$10$ELUROh8MX9106LuZW26ujOPVf78oxonIuu0vZqSQln3MnUto48e9e', '88005553535',
   'WAREHOUSE_WORKER', 'worker', 'working', 1);
INSERT INTO users (id, name, surname, is_superuser, password, phone_number, role, username, status, department_id)
VALUES
  (2, 'Иван', 'Иванов', FALSE, '$2a$10$ELUROh8MX9106LuZW26ujOPVf78oxonIuu0vZqSQln3MnUto48e9e', '88005553535',
   'WAREHOUSE_WORKER', 'worker2', 'vacation', 1);
INSERT INTO users (id, name, surname, is_superuser, password, phone_number, role, username, status, department_id)
VALUES
  (3, 'Максим', 'Горький', FALSE, '$2a$10$ELUROh8MX9106LuZW26ujOPVf78oxonIuu0vZqSQln3MnUto48e9e', '88005553535',
   'WAREHOUSE_WORKER', 'worker3', 'working', 1);

INSERT INTO users (id, name, surname, is_superuser, password, phone_number, role, username, status, department_id)
VALUES
  (4, 'Антон', 'Городецкий', FALSE, '$2a$10$ELUROh8MX9106LuZW26ujOPVf78oxonIuu0vZqSQln3MnUto48e9e', '88005553535',
   'SELLER', 'seller', 'sick', 2);

INSERT INTO users (id, name, surname, is_superuser, password, phone_number, role, username, status, department_id)
VALUES
  (5, 'Лев', 'Толстой', FALSE, '$2a$10$ELUROh8MX9106LuZW26ujOPVf78oxonIuu0vZqSQln3MnUto48e9e', '88005553535',
   'SELLER', 'seller2', 'working', 3);

INSERT INTO users (id, name, surname, is_superuser, password, phone_number, role, username, status, department_id)
VALUES
  (6, 'Федор', 'Тютчев', FALSE, '$2a$10$ELUROh8MX9106LuZW26ujOPVf78oxonIuu0vZqSQln3MnUto48e9e', '88005553535',
   'SELLER', 'seller3', 'working', 4);

INSERT INTO item (id, name, price)
VALUES (1, 'Баклажан', 40);

INSERT INTO item (id, name, price)
VALUES (2, 'Огурец', 30);

INSERT INTO item (id, name, price)
VALUES (3, 'Хлеб', 20);

INSERT INTO item (id, name, price)
VALUES (4, 'Печенье', 35);

INSERT INTO item (id, name, price)
VALUES (5, 'Арбуз', 25);

INSERT INTO department_link_item (id, count, department_id, item_id)
VALUES (1, 24, 1, 2);

INSERT INTO department_link_item (id, count, department_id, item_id)
VALUES (2, 27, 1, 3);

INSERT INTO department_link_item (id, count, department_id, item_id)
VALUES (3, 50, 2, 1);

INSERT INTO department_link_item (id, count, department_id, item_id)
VALUES (4, 50, 2, 2);

INSERT INTO department_link_item (id, count, department_id, item_id)
VALUES (5, 1, 2, 3);

INSERT INTO department_link_item (id, count, department_id, item_id)
VALUES (6, 15, 3, 4);

INSERT INTO department_link_item (id, count, department_id, item_id)
VALUES (7, 5, 3, 5);

INSERT INTO department_link_item (id, count, department_id, item_id)
VALUES (8, 50, 4, 5);

INSERT INTO department_link_item (id, count, department_id, item_id)
VALUES (9, 65, 5, 1);

INSERT INTO department_link_item (id, count, department_id, item_id)
VALUES (10, 46, 6, 2);

INSERT INTO task (id, description, status, department_id, task_creator_id, task_maker_id)
VALUES (1, "to do job", 2, 2, 33, 4)

INSERT INTO task (id, description, status, department_id, task_creator_id, task_maker_id)
VALUES (2, "to do job", 0, 1, 33, 2)

INSERT INTO task (id, description, status, department_id, task_creator_id, task_maker_id)
VALUES (3, "to do job", 0, 1, 33, 1)

INSERT INTO task (id, description, status, department_id, task_creator_id, task_maker_id)
VALUES (4, "to do job", 0, 1, 33, 3)