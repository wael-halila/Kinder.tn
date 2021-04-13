package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name = "Child")
public class Child implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idKid;

	@Column(name = "fistName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthDate")
	private Date birthDate;

	@Column(name = "gender")
	private String gender;

	@Column(name = "address")
	private String address;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;


	@ManyToOne
	@JoinColumn(name = "id_bus")
	private KindergartenBus bus;


	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Child(int idKid, String firstName, String lastName, Date birthDate, String gender, String address) {
		super();
		this.idKid = idKid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.address = address;
	}


	public int getIdKid() {
		return idKid;
	}


	public void setIdKid(int idKid) {
		this.idKid = idKid;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public KindergartenBus getBus() {
		return bus;
	}


	public void setBus(KindergartenBus bus) {
		this.bus = bus;
	}
	@OneToOne(mappedBy="child")
	private Score score;


	public Score getScore() {
		return score;
	}


	public void setScore(Score score) {
		this.score = score;
	}


	
}
