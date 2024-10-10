package com.spring3.series.controller;

import com.spring3.series.dto.EpisodioDTO;
import com.spring3.series.dto.SerieDTO;
import com.spring3.series.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("series")
public class SerieController {

    @Autowired
    private SerieService servico;

    @GetMapping
    public List<SerieDTO> obterSeries() {
        return servico.obterTodasSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obterTop5() {
        return servico.obterTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> obterLancamentos() {
        return servico.obterUltimosLancamentos();
    }

    @GetMapping("/{id}")
    public SerieDTO obterPorId(@PathVariable long id) {
        return servico.obterPorId(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> obterTodasTemporadas(@PathVariable long id) {
        return servico.obterTodasTemporadas(id);
    }

    @GetMapping("/{id}/temporadas/{numeroTemporada}")
    public List<EpisodioDTO> obterTemporadaEspecifica(@PathVariable long id, @PathVariable long numeroTemporada) {
        return servico.obterTemporadaEspecifica(id, numeroTemporada);
    }

    @GetMapping("/categoria/{nomeCategoria}")
    public List<SerieDTO> obterSeriesPorCategoria(@PathVariable String nomeCategoria) {
        return servico.obterSeriesPorCategoria(nomeCategoria);
    }

    @GetMapping("/{id}/temporadas/top")
    public List<EpisodioDTO> obterTopEpisodiosDaSerie(@PathVariable long id) {
        return servico.obterTopEpisodiosDaSerie(id);
    }
};
