package com.spring3.series.principal;

import com.spring3.series.model.DadosEpisodio;
import com.spring3.series.model.DadosSerie;
import com.spring3.series.model.DadosTemporada;
import com.spring3.series.model.Episodio;
import com.spring3.series.service.ConsumoAPI;
import com.spring3.series.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados converteDados = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=1e2c5b98";

    public void exibeMenu() {
        System.out.println("Digite o nome da série que deseja buscar:");
        var nomeSerie = leitura.nextLine();
        String link = ENDERECO + nomeSerie.replace(" ", "+") + API_KEY;
        var json = consumoAPI.obterDados(link);
        DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = consumoAPI.obterDados("https://www.omdbapi.com/?t=" + nomeSerie.replace(" ", "+") + "&Season=" +i + "&apikey=1e2c5b98");
			DadosTemporada dadosTemporada = converteDados.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		//temporadas.forEach(System.out::println);

//        for (int i = 0; i < temporadas.size(); i++) {
//            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size(); j++) {
//                System.out.println("T-" + temporadas.get(i).numero() + "-EP-" + episodiosTemporada.get(j).numero() + " " + episodiosTemporada.get(j).titulo());
//            }
//        }

        //temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println("T-" + t.numero() + "-EP-" + e.numero() + " " + e.titulo())));


        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList()); // Permite novos registros futuros
                //.toList(); // Imutável


        // Lista com a Classe Episodio
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());

        // Faz média da nota por temporada
        Map<Integer, Double> avaliacoesPorTemporada = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getAvaliacao)));
        System.out.println("Média por temporadas: " + avaliacoesPorTemporada);

        // Classe SummaryStatistics para coletar dados (contador, soma, minimo, média, maximo)
        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));

        System.out.println(est);

        //Procura episódio informado
//        System.out.println("Informe o episódio que deseja buscar: ");
//        var buscaEpisodio = leitura.nextLine();
//        Optional<Episodio> episodioBuscado = episodios.stream()
//                .filter(e -> e.getTitulo().toLowerCase().contains(buscaEpisodio.toLowerCase()))
//                .findFirst();
//
//        episodioBuscado.ifPresent(e -> System.out.println("Episódio encontrado: " + e.getTitulo()));
//        if (episodioBuscado.isEmpty()) System.out.println("Episódio não encontrado.");

        // TOP 5 EPISODIOS
//        System.out.println("Top 5 Episódios:");
//
//        episodios.stream()
//                .sorted(Comparator.comparing(Episodio::getAvaliacao).reversed())
//                .limit(5)
//                //.peek(p -> System.out.println("Peek: " + p)) Percorre a etapa da Stream logando o processo
//                .forEach(System.out::println);

// FILTRA PELO ANO
//        System.out.println("A partir de qual ano deseja ver os episódios?");
//        var ano = leitura.nextInt();
//        LocalDate dataBusca = LocalDate.of(ano, 1, 1);
//
//        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        episodios.stream()
//                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e -> System.out.println(
//                        "Temporada:" + e.getTemporada() + " Episódio:" + e.getNumeroEpisodio() + " " + e.getTitulo() + " (" + e.getDataLancamento().format(formatador) + ")."
//                ));
    }
}
