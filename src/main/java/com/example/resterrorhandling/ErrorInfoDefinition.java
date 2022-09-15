package com.example.resterrorhandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ErrorInfoDefinition implements Serializable {

    private int code;

    private String codeDefinition;
    private String codeMeaning;
    private String infoURL;

    private RestErrorType type;

    private List<String> hints;
}
