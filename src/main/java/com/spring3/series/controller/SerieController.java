package com.spring3.series.controller;

import com.spring3.series.dto.SerieDTO;
import com.spring3.series.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SerieController {

    @Autowired
    private SerieService servico;

    @GetMapping("/series")
    public List<SerieDTO> obterSeries() {
        return servico.obterTodasSeries();
    }

    @GetMapping("/inicio")
    public String retornaInicio() {
        return "Inicio.";
    }
};
