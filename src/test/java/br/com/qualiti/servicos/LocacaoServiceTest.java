package br.com.qualiti.servicos;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.qualiti.entidades.Filme;
import br.com.qualiti.entidades.Locacao;
import br.com.qualiti.entidades.Usuario;
import br.com.qualiti.utils.DataUtils;



public class LocacaoServiceTest {

	@Test
	@DisplayName("Meu primeiro teste no JUnit")
	public void meuPrimeiroTeste() {
		
		
		// Faça um teste do metodo alugarFilme() apenas usando Java. 
		// Para simplificar vamos verificar apenas o valor do filme, a data de locação e data de retorno
		// Todo teste deve ser estruturado da seguinte forma:
		
		// CENARIOS: Montagem de ambiente
		
		Usuario usuario1 = new Usuario("Joyce");
		Filme filme1 = new Filme("Titanic", 5, 5.5);
				
		LocacaoService service = new LocacaoService();
		
		// ACAO : O teste
				
		Locacao locacao = null;
		try {
			locacao = service.alugarFilme(usuario1, filme1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// VERIFICACAO : Checar resultado do teste
		
		Assert.assertTrue(locacao.getValor() == 5.5);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
		Assert.assertNotNull(locacao);
		
		
	}
}
