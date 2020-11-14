package br.com.qualiti.servicos;

import static br.com.qualiti.utils.DataUtils.adicionarDias;

import java.util.Date;
import java.util.List;

import br.com.qualiti.entidades.Filme;
import br.com.qualiti.entidades.Locacao;
import br.com.qualiti.entidades.Usuario;
import br.com.qualiti.exceptions.LocadoraException;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws Exception {
		
		if(usuario == null) {
			throw new LocadoraException("Usu·rio Nulo");
		}
		
		if(filmes == null || filmes.isEmpty()) {
			throw new LocadoraException("Filme nulo");
		}
		for (Filme filme : filmes) {
			if(filme == null) {
				throw new LocadoraException("Filme nulo");
			} else if(filme.getEstoque()==0) {
				throw new LocadoraException("Filme sem estoque!");
			}
		}
		
		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		Double valorTotal = 0.0;
		
		for (Filme filme : filmes) {
			valorTotal = valorTotal + filme.getPrecoLocacao();
			
		}
		locacao.setValor(valorTotal);

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar m√©todo para salvar
		
		return locacao;			
		
	}
}