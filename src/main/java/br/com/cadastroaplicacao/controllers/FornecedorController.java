package br.com.cadastroaplicacao.controllers;
import java.time.Instant;
import java.time.LocalDateTime;

import org.hibernate.mapping.List;
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

import br.com.cadastroaplicacao.models.Estado;
import br.com.cadastroaplicacao.models.Fornecedor;
import br.com.cadastroaplicacao.repositories.EstadoRepository;
import br.com.cadastroaplicacao.repositories.FornecedorRepository;
import br.com.cadastroaplicacao.utils.Constantes;
import jakarta.validation.Valid;

@Controller
public class FornecedorController {
    private final Logger logger = LoggerFactory.getLogger(FornecedorController.class);

    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping("/fornecedor/incluir")
    public ModelAndView incluirForm(Fornecedor toItem){
    	ModelAndView modelAndView = new ModelAndView(Constantes.TEMPLATE_FORNECEDOR_INCLUIR);
        modelAndView.addObject("estadosItens" , estadoRepository.findAll());
        return modelAndView;
    }    

    @GetMapping("/fornecedor/alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") long id, Model model) {
        ModelAndView modelAndView = new ModelAndView(Constantes.TEMPLATE_FORNECEDOR_ALTERAR);
        modelAndView.addObject("estadosItens" , estadoRepository.findAll());
    	Fornecedor toItem = fornecedorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item id: " + id + " nao encontrado"));
       model.addAttribute("fornecedor", toItem);
       return modelAndView;
    }

    @GetMapping("/fornecedor/excluir/{id}")
    public String excluirForm(@PathVariable("id") long id, Model model) {
    	Fornecedor toItem = fornecedorRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Item id: " + id + " fornecedor nao encontrado"));
    	fornecedorRepository.delete(toItem);
        return Constantes.REDIRECT_FORNECEDOR;
    }
    
    @GetMapping("/fornecedores")
    public ModelAndView retornaTodosFornecedores() {
        logger.info("Retorna Todos Fornecedores");
        ModelAndView modelAndView = new ModelAndView(Constantes.FORNECEDOR_INDEX);
        modelAndView.addObject("fornecedorItems" , fornecedorRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/fornecedor")
    public String incluirItemFornecedor(@Valid Fornecedor fornecedor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return Constantes.TEMPLATE_FORNECEDOR_INCLUIR;
        }
        fornecedor.setDtCriacao(LocalDateTime.now());
        fornecedor.setDtAlteracao(LocalDateTime.now());
        fornecedorRepository.save(fornecedor);
        return Constantes.REDIRECT_FORNECEDOR;
    }

    @PostMapping("/fornecedor/{id}")
    public String alterarItemFornecedor(@PathVariable("id") long id, @Valid Fornecedor fornecedor, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	fornecedor.setId(id);
            return Constantes.TEMPLATE_FORNECEDOR_ALTERAR;
        }
        fornecedor.setDtAlteracao(LocalDateTime.now());
        fornecedorRepository.save(fornecedor);
        return Constantes.REDIRECT_FORNECEDOR;
    }
}

