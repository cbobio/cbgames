CREATE TABLE tb_venda (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,

                          data_venda TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                          data_pagamento TIMESTAMP NULL,

                          valor_total DECIMAL(10,2) NOT NULL DEFAULT 0.00,

                          status_venda ENUM(
        'NOVO',
        'VALIDADO',
        'PAGO',
        'ENTREGUE',
        'COMPLETADO',
        'CANCELADO'
    ) NOT NULL DEFAULT 'NOVO',

                          tb_cliente_id BIGINT NOT NULL,

                          tb_usuario_id BIGINT NOT NULL,

                          data_conclusao TIMESTAMP NULL,

                          data_cancelamento TIMESTAMP NULL,

                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                              ON UPDATE CURRENT_TIMESTAMP,

                          CONSTRAINT chk_venda_valor_total
                              CHECK (valor_total >= 0),

                          CONSTRAINT fk_venda_cliente
                              FOREIGN KEY (tb_cliente_id)
                                  REFERENCES tb_cliente(id)
                                  ON DELETE RESTRICT
                                  ON UPDATE CASCADE,

                          CONSTRAINT fk_venda_usuario
                              FOREIGN KEY (tb_usuario_id)
                                  REFERENCES tb_usuario(id)
                                  ON DELETE RESTRICT
                                  ON UPDATE CASCADE
);

CREATE INDEX idx_venda_cliente
    ON tb_venda(tb_cliente_id);

CREATE INDEX idx_venda_usuario
    ON tb_venda(tb_usuario_id);

CREATE INDEX idx_venda_status
    ON tb_venda(status_venda);

CREATE INDEX idx_venda_data
    ON tb_venda(data_venda);