package ru.nonoka.dao;

import ru.nonoka.dto.EmployeeHandbookDto;
import ru.nonoka.dto.EmployeeHandbookView;
import ru.nonoka.entity.EmployeeHandbook;

import java.util.List;

public interface DaoEmployees {

    void createTableEmployees();

    void create(List<EmployeeHandbookDto> employeeHandbookDto);

    List<EmployeeHandbookView> getDistinctEmployeeHandbook();

    List<EmployeeHandbook> findAllByGenderAndLastName();
}
