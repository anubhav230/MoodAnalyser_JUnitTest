package com.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser(String... values) throws MoodAnalysisException {
        try {
            Class<?> moosAnalyserClass = Class.forName(values[0]);
           Class<?> param=Class.forName("java.lang."+values[2]);
            Constructor<?> moodConstructor = moosAnalyserClass.getConstructor(param);
            Object moodObj = moodConstructor.newInstance(values[1]);
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "wrong class");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "wrong method");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
