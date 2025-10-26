import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Valid valid = new Valid();

        System.out.println("Привет, это 4 лаба по Java");
        String number;
        while (true) {
            System.out.println("Введи номер задания(1-7):");
            number = scanner.nextLine();

            if (!valid.isNumber(number)) {
                System.out.println("Ошибка");
            } else if (!number.equals("1") && !number.equals("2") && !number.equals("3") &&
                    !number.equals("4") && !number.equals("5") && !number.equals("6") &&
                    !number.equals("7")) {
                System.out.println("Такого задания нет");
            }

            switch (number) {
                case "1":
                    System.out.println("1 Задание");
                    Box<Integer> integerBox = new Box<>();

                    System.out.print("Введите целое число: ");
                    String input = scanner.nextLine();

                    if (valid.isNumber(input)) {
                        int number1 = Integer.parseInt(input);

                        integerBox.put(number1);
                        System.out.println(integerBox.toString());

                        System.out.println("Коробка пуста: " + integerBox.isEmpty());

                        Integer extractedValue = integerBox.get();
                        System.out.println("Извлеченное значение: " + extractedValue);

                        System.out.println(integerBox.toString());
                        System.out.println("Коробка пуста: " + integerBox.isEmpty());

                    } else {
                        System.out.println("Ошибка: введите целое число!");
                    }
                    break;

                case "2":
                    System.out.println("2 Задание");

                    System.out.print("Введите первое число: ");
                    String num1 = scanner.nextLine();
                    System.out.print("Введите второе число: ");
                    String num2 = scanner.nextLine();

                    if (valid.isNumber(num1) && valid.isNumber(num2)) {
                        int n1 = Integer.parseInt(num1);
                        int n2 = Integer.parseInt(num2);

                        Compare<Integer> comp = other -> n1 - other;
                        int result = comp.compare(n2);

                        System.out.println(n1 + " сравнить " + n2 + " = " + result);

                        if (result < 0) System.out.println(n1 + " меньше " + n2);
                        else if (result > 0) System.out.println(n1 + " больше " + n2);
                        else System.out.println("Числа равны");
                    } else {
                        System.out.println("Ошибка ввода чисел!");
                    }
                    break;

                case "3":
                    System.out.println("3 Задание");

                    System.out.print("Введите количество коробок: ");
                    String countStr3 = scanner.nextLine();

                    if (!valid.isNumber(countStr3)) {
                        System.out.println("Ошибка");
                        break;
                    }

                    int count3 = Integer.parseInt(countStr3);
                    Box<? extends Number>[] boxes = new Box[count3];

                    for (int i = 0; i < count3; i++) {
                        System.out.print("Введите значение для коробки " + (i + 1) + ": ");
                        String valueStr = scanner.nextLine();

                        if (valid.isAnyNumber(valueStr)) {
                            double value = Double.parseDouble(valueStr);
                            if (valueStr.contains(".")) {
                                boxes[i] = new Box<>(value);
                            } else {
                                boxes[i] = new Box<>((int) value);
                            }
                        } else {
                            System.out.println("Ошибка: введите корректное число!");
                            i--;
                        }
                    }

                    try {
                        double max = FindMax.findMax(boxes);
                        System.out.println("Максимальное значение: " + max);
                        System.out.println();
                        System.out.println("Содержимое коробок:");
                        for (int i = 0; i < boxes.length; i++) {
                            System.out.println("Коробка " + (i + 1) + ": " + boxes[i]);
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;

                case "4":
                    System.out.println("4 Задание");

                    System.out.println("1. Строки");
                    System.out.println("2. Числа");
                    System.out.println("3. Массивы");
                    System.out.print("Выберите вариант: ");
                    String choice4 = scanner.nextLine();

                    if (choice4.equals("1")) {
                        System.out.print("Сколько строк вы хотите ввести? ");
                        String countStr = scanner.nextLine();

                        if (valid.isNumber(countStr)) {
                            int count = Integer.parseInt(countStr);
                            List<String> strings = new ArrayList<>();

                            for (int i = 0; i < count; i++) {
                                System.out.print("Введите строку " + (i + 1) + ": ");
                                strings.add(scanner.nextLine());
                            }

                            List<Integer> lengths = Transform.transform(strings, String::length);
                            System.out.println("Строки: " + strings);
                            System.out.println("Длины: " + lengths);
                        } else {
                            System.out.println("Ошибка: введите число!");
                        }

                    } else if (choice4.equals("2")) {
                        System.out.print("Сколько чисел вы хотите ввести? ");
                        String countStr = scanner.nextLine();

                        if (valid.isNumber(countStr)) {
                            int count = Integer.parseInt(countStr);
                            List<Integer> numList = new ArrayList<>();

                            for (int i = 0; i < count; i++) {
                                System.out.print("Введите число " + (i + 1) + ": ");
                                String numStr = scanner.nextLine();

                                if (valid.isInteger(numStr)) {
                                    numList.add(Integer.parseInt(numStr));
                                } else {
                                    System.out.println("Ошибка: введите целое число!");
                                    i--;
                                }
                            }

                            List<Integer> absValues = Transform.transform(numList, Math::abs);
                            System.out.println("Исходные числа: " + numList);
                            System.out.println("Абсолютные значения: " + absValues);
                        } else {
                            System.out.println("Ошибка: введите число!");
                        }

                    } else if (choice4.equals("3")) {
                        System.out.print("Сколько массивов вы хотите ввести? ");
                        String countStr = scanner.nextLine();

                        if (valid.isNumber(countStr)) {
                            int count = Integer.parseInt(countStr);
                            List<int[]> arraysList = new ArrayList<>();

                            for (int i = 0; i < count; i++) {
                                System.out.print("Сколько чисел в массиве " + (i + 1) + "? ");
                                String arraySizeStr = scanner.nextLine();

                                if (valid.isNumber(arraySizeStr)) {
                                    int arraySize = Integer.parseInt(arraySizeStr);
                                    int[] array = new int[arraySize];

                                    for (int j = 0; j < arraySize; j++) {
                                        System.out.print("Введите число " + (j + 1) + " для массива " + (i + 1) + ": ");
                                        String numStr = scanner.nextLine();
                                        if (valid.isInteger(numStr)) {
                                            array[j] = Integer.parseInt(numStr);
                                        } else {
                                            System.out.println("Ошибка: введите целое число!");
                                            j--;
                                        }
                                    }
                                    arraysList.add(array);
                                } else {
                                    System.out.println("Ошибка: введите число!");
                                    i--;
                                }
                            }

                            List<Integer> maxValues = Transform.transform(arraysList,
                                    array -> {
                                        int max = array[0];
                                        for (int num : array) {
                                            if (num > max) {
                                                max = num;
                                            }
                                        }
                                        return max;
                                    });

                            System.out.println("Массивы:");
                            for (int i = 0; i < arraysList.size(); i++) {
                                System.out.println("Массив " + (i + 1) + ": " + Arrays.toString(arraysList.get(i)));
                            }
                            System.out.println("Максимальные значения: " + maxValues);
                        } else {
                            System.out.println("Ошибка: введите число!");
                        }
                    }
                    break;

                case "5":
                    System.out.println("5 Задание");
                    System.out.println("1. Фильтрация строк");
                    System.out.println("2. Фильтрация чисел");
                    System.out.println("3. Фильтрация массивов");
                    System.out.print("Выберите вариант: ");
                    String choice5 = scanner.nextLine();

                    if (choice5.equals("1")) {
                        System.out.print("Сколько строк вы хотите ввести? ");
                        String countStr5 = scanner.nextLine();

                        if (valid.isNumber(countStr5)) {
                            int count5 = Integer.parseInt(countStr5);
                            List<String> stringList = new ArrayList<>();

                            for (int i = 0; i < count5; i++) {
                                System.out.print("Введите строку " + (i + 1) + ": ");
                                stringList.add(scanner.nextLine());
                            }

                            List<String> filtered = Filter.filter(stringList, value -> value.length() >= 3);
                            System.out.println("Исходные строки: " + stringList);
                            System.out.println("Строки длиной более 3 символов: " + filtered);

                        } else {
                            System.out.println("Ошибка: введите число!");
                        }

                    } else if (choice5.equals("2")) {
                        System.out.print("Сколько чисел вы хотите ввести? ");
                        String countStr5 = scanner.nextLine();

                        if (valid.isNumber(countStr5)) {
                            int count5 = Integer.parseInt(countStr5);
                            List<Integer> numList = new ArrayList<>();

                            for (int i = 0; i < count5; i++) {
                                System.out.print("Введите число " + (i + 1) + ": ");
                                String numStr = scanner.nextLine();
                                if (valid.isAnyNumber(numStr)) {
                                    numList.add(Integer.parseInt(numStr));
                                } else {
                                    System.out.println("Ошибка: введите целое число!");
                                    i--;
                                }
                            }

                            List<Integer> nonPositive = Filter.filter(numList, value -> value <= 0);
                            System.out.println("Исходные числа: " + numList);
                            System.out.println("Неположительные числа: " + nonPositive);

                        } else {
                            System.out.println("Ошибка: введите число!");
                        }

                    } else if (choice5.equals("3")) {
                        System.out.print("Сколько массивов вы хотите ввести? ");
                        String countStr5 = scanner.nextLine();

                        if (valid.isNumber(countStr5)) {
                            int count5 = Integer.parseInt(countStr5);
                            List<int[]> arraysList = new ArrayList<>();

                            for (int i = 0; i < count5; i++) {
                                System.out.print("Сколько чисел в массиве " + (i + 1) + "? ");
                                String arraySizeStr = scanner.nextLine();

                                if (valid.isNumber(arraySizeStr)) {
                                    int arraySize = Integer.parseInt(arraySizeStr);
                                    int[] array = new int[arraySize];

                                    for (int j = 0; j < arraySize; j++) {
                                        System.out.print("Введите число " + (j + 1) + " для массива " + (i + 1) + ": ");
                                        String numStr = scanner.nextLine();
                                        if (valid.isAnyNumber(numStr)) {
                                            array[j] = Integer.parseInt(numStr);
                                        } else {
                                            System.out.println("Ошибка: введите целое число!");
                                            j--;
                                        }
                                    }
                                    arraysList.add(array);
                                } else {
                                    System.out.println("Ошибка: введите число!");
                                    i--;
                                }
                            }

                            List<int[]> arraysWithoutPositive = Filter.filter(arraysList,
                                    array -> {
                                        for (int num : array) {
                                            if (num > 0) {
                                                return false;
                                            }
                                        }
                                        return true;
                                    });

                            System.out.println("Исходные массивы:");
                            for (int i = 0; i < arraysList.size(); i++) {
                                System.out.println("Массив " + (i + 1) + ": " + Arrays.toString(arraysList.get(i)));
                            }
                            System.out.println("Массивы без положительных элементов:");
                            for (int i = 0; i < arraysWithoutPositive.size(); i++) {
                                System.out.println("Массив " + (i + 1) + ": " + Arrays.toString(arraysWithoutPositive.get(i)));
                            }
                        } else {
                            System.out.println("Ошибка: введите число!");
                        }
                    }
                    break;

                case "6":
                    System.out.println("6 Задание");

                    System.out.println("1. Конкатенация");
                    System.out.println("2. Сумма");
                    System.out.println("3. Общее количество элементов");
                    System.out.print("Выберите вариант: ");
                    String choice6 = scanner.nextLine();

                    if (choice6.equals("1")) {
                        System.out.print("Сколько строк вы хотите ввести? ");
                        String countStr = scanner.nextLine();

                        if (valid.isNumber(countStr)) {
                            int count = Integer.parseInt(countStr);
                            List<String> stringList = new ArrayList<>();

                            for (int i = 0; i < count; i++) {
                                System.out.print("Введите строку " + (i + 1) + ": ");
                                stringList.add(scanner.nextLine());
                            }

                            String concatenated = Reducer.reduce(stringList, (acc, curr) -> acc + curr, "");
                            System.out.println("Исходные строки: " + stringList);
                            System.out.println("Объединенная строка: " + concatenated);
                        } else {
                            System.out.println("Ошибка: введите число!");
                        }

                    } else if (choice6.equals("2")) {
                        System.out.print("Сколько чисел вы хотите ввести? ");
                        String countStr = scanner.nextLine();

                        if (valid.isNumber(countStr)) {
                            int count = Integer.parseInt(countStr);
                            List<Integer> numList = new ArrayList<>();

                            for (int i = 0; i < count; i++) {
                                System.out.print("Введите число " + (i + 1) + ": ");
                                String numStr = scanner.nextLine();
                                if (valid.isAnyNumber(numStr)) {
                                    numList.add(Integer.parseInt(numStr));
                                } else {
                                    System.out.println("Ошибка: введите целое число!");
                                    i--;
                                }
                            }

                            int sum = Reducer.reduce(numList, Integer::sum, 0);
                            System.out.println("Исходные числа: " + numList);
                            System.out.println("Сумма чисел: " + sum);
                        } else {
                            System.out.println("Ошибка: введите число!");
                        }

                    } else if (choice6.equals("3")) {
                        System.out.print("Сколько списков вы хотите ввести? ");
                        String countStr = scanner.nextLine();

                        if (valid.isNumber(countStr)) {
                            int count = Integer.parseInt(countStr);
                            List<List<Integer>> listOfLists = new ArrayList<>();

                            for (int i = 0; i < count; i++) {
                                System.out.print("Сколько чисел в списке " + (i + 1) + "? ");
                                String listSizeStr = scanner.nextLine();

                                if (valid.isNumber(listSizeStr)) {
                                    int listSize = Integer.parseInt(listSizeStr);
                                    List<Integer> numbers = new ArrayList<>();

                                    for (int j = 0; j < listSize; j++) {
                                        System.out.print("Введите число " + (j + 1) + " для списка " + (i + 1) + ": ");
                                        String numStr = scanner.nextLine();
                                        if (valid.isAnyNumber(numStr)) {
                                            numbers.add(Integer.parseInt(numStr));
                                        } else {
                                            System.out.println("Ошибка: введите целое число!");
                                            j--;
                                        }
                                    }
                                    listOfLists.add(numbers);
                                } else {
                                    System.out.println("Ошибка: введите число!");
                                    i--;
                                }
                            }

                            List<Integer> sizes = Transform.transform(listOfLists, List::size);
                            int totalCount2 = Reducer.reduce(sizes, Integer::sum, 0);
                            System.out.println("Ответ: " + totalCount2);
                        } else {
                            System.out.println("Ошибка: введите число!");
                        }
                    }
                    break;

                case "7":
                    System.out.println("7 Задание");

                    System.out.println("1. Разбиение чисел на положительные и отрицательные");
                    System.out.println("2. Группировка строк по длине");
                    System.out.println("3. Уникальные строки");
                    System.out.print("Выберите вариант: ");
                    String choice7 = scanner.nextLine();

                    if (choice7.equals("1")) {
                        System.out.print("Сколько чисел вы хотите ввести? ");
                        String countStr = scanner.nextLine();

                        if (valid.isNumber(countStr)) {
                            int count = Integer.parseInt(countStr);
                            List<Integer> numList = new ArrayList<>();

                            for (int i = 0; i < count; i++) {
                                System.out.print("Введите число " + (i + 1) + ": ");
                                String numStr = scanner.nextLine();
                                if (valid.isAnyNumber(numStr)) {
                                    numList.add(Integer.parseInt(numStr));
                                } else {
                                    System.out.println("Ошибка: введите целое число!");
                                    i--;
                                }
                            }

                            Collector<List<List<Integer>>, Integer> collector = () -> {
                                List<List<Integer>> result = new ArrayList<>();
                                result.add(new ArrayList<>());
                                result.add(new ArrayList<>());
                                return result;
                            };

                            Accumulator<List<List<Integer>>, Integer> accumulator = (lists, value) -> {
                                if (value > 0) {
                                    lists.getFirst().add(value);
                                } else if (value < 0) {
                                    lists.get(1).add(value);
                                }
                            };

                            List<List<Integer>> result = CollectionUtils.collect(numList, collector, accumulator);
                            System.out.println("Положительные числа: " + result.get(0));
                            System.out.println("Отрицательные числа: " + result.get(1));
                        }

                    } else if (choice7.equals("2")) {
                        System.out.print("Сколько строк вы хотите ввести? ");
                        String countStr = scanner.nextLine();

                        if (valid.isNumber(countStr)) {
                            int count = Integer.parseInt(countStr);
                            List<String> stringList = new ArrayList<>();

                            for (int i = 0; i < count; i++) {
                                System.out.print("Введите строку " + (i + 1) + ": ");
                                stringList.add(scanner.nextLine());
                            }

                            List<Integer> uniqueLengths = new ArrayList<>();
                            for (String str : stringList) {
                                int length = str.length();
                                if (!uniqueLengths.contains(length)) {
                                    uniqueLengths.add(length);
                                }
                            }

                            Collector<List<List<String>>, String> collector = () -> {
                                List<List<String>> result = new ArrayList<>();
                                for (int i = 0; i < uniqueLengths.size(); i++) {
                                    result.add(new ArrayList<>());
                                }
                                return result;
                            };

                            Accumulator<List<List<String>>, String> accumulator = (lists, value) -> {
                                int length = value.length();
                                int index = uniqueLengths.indexOf(length);
                                if (index != -1) {
                                    lists.get(index).add(value);
                                }
                            };

                            List<List<String>> grouped = CollectionUtils.collect(stringList, collector, accumulator);

                            System.out.println("Группировка строк по длине:");
                            for (int i = 0; i < uniqueLengths.size(); i++) {
                                System.out.println("Длина " + uniqueLengths.get(i) + ": " + grouped.get(i));
                            }
                        }

                    } else if (choice7.equals("3")) {
                        System.out.print("Сколько строк вы хотите ввести? ");
                        String countStr = scanner.nextLine();

                        if (valid.isNumber(countStr)) {
                            int count = Integer.parseInt(countStr);
                            List<String> stringList = new ArrayList<>();

                            for (int i = 0; i < count; i++) {
                                System.out.print("Введите строку " + (i + 1) + ": ");
                                stringList.add(scanner.nextLine());
                            }

                            Collector<List<String>, String> collector = ArrayList::new;
                            Accumulator<List<String>, String> accumulator = (list, value) -> {
                                if (!list.contains(value)) {
                                    list.add(value);
                                }
                            };

                            List<String> uniqueStrings = CollectionUtils.collect(stringList, collector, accumulator);
                            System.out.println("Исходные строки: " + stringList);
                            System.out.println("Уникальные строки: " + uniqueStrings);
                        }
                    }
                    break;
            }
        }
    }
}