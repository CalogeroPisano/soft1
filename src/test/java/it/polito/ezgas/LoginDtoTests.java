package it.polito.ezgas;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.polito.ezgas.dto.LoginDto;



@RunWith(SpringRunner.class)
public class LoginDtoTests {
private LoginDto log=new LoginDto(1,"pippo","password","pippo@ezgas.com",0);

@Test 
public void test_LoginDtoUserID1() {
	log.setUserId(8888);
	assert(log.getUserId()==8888);
}
@Test
public void test_LoginDtoUserID2() {
	log.setUserId(Integer.MAX_VALUE+1);
	assert(log.getUserId()==Integer.MIN_VALUE);
}

@Test
public void test_LoginDtoUserID() {
	log.setUserId(Integer.MIN_VALUE-1);
	assert(log.getUserId()==Integer.MAX_VALUE);
}
@Test
public void test_LoginDtoUserName() {
	log.setUserName("pluto");
	assert(log.getUserName().equals("pluto"));
}
@Test
public void test_LoginDtoToken() {
	log.setToken("0001");
	assert(log.getToken().equals("0001"));
}
@Test
public void test_LoginDtoUserEmail() {
	log.setEmail("pippo.pluto@ezgas.it");
	assert(log.getEmail().equals("pippo.pluto@ezgas.it"));
}
@Test 
public void test_LoginDtoUserReputation1() {
	log.setReputation(100);
	assert(log.getReputation()==100);
}
@Test
public void test_LoginDtoUserReputation2() {
	log.setReputation(Integer.MAX_VALUE+1);
	assert(log.getReputation()==Integer.MIN_VALUE);
}

@Test
public void test_LoginDtoUserReputation3() {
	log.setReputation(Integer.MIN_VALUE-1);
	assert(log.getReputation()==Integer.MAX_VALUE);
}
@Test
public void test_LoginDtoUserAdmin() {
	log.setAdmin(true);
	assert(log.getAdmin()==true);
}


}
