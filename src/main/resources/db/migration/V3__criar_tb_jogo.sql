CREATE TABLE tb_jogo (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,

                         nome_jogo VARCHAR(100) NOT NULL,

                         genero_jogo VARCHAR(50),

                         plataforma_jogo VARCHAR(50),

                         desenvolvedora VARCHAR(100),

                         ano_lancamento INT,

                         preco DECIMAL(10,2) NOT NULL,

                         quantidade_estoque INT NOT NULL DEFAULT 0,

                         estoque_minimo INT NOT NULL DEFAULT 5,

                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                             ON UPDATE CURRENT_TIMESTAMP,

                         CONSTRAINT chk_jogo_estoque
                             CHECK (quantidade_estoque >= 0)
);

CREATE INDEX idx_jogo_nome
    ON tb_jogo(nome_jogo);

CREATE INDEX idx_jogo_plataforma
    ON tb_jogo(plataforma_jogo);