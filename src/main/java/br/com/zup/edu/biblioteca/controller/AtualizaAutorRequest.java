package br.com.zup.edu.biblioteca.controller;

import br.com.zup.edu.biblioteca.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AtualizaAutorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank
    private String descricao;

    @NotBlank
    @Email
    private String email;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmail() {
        return email;
    }


}
