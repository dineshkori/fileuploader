package com.example.filedemo.model.response;

public class Lr_classifier_2
{
    private LR_Classifier[] LR_Classifier;

    public LR_Classifier[] getLR_Classifier ()
    {
        return LR_Classifier;
    }

    public void setLR_Classifier (LR_Classifier[] LR_Classifier)
    {
        this.LR_Classifier = LR_Classifier;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [LR_Classifier = "+LR_Classifier+"]";
    }
}