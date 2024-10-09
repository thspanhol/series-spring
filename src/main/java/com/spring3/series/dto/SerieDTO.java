package com.spring3.series.dto;

import com.spring3.series.model.Categoria;

public record SerieDTO(
        long id,
        String titulo,
        Integer totalTemporadas,
        Double avaliacao,
        Categoria genero,
        String atores,
        String poster,
        String sinopse
) {
}
