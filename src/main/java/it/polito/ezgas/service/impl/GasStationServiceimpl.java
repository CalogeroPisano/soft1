package it.polito.ezgas.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

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
import it.polito.ezgas.service.GasStationService;

/**
 * Created by softeng on 27/4/2020.
 */
@Service
public class GasStationServiceimpl implements GasStationService {
	
	//@Autowired
	private  GasStationRepository gasstationrepo;
	//@Autowired
	private  UserRepository userrepo;
	
	public GasStationServiceimpl(GasStationRepository gasstationrepo, UserRepository userrepo)
	{
		this.gasstationrepo = gasstationrepo;
		this.userrepo = userrepo; 
	}

	public static GasStation GasStationFromDto(GasStationDto dto,Boolean newGasStation) {
		GasStation g=new GasStation();
		//if the gasStation is new i want to automatically generate the ID
		if(!newGasStation)
			g.setGasStationId(dto.getGasStationId());
		g.setCarSharing(dto.getCarSharing());
		g.setDieselPrice(dto.getDieselPrice());
		g.setGasPrice(dto.getGasPrice());
		g.setGasStationAddress(dto.getGasStationAddress());
		g.setGasStationName(dto.getGasStationName());
		g.setHasDiesel(dto.getHasDiesel());
		g.setHasGas(dto.getHasGas());
		g.setHasMethane(dto.getHasMethane());
		g.setHasSuper(dto.getHasSuper());
		g.setHasSuperPlus(dto.getHasSuperPlus());
		g.setHasPremiumDiesel(dto.getHasPremiumDiesel());
		g.setLat(dto.getLat());
		g.setLon(dto.getLon());
		g.setMethanePrice(dto.getMethanePrice());
		g.setReportDependability(dto.getReportDependability());
		g.setReportTimestamp(dto.getReportTimestamp());
		g.setReportUser(dto.getReportUser());
		g.setSuperPlusPrice(dto.getSuperPlusPrice());
		g.setSuperPrice(dto.getSuperPrice());
		g.setPremiumDieselPrice(dto.getPremiumDieselPrice());
		
		if(dto.getUserDto()!=null)
			g.setUser(UserServiceimpl.UserFromDto(dto.getUserDto(), false));
		

		return g;
	}
	
