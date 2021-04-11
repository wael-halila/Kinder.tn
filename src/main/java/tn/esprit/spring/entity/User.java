package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class User implements Serializable {
	   private static final long serialVersionUID = 1L;
	   @Id
       @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @JoinColumn(name= "idUser")
       private Long idUser;
	   private String email;
	   private String telNum;
	   private String firstName; 
	   public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	private String lastName ; 
		
		public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
		public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
		
	

	@LazyCollection(LazyCollectionOption.FALSE)
		@OneToMany(mappedBy="user",cascade=CascadeType.MERGE)
		private List<Claim> claims;
	@OneToOne(mappedBy="user")
	private Kindergarten kindergarten ;
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Claim> getClaims() {
		return claims;
	}
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}
	public Kindergarten getKindergarten() {
		return kindergarten;
	}
	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long idUser, String email, 
			List<Claim> claims, Kindergarten kindergarten , String telNum) {
		super();
		this.idUser = idUser;
		this.email = email;
		this.claims = claims;
		this.kindergarten = kindergarten;
		this.telNum= telNum;
	}
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", email=" + email + ", telNum=" + telNum + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", claims=" + claims + ", kindergarten=" + kindergarten + "]";
	}
	
	
	
	
	
	
	
	
	
	
	   
	
}
