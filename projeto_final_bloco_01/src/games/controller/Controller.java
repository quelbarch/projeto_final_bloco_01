package games.controller;

import java.util.ArrayList;
import java.util.List;


import games.model.Produto;
import games.repository.Repository;
import games.util.Cores;


public class Controller implements Repository {
	
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	int id = 0;

	
	@Override
	public void listarTodos() {
		for (var produto : listaProdutos) {
			produto.visualizar();
		}
	}

	@Override
	public void buscarPorId(int id) {

		var produto = buscarNaCollection(id);

		if (produto != null) {
			produto.visualizar();
		} else {
			System.out.printf(Cores.TEXT_RED + "\nO Produto id: %d não foi encontrado!\n" + Cores.TEXT_RESET, id);
		}
	}

	@Override
	public void cadastrar(Produto produto) {

		produto.setId(gerarId());
		listaProdutos.add(produto);

		System.out.println(Cores.TEXT_BLUE + "\nProduto cadastrado com sucesso!" + Cores.TEXT_RESET);
	}

	@Override
	public void atualizar(Produto produto) {

		var buscarProduto = buscarNaCollection(produto.getId());

		if (buscarProduto != null) {

			int index = listaProdutos.indexOf(buscarProduto);
			listaProdutos.set(index, produto);

			System.out.printf(Cores.TEXT_BLUE + "\nO Produto id: %d foi atualizado com sucesso!\n" + Cores.TEXT_RESET, produto.getId());

		} else {
			System.out.printf(Cores.TEXT_RED + "\nO Produto id: %d não foi encontrado!\n" + Cores.TEXT_RESET, produto.getId());
		}
	}

	@Override
	public void deletar(int id) {

		var produto = buscarNaCollection(id);

		if (produto != null) {

			listaProdutos.remove(produto);
			System.out.printf(Cores.TEXT_BLUE + "\nO produto id %d foi deletado com sucesso!\n" + Cores.TEXT_RESET, id);

		} else {
			System.out.printf(Cores.TEXT_RED + "\nO Produto id: %d não foi encontrado!\n" + Cores.TEXT_RESET, id);
		}
	}

	public int gerarId() {
		return ++id;
	}

	public Produto buscarNaCollection(int id) {

		for (var produto : listaProdutos) {
			if (produto.getId() == id) {
				return produto;
			}
		}

		return null;
	}
}