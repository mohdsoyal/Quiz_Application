package quiz.app.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import quiz.app.Entity.TestResult;

public interface TestResultRepo extends JpaRepository<TestResult, Long>{
	
	
	List<TestResult> findAllByUserId(Long userId);

}
