package tn.esprit.spring.entity;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String message;
	@Enumerated (EnumType.STRING)
	private  Favorite favorite;
	public enum Favorite {LIKE, DISLIKE	}
	private int view_number;
	private float statistic;


	
	@OneToMany(mappedBy="post",cascade={ CascadeType.ALL},fetch=FetchType.EAGER)
	private List<Comment> comments =  new ArrayList<>();
	
	//constructeur paramétré
	
	public Post(int id, Favorite favorite, int view_number, float statistic) {
		super();
		this.id = id;
		this.favorite = favorite;
		this.view_number = view_number;
		this.statistic = statistic;
		
	}
	//vide
	
	public Post(int ref, String message) {
		super();
		
		this.message = message;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//getter & setter 
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public Favorite getFavorite() {
		return favorite;
	}
	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
	}
	public int getView_number() {
		return view_number;
	}
	public void setView_number(int view_number) {
		this.view_number = view_number;
	}
	public float getStatistic() {
		return statistic;
	}
	public void setStatistic(float statistic) {
		this.statistic = statistic;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Post(int id, String message, Favorite favorite, int view_number, float statistic, List<Comment> comments) {
		super();
		this.id = id;
		this.message = message;
		this.favorite = favorite;
		this.view_number = view_number;
		this.statistic = statistic;
		this.comments = comments;
	}

	
	
	
	
	
	

}
