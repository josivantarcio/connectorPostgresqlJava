package teste.connectedDatabase;

import org.junit.Test;

import connectJdbc.SingleConnected;

public class AppTest {

	@Test
	public void start() {
		SingleConnected.getConnection();
	}

}
