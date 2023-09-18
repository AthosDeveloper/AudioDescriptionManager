CREATE TABLE tb_projects(
id_project BIGINT PRIMARY KEY,
project_name VARCHAR(39) NOT NULL,
description VARCHAR(255),
value_per_minut DECIMAL(10,2),
duration INTEGER NOT NULL,
 category VARCHAR(255),
 total_value DECIMAL(10,2)
);