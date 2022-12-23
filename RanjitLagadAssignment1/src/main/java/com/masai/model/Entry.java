package com.masai.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entry {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String Title;
	private String Description;
	private Boolean https;
	private String Core;
	private String Auth;
	private String Category;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Boolean getHttps() {
		return https;
	}
	public void setHttps(Boolean https) {
		this.https = https;
	}
	public String getCore() {
		return Core;
	}
	public void setCore(String core) {
		Core = core;
	}
	public String getAuth() {
		return Auth;
	}
	public void setAuth(String auth) {
		Auth = auth;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	
	
	

}
