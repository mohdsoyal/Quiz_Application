package quiz.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import quiz.app.Dto.TestDetailsDto;
import quiz.app.Dto.TestResultDto;

@Entity
@Data
public class TestResult {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int totalQuestion;
	
	private int correctAnswer;
	
	private double percentage;
	
	@ManyToOne
	@JoinColumn(name = "test_id")
	private Test test;
	
	@ManyToOne
	@JoinColumn(name ="user_id")
	private User user;
	
	
	
	public TestResultDto getDto() {
		
		TestResultDto dto = new TestResultDto();
		dto.setId(id);
		dto.setTotalQuestion(totalQuestion);
		dto.setCorrectAnswer(correctAnswer);
		dto.setPercentage(percentage);
		dto.setTestName(test.getTitle());
		dto.setUserName(user.getName());
		
		return dto;
		
		
		
	
	}

}
