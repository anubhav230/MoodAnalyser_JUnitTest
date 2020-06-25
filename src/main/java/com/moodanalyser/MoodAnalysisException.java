package com.moodanalyser;

public class MoodAnalysisException extends Exception {
    enum ExceptionType {
        ENTEREDNULL, ENTEREDEMPTY, NO_SUCH_CLASS, NO_SUCH_METHOD,METHOD_INVOCATION_ISSUE, INVALID_FIELD,
        FIELD_SETTING_ISSUE

    }
    ExceptionType type;
    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
