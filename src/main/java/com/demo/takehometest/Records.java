package com.demo.takehometest;
import org.json.JSONObject;
public class Records {
    private int score;
    private String id;

    public Records(int score, String id){
        this.score= score;
        this.id= id;
    }

    public int getScore(){
        return score;
    }

    public String getId(){
        return id;
    }

    public JSONObject toJson(){
        JSONObject json= new JSONObject();
        json.put("score", score);
        json.put("id", id);
        return json;
    }
}
