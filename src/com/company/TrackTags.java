package com.company;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by reinout on 11/10/16.
 */
public class TrackTags {
    public String Title=null;
    public String Performer=null;
    public String Songwriter=null;
    public float CutPoint=0;
    public String ISRC=null;
    public boolean finished=false;
    public final StringProperty title() {
        StringProperty s = new SimpleStringProperty();
        s.set(this.Title);
        return s;
    }
    public final StringProperty performer(){
        StringProperty s= new SimpleStringProperty();
        s.set(this.Performer);
        return s;
    }

    public void SetCutPoint(String s){
        s = s.replaceAll("^\"+", "").replaceAll("\"+$", "");
        String[] splitTime=s.split(":");
        if(splitTime[2]!=null&&splitTime[2].length()<3)
            splitTime[2]=splitTime[2].concat("0");
        CutPoint=Float.parseFloat(splitTime[0])*60+Float.parseFloat(splitTime[1])+Float.parseFloat(splitTime[2])/1000;

    }
    public void Clean() {
        if (Title != null)
            Title = Title.replaceAll("^\"+", "").replaceAll("\"+$", "");
        if (Performer != null)
            Performer = Performer.replaceAll("^\"+", "").replaceAll("\"+$", "");
        if (Songwriter != null)
            Songwriter = Songwriter.replaceAll("^\"+", "").replaceAll("\"+$", "");
        if (ISRC != null)
            ISRC = ISRC.replaceAll("^\"+", "").replaceAll("\"+$", "");
    }
}
