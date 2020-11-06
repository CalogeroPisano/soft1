package it.polito.ezgas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.junit4.SpringRunner;

import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.impl.UserServiceimpl;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GasStationRepositoryTest {
	
	@Autowired
	private  GasStationRepository gasrepo;
	@Autowired
	private  UserRepository userrepo;
	GasStation dummy;
	User u;
	

	@Before
	public void setupUser() {
		dummy = new GasStation();
		dummy.setCarSharing("testToGo");
		dummy.setDieselPrice(1.0);
		dummy.setGasPrice(1.1);
		dummy.setGasStationAddress("Corso duca degli abruzzi 24");
		dummy.setGasStationName("PolitoGas");
		dummy.setHasDiesel(true);
		dummy.setHasGas(true);
		dummy.setHasMethane(true);
		dummy.setHasSuper(true);
		dummy.setHasSuperPlus(true);
		dummy.setHasPremiumDiesel(true);
		dummy.setLat(45.063104);
		dummy.setLon(7.662192);
		dummy.setMethanePrice(1.4);
		dummy.setReportDependability(0);
		dummy.setReportTimestamp("23-05-2020 19:32");
		dummy.setReportUser(-1);
		dummy.setSuperPlusPrice(1.6);
		dummy.setSuperPrice(1.7);
		dummy.setPremiumDieselPrice(1.8);
		dummy.setUser(null);
		
		u = new User();
		u.setUserName("TestUser");
		u.setEmail("userepotest@gmail.com");
		u.setAdmin(false);
		u.setPassword("password");
		u.setReputation(4);

	}
	
	@Test
	public void test_updateGasStation() {
		gasrepo.save(dummy);
		userrepo.save(u);
		Integer ret=gasrepo.updateGasStation(dummy.getGasStationId(),
				"PolitoGas2",
				"Corso Castelfidardo",
				true,true,true,true,false,true,
				"testEnjoy",
				45.005,
				7.44,
				0.5,0.5,0.5,0.5,0.5,0.5,
				u.getUserId(),
				"23-05-2020 21:43",
				5.5);
		GasStation g=gasrepo.findOne(dummy.getGasStationId());
		assert(g!=null);
		assert(ret==1);
		assert(g.getGasStationName()=="PolitoGas2");
		assert(g.getGasStationAddress()=="Corso Castelfidardo");
		
		assert(g.getCarSharing()=="testEnjoy");
		assert(g.getReportTimestamp()=="23-05-2020 21:43");
		assert(g.getLat()==45.005);
		assert(g.getLon()==7.44);
		assert(g.getReportDependability()==5.5);
		
		
		assert(g.getHasDiesel()==true);
		assert(g.getHasGas()==true);
		assert(g.getHasMethane()==false);
		assert(g.getHasSuper()==true);
		assert(g.getHasSuperPlus()==true);
		assert(g.getHasSuperPlus()==true);
		assert(g.getHasPremiumDiesel()==true);
		
		
		
		assert(g.getDieselPrice()==0.5);
		assert(g.getSuperPlusPrice()==0.5);
		assert(g.getSuperPrice()==0.5);
		assert(g.getMethanePrice()==0.5);
		assert(g.getGasPrice()==0.5);
		assert(g.getPremiumDieselPrice()==0.5);
		
		gasrepo.delete(dummy.getGasStationId());
		userrepo.delete(u.getUserId());
	}
	
	@Test
	public void test_verifyLatLon() {
		gasrepo.save(dummy);
		Integer ret= gasrepo.verifyLatLon(45.063104,7.662192);
		
		GasStation g=gasrepo.findOne(dummy.getGasStationId());
		
		assert(ret==1);
		assert(g.getLat()==45.063104);
		assert(g.getLon()==7.662192);
		
		gasrepo.delete(dummy.getGasStationId());
		
	}
	
	@Test
	public void test_setGasPrice() {
		gasrepo.save(dummy);
		Integer ret= gasrepo.setGasPrice(dummy.getGasStationId(),0.5);
		
		GasStation g=gasrepo.findOne(dummy.getGasStationId());
		
		assert(ret==1);
		assert(g.getHasGas()==true);
		assert(g.getGasPrice()==0.5);
		
		gasrepo.delete(dummy.getGasStationId());
	}
	

	@Test
	public void test_setDieselPrice() {
		gasrepo.save(dummy);
		Integer ret= gasrepo.setDieselPrice(dummy.getGasStationId(),0.5);
		
		GasStation g=gasrepo.findOne(dummy.getGasStationId());
		
		assert(ret==1);
		assert(g.getHasDiesel()==true);
		assert(g.getDieselPrice()==0.5);
		
		gasrepo.delete(dummy.getGasStationId());
	}
	
	@Test
	public void test_setMethanePrice() {
		gasrepo.save(dummy);
		Integer ret= gasrepo.setMethanePrice(dummy.getGasStationId(),0.5);
		
		GasStation g=gasrepo.findOne(dummy.getGasStationId());
		
		assert(ret==1);
		assert(g.getHasMethane()==true);
		assert(g.getMethanePrice()==0.5);
		
		gasrepo.delete(dummy.getGasStationId());
	}
	
	@Test
	public void test_setSuperPrice() {
		gasrepo.save(dummy);
		Integer ret= gasrepo.setSuperPrice(dummy.getGasStationId(),0.5);
		
		GasStation g=gasrepo.findOne(dummy.getGasStationId());
		
		assert(ret==1);
		assert(g.getHasSuper()==true);
		assert(g.getSuperPrice()==0.5);
		
		gasrepo.delete(dummy.getGasStationId());
	}
	
	@Test
	public void test_setSuperPlusPrice() {
		gasrepo.save(dummy);
		Integer ret= gasrepo.setSuperPlusPrice(dummy.getGasStationId(),0.5);
		
		GasStation g=gasrepo.findOne(dummy.getGasStationId());
		
		assert(ret==1);
		assert(g.getHasSuperPlus()==true);
		assert(g.getSuperPlusPrice()==0.5);
		
		gasrepo.delete(dummy.getGasStationId());
	}
	
	@Test
	public void test_setPremiumDieselPrice() {
		gasrepo.save(dummy);
		Integer ret= gasrepo.setSuperPremiumDieselPrice(dummy.getGasStationId(),0.5);
		
		GasStation g=gasrepo.findOne(dummy.getGasStationId());
		
		assert(ret==1);
		assert(g.getHasPremiumDiesel()==true);
		assert(g.getPremiumDieselPrice()==0.5);
		
		gasrepo.delete(dummy.getGasStationId());
	}
	
	@Test
	public void test_setUserId() {
		gasrepo.save(dummy);
		userrepo.save(u);
		Integer ret= gasrepo.setUserId(u.getUserId(),dummy.getGasStationId());
		
		GasStation g=gasrepo.findOne(dummy.getGasStationId());
		
		assert(ret==1);
		assert(g.getReportUser()==u.getUserId());
		
		gasrepo.delete(dummy.getGasStationId());
		userrepo.delete(u.getUserId());
	}
	
	@Test
	public void test_Timestamp() {
		DateFormat formatter = new SimpleDateFormat("MM-dd-YYYY");
		gasrepo.save(dummy);
		Integer ret= gasrepo.setTimestamp(formatter.format(new Date(System.currentTimeMillis())),dummy.getGasStationId());
		
		GasStation g=gasrepo.findOne(dummy.getGasStationId());
		
		assert(ret==1);
		assert (formatter.format(new Date(System.currentTimeMillis())).contentEquals(g.getReportTimestamp()));
		
		gasrepo.delete(dummy.getGasStationId());
	}
	
	
	
	
	
}
