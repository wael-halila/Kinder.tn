package tn.esprit.spring.sevice.impl;

import java.util.List;

import tn.esprit.spring.entity.Question;

public interface IQuestionService {

	//public Iterable<Question> findAll();

	public int ajouterQuestion(Question question);
	
	public List<Question> getAllQuestion(); 
	
	public Question getQuestionById(int QuestionId);
	public String getResponse(int questionId , String reponse,int idKid);
	
	
	
}
