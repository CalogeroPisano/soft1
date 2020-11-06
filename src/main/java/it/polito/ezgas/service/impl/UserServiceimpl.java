package it.polito.ezgas.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.InvalidLoginDataException;
import exception.InvalidUserException;
import it.polito.ezgas.dto.IdPw;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.UserService;

/**
 * Created by softeng on 27/4/2020.
 */
@Service
public class UserServiceimpl implements UserService {
	
	@Autowired
	private  UserRepository userrepo;
	
	public UserServiceimpl(UserRepository userrepo)
	{
		this.userrepo = userrepo; 
	}
	
	//converts User to userDto
	public static UserDto UserToDto(User u) {
		UserDto dto=new UserDto();
		dto.setAdmin(u.getAdmin());
		dto.setEmail(u.getEmail());
		dto.setReputation(u.getReputation());
		dto.setUserId(u.getUserId());
		dto.setUserName(u.getUserName());
		dto.setPassword(u.getPassword());
		return dto;
	}
	
	//converts userDto to User
	public static User UserFromDto(UserDto dto,boolean newuser) {
		User u=new User();
		u.setAdmin(dto.getAdmin());
		u.setEmail(dto.getEmail());
		u.setReputation(dto.getReputation());
		u.setUserName(dto.getUserName());
		u.setPassword(dto.getPassword());
		
		//if the user is new i want the id to be generated automatically
		if(!newuser)
			u.setUserId(dto.getUserId());
		
		return u;
	}
	
	//converts User to LoginDto
	public static LoginDto UserToLoginDto(User u) {
		LoginDto ret=new LoginDto();
		ret.setAdmin(u.getAdmin());
		ret.setEmail(u.getEmail());
		ret.setReputation(u.getReputation());
		
		//For now we should ignore token so i set to a dummy string
		ret.setToken("dummy");
		
		ret.setUserId(u.getUserId());
		ret.setUserName(u.getUserName());
		return ret;
	}

	@Override
	public UserDto getUserById(Integer userId) throws InvalidUserException {
		if(userId>=0) {
			User u=userrepo.findOne(userId);
			if(u==null)
				return null;
			return UserToDto(u);
		}else
			throw new InvalidUserException("User not Found");
	}

	@Override
	public UserDto saveUser(UserDto userDto) {
		//check if there is another user with the same credentials before adding the new user
		User u=null;
		
		if(userrepo.verifyEmail(userDto.getEmail())==0 && userDto.getUserId()==null) {
			u=UserFromDto(userDto,true);
			userrepo.save(u);
			return UserToDto(u);
		}else if(userDto.getUserId()!=null){
			u=UserFromDto(userDto,false);
			if(userrepo.updateUsr(u.getUserId(),u.getUserName(),u.getEmail(),u.getPassword())==1) {
				
				return userDto;
				
			}else
				return null;
			
		}
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		ArrayList<UserDto> list=new ArrayList<UserDto>();
		for(User u: userrepo.findAll()) {
			list.add(UserToDto(u));
		}
		return list;
	}

	@Override
	public Boolean deleteUser(Integer userId) throws InvalidUserException {
		if(userId>=0) {
			userrepo.delete(userId);
			User u=userrepo.findOne(userId);
			if(u==null)
				return true;
			return false;
		}else
			throw new InvalidUserException("User not Found");
	}

	@Override
	public LoginDto login(IdPw credentials) throws InvalidLoginDataException {
		//User u=userrepo.findOne(1);
		User u= userrepo.findOne(userrepo.verifyCredentials(credentials.getUser(),credentials.getPw()));
		if(u!=null && u.getEmail().equals(credentials.getUser()) && u.getPassword().equals(credentials.getPw())) {
			
			return UserToLoginDto(u);
		}else
			throw new InvalidLoginDataException("wrong credentials");
		//return null;
	}

	@Override
	public Integer increaseUserReputation(Integer userId) throws InvalidUserException {
		if(userId>=0) {
			User u=userrepo.findOne(userId);
			Integer rep=0;
			if(u==null)
				return -1;
			rep=userrepo.getReputation(userId);
			rep= rep>=5 ?5 : rep+1;
			userrepo.changeReputation(userId,rep);
			return rep;
		}else
			throw new InvalidUserException("User not Found");
	}

	@Override
	public Integer decreaseUserReputation(Integer userId) throws InvalidUserException {
		if(userId>=0) {
			User u=userrepo.findOne(userId);
			Integer rep=0;
			if(u==null)
				return -1;
			rep=userrepo.getReputation(userId);
			rep= rep<=-5 ?-5 : rep-1;
			userrepo.changeReputation(userId,rep);
			return rep;
		}else
			throw new InvalidUserException("User not Found");
	}
	
}
