package com.celsoaquino.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TituloController {

    @GetMapping("titulos/novo")
    public String novo() {
        return "CadastroTitulo";
    }
}
