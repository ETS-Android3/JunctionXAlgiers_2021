package com.example.hamoudApp.models;

public class myWorkersList {
    private String workerText;
    private String stateText ;

    public myWorkersList(String workerText, String stateText) {
        this.workerText = workerText;
        this.stateText = stateText;
    }

    public String getWorkerText() {
        return workerText;
    }

    public void setWorkerText(String workerText) {
        this.workerText = workerText;
    }

    public String getStateText() {
        return stateText;
    }

    public void setStateText(String stateText) {
        this.stateText = stateText;
    }

}
