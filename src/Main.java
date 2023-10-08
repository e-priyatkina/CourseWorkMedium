import java.util.Arrays;

public class Main {

    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        int i = 0;
        employees[i] = new Employee("Комиссаров Абрам Ростиславович", 3, 64000);
        i++;
        employees[i] = new Employee("Николаев Адриан Миронович", 1, 51000);
        i++;
        employees[i] = new Employee("Воронова Мила Семёновна", 2, 72000);
        i++;
        employees[i] = new Employee("Щукина Тамара Яковлевна", 5, 95000);
        i++;
        employees[i] = new Employee("Казаков Виссарион Германович", 4, 78000);
        i++;
        employees[i] = new Employee("Евдокимова Нонна Альбертовна", 4, 67000);
        i++;
        employees[i] = new Employee("Титов Виссарион Глебович", 1, 63000);;
        i++;
        employees[i] = new Employee("Силина Иветта Даниловна", 3, 75000);
        i++;
        employees[i] = new Employee("Зыкова Эдуарда Аркадьевна", 2, 83000);
        i++;
        employees[i] = new Employee("Шаров Петр Христофорович", 5, 91000);

        //вывод всех сотрудников
        printAllEmployees();

        System.out.println("Сумма затрат на зарплаты в месяц: " + countAllSalary());

        System.out.println("Сотрудник с минимальной зарплатой: " + minimumSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + maximumSalary());
        System.out.println("Среднее значение зарплат: " + averageSalary());

        //вывод всех ФИО сотрудников
        printAllFIO();


        System.out.println(Arrays.toString(indexSalary(1.07f))); //увеличиваем зарплату на 7%


        System.out.println("Минимальная зарплата сотрудника из 2 отдела: " + minimumSalaryDepartment(2));

        System.out.println("Максимальная зарплата сотрудника из 4 отдела: " + maximumSalaryDepartment(4));

        System.out.println("Сумма зарплат по 3 отделу: " + countAllSalaryDepartment(3));

        System.out.println("Средняя зарплата по 5 отделу: " + averageSalaryDepartment(5));

        System.out.println("Индексирование зарплаты по 2 отделу:");
        System.out.println(Arrays.toString(indexSalaryDepartment(2, 1.06f)));

        System.out.println("Сотрудники 3 отдела:");
        printEmployeesDepartment(3);

        System.out.println("Сотрудники с зарплатой меньше 72000:");
        lessNumber(72000);

        System.out.println("Сотрудники с зарплатой больше 72000:");
        moreNumber(72000);
    }

    public static void printAllEmployees() { //вывод списка всех сотрудников
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static float countAllSalary() { //сумма затрат на зарплаты
        float allSalary = 0;
        for (Employee employee : employees) {
            allSalary = allSalary + employee.getSalary();
        }
        return allSalary;
    }

    public static Employee minimumSalary() { //минимальная зарплата
        float min = Float.MAX_VALUE;
        Employee employee = null;
        for (Employee value : employees) {
            if (value.getSalary() < min) {
                min = value.getSalary();
                employee = value;
            }
        }
        return employee;
    }

    public static Employee maximumSalary() { //максимальная зарплата
        float max = Float.MIN_VALUE;
        Employee employee = null;
        for (Employee value : employees) {
            if (value.getSalary() > max) {
                max = value.getSalary();
                employee = value;
            }
        }
        return employee;
    }

    public static float averageSalary() { //средняя зарплата
        return countAllSalary() / employees.length;
    }

    public static void printAllFIO() { //вывод всех ФИО
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    public static Employee[] indexSalary(float index) { //увеличение зарплаты на %
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary(employees[i].getSalary() * index);
        }
        return employees;
    }

    public static Employee minimumSalaryDepartment (int department) { //минимальная зарплата по отделу
        float min = Float.MAX_VALUE;
        Employee employee = null;
        for (Employee value : employees) {
            if (value.getSalary() < min && value.getDepartment() == department) {
                min = value.getSalary();
                employee = value;
            }
        }
        return employee;
    }

    public static Employee maximumSalaryDepartment(int department) { //максимальная зарплата по отделу
        float max = Float.MIN_VALUE;
        Employee employee = null;
        for (Employee value : employees) {
            if (value.getSalary() > max && value.getDepartment() == department) {
                max = value.getSalary();
                employee = value;
            }
        }
        return employee;
    }

    public static float countAllSalaryDepartment(int department) { //общая зарплата по отделу
        float allSalary = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                allSalary = allSalary + employee.getSalary();
            }
        }
        return allSalary;
    }

    public static float averageSalaryDepartment(int department) { //средняя зарплата по отделу
        float average = 0;
        int k = 0; //количество сотрудников
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                average = countAllSalaryDepartment(department);
                k++;
            }
        }
        average = average / k;
        return average;
    }

    public static Employee[] indexSalaryDepartment(int department, float index) { //увеличение зарплаты в отделе

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                employees[i].setSalary(employees[i].getSalary() * index);
            }
        }
        return employees;
    }

    public static void printEmployeesDepartment(int department) { //вывод списка сотрудников отдела
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println(employee.getId() + " " + employee.getFullName() + " " + employee.getSalary());
            }
        }
    }

    public static void lessNumber(int number) { //зарплата меньше числа
        for (Employee value : employees) {
            if (value.getSalary() < number) {
                System.out.println(value.getId() + " " + value.getFullName() + " " + value.getSalary());
            }
        }
    }

    public static void moreNumber(int number) { //зарплата больше числа
        for (Employee value : employees) {
            if (value.getSalary() >= number) {
                System.out.println(value.getId() + " " + value.getFullName() + " " + value.getSalary());
            }
        }
    }
}
