package ru.nonoka;

import ru.nonoka.service.EmployeesService;

public class Main {
    public static void main(String[] args) {
        EmployeesService employeesService = new EmployeesService();

        if (args.length > 0) {
            int mode = Integer.parseInt(args[0]);
            switch (mode) {
                case 1:
                    System.out.println("Режим работы 1");
                    employeesService.createTableEmployees();
                    System.out.println("Таблица создана");
                    break;
                case 2:
                    System.out.println("Режим работы 2");
                    if (args.length < 2) {
                        System.out.println("Недостаточно аргументов. Пример использования: myApp 2 \"Ivanov Petr Sergeevich\" 2009-07-12 Male, \"Petrov Ivan Ivanovich\" 1995-03-25 Male");
                        return;
                    }
                    employeesService.create(args);
                    System.out.println("Сотрудники добавлены");
                    break;
                case 3:
                    System.out.println("Режим работы 3");
                    employeesService.getDistinctEmployeeHandbook().forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Режим работы 4");
                    employeesService.generateLargeEmployees();
                    System.out.println("Автодобавление 1_000_000 сотрудников прошло успешно");
                    break;
                case 5:
                    System.out.println("Режим работы 5");
                    long startTime = System.currentTimeMillis();

                    employeesService.findAllByGenderAndLastName().forEach(System.out::println);
                    long endTime = System.currentTimeMillis();

                    System.out.println("Потрачено на запрос " + (endTime - startTime) + " milliseconds");
                    break;
                default:
                    System.out.println("Неизвестный режим");
            }
        } else {
            System.out.println("Пожалуйста, укажите режим работы.");
        }

    }

}