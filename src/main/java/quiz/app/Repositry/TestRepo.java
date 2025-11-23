package quiz.app.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import quiz.app.Entity.Test;

public interface TestRepo extends JpaRepository<Test, Long>{

	
}
