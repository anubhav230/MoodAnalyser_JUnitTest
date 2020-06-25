package com.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.Objects;

public class MoodAnalyserReflector {
    public static MoodAnalyser createMoodAnalyser(String... values) throws MoodAnalysisException {
        try {
            Class<?> moosAnalyserClass = Class.forName(values[0]);
            Class<?> param = Class.forName("java.lang." + values[2]);
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

    public static Object invokeMethod(Object moodAnalyserObject, String methodName) throws MoodAnalysisException {
        try {

               return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);

        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "give proper method name");
        }catch (IllegalAccessException |InvocationTargetException  e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE, "method invocation issue");
        }

    }

    public static void setField(Object myObject, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            Field field = myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject, fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.INVALID_FIELD, "give proper field name");
        }catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.FIELD_SETTING_ISSUE, "issue while setting field value");
        }
    }
}
