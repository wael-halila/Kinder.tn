package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name= "Driver")
public class BusDriver implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idDriver;
	@Column(name= "firstName")
	private String firstName;
	@Column(name= "lastName")
	private String lastName;
	@Column(name= "telNum")
	private int telNum;
	@Column(name= "address")
	private String address;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="driver", fetch= FetchType.EAGER)
	private Set<KindergartenBus> bus;
	
	
	public int getIdDriver() {
		return idDriver;
	}
	public void setIdDriver(int idDriver) {
		this.idDriver = idDriver;
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
	public int getTelNum() {
		return telNum;
	}
	public void setTelNum(int telNum) {
		this.telNum = telNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<KindergartenBus> getBus() {
		return bus;
	}
	public void setBus(Set<KindergartenBus> bus) {
		this.bus = bus;
	}

}
