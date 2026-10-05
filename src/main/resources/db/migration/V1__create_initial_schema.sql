
CREATE DATABASE IF NOT EXISTS cbgames;
USE cbgames;

CREATE TABLE tb_usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_usuario VARCHAR(100) NOT NULL,
    email_usuario VARCHAR(100) NOT NULL UNIQUE,
    login_usuario VARCHAR(50) NOT NULL UNIQUE,
    senha_usuario VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

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

CREATE TABLE tb_venda (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    data_venda TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    valor_total DECIMAL(10,2) NOT NULL DEFAULT 0.00,

    status_venda ENUM(
        'RASCUNHO',
        'PENDENTE',
        'CONCLUIDA',
        'CANCELADA'
    ) DEFAULT 'RASCUNHO',

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
