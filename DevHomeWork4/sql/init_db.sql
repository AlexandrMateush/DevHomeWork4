-- Створення таблиці "worker"
CREATE TABLE worker (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(1000) NOT NULL,
  BIRTHDAY DATE,
  LEVEL ENUM('Trainee', 'Junior', 'Middle', 'Senior'),
  SALARY INT CHECK (SALARY >= 100 AND SALARY <= 100000)
);

-- Створення таблиці "client"
CREATE TABLE client (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(1000) NOT NULL
);

-- Створення таблиці "project"
CREATE TABLE project (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  CLIENT_ID INT,
  START_DATE DATE,
  FINISH_DATE DATE,
  FOREIGN KEY (CLIENT_ID) REFERENCES client(ID)
);

-- Створення таблиці "project_worker"
CREATE TABLE project_worker (
  PROJECT_ID INT,
  WORKER_ID INT,
  PRIMARY KEY (PROJECT_ID, WORKER_ID),
  FOREIGN KEY (PROJECT_ID) REFERENCES project(ID),
  FOREIGN KEY (WORKER_ID) REFERENCES worker(ID)
);
