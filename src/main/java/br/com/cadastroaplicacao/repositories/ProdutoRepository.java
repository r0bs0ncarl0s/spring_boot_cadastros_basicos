package br.com.cadastroaplicacao.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.cadastroaplicacao.models.Produto;

public interface ProdutoRepository  extends CrudRepository <Produto, Long>{
    
}
