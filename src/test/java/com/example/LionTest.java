package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LionTest {
    @Spy
    Feline feline;

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false",
    })

    void getSexCorrectValue(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Неизвестный",
            "самец",
            "самка",
            "",
            " "
    })

    void getSexInvalidValueTrowsException(String invalidSex) throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion(invalidSex);
        });

        assertEquals(
                "Используйте допустимые значения пола животного - Самец или Самка",
                exception.getMessage(),
                "Сообщение об ошибке должно быть одинаковым для всех неверных значений"
        );
    }

    @Test
    void getKittens() {
        when(feline.getKittens()).thenReturn(5);
        Lion lion = new Lion(feline);
        int result = lion.getKittens();
        assertEquals(5, result);
    }

    @Test
    void getFood() throws Exception {
        Lion lion = new Lion(feline);
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        verify(feline, Mockito.times(1)).eatMeat();
        assertEquals(expected, actual);
    }
}
