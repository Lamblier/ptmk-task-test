package ru.nonoka.dto;

import java.time.LocalDate;

public record EmployeeHandbookView(
        String firstName,
        String lastName,
        String patronymic,
        LocalDate birthDay
) {
}
