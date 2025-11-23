package quiz.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.app.Dto.QuestionDto;
import quiz.app.Dto.SubmitTestDto;
import quiz.app.Dto.TestDto;
import quiz.app.Repositry.QuestionRepo;
import quiz.app.Repositry.TestResultRepo;
import quiz.app.Service.TestService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private TestResultRepo testResultRepo;
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@PostMapping("/create")
	public ResponseEntity<?> createTest(@RequestBody TestDto dto){
		
		try {
			
			return new ResponseEntity<>(testService.createTest(dto), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addQuestion")
	public ResponseEntity<?> addQuestion(@RequestBody QuestionDto dto){
		
		return new ResponseEntity<>(testService.addQuestionText(dto), HttpStatus.OK);
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllTest(){
		
		try {
			
			return new ResponseEntity<>(testService.getAllTest(), HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		}
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllQuestion(@PathVariable Long id){
		
		try {
			return new ResponseEntity<>(testService.getAllQuestion(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@PostMapping("/submitTest")
	public ResponseEntity<?> SubmitTest(@RequestBody SubmitTestDto dto){
		
		try {
			
			return new ResponseEntity<>(testService.SubmitTest(dto), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/all-Result")
	public ResponseEntity<?> getAllTestResult(){
		
		try {
			return new ResponseEntity<>(testService.getAllTestResult(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/user-result/{userId}")
	public ResponseEntity<?> getAllTestResultUser(@PathVariable Long userId){
		
		return new ResponseEntity<>(testService.getAllTestReultUser(userId) , HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/result/{id}")
	public ResponseEntity<?> deleteResult(@PathVariable Long id) {
	    return testResultRepo.findById(id)
	            .map(result -> {
	                testResultRepo.delete(result);
	                return new ResponseEntity<>("Result deleted successfully", HttpStatus.OK);
	            })
	            .orElse(new ResponseEntity<>("Result not found", HttpStatus.NOT_FOUND));
	}
	
	
	@DeleteMapping("/question/{id}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long id){
		
		return questionRepo.findById(id).map(que -> {
			questionRepo.delete(que);
			return new ResponseEntity<>("Question Deleted successfull" , HttpStatus.OK);
		})
				.orElse(new ResponseEntity<>("Question Not Found" , HttpStatus.OK));
		
	}
	
	
	



}
