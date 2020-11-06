package it.polito.ezgas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import it.polito.ezgas.entity.User;;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	private static User user;
	@Before
	public void setupUser() {
		user = new User("calogero", "password", "test@gmail.com", 0);
	}
	
	@Test
	public void testsetUserId() {
		Integer testValue = 2;
		user.setUserId(testValue);
		Integer value = user.getUserId();
		assertNotNull("userId is not null", user.getUserId());
		assertEquals(testValue, value);
	}
	
	@Test
	public void testgetUserId() {
		user.setUserId(1);
		assertNotNull("userId is not null", user.getUserId());
		assertTrue(user.getUserId() instanceof Integer);
		assertEquals(user.getUserId(), 1, 0);
	}
	
	@Test
	public void testgetUserName() {
		String testValue = user.getUserName();
		assertEquals(testValue, "calogero");
	}
	@Test
	public void testsetUserName() {
		String testValue = "testName";
		user.setUserName(testValue);
		String value = user.getUserName();
		assertNotNull("userId is not null", user.getUserName());
		assertEquals(testValue, value);
	}
	@Test
	public void testgetPassword() {
		String testValue = user.getPassword();
		assertEquals(testValue, "password");
	}
	@Test
	public void testsetPassword() {
		String testValue = "testPassword";
		user.setPassword(testValue);
		String value = user.getPassword();
		assertNotNull("userId is not null", user.getPassword());
		assertEquals(testValue, value);
	}
	@Test
	public void testgetEmail() {
		String testValue = user.getEmail();
		assertEquals(testValue, "test@gmail.com");
	}
	@Test
	public void testsetEmail() {
		String testValue = "testEmail@gmail.com";
		user.setEmail(testValue);
		String value = user.getEmail();
		assertNotNull("userId is not null", user.getEmail());
		assertEquals(testValue, value);
	}
	@Test
	public void testgetReputation() {
		Integer testValue = user.getReputation();
		assertEquals(testValue, 0, 0);
	}
	@Test
	public void testsetReputation() {
		Integer testValue = 2;
		user.setReputation(testValue);
		Integer value = user.getReputation();
		assertNotNull("userId is not null", user.getReputation());
		assertEquals(testValue, value);
	}
	
	@Test
	public void testsetAdmin() {
		Boolean testValue = true;
		user.setAdmin(testValue);
		Boolean value = user.getAdmin();
		assertNotNull("userId is not null", user.getAdmin());
		assertEquals(testValue, value);
	}
	@Test
	public void testgetAdmin() {
		user.setAdmin(false);
		Boolean testValue = user.getAdmin();
		assertNotNull("userId is not null", user.getAdmin());
		assertTrue(user.getAdmin() instanceof Boolean);
		assertEquals(testValue, false);
	}
}
