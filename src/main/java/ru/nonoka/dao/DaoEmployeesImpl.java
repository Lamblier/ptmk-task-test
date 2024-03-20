package ru.nonoka.dao;

import ru.nonoka.datasource.ConnectionFactory;
import ru.nonoka.dto.EmployeeHandbookDto;
import ru.nonoka.dto.EmployeeHandbookView;
import ru.nonoka.entity.EmployeeHandbook;
import ru.nonoka.entity.Gender;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DaoEmployeesImpl implements DaoEmployees {

    private static String CREATE_TABLE_EMPLOYEE_HANDBOOK = """
            create table IF NOT EXISTS employee_handbook(
                                               id BIGSERIAL PRIMARY KEY,
                                               first_name VARCHAR(128) NOT NULL,
                                               last_name VARCHAR(128) NOT NULL,
                                               patronymic VARCHAR(128) NOT NULL,
                                               birth_day date NOT NULL,
                                               gender VARCHAR(25) NOT NULL
                                           );
            """;

    private static String INSERT_EMPLOYEE_QUERY = """
            INSERT INTO employee_handbook 
            (first_name, last_name, patronymic, birth_day, gender)
            VALUES (?, ?, ?, ?, ?);
            """;

    private static String FIND_DISTINCT_EMPLOYEE_QUERY = """
            SELECT DISTINCT eh.first_name, eh.last_name, 
            eh.patronymic, eh.birth_day FROM employee_handbook as eh
                                  ORDER BY eh.first_name, eh.last_name, eh.patronymic;
            """;

    private static String FIND_EMPLOYEE_GENDER_AND_LASTNAME_FIRST_LETTER_QUERY = """
            SELECT * FROM employee_handbook
                                  WHERE GENDER = 'Male'
                                  AND last_name LIKE 'F%';
            """;

    @Override
    public void createTableEmployees() {
        try (Connection connection = ConnectionFactory.getDataSource().getConnection();
             var ps = connection.prepareStatement(CREATE_TABLE_EMPLOYEE_HANDBOOK)) {
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public void create(List<EmployeeHandbookDto> employeeHandbookDtos) {
        try (Connection connection = ConnectionFactory.getDataSource().getConnection();
             var ps = connection.prepareStatement(INSERT_EMPLOYEE_QUERY)) {
            for (EmployeeHandbookDto employeeHandbookDto : employeeHandbookDtos) {
                ps.setString(1, employeeHandbookDto.firstName());
                ps.setString(2, employeeHandbookDto.lastName());
                ps.setString(3, employeeHandbookDto.patronymic());
                ps.setObject(4, employeeHandbookDto.birthDay());
                ps.setObject(5, employeeHandbookDto.gender().name());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<EmployeeHandbookView> getDistinctEmployeeHandbook() {
        List<EmployeeHandbookView> employeeHandbooks = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getDataSource().getConnection();
             var ps = connection.prepareStatement(FIND_DISTINCT_EMPLOYEE_QUERY)) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                employeeHandbooks.add(new EmployeeHandbookView(
                        resultSet.getObject("first_name", String.class),
                        resultSet.getObject("last_name", String.class),
                        resultSet.getObject("patronymic", String.class),
                        resultSet.getObject("birth_day", LocalDate.class)
                ));
            }
            return employeeHandbooks;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EmployeeHandbook> findAllByGenderAndLastName() {
        List<EmployeeHandbook> employeeHandbooks = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getDataSource().getConnection();
             var ps = connection.prepareStatement(FIND_EMPLOYEE_GENDER_AND_LASTNAME_FIRST_LETTER_QUERY)) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                employeeHandbooks.add(new EmployeeHandbook(
                        resultSet.getObject("id", Long.class),
                        resultSet.getObject("first_name", String.class),
                        resultSet.getObject("last_name", String.class),
                        resultSet.getObject("patronymic", String.class),
                        resultSet.getObject("birth_day", LocalDate.class),
                        Gender.valueOf(resultSet.getObject("gender", String.class))
                ));
            }
            return employeeHandbooks;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
