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
		Double valorUnidade = 0.0;
		Double desconto = 0.0;
		
		for (Filme filme : filmes) {
			valorUnidade = filme.getPrecoLocacao();
			valorTotal = valorTotal + filme.getPrecoLocacao();
			
		}
		locacao.setValor(valorTotal);
		
		switch (filmes.size()) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			desconto = valorUnidade * 25/100;
			valorTotal = locacao.getValor() - desconto;
			break;
		case 4:
			desconto = valorUnidade * 50/100;
			valorTotal = locacao.getValor() - desconto;
			break;
		case 5:
			desconto = valorUnidade * 75/100;
			valorTotal = locacao.getValor() - desconto;
			break;
		case 6:
			desconto = valorUnidade * 100/100;
			valorTotal = locacao.getValor() - desconto;
			break;

		default:
			desconto = valorUnidade * 100/100;
			valorTotal = locacao.getValor() - desconto;
			break;
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