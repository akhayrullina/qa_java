package com.example;

import java.util.List;

public class LionAlex extends Lion {

    protected LionAlex() throws Exception {
        super("Самец", null);
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public List<String> getFriends() {
        return List.of("Зебра Марти", "Бегемотиха Глория", "жирафа Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
}
