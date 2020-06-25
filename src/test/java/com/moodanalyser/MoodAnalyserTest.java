package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class MoodAnalyserTest {


    @Test
    public void giveMassage_WhenSad_ShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad mood");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalysisException.class);
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMassage_WhenHappy_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy mood");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalysisException.class);
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMassage_WhenNull_ShouldThrowException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalysisException.class);
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMassage_WhenEmpty_ShouldThrowException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalysisException.class);
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMassage_WhenNull_ShouldThrowException_WithoutExceptionRule() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTEREDNULL, e.type);
        }
    }

    @Test
    public void givenMassage_WhenEmpty_ShouldThrowException_WithoutExceptionRule() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTEREDEMPTY, e.type);
        }
    }
//    ////////////////
//    @Test
//    public void givenMoodAnalyserClass_WhenProper_shouldReturnObject() throws MoodAnalysisException {
//        MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser("com.moodanalyser.MoodAnalyser","I am in Happy mood", "String.class");
//        try {
//            String mood = moodAnalyser.analyseMood();
//            Assert.assertEquals("Happy", mood);
//        } catch (MoodAnalysisException e) {
//            e.printStackTrace();
//        }
//    }
//    ///////////////
//    @Test
//    public void givenMoodAnalyserClass2_WhenProper_shouldReturnObject() throws MoodAnalysisException {
//        MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser("com.moodanalyser.MoodAnalyser","I am in Happy mood", "String.class");
//        Assert.assertEquals(new MoodAnalyser("I am in Happy mood"), moodAnalyser);
//    }

    @Test
    public void givenMoodAnalyserClass_WhenWrongMethodName_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyserReflector.createMoodAnalyser("com.moodanalyser.Analyser", "I am in Happy mood","String.class");
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalysisWithParametrizedConstructor_WhenImproper_ShouldThrowMoodAnalysisException() {
        try {
            MoodAnalyserReflector.createMoodAnalyser("com.moodanalyser.MoodAnalyser", "I am in Happy mood", "Double");
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }

    //6.1
    @Test
    public void givenMoodAnalyserClass_WhenReflector_shouldReturnObject(){
        try {
            Object MyObject =  MoodAnalyserReflector.createMoodAnalyser("I am Happy mood");
            Object analyseMood = MoodAnalyserReflector.invokeMethod(MyObject, "analyseMood");
            Assert.assertEquals("Happy", analyseMood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    //6.2
    @Test
    public void givenMoodAnalyserClass_WhenReflector_shouldThrowException(){
        try {
            Object MyObject =  MoodAnalyserReflector.createMoodAnalyser("com.moodanalyser.MoodAnalyser", "I am in Happy mood", "String");
            Object analyseMood = MoodAnalyserReflector.invokeMethod(MyObject, "Mood");
            Assert.assertEquals("Happy", analyseMood);
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }

    //7.1
    @Test
    public void giveMoodAnalyser_OnChangMood_shouldReturnHappy (){
        try {
            Object MyObject =  MoodAnalyserReflector.createMoodAnalyser("com.moodanalyser.MoodAnalyser", "I am in Happy mood", "String");
            MoodAnalyserReflector.setField(MyObject,"mood", "I am in Happy mood");
            Object analyseMood = MoodAnalyserReflector.invokeMethod(MyObject, "analyseMood");
            Assert.assertEquals("Happy", analyseMood);
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }

    //7.2
    @Test
    public void giveMoodAnalyser_WhileInvalidField_shouldThrowException (){
        try {
            Object MyObject =  MoodAnalyserReflector.createMoodAnalyser("com.moodanalyser.MoodAnalyser", "I am in Happy mood", "String");
            MoodAnalyserReflector.setField(MyObject,"mood", "I am in Happy mood");
            Object analyseMood = MoodAnalyserReflector.invokeMethod(MyObject, "analyseMood");
            Assert.assertEquals("Happy", analyseMood);
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void giveMoodAnalyser_WhileFieldValueIsEmpty_shouldThrowException (){
        try {
            Object MyObject =  MoodAnalyserReflector.createMoodAnalyser("com.moodanalyser.MoodAnalyser", "I am in Happy mood", "String");
            MoodAnalyserReflector.setField(MyObject,"mood", "");
            Object analyseMood = MoodAnalyserReflector.invokeMethod(MyObject, "analyseMood");
            Assert.assertEquals("Happy", analyseMood);
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }

}
