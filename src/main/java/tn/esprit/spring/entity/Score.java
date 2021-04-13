package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Score implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private int score;
	public Score(int id, int score) {
		super();
		this.id = id;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@OneToOne
	private Child child;
	
	
	public Score(int id, int score, Child child) {
		super();
		this.id = id;
		this.score = score;
		this.child = child;
	}
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Child getChild() {
		return child;
	}
	public void setChild(Child child) {
		this.child = child;
	}

}