	public static GasStationDto GasStationToDto(GasStation g) {
		GasStationDto dto=new GasStationDto();
		
		dto.setGasStationId(g.getGasStationId());
		dto.setCarSharing(g.getCarSharing());
		dto.setDieselPrice(g.getDieselPrice());
		dto.setGasPrice(g.getGasPrice());
		dto.setGasStationAddress(g.getGasStationAddress());
		dto.setGasStationName(g.getGasStationName());
		dto.setHasDiesel(g.getHasDiesel());
		dto.setHasGas(g.getHasGas());
		dto.setHasMethane(g.getHasMethane());
		dto.setHasSuper(g.getHasSuper());
		dto.setHasSuperPlus(g.getHasSuperPlus());
		dto.setHasPremiumDiesel(g.getHasPremiumDiesel());
		dto.setLat(g.getLat());
		dto.setLon(g.getLon());
		dto.setMethanePrice(g.getMethanePrice());
		dto.setReportDependability(g.getReportDependability());
		dto.setReportTimestamp(g.getReportTimestamp());
		dto.setReportUser(g.getReportUser());
		dto.setSuperPlusPrice(g.getSuperPlusPrice());
		dto.setSuperPrice(g.getSuperPrice());
		dto.setPremiumDieselPrice(g.getPremiumDieselPrice());
		
		if(g.getUser()!=null)
			dto.setUserDto(UserServiceimpl.UserToDto(g.getUser()));

		return dto;
	}
	
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        double earthRadius = 6371.01; //Kilometers
        return earthRadius * Math.acos(Math.sin(lat1)*Math.sin(lat2) + Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon1 - lon2));
    }
	
	@Override
	public GasStationDto getGasStationById(Integer gasStationId) throws InvalidGasStationException {
		if(gasStationId>=0) {
			GasStation g=gasstationrepo.findOne(gasStationId);
			
			
			
			if(g==null)
				return null;
			//
			if(g.getReportUser()!=null && g.getReportUser()>=0) {
				g.setUser(userrepo.findOne(g.getReportUser()));
			}
			//
			return GasStationToDto(g);
		}else
			throw new InvalidGasStationException("Gas Station not Found");
	}

	@Override
	public GasStationDto saveGasStation(GasStationDto gasStationDto) throws PriceException, GPSDataException {
	
		GasStation g =null;
		
		if((gasStationDto.getDieselPrice()!=null && gasStationDto.getHasDiesel() && gasStationDto.getDieselPrice()<0) ||
			(gasStationDto.getMethanePrice()!=null && gasStationDto.getHasMethane() && gasStationDto.getMethanePrice()<0) ||
			(gasStationDto.getGasPrice()!=null && gasStationDto.getHasGas() && gasStationDto.getGasPrice()<0) ||
			(gasStationDto.getSuperPrice()!=null &&gasStationDto.getHasSuper() && gasStationDto.getSuperPrice()<0) ||
			(gasStationDto.getPremiumDieselPrice()!=null &&gasStationDto.getHasPremiumDiesel() && gasStationDto.getPremiumDieselPrice()<0) ||
			(gasStationDto.getSuperPlusPrice()!=null &&gasStationDto.getHasSuperPlus() && gasStationDto.getSuperPlusPrice()<0))
				throw new PriceException("There cannot be a negative price");
			
		if(gasStationDto.getLat()>= -90 && gasStationDto.getLat() <=90 && gasStationDto.getLon()>=-180 && gasStationDto.getLon()<=80) {
			
			
			
			if(gasStationDto.getGasStationId()==null) {
				g=GasStationFromDto(gasStationDto,true);
				gasstationrepo.save(g);
				return GasStationToDto(g);
			}else {
				g=GasStationFromDto(gasStationDto,false);
				System.out.println("-----------------------------------------------"+g.getLat()+" "+g.getLon());
				if(gasstationrepo.updateGasStation(g.getGasStationId(),g.getGasStationName(),g.getGasStationAddress(),g.getHasDiesel(),
						g.getHasSuper(),g.getHasSuperPlus(),g.getHasGas(),g.getHasMethane(),g.getHasPremiumDiesel(),
						g.getCarSharing(),g.getLat(),g.getLon(),g.getDieselPrice(),
						g.getSuperPrice(),g.getSuperPlusPrice(),g.getGasPrice(),g.getMethanePrice(),g.getMethanePrice(),
						g.getReportUser(),g.getReportTimestamp(), g.getReportDependability() )==1)
							return GasStationToDto(g);
				else
					return null;
				
			}
		}else
			throw new GPSDataException("Invalid Coordinates");
		
	}

	
	@Override
	public List<GasStationDto> getAllGasStations() {
		ArrayList<GasStationDto> list=new ArrayList<GasStationDto>();
		for(GasStation g: gasstationrepo.findAll()) {
			list.add(GasStationToDto(g));
		}
		return list;
	}

	@Override
	public Boolean deleteGasStation(Integer gasStationId) throws InvalidGasStationException {
		if(gasStationId>=0) {
			gasstationrepo.delete(gasStationId);
			GasStation g=gasstationrepo.findOne(gasStationId);
			if(g==null)
				return true;
			return false;
		}else
			throw new InvalidGasStationException("Invalid Gas Station id");
	}

	@Override
	public List<GasStationDto> getGasStationsByGasolineType(String gasolinetype) throws InvalidGasTypeException {
		if(!(gasolinetype.toLowerCase().equals("gas") || 
		   gasolinetype.toLowerCase().equals("diesel") || 
		   gasolinetype.toLowerCase().equals("methane") || 
		   gasolinetype.toLowerCase().equals("super") || 
		   gasolinetype.toLowerCase().equals("premiumdiesel") || 
		   gasolinetype.toLowerCase().equals("superplus")))
			throw new InvalidGasTypeException(gasolinetype + " is not a valid fuel type");
		
		
		ArrayList<GasStation> list =new ArrayList<GasStation>();
		ArrayList<GasStationDto> listdto =new ArrayList<GasStationDto>();
		
		for(GasStation g: gasstationrepo.findAll()) {
			if((gasolinetype.toLowerCase().equals("gas") && g.getHasGas()) ||
				(gasolinetype.toLowerCase().equals("diesel") && g.getHasDiesel()) ||
				(gasolinetype.toLowerCase().equals("methane") && g.getHasMethane()) ||
				(gasolinetype.toLowerCase().equals("super") && g.getHasSuper()) ||
				(gasolinetype.toLowerCase().equals("premiumdiesel") && g.getHasSuper()) ||
				(gasolinetype.toLowerCase().equals("superplus") && g.getHasSuperPlus()) )
					list.add(g);
		}
		
		Collections.sort(list, new Comparator<GasStation>() {
			@Override
			public int compare(GasStation first,GasStation second) {
				if(gasolinetype.toLowerCase().equals("gas"))
					return (int) (first.getGasPrice()-second.getGasPrice());
				else if(gasolinetype.toLowerCase().equals("diesel"))
					return (int) (first.getDieselPrice()-second.getDieselPrice());
				else if(gasolinetype.toLowerCase().equals("methane"))
					return (int) (first.getMethanePrice()-second.getMethanePrice());
				else if(gasolinetype.toLowerCase().equals("super"))
					return (int) (first.getSuperPrice()-second.getSuperPrice());
				else if(gasolinetype.toLowerCase().equals("premiumdiesel"))
					return (int) (first.getSuperPrice()-second.getSuperPrice());
				else 
					return (int) (first.getSuperPlusPrice()-second.getSuperPlusPrice());
				
			}
		});
		
		for(GasStation g: list) {
			listdto.add(GasStationToDto(g));
		}
		
		return listdto;
	}


	@Override
	public List<GasStationDto> getGasStationsWithoutCoordinates(String gasolinetype, String carsharing)
			throws InvalidGasTypeException {
		
		
		if(!(gasolinetype.equals("null") ||
			gasolinetype.toLowerCase().equals("gas") || 
		   gasolinetype.toLowerCase().equals("diesel") || 
		   gasolinetype.toLowerCase().equals("methane") || 
		   gasolinetype.toLowerCase().equals("super") || 
		   gasolinetype.toLowerCase().equals("premiumdiesel") || 
		   gasolinetype.toLowerCase().equals("superplus")))
			throw new InvalidGasTypeException(gasolinetype + " is not a valid fuel type");
		
		ArrayList<GasStationDto> listdto =new ArrayList<GasStationDto>();
		boolean add=true;
		
		
		for(GasStationDto dto : getAllGasStations()){
			add=true;
			if(!gasolinetype.equals("null")) {
				if(!((gasolinetype.toLowerCase().equals("gas") && dto.getHasGas()) ||
					(gasolinetype.toLowerCase().equals("diesel") && dto.getHasDiesel()) ||
					(gasolinetype.toLowerCase().equals("premiumdiesel") && dto.getHasDiesel()) ||
					(gasolinetype.toLowerCase().equals("methane") && dto.getHasMethane()) ||
					(gasolinetype.toLowerCase().equals("super") && dto.getHasSuper()) ||
					(gasolinetype.toLowerCase().equals("superplus") && dto.getHasSuperPlus()))) {
						add=false;
						System.out.println("KO1");
				}
					
			}
			if(add==true && !carsharing.equals("null") && dto.getCarSharing()!=null) {
				if(!carsharing.toLowerCase().equals(dto.getCarSharing().toLowerCase())) {
					add=false;
					System.out.println("KO2");
				}
			} if(!carsharing.equals("null") && dto.getCarSharing()==null) {
				add=false;
			}
			if(add==true) {
				listdto.add(dto);
				System.out.println("OK");
			}
		}
		
		return listdto;
	}

	@Override
	public List<GasStationDto> getGasStationByCarSharing(String carSharing) {


		ArrayList<GasStationDto> listdto =new ArrayList<GasStationDto>();
		boolean add=true;
		
			for(GasStationDto dto : getAllGasStations()){
				if(!carSharing.equals("null") && dto.getCarSharing()!=null ) {
					if(carSharing.toLowerCase().equals(dto.getCarSharing()))
						listdto.add(dto);
					
			}else if(carSharing.equals("null") && dto.getCarSharing()==null)
				listdto.add(dto);
			
		}

		return listdto;
	}

	@Override
	public List<GasStationDto> getGasStationsByProximity(double lat, double lon, int radius) throws GPSDataException {
		if(lat>= -90 && lat <=90 && lon>=-180 && lon<=80) {
			
			ArrayList<GasStation> list =new ArrayList<GasStation>();
			ArrayList<GasStationDto> listdto =new ArrayList<GasStationDto>();
			System.out.println("OK!!!!!!!!!!!!!!!!!!!!!!!!!!");
			for(GasStation g: gasstationrepo.findAll()) {
				System.out.println(lat +" "+ lon + " "+g.getLat()+" "+g.getLon());
				if(distance(lat,lon,g.getLat(),g.getLon())<=radius) {
					
					list.add(g);
				}
			}
			
			for(GasStation g: list) {
				listdto.add(GasStationToDto(g));
			}
			
			return listdto;
		}else{
			throw new GPSDataException("Invalid Coordinates");
		}
	}

	@Override
	public List<GasStationDto> getGasStationsWithCoordinates(double lat, double lon, int radius, String gasolinetype,
			String carsharing) throws InvalidGasTypeException, GPSDataException, InvalidCarSharingException {
		if(!(gasolinetype.equals("null") ||
				gasolinetype.toLowerCase().equals("gas") || 
			   gasolinetype.toLowerCase().equals("diesel") || 
			   gasolinetype.toLowerCase().equals("premiumdiesel") || 
			   gasolinetype.toLowerCase().equals("methane") || 
			   gasolinetype.toLowerCase().equals("super") || 
			   gasolinetype.toLowerCase().equals("superplus")))
				throw new InvalidGasTypeException(gasolinetype + " is not a valid fuel type");
			
			ArrayList<GasStationDto> listdto =new ArrayList<GasStationDto>();
			boolean add=true;

			for(GasStationDto dto : getGasStationsByProximity(lat,lon,radius)){
				add=true;

				if(!gasolinetype.equals("null")) {
					if(!((gasolinetype.toLowerCase().equals("gas") ) ||
						(gasolinetype.toLowerCase().equals("diesel") ) ||
						(gasolinetype.toLowerCase().equals("premiumdiesel") ) ||
						(gasolinetype.toLowerCase().equals("methane") ) ||
						(gasolinetype.toLowerCase().equals("super") ) ||
						(gasolinetype.toLowerCase().equals("superplus") ))) {
							add=false;
							throw new InvalidGasTypeException("invalid gas type");
					}
						
				}

				if(add==true && !carsharing.equals("null") && dto.getCarSharing()!=null) {

					if(!carsharing.toLowerCase().equals(dto.getCarSharing().toLowerCase())) {
						add=false;
						System.out.println("KO2");
					}
				} else if(!carsharing.equals("null") && dto.getCarSharing()==null) {
					add=false;
				}else
					throw new InvalidCarSharingException("invalid car sharing");
				if(add==true) {
					listdto.add(dto);
					System.out.println("OK");
				}
			}
			
			return listdto;
	}

	@Override
	public void setReport(Integer gasStationId, Double dieselPrice, Double superPrice, Double superPlusPrice,
			Double gasPrice, Double methanePrice, Double premiumDieselPrice, Integer userId)
			throws InvalidGasStationException, PriceException, InvalidUserException {
		DateFormat formatter = new SimpleDateFormat("MM-dd-YYYY");
		if(userId<0)
			throw new InvalidUserException("invalid user id");
		if(gasStationId<0)
			throw new InvalidGasStationException("invalid gas station id");
		boolean add=false;
		boolean check=false;
		
		
		if(dieselPrice<0 || superPrice<0 || superPlusPrice<0|| gasPrice<0 || methanePrice<0 || premiumDieselPrice<0)
			throw new PriceException("there cannot be negative prices");
		

		GasStation g=gasstationrepo.findOne(gasStationId);
		if(g==null)
			throw new InvalidGasStationException("invalid gas station id");
		
		if(g.getReportUser()==null || g.getReportUser()==-1)
			check=true;

		if(! check) {
			Date date1=new Date(System.currentTimeMillis());
			Date date2=new Date(System.currentTimeMillis());
			try {
				date2 = formatter.parse(g.getReportTimestamp());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    long diff = TimeUnit.DAYS.convert(date2.getTime() - date1.getTime(), TimeUnit.MILLISECONDS);
		    if(diff>4)
		    	check=true;
			
		}
		
		if(!check) {
			User n=userrepo.findOne(userId);
			User o= userrepo.findOne(g.getReportUser());
			if(n!=null && o!=null) {
				if(n.getReputation()>=o.getReputation())
					check=true;
			}
		}
		
		if(check) {
		
			if(userrepo.findOne(userId)!=null && gasstationrepo.findOne(gasStationId)!=null) {
			
				if(dieselPrice>0) {
					gasstationrepo.setDieselPrice(gasStationId,dieselPrice);
					add=true;
				}
				
				if(superPrice>0) {
					gasstationrepo.setSuperPrice(gasStationId,superPrice);
					add=true;
				}
				
				if(superPlusPrice>0) {
					gasstationrepo.setSuperPlusPrice(gasStationId,superPlusPrice);
					add=true;
				}
				
				if(gasPrice>0) {
					gasstationrepo.setGasPrice(gasStationId,gasPrice);
					add=true;
				}
				
				if(methanePrice>0) {
					gasstationrepo.setMethanePrice(gasStationId,methanePrice);
				
					add=true;
				}
				
				if(premiumDieselPrice>0) {
					gasstationrepo.setSuperPremiumDieselPrice(gasStationId,premiumDieselPrice);
				
					add=true;
				}
				
				if(add) {
					gasstationrepo.setUserId(userId, gasStationId);
					gasstationrepo.setTimestamp(formatter.format(new Date(System.currentTimeMillis())), gasStationId);
				}
			
			}
		}
		
	}

	@Override
	public List<GasStationDto> getGasStationsByProximity(double lat, double lon) throws GPSDataException {
		
		return getGasStationsByProximity(lat,lon,1);
	}
	
	
	
}
