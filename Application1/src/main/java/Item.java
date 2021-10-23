/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Patrick Brookshire
 */

import java.time.LocalDate;

public class Item {

    @Override
    public String toString(){
        String isComplete;
        if(getComplete().equals(true)) {
            isComplete = "completed";
        } else {
            isComplete = "incomplete";
        }
        return (this.getDate() + "\t" + this.getDescription() + " - " + isComplete);
    }


    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Boolean getComplete() {
        return complete;
    }
    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getCompletedBoolean(Boolean complete) {
        String temp;
        if(getComplete().equals(true)) {
            temp = "completed";
        } else {
            temp = "incomplete";
        }

        return temp;
    }

    //variables
    private String description;
    private LocalDate date;
    private Boolean complete;

    //constructor
    public Item(String description, LocalDate date, Boolean complete) {
        this.description = description;
        this.date = date;
        this.complete = complete;
    }

    public String getDescription() {
        return description;
    }

}
