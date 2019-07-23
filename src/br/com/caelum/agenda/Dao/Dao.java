package br.com.caelum.agenda.Dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
	void inserir(T entidade) throws SQLException, ClassNotFoundException;
	void atualizar(T entidade) throws SQLException, ClassNotFoundException;
	void excluir(T entidade) throws SQLException, ClassNotFoundException;
	List<T> getList() throws SQLException, ClassNotFoundException;
	Object pesquisar(int idProduto) throws SQLException;
	
}
