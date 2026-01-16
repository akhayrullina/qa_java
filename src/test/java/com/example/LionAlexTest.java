package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LionAlexTest {

    @Test
    void getKittens() throws Exception {
        LionAlex lionAlex = new LionAlex();
        assertEquals(0, lionAlex.getKittens());
    }

    @Test
    void getFriends() throws Exception {
        LionAlex lionAlex = new LionAlex();
        List<String> expected = List.of("Зебра Марти", "Бегемотиха Глория", "жирафа Мелман");
        List<String> actual = lionAlex.getFriends();
        assertEquals(expected,actual);
    }

    @Test
    void getPlaceOfLiving() throws Exception {
        LionAlex lionAlex = new LionAlex();
        String expected = "Нью-Йоркский зоопарк";
        String actual = lionAlex.getPlaceOfLiving();
        assertEquals(expected,actual);
    }
}
