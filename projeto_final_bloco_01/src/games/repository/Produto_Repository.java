package games.repository;

import games.model.Produto;

public interface Produto_Repository {

    public void listarTodos();
    public void buscarPorId(int id);
    public void cadastrar(Produto produto);
    public void atualizar(Produto produto);
    public void deletar(int id);

}