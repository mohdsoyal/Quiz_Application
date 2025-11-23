package quiz.app.Dto;

import java.util.List;

import lombok.Data;

@Data
public class TestDetailsDto {
	
	private TestDto testDto;
	
	private List<QuestionDto> question;

}
