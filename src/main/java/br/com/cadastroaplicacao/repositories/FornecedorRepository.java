package br.com.cadastroaplicacao.repositories;

import org.springframework.data.repository.CrudRepository;
import br.com.cadastroaplicacao.models.Fornecedor;

public interface FornecedorRepository  extends CrudRepository <Fornecedor, Long>{
    
}
