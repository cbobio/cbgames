package br.com.cbobio.cbgames.web.controller.dto.response.cliente;

import br.com.cbobio.cbgames.web.controller.dto.response.endereco.EnderecoResponseDto;
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
public class ClienteResponseDto {

    private Long id;

    private String nomeCliente;

    private String emailCliente;

    private String cpfCliente;

    private String telefoneCliente;

    private EnderecoResponseDto endereco;

}