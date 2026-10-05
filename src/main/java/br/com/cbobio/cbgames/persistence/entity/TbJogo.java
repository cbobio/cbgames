package br.com.cbobio.cbgames.persistence.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_jogo")
public class TbJogo extends BaseAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_jogo", nullable = false, length = 100)
    private String nomeJogo;

    @Column(name = "genero_jogo", length = 50)
    private String generoJogo;

    @Column(name = "plataforma_jogo", length = 50)
    private String plataformaJogo;

    @Column(name = "desenvolvedora", length = 100)
    private String desenvolvedora;

    @Column(name = "ano_lancamento")
    private Integer anoLancamento;

    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "quantidade_estoque", nullable = false)
    private Integer quantidadeEstoque;

    @Column(name = "estoque_minimo", nullable = false)
    private Integer estoqueMinimo;

    @Builder.Default
    @OneToMany(mappedBy = "jogo")
    private Set<TbVendaItem> itensVenda = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "jogo")
    private Set<TbMovimentacaoEstoque> movimentacoes = new HashSet<>();
}