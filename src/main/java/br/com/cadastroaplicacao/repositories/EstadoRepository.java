package br.com.cadastroaplicacao.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.cadastroaplicacao.models.Estado;

public interface EstadoRepository  extends CrudRepository <Estado, Long>{
    
}
