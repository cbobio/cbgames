CREATE TABLE tb_log (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,

                        acao_log ENUM(
        'CADASTRO',
        'ALTERACAO',
        'EXCLUSAO',
        'VENDA',
        'ESTOQUE'
    ) NOT NULL,

                        descricao_log VARCHAR(255),

                        data_movimentacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                        tb_usuario_id BIGINT NOT NULL,

                        tb_venda_id BIGINT NULL,

                        CONSTRAINT fk_log_usuario
                            FOREIGN KEY (tb_usuario_id)
                                REFERENCES tb_usuario(id)
                                ON DELETE RESTRICT
                                ON UPDATE CASCADE,

                        CONSTRAINT fk_log_venda
                            FOREIGN KEY (tb_venda_id)
                                REFERENCES tb_venda(id)
                                ON DELETE RESTRICT
                                ON UPDATE CASCADE
);

CREATE INDEX idx_log_usuario
    ON tb_log(tb_usuario_id);

CREATE INDEX idx_log_venda
    ON tb_log(tb_venda_id);