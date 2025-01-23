import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите задание (1-20) или 0 для выхода:");
        System.out.println("1. Класс 'Человек'");
        System.out.println("2. Наследование: 'Работник' и 'Менеджер'");
        System.out.println("3. Полиморфизм: Животные");
        System.out.println("4. Абстрактный класс 'Транспорт'");
        System.out.println("5. Класс 'Книга' и 'Библиотека'");
        System.out.println("6. Инкапсуляция: Банк");
        System.out.println("7. Счетчик объектов");
        System.out.println("8. Площадь фигур");
        System.out.println("9. Наследование: Животные и их движения");
        System.out.println("10. Работа с коллекциями: Университет");
        System.out.println("11. Класс 'Магазин'");
        System.out.println("12. Интерфейс 'Платежная система'");
        System.out.println("13. Генерация уникальных идентификаторов");
        System.out.println("14. Класс 'Точка' и 'Прямоугольник'");
        System.out.println("15. Комплексные числа");
        System.out.println("16. Перегрузка операторов: Матрица");
        System.out.println("17. Создание игры с использованием ООП");
        System.out.println("18. Автоматизированная система заказов");
        System.out.println("19. Наследование: Электроника");
        System.out.println("20. Игра 'Крестики-нолики'");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        switch (choice) {
            case 1:
        personTask();
        break;
    case 2:
        workerManagerTask();
        break;
    case 3:
        animalTask();
        break;
    case 4:
        transportTask();
        break;
    case 5:
        libraryTask();
        break;
    case 6:
        bankTask();
        break;
    case 7:
        counterTask();
        break;
    case 8:
        shapeTask();
        break;
    case 9:
        animalMovementTask();
        break;
    case 10:
        universityTask();
        break;
    case 11:
        storeTask();
        break;
    case 12:
        paymentSystemTask();
        break;
    case 13:
        uniqueIDTask();
        break;
    case 14:
        rectangleTask();
        break;
    case 15:
        complexNumberTask();
        break;
    case 16:
        matrixTask();
        break;
    case 17:
        gameTask();
        break;
    case 18:
        orderSystemTask();
        break;
    case 19:
        electronicsTask();
        break;
    case 20:
        ticTacToeTask();
        break;
            default:
                System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }

    private static void personTask() {
        class Person {
            private String name;
            private int age;
            private String gender;

            public Person(String name, int age, String gender) {
                this.name = name;
                this.age = age;
                this.gender = gender;
            }

            public void increaseAge() {
                age++;
            }

            public void changeName(String newName) {
                name = newName;
            }

            public void displayInfo() {
                System.out.println("Имя: " + name + ", Возраст: " + age + ", Пол: " + gender);
            }
        }

        Person person = new Person("Иван", 30, "Мужской");
        person.displayInfo();
        person.increaseAge();
        person.changeName("Алексей");
        person.displayInfo();
    }

    private static void workerManagerTask() {
        class Person {
            protected String name;
            protected int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }

        class Worker extends Person {
            protected double salary;

            public Worker(String name, int age, double salary) {
                super(name, age);
                this.salary = salary;
            }
        }

        class Manager extends Worker {
            private List<Worker> subordinates;

            public Manager(String name, int age, double salary) {
                super(name, age, salary);
                subordinates = new ArrayList<>();
            }

            public void addSubordinate(Worker worker) {
                subordinates.add(worker);
            }
        }

        Manager manager = new Manager("Анна", 40, 100000);
        Worker worker1 = new Worker("Иван", 25, 50000);
        Worker worker2 = new Worker("Петр", 30, 55000);
        manager.addSubordinate(worker1);
        manager.addSubordinate(worker2);
    }

    private static void animalTask() {
        interface Animal {
            void makeSound();
        }

        class Dog implements Animal {
            public void makeSound() {
                System.out.println("Собака: Гав-Гав");
            }
        }

        class Cat implements Animal {
            public void makeSound() {
                System.out.println("Кошка: Мяу");
            }
        }

        class Cow implements Animal {
            public void makeSound() {
                System.out.println("Корова: Мууу");
            }
        }

        Animal[] animals = {new Dog(), new Cat(), new Cow()};
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }

    private static void transportTask() {
        abstract class Transport {
            public abstract void move();
        }

        class Car extends Transport {
            public void move() {
                System.out.println("Машина едет по дороге");
            }
        }

        class Bike extends Transport {
            public void move() {
                System.out.println("Велосипед едет по тропинке");
            }
        }

        Transport car = new Car();
        Transport bike = new Bike();
        car.move();
        bike.move();
    }

    private static void libraryTask() {
        class Book {
            private String title;
            private String author;
            private int year;

            public Book(String title, String author, int year) {
                this.title = title;
                this.author = author;
                this.year = year;
            }
        }

        class Library {
            private List<Book> books = new ArrayList<>();

            public void addBook(Book book) {
                books.add(book);
            }
        }
    }

    private static void bankTask() {
        class BankAccount {
            private String accountNumber;
            private double balance;

            public BankAccount(String accountNumber, double initialBalance) {
                this.accountNumber = accountNumber;
                this.balance = initialBalance;
            }

            public void deposit(double amount) {
                if (amount > 0) {
                    balance += amount;
                    System.out.println("Средства успешно внесены: " + amount);
                } else {
                    System.out.println("Сумма пополнения должна быть положительной.");
                }
            }

            public void withdraw(double amount) {
                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    System.out.println("Средства успешно сняты: " + amount);
                } else {
                    System.out.println("Недостаточно средств или некорректная сумма.");
                }
            }

            public double getBalance() {
                return balance;
            }
        }

        System.out.println("\nЗадание 6: Инкапсуляция");
        BankAccount account = new BankAccount("123456", 1000);
        account.deposit(500);
        account.withdraw(300);
        System.out.println("Баланс: " + account.getBalance());        
    }

    private static void counterTask() {
        class Counter {
            private static int objectCount = 0;

            public Counter() {
                objectCount++;
            }

            public static int getObjectCount() {
                return objectCount;
            }
        }

        System.out.println("\nЗадание 7: Счетчик объектов");
        new Counter();
        new Counter();
        System.out.println("Количество созданных объектов: " + Counter.getObjectCount());
        }
        

    private static void shapeTask() {
        abstract class Shape {
            public abstract double getArea();
        }

        class Circle extends Shape {
            private double radius;

            public Circle(double radius) {
                this.radius = radius;
            }

            @Override
            public double getArea() {
                return Math.PI * radius * radius;
            }
        }

        class Rectangle extends Shape {
            private double width;
            private double height;

            public Rectangle(double width, double height) {
                this.width = width;
                this.height = height;
            }

            @Override
            public double getArea() {
                return width * height;
            }
        }

        System.out.println("\nЗадание 8: Площадь фигур");
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        System.out.println("Площадь круга: " + circle.getArea());
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());
    }

    private static void animalMovementTask() {
        class Animal {
            public void move() {
                System.out.println("Животное движется...");
            }
        }

        class Fish extends Animal {
            @Override
            public void move() {
                System.out.println("Рыба плывёт...");
            }
        }

        class Bird extends Animal {
            @Override
            public void move() {
                System.out.println("Птица летит...");
            }
        }

        class Dog extends Animal {
            @Override
            public void move() {
                System.out.println("Собака бегает...");
            }
        }

        System.out.println("\nЗадание 9: Наследование");
        Animal fish = new Fish();
        Animal bird = new Bird();
        Animal dog = new Dog();
        fish.move();
        bird.move();
        dog.move();
    }

    private static void universityTask() {
            class Student {
                private String name;
                private String group;
                private double grade;
    
                public Student(String name, String group, double grade) {
                    this.name = name;
                    this.group = group;
                    this.grade = grade;
                }
    
                public String getName() {
                    return name;
                }
    
                public double getGrade() {
                    return grade;
                }
    
                @Override
                public String toString() {
                    return "Student{" +
                            "name='" + name + '\'' +
                            ", group='" + group + '\'' +
                            ", grade=" + grade +
                            '}';
                }
            }
    
            class University {
                private List<Student> students = new ArrayList<>();
    
                public void addStudent(Student student) {
                    students.add(student);
                }
    
                public void sortStudentsByName() {
                    students.sort(Comparator.comparing(Student::getName));
                }
    
                public List<Student> filterByGrade(double threshold) {
                    return students.stream()
                            .filter(student -> student.getGrade() >= threshold)
                            .collect(Collectors.toList());
                }
        }
    }

    private static void storeTask() {
        class Product {
            private String name;
            private double price;
            private int quantity;

            public Product(String name, double price, int quantity) {
                this.name = name;
                this.price = price;
                this.quantity = quantity;
            }

            public String getName() {
                return name;
            }

            @Override
            public String toString() {
                return "Product{name='" + name + "', price=" + price + ", quantity=" + quantity + "}";
            }
        }

        class Store {
            private List<Product> products = new ArrayList<>();

            public void addProduct(Product product) {
                products.add(product);
            }

            public void removeProduct(String name) {
                products.removeIf(product -> product.getName().equals(name));
            }

            public Product findProduct(String name) {
                for (Product product : products) {
                    if (product.getName().equals(name)) {
                        return product;
                    }
                }
                return null;
            }

            public void displayProducts() {
                products.forEach(System.out::println);
            }
        }

        System.out.println("\nЗадание 11: Класс \"Магазин\"");
        Store store = new Store();
        store.addProduct(new Product("Apple", 1.5, 100));
        store.addProduct(new Product("Banana", 0.8, 50));
        store.displayProducts();
        store.removeProduct("Apple");
        store.displayProducts();
        System.out.println("Найденный продукт: " + store.findProduct("Banana"));
    }

    private static void paymentSystemTask() {
        interface PaymentSystem {
            void pay(double amount);
            void refund(double amount);
        }

        class CreditCard implements PaymentSystem {
            @Override
            public void pay(double amount) {
                System.out.println("Оплата " + amount + " через Credit Card");
            }

            @Override
            public void refund(double amount) {
                System.out.println("Возврат " + amount + " через Credit Card");
            }
        }

        class PayPal implements PaymentSystem {
            @Override
            public void pay(double amount) {
                System.out.println("Оплата " + amount + " через PayPal");
            }

            @Override
            public void refund(double amount) {
                System.out.println("Возврат " + amount + " через PayPal");
            }
        }

        System.out.println("\nЗадание 12: Интерфейс \"Платежная система\"");
        PaymentSystem creditCard = new CreditCard();
        PaymentSystem payPal = new PayPal();
        creditCard.pay(150);
        payPal.refund(50);
    }

    private static void uniqueIDTask() {
        class UniqueID {
            private static int counter = 0;
            private final int id;

            public UniqueID() {
                id = ++counter;
            }

            public int getId() {
                return id;
            }

            public static int getCurrentCount() {
                return counter;
            }
        }

        System.out.println("\nЗадание 13: Генерация уникальных идентификаторов");
        UniqueID obj1 = new UniqueID();
        UniqueID obj2 = new UniqueID();
        System.out.println("ID первого объекта: " + obj1.getId());
        System.out.println("ID второго объекта: " + obj2.getId());
        System.out.println("Общее количество созданных объектов: " + UniqueID.getCurrentCount());
    }

    private static void rectangleTask() {
        class Point {
            private double x, y;

            public Point(double x, double y) {
                this.x = x;
                this.y = y;
            }
        }

        class Rectangle {
            private Point topLeft, bottomRight;

            public Rectangle(Point topLeft, Point bottomRight) {
                this.topLeft = topLeft;
                this.bottomRight = bottomRight;
            }

            public double calculateArea() {
                double width = Math.abs(bottomRight.x - topLeft.x);
                double height = Math.abs(topLeft.y - bottomRight.y);
                return width * height;
            }
        }

        System.out.println("\nЗадание 14: Класс \"Точка\" и \"Прямоугольник\"");
        Point topLeft = new Point(1, 5);
        Point bottomRight = new Point(4, 1);
        Rectangle rectangle = new Rectangle(topLeft, bottomRight);
        System.out.println("Площадь прямоугольника: " + rectangle.calculateArea());
    }

    private static void complexNumberTask() {
        class ComplexNumber {
            private double real;
            private double imaginary;

            public ComplexNumber(double real, double imaginary) {
                this.real = real;
                this.imaginary = imaginary;
            }

            public ComplexNumber add(ComplexNumber other) {
                return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
            }

            public ComplexNumber subtract(ComplexNumber other) {
                return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
            }

            public ComplexNumber multiply(ComplexNumber other) {
                double realPart = this.real * other.real - this.imaginary * other.imaginary;
                double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
                return new ComplexNumber(realPart, imaginaryPart);
            }

            public ComplexNumber divide(ComplexNumber other) {
                double denominator = other.real * other.real + other.imaginary * other.imaginary;
                double realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
                double imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
                return new ComplexNumber(realPart, imaginaryPart);
            }

            @Override
            public String toString() {
                return real + " + " + imaginary + "i";
            }
        }

        System.out.println("\nЗадание 15: Комплексные числа");
        ComplexNumber num1 = new ComplexNumber(3, 4);
        ComplexNumber num2 = new ComplexNumber(1, 2);
        System.out.println("Сумма: " + num1.add(num2));
        System.out.println("Разность: " + num1.subtract(num2));
        System.out.println("Произведение: " + num1.multiply(num2));
        System.out.println("Частное: " + num1.divide(num2));
    }

    private static void matrixTask() {
        class Matrix {
            private int[][] data;

            public Matrix(int[][] data) {
                this.data = data;
            }

            public Matrix add(Matrix other) {
                int rows = data.length;
                int cols = data[0].length;
                int[][] result = new int[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        result[i][j] = this.data[i][j] + other.data[i][j];
                    }
                }
                return new Matrix(result);
            }

            public Matrix multiply(Matrix other) {
                int rows = this.data.length;
                int cols = other.data[0].length;
                int sumLength = this.data[0].length;
                int[][] result = new int[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        for (int k = 0; k < sumLength; k++) {
                            result[i][j] += this.data[i][k] * other.data[k][j];
                        }
                    }
                }
                return new Matrix(result);
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                for (int[] row : data) {
                    for (int value : row) {
                        sb.append(value).append(" ");
                    }
                    sb.append("\n");
                }
                return sb.toString();
            }
        }

        System.out.println("\nЗадание 16: Перегрузка операторов: Матрица");
        int[][] data1 = {{1, 2}, {3, 4}};
        int[][] data2 = {{5, 6}, {7, 8}};
        Matrix mat1 = new Matrix(data1);
        Matrix mat2 = new Matrix(data2);
        System.out.println("Сумма матриц:\n" + mat1.add(mat2));
        System.out.println("Произведение матриц:\n" + mat1.multiply(mat2));
    }

    private static void gameTask() {
        class Enemy {
            private String name;
            private int health;

            public Enemy(String name, int health) {
                this.name = name;
                this.health = health;
            }

            public void takeDamage(int damage) {
                health -= damage;
                System.out.println(name + " получает " + damage + " урона. Осталось здоровья: " + health);
            }

            public String getName() {
                return name;
            }
        }
        
        class Player {
            private String name;
            private int health;
            private int damage;

            public Player(String name, int health, int damage) {
                this.name = name;
                this.health = health;
                this.damage = damage;
            }

            public void attack(Enemy enemy) {
                enemy.takeDamage(damage);
                System.out.println(name + " атакует " + enemy.getName() + " и наносит " + damage + " урона!");
            }
        }

        

        System.out.println("\nЗадание 17: Создание игры с использованием ООП");
        Player player = new Player("Герой", 100, 20);
        Enemy enemy = new Enemy("Монстр", 50);
        player.attack(enemy);
    }

    private static void orderSystemTask() {
        class Product {
            private String name;
            private double price;

            public Product(String name, double price) {
                this.name = name;
                this.price = price;
            }

            public double getPrice() {
                return price;
            }

            @Override
            public String toString() {
                return name + " ($" + price + ")";
            }
        }

        class Order {
            private List<Product> products = new ArrayList<>();

            public void addProduct(Product product) {
                products.add(product);
            }

            public double getTotalPrice() {
                return products.stream().mapToDouble(Product::getPrice).sum();
            }

            @Override
            public String toString() {
                return "Order: " + products.toString() + ", Total: $" + getTotalPrice();
            }
        }

        System.out.println("\nЗадание 18: Автоматизированная система заказов");
        Product apple = new Product("Apple", 1.5);
        Product banana = new Product("Banana", 0.8);
        Order order = new Order();
        order.addProduct(apple);
        order.addProduct(banana);
        System.out.println(order);
    }
    private static void electronicsTask() {
        class Device {
            protected String brand;

            public Device(String brand) {
                this.brand = brand;
            }

            public void turnOn() {
                System.out.println(brand + " включен.");
            }

            public void turnOff() {
                System.out.println(brand + " выключен.");
            }
        }

        class Smartphone extends Device {
            public Smartphone(String brand) {
                super(brand);
            }

            public void takePhoto() {
                System.out.println(brand + " делает фотографию.");
            }
        }

        class Laptop extends Device {
            public Laptop(String brand) {
                super(brand);
            }

            public void compileCode() {
                System.out.println(brand + " компилирует код.");
            }
        }

        System.out.println("\nЗадание 19: Наследование: Электроника");
        Smartphone phone = new Smartphone("Samsung");
        Laptop laptop = new Laptop("Dell");
        phone.turnOn();
        phone.takePhoto();
        phone.turnOff();
        laptop.turnOn();
        laptop.compileCode();
        laptop.turnOff();
    }

    // Задание 20: Игра "Крестики-нолики"
    private static void ticTacToeTask() {
        class Game {
            private char[][] board = new char[3][3];
            private char currentPlayer = 'X';

            public Game() {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        board[i][j] = '-';
                    }
                }
            }

            public void play(int row, int col) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayer;
                    if (checkWin()) {
                        System.out.println("Игрок " + currentPlayer + " победил!");
                        printBoard();
                        return;
                    }
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("Клетка уже занята! Попробуйте снова.");
                }
                printBoard();
            }

            private boolean checkWin() {
                for (int i = 0; i < 3; i++) {
                    if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                        return true;
                    if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                        return true;
                }
                return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
                        || (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
            }

            private void printBoard() {
                for (char[] row : board) {
                    for (char cell : row) {
                        System.out.print(cell + " ");
                    }
                    System.out.println();
                }
            }
        }

        System.out.println("\nЗадание 20: Игра 'Крестики-нолики'");
        Game game = new Game();
        game.play(0, 0); // Игрок X
        game.play(1, 1); // Игрок O
        game.play(0, 1); // Игрок X
        game.play(1, 0); // Игрок O
        game.play(0, 2); // Игрок X выигрывает
    }

}