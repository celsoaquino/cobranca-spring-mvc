package com.celsoaquino.cobranca.controller;

import com.celsoaquino.cobranca.model.Titulo;
import com.celsoaquino.cobranca.repository.TituloRepoitory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/titulos")
public class TituloController {

    private final TituloRepoitory repoitory;

    public TituloController(TituloRepoitory repoitory) {
        this.repoitory = repoitory;
    }

    @GetMapping("/novo")
    public String novo() {
        return "CadastroTitulo";
    }

    @PostMapping
    private String salvar(Titulo titulo){
        repoitory.save(titulo);
        return "CadastroTitulo";
    }
}
