ALTER TABLE employees
    ADD cpf VARCHAR(255) NOT NULL AFTER name;

ALTER TABLE employees
    ADD CONSTRAINT uc_employees_cpf UNIQUE (cpf);