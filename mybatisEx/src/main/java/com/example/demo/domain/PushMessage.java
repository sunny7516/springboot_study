package com.example.demo.domain;

import java.time.LocalDateTime;

public class PushMessage {
	private Long id;
	private String content;
	private String status;
	
	private String created_by;
	private LocalDateTime created_at;
	private LocalDateTime last_modified_at;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getLast_modified_at() {
		return last_modified_at;
	}
	public void setLast_modified_at(LocalDateTime last_modified_at) {
		this.last_modified_at = last_modified_at;
	}
	@Override
	public String toString() {
		return "PushMessage [id=" + id + ", content=" + content + ", status=" + status + ", created_by=" + created_by
				+ ", created_at=" + created_at + ", last_modified_at=" + last_modified_at + "]";
	}
	
	
}
