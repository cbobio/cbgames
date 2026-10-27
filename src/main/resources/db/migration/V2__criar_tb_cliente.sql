CREATE TABLE tb_cliente (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,

                            nome_cliente VARCHAR(100) NOT NULL,

                            email_cliente VARCHAR(100) NOT NULL UNIQUE,

                            cpf_cliente CHAR(11) NOT NULL UNIQUE,

                            telefone_cliente VARCHAR(20),

                            logradouro VARCHAR(150) NOT NULL,

                            numero VARCHAR(20) NOT NULL,

                            bairro VARCHAR(100) NOT NULL,

                            cidade VARCHAR(100) NOT NULL,

                            estado CHAR(2) NOT NULL,

                            cep CHAR(8) NOT NULL,

                            complemento VARCHAR(100),

                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                                ON UPDATE CURRENT_TIMESTAMP,

                            tb_usuario_id BIGINT NOT NULL,

                            CONSTRAINT fk_cliente_usuario
                                FOREIGN KEY (tb_usuario_id)
                                    REFERENCES tb_usuario(id)
                                    ON DELETE RESTRICT
                                    ON UPDATE CASCADE
);

CREATE INDEX idx_cliente_usuario
    ON tb_cliente(tb_usuario_id);

CREATE INDEX idx_cliente_nome
    ON tb_cliente(nome_cliente);

CREATE INDEX idx_cliente_cpf
    ON tb_cliente(cpf_cliente);