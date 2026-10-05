ALTER TABLE tb_venda
    ADD COLUMN data_pagamento TIMESTAMP NULL
AFTER data_venda;