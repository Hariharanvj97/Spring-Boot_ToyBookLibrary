package com.cg.entity;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("unused")
@Entity
public class Child  {
	@Id
	@Column(name="child_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int childId;
	 @Column(name="user_name")
	 private String username;
	 @Column(name="password")
	 private String password;
	//@JsonFormat(pattern="dd-MM-yyyy")
	//@Temporal(TemporalType.DATE)
	 @Column(name="dob")
	private LocalDate dob;
 	 @Column(name="gender")
   	private String gender;
     @Column(name="mobile_number")
   	private String mobile;
   	 @Column(name="email_id")
   	private String email;
	 @Column(name="address")
   	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)
		Parent parent;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "child")
	@JsonIgnore
    List<LendItems> lenditems;
	
	  public List<LendItems> getLenditems() {
	    return lenditems;
	    }
	    public void setLenditems(List<LendItems> lenditems) {
	    this.lenditems = lenditems;
	    }
		public Child() {
			super();
		}
		
		public Child(int childId, String username, String password, LocalDate dob, String gender, String mobile,
				String email, String address, Parent parent, List<LendItems> lenditems) {
			super();
			this.childId = childId;
			this.username = username;
			this.password = password;
			this.dob = dob;
			this.gender = gender;
			this.mobile = mobile;
			this.email = email;
			this.address = address;
			this.parent = parent;
			this.lenditems = lenditems;
		}
		
		public int getChildId() {
			return childId;
		}
		public void setChildId(int childId) {
			this.childId = childId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public LocalDate getDob() {
			return dob;
		}
		public void setDob(LocalDate dob) {
			this.dob = dob;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Parent getParent() {
			return parent;
		}
		public void setParent(Parent parent) {
			this.parent = parent;
		}
		@Override
		public String toString() {
			return "Child [childId=" + childId + ", username=" + username + ", password=" + password + ", dob=" + dob
					+ ", gender=" + gender + ", mobile=" + mobile + ", email=" + email + ", address=" + address + "]";
		}
		
}
	
