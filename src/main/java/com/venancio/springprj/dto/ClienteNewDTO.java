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
public class ClienteNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipoCliente;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Integer cidadeId;

    public ClienteNewDTO(){}
}
