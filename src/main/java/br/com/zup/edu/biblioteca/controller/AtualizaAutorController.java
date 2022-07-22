package br.com.zup.edu.biblioteca.controller;

import br.com.zup.edu.biblioteca.model.Autor;
import br.com.zup.edu.biblioteca.repository.AutorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/autores")
public class AtualizaAutorController {

    private final AutorRepository autorRepository;

    public AtualizaAutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PatchMapping("/{idAutor}")
    public ResponseEntity<Void> atualizaAutor(@PathVariable Long idAutor, @RequestBody @Valid AtualizaAutorRequest request){

        Autor autor = autorRepository.findById(idAutor).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "Autor não encontrado"));

        autor = request.atualizaAutor(autor);

        autorRepository.save(autor);

        return ResponseEntity.noContent().build()   ;



    }
}
