CREATE TABLE tb_users (
    id_user BIGINT  PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
    position VARCHAR(255) NOT NULL,

    percentage DECIMAL(10,2),
value_to_receive DECIMAL(10,2)
);