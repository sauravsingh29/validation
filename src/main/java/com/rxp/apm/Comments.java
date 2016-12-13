package com.rxp.apm;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comments
{
	@JsonProperty("comment")
	private List<Comment> comments = new ArrayList<>();
	

    public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [comment = "+comments+"]";
    }
}
