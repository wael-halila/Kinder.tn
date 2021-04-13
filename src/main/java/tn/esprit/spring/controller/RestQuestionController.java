package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Question;
import tn.esprit.spring.sevice.impl.QuestionServiceImpl;




@RestController
public class RestQuestionController {

	@Autowired
	QuestionServiceImpl questionService;
	

	// http://localhost:8081//SpringMVC/servlet/ajouterQuestion
	@PostMapping("/ajouterQuestion")
	@ResponseBody
	public Question ajouterQuestion(@RequestBody Question question)
	{
		questionService.ajouterQuestion(question);
		return question;
	}
	
	
	 // http://localhost:8081/SpringMVC/servlet/getQuestionById/1
    @GetMapping(value = "getQuestionById/{idQuestion}")
    @ResponseBody
	public Question getEntrepriseById(@PathVariable("idQuestion") int questionId) {

		return questionService.getQuestionById(questionId);
	}
    
 // http://localhost:8081/SpringMVC/servlet/questions/{qd}/{rep}/{idk}
    
    @GetMapping("/questions/{qId}/{rep}/{idk}") 
	private String getResponse(@PathVariable("qId") int questionId ,@PathVariable("rep") String reponse,@PathVariable("idk") int idkid)
  { 
	 return questionService.getResponse(questionId, reponse, idkid);}

}

