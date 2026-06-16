package br.com.cbobio.cbgames.persistence.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class TbUsuario extends BaseAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_usuario", nullable = false, length = 100)
    private String nomeUsuario;

    @Column(name = "email_usuario", nullable = false, unique = true, length = 100)
    private String emailUsuario;

    @Column(name = "login_usuario", nullable = false, unique = true, length = 50)
    private String loginUsuario;

    @Column(name = "senha_usuario", nullable = false)
    private String senhaUsuario;

    @Builder.Default
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<TbCliente> clientes = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "usuario")
    private Set<TbVenda> vendas = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "usuario")
    private Set<TbMovimentacaoEstoque> movimentacoes = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "usuario")
    private Set<TbLog> logs = new HashSet<>();
}