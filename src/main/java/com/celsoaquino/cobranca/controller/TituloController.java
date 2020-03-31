package com.celsoaquino.cobranca.controller;

import com.celsoaquino.cobranca.model.StatusTitulo;
import com.celsoaquino.cobranca.model.Titulo;
import com.celsoaquino.cobranca.repository.TituloRepoitory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/titulos")
public class TituloController {

    private final TituloRepoitory repoitory;

    public TituloController(TituloRepoitory repoitory) {
        this.repoitory = repoitory;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("CadastroTitulo");
        mv.addObject("todosStatusTitulo", StatusTitulo.values());
        return mv;
    }

    @PostMapping
    public ModelAndView salvar(Titulo titulo) {
        repoitory.save(titulo);
        ModelAndView mv = new ModelAndView("CadastroTitulo");
        mv.addObject("mensagem", "Titulo salvo com sucesso!");
        return mv;
    }

    @GetMapping
    public String pesquisar() {
        return "PesquisaTitulo";
    }


    @ModelAttribute("allStatus")
    public List<StatusTitulo> todosStatusTitulo(){
        return Arrays.asList(StatusTitulo.values());
    }
}
