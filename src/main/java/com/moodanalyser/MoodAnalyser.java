package com.moodanalyser;

public class MoodAnalyser {
    String mood;

    /**
     * parameterized constructor
     * @param mood
     */
    public MoodAnalyser(String mood) {
        this.mood = mood;
    }

    /**
     * method for checking mood with null
     * @return
     */
    public String analyseMood() throws MoodAnalysisException {
        try {
            if (mood.length() == 0)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.EnteredEmpty, "Enter correct message");
            if (mood.contains("I am in Sad mood"))
                return "Sad";
            else
                return "Happy";
        } catch (NullPointerException empty) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.EnteredNull, "Enter correct message");
        }
    }
}
