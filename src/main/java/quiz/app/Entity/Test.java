package quiz.app.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import quiz.app.Dto.TestDto;

@Entity
@Data
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	private Long time;
	
	@OneToMany(mappedBy = "test" , cascade = CascadeType.ALL)
	private List<Question> questions;
	
	public TestDto getDto() {
		TestDto testDto = new TestDto();
		
		testDto.setId(id);
		testDto.setTitle(title);
		testDto.setDescription(description);
		testDto.setTime(time);
		return testDto;
	}

}
