package quiz.app.Dto;

import java.util.List;

import lombok.Data;

@Data
public class SubmitTestDto {
	
	private Long testId;
	
	private Long userId;
	
	private List<QuestionResponse> responses;
	
	

}
