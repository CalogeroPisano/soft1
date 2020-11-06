package it.polito.ezgas;
import org.junit.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.polito.ezgas.dto.IdPw;


@RunWith(SpringRunner.class)

public class IdPwTests {
	private IdPw credentials=new IdPw("user","password");
	
	@Test
	public void test_IdPwUser() {
		credentials.setUser("pippo@ezgas.users.com");
		assert(credentials.getUser().equals("pippo@ezgas.users.com"));
	}
	@Test
	public void test_IdPwPassword() {
		credentials.setPw("a.b@c.com");
		assert(credentials.getPw().equals("a.b@c.com"));
	}
}
