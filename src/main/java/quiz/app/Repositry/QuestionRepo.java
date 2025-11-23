package quiz.app.Repositry;


import org.springframework.data.jpa.repository.JpaRepository;

import quiz.app.Entity.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {
	
	

}
