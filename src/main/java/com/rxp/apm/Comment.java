package com.rxp.apm;

public class Comment
{
    private String id;

    private String content;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", content = "+content+"]";
    }
}
