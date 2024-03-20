package ru.nonoka.mapper;

import ru.nonoka.dto.EmployeeHandbookDto;

import java.util.List;

public interface Mapper<R, T> {
    List<EmployeeHandbookDto> toDto(T jsonEmployeeHandbook);
}
