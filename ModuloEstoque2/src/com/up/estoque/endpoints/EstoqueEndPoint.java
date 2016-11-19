package com.up.estoque.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.up.estoque.domain.Produto;
import com.up.estoque.domain.ProdutoDeposito;
import com.up.estoque.domain.MovimentacaoSaida;
import com.up.estoque.interfaces.services.DepositoService;
import com.up.estoque.interfaces.services.ProdutoService;
import com.up.estoque.repositories.ProdutoRepository;

@RestController
@RequestMapping(path="/rest/Deposito")
public class EstoqueEndPoint {

	@Autowired
	private DepositoService depositoService;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@RequestMapping(path="produtos",method=RequestMethod.GET)
	public List<ProdutoDeposito> produtos(){
		return depositoService.fazerInventario();
	}
	
	@RequestMapping(path="produto/{id}",method=RequestMethod.GET)
	public ProdutoDeposito produto(@PathVariable("id") Integer id){
		return depositoService.carregarProdutoRepositorioPorId(id);
		
	}
	@RequestMapping(path="baixar/{id}/{quantidade}",method=RequestMethod.GET)
	public boolean baixar(@PathVariable("id")Integer idProduto,@PathVariable("quantidade") Integer quantidade){
		MovimentacaoSaida ms = new MovimentacaoSaida();
		ms.setProduto(produtoRepository.findOne(idProduto));
		ms.setQuantidade(quantidade);
		depositoService.movimentar(ms);
		return true;
	}
	
	
}
