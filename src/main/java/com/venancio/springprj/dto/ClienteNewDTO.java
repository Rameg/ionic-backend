package com.venancio.springprj.dto;

import com.venancio.springprj.domain.Cliente;
import com.venancio.springprj.services.validation.ClienteInsert;
import com.venancio.springprj.services.validation.ClienteUpdate;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@ClienteInsert
@ClienteUpdate
public class ClienteNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Preechimento Obrigátorio")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 80 caracteres.")
    private String nome;
    @NotEmpty(message = "Preechimento Obrigátorio")
    @Email
    private String email;
    @NotEmpty(message = "Preechimento Obrigátorio")
    private String cpfOuCnpj;
    private Integer tipoCliente;

    @NotEmpty(message = "Preechimento Obrigátorio")
    private String logradouro;
    @NotEmpty(message = "Preechimento Obrigátorio")
    private String numero;
    private String complemento;
    private String bairro;
    @NotEmpty(message = "Preechimento Obrigátorio")
    private String cep;

    @NotEmpty(message = "Preechimento Obrigátorio")
    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Integer cidadeId;

    public ClienteNewDTO(){}
}
