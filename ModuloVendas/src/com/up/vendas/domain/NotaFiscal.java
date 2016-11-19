package com.up.vendas.domain;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class NotaFiscal {

	public Emissor emissor;
	public Destinatario destinario;
	public List<ItemPedido> produtos;
	public Double valorTotal;
	public Double valorFrete;
	
	public NotaFiscal(Emissor emissor, Destinatario destinario,
			List<ItemPedido> produtos) {
		super();
		this.emissor = emissor;
		this.destinario = destinario;
		this.produtos = produtos;
	}

	public NotaFiscal(Pedido pedido) {
		this.emissor = new Emissor("Loja do Zé", "00000000000/00",
				"Rua Prof Viriato p. De Souza 5175", "Mossungue", "81280330",
				"Curitiba", "PR", 1254840);
		this.setDestinario(pedido.getFrete().getDestinatario());
		this.setProdutos(pedido.getProdutos());
		this.setValorTotal(pedido.getTotal());
		this.setValorFrete(pedido.getFrete().getValorTotal());;
	}

	public Emissor getEmissor() {
		return emissor;
	}

	public void setEmissor(Emissor emissor) {
		this.emissor = emissor;
	}

	public Destinatario getDestinario() {
		return destinario;
	}

	public void setDestinario(Destinatario destinario) {
		this.destinario = destinario;
	}

	public List<ItemPedido> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ItemPedido> produtos) {
		this.produtos = produtos;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public String toJson(){
		
		String json = "{\"Nfe\":{\"Id\":1,\"Operacao\":1,\"Natureza_operacao\":\"Venda de producao do estabelecimento\"},\"Emitente\":{\"Cnpj\":\""+this.getEmissor().getCnpj()+"\",\"IE\":\""+this.getEmissor().getIncricaoEstadual()+"\",\"RazaoSocial\":\""+this.getEmissor().getRazaoSocial()+"\",\"Endereco\":\""+this.getEmissor().getEndereco()+"\",\"Complemento\":\" \",\"Numero\":5175,\"Bairro\":\"\",\"Municipio\":\""+this.getEmissor().getMunicipio()+"\",\"UF\":\""+this.getEmissor().getUF()+"\",\"Cep\":\""+this.getEmissor().getCep()+"\",\"Telefone\":\"4187682306\",\"Email\":\"suporte@voltzstore.com\"},"
				+ "\"Destinatario\":{\"Cpf\":\""+this.getDestinario().getCpfCnpj()+"\",\"Cnpj\":\"\",\"IE\":\"\",\"Nome\":\""+this.getDestinario().getNome()+"\",\"Endereco\":\""+this.getDestinario().getRua()+"\",\"Complemento\":\"\",\"Numero\":"+this.getDestinario().getNumero()+",\"Bairro\":\"\",\"Municipio\":\"Curitiba\",\"UF\":\""+this.getDestinario().getEstado()+"\",\"Cep\":\""+this.getDestinario().getCep()+"\",\"Telefone\":\""+this.getDestinario().getTelefone()+"\",\"Email\":\""+this.getDestinario().getEmail()+"\"},"
				+ "\"Produtos\":{";
				Integer cont = 0;
				for (ItemPedido produto : produtos) {
			    cont++;
				json = json+ "\"Produto"+cont+"\": {\"Id\":"+produto.getIdProduto()+",\"Descricao\":\""+produto.getNome()+"\",\"Sku\":\"\",\"Ean\":\"07896020153"+produto.getIdProduto()+"\",\"Ncm\":\"6109.10.00\",\"Cest\":\"28.038.00\",\"Quantidade\":"+produto.getQuantidade()+",\"Valor\":"+produto.getPrecoUnitario()+",\"Unidade\":\"UN\",\"Peso\":\""+produto.getPeso()+"\",\"Origem\":0,\"Aliquota\":12";
				if (cont != produtos.size())
				json = json+ "},";
				else
				json = json+ "}";	
				}
			    json = json+ "}"
				+ "\"Pedido\":{\"Id\":1,\"Pagamento\":0,\"Presenca\":2,\"Frete\":\""+this.getValorFrete()+"\",\"Desconto\":\"0.00\",\"Total\":\""+this.getValorTotal()+"\"},\"Transportador\":{\"Cnpj\":\"14.400.427/0001-82\",\"Razaosocial\":\"Loja do Zé Transportes LTDA\",\"IE\":\"123.456.789.123\",\"Endereco\":\"Rua Prof Pedro V. P De Souza 5175\",\"UF\":\"PR\",\"Municipio\":\"Curitiba\",\"Cep\":\"80540-180\"}}";
		return json;
	}
}
