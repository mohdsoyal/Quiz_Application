//package quiz.app.Controller;
//
//import java.util.ArrayList;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import jakarta.validation.Valid;
//import quiz.app.Entity.Question;
//import quiz.app.Service.QuestionService;
//
//@CrossOrigin(origins = "http://localhost:5173")
//@RestController
//@RequestMapping("/quiz")
//public class QuestionController {
//
//	@Autowired
//	private QuestionService questionservice;
//	
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
//	@PostMapping("/create")
//	public ResponseEntity<Question> createQuestion( @Valid @RequestBody Question question) {
//		
//		Question question2 = questionservice.createQuestion(question);
//		
//		return ResponseEntity.ok(question2);
//	}
//	
//	@GetMapping("/allQuestion")
//	public List<Question> getAllQuestion() {
//		
//		return questionservice.getAllQuestion();
//	}
//	
//	@GetMapping("/getQuestion/{id}")
//	public Optional<Question> getQuestionById(@PathVariable Long id) {
//		
//		return questionservice.getQuestionById(id);
//	}
//	
//	
//	   @GetMapping("/getAllSubject")
//       public List<String> getAllSubjects() {
//		
//		return questionservice.getAllSubjects();
//	}
//	   
//	   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//	   @PutMapping("/update/{id}")
//	   public Question update(@RequestBody Question question, @PathVariable Long id) {
//		   return questionservice.update(question, id);
//	   }  
//	   
//	   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//	   @DeleteMapping("/delete/{id}")
//	   public void deleteQuestion(@PathVariable Long id) {
//		   questionservice.deleteQuestion(id);
//	   }
//	   
//	   @GetMapping("/getQuestionUser")
//	   public ResponseEntity<List<Question>>  getQuestionsForUser(@RequestParam Integer numOfQuestion,@RequestParam String subject) {
//	      
//		   List<Question> allquestion = questionservice.getQuestionForUser(numOfQuestion, subject);
//		   List<Question> multipleQuestion = new ArrayList<>(allquestion);
//		   Collections.shuffle(multipleQuestion);
//		   
//		   int availableQuestion = Math.min(numOfQuestion, multipleQuestion.size());
//		   List<Question> randomQuestions = multipleQuestion.subList(0, availableQuestion);
//	       return ResponseEntity.ok(randomQuestions);
//	   }
//
//	   
//}
