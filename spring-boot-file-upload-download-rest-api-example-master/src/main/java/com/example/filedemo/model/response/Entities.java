package com.example.filedemo.model.response;

public class Entities
{
    private SemTypeArr[] semTypeArr;

    private String score;

    private String conceptName;

    private String cui;

    private String[] masterType;

    private String semType;

    private Position[] position;

    private String[] matchedWords;

    public SemTypeArr[] getSemTypeArr ()
    {
        return semTypeArr;
    }

    public void setSemTypeArr (SemTypeArr[] semTypeArr)
    {
        this.semTypeArr = semTypeArr;
    }

    public String getScore ()
    {
        return score;
    }

    public void setScore (String score)
    {
        this.score = score;
    }

    public String getConceptName ()
    {
        return conceptName;
    }

    public void setConceptName (String conceptName)
    {
        this.conceptName = conceptName;
    }

    public String getCui ()
    {
        return cui;
    }

    public void setCui (String cui)
    {
        this.cui = cui;
    }

    public String[] getMasterType ()
    {
        return masterType;
    }

    public void setMasterType (String[] masterType)
    {
        this.masterType = masterType;
    }

    public String getSemType ()
    {
        return semType;
    }

    public void setSemType (String semType)
    {
        this.semType = semType;
    }

    public Position[] getPosition ()
    {
        return position;
    }

    public void setPosition (Position[] position)
    {
        this.position = position;
    }

    public String[] getMatchedWords ()
    {
        return matchedWords;
    }

    public void setMatchedWords (String[] matchedWords)
    {
        this.matchedWords = matchedWords;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [semTypeArr = "+semTypeArr+", score = "+score+", conceptName = "+conceptName+", cui = "+cui+", masterType = "+masterType+", semType = "+semType+", position = "+position+", matchedWords = "+matchedWords+"]";
    }
}
			