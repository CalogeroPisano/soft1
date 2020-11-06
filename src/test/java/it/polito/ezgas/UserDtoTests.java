package it.polito.ezgas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import it.polito.ezgas.dto.UserDto;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDtoTests {
	private static UserDto user;
	@Before
	public void setup() {
		user = new UserDto(1, "calogero", "password", "test@gmail.com", 0, false);
	}
	@Test
	public void testgetUserId() {
		Integer actual = user.getUserId();
		assertEquals(1, actual, 0);
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
	public void testgetAdmin() {
		Boolean testValue = user.getAdmin();
		assertEquals(testValue, false);
	}
	@Test
	public void testsetAdmin() {
		Boolean testValue = true;
		user.setAdmin(testValue);
		Boolean value = user.getAdmin();
		assertNotNull("userId is not null", user.getAdmin());
		assertEquals(testValue, value);
	}
	
}
