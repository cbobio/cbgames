CREATE
DATABASE IF NOT EXISTS cbgames;
USE
cbgames;

CREATE TABLE tb_usuario
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_usuario  VARCHAR(100) NOT NULL,
    email_usuario VARCHAR(100) NOT NULL UNIQUE,
    login_usuario VARCHAR(50)  NOT NULL UNIQUE,
    senha_usuario VARCHAR(255) NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_cliente
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_cliente VARCHAR(100) NOT NULL,
    email_cliente VARCHAR(100) NOT NULL,
    cpf_cliente VARCHAR(14)  NOT NULL UNIQUE,
    telefone_cliente VARCHAR(20),
    endereco_cliente VARCHAR(255),
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tb_usuario_id BIGINT NOT NULL,
    CONSTRAINT fk_cliente_usuario
        FOREIGN KEY (tb_usuario_id)
            REFERENCES tb_usuario (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

CREATE INDEX idx_cliente_usuario
    ON tb_cliente (tb_usuario_id);

CREATE TABLE tb_jogo
(
    id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_jogo VARCHAR(100)   NOT NULL,
    genero_jogo VARCHAR(50),
    plataforma_jogo VARCHAR(50),
    desenvolvedora VARCHAR(100),
    ano_lancamento  INT,
    preco DECIMAL(10, 2) NOT NULL,
    quantidade_estoque INT NOT NULL DEFAULT 0,
    data_entrada TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_venda
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_venda TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
    valor_total DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    status_venda  ENUM(
        'RASCUNHO',
        'PENDENTE',
        'CONCLUIDA',
        'CANCELADA'
    ) DEFAULT 'RASCUNHO',
    tb_cliente_id BIGINT NOT NULL,
    CONSTRAINT fk_venda_cliente
        FOREIGN KEY (tb_cliente_id)
            REFERENCES tb_cliente (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);
CREATE INDEX idx_venda_cliente
    ON tb_venda (tb_cliente_id);

CREATE TABLE tb_venda_item
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    quantidade INT NOT NULL,

    valor_unitario DECIMAL(10, 2) NOT NULL,

    subtotal DECIMAL(10, 2) NOT NULL,

    tb_venda_id  BIGINT NOT NULL,

    tb_jogo_id BIGINT NOT NULL,

    CONSTRAINT fk_venda_item_venda
        FOREIGN KEY (tb_venda_id)
            REFERENCES tb_venda (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT fk_venda_item_jogo
        FOREIGN KEY (tb_jogo_id)
            REFERENCES tb_jogo (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

CREATE INDEX idx_venda_item_venda
    ON tb_venda_item (tb_venda_id);

CREATE INDEX idx_venda_item_jogo
    ON tb_venda_item (tb_jogo_id);

CREATE TABLE tb_log
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    responsavel_log VARCHAR(100) NOT NULL,
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
    tb_venda_id  BIGINT NULL,
    CONSTRAINT fk_log_usuario
        FOREIGN KEY (tb_usuario_id)
            REFERENCES tb_usuario (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,
    CONSTRAINT fk_log_venda
        FOREIGN KEY (tb_venda_id)
            REFERENCES tb_venda (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);
CREATE INDEX idx_log_usuario
    ON tb_log (tb_usuario_id);
CREATE INDEX idx_log_venda
    ON tb_log (tb_venda_id);