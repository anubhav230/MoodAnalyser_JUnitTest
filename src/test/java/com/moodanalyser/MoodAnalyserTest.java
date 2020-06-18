package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

     @Test
     public void giveMassage_WhenSad_ShouldReturnSad() {
         MoodAnalyser moodAnalyser = new MoodAnalyser();
         String mood = moodAnalyser.analyseMood("Sad mood");
         Assert.assertEquals("Sad", mood);
     }
     @Test
     public void givenMassage_WhenHappy_ShouldReturnHappy() {
         MoodAnalyser moodAnalyser = new MoodAnalyser();
         String mood = moodAnalyser.analyseMood("Happy mood");
         Assert.assertEquals("Happy", mood);

     }

}
