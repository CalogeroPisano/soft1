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
import exception.InvalidCarSharingException;
import exception.InvalidGasStationException;
import exception.InvalidGasTypeException;
import exception.InvalidUserException;
import exception.PriceException;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.impl.GasStationServiceimpl;
import it.polito.ezgas.service.impl.UserServiceimpl;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class GasStationServiceimplTest {

	GasStationServiceimpl gasstationservice;

	@Mock
	GasStationRepository gasstationrepo_mock;
	@Mock
	UserRepository userrepo_mock;
	
	@Mock
	GasStationDto gasstationdto_mock;
	@Mock
	GasStation gasstation_mock;
	
	@Before
	public void setUp() {
		
		gasstationdto_mock = mock(GasStationDto.class);
		when(gasstationdto_mock.getGasStationId()).thenReturn(1);
		when(gasstationdto_mock.getCarSharing()).thenReturn("share");
		when(gasstationdto_mock.getDieselPrice()).thenReturn(1.2);
		when(gasstationdto_mock.getGasPrice()).thenReturn(1.2);
		when(gasstationdto_mock.getGasStationAddress()).thenReturn("address");
		when(gasstationdto_mock.getGasStationName()).thenReturn("gasstation name");
		when(gasstationdto_mock.getHasDiesel()).thenReturn(true);
		when(gasstationdto_mock.getHasGas()).thenReturn(true);
		when(gasstationdto_mock.getHasMethane()).thenReturn(true);
		when(gasstationdto_mock.getHasSuper()).thenReturn(true);
		when(gasstationdto_mock.getHasSuperPlus()).thenReturn(true);
		when(gasstationdto_mock.getHasPremiumDiesel()).thenReturn(true);
		when(gasstationdto_mock.getLat()).thenReturn(1.2);
		when(gasstationdto_mock.getLon()).thenReturn(1.2);
		when(gasstationdto_mock.getMethanePrice()).thenReturn(1.2);
		when(gasstationdto_mock.getReportDependability()).thenReturn(1.2);
		when(gasstationdto_mock.getReportTimestamp()).thenReturn("123");
		when(gasstationdto_mock.getReportUser()).thenReturn(1);
		when(gasstationdto_mock.getSuperPlusPrice()).thenReturn(1.2);
		when(gasstationdto_mock.getSuperPrice()).thenReturn(1.2);
		when(gasstationdto_mock.getPremiumDieselPrice()).thenReturn(1.2);
		when(gasstationdto_mock.getUserDto()).thenReturn(new UserDto());
		
		
		gasstation_mock = mock(GasStation.class);
		when(gasstation_mock.getGasStationId()).thenReturn(1);
		when(gasstation_mock.getCarSharing()).thenReturn("share");
		when(gasstation_mock.getDieselPrice()).thenReturn(1.2);
		when(gasstation_mock.getGasPrice()).thenReturn(1.2);
		when(gasstation_mock.getGasStationAddress()).thenReturn("address");
		when(gasstation_mock.getGasStationName()).thenReturn("gasstation name");
		when(gasstation_mock.getHasDiesel()).thenReturn(true);
		when(gasstation_mock.getHasGas()).thenReturn(true);
		when(gasstation_mock.getHasMethane()).thenReturn(true);
		when(gasstation_mock.getHasSuper()).thenReturn(true);
		when(gasstation_mock.getHasSuperPlus()).thenReturn(true);
		when(gasstation_mock.getHasPremiumDiesel()).thenReturn(true);
		when(gasstation_mock.getLat()).thenReturn(1.2);
		when(gasstation_mock.getLon()).thenReturn(1.2);
		when(gasstation_mock.getMethanePrice()).thenReturn(1.2);
		when(gasstation_mock.getReportDependability()).thenReturn(1.2);
		when(gasstation_mock.getReportTimestamp()).thenReturn("123");
		when(gasstation_mock.getReportUser()).thenReturn(1);
		when(gasstation_mock.getSuperPlusPrice()).thenReturn(1.2);
		when(gasstation_mock.getSuperPrice()).thenReturn(1.2);
	
		when(gasstation_mock.getPremiumDieselPrice()).thenReturn(1.2);
		when(gasstation_mock.getUser()).thenReturn(new User());
	
	
		gasstationrepo_mock = mock(GasStationRepository.class);
		when(gasstationrepo_mock.save(any(GasStation.class))).thenReturn(gasstation_mock);
		
		userrepo_mock = mock(UserRepository.class);
	
		gasstationservice = new GasStationServiceimpl(gasstationrepo_mock, userrepo_mock);	
	}
	
	
	@Test
	public void testGasStationFromDto()
	{
		GasStation gs = GasStationServiceimpl.GasStationFromDto(gasstationdto_mock, false);
		
		assertTrue(gs.getGasStationId() == gasstationdto_mock.getGasStationId());
		assertTrue(gs.getCarSharing() == gasstationdto_mock.getCarSharing());
		assertTrue(gs.getDieselPrice() == gasstationdto_mock.getDieselPrice());
		assertTrue(gs.getGasPrice() == gasstationdto_mock.getGasPrice());
		assertTrue(gs.getPremiumDieselPrice() == gasstationdto_mock.getPremiumDieselPrice());
		assertTrue(gs.getGasStationAddress() == gasstationdto_mock.getGasStationAddress());
		assertTrue(gs.getGasStationName() == gasstationdto_mock.getGasStationName());
		assertTrue(gs.getHasDiesel() == gasstationdto_mock.getHasDiesel());
		assertTrue(gs.getHasGas() == gasstationdto_mock.getHasGas());
		assertTrue(gs.getHasMethane() == gasstationdto_mock.getHasMethane());
		assertTrue(gs.getHasSuper() == gasstationdto_mock.getHasSuper());
		assertTrue(gs.getHasSuperPlus() == gasstationdto_mock.getHasSuperPlus());
		assertTrue(gs.getHasPremiumDiesel() == gasstationdto_mock.getHasPremiumDiesel());
		assertTrue(gs.getLat() == gasstationdto_mock.getLat());
		assertTrue(gs.getLon() == gasstationdto_mock.getLon());
		assertTrue(gs.getMethanePrice() == gasstationdto_mock.getMethanePrice());
		assertTrue(gs.getReportDependability() == gasstationdto_mock.getReportDependability());
		assertTrue(gs.getReportTimestamp() == gasstationdto_mock.getReportTimestamp());
		assertTrue(gs.getReportUser() == gasstationdto_mock.getReportUser());
		assertTrue(gs.getSuperPlusPrice() == gasstationdto_mock.getSuperPlusPrice());
		assertTrue(gs.getSuperPrice() == gasstationdto_mock.getSuperPrice());
		assertTrue(gs.getUser().getUserId() == gasstationdto_mock.getUserDto().getUserId());
	}
	
	@Test
	public void testGasStationToDto()
	{
		GasStationDto gs = GasStationServiceimpl.GasStationToDto(gasstation_mock);
		
		assertTrue(gs.getGasStationId() == gasstation_mock.getGasStationId());
		assertTrue(gs.getCarSharing() == gasstation_mock.getCarSharing());
		assertTrue(gs.getDieselPrice() == gasstation_mock.getDieselPrice());
		assertTrue(gs.getGasPrice() == gasstation_mock.getGasPrice());
		assertTrue(gs.getGasStationAddress() == gasstation_mock.getGasStationAddress());
		assertTrue(gs.getGasStationName() == gasstation_mock.getGasStationName());
		assertTrue(gs.getHasDiesel() == gasstation_mock.getHasDiesel());
		assertTrue(gs.getHasGas() == gasstation_mock.getHasGas());
		assertTrue(gs.getHasMethane() == gasstation_mock.getHasMethane());
		assertTrue(gs.getHasSuper() == gasstation_mock.getHasSuper());
		assertTrue(gs.getHasSuperPlus() == gasstation_mock.getHasSuperPlus());
		assertTrue(gs.getLat() == gasstation_mock.getLat());
		assertTrue(gs.getLon() == gasstation_mock.getLon());
		assertTrue(gs.getMethanePrice() == gasstation_mock.getMethanePrice());
		assertTrue(gs.getReportDependability() == gasstation_mock.getReportDependability());
		assertTrue(gs.getReportTimestamp() == gasstation_mock.getReportTimestamp());
		assertTrue(gs.getReportUser() == gasstation_mock.getReportUser());
		assertTrue(gs.getSuperPlusPrice() == gasstation_mock.getSuperPlusPrice());
		assertTrue(gs.getSuperPrice() == gasstation_mock.getSuperPrice());
		assertTrue(gs.getUserDto().getUserId() == gasstation_mock.getUser().getUserId());
		
		assertTrue(gs.getPremiumDieselPrice() == gasstation_mock.getPremiumDieselPrice());
		assertTrue(gs.getHasPremiumDiesel() == gasstation_mock.getHasPremiumDiesel());
	}
	
	@Test
	public void testdistance()
	{
		double returnedValue = GasStationServiceimpl.distance(1.0, 1.0, 1.0, 1.0);
		double expectedValue = 0;
		assertTrue(returnedValue == expectedValue);
		
		returnedValue = GasStationServiceimpl.distance(1.0, 1.0, 2.0, 2.0);
		expectedValue = 157.22567882102143;
		assertTrue(returnedValue == expectedValue);
	}
	
	@Test
	public void testgetGasStationById()
	{
		//test1
		when(gasstationrepo_mock.findOne(anyInt())).thenReturn(null);
		try {
			GasStationDto returnedValue = gasstationservice.getGasStationById(1);
			
			GasStationDto expectedValue = null;
			assertTrue(returnedValue == expectedValue);
		}
		catch(Exception e) {
			fail("unexpected exception");
		}
		
		//test2
		when(gasstationrepo_mock.findOne(anyInt())).thenReturn(gasstation_mock);
		try {
			GasStationDto returnedValue = gasstationservice.getGasStationById(1);
			GasStationDto expectedValue = gasstationdto_mock;
			assertTrue(expectedValue.getGasStationId() == returnedValue.getGasStationId());
		}
		catch(Exception e) {
			fail("unexpected exception");
		}
		
		//test3
		try {	
			gasstationservice.getGasStationById(-1);
			fail("expected exception");
		}
		catch(Exception e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void testsaveGasStation()
	{
		//test1
		try {
			gasstationservice.saveGasStation(null);
			fail("expected exception");
		}
		catch(Exception e) {
			assertTrue(true);
		}
		
		//test2
		when(gasstationdto_mock.getDieselPrice()).thenReturn(-1.2);
		try {
			gasstationservice.saveGasStation(gasstationdto_mock);			
			fail("expected exception");
		}
		catch(PriceException e) {
			assertTrue(true);
		} catch (GPSDataException e) {
			fail("expected PriceException");
		}
		
		//test3
		when(gasstationdto_mock.getDieselPrice()).thenReturn(1.2);
		when(gasstationdto_mock.getLat()).thenReturn(91.0);
		try {
			gasstationservice.saveGasStation(gasstationdto_mock);			
			fail("expected exception");
		}
		catch(PriceException e) {
			fail("expected GPSDataException");
		} catch (GPSDataException e) {
			assertTrue(true);
		}
		
		
		//test4
		when(gasstationdto_mock.getLat()).thenReturn(1.0);
		when(gasstationrepo_mock.updateGasStation(anyInt(), anyString(), anyString(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(),anyBoolean(), anyString(), anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyDouble(),anyDouble(), anyInt(), anyString(), anyDouble())).thenReturn(1);
		try {
			GasStationDto returnedValue = gasstationservice.saveGasStation(gasstationdto_mock);			
			GasStationDto expectedValue = gasstationdto_mock;
			assertTrue(expectedValue.getGasStationId() == returnedValue.getGasStationId());
		}
		catch(Exception e) {
			fail("unexpected exception");
		}	
	}

	@Test
	public void testgetAllGasStations()
	{
		//test1
		when(gasstationrepo_mock.findAll()).thenReturn(new ArrayList<GasStation>());
		List<GasStationDto> returnedValue = gasstationservice.getAllGasStations();
		assertTrue(returnedValue.size() == 0);
		
		//test2
		when(gasstationrepo_mock.findAll()).thenReturn(new ArrayList<GasStation>(){{add(gasstation_mock);}});
		returnedValue = gasstationservice.getAllGasStations();
		assertTrue(gasstation_mock.getGasStationId() == returnedValue.get(0).getGasStationId());
	}
	
	@Test
	public void testdeleteGasStation()
	{
		//test1
		when(gasstationrepo_mock.findOne(anyInt())).thenReturn(null);
		try {
			Boolean returnedValue = gasstationservice.deleteGasStation(1);
			assertTrue(returnedValue);
		} catch(Exception e)
		{
			fail("unexpected exception");
		}
		
		//test2
		try {
			gasstationservice.deleteGasStation(-1);
			fail("expected exception");
		} catch(Exception e)
		{
			assertTrue(true);
		}
	}

	@Test
	public void testgetGasStationsByGasolineType()
	{
		//test1
		try {
			gasstationservice.getGasStationsByGasolineType("gas1");
			fail("expected exception");
		} catch(Exception e)
		{
			assertTrue(true);
		}
		
		//test2
		when(gasstationrepo_mock.findAll()).thenReturn(new ArrayList<GasStation>());
		try {
			List<GasStationDto> returnedValue = gasstationservice.getGasStationsByGasolineType("gas");
			assertTrue(returnedValue.size() == 0);
		} catch(Exception e)
		{
			fail("unexpected exception");
		}
		
		//test3
		when(gasstationrepo_mock.findAll()).thenReturn(new ArrayList<GasStation>(){{add(gasstation_mock);}});
		try {
			List<GasStationDto> returnedValue = gasstationservice.getGasStationsByGasolineType("gas");
			assertTrue(gasstation_mock.getGasStationId() == returnedValue.get(0).getGasStationId());
		} catch(Exception e)
		{
			fail("unexpected exception");
		}
	}
	
	@Test
	public void testgetGasStationsByProximity()
	{
		//test1
		try {
			gasstationservice.getGasStationsByProximity(91, 1.0);
			fail("expected exception");
		} catch(Exception e)
		{
			assertTrue(true);
		}
		
		//test2
		when(gasstationrepo_mock.findAll()).thenReturn(new ArrayList<GasStation>());
		try {
			List<GasStationDto> returnedValue = gasstationservice.getGasStationsByProximity(1.0, 1.0);
			assertTrue(returnedValue.size() == 0);
		} catch(Exception e)
		{
			fail("unexpected exception");
		}
		
		//test3
		when(gasstationrepo_mock.findAll()).thenReturn(new ArrayList<GasStation>(){{add(gasstation_mock);}});
		try {
			List<GasStationDto> returnedValue = gasstationservice.getGasStationsByProximity(1.2, 1.2);
			assertTrue(returnedValue.size() == 1);
		} catch(Exception e)
		{
			fail("unexpected exception");
		}
	}
	
	@Test
	public void testgetGasStationsWithCoordinates()
	{
		//test1
		try {
			gasstationservice.getGasStationsWithCoordinates(1.0, 1.0, 1, "gas1", "share");
			fail("expected exception");
		} catch(InvalidGasTypeException e)
		{
			assertTrue(true);
		}
		catch(GPSDataException e)
		{
			fail("expected InvalidGasTypeException");
		}
		catch(InvalidCarSharingException e) {
			
		}
		
		//test2
		when(gasstationrepo_mock.findAll()).thenReturn(new ArrayList<GasStation>());
		try {
			List<GasStationDto> returnedValue = gasstationservice.getGasStationsWithCoordinates(91.0, 1.0, 1, "gas", "share");
			fail("expected exception");
		} catch(InvalidGasTypeException e)
		{
			fail("expected InvalidGasTypeException");
		}
		catch(GPSDataException e)
		{
			assertTrue(true);
		}
		catch(InvalidCarSharingException e) {
			
		}
		
		//test3
		when(gasstationrepo_mock.findAll()).thenReturn(new ArrayList<GasStation>(){{add(gasstation_mock);}});
		try {
			List<GasStationDto> returnedValue = gasstationservice.getGasStationsWithCoordinates(1.2, 1.2, 1, "gas", "share");
			assertTrue(returnedValue.size() == 1);
		} catch(InvalidGasTypeException e)
		{
			fail("unexpected exception");
		}
		catch(GPSDataException e)
		{
			fail("unexpected exception");
		}
		catch(InvalidCarSharingException e) {
			
		}
	}
	
	@Test
	public void testgetGasStationsWithoutCoordinates()
	{
		//test1
		try {
			gasstationservice.getGasStationsWithoutCoordinates("gas1", "share");
			fail("expected exception");
		} catch(InvalidGasTypeException e)
		{
			assertTrue(true);
		}
		
		//test2
		when(gasstationrepo_mock.findAll()).thenReturn(new ArrayList<GasStation>());
		try {
			List<GasStationDto> returnedValue = gasstationservice.getGasStationsWithoutCoordinates("gas", "share");
			assertTrue(returnedValue.size() == 0);
		} catch(InvalidGasTypeException e)
		{
			fail("unexpected exception");
		}
		
		//test3
		when(gasstationrepo_mock.findAll()).thenReturn(new ArrayList<GasStation>(){{add(gasstation_mock);}});
		try {
			List<GasStationDto> returnedValue = gasstationservice.getGasStationsWithoutCoordinates("gas", "share");
			assertTrue(returnedValue.size() == 1);
		} catch(InvalidGasTypeException e)
		{
			fail("unexpected exception");
		}
	}
	
	
	@Test
	public void testsetReport()
	{
		//test1
		try {
			gasstationservice.setReport(1, 1.2, 1.2, 1.2, 1.2, 1.2, 1.2, -1);
			fail("expected exception");
		} catch(InvalidUserException e)
		{
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail("expected InvalidUserException");
		}
		
		
		//test2
		try {
			gasstationservice.setReport(-1, 1.2, 1.2, 1.2, 1.2, 1.2, 1.2, 1);
			fail("expected exception");
		} catch(InvalidGasStationException e)
		{
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail("expected InvalidGasStationException");
		}
		
		
		//test3
		try {
			gasstationservice.setReport(1, -1.2, 1.2, 1.2, 1.2, 1.2, 1.2, 1);
			fail("expected exception");
		} catch(PriceException e)
		{
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail("expected PriceException");
		}
		
		
	}
	
	@Test
	public void testgetGasStationByCarSharing()
	{
		//test1
		when(gasstationrepo_mock.findAll()).thenReturn(new ArrayList<GasStation>());
		List<GasStationDto> returnedValue = gasstationservice.getGasStationByCarSharing("share");
		assertTrue(returnedValue.size() == 0);
		
		//test2
		when(gasstationrepo_mock.findAll()).thenReturn(new ArrayList<GasStation>(){{add(gasstation_mock);}});
		returnedValue = gasstationservice.getGasStationByCarSharing("share");
		assertTrue(returnedValue.size() == 1);
	}
}
