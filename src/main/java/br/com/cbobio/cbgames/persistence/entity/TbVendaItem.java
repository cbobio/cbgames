package br.com.cbobio.cbgames.persistence.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_venda_item")
public class TbVendaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "valor_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorUnitario;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tb_venda_id", nullable = false)
    private TbVenda venda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tb_jogo_id", nullable = false)
    private TbJogo jogo;
}