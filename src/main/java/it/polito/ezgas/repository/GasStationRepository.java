package it.polito.ezgas.repository;

import javax.persistence.Column;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.polito.ezgas.entity.GasStation;

@Repository
public interface GasStationRepository extends CrudRepository<GasStation, Integer>{
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE GasStation SET gasStationName=:gname, gasStationAddress=:gadr ,"
			+ " hasDiesel=:hd, hasSuper=:hs, hasSuperPlus=:hsp, hasGas=:hg,"
			+ " hasMethane=:hm, hasPremiumDiesel=:hpd, carSharing=:cs, lat=:la, lon=:lo,"
			+ " dieselPrice=:dp, superPrice=:sp, superPlusPrice=:spp,"
			+ " gasPrice=:gp, methanePrice=:mp,premiumDieselPrice=:pdp, reportUser=:ru,"
			+ " reportTimestamp=:rt,reportDependability=:rd "
			+ "WHERE gasStationId=:id")
	int updateGasStation(@Param("id") Integer id,@Param("gname") String gname,@Param("gadr") String gadr,@Param("hd") boolean hd,
			@Param("hs") boolean hs,@Param("hsp") boolean hsp,@Param("hg") boolean hg,@Param("hm") boolean hm,@Param("hpd") boolean hpd,
			@Param("cs") String cs,@Param("la") double la,@Param("lo") double lo,@Param("dp") double dp,
			@Param("sp") double sp,@Param("spp") double spp,@Param("gp") double gp,@Param("mp") double mp,@Param("pdp") double pdp,
			@Param("ru") Integer ru,@Param("rt") String rt,@Param("rd") double rd );
	
	
	
	@Query("SELECT Count(*) FROM GasStation WHERE lat=:lat AND lon=:lon ")
	Integer verifyLatLon(@Param("lat") double lat,@Param("lon") double lon);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE GasStation SET hasGas='TRUE', gasPrice=:price WHERE gasStationId=:id")
	Integer setGasPrice(@Param("id") Integer id,@Param("price") double price);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE GasStation SET hasDiesel='TRUE', dieselPrice=:price WHERE gasStationId=:id")
	Integer setDieselPrice(@Param("id") Integer id,@Param("price") double price);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE GasStation SET hasMethane='TRUE', methanePrice=:price WHERE gasStationId=:id")
	Integer setMethanePrice(@Param("id") Integer id,@Param("price") double price);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE GasStation SET hasSuper='TRUE', superPrice=:price WHERE gasStationId=:id")
	Integer setSuperPrice(@Param("id") Integer id,@Param("price") double price);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE GasStation SET hasSuperPlus='TRUE', superPlusPrice=:price WHERE gasStationId=:id")
	Integer setSuperPlusPrice(@Param("id") Integer id,@Param("price") double price);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE GasStation SET hasPremiumDiesel='TRUE', premiumDieselPrice=:price WHERE gasStationId=:id")
	Integer setSuperPremiumDieselPrice(@Param("id") Integer id,@Param("price") double price);
	
	
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE GasStation SET reportUser=:uid WHERE gasStationId=:gasid")
	Integer setUserId(@Param("uid") Integer uid,@Param("gasid") Integer gasid);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE GasStation SET reportTimestamp=:tm WHERE gasStationId=:gasid")
	Integer setTimestamp(@Param("tm") String time,@Param("gasid") Integer gasid);
	

}
