package bo.custom.customImpl;

import java.util.ArrayList;

import bo.custom.UserBo;
import dao.DaoFactory;
import dao.custom.Userdao;
import dto.UserDto;
import entity.User;

public class UserBoImpl implements UserBo{

    private Userdao userdao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.USER);

    @Override
    public boolean saveUser(UserDto UserDTO) throws Exception {
       return userdao.save(new User(UserDTO.getUsername(), UserDTO.getPassword(), UserDTO.getName(), UserDTO.getContactNo()));
    }

    @Override
    public boolean updateUser(UserDto UserDTO) throws Exception {
     
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public boolean deleteUser(Integer id) throws Exception {
       
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public UserDto getUser(Integer id) throws Exception {
       
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    @Override
    public ArrayList<UserDto> getAllUser() throws Exception {
       
        throw new UnsupportedOperationException("Unimplemented method 'getAllUser'");
    }

    @Override
    public UserDto getUserByUsername(String username) throws Exception {
      User user = userdao.getCustomerByUserName(username);
      if(user !=null){
        UserDto userDto = new UserDto(user.getUsername(), user.getPassword());
        return userDto;
      }else{
        return null;
      }
      
    }
    
}
