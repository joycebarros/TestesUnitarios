package br.com.qualiti.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.qualiti.entidades.Filme;
import br.com.qualiti.entidades.Locacao;
import br.com.qualiti.entidades.Usuario;
import br.com.qualiti.exceptions.LocadoraException;
import br.com.qualiti.utils.DataUtils;



public class LocacaoServiceTest {

	@Test
	@DisplayName("Meu primeiro teste no JUnit")
	public void meuPrimeiroTeste() {
		
		
		// Fa√ßa um teste do metodo alugarFilme() apenas usando Java. 
		// Para simplificar vamos verificar apenas o valor do filme, a data de loca√ß√£o e data de retorno
		// Todo teste deve ser estruturado da seguinte forma:
		
		// CENARIOS: Montagem de ambiente
		
		Usuario usuario1 = new Usuario("Joyce");
		List<Filme> filmes = new ArrayList<>();
		Filme filme1 = new Filme("ABC", 3, 5.5);
		Filme filme2 = new Filme("Titanic", 4, 3.0);
		
		filmes.add(filme1);
		filmes.add(filme2);
				
		LocacaoService service = new LocacaoService();
		
		// ACAO : O teste
				
		Locacao locacao = null;
		try {
			locacao = service.alugarFilme(usuario1, filmes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// VERIFICACAO : Checar resultado do teste
		
		Assert.assertTrue(locacao.getValor() == 8.5);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
		Assert.assertNotNull(locacao);
		
	}
	
	@Test
	@DisplayName("Teste de Usu·rio Nulo")
	public void testeDeUsuarioException() throws Exception {
		
		// CENARIOS: Montagem de ambiente
		Usuario usuario1 = null;
		List<Filme> filmes = new ArrayList<>();
		Filme filme1 = new Filme("ABC", 3, 5.5);
		Filme filme2 = new Filme("Titanic", 4, 3.0);
		
		filmes.add(filme1);
		filmes.add(filme2);
				
		LocacaoService service = new LocacaoService();
		
		// ACAO : O teste
		
		LocadoraException exceptionEsperada = assertThrows(LocadoraException.class, () -> {
			service.alugarFilme(usuario1, filmes);
		});
			
		
		// VERIFICACAO : Checar resultado do teste
		
		assertEquals(exceptionEsperada.getMessage(), "Usu·rio Nulo");
		
	}
	
	@Test
	@DisplayName("Teste de Filme Nulo")
	public void testeDeFilmeException() throws Exception {
		
		// CENARIOS: Montagem de ambiente
		Usuario usuario1 = new Usuario("Joyce");
		List<Filme> filmes = null;
				
		LocacaoService service = new LocacaoService();
		
		// ACAO : O teste
				
		LocadoraException exceptionEsperada = assertThrows(LocadoraException.class, () -> {
			service.alugarFilme(usuario1, filmes);
		});
			
		
		// VERIFICACAO : Checar resultado do teste
		
		assertEquals(exceptionEsperada.getMessage(), "Filme nulo");
		
	}
	
	// Desafio 5 - 
		// O cliente tem desconto crescentes (n„o acumulativos):
		// - 25% no 3∫ filme
		// - 50% no 4∫ filme
		// - 75% no 5∫ filme
		// - 100% no 6∫ filme
		// - n„o tem desconto no 7∫ filme em diante
	
	
	@Test
	@DisplayName("Teste com 2 filmes")
	public void testeComDoisFilmes() throws Exception {
		
		// CENARIOS: Montagem de ambiente
		
		Usuario usuario1 = new Usuario("Joyce");
		List<Filme> filmes = new ArrayList<>();
		Filme filme1 = new Filme("Filme1", 3, 5.0);
		Filme filme2 = new Filme("Filme2", 4, 5.0);
				
		filmes.add(filme1);
		filmes.add(filme2);
			
		LocacaoService service = new LocacaoService();
		
		// ACAO : O teste
				
		Locacao locacao = service.alugarFilme(usuario1, filmes);
				
		
		// VERIFICACAO : Checar resultado do teste
		
		assertEquals(locacao.getValor(), 10.00);				
		
	}
	
	@Test
	@DisplayName("Teste com 3 filmes")
	public void testeComTresFilmes() throws Exception {
		
		// CENARIOS: Montagem de ambiente
		
		Usuario usuario1 = new Usuario("Joyce");
		List<Filme> filmes = new ArrayList<>();
		Filme filme1 = new Filme("Filme1", 3, 5.0);
		Filme filme2 = new Filme("Filme2", 4, 5.0);
		Filme filme3 = new Filme("Filme3", 4, 5.0);
		
		filmes.add(filme1);
		filmes.add(filme2);
		filmes.add(filme3);
		
		LocacaoService service = new LocacaoService();
		
		// ACAO : O teste
				
		Locacao locacao = service.alugarFilme(usuario1, filmes);
				
		
		// VERIFICACAO : Checar resultado do teste
		
		assertEquals(locacao.getValor(), 13.75);				
		
	}
	
	@Test
	@DisplayName("Teste com 4 filmes")
	public void testeComQuatroFilmes() throws Exception {
		
		// CENARIOS: Montagem de ambiente
		
		Usuario usuario1 = new Usuario("Joyce");
		List<Filme> filmes = new ArrayList<>();
		Filme filme1 = new Filme("Filme1", 3, 5.0);
		Filme filme2 = new Filme("Filme2", 4, 5.0);
		Filme filme3 = new Filme("Filme3", 4, 5.0);
		Filme filme4 = new Filme("Filme4", 4, 5.0);
		
		filmes.add(filme1);
		filmes.add(filme2);
		filmes.add(filme3);
		filmes.add(filme4);
		
		LocacaoService service = new LocacaoService();
		
		// ACAO : O teste
				
		Locacao locacao = service.alugarFilme(usuario1, filmes);
				
		
		// VERIFICACAO : Checar resultado do teste
		
		assertEquals(locacao.getValor(), 17.50);				
		
	}
	
	@Test
	@DisplayName("Teste com 5 filmes")
	public void testeComCincoFilmes() throws Exception {
		
		// CENARIOS: Montagem de ambiente
		
		Usuario usuario1 = new Usuario("Joyce");
		List<Filme> filmes = new ArrayList<>();
		Filme filme1 = new Filme("Filme1", 3, 5.0);
		Filme filme2 = new Filme("Filme2", 4, 5.0);
		Filme filme3 = new Filme("Filme3", 4, 5.0);
		Filme filme4 = new Filme("Filme4", 4, 5.0);
		Filme filme5 = new Filme("Filme5", 4, 5.0);
		
		filmes.add(filme1);
		filmes.add(filme2);
		filmes.add(filme3);
		filmes.add(filme4);
		filmes.add(filme5);
		
		LocacaoService service = new LocacaoService();
		
		// ACAO : O teste
				
		Locacao locacao = service.alugarFilme(usuario1, filmes);
				
		
		// VERIFICACAO : Checar resultado do teste
		
		assertEquals(locacao.getValor(), 21.25);				
		
	}
	
	@Test
	@DisplayName("Teste com 6 filmes")
	public void testeComSeisFilmes() throws Exception {
		
		// CENARIOS: Montagem de ambiente
		
		Usuario usuario1 = new Usuario("Joyce");
		List<Filme> filmes = new ArrayList<>();
		Filme filme1 = new Filme("Filme1", 3, 5.0);
		Filme filme2 = new Filme("Filme2", 4, 5.0);
		Filme filme3 = new Filme("Filme3", 4, 5.0);
		Filme filme4 = new Filme("Filme4", 4, 5.0);
		Filme filme5 = new Filme("Filme5", 4, 5.0);
		Filme filme6 = new Filme("Filme6", 4, 5.0);
		
		filmes.add(filme1);
		filmes.add(filme2);
		filmes.add(filme3);
		filmes.add(filme4);
		filmes.add(filme5);
		filmes.add(filme6);
		
		LocacaoService service = new LocacaoService();
		
		// ACAO : O teste
				
		Locacao locacao = service.alugarFilme(usuario1, filmes);
				
		
		// VERIFICACAO : Checar resultado do teste
		
		assertEquals(locacao.getValor(), 25.00);				
		
	}
	
	@Test
	@DisplayName("Teste com 7 filmes")
	public void testeComSeteFilmes() throws Exception {
		
		// CENARIOS: Montagem de ambiente
		
		Usuario usuario1 = new Usuario("Joyce");
		List<Filme> filmes = new ArrayList<>();
		Filme filme1 = new Filme("Filme1", 3, 5.0);
		Filme filme2 = new Filme("Filme2", 4, 5.0);
		Filme filme3 = new Filme("Filme3", 4, 5.0);
		Filme filme4 = new Filme("Filme4", 4, 5.0);
		Filme filme5 = new Filme("Filme5", 4, 5.0);
		Filme filme6 = new Filme("Filme6", 4, 5.0);
		Filme filme7 = new Filme("Filme7", 4, 5.0);
		
		filmes.add(filme1);
		filmes.add(filme2);
		filmes.add(filme3);
		filmes.add(filme4);
		filmes.add(filme5);
		filmes.add(filme6);
		filmes.add(filme7);
		
		LocacaoService service = new LocacaoService();
		
		// ACAO : O teste
				
		Locacao locacao = service.alugarFilme(usuario1, filmes);
				
		
		// VERIFICACAO : Checar resultado do teste
		
		assertEquals(locacao.getValor(), 30.00);				
		
	}
	
	@Test
	@DisplayName("Teste com 8 filmes")
	public void testeComOitoFilmes() throws Exception {
		
		// CENARIOS: Montagem de ambiente
		
		Usuario usuario1 = new Usuario("Joyce");
		List<Filme> filmes = new ArrayList<>();
		Filme filme1 = new Filme("Filme1", 3, 5.0);
		Filme filme2 = new Filme("Filme2", 4, 5.0);
		Filme filme3 = new Filme("Filme3", 4, 5.0);
		Filme filme4 = new Filme("Filme4", 4, 5.0);
		Filme filme5 = new Filme("Filme5", 4, 5.0);
		Filme filme6 = new Filme("Filme6", 4, 5.0);
		Filme filme7 = new Filme("Filme7", 4, 5.0);
		Filme filme8 = new Filme("Filme8", 4, 5.0);
		
		filmes.add(filme1);
		filmes.add(filme2);
		filmes.add(filme3);
		filmes.add(filme4);
		filmes.add(filme5);
		filmes.add(filme6);
		filmes.add(filme7);
		filmes.add(filme8);
		
		LocacaoService service = new LocacaoService();
		
		// ACAO : O teste
				
		Locacao locacao = service.alugarFilme(usuario1, filmes);
				
		
		// VERIFICACAO : Checar resultado do teste
		
		assertEquals(locacao.getValor(), 35.00);				
		
	}

}
