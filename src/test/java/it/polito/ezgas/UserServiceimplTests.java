package it.polito.ezgas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import exception.GPSDataException;
import exception.InvalidGasStationException;
import exception.InvalidGasTypeException;
import exception.InvalidUserException;
import exception.PriceException;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.dto.IdPw;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.impl.GasStationServiceimpl;
import it.polito.ezgas.service.impl.UserServiceimpl;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceimplTests {
	UserServiceimpl userService;
	@Mock
	UserRepository userrepo_mock;
	@Mock
	UserDto userDto_mock;
	@Mock
	User user_mock;
	@Mock
	IdPw idpw_mock;
	@Mock
	LoginDto lgDto_mock;
	
	@Before
	public void setUp() {
		//userMock
		user_mock = mock(User.class);
		when(user_mock.getUserId()).thenReturn(1);
		when(user_mock.getEmail()).thenReturn("DummyEmail");
		when(user_mock.getPassword()).thenReturn("DummyPassword");
		when(user_mock.getUserName()).thenReturn("DummyUserName");
		when(user_mock.getAdmin()).thenReturn(false);
		when(user_mock.getReputation()).thenReturn(0);
		
		userDto_mock = mock(UserDto.class);
		when(userDto_mock.getUserId()).thenReturn(1);
		when(userDto_mock.getEmail()).thenReturn("DummyEmail");
		when(userDto_mock.getPassword()).thenReturn("DummyPassword");
		when(userDto_mock.getUserName()).thenReturn("DummyUserName");
		when(userDto_mock.getAdmin()).thenReturn(false);
		when(userDto_mock.getReputation()).thenReturn(0);
		
		idpw_mock = mock(IdPw.class);
		when(idpw_mock.getUser()).thenReturn("DummyEmail");
		when(idpw_mock.getPw()).thenReturn("DummyPassword");
		
		lgDto_mock = mock(LoginDto.class);
		when(lgDto_mock.getUserId()).thenReturn(1);
		when(lgDto_mock.getEmail()).thenReturn("DummyEmail");
		when(lgDto_mock.getUserName()).thenReturn("DummyUserName");
		when(lgDto_mock.getAdmin()).thenReturn(false);
		when(lgDto_mock.getReputation()).thenReturn(0);

		userrepo_mock = mock(UserRepository.class);
		when(userrepo_mock.save(any(User.class))).thenReturn(user_mock);
		
		userService = new UserServiceimpl(userrepo_mock);
	}
	
	@Test
	public void testUserToDto() {
		UserDto usDto = UserServiceimpl.UserToDto(user_mock);
		
		assertTrue(usDto.getUserId() == user_mock.getUserId());
		assertTrue(usDto.getUserName() == user_mock.getUserName());
		assertTrue(usDto.getEmail() == user_mock.getEmail());
		assertTrue(usDto.getAdmin() == user_mock.getAdmin());
		assertTrue(usDto.getReputation() == user_mock.getReputation());
		assertTrue(usDto.getPassword() == user_mock.getPassword());
	}
	
	@Test
	public void testUserFromDto() {
		User us = UserServiceimpl.UserFromDto(userDto_mock, false);
		
		assertTrue(us.getUserId() == userDto_mock.getUserId());
		assertTrue(us.getUserName() == userDto_mock.getUserName());
		assertTrue(us.getEmail() == userDto_mock.getEmail());
		assertTrue(us.getAdmin() == userDto_mock.getAdmin());
		assertTrue(us.getReputation() == userDto_mock.getReputation());
		assertTrue(us.getPassword() == userDto_mock.getPassword());
	}
	
	@Test
	public void testUserToLoginDto() {
		LoginDto logDto = UserServiceimpl.UserToLoginDto(user_mock);
		
		assertTrue(logDto.getUserId() == user_mock.getUserId());
		assertTrue(logDto.getUserName() == user_mock.getUserName());
		assertTrue(logDto.getEmail() == user_mock.getEmail());
		assertTrue(logDto.getAdmin() == user_mock.getAdmin());
		assertTrue(logDto.getReputation() == user_mock.getReputation());
		assertTrue(logDto.getToken() == "dummy");
	}
	
	@Test
	public void testgetUserById() {
		//test1
		when(userrepo_mock.findOne(anyInt())).thenReturn(null);
		try {
			UserDto returnValue = userService.getUserById(1);
			UserDto expectedValue = null;
			assertTrue(returnValue == expectedValue);
			
		}
		catch(Exception e){
			fail("unexpected exception");
		}
		
		//test2
		when(userrepo_mock.findOne(anyInt())).thenReturn(user_mock);
		try {
			UserDto returnValue = userService.getUserById(1);
			UserDto expectedValue = userDto_mock;
			assertTrue(returnValue.getUserId() == expectedValue.getUserId());
		}
		catch(Exception e) {
			fail("unexpected excetion");
		}
		
		//test3
		try {
			userService.getUserById(-1);
			fail("exception");
		}
		catch(Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testsaveUser() {
		
		//test1
		try {
			userService.saveUser(null);
			fail("exception");
			
		}
		catch(Exception e) {
			assertTrue(true);
		}
		
		//test2
		when(userrepo_mock.verifyEmail(userDto_mock.getEmail())).thenReturn(1);
		when(userDto_mock.getUserId()).thenReturn(null);
		try {
			UserDto returneduserDto = userService.saveUser(userDto_mock);
			UserDto expUserDto = null;
			assertTrue(returneduserDto == expUserDto);
			
		}
		catch(Exception e) {
			fail("unexpected excetion");
		}
		//test3 inside else if and update return 0
		when(userrepo_mock.verifyEmail(userDto_mock.getEmail())).thenReturn(1);
		when(userDto_mock.getUserId()).thenReturn(1);
		when(userrepo_mock.updateUsr(anyInt(), anyString(), anyString(), anyString())).thenReturn(0);
		try {
			UserDto returneduserDto = userService.saveUser(userDto_mock);
			UserDto expUserDto = null;
			assertTrue(returneduserDto == expUserDto);
			
		}
		catch(Exception e) {
			fail("unexpected excetion");
		}
		//test4 inside else if and update return 1
				when(userrepo_mock.verifyEmail(userDto_mock.getEmail())).thenReturn(1);
				when(userDto_mock.getUserId()).thenReturn(1);
				when(userrepo_mock.updateUsr(anyInt(), anyString(), anyString(), anyString())).thenReturn(1);
				try {
					UserDto returneduserDto = userService.saveUser(userDto_mock);
					UserDto expUserDto = userDto_mock;
					assertTrue(returneduserDto.getUserId() == expUserDto.getUserId());
					
				}
				catch(Exception e) {
					fail("unexpected excetion");
				}
		//test5 inside else if and update return 0
		when(userrepo_mock.verifyEmail(userDto_mock.getEmail())).thenReturn(0);
		when(userDto_mock.getUserId()).thenReturn(1);
		when(userrepo_mock.updateUsr(anyInt(), anyString(), anyString(), anyString())).thenReturn(0);
		try {
			UserDto returneduserDto = userService.saveUser(userDto_mock);
			UserDto expUserDto = null;
			assertTrue(returneduserDto == expUserDto);
			
		}
		catch(Exception e) {
			fail("unexpected excetion");
		}
		//test6 inside else id and update return 1
		
		when(userrepo_mock.verifyEmail(userDto_mock.getEmail())).thenReturn(0);
		when(userDto_mock.getUserId()).thenReturn(1);
		when(userrepo_mock.updateUsr(anyInt(), anyString(), anyString(), anyString())).thenReturn(1);
		try {
			UserDto returneduserDto = userService.saveUser(userDto_mock);
			UserDto expUserDto = userDto_mock;
			assertTrue(returneduserDto.getUserId() == expUserDto.getUserId());
			
		}
		catch(Exception e) {
			fail("unexpected excetion");
		}
		
		//test7 both works
		when(userrepo_mock.verifyEmail(userDto_mock.getEmail())).thenReturn(0);
		when(userDto_mock.getUserId()).thenReturn(null);
		try {
			UserDto returneduserDto = userService.saveUser(userDto_mock);
			UserDto expUserDto = userDto_mock;
			assertTrue(returneduserDto.getUserId() == expUserDto.getUserId());
		}
		catch(Exception e) {
			fail("unexpected excetion");
		}
		
	}
	@Test
	public void testgetAllUsers() {
		//test1
		when(userrepo_mock.findAll()).thenReturn(new ArrayList<User>());
		List<UserDto> returnedValue = userService.getAllUsers();
		assertTrue(returnedValue.size() == 0);
		
		//test2
		when(userrepo_mock.findAll()).thenReturn(new ArrayList<User>() {{add(user_mock);}});
		returnedValue = userService.getAllUsers();
		assertTrue(user_mock.getUserId() == returnedValue.get(0).getUserId());
	}
	@Test
	public void testdeleteUser() {
		//test1
		when(userrepo_mock.findOne(anyInt())).thenReturn(null);
		try {
			Boolean returnedValue = userService.deleteUser(1);
			assertTrue(returnedValue);
		}
		catch(Exception e) {
			fail("unexpected excetion");
		}
		//test2
		try {
			userService.deleteUser(-1);
			fail("exception");
		}
		catch(Exception e) {
			assertTrue(true);
		}
	}
	@Test
	public void testlogin() {
		//test1 else
		
		try {
			userService.login(null);
			fail("expected excetion");
		}
		catch(Exception e) {
			assertTrue(true);
		}
		//test2 (first ok others not)
		when(userrepo_mock.findOne(anyInt())).thenReturn(user_mock);
		when(idpw_mock.getUser()).thenReturn("notequal");
		when(idpw_mock.getPw()).thenReturn("notequal");
		try {
			userService.login(idpw_mock);
			fail("expected excetion");
		}
		catch(Exception e) {
			assertTrue(true);
		}
		
		//test3 (first two ok and other one not)
		when(userrepo_mock.findOne(anyInt())).thenReturn(user_mock);
		when(idpw_mock.getUser()).thenReturn("DummyEmail");
		when(idpw_mock.getPw()).thenReturn("notequal");
		try {
			userService.login(idpw_mock);
			fail("expected excetion");
		}
		catch(Exception e) {
			assertTrue(true);
		}
		//test4 (second ok others not)
		when(userrepo_mock.findOne(anyInt())).thenReturn(null);
		when(idpw_mock.getUser()).thenReturn("DummyEmail");
		when(idpw_mock.getPw()).thenReturn("notequal");
		try {
			userService.login(idpw_mock);
			fail("expected excetion");
		}
		catch(Exception e) {
			assertTrue(true);
		}
		//test5 (second and third ok the other one not)
		when(userrepo_mock.findOne(anyInt())).thenReturn(null);
		when(idpw_mock.getUser()).thenReturn("DummyEmail");
		when(idpw_mock.getPw()).thenReturn("DummyPassword");
		try {
			userService.login(idpw_mock);
			fail("expected excetion");
		}
		catch(Exception e) {
			assertTrue(true);
		}
		//test6 (third ok and others not)
		when(userrepo_mock.findOne(anyInt())).thenReturn(null);
		when(idpw_mock.getUser()).thenReturn("notequal");
		when(idpw_mock.getPw()).thenReturn("DummyPassword");
		try {
			userService.login(idpw_mock);
			fail("expected excetion");
		}
		catch(Exception e) {
			assertTrue(true);
		}
		//test7 (first and third ok the other one not)
		when(userrepo_mock.findOne(anyInt())).thenReturn(user_mock);
		when(idpw_mock.getUser()).thenReturn("notequal");
		when(idpw_mock.getPw()).thenReturn("DummyPassword");
		try {
			userService.login(idpw_mock);
			fail("expected excetion");
		}
		catch(Exception e) {
			assertTrue(true);
		}
		//test8 (all ok)
		when(userrepo_mock.findOne(anyInt())).thenReturn(user_mock);
		when(idpw_mock.getUser()).thenReturn("DummyEmail");
		when(idpw_mock.getPw()).thenReturn("DummyPassword");
		try {
			LoginDto returnedValue = userService.login(idpw_mock);
			LoginDto value = lgDto_mock;
			assertTrue(returnedValue.getUserId() == value.getUserId());	
		}
		catch(Exception e) {
			fail("unexpected excetion");
		}
	}
	@Test
	public void testincreaseUserReputation() {
		//test1
		try {
			userService.increaseUserReputation(-1);
			fail("exception");
		}
		catch(Exception e) {
			assertTrue(true);
		}
		
		//test2
		when(userrepo_mock.findOne(anyInt())).thenReturn(user_mock);
		try {
			Integer returnedValue = userService.increaseUserReputation(1);
			Integer exceptedValue = user_mock.getReputation() + 1;
			assertTrue(returnedValue == exceptedValue);
		}
		catch(Exception e) {
			fail("exception");
		}
		//test3 actual reputation equal to 5
		when(userrepo_mock.findOne(anyInt())).thenReturn(user_mock);
		when(userrepo_mock.getReputation(anyInt())).thenReturn(5);
		try {
			Integer returnedValue = userService.increaseUserReputation(1);
			Integer exceptedValue = 5;
			assertTrue(returnedValue == exceptedValue);
		}
		catch(Exception e) {
			fail("exception");
		}
		
		//test4
		when(userrepo_mock.findOne(anyInt())).thenReturn(null);
		
		try {
			Integer returnedValue = userService.increaseUserReputation(1);
			assertTrue(returnedValue == -1);
		}
		catch(Exception e) {
			fail("exception");
		}
		
		
	}
	@Test
	public void testdecreaseUserReputation() {
		//test1
				try {
					userService.decreaseUserReputation(-1);
					fail("exception");
				}
				catch(Exception e) {
					assertTrue(true);
				}
				
				//test2
				when(userrepo_mock.findOne(anyInt())).thenReturn(user_mock);
				try {
					Integer returnedValue = userService.decreaseUserReputation(1);
					Integer exceptedValue = user_mock.getReputation() - 1;
					assertTrue(returnedValue == exceptedValue);
				}
				catch(Exception e) {
					fail("exception");
				}
				//test3 actual reputation equal to -5
				when(userrepo_mock.findOne(anyInt())).thenReturn(user_mock);
				when(userrepo_mock.getReputation(anyInt())).thenReturn(-5);
				try {
					Integer returnedValue = userService.decreaseUserReputation(1);
					Integer exceptedValue = -5;
					assertTrue(returnedValue == exceptedValue);
				}
				catch(Exception e) {
					fail("exception");
				}
				
				//test4
				when(userrepo_mock.findOne(anyInt())).thenReturn(null);
				
				try {
					Integer returnedValue = userService.decreaseUserReputation(1);
					assertTrue(returnedValue == -1);
				}
				catch(Exception e) {
					fail("exception");
				}
	}
}
