package it.polito.ezgas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.PriceReportDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.User;

public class GasStationDtoTests {

	GasStationDto g;
	
	@Before
    public void initTest(){
		g = new GasStationDto(1, "IP", "Corso Tortona, 61/A, 10153 Torino TO", 
				true, true, true, true, true, true, "carsharing", 
				1.0, 1.0,
				1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1, "1589662307", 1.0);
    }
	
	@Test
	public void testReportDependability() {
		try {
			
			double testValue = 2.0;
			g.setReportDependability(testValue);
			double actualValue = g.getReportDependability();
			assertEquals(testValue, actualValue, 0);
		
	   }catch(Exception e){
	       fail("Unexpected Exception");
	   }
	}
	
	@Test
	public void testGasStationId() {
		try {
			
			int testValue = 2;
			g.setGasStationId(testValue);
			int actualValue = g.getGasStationId();
			assertEquals(testValue, actualValue, 0);
			
	   }catch(Exception e){
	       fail("Unexpected Exception");
	   }
	}
	
	@Test
	public void testGasStationName() {		
		try {

			String testValue = "Q8";
			g.setGasStationName(testValue);
			String actualValue = g.getGasStationName();
			assertEquals(testValue, actualValue);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testGasStationAddress() {		
		try {

			String testValue = "Via Sandro Botticelli, 62, 10154 Torino TO";
			g.setGasStationAddress(testValue);
			String actualValue = g.getGasStationAddress();
			assertEquals(testValue, actualValue);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testHasDiesel() {		
		try {

			boolean testValue = false;
			g.setHasDiesel(testValue);
			boolean actualValue = g.getHasDiesel();
			assertEquals(testValue, actualValue);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testHasSuper() {		
		try {

			boolean testValue = false;
			g.setHasSuper(testValue);
			boolean actualValue = g.getHasSuper();
			assertEquals(testValue, actualValue);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testHasSuperPlus() {		
		try {

			boolean testValue = false;
			g.setHasSuperPlus(testValue);
			boolean actualValue = g.getHasSuperPlus();
			assertEquals(testValue, actualValue);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testHasGas() {		
		try {

			boolean testValue = false;
			g.setHasGas(testValue);
			boolean actualValue = g.getHasGas();
			assertEquals(testValue, actualValue);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testLat() {		
		try {

			double testValue = 2.0;
			g.setLat(testValue);
			double actualValue = g.getLat();
			assertEquals(testValue, actualValue, 0);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testLon() {		
		try {

			double testValue = 2.0;
			g.setLon(testValue);
			double actualValue = g.getLon();
			assertEquals(testValue, actualValue, 0);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testDieselPrice() {		
		try {

			double testValue = 2.0;
			g.setDieselPrice(testValue);
			double actualValue = g.getDieselPrice();
			assertEquals(testValue, actualValue, 0);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testSuperPrice() {		
		try {

			double testValue = 2.0;
			g.setSuperPrice(testValue);
			double actualValue = g.getSuperPrice();
			assertEquals(testValue, actualValue, 0);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testSuperPlusPrice() {		
		try {

			double testValue = 2.0;
			g.setSuperPlusPrice(testValue);
			double actualValue = g.getSuperPlusPrice();
			assertEquals(testValue, actualValue, 0);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testGasPrice() {		
		try {

			double testValue = 2.0;
			g.setGasPrice(testValue);
			double actualValue = g.getGasPrice();
			assertEquals(testValue, actualValue, 0);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	

	
	@Test
	public void testReportUser() {		
		try {

			Integer testValue = 2;
			g.setReportUser(testValue);
			Integer actualValue = g.getReportUser();
			assertEquals(testValue, actualValue, 0);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testReportTimestamp() {		
		try {

			String testValue = "1589711737";
			g.setReportTimestamp(testValue);
			String actualValue = g.getReportTimestamp();
			assertEquals(testValue, actualValue);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testUserDto() {		
		try {

			UserDto testValue = new UserDto();
			g.setUserDto(testValue);
			UserDto actualValue = g.getUserDto();
			assertEquals(testValue, actualValue);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testHasMethane() {		
		try {

			boolean testValue = false;
			g.setHasMethane(testValue);
			boolean actualValue = g.getHasMethane();
			assertEquals(testValue, actualValue);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testMethanePrice() {		
		try {

			double testValue = 2.0;
			g.setMethanePrice(testValue);
			double actualValue = g.getMethanePrice();
			assertEquals(testValue, actualValue, 0);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
	
	@Test
	public void testCarSharing() {		
		try {

			String testValue = "Car";
			g.setCarSharing(testValue);
			String actualValue = g.getCarSharing();
			assertEquals(testValue, actualValue);
            
       }catch(Exception e){
           fail("Unexpected Exception");
       }
	}
}
