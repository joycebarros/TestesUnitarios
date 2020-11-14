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

}
