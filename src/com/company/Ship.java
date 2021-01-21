package com.company;

import java.util.ArrayList;

public class Ship
{
    private ArrayList<String> locationField;
    public void setLocationField(ArrayList<String> location)
    {
        locationField = location;
    }
    public String check(String move)
    {
        String score = "miss";
        int index = locationField.indexOf(move);
        if(index >= 0)
        {
            locationField.remove(index);
            if(locationField.isEmpty())
            {
                score = "kill";
            }
            else
            {
                score = "hit";
            }
        }
        return score;
    }
    private String name;
    public void setName(String string) { name = string; }
}
