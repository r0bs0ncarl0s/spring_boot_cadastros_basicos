package br.com.cadastroaplicacao.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.cadastroaplicacao.models.Produto;
import br.com.cadastroaplicacao.repositories.ProdutoRepository;

@Component
public class ProdutoDataLoader implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(ProdutoDataLoader.class);

    @Autowired 
    ProdutoRepository produtoRepository;
    
    @Override
    public void run(String... args) throws Exception{
        loadData();
    }

    private void loadData(){
        if(produtoRepository.count()==0){
            Produto prod1 = new Produto("Laranja");
            Produto prod2 = new Produto("Banana");
            produtoRepository.save(prod1);
            produtoRepository.save(prod2);
        }
        logger.info("Numero de produtos: {}", produtoRepository.count());
    }
}
