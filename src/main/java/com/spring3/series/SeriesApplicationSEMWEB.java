//package com.spring3.series;
//
//import com.spring3.series.principal.Principal;
//import com.spring3.series.repository.SerieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SeriesApplicationSEMWEB implements CommandLineRunner {
//
//	@Autowired
//	private SerieRepository repositorio;
//
//	public static void main(String[] args) {
//		SpringApplication.run(SeriesApplicationSEMWEB.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//
////		var consumoApi = new ConsumoAPI();
////		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=supernatural&apikey=1e2c5b98");
////		System.out.println(json);
////		ConverteDados conversor = new ConverteDados();
////		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
////		System.out.println(dados);
////
////		json = consumoApi.obterDados("https://www.omdbapi.com/?t=supernatural&Season=1&Episode=2&apikey=1e2c5b98");
////		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
////		System.out.println(dadosEpisodio);
//
//		Principal principal = new Principal(repositorio);
//		principal.exibeMenu();
//
////		List<DadosTemporada> temporadas = new ArrayList<>();
//
////		for (int i = 1; i <= dados.totalTemporadas(); i++) {
////			json = consumoApi.obterDados("https://www.omdbapi.com/?t=supernatural&Season=" +i + "&apikey=1e2c5b98");
////			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
////			temporadas.add(dadosTemporada);
////		}
////		temporadas.forEach(System.out::println);
//
//	}
//}
