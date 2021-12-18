package com.example.hamoudApp.models;

public class oneTask {
    private String idTask;
    private String title;
    private String date ;
    private String time ;
    private String message ;
    private String vocal_path;

    public oneTask(String idTask, String title, String date, String time, String message , String vocal_path) {
        this.idTask = idTask;
        this.title = title;
        this.date = date;
        this.time = time;
        this.message = message;
        this.vocal_path = vocal_path ;
    }

    public String getVocal_path() {
        return vocal_path;
    }

    public String getIdTask() {
        return idTask;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }
}
