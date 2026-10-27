CREATE TABLE tb_movimentacao_estoque (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,

                                         tipo_movimentacao ENUM(
        'ENTRADA',
        'SAIDA',
        'AJUSTE'
    ) NOT NULL,

                                         quantidade INT NOT NULL,

                                         observacao VARCHAR(255),

                                         data_movimentacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                                         tb_jogo_id BIGINT NOT NULL,

                                         tb_usuario_id BIGINT NOT NULL,

                                         CONSTRAINT fk_movimentacao_jogo
                                             FOREIGN KEY (tb_jogo_id)
                                                 REFERENCES tb_jogo(id)
                                                 ON DELETE RESTRICT
                                                 ON UPDATE CASCADE,

                                         CONSTRAINT fk_movimentacao_usuario
                                             FOREIGN KEY (tb_usuario_id)
                                                 REFERENCES tb_usuario(id)
                                                 ON DELETE RESTRICT
                                                 ON UPDATE CASCADE
);

CREATE INDEX idx_movimentacao_jogo
    ON tb_movimentacao_estoque(tb_jogo_id);

CREATE INDEX idx_movimentacao_usuario
    ON tb_movimentacao_estoque(tb_usuario_id);