package com.dgerom89;
/*
 Kurinnoi Andrii
 ДЗ 02.1
 Необходимо реализовать коллекцию целых чисел, которая позволяет выполнять операции:
 добавления
 удаления
 поиска элемента по значению
 поиска элемента по индексу
 поиска максимального элемента
 поиска минимального элемента
 поиска среднего арифметического всех элементов
 При этом:
 при добавлении нового элемента все элементы увеличивают своё значение на добавляемый элемент
 при удалении - уменьшают своё значение на удаляемый элемент
 Недопустим ввод в коллекцию null, символов и других значений, кроме целых чисел.
 Результатом работы должен быть отдельный репозиторий github/bitbucket с README файлом, который описывает задание, сам класс и содержит инструкции по запуску приложения.
 */


import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

                Scanner in = new Scanner(System.in);
                ArrayList<Integer> arrayList = new ArrayList<Integer>() {

                    /**
                     * Добавление элемента в коллекцию
                     * @param integer - принимает только числа
                     * @return
                     */
                    @Override
                    public boolean add(Integer integer) {
                        for (int i = 0; i < this.size(); i++) {
                            this.set(i, this.get(i) + integer);
                        }
                        super.add(integer);
                        System.out.println(this);
                        return true;
                    }

                    /**
                     * Удаление элемента по значению
                     * @param integer - принимает только числа
                     * @return
                     */
                    @Override
                    public boolean remove(Object integer) {
                        if (super.remove(integer)) {
                            for (int i = 0; i < this.size() - 1; i++) {
                                this.set(i, this.get(i) - (int) integer);
                            }
                            System.out.println(this);
                            return true;
                        } else {
                            System.out.println(this);
                            return false;
                        }
                    }

                    /**
                     * Удаление элемента по индексу
                     * @param index - индекс элемента который хотим удалить
                     * @return
                     */
                    @Override
                    public Integer remove(int index) {
                        int valueToRemove = this.get(index);
                        for (int i = 0; i < this.size(); i++) {
                            this.set(i, this.get(i) - valueToRemove);
                        }
                        super.remove(index);
                        System.out.println(this);

                        return null;
                    }

                };
                int possibilities;
        /**
         * Меню выбора действий
         */
        do {
            System.out.println("Что будем делать с коллекцией:");
                    System.out.println("1) добавлять элемент;");
                    System.out.println("2) удалять элемент по значению;");
                    System.out.println("3) удалять элемент по индексу;");
                    System.out.println("4) находить элемент по значению;");
                    System.out.println("5) находить элемент по индексу;");
                    System.out.println("6) находить минимальный элемент;");
                    System.out.println("7) находить максимальный элемент;");
                    System.out.println("8) находить среднее арифметическое всех элементов;");
                    System.out.println("9) не сегодня - выходим :)");

            possibilities = getIntegerFromScanner(in, errorMessage());
                    switch (possibilities) {
                        case 1: {
                            System.out.print("Введите добавляемый элемент коллекции: ");
                            arrayList.add(getIntegerFromScanner(in, errorMessage()));
                            break;
                        }
                        case 2: {
                            System.out.print("Введите удаляемый по значению элемент коллекции: ");
                            arrayList.remove((Object) getIntegerFromScanner(in, "НЕВЕРНЫЙ ВВОД! Попробуйте еще раз!"));
                            break;
                        }
                        case 3: {
                            System.out.print("Введите индекс удаляемого элемента коллекции: ");
                            int index = getIntegerFromScanner(in, errorMessage());
                            if (index < arrayList.size() && index >= 0){
                                arrayList.remove(index);
                            } else System.out.println(errorMessage());

                            break;
                        }
                        case 4: {
                            System.out.print("Введите значение искомого элемента коллекции: ");
                            int element = getIntegerFromScanner(in, errorMessage());
                            System.out.println("Элемент находиться в: " + arrayList.indexOf(element));
                            break;
                        }
                        case 5: {
                            System.out.print("Введите индекс искомого элемента коллекции: ");
                            int index = getIntegerFromScanner(in, errorMessage());
                            if (index < arrayList.size() && index >= 0) {
                                System.out.println("В " + index + " храниться " + arrayList.get(index));
                            } else System.out.println(errorMessage());
                            break;
                        }
                        case 6: {
                            int minElement = Integer.MAX_VALUE;
                            for (int i = 0; i < arrayList.size(); i++) {
                                if (arrayList.get(i) < minElement) {
                                    minElement = arrayList.get(i);
                                }
                            }
                            System.out.println("Минимальный элемент коллекции: " + minElement);
                            break;
                        }
                        case 7: {
                            int maxElement = Integer.MIN_VALUE;
                            for (int i = 0; i < arrayList.size(); i++) {
                                if (arrayList.get(i) > maxElement) {
                                    maxElement = arrayList.get(i);
                                }
                            }
                            System.out.println("Минимальный элемент коллекции: " + maxElement);
                            break;
                        }
                        case 8: {
                            int sum = 0;
                            for (int i = 0; i < arrayList.size(); i++) {
                                sum += arrayList.get(i);
                            }
                            double directAverage = sum / arrayList.size();
                            System.out.println("Среднее арифметическое всех элементов коллекции:" + directAverage);
                            break;
                        }
                        case 9: {
                            System.out.println("Хорошего дня! Удачи!");
                            break;
                        }
                        default: {
                            System.out.println(errorMessage());
                        }
                    }


                } while (possibilities != 9);


            }

            private static int getIntegerFromScanner(Scanner sc, String errorMessage) {
                while (!sc.hasNextInt()) {
                    System.err.println(errorMessage);
                    sc.next();
                }
                return sc.nextInt();
            }

            private static String errorMessage(){
                return "НЕВЕРНЫЙ ВВОД! Попробуйте еще раз!";
            }
        }

