package br.com.qualiti.servicos;

import static br.com.qualiti.utils.DataUtils.adicionarDias;

import java.util.Date;

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
		Usuario usuario2 = new Usuario("Elian");
		Filme filme1 = new Filme("Titanic", 5, 5.5);
		Filme filme2 = new Filme("Harry Potter", 4, 6.0);
		Locacao locacao1 = new Locacao();
	//	Locacao locacao2 = new Locacao();
		LocacaoService service = new LocacaoService();
		
		// ACAO : O teste
				
		locacao1.setUsuario(usuario1);
		locacao1.setFilme(filme2);
		locacao1.setValor(filme2.getPrecoLocacao());
		locacao1.setDataLocacao(new Date());
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 2);
		locacao1.setDataRetorno(dataEntrega);
		
		Locacao locacao = null;
		try {
			locacao = service.alugarFilme(usuario2, filme1);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		locacao2.setUsuario(usuario2);
//		locacao2.setFilme(filme1);
//		locacao2.setValor(filme1.getPrecoLocacao());
//		locacao2.setDataLocacao(new Date());
//		Date dataEntrega2 = new Date();
//		dataEntrega2 = adicionarDias(dataEntrega2, 3);
//		locacao2.setDataRetorno(dataEntrega2);
		
		// VERIFICACAO : Checar resultado do teste
		
//		System.out.println(usuario1.toString());
//		System.out.println(usuario2.toString());
//		System.out.println(filme1.toString());
//		System.out.println(filme2.toString());
		System.out.println(locacao.getValor());
		System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		
		
	}
}
