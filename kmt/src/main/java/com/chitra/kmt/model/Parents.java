package com.chitra.kmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APP_PARENTS")
public class Parents {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "P_ID")
	private int id;
	
	private String motherName;
	private String motherPhone;
	private String fatherName;
	private String fatherPhone;
	 
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getMotherPhone() {
		return motherPhone;
	}
	public void setMotherPhone(String motherPhone) {
		this.motherPhone = motherPhone;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getFatherPhone() {
		return fatherPhone;
	}
	public void setFatherPhone(String fatherPhone) {
		this.fatherPhone = fatherPhone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
