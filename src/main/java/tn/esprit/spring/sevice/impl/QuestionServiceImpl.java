package tn.esprit.spring.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Question;
import tn.esprit.spring.entity.Score;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.ScoreRepository;



@Service 
public class QuestionServiceImpl implements IQuestionService {

	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	ScoreRepository scoreRepository;
	
	public List<Question> getAllQuestion() {
		return (List<Question>) questionRepository.findAll();
}
	

	public int ajouterQuestion(Question question) {
		questionRepository.save(question);
		return question.getQuestionId();
	}
	
	public Question getQuestionById(int QuestionId) {
		return questionRepository.findById(QuestionId).get();	
	
}
	@Transactional
	public String getResponse(int questionId , String reponse,int idKid) {
		//List<Question> list= getAllQuestion();
		
		Question question =  questionRepository.findById(questionId).get();
		if(question.getCorrect().equals(reponse))
		{ 
			
		Score sc = scoreRepository.getScoreByIdkid(idKid);
		
		 int valeur = sc.getScore();
		 valeur++;
		 scoreRepository.updateScoreById(valeur,sc.getId());
		 
	
			return ("that's right ! ");}
			
			else
				
				return (" try again ");
				
		
	}
	}
	
