package com.example.hp.hotelbooking;

/**
 * Created by kunai on 3/8/17.
 */

public class content {

    private String name,open ;
    private String rating ,openStatus;

    content(){
        name = "";
        openStatus = "";

    }

    public void setName(String name){
        this.name = name;
    }

    public void setStatus(String openStatus){
        this.openStatus = openStatus;
    }

    public String getName() {
        return name;
    }

    public String getOpenStatus() {
        return openStatus;
    }

    public void setOpenNow(String open) {
        this.open = open;
    }


    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getRating() {

        return rating;
    }

    public String getOpenNow() {
        return open;
    }
}

