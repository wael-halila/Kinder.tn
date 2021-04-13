package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.spring.entity.StatusApp;

@Entity
@Table(name="Appointements")
public class Appointement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 @Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		@Column(name= "id")
		private int idAppointement;
		private LocalDate startDate;


		private LocalTime time;
	    
		public Appointement() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Appointement(int idAppointement, LocalDate startDate, LocalTime time, LocalDateTime createdAt,
				LocalDateTime canceledAt, StatusApp status, User canceler) {
			super();
			this.idAppointement = idAppointement;
			this.startDate = startDate;
			this.time = time;
			this.createdAt = createdAt;
			this.canceledAt = canceledAt;
			this.status = status;
			this.canceler = canceler;
		
			
		}

		public int getIdAppointement() {
			return idAppointement;
		}

		public void setIdAppointement(int idAppointement) {
			this.idAppointement = idAppointement;
		}

		public LocalDate getStartDate() {
			return startDate;
		}

		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}

		public LocalTime getTime() {
			return time;
		}

		public void setTime(LocalTime time) {
			this.time = time;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public LocalDateTime getCanceledAt() {
			return canceledAt;
		}

		public void setCanceledAt(LocalDateTime canceledAt) {
			this.canceledAt = canceledAt;
		}

		public StatusApp getStatus() {
			return status;
		}

		public void setStatus(StatusApp status) {
			this.status = status;
		}

		/*public User getCanceler() {
			return canceler;
		} */

		public void setCanceler(User canceler) {
			this.canceler = canceler;
		}

		

		 public User getUsers() {
			return users;
		}

		public void setUsers(User users) {
			this.users = users;
		}

		private LocalDateTime createdAt;
	    
		@Column(name = "canceled_at")
		private LocalDateTime canceledAt;
		@Column(name = "status")
		
		@Enumerated(EnumType.STRING)
		private StatusApp status;
		
		@OneToOne
		@JoinColumn(name = "id_canceler")
		private User canceler; 
		
		
	    
	    @ManyToOne
	    @JoinColumn(name = "id_kindergarten")
	    private Kindergarten kindergarten;  
		
	   
	   public Kindergarten getKindergarten() {
			return kindergarten;
		}

		public void setKindergarten(Kindergarten kindergarten) {
			this.kindergarten = kindergarten;
		}

	@JsonIgnore

	    @ManyToOne
	    @JoinColumn(name = "id_parent")
	    private User users;
		
	
	//@ManyToMany(cascade= CascadeType.ALL, mappedBy="meetings", fetch= FetchType.EAGER)
	//private Set<User> users;

	
	@Override
	public String toString() {
		return "Appointement [idAppointement=" + idAppointement + ", startDate=" + startDate + ", time=" + time + ", createdAt="
				+ createdAt + ", canceledAt=" + canceledAt + ", canceler=" + canceler + ", status=" + status + ", kindergarten=" + kindergarten + ", users=" + users
				+ "]";
	}
}
