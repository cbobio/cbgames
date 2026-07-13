package br.com.cbobio.cbgames.web.controller.dto.request;

import jakarta.validation.constraints.*;
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
public class JogoRequestDto {

    @NotBlank
    @Size(max = 100)
    private String nomeJogo;

    private String generoJogo;

    private String plataformaJogo;

    private String desenvolvedora;

    private Integer anoLancamento;


    @NotNull
    @Positive
    private BigDecimal preco;

    @NotNull
    @PositiveOrZero
    private Integer quantidadeEstoque;

    @NotNull
    @PositiveOrZero
    private Integer estoqueMinimo;

}