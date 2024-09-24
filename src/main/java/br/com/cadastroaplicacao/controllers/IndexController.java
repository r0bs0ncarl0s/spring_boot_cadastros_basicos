package br.com.cadastroaplicacao.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.cadastroaplicacao.utils.Constantes;

@Controller
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/")
    public String index(){
        return Constantes.TEMPLATE_INDEX;
    }    
}

