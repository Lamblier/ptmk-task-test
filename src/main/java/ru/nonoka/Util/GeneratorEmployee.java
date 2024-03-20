package ru.nonoka.Util;

import ru.nonoka.dto.EmployeeHandbookDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static ru.nonoka.entity.Gender.Female;
import static ru.nonoka.entity.Gender.Male;

public class GeneratorEmployee {
    public static List<EmployeeHandbookDto> getFilledPersonCollection() {
        List<String> firstName = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> lastName = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Funtick");
        List<String> patronymic = Arrays.asList("Ivanovich", "Petrovich", "Sidorovna", "Markelovna", "Pingvinovich", "Baralginovich", "Brown");

        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();

        List<EmployeeHandbookDto> employees = new ArrayList<>();
        for (
                int i = 0;
                i < 1_000_000; i++) {
            employees.add(new EmployeeHandbookDto(
                    firstName.get(new Random().nextInt(firstName.size())),
                    lastName.get(new Random().nextInt(lastName.size())),
                    patronymic.get(new Random().nextInt(lastName.size())),
                    LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(minDay, maxDay)),
                    i > 500000 ? Female : Male
            ));
        }
        return employees;
    }
}
