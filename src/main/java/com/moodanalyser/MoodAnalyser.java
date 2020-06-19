package com.moodanalyser;

public class MoodAnalyser {
    String mood;

    public MoodAnalyser(String mood) {
        this.mood = mood;
    }

    public String analyseMood() {
        try {
            if (mood.contains("I am in Sad mood"))
                return mood = "Sad";
            else
                return mood = "Happy";
        } catch (NullPointerException empty) {
            return "Happy";
        }
    }
}
