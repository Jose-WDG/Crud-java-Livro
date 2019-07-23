package br.com.caelum.agenda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/agendacontatos?useSSL=false", "root", "81776279");

	}
}
