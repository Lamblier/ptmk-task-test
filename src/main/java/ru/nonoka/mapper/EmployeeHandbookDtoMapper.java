package ru.nonoka.mapper;

import ru.nonoka.dto.EmployeeHandbookDto;
import ru.nonoka.entity.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeHandbookDtoMapper implements Mapper<EmployeeHandbookDto, String[]> {

    @Override
    public List<EmployeeHandbookDto> toDto(String[] args) {
        List<EmployeeHandbookDto> employeeHandbookDtos = new ArrayList<>();
        String[] employees = Arrays.copyOfRange(args, 1, args.length);
        if (employees.length % 3 != 0) {
            System.out.println("Недостаточно аргументов. Пример использования: myApp 2 \"Ivanov Petr Sergeevich\" 2009-07-12 Male, \"Petrov Ivan Ivanovich\" 1995-03-25 Female");
            throw new RuntimeException();
        }

        String firstName;
        String lastName;
        String patronymic;
        LocalDate birthDate;
        Gender gender;

        for (int i = 0; i < employees.length; ) {
            String[] employeeNames = employees[i++].trim().split(" ");
            firstName = employeeNames[0];
            lastName = employeeNames[1];
            patronymic = employeeNames[2];
            birthDate = LocalDate.parse(employees[i++]);
            gender = Gender.valueOf(employees[i++].replace(",", ""));
            employeeHandbookDtos.add(new EmployeeHandbookDto(firstName, lastName, patronymic, birthDate, gender));
        }
        return employeeHandbookDtos;
    }
}
