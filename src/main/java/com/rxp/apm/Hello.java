package com.rxp.apm;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Hello {

	private int id;
	private String title;
	private String description;
	private String createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("id", id);
		builder.append("title", title);
		builder.append("description", description);
		builder.append("createdAt", createdAt);
		return builder.toString();
	}

}
