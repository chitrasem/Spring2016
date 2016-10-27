package com.chitra.kms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ClassLevel {
	
	@Id
	@Column(name="cl_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name="level_name")
	private String levelName;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "APP_ClASS_LEVEL_CLASSROOM", 
             joinColumns = { @JoinColumn(name = "cl_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "c_room_id") })
    private Set<Classroom> classRoom = new HashSet<Classroom>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Set<Classroom> getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(Set<Classroom> classRoom) {
		this.classRoom = classRoom;
	}
	

}
