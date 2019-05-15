package com.example.filedemo.model.response;

public class Phrases
{
    private Entities[] entities;

    private String text;

    private Tag tag;

    public Entities[] getEntities ()
    {
        return entities;
    }

    public void setEntities (Entities[] entities)
    {
        this.entities = entities;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public Tag getTag ()
    {
        return tag;
    }

    public void setTag (Tag tag)
    {
        this.tag = tag;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [entities = "+entities+", text = "+text+", tag = "+tag+"]";
    }
}