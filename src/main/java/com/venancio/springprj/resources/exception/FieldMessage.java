package com.venancio.springprj.resources.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FieldMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String filedName;
    private String message;

    public FieldMessage(){
    }

    public FieldMessage(String filedName, String message) {
        this.filedName = filedName;
        this.message = message;
    }
}
