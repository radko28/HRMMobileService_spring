package sk.cyklosoft.hrmservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sk.cyklosoft.hrmservice.dao.SportDao;
import sk.cyklosoft.hrmservice.dao.UserDao;
import sk.cyklosoft.hrmservice.data.UserResponseData;
import sk.cyklosoft.hrmservice.model.User;
import sk.cyklosoft.hrmservice.service.UserService;
import sk.cyklosoft.hrmservice.util.SportType;
import sk.cyklosoft.hrmservice.vo.Address;
import sk.cyklosoft.hrmservice.vo.Team;
import sk.cyklosoft.hrmservice.vo.UserVO;

@Service("userService")
@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	@Autowired
	SportDao sportDao;

	public UserResponseData getUserDetail(String username) {
		User user = userDao.findUserByUsername(username);
		
		UserResponseData response = new UserResponseData();
		UserVO userVO = new UserVO();
    	userVO.setUsername(username);
    	userVO.setFirstname(user.getFirstname());
    	userVO.setLastname(user.getLastname());
    	userVO.setPassword(user.getPassword());
    	userVO.setUserId(user.getUserId());
    	userVO.setCurrentActivity(user.getCurrentActivity());
    	response.setUser(userVO);
    	
    	Address address = new Address();
    	address.setAddressId(1027L);
    	address.setCity("Terany");
    	address.setCountry("Slovakia");
    	address.setPhone("0911760775");
    	address.setZip("96268");
    	address.setAddress("27");
    	//response.setAddress(address);
    	
    	Team team = new Team();
    	team.setName("sakali");
    	team.setTeamId(1975L);
    	List<Team> teamList = new ArrayList<>();
    	teamList.add(team);
    	//response.setTeam(teamList);
    	
		return response;
	}

	@Override
	public void registerUser(UserVO userVO) {
		User user = new User();
		user.setFirstname(userVO.getFirstname());
		user.setLastname(userVO.getLastname());
		user.setPassword(userVO.getPassword());
		user.setUsername(userVO.getUsername());
		user.setCurrentActivity(SportType.STOP);
		userDao.register(user);
		
	}

	@Override
	public void deleteUser(Long userId) {
        User user = userDao.findUserById(userId);		
		sportDao.delete(user.getUsername());
		userDao.delete(user);
		
	}

	@Override
	public List<UserVO> findAllUsers() {
        List<User> userList = userDao.findAllUsers();
        // copy
         List<UserVO> result = new ArrayList<UserVO>();
        for (User user : userList) {
            result.add(user.copy());
        }
        return result;
	}

	@Override
	public String getWholeNameByUsername(String string) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public UserVO getUserById(Long userId) {
        User user = userDao.findUserById(userId);
        UserVO result = user.copy();
        return result;
    }
}



