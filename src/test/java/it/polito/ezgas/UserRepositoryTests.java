package it.polito.ezgas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
	
	@Autowired
	private  UserRepository userrepo;
	User dummy;
	

	@Before
	public void setupUser() {
		dummy = new User();
		dummy.setUserName("TestUser");
		dummy.setEmail("userepotest@gmail.com");
		dummy.setAdmin(false);
		dummy.setPassword("password");
		dummy.setReputation(4);
	}
	
	@Test
	public void test_verifyCredentials() {
		userrepo.save(dummy);
		Integer res= userrepo.verifyCredentials("userepotest@gmail.com","password");
		User u=userrepo.findOne(dummy.getUserId());
		assert(u!=null);
		assert(u.getUserId()==dummy.getUserId()&& u.getUserId()==res);
		userrepo.delete(u.getUserId());
	}
	
	@Test
	public void test_verifyEmail() {
		userrepo.save(dummy);
		Integer res= userrepo.verifyEmail("userepotest@gmail.com");
		assert(res==1);
		userrepo.delete(dummy.getUserId());
	}
	
	@Test
	public void test_getReputation() {
		userrepo.save(dummy);
		Integer res= userrepo.getReputation(dummy.getUserId());
		assert(res==dummy.getReputation());
		userrepo.delete(dummy.getUserId());
	}
	
	@Test
	public void test_changeReputation() {
		userrepo.save(dummy);
		Integer res= userrepo.changeReputation(dummy.getUserId(),dummy.getReputation()+1);
		User u=userrepo.findOne(dummy.getUserId());
		assert(u!=null);
		assert(res==1);
		assert(u.getReputation()==dummy.getReputation()+1);
		userrepo.delete(dummy.getUserId());
	}
	
	@Test
	public void test_updateUsr() {
		userrepo.save(dummy);
		Integer res= userrepo.updateUsr(dummy.getUserId(),"testupdate","testupdate@gmail.com","newpassword");
		User u=userrepo.findOne(dummy.getUserId());
		assert(u!=null);
		assert(res==1);
		assert(u.getUserId()==dummy.getUserId());
		assert(u.getUserName()=="testupdate");
		assert(u.getEmail()=="testupdate@gmail.com");
		assert(u.getPassword()=="newpassword");
		userrepo.delete(dummy.getUserId());
	}
	
	
	
}
