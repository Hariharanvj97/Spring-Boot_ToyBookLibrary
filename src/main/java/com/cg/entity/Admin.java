package com.cg.entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.context.spi.CurrentSessionContext;
import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("unused")
@Entity
public class Admin  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="admin_id")
	 private int adminId;
	 @Column(name="user_name")
	 private String username;
	 @Column(name="password")
	 private String password;
	@Column(name="gender")
  	 private String gender;
    @Column(name="mobile_number")
  	 private String mobile;
  	@Column(name="email_id")
  	 private String email;
	@Column(name="address")
  	 private String address;
	
	
	public Admin() {
		super();
	}
	public Admin(int adminId, String username, String password, String gender, String mobile, String email,
			String address) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", username=" + username + ", password=" + password + ", gender=" + gender
				+ ", mobile=" + mobile + ", email=" + email + ", address=" + address + "]";
	}

	
}
