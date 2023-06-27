-- Додавання працівників
INSERT INTO worker (ID, NAME, BIRTHDAY, LEVEL, SALARY)
VALUES (1, 'John Doe', '1990-05-15', 'Trainee', 800),
       (2, 'Jane Smith', '1985-09-20', 'Junior', 1200),
       (3, 'Michael Johnson', '1982-02-10', 'Middle', 2500),
       (4, 'Genry Smitt', '1983-05-05', 'Trainee', 900),
       (5, 'Sharlota Smitt', '1985-08-15', 'Middle', 2300),
       (6, 'Michael Mark', '1992-05-18', 'Middle', 2800),
       (7, 'Mark Jons', '1975-02-10', 'Senior', 7500),
       (8, 'Cris Mask', '1989-07-21', 'Junior', 1000),
       (9, 'Sara Johnson', '1988-02-10', 'Middle', 2700),
       (10, 'Emily Williams', '1993-07-02', 'Senior', 5000);

-- Додавання клієнтів
INSERT INTO client (ID, NAME)
VALUES (1, 'ABC Company'),
       (2, 'XYZ Corporation'),
       (3, 'FFG Company'),
       (4, 'GHJ Corporation'),
       (5, 'LKI Company');

-- Додавання проєктів
INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (1, 1, '2023-01-01', '2023-02-27'),
       (2, 2, '2023-03-15', '2024-06-30'),
       (3, 3, '2023-04-10', '2023-05-20'),
       (4, 4, '2022-04-21', '2023-06-21'),
       (5, 5, '2022-05-15', '2023-08-22'),
       (6, 2, '2022-07-20', '2023-09-23'),
       (7, 3, '2022-05-21', '2023-10-24'),
       (8, 4, '2022-04-22', '2023-11-25'),
       (9, 3, '2022-08-23', '2023-12-26'),
       (10, 1, '2022-09-24', '2023-11-27');


-- Додавання працівників до проєктів
-- Проєкт 1
INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES (1, 2),
       (1, 5),
       (1, 4);


-- Проєкт 2
INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES (2, 2),
       (2, 3),
       (2, 4);

-- Проєкт 3
INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES (3, 2),
       (3, 3),
       (3, 4);

-- Проєкт 4
INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES (4, 1),
       (4, 2),
       (4, 3);

-- Проєкт 5
INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES (5, 3),
       (5, 4),
       (5, 5);

-- Проєкт 6
INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES (6, 1),
       (6, 2),
       (6, 4);

-- Проєкт 7
INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES (7, 1),
       (7, 2),
       (7, 3);

-- Проєкт 8
INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES (8, 4),
       (8, 5),
       (8, 3);

-- Проєкт 9
INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES (9, 1),
       (9, 5),
       (9, 4);

-- Проєкт 10
INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES (10, 1),
       (10, 3),
       (10, 4);





