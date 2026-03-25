package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Funcionario;
import br.uniesp.si.techback.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public Funcionario salvar(Funcionario func){
        return service.salvar(func);
    }

    @GetMapping
    public List<Funcionario> listar(){
        return service.listar();
    }

    @PutMapping("/{id}")
    public Funcionario atualizar (@PathVariable Long id,
                                  @RequestBody Funcionario funcionario){
        return service.atualizar(id,funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorID(@PathVariable Long id){
        Funcionario funcionario = service.buscarPorID(id);
        return ResponseEntity.ok(funcionario);
    }

}
