CREATE TABLE tb_venda_item (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,

                               quantidade INT NOT NULL,

                               valor_unitario DECIMAL(10,2) NOT NULL,

                               subtotal DECIMAL(10,2) NOT NULL,

                               tb_venda_id BIGINT NOT NULL,

                               tb_jogo_id BIGINT NOT NULL,

                               CONSTRAINT chk_venda_item_quantidade
                                   CHECK (quantidade > 0),

                               CONSTRAINT chk_venda_item_valor_unitario
                                   CHECK (valor_unitario >= 0),

                               CONSTRAINT chk_venda_item_subtotal
                                   CHECK (subtotal >= 0),

                               CONSTRAINT fk_venda_item_venda
                                   FOREIGN KEY (tb_venda_id)
                                       REFERENCES tb_venda(id)
                                       ON DELETE RESTRICT
                                       ON UPDATE CASCADE,

                               CONSTRAINT fk_venda_item_jogo
                                   FOREIGN KEY (tb_jogo_id)
                                       REFERENCES tb_jogo(id)
                                       ON DELETE RESTRICT
                                       ON UPDATE CASCADE
);

CREATE INDEX idx_venda_item_venda
    ON tb_venda_item(tb_venda_id);

CREATE INDEX idx_venda_item_jogo
    ON tb_venda_item(tb_jogo_id);