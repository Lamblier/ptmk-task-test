package ru.nonoka.service;

import ru.nonoka.Util.GeneratorEmployee;
import ru.nonoka.dao.DaoEmployees;
import ru.nonoka.dao.DaoEmployeesImpl;
import ru.nonoka.dto.EmployeeHandbookDto;
import ru.nonoka.dto.EmployeeHandbookView;
import ru.nonoka.entity.EmployeeHandbook;
import ru.nonoka.mapper.EmployeeHandbookDtoMapper;

import java.util.List;

public class EmployeesService {

    DaoEmployees daoEmployees = new DaoEmployeesImpl();
    EmployeeHandbookDtoMapper mapper = new EmployeeHandbookDtoMapper();

    public void createTableEmployees() {
        daoEmployees.createTableEmployees();
    }

    public void create(String[] employeeJson) {
        List<EmployeeHandbookDto> handbookDtos = mapper.toDto(employeeJson);
        daoEmployees.create(handbookDtos);
    }

    public List<EmployeeHandbookView> getDistinctEmployeeHandbook() {
        return daoEmployees.getDistinctEmployeeHandbook();
    }

    public void generateLargeEmployees() {
        daoEmployees.create(GeneratorEmployee.getFilledPersonCollection());
    }

    public List<EmployeeHandbook> findAllByGenderAndLastName() {
        return daoEmployees.findAllByGenderAndLastName();
    }
}
