package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FelineTest {
    @Spy
    Feline feline;

    @Test
    void eatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");

    }

    @Test
    void getFamily() {
        String actual = feline.getFamily();
        assertEquals("Кошачьи", actual);
    }

    @Test
    void getKittensDefault() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);

    }

    @Test
    void getKittensWithCount() {
        int actual = feline.getKittens(3);
        assertEquals(3,actual);
    }
}
