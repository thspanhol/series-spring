package com.spring3.series;

import com.spring3.series.model.DadosEpisodio;
import com.spring3.series.model.DadosSerie;
import com.spring3.series.model.DadosTemporada;
import com.spring3.series.principal.Principal;
import com.spring3.series.repository.SerieRepository;
import com.spring3.series.service.ConsumoAPI;
import com.spring3.series.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SeriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeriesApplication.class, args);
	}

}
