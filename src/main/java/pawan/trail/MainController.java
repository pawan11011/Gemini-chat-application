package pawan.trail;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ask/question")
public class MainController {
	@Autowired
	Webbuilder wb;
	
	@PostMapping("/now")
	public String getResponse(@RequestBody Map<String,String> payload) {
		String question = payload.get("question");
		String response = wb.getAnswer(question);
		return response;
	}
}
