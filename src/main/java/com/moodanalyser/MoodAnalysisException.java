package com.moodanalyser;

public class MoodAnalysisException extends Exception {
    enum ExceptionType {
        ENTEREDNULL, ENTEREDEMPTY
    }
    ExceptionType type;
    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
