package br.com.cbobio.cbgames.persistence.entity;
import br.com.cbobio.cbgames.enums.AcaoLog;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_log")
public class TbLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "acao_log", nullable = false)
    private AcaoLog acaoLog;

    @Column(name = "descricao_log", length = 255)
    private String descricaoLog;

    @Column(name = "data_movimentacao", insertable = false, updatable = false)
    private LocalDateTime dataMovimentacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tb_usuario_id", nullable = false)
    private TbUsuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tb_venda_id")
    private TbVenda venda;
}