package teste.connectedDatabase;

import javax.swing.JOptionPane;

import org.junit.Test;

import dao.UserDao;
import model.UserModelo;

public class AppTest {

	@Test
	public void start() {
		// SingleConnected.getConnection();

		UserDao userDao = new UserDao();
		UserModelo userModelo = new UserModelo();

		userModelo.setId(Long.valueOf(JOptionPane.showInputDialog("ID")));
		userModelo.setName(JOptionPane.showInputDialog("Nome").toUpperCase());
		userModelo.setEmail(JOptionPane.showInputDialog("Email").toLowerCase());
		userDao.insert(userModelo);
	}

}
