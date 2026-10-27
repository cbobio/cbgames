package br.com.cbobio.cbgames.web.controller.dto.request.cliente;

import br.com.cbobio.cbgames.web.controller.dto.request.endereco.EnderecoRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDto {

    @NotBlank(message = "O nome do cliente é obrigatório.")
    @Size(max = 100)
    private String nomeCliente;

    @NotBlank(message = "O e-mail do cliente é obrigatório.")
    @Email(message = "E-mail inválido.")
    @Size(max = 100)
    private String emailCliente;

    @NotBlank(message = "O CPF é obrigatório.")
    @Pattern(
            regexp = "\\d{11}",
            message = "O CPF deve conter exatamente 11 números."
    )
    private String cpfCliente;

    @Size(max = 20)
    private String telefoneCliente;

    @Valid
    @NotNull(message = "O endereço é obrigatório.")
    private EnderecoRequestDto endereco;

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Long usuarioId;
}