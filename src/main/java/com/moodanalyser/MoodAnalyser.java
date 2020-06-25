package com.moodanalyser;

import java.util.Objects;

public class MoodAnalyser {
    private String mood;

    public MoodAnalyser() {

    }

    /**
     * parameterized constructor
     *
     * @param mood
     */
    public MoodAnalyser(String mood) {
        this.mood = mood;
    }

    public String analyseMood(String mood) throws MoodAnalysisException {
        this.mood = mood;
        return analyseMood();
    }

    /**
     * method for checking mood with null
     *
     * @return
     */
    public String analyseMood() throws MoodAnalysisException {
        try {
            if (mood.length() == 0)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTEREDEMPTY, "Enter correct message");
            if (mood.contains("I am in Sad mood"))
                return "Sad";
            else
                return "Happy";
        } catch (NullPointerException empty) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTEREDNULL, "Enter correct message");
        }
    }

    public boolean equals(MoodAnalyser other) {
        if (this.mood.equals(other.mood))
            return true;
        return false;
    }
}
