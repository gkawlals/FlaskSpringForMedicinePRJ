package poly.service;

import poly.dto.UserDTO;

public interface IUserSerivce {

	UserDTO LoginStart(UserDTO pDTO) throws Exception;

	int InsertStart(UserDTO pDTO) throws Exception;

}
