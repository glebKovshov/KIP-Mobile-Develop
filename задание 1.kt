fun main() {
    // Задача 1: Четное или нечетное число
    fun checkEvenOdd() {
        print("Введите целое число: ")
        val input = readLine()!!
        val number = input.toInt()
        if (number % 2 == 0) {
            println("Число $number является четным.")
        } else {
            println("Число $number является нечетным.")
        }
    }

    // Задача 2: Минимальное из трех чисел
    fun findMinimum() {
        print("Введите три целых числа через пробел: ")
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        val min = minOf(a, b, c)
        println("Минимальное число: $min")
    }

    // Задача 3: Таблица умножения
    fun multiplicationTable() {
        println("Таблица умножения на 5:")
        for (i in 1..10) {
            println("5 * $i = ${5 * i}")
        }
    }

    // Задача 4: Сумма чисел от 1 до N
    fun sumToN() {
        print("Введите целое число N: ")
        val N = readLine()!!.toInt()
        val sum = (1..N).sum()
        println("Сумма чисел от 1 до $N: $sum")
    }

    // Задача 5: Число Фибоначчи
    fun fibonacci(n: Int): Int {
        return if (n <= 1) n else fibonacci(n - 1) + fibonacci(n - 2)
    }

    fun printFibonacciSeries() {
        print("Введите целое число N: ")
        val N = readLine()!!.toInt()
        
        for (i in 0 until N) {
            print("${fibonacci(i)} ")
        }
    }   

    // Задача 6: Проверка простого числа
    fun checkPrimeNumber() {
        print("Введите целое число: ")
        val num = readLine()!!.toInt()
        var isPrime = true
        for (i in 2 until num) {
            if (num % i == 0) {
                isPrime = false
                break
            }
        }
        if (isPrime) {
            println("$num — простое число.")
        } else {
            println("$num — не является простым числом.")
        }
    }

    // Задача 7: Обратный порядок чисел
    fun reverseNumbers() {
        print("Введите целое число N: ")
        val N = readLine()!!.toInt()
        for (i in N downTo 1) {
            println(i)
        }
    }

    // Задача 8: Сумма четных чисел
    fun sumEvenNumbers() {
        print("Введите два целых числа A и B через пробел: ")
        val (A, B) = readLine()!!.split(" ").map { it.toInt() }
        var sum = 0
        for (i in A..B) {
            if (i % 2 == 0) {
                sum += i
            }
        }
        println("Сумма четных чисел от $A до $B: $sum")
    }

    // Задача 9: Реверс строки
    fun reverseString() {
        print("Введите строку: ")
        val input = readLine()!!
        println("Реверс строки: ${input.reversed()}")
    }

    // Задача 10: Количество цифр в числе
    fun countDigits() {
        print("Введите целое число: ")
        val num = readLine()!!.toInt()
        println("Количество цифр в числе: ${num.toString().length}")
    }

    // Задача 11: Факториал числа
    fun factorial() {
        print("Введите целое число N: ")
        val N = readLine()!!.toInt()
        var factorial = 1
        for (i in 1..N) {
            factorial *= i
        }
        println("Факториал $N: $factorial")
    }

    // Задача 12: Сумма цифр числа
    fun sumOfDigits() {
        print("Введите целое число: ")
        val num = readLine()!!.toInt()
        val sum = num.toString().map { it.toString().toInt() }.sum()
        println("Сумма всех цифр числа $num: $sum")
    }

    // Задача 13: Палиндром
    fun checkPalindrome() {
        print("Введите строку: ")
        val input = readLine()!!
        if (input == input.reversed()) {
            println("Это палиндром.")
        } else {
            println("Это не палиндром.")
        }
    }

    // Задача 14: Найти максимальное число в массиве
    fun findMaxInArray() {
        print("Введите размер массива: ")
        val size = readLine()!!.toInt()
        print("Введите элементы массива через пробел: ")
        val array = readLine()!!.split(" ").map { it.toInt() }
        println("Максимальное число в массиве: ${array.maxOrNull()}")
    }

    // Задача 15: Сумма всех элементов массива
    fun sumArrayElements() {
        print("Введите размер массива: ")
        val size = readLine()!!.toInt()
        print("Введите элементы массива через пробел: ")
        val array = readLine()!!.split(" ").map { it.toInt() }
        println("Сумма всех элементов массива: ${array.sum()}")
    }

    // Задача 16: Количество положительных и отрицательных чисел
    fun countPositiveNegative() {
        print("Введите размер массива: ")
        val size = readLine()!!.toInt()
        print("Введите элементы массива через пробел: ")
        val array = readLine()!!.split(" ").map { it.toInt() }
        val positives = array.count { it > 0 }
        val negatives = array.count { it < 0 }
        println("Положительных чисел: $positives, Отрицательных чисел: $negatives")
    }

    // Задача 17: Простые числа в диапазоне
    fun printPrimesInRange() {
        print("Введите два числа A и B через пробел: ")
        val (A, B) = readLine()!!.split(" ").map { it.toInt() }
        for (i in A..B) {
            var isPrime = true
            for (j in 2 until i) {
                if (i % j == 0) {
                    isPrime = false
                    break
                }
            }
            if (isPrime) println(i)
        }
    }

    // Задача 18: Подсчет гласных и согласных в строке
    fun countVowelsConsonants() {
        print("Введите строку: ")
        val input = readLine()!!.lowercase()
        val vowels = "aeiou"
        var vowelCount = 0
        var consonantCount = 0
        for (char in input) {
            if (char in vowels) vowelCount++
            else if (char.isLetter()) consonantCount++
        }
        println("Гласных: $vowelCount, Согласных: $consonantCount")
    }

    // Задача 19: Перестановка слов в строке
    fun reverseWords() {
        print("Введите строку: ")
        val input = readLine()!!
        val reversedWords = input.split(" ").reversed().joinToString(" ")
        println("Перестановка слов: $reversedWords")
    }

    // Задача 20: Число Армстронга
    fun checkArmstrongNumber() {
        print("Введите целое число: ")
        val num = readLine()!!.toInt()
        val digits = num.toString().length
        var sum = 0

        for (i in 0 until digits) {
            sum += num.toString()[i].toString().toInt()
        }

        sum = Math.pow(sum.toDouble(), digits.toDouble()).toInt()
        if (sum == num) {
            println("$num - число Армстронга.")
        } else {
            println("$num - не число Армстронга.")
        }
    }

    // Выбор задачи
    println("Выберите задачу (1-20): ")
    val task = readLine()!!.toInt()
    when (task) {
        1 -> checkEvenOdd()
        2 -> findMinimum()
        3 -> multiplicationTable()
        4 -> sumToN()
        5 -> printFibonacciSeries()
        6 -> checkPrimeNumber()
        7 -> reverseNumbers()
        8 -> sumEvenNumbers()
        9 -> reverseString()
        10 -> countDigits()
        11 -> factorial()
        12 -> sumOfDigits()
        13 -> checkPalindrome()
        14 -> findMaxInArray()
        15 -> sumArrayElements()
        16 -> countPositiveNegative()
        17 -> printPrimesInRange()
        18 -> countVowelsConsonants()
        19 -> reverseWords()
        20 -> checkArmstrongNumber()
        else -> println("Некорректный выбор.")
    }
}
