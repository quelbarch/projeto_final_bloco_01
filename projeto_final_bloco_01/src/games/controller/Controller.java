package games.controller;

import java.util.ArrayList;
import java.util.List;


import games.model.Produto;
import games.repository.Repository;


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
			System.out.printf("\nO Produto id: %d não foi encontrado!\n", id);
		}
	}

	@Override
	public void cadastrar(Produto produto) {

		produto.setId(gerarId());
		listaProdutos.add(produto);

		System.out.println("\nProduto cadastrado com sucesso!");
	}

	@Override
	public void atualizar(Produto produto) {

		var buscarProduto = buscarNaCollection(produto.getId());

		if (buscarProduto != null) {

			int index = listaProdutos.indexOf(buscarProduto);
			listaProdutos.set(index, produto);

			System.out.printf("\nO Produto id: %d foi atualizado com sucesso!\n", produto.getId());

		} else {
			System.out.printf("\nO Produto id: %d não foi encontrado!\n", produto.getId());
		}
	}

	@Override
	public void deletar(int id) {

		var produto = buscarNaCollection(id);

		if (produto != null) {

			listaProdutos.remove(produto);
			System.out.printf("\nO produto id %d foi deletado com sucesso!\n", id);

		} else {
			System.out.printf("\nO Produto id: %d não foi encontrado!\n", id);
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