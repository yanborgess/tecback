package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Funcionario;
import br.uniesp.si.techback.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public Funcionario salvar(Funcionario func){
        return repository.save(func);
    }

    public List<Funcionario> listar(){
        return repository.findAll();
    }

    public Funcionario atualizar(Long id, Funcionario funcionario){
        Optional<Funcionario> func = repository.findById(id);
        if (func.isEmpty()){
            throw new RuntimeException("Funcionário não encontrado");
        }else {
            return repository.save(funcionario);
        }
    }
    public void  excluir( Long id){
        if (!repository.existsById(id)){
            throw  new RuntimeException("ID not found");
        }
        repository.deleteById(id);
    }

    public Funcionario buscarPorID(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }
}
