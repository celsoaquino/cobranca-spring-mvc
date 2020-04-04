package com.celsoaquino.cobranca.service;

import com.celsoaquino.cobranca.model.StatusTitulo;
import com.celsoaquino.cobranca.model.Titulo;
import com.celsoaquino.cobranca.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CadastroTituloService {

    @Autowired
    private TituloRepository tituloRepository;

    public void salvar(Titulo titulo) {
        try{
            tituloRepository.save(titulo);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Formato de data inválido");
        }
    }

    public void excluir(Long codigo) {
        tituloRepository.deleteById(codigo);
    }

    public String receber(Long codigo) {
        Titulo titulo = tituloRepository.findById(codigo).get();
        titulo.setStatus(StatusTitulo.RECEBIDO);
        tituloRepository.save(titulo);

        return StatusTitulo.RECEBIDO.getDescricao();
    }
}
