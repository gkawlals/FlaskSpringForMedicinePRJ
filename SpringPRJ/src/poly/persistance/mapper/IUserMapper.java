package poly.persistance.mapper;

import config.Mapper;
import poly.dto.UserDTO;

@Mapper("UserMapper")
public interface IUserMapper {

	UserDTO LoginStart(UserDTO pDTO);

	int InsertStart(UserDTO pDTO);

	int userIdCheck(String user_id);

}
