package com.moodanalyser.exception;

public class MoodAnalysisException extends Exception {
    public enum ExceptionType {
        ENTEREDNULL, ENTEREDEMPTY, NO_SUCH_CLASS, NO_SUCH_METHOD,METHOD_INVOCATION_ISSUE, INVALID_FIELD,
        FIELD_SETTING_ISSUE, NULL_VALUE
    }
    public ExceptionType type;
    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
