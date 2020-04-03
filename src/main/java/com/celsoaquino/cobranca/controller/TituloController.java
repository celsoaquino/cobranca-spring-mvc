package com.celsoaquino.cobranca.controller;

import com.celsoaquino.cobranca.model.StatusTitulo;
import com.celsoaquino.cobranca.model.Titulo;
import com.celsoaquino.cobranca.repository.TituloRepoitory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/titulos")
public class TituloController {

    private static final String CADASTRO_VIEW = "CadastroTitulo";

    private final TituloRepoitory repoitory;

    public TituloController(TituloRepoitory repoitory) {
        this.repoitory = repoitory;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(new Titulo());
        return mv;
    }

    @PostMapping
    public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return CADASTRO_VIEW;
        }
        try {
            repoitory.save(titulo);
            ra.addFlashAttribute("mensagem", "Titulo salvo com sucesso!");
            return "redirect:/titulos/novo";
        }catch (DataIntegrityViolationException e) {
            errors.rejectValue("dataVencimento", null, "Formato de data inválido");
            return CADASTRO_VIEW;
        }

    }

    @GetMapping
    public ModelAndView pesquisar() {
        List<Titulo> titulos = repoitory.findAll();
        ModelAndView mv = new ModelAndView("PesquisaTitulo");
        mv.addObject("titulos", titulos);
        return mv;
    }

    @GetMapping("{codigo}")
    public ModelAndView edicao(@PathVariable("codigo") Titulo titulo) {
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(titulo);
        return mv;
    }

    @GetMapping("/excluir/{codigo}")
    public String excluir(@PathVariable("codigo") Long codigo, RedirectAttributes ra) {
        repoitory.deleteById(codigo);
        ra.addFlashAttribute("mensagem", "Titulo excluído com sucesso!");
        return "redirect:/titulos";
    }


    @ModelAttribute("allStatus")
    public List<StatusTitulo> todosStatusTitulo(){
        return Arrays.asList(StatusTitulo.values());
    }
}
