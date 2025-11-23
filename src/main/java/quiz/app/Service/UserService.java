package quiz.app.Service;

import quiz.app.Entity.User;

public interface UserService {
	
	User createUser(User user);
	
	Boolean hasUserWithEmail(String email);
	
	User login(User user);
	
	
	
	
	
	

}
