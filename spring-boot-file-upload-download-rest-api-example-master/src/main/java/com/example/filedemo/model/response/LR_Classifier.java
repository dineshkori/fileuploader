package com.example.filedemo.model.response;

public class LR_Classifier
{
    private String conclusion;

    private String prediction;

    private String tag;

    private String type;

    public String getConclusion ()
    {
        return conclusion;
    }

    public void setConclusion (String conclusion)
    {
        this.conclusion = conclusion;
    }

    public String getPrediction ()
    {
        return prediction;
    }

    public void setPrediction (String prediction)
    {
        this.prediction = prediction;
    }

    public String getTag ()
    {
        return tag;
    }

    public void setTag (String tag)
    {
        this.tag = tag;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [conclusion = "+conclusion+", prediction = "+prediction+", tag = "+tag+", type = "+type+"]";
    }
}