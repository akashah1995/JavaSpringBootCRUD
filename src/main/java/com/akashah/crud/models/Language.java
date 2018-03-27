package com.akashah.crud.models;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



import java.util.*;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Language {
	
	

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@Size(min = 2, max = 20)
	public String name;
	
	@Column
	@Size(min = 2, max = 20)
	public String creator;
	
	@Column
	@NotNull
	public Float version;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date created_at;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updated_at;
	
	
	Language () {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	Language (String name, String creator, Float version){
		this.name = name;
		this.creator = creator;
		this.version = version;
	}
	
	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Float getVersion() {
		return version;
	}

	public void setVersion(Float version) {
		this.version = version;
	}

	
	

}
