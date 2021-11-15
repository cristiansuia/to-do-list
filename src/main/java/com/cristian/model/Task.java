package com.cristian.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private Long id;
	@Column
	private String username;
	@Column
    private String desc;
	@Column
    private String lastUpdate;
	@Column
    private Boolean isDone = false;
	
	public Task() {}
    
    
    public Task(long id, String username, String desc, String lastUpdate, boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.desc = desc;
		this.lastUpdate = lastUpdate;
		this.isDone = isDone;
	}
  
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public Boolean isDone() {
		return isDone;
	}
	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}
   
}
