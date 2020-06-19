package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void giveMassage_WhenSad_ShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("Sad", mood);
    }

    @Test
    public void givenMassage_WhenHappy_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("Happy", mood);
    }

    @Test
    public void givenMassage_WhenNull_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("Happy", mood);
    }
}
