package com.moodanalyser;

public class MoodAnalyser {
    public String analyseMood(String message) {
        if (message.contains("I am in Sad mood"))
            return "Sad";
        else
            return "Happy";
    }
}
