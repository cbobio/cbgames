CREATE TABLE tb_usuario (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,

                            nome_usuario VARCHAR(100) NOT NULL,

                            email_usuario VARCHAR(100) NOT NULL UNIQUE,

                            login_usuario VARCHAR(50) NOT NULL UNIQUE,

                            senha_usuario VARCHAR(255) NOT NULL,

                            created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                            updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
                                ON UPDATE CURRENT_TIMESTAMP
);