package com.dgerom89;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Dgerom on 20.06.2017.
 */
public class CollectionsMethods {

    private static Scanner in = new Scanner(System.in);
    private ArrayList<Integer> arrayList = new ArrayList<Integer>() {

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

    void addElement (){
        System.out.print("Введите добавляемый элемент коллекции: ");
        arrayList.add(getIntegerFromScanner());
    }
    void removeElementByValue() {
        System.out.print("Введите удаляемый по значению элемент коллекции: ");
        arrayList.remove((Object) getIntegerFromScanner());
    }
    void removeElementByIndex() {
        System.out.print("Введите индекс удаляемого элемента коллекции: ");
        int index = getIntegerFromScanner();
        if (index < arrayList.size() && index >= 0){
            arrayList.remove(index);
        } else System.out.println(errorMessage());
    }
    void findElementByValue() {
        System.out.print("Введите значение искомого элемента коллекции: ");
        int element = getIntegerFromScanner();
        System.out.println("Элемент находиться в: " + arrayList.indexOf(element));
    }
    void findAvarageOfAllElements() {
        int sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i);
        }
        double directAverage = sum / arrayList.size();
        System.out.println("Среднее арифметическое всех элементов коллекции:" + directAverage);
    }

    void findMinValueElement() {
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > maxElement) {
                maxElement = arrayList.get(i);
            }
        }
        System.out.println("Минимальный элемент коллекции: " + maxElement);
    }

    void findMaxValueElement() {
        int minElement = Integer.MAX_VALUE;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) < minElement) {
                minElement = arrayList.get(i);
            }
        }
        System.out.println("Минимальный элемент коллекции: " + minElement);
    }

    void findElementByIndex() {
        System.out.print("Введите индекс искомого элемента коллекции: ");
        int index = getIntegerFromScanner();
        if (index < arrayList.size() && index >= 0) {
            System.out.println("В " + index + " храниться " + arrayList.get(index));
        } else System.out.println(errorMessage());
    }

    /**
     * решил использовать наработки из ДЗ 1.2
     */
    static int getIntegerFromScanner(   ) {
        int i;
        try {
            i = in.nextInt();
        } catch (Exception e) {
            System.out.println("НЕВЕРНЫЙ ВВОД! Попробуйте еще раз!");
            in.next();
            i = getIntegerFromScanner();
        }
        return i;
    }
    static String errorMessage(){
        return "НЕВЕРНЫЙ ВВОД! Попробуйте еще раз!";
    }
}
