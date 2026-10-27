
package br.com.cbobio.cbgames.web.controller.dto.request.jogo;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JogoAtualizacaoRequestDto {

    @Size(max = 100, message = "O nome do jogo deve ter no máximo 100 caracteres.")
    private String nomeJogo;

    @Size(max = 50, message = "O gênero deve ter no máximo 50 caracteres.")
    private String generoJogo;

    @Size(max = 50, message = "A plataforma deve ter no máximo 50 caracteres.")
    private String plataformaJogo;

    @Size(max = 100, message = "A desenvolvedora deve ter no máximo 100 caracteres.")
    private String desenvolvedora;

    @Min(value = 1950, message = "O ano de lançamento deve ser igual ou posterior a 1950.")
    @Max(value = 2100, message = "O ano de lançamento não pode ser posterior a 2100.")
    private Integer anoLancamento;

    @NotNull(message = "O preço é obrigatório.")
    @DecimalMin(value = "0.00", message = "O preço não pode ser negativo.")
    private BigDecimal preco;

    @NotNull(message = "A quantidade em estoque é obrigatória.")
    @PositiveOrZero(message = "A quantidade em estoque não pode ser negativa.")
    private Integer quantidadeEstoque;

    @NotNull(message = "O estoque mínimo é obrigatório.")
    @PositiveOrZero(message = "O estoque mínimo não pode ser negativo.")
    private Integer estoqueMinimo;
}
