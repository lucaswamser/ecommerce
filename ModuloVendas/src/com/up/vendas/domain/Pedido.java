package com.up.vendas.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido {

	@Id
	@GeneratedValue
	private Integer idPedido;
	private Integer idUsuario;
	@OneToMany(mappedBy = "pedido", targetEntity = ItemPedido.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ItemPedido> produtos;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Pagamento pagamento;
	@OneToOne(cascade = CascadeType.ALL)
	private Frete frete;
	private String status;
	private Date date;
	private Double total;

	public Pedido() {
		frete= new Frete();
		total = 0.0;
	}

	
	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


	public List<ItemPedido> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ItemPedido> produtos) {
		this.produtos = produtos;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Frete getFrete() {
		return frete;
	}

	public void setFrete(Frete frete) {
		this.frete = frete;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Double getTotal() {
		if (total == null)
			total = 0.0;
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void adicionarProduto(ItemPedido itemPedido) {
		adicionarValor(itemPedido.getTotal());
		if (this.produtos == null)
			this.produtos = new ArrayList<ItemPedido>();
		this.frete.setPeso(this.frete.getPeso() + itemPedido.getPeso() * itemPedido.getQuantidade());
		for (ItemPedido item : produtos) {
			if (item.getIdProduto() == itemPedido.getIdProduto()) {
				item.setQuantidade(item.getQuantidade()
						+ itemPedido.getQuantidade());
				return;
			}
		}
		produtos.add(itemPedido);

	}
	
	public void removerProduto(ItemPedido itemPedido){
		for (ItemPedido item : produtos) {
			removerValor(itemPedido.getTotal());
			if (item.getIdProduto() == itemPedido.getIdProduto()) {
				this.frete.setPeso(this.frete.getPeso() - (itemPedido.getPeso() * itemPedido.getQuantidade()));
				item.setQuantidade(item.getQuantidade() - itemPedido.getQuantidade());
				if (item.getQuantidade() <= 0)
					produtos.remove(item);
				return;
			}
		}
	}
	
	public void setValorFrete(Double valor){
			this.setTotal(this.getTotal() + valor);
			this.frete.setValorTotal(valor);
	}
	public void adicionarValor(Double valor){
		this.setTotal(this.getTotal() + valor);
	}
	public void removerValor(Double valor){
		this.setTotal(this.getTotal() - valor);
	}
	
	

}
