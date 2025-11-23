package quiz.app.Impl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import quiz.app.Dto.QuestionDto;
import quiz.app.Dto.QuestionResponse;
import quiz.app.Dto.SubmitTestDto;
import quiz.app.Dto.TestDetailsDto;
import quiz.app.Dto.TestDto;
import quiz.app.Dto.TestResultDto;
import quiz.app.Entity.Question;
import quiz.app.Entity.Test;
import quiz.app.Entity.TestResult;
import quiz.app.Entity.User;
import quiz.app.Repositry.QuestionRepo;
import quiz.app.Repositry.TestRepo;
import quiz.app.Repositry.TestResultRepo;
import quiz.app.Repositry.UserRepo;
import quiz.app.Service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestRepo testRepo;
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Autowired
	private TestResultRepo testResultRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	
	public TestDto createTest(TestDto dto) {
		
		Test test = new Test();
		test.setTitle(dto.getTitle());
		test.setDescription(dto.getDescription());
		test.setTime(dto.getTime());
		
		return testRepo.save(test).getDto();
	}
	
	
	public QuestionDto addQuestionText(QuestionDto dto) {
		
		Optional<Test> opTest = testRepo.findById(dto.getId());
		if(opTest.isPresent()) {
			
			Question question = new Question();
			
			question.setTest(opTest.get());
			question.setQuestionText(dto.getQuestionText());
			question.setOptionA(dto.getOptionA());
			question.setOptionB(dto.getOptionB());
			question.setOptionC(dto.getOptionC());
			question.setOptionD(dto.getOptionD());
			question.setCorrectOption(dto.getCorrectOption());
			
			return questionRepo.save(question).getDto();
			
		}
		
		throw new EntityNotFoundException("Test Not Found !");
	
	}
	
	public List<TestDto> getAllTest() {
	    return testRepo.findAll().stream()
	        .map(Test::getDto)
	        .collect(Collectors.toList());
	}
	
	
	
	public TestDetailsDto getAllQuestion(Long id) {
		
		Optional<Test> opTest = testRepo.findById(id);
		
		TestDetailsDto testDetailsDto = new TestDetailsDto();
		
		if(opTest.isPresent()) {
			TestDto testDto = opTest.get().getDto();
			testDto.setTime(opTest.get().getTime() * opTest.get().getQuestions().size());
			
			
			testDetailsDto.setTestDto(testDto);
			testDetailsDto.setQuestion(opTest.get().getQuestions().stream().map(Question::getDto).toList());
			return testDetailsDto;
		}
		
		return testDetailsDto;
	
	}
	
	
	
	public TestResultDto SubmitTest(SubmitTestDto request) throws Exception {
		
		Test test = testRepo.findById(request.getTestId()).orElseThrow(() -> new Exception("Test Not Found"));
		
		User  user = userRepo.findById(request.getUserId()).orElseThrow(() -> new Exception("User Not Found"));
		
		int correctAnswer =0;
		for(QuestionResponse response : request.getResponses()) {
			
			Question question =questionRepo.findById(response.getQuestionId()).orElseThrow(() -> new Exception("Question Not Found"));
			
			if(question.getCorrectOption().equals(response.getSelectedOption())) {
				
				correctAnswer++;
			}
		}
		
		int  totalQuestion = test.getQuestions().size();
		double percentage = ((double)correctAnswer/totalQuestion)*100;
		
		TestResult testResult = new TestResult();
		testResult.setTest(test);
		testResult.setUser(user);
		testResult.setTotalQuestion(totalQuestion);
		testResult.setCorrectAnswer(correctAnswer);
		testResult.setPercentage(percentage);
		
		
		
		return testResultRepo.save(testResult).getDto();
	}


	public List<TestResultDto> getAllTestResult(){
		return testResultRepo.findAll().stream().map(TestResult::getDto).collect(Collectors.toList());
	}
	
	
	public List<TestResultDto> getAllTestReultUser(Long userId){
		
		return testResultRepo.findAllByUserId(userId).stream().map(TestResult::getDto).collect(Collectors.toList());
	}


	

	
	
	

	
}
