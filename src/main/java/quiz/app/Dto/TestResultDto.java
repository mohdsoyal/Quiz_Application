package quiz.app.Dto;

import lombok.Data;

@Data
public class TestResultDto {
	
	
    private Long id;
	
	private int totalQuestion;
	
	private int correctAnswer;
	
	private double percentage;
	
	
	private String testName;
	
	private String userName;

}
