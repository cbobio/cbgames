package br.com.cbobio.cbgames.web.controller.dto.request.cliente;

import br.com.cbobio.cbgames.web.controller.dto.request.endereco.EnderecoRequestDto;
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

    private String nomeCliente;

    private String emailCliente;

    private String cpfCliente;

    private String telefoneCliente;

    private EnderecoRequestDto endereco;

    private Long usuarioId;

}