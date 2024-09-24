package br.com.cadastroaplicacao.controllers;
import br.com.cadastroaplicacao.models.Produto;
import br.com.cadastroaplicacao.repositories.ProdutoRepository;
import br.com.cadastroaplicacao.utils.Constantes;
import jakarta.validation.Valid;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutoController {
    private final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produto/incluir")
    public String incluirForm(Produto toItem){
        return Constantes.TEMPLATE_PRODUTO_INCLUIR;
    }    

    @GetMapping("/produto/alterar/{id}")
    public String alterarForm(@PathVariable("id") long id, Model model) {
        Produto toItem = produtoRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Item id: " + id + " nao encontrado"));
       model.addAttribute("produto", toItem);
        return Constantes.TEMPLATE_PRODUTO_ALTERAR;
    }

    @GetMapping("/produto/excluir/{id}")
    public String excluirForm(@PathVariable("id") long id, Model model) {
        Produto toItem = produtoRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Item id: " + id + " produto nao encontrado"));
        produtoRepository.delete(toItem);
        return Constantes.REDIRECT_PRODUTO;
    }
    
    @GetMapping("/produtos")
    public ModelAndView retornaTodosProdutos() {
        logger.info("Retorna Todos Produtos");
        ModelAndView modelAndView = new ModelAndView(Constantes.PRODUTO_INDEX);
        modelAndView.addObject("produtoItems" , produtoRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/produto")
    public String incluirItemProduto(@Valid Produto produto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return Constantes.TEMPLATE_PRODUTO_INCLUIR;
        }
        produto.setDtCriacao(Instant.now());
        produto.setDtAlteracao(Instant.now());
        produtoRepository.save(produto);
        return Constantes.REDIRECT_PRODUTO;
    }

    @PostMapping("/produto/{id}")
    public String alterarItemProduto(@PathVariable("id") long id, @Valid Produto produto, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	produto.setId(id);
            return Constantes.TEMPLATE_PRODUTO_ALTERAR;
        }
        produto.setDtAlteracao(Instant.now());
        produtoRepository.save(produto);
        return Constantes.REDIRECT_PRODUTO;
    }
}

