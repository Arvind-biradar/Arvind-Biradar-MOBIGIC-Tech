package com.mobigic.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="files")
public class Filedata {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String filename;
	private String path;
	private int unicode;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Filedata () {
		super();
	}
	
	public Filedata(int id, String filename, String path, int unicode, User user) {
		super();
		this.id = id;
		this.filename = filename;
		this.path = path;
		this.unicode = unicode;
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getData() {
		return path;
	}
	public void setData(String data) {
		this.path = data;
	}
	public int getUnicode() {
		return unicode;
	}
	public void setUnicode(int unicode) {
		this.unicode = unicode;
	}
	@Override
	public String toString() {
		return "Filedata [id=" + id + ", filename=" + filename + ", path=" + path + ", unicode=" + unicode + ", user="
				+ user + "]";
	}
	
	
	
	
}
