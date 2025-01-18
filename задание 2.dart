import 'dart:io';
import 'dart:math';

class ArithmeticException implements Exception {
  final String message;
  ArithmeticException(this.message);

  @override
  String toString() => 'ArithmeticException: $message';
}

class IllegalArgumentException implements Exception {
  final String message;
  IllegalArgumentException(this.message);

  @override
  String toString() => 'IllegalArgumentException: $message';
}

class NumberFormatException implements Exception {
  final String message;
  NumberFormatException(this.message);

  @override
  String toString() => 'NumberFormatException: $message';
}

class IndexOutOfBoundsException implements Exception {
  final String message;
  IndexOutOfBoundsException(this.message);

  @override
  String toString() => 'IndexOutOfBoundsException: $message';
}

class DateTimeParseException implements Exception{
  final String message;
  DateTimeParseException(this.message);

  @override
  String toString() => 'DateTimeParseException: $message';
}

void main() {
  // 1. Функция для нахождения максимума
  void findMax() {
    stdout.write("Введите первое число: ");
    int a = int.parse(stdin.readLineSync()!);

    stdout.write("Введите второе число: ");
    int b = int.parse(stdin.readLineSync()!);

    if (a == b) {
      throw Exception('Числа равны');
    }
    print(a > b ? a : b);
  }

  // 2. Калькулятор деления
  void divide() {
    stdout.write("Введите делимое: ");
    int a = int.parse(stdin.readLineSync()!);

    stdout.write("Введите делитель: ");
    int b = int.parse(stdin.readLineSync()!);

    if (b == 0) {
      throw ArithmeticException('Деление на ноль невозможно');
    }
    print(a / b);
  }

  // 3. Конвертер строк в числа
  void convertToInt() {
    stdout.write("Введите строку для преобразования: ");
    String str = stdin.readLineSync()!;

    try {
      print(int.parse(str));
    } catch (e) {
      throw NumberFormatException('Невозможно преобразовать строку в число');
    }
  }

  // 4. Проверка возраста
  void checkAge() {
    stdout.write("Введите возраст: ");
    int age = int.parse(stdin.readLineSync()!);

    if (age < 0 || age > 150) {
      throw IllegalArgumentException('Недопустимый возраст');
    }
    print('Возраст $age допустим');
  }

  // 5. Нахождение корня
  void findSquareRoot() {
    stdout.write("Введите число для нахождения корня: ");
    double number = double.parse(stdin.readLineSync()!);

    if (number < 0) {
      throw IllegalArgumentException('Число не может быть отрицательным');
    }
    print(sqrt(number));
  }

  // 6. Факториал
  void factorial() {
    stdout.write("Введите число для вычисления факториала: ");
    int n = int.parse(stdin.readLineSync()!);

    if (n < 0) {
      throw Exception('Число должно быть неотрицательным');
    }
    int result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
    }
    print(result);
  }

  // 7. Проверка массива на нули
  void checkForZeros() {
    stdout.write("Введите элементы массива через пробел: ");
    List<int> list = stdin.readLineSync()!.split(' ').map(int.parse).toList();

    if (list.contains(0)) {
      throw Exception('Массив содержит нули');
    }
    print('Массив без нулей');
  }

  // 8. Калькулятор возведения в степень
  void power() {
    stdout.write("Введите основание: ");
    int base = int.parse(stdin.readLineSync()!);

    stdout.write("Введите степень: ");
    int exponent = int.parse(stdin.readLineSync()!);

    if (exponent < 0) {
      throw Exception('Степень не может быть отрицательной');
    }
    print(pow(base, exponent));
  }

  // 9. Срез строки
  void truncateString() {
    stdout.write("Введите строку: ");
    String str = stdin.readLineSync()!;

    stdout.write("Введите число символов для обрезки: ");
    int length = int.parse(stdin.readLineSync()!);

    if (length > str.length) {
      throw Exception('Длина превышает длину строки');
    }
    print(str.substring(0, length));
  }

  // 10. Поиск элемента в массиве
  void findElement() {
    stdout.write("Введите элементы массива через пробел: ");
    List<int> list = stdin.readLineSync()!.split(' ').map(int.parse).toList();

    stdout.write("Введите элемент для поиска: ");
    int element = int.parse(stdin.readLineSync()!);

    if (!list.contains(element)) {
      throw Exception('Элемент не найден');
    }
    print(list.indexOf(element));
  }

  // 11. Конвертация в двоичную систему
  void toBinary() {
    stdout.write("Введите число для конвертации в двоичную систему: ");
    int number = int.parse(stdin.readLineSync()!);

    if (number < 0) {
      throw Exception('Число не может быть отрицательным');
    }
    print(number.toRadixString(2));
  }

  // 12. Проверка делимости
  void isDivisible() {
    stdout.write("Введите первое число: ");
    int a = int.parse(stdin.readLineSync()!);

    stdout.write("Введите второе число: ");
    int b = int.parse(stdin.readLineSync()!);

    if (b == 0) {
      throw ArithmeticException('Деление на ноль невозможно');
    }
    print(a % b == 0);
  }

  // 13. Чтение элемента списка
  void getElement() {
    stdout.write("Введите элементы списка через пробел: ");
    List<int> list = stdin.readLineSync()!.split(' ').map(int.parse).toList();

    stdout.write("Введите индекс элемента: ");
    int index = int.parse(stdin.readLineSync()!);

    if (index < 0 || index >= list.length) {
      throw IndexOutOfBoundsException('Индекс вне диапазона');
    }
    print(list[index]);
  }

  // 14. Парольная проверка
  void checkPasswordStrength() {
    stdout.write("Введите пароль: ");
    String password = stdin.readLineSync()!;

    if (password.length < 8) {
      throw Exception('Пароль слишком слабый');
    }
    print('Пароль надежный');
  }

  // 15. Проверка даты
  void parseDate() {
    stdout.write("Введите дату в формате dd.mm.yyyy: ");
    String date = stdin.readLineSync()!;

    try {
      var splitdate = date.split('.');
      date = splitdate[2]+'-'+splitdate[1]+'-'+splitdate[0];
      print(DateTime.parse(date));
    } catch (e) {
      throw DateTimeParseException('Неверный формат даты');
    }
  }

  // 16. Конкатенация строк
  void concatenateStrings() {
    stdout.write("Введите первую строку: ");
    String str1 = stdin.readLineSync()!;

    stdout.write("Введите вторую строку: ");
    String str2 = stdin.readLineSync()!;

    if (str1.isEmpty || str2.isEmpty) {
      throw Exception('Одна из строк равна пустой');
    }
    print(str1 + str2);
  }

  // 17. Остаток от деления
  void modulo() {
    stdout.write("Введите первое число: ");
    int a = int.parse(stdin.readLineSync()!);

    stdout.write("Введите второе число: ");
    int b = int.parse(stdin.readLineSync()!);

    if (b == 0) {
      throw ArithmeticException('Деление на ноль невозможно');
    }
    print(a % b);
  }

  // 18. Квадратный корень
  void squareRoot() {
    stdout.write("Введите число для нахождения квадратного корня: ");
    int number = int.parse(stdin.readLineSync()!);

    if (number < 0) {
      throw Exception('Число должно быть неотрицательным');
    }
    print(sqrt(number));
  }

  // 19. Конвертер температуры
  void celsiusToFahrenheit() {
    stdout.write("Введите температуру в Цельсиях: ");
    double celsius = double.parse(stdin.readLineSync()!);

    if (celsius < -273.15) {
      throw Exception('Температура ниже абсолютного нуля');
    }
    print((celsius * 9/5) + 32);
  }

  // 20. Проверка строки на пустоту
  void checkIfEmpty() {
    stdout.write("Введите строку: ");
    String str = stdin.readLineSync()!;

    if (str.isEmpty) {
      throw Exception('Строка пустая');
    }
    print('Строка не пустая');
  }

  stdout.write('Выберите задачу (1-20): ');

  int choice = int.parse(stdin.readLineSync()!);

  switch (choice) {
    case 1: findMax();
    case 2: divide();
    case 3: convertToInt();
    case 4: checkAge();
    case 5: findSquareRoot();
    case 6: factorial();
    case 7: checkForZeros();
    case 8: power();
    case 9: truncateString();
    case 10: findElement();
    case 11: toBinary();
    case 12: isDivisible();
    case 13: getElement();
    case 14: checkPasswordStrength();
    case 15: parseDate();
    case 16: concatenateStrings();
    case 17: modulo();
    case 18: squareRoot();
    case 19: celsiusToFahrenheit();
    case 20: checkIfEmpty();
  }
}
