CREATE TABLE tb_projects(
id_project BIGINT PRIMARY KEY,
projectName VARCHAR(39) NOT NULL,
description VARCHAR(255),
valueMinuts DECIMAL(10,2),
duration INTEGER NOT NULL,
 category VARCHAR(255)
);