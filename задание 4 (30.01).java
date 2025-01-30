import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class DateTimeTasks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите задание (1-15):");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        switch (taskNumber) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
            case 4:
                task4();
                break;
            case 5:
                task5();
                break;
            case 6:
                task6();
                break;
            case 7:
                task7();
                break;
            case 8:
                task8();
                break;
            case 9:
                task9();
                break;
            case 10:
                task10();
                break;
            case 11:
                task11();
                break;
            case 12:
                task12();
                break;
            case 13:
                task13();
                break;
            case 14:
                task14();
                break;
            case 15:
                task15();
                break;
            default:
                System.out.println("Неверный номер задания.");
        }
    }

    // Задание 1: Основы LocalDate и LocalTime
    private static void task1() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = currentDate.atTime(currentTime).format(formatter);
        System.out.println("Текущая дата и время: " + formattedDateTime);
    }

    // Задание 2: Сравнение дат
    private static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую дату в формате yyyy-MM-dd:");
        LocalDate date1 = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите вторую дату в формате yyyy-MM-dd:");
        LocalDate date2 = LocalDate.parse(scanner.nextLine());

        if (date1.isBefore(date2)) {
            System.out.println("Первая дата раньше второй.");
        } else if (date1.isAfter(date2)) {
            System.out.println("Первая дата позже второй.");
        } else {
            System.out.println("Даты равны.");
        }
    }

    // Задание 3: Сколько дней до Нового года?
    private static void task3() {
        LocalDate today = LocalDate.now();
        LocalDate newYear = LocalDate.of(today.getYear() + 1, 1, 1);
        long daysUntilNewYear = ChronoUnit.DAYS.between(today, newYear);
        System.out.println("До Нового года осталось " + daysUntilNewYear + " дней.");
    }

    // Задание 4: Проверка високосного года
    private static void task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год:");
        int year = scanner.nextInt();
        boolean isLeap = Year.of(year).isLeap();
        System.out.println(year + " год високосный: " + isLeap);
    }

    // Задание 5: Подсчет выходных за месяц
    private static void task5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год:");
        int year = scanner.nextInt();
        System.out.println("Введите месяц (1-12):");
        int month = scanner.nextInt();

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

        int weekendCount = 0;
        while (!startDate.isAfter(endDate)) {
            if (startDate.getDayOfWeek() == DayOfWeek.SATURDAY || startDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                weekendCount++;
            }
            startDate = startDate.plusDays(1);
        }
        System.out.println("Количество выходных в месяце: " + weekendCount);
    }

    // Задание 6: Расчет времени выполнения метода
    private static void task6() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            // Пустой цикл для примера
        }
        long endTime = System.nanoTime();
        System.out.println("Время выполнения метода: " + (endTime - startTime) + " наносекунд.");
    }

    // Задание 7: Форматирование и парсинг даты
    private static void task7() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату в формате dd-MM-yyyy:");
        String dateStr = scanner.nextLine();
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateStr, inputFormatter);
        LocalDate newDate = date.plusDays(10);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println("Новая дата: " + newDate.format(outputFormatter));
    }

    // Задание 8: Конвертация между часовыми поясами
    private static void task8() {
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneOffset.UTC);
        ZonedDateTime moscowTime = utcTime.withZoneSameInstant(ZoneId.of("Europe/Moscow"));
        System.out.println("Время в UTC: " + utcTime);
        System.out.println("Время в Москве: " + moscowTime);
    }

    // Задание 9: Вычисление возраста по дате рождения
    private static void task9() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату рождения в формате yyyy-MM-dd:");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        System.out.println("Возраст: " + age + " лет.");
    }

    // Задание 10: Создание календаря на месяц
    private static void task10() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год:");
        int year = scanner.nextInt();
        System.out.println("Введите месяц (1-12):");
        int month = scanner.nextInt();

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

        while (!startDate.isAfter(endDate)) {
            String dayType = (startDate.getDayOfWeek() == DayOfWeek.SATURDAY || startDate.getDayOfWeek() == DayOfWeek.SUNDAY)
                    ? "выходной" : "рабочий день";
            System.out.println(startDate + ": " + dayType);
            startDate = startDate.plusDays(1);
        }
    }

    // Задание 11: Генерация случайной даты в диапазоне
    private static void task11() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите начальную дату в формате yyyy-MM-dd:");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите конечную дату в формате yyyy-MM-dd:");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        Random random = new Random();
        long randomDays = random.nextInt((int) daysBetween + 1);
        LocalDate randomDate = startDate.plusDays(randomDays);
        System.out.println("Случайная дата: " + randomDate);
    }

    // Задание 12: Расчет времени до заданной даты
    private static void task12() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату и время события в формате yyyy-MM-dd HH:mm:ss:");
        String dateTimeStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime eventDateTime = LocalDateTime.parse(dateTimeStr, formatter);
        LocalDateTime now = LocalDateTime.now();

        Duration duration = Duration.between(now, eventDateTime);
        System.out.println("Осталось времени: " + duration.toHours() + " часов, " +
                duration.toMinutes() % 60 + " минут, " +
                duration.getSeconds() % 60 + " секунд.");
    }

    // Задание 13: Вычисление количества рабочих часов
    private static void task13() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите начало рабочего дня в формате yyyy-MM-dd HH:mm:ss:");
        LocalDateTime start = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("Введите конец рабочего дня в формате yyyy-MM-dd HH:mm:ss:");
        LocalDateTime end = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        long workingHours = ChronoUnit.HOURS.between(start, end);
        System.out.println("Количество рабочих часов: " + workingHours);
    }

    // Задание 14: Конвертация даты в строку с учетом локали
    private static void task14() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату в формате yyyy-MM-dd:");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите локаль (например, ru или en):");
        String localeStr = scanner.nextLine();
        Locale locale = new Locale(localeStr);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", locale);
        System.out.println("Дата: " + date.format(formatter));
    }

    // Задание 15: Определение дня недели по дате
    private static void task15() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату в формате yyyy-MM-dd:");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        String dayOfWeek = date.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, new Locale("ru"));
        System.out.println("День недели: " + dayOfWeek);
    }
}