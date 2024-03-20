package ru.nonoka.dto;

import ru.nonoka.entity.Gender;

import java.time.LocalDate;

public record EmployeeHandbookDto(
        String firstName,
        String lastName,
        String patronymic,
        LocalDate birthDay,
        Gender gender
) {
}
