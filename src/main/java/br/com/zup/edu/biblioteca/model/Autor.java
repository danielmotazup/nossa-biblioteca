package br.com.zup.edu.biblioteca.model;

import br.com.zup.edu.biblioteca.controller.AtualizaAutorRequest;

import javax.persistence.*;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Lob
    private String descricao;

    @Column(nullable = false)
    private String cpf;

    public Autor(String nome, String email, String descricao, String cpf) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.cpf = cpf;
    }

    /**
     * @deprecated construtor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Autor() {
    }

    public Long getId() {
        return id;
    }



    public void atualizaAutor(AtualizaAutorRequest request){
        this.nome = request.getNome();
        this.cpf = request.getCpf();
        this.email = request.getEmail();
        this.descricao = request.getDescricao();
    }
}