package bo.custom;

import java.util.ArrayList;

import dto.UserDto;

public interface UserBo {
     public boolean saveUser(UserDto UserDTO) throws Exception;

    public boolean updateUser(UserDto UserDTO) throws Exception;

    public boolean deleteUser(Integer id) throws Exception;

    public UserDto getUser(Integer id) throws Exception;

    public ArrayList<UserDto> getAllUser() throws Exception;

    public UserDto  getUserByUsername(String username) throws Exception;
}
