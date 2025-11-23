package quiz.app.Repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import quiz.app.Entity.User;
import quiz.app.enums.UserRole;

public interface UserRepo extends JpaRepository<User, Long>{
	
	 User findByRole(UserRole role);
	 
	 User findFirstByEmail(String email);
	 
	Optional<User> findByEmail(String email);

}
