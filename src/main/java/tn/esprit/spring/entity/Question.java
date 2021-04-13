package tn.esprit.spring.entity;

import java.io.Serializable;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="T_Question")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int questionId;
	
	private String choix1;
	private String choix2;
	private String choix3;
	
	//@Transient
	private String correct;

	private String content;
	public String getChoix1() {
		return choix1;
	}
	public void setChoix1(String choix1) {
		this.choix1 = choix1;
	}
	public String getChoix2() {
		return choix2;
	}
	public void setChoix2(String choix2) {
		this.choix2 = choix2;
	}
	public String getChoix3() {
		return choix3;
	}
	public void setChoix3(String choix3) {
		this.choix3 = choix3;
	}
	public String getCorrect() {
		return correct;
	}
	public Question(int questionId, String content, String correct) {
		super();
		this.questionId = questionId;
		this.content = content;
		this.correct = correct;
	}
	public Question() {
		super();
		
	}
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int id) {
		this.questionId = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String setCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}

	

}
