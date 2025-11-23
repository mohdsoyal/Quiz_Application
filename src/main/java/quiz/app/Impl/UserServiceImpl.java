package quiz.app.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import quiz.app.Entity.User;
import quiz.app.Repositry.UserRepo;
import quiz.app.Service.UserService;
import quiz.app.enums.UserRole;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	
	// This method runs automatically after the app starts
	@PostConstruct
	private void createAdminUser() {
		
		User optionalUser = userRepo.findByRole(UserRole.ADMIN);
		if(optionalUser == null) {
			
			User user = new User();
			
			user.setName("Admin");
			user.setEmail("admin6393@gmail.com");
			user.setRole(UserRole.ADMIN);
			user.setPassword("admin12345");
			
			userRepo.save(user);
		}
		
		
	}
	
	
	public  Boolean hasUserWithEmail(String email) {
		
		return userRepo.findFirstByEmail(email) != null ;

}
	
	public User createUser(User user) {
		
		user.setRole(UserRole.USER);
		
		return userRepo.save(user);
	}
	
	
	public User login(User user) {
		
		Optional<User> opUser = userRepo.findByEmail(user.getEmail());
		
		if(opUser.isPresent() && user.getPassword().equals(opUser.get().getPassword())) {
			
			return opUser.get();
		}
		
		return null;
	}
}