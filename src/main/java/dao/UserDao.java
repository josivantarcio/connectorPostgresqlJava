package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectJdbc.SingleConnected;
import model.UserModelo;

/**
 * Classe que faz o CRUD
 * 
 * @author Josevan
 *
 */
public class UserDao {

	private Connection connection;

	/**
	 * Construtora que faz a conexao ao banco
	 */
	public UserDao() {
		connection = SingleConnected.getConnection();
	}

	/**
	 * Insert
	 */
	public void insert(UserModelo userModelo) {
		try {
			String sqlString = "insert into " + SingleConnected.getDbJdbc() + "(id,nome,email) values (?,?,?)";
			/**
			 * Preparar os dados para o SQL
			 */
			PreparedStatement insertPreparedStatement = connection.prepareStatement(sqlString);
			insertPreparedStatement.setLong(1, userModelo.getId());
			insertPreparedStatement.setString(2, userModelo.getName());
			insertPreparedStatement.setString(3, userModelo.getEmail());
			insertPreparedStatement.execute();

			connection.commit(); // salvar dados no banco
			System.out.println("Dados adicionados com Sucesso ao Banco");
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

}
