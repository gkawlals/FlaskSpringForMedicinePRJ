package poly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.UserDTO;
import poly.persistance.mapper.IUserMapper;
import poly.service.IUserSerivce;
import org.apache.log4j.Logger;
import org.mortbay.log.Log;

@Service("UserService")
public class UserService implements IUserSerivce {
	
	@Resource(name="UserMapper")
	IUserMapper userMapper;
	
	@Override
	public UserDTO LoginStart(UserDTO pDTO) throws Exception{
		
		Log.info(this.getClass() + "LoginStart for Service");
		
		return userMapper.LoginStart(pDTO);
	}

	@Override
	public int InsertStart(UserDTO pDTO) throws Exception {
		
		Log.info(this.getClass() + "InsertStart for Service");
		
		return userMapper.InsertStart(pDTO);
	}

}
