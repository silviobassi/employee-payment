SET foreign_key_checks = 0;

DELETE FROM employees;
DELETE FROM advance_monies;
DELETE FROM benefits;
DELETE FROM withdrawals;

SET foreign_key_checks = 1;
ALTER TABLE employees AUTO_INCREMENT = 1;
ALTER TABLE advance_monies AUTO_INCREMENT = 1;
ALTER TABLE benefits AUTO_INCREMENT = 1;
ALTER TABLE withdrawals AUTO_INCREMENT = 1;

INSERT INTO employees (code, cpf, name, daily_value)
VALUE (UUID(), '25782713801', 'Silvio Luiz Bassi', 100.00);
INSERT INTO employees (code, cpf, name, daily_value)
VALUE (UUID(),'63012271074', 'Pedro Oliveira Bassi', 70.00);
INSERT INTO employees (code, cpf, name, daily_value)
VALUE (UUID(), '88628357017','Jefferson Serene', 90.00);
INSERT INTO employees (code, cpf, name, daily_value)
VALUE (UUID() ,'46423266000' ,'Marcos Costa', 160.00);
INSERT INTO employees (code, cpf, name, daily_value)
VALUE (UUID() ,'58961321820' ,'Luiz Carlos Bassi', 170.00);
INSERT INTO employees (code, cpf, name, daily_value)
VALUE (UUID(), '42278269003', 'Pedro Oliveira Bassi', 70.00);
INSERT INTO employees (code, cpf, name, daily_value)
VALUE (UUID(), '32359414011', 'Helton Costa', 100.00);


INSERT INTO advance_monies (value, description, employee_id, date)
    VALUE (160.00, 'Conserto do automóvel', 4, utc_timestamp);
INSERT INTO advance_monies (value, description, employee_id, date)
    VALUE (100.00, 'Comprar mantimentos', 7, utc_timestamp);
INSERT INTO advance_monies (value, description, employee_id, date)
    VALUE (15.90, 'Marmita', 4, utc_timestamp);
INSERT INTO advance_monies (value, description, employee_id, date)
    VALUE (17.90, 'Marmita', 7, utc_timestamp);



