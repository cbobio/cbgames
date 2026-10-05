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
@Table(name = "tb_cliente")
public class TbCliente extends BaseAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cliente", nullable = false, length = 100)
    private String nomeCliente;

    @Column(name = "email_cliente", nullable = false, unique = true, length = 100)
    private String emailCliente;

    @Column(name = "cpf_cliente", nullable = false, unique = true, length = 11)
    private String cpfCliente;

    @Column(name = "telefone_cliente", length = 20)
    private String telefoneCliente;

    @Embedded
    private TbEndereco endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tb_usuario_id", nullable = false)
    private TbUsuario usuario;

    @Builder.Default
    @OneToMany(mappedBy = "cliente")
    private Set<TbVenda> vendas = new HashSet<>();
}