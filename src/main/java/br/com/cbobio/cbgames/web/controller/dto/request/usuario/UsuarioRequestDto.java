package br.com.cbobio.cbgames.web.controller.dto.request.usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class UsuarioRequestDto {

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100)
    private String nomeUsuario;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    @Size(max = 100)
    private String emailUsuario;

    @NotBlank(message = "O login é obrigatório.")
    @Size(max = 50)
    private String loginUsuario;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, max = 255)
    private String senhaUsuario;

}