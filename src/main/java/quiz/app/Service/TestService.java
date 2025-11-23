package quiz.app.Service;

import java.util.List;

import quiz.app.Dto.QuestionDto;
import quiz.app.Dto.SubmitTestDto;
import quiz.app.Dto.TestDetailsDto;
import quiz.app.Dto.TestDto;
import quiz.app.Dto.TestResultDto;
import quiz.app.Entity.Test;

public interface TestService {
	
	 TestDto createTest(TestDto dto);
	 
	 QuestionDto addQuestionText(QuestionDto dto);
	 
	 List<TestDto> getAllTest();

	 TestDetailsDto getAllQuestion(Long id);
	 
	 TestResultDto SubmitTest(SubmitTestDto request) throws Exception;
	 
	 List<TestResultDto> getAllTestResult();
	 
	 List<TestResultDto> getAllTestReultUser(Long userId);
	 
	 
}
