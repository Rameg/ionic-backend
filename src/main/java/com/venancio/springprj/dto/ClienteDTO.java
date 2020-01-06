package com.venancio.springprj.dto;

import com.venancio.springprj.domain.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preechimento Obrigátorio")
    @Email(message = "Email inválido!!!")
    private String email;

    @NotEmpty(message = "Preechimento Obrigátorio")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 80 caracteres.")
    private String nome;

    public ClienteDTO(){}

    public ClienteDTO(Cliente obj){
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }

}
