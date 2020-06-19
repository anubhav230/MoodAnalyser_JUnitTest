package com.moodanalyser;

public class MoodAnalyser {
    String mood;

    public MoodAnalyser(String mood) {
        this.mood = mood;
    }

    public String analyseMood() {
        if (mood.contains("I am in Sad mood"))
            mood = "Sad";
        if (mood.contains("I am in Happy mood"))
            mood = "Happy";

        return mood;
    }
}
