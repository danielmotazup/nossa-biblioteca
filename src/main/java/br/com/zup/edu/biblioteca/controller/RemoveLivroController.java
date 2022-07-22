package br.com.zup.edu.biblioteca.controller;

import br.com.zup.edu.biblioteca.model.Livro;
import br.com.zup.edu.biblioteca.repository.LivroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/livros/{isbn}")
public class RemoveLivroController {

    private final LivroRepository livroRepository;

    public RemoveLivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }


    @DeleteMapping()
    @Transactional
    public ResponseEntity<Void> removeLivros(@PathVariable String isbn){

        Livro livro = livroRepository.findByISBN(isbn).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "livro não encontrado"));

        if (livro.validaCirculacao()){
            livroRepository.delete(livro);
            return ResponseEntity.noContent().build();
        }

        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"impossível remover");





    }
}
