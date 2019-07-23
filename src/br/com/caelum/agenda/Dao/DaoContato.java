package br.com.caelum.agenda.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.agenda.entidades.Contato;
import br.com.caelum.agenda.jdbc.ConnectionFactory;

public class DaoContato implements Dao<Contato> {

	/**
	 * return true se a operação for executada com sucesso
	 * 
	 * @throws ClassNotFoundException
	 */
	@Override
	public void inserir(Contato entidade) throws SQLException, ClassNotFoundException {

		Connection conexao = new ConnectionFactory().getConnection();

		String sql = "INSERT into contatos (nome,email,endereco,dataNascimento) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = conexao.prepareStatement(sql);
		preparedStatement.setString(1, entidade.getNome());
		preparedStatement.setString(2, entidade.getEmail());
		preparedStatement.setString(3, entidade.getEndereco());
		preparedStatement.setString(4, entidade.getDataNascimento());

		if (!preparedStatement.execute()) {
			preparedStatement.close();
			// fechando conexão
			conexao.close();
			System.out.println("O contato: " + entidade.getNome() + " foi salvo com sucesso.");

		} else {
			// fechando conexão
			conexao.close();
			System.out.println("Erro ao salvar o contato!");

		}

	}

	@Override
	public void atualizar(Contato entidade) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE contatos SET nome=?, email=?,endereco=?,dataNascimento=?  WHERE id=?";
		try(Connection conexao = new ConnectionFactory().getConnection()) {
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);

			preparedStatement.setString(1, entidade.getNome());
			preparedStatement.setString(2, entidade.getEmail());
			preparedStatement.setString(3, entidade.getEndereco());
			preparedStatement.setString(4, entidade.getDataNascimento());
			preparedStatement.setInt(5, entidade.getId());
			preparedStatement.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}

	@Override
	public void excluir(Contato entidade) throws SQLException, ClassNotFoundException {
	try(Connection conexao = new ConnectionFactory().getConnection() ) {
		PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM contatos WHERE id = ?");
		preparedStatement.setInt(1, entidade.getId());
		preparedStatement.execute();
		preparedStatement.close();
	} 

	}

	@Override
	public List<Contato> getList() throws SQLException, ClassNotFoundException {

		Connection conexao = new ConnectionFactory().getConnection();

		List<Contato> contatos = new ArrayList<>();

		PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * from contatos");

		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			Contato contato = new Contato();
			contato.setId(rs.getInt("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			contato.setDataNascimento(rs.getString("dataNascimento"));
			contatos.add(contato);

		}

		preparedStatement.close();
		conexao.close();

		return contatos;
	}

	@Override
	public Object pesquisar(int idProduto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	//validações 
	public Boolean validaEmail(String email) throws SQLException, ClassNotFoundException{
			Connection conexao = new ConnectionFactory().getConnection();
			PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM contatos WHERE email LIKE ?;");
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.getString("email") == email) {
				preparedStatement.close();
				return false;
			}
				preparedStatement.close();
				return true;
			
		
		
	}

}
