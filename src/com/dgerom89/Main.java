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


import static com.dgerom89.CollectionsMethods.errorMessage;



public class Main {

    public static void main(String[] args) {

            CollectionsMethods collect = new CollectionsMethods();
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

            possibilities = collect.getIntegerFromScanner();
                    switch (possibilities) {
                        case 1: {
                            collect.addElement();
                            break;
                        }
                        case 2: {
                            collect.removeElementByValue();
                            break;
                        }
                        case 3: {
                            collect.removeElementByIndex();
                            break;
                        }
                        case 4: {
                            collect.findElementByValue();
                            break;
                        }
                        case 5: {
                            collect.findElementByIndex();
                            break;
                        }
                        case 6: {
                            collect.findMaxValueElement();
                            break;
                        }
                        case 7: {
                            collect.findMinValueElement();
                            break;
                        }
                        case 8: {
                            collect.findAvarageOfAllElements();
                            break;
                        }
                        case 9: {
                            System.out.println("Хорошего дня! Удачи!");
                            break;
                        }
                        default: {
                            System.out.println( errorMessage());
                        }
                    }
                } while (possibilities != 9);
            }
  }

