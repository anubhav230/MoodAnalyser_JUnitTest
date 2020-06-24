package com.moodanalyser;

public class MoodAnalysisException extends Exception {
    enum ExceptionType {
        ENTEREDNULL, ENTEREDEMPTY, NO_SUCH_CLASS, NO_SUCH_METHOD

    }
    ExceptionType type;
    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
