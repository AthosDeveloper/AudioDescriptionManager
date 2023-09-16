CREATE TABLE  tb_users_projects(
id_user BIGINT,
id_project BIGINT,
FOREIGN KEY(id_user) REFERENCES tb_users(id_user),
FOREIGN KEY (id_project) REFERENCES tb_projects(id_project)

);