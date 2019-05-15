package com.example.filedemo.model.response;

public class SemTypeArr
{
    private String topp;

    public String getTopp ()
    {
        return topp;
    }

    public void setTopp (String topp)
    {
        this.topp = topp;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [topp = "+topp+"]";
    }
}