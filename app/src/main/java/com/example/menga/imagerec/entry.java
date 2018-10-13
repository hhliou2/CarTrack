package com.example.menga.cartrack;

public class entry {
    private String color;
    private float value;
    private String hex;
    public entry(String colour, float val, String hexs){
        color = colour;
        value = val;
        hex = hexs;
    }
    public String getColor(){return color;}
    public String getHex(){return hex;}
    public float getValue(){return value;}
    public void setColor(String colour){color=colour;}
    public void setHex(String hexs){hex=hexs;}
    public void setValue(float val){value = val;}
}
