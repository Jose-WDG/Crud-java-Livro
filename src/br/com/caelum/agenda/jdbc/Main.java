package br.com.caelum.agenda.jdbc;

import java.sql.SQLException;
import java.util.List;

import br.com.caelum.agenda.Dao.DaoContato;
/*import br.com.caelum.agenda.entidades.Contato;*/
import br.com.caelum.agenda.entidades.Contato;



public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		/*
		 * Contato contato = new Contato();
		 * contato.setNome("josé Ramalho da silva neto");
		 * contato.setEmail("neto.silva101@outlook.com");
		 * contato.setEndereco("Rua manuel pla");
		 * contato.setDataNascimento("01-05-1998");
		 */
		
		DaoContato contatoDao = new DaoContato();
		List<Contato> cont = contatoDao.getList();
		for(Contato contato: cont) {
			System.out.println("id: "+contato.getId()+" !! nome: "+contato.getNome()+" !! email: "+contato.getEmail()+" !! endereço: "+contato.getEndereco()+" !! data de nascimento: "+contato.getDataNascimento()+"\n");
		}

	}

}
