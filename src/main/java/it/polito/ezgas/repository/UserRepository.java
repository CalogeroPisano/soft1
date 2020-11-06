package it.polito.ezgas.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;

import it.polito.ezgas.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query("SELECT SUM(userId) FROM User WHERE email=:em and password=:pwd")
	Integer verifyCredentials(@Param("em") String em,@Param("pwd") String pwd );
	
	@Query("SELECT Count(*) FROM User WHERE email=:em")
	Integer verifyEmail(@Param("em") String em);
	
	
	@Query("SELECT SUM(reputation) FROM User WHERE userId=:id ")
	Integer getReputation(@Param("id") Integer id);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE User SET reputation=:rep WHERE userId=:id")
	int changeReputation(@Param("id") Integer id,@Param("rep") Integer rep);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE User SET userName=:usr, email=:em , password=:pwd WHERE userId=:id")
	int updateUsr(@Param("id") Integer id,@Param("usr") String usr,@Param("em") String em,@Param("pwd") String pwd);
	
	
	
}
