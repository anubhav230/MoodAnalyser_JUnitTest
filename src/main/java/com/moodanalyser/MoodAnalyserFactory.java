package com.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser(String message) {
        try {
            Class<?> moosAnalyserClass = Class.forName("com.moodanalyser.MoodAnalyser");
            Constructor<?> moodConstructor = moosAnalyserClass.getConstructor(String.class);
            Object moodObj = moodConstructor.newInstance(message);
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor<?> getConstructor(String className) throws MoodAnalysisException {
        Class<?> moodAnalyserClass;
        try {
            moodAnalyserClass = Class.forName(className);
            try {
                return moodAnalyserClass.getConstructor(Class.forName(className));
            } catch (NoSuchMethodException e) {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.getMessage());
        }
    }

    public static MoodAnalyser createMoodAnalyser(Constructor<?> moodAnalyserConstructor, String i_am_in_happy_mood) throws IllegalAccessException, InvocationTargetException, InstantiationException {
    return (MoodAnalyser) moodAnalyserConstructor.newInstance();
    }
}
