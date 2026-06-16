package br.com.cbobio.cbgames.persistence.entity;
import br.com.cbobio.cbgames.machine.enums.estados.StatusVenda;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_venda")
public class TbVenda extends BaseAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_venda", insertable = false, updatable = false)
    private LocalDateTime dataVenda;

    @Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_venda", nullable = false)
    private StatusVenda statusVenda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tb_cliente_id", nullable = false)
    private TbCliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tb_usuario_id", nullable = false)
    private TbUsuario usuario;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @Column(name = "data_cancelamento")
    private LocalDateTime dataCancelamento;

    @Builder.Default
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TbVendaItem> itens = new HashSet<>();
}