package com.spring3.series.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Ignora as propriedades não informadas previamente
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(
       @JsonAlias("Title") String titulo,
       @JsonAlias("totalSeasons") Integer totalTemporadas,
       @JsonAlias("imdbRating") String avaliacao,
       @JsonAlias("Genre") String genero,
       @JsonAlias("Actors") String atores,
       @JsonAlias("Poster") String poster,
       @JsonAlias("Plot") String sinopse
       //@JsonProperty({"",""}) lê e imprimi com o nome informado, pode receber um array de nomes (útil para quando utiliza mais de uma api)
) {
}
