/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coad_laba_2_Z_1;

import java.util.Scanner;

class LineList {

    int number_of_elements = 0;

    int elements[] = new int[10];

    //Проверка на пустоту
    private boolean isNotEmpty() {
        return number_of_elements > 0;
    }

    //Проверка на заполненность
    private boolean isNotFull() {
        return number_of_elements < 10;
    }

    //Вывод элементов
    public void printElements() {
        if (isNotEmpty()) {
            for (int i = 0; i < elements.length; i++) {
                System.out.print(elements[i] + " | ");
            }
            System.out.println();
        } else {
            System.out.println("Список пуст");
        }
    }

    //Поиск элемента по информационной части
    public void searchElement(int element) {
        if (isNotEmpty()) {
            for (int i = 0; i < number_of_elements; i++) {
                if (elements[i] == element) {
                    System.out.println("Элемент найден. Номер элемента: " + i);
                }
            }
        } else {
            System.out.println("Список пуст");
        }
    }

    // добавление элемента по его номеру
    public void addElement(int cell, int element) {
        if (isNotFull()) {
            if (cell < 10 && cell >= 0) { //Проверка входит ли введеный номер в диапозон списка
                if ((elements[cell] != 0)) {  //Проверка на наличие информации в данной ячейки списка, если она есть то происходит сдвиг вправо
                    for (int i = number_of_elements; i > cell; i--) { // Сдвиг ячейки начинается с конца списка
                        elements[i] = elements[i - 1];
                    }
                    elements[cell] = element;
                    number_of_elements++;
                } else { // Если ячейка пуста, то данные просто записываются в ячейку
                    elements[cell] = element;
                    number_of_elements++;
                }
            } else {
                System.out.println("Некорректно указан номер ячейки списка");
            }
        } else {
            System.out.println("Список полон");
        }
    }

    //Удаление элемента по информ части
    public void deleteElement(int cell) {
        if (isNotEmpty()) {
            for (int j = cell; j < number_of_elements - 1; j++) { // Сдвиг ячейки влево
                elements[j] = elements[j + 1];
            }
            elements[number_of_elements - 1] = 0;
        }

    }
}

public class COAD_Laba_2_Z_1 {

    public static void main(String[] args) {
        LineList list = new LineList();
        int input = 0;

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("1.Добавление элемента в список\n2.Удаление элемента из списка\n3.Поиск элемента в списке\n4.Вывод списка\n5.Выход");
            if (in.hasNextInt()) {
                input = in.nextInt();
            } else {
                System.out.println("Ошибка. Введенный символ не является числом");
                in.close();
                System.exit(0);
            }

            switch (input) {
                case 1:
                    System.out.println("Введите ячейку, куда необходимо добавить элемент");
                    int n = in.nextInt();
                    System.out.println("Введите Значение");
                    int m = in.nextInt();
                    list.addElement(n, m);
                    break;
                case 2:
                    System.out.println("Введите элемент который необходимо удалить");
                    m = in.nextInt();
                    list.deleteElement(m);
                    break;
                case 3:
                    System.out.println("Введите элемент который необходимо найти");
                    m = in.nextInt();
                    list.searchElement(m);
                    break;
                case 4:
                    list.printElements();
                    break;
                case 5:
                    in.close();
                    System.exit(0);
            }
        }
    }

}
