package br.com.estudos.bo;

import java.util.List;

public class PoloComissaoBatchBO {

	private Long controleCalculoComissao;
	private List<String> controlePolosComissao;

	public Long getControleCalculoComissao() {
		return controleCalculoComissao;
	}

	public void setControleCalculoComissao(Long controleCalculoComissao) {
		this.controleCalculoComissao = controleCalculoComissao;
	}

	public List<String> getControlePolosComissao() {
		return controlePolosComissao;
	}

	public void setControlePolosComissao(List<String> controlePolosComissao) {
		this.controlePolosComissao = controlePolosComissao;
	}
}
