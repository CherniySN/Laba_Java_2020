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

    //�������� �� �������
    private boolean isNotEmpty() {
        return number_of_elements > 0;
    }

    //�������� �� �������������
    private boolean isNotFull() {
        return number_of_elements < 10;
    }

    //����� ���������
    public void printElements() {
        if (isNotEmpty()) {
            for (int i = 0; i < elements.length; i++) {
                System.out.print(elements[i] + " | ");
            }
            System.out.println();
        } else {
            System.out.println("������ ����");
        }
    }

    //����� �������� �� �������������� �����
    public void searchElement(int element) {
        if (isNotEmpty()) {
            for (int i = 0; i < number_of_elements; i++) {
                if (elements[i] == element) {
                    System.out.println("������� ������. ����� ��������: " + i);
                }
            }
        } else {
            System.out.println("������ ����");
        }
    }

    // ���������� �������� �� ��� ������
    public void addElement(int cell, int element) {
        if (isNotFull()) {
            if (cell < 10 && cell >= 0) { //�������� ������ �� �������� ����� � �������� ������
                if ((elements[cell] != 0)) {  //�������� �� ������� ���������� � ������ ������ ������, ���� ��� ���� �� ���������� ����� ������
                    for (int i = number_of_elements; i > cell; i--) { // ����� ������ ���������� � ����� ������
                        elements[i] = elements[i - 1];
                    }
                    elements[cell] = element;
                    number_of_elements++;
                } else { // ���� ������ �����, �� ������ ������ ������������ � ������
                    elements[cell] = element;
                    number_of_elements++;
                }
            } else {
                System.out.println("����������� ������ ����� ������ ������");
            }
        } else {
            System.out.println("������ �����");
        }
    }

    //�������� �������� �� ������ �����
    public void deleteElement(int cell) {
        if (isNotEmpty()) {
            for (int j = cell; j < number_of_elements - 1; j++) { // ����� ������ �����
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
            System.out.println("1.���������� �������� � ������\n2.�������� �������� �� ������\n3.����� �������� � ������\n4.����� ������\n5.�����");
            if (in.hasNextInt()) {
                input = in.nextInt();
            } else {
                System.out.println("������. ��������� ������ �� �������� ������");
                in.close();
                System.exit(0);
            }

            switch (input) {
                case 1:
                    System.out.println("������� ������, ���� ���������� �������� �������");
                    int n = in.nextInt();
                    System.out.println("������� ��������");
                    int m = in.nextInt();
                    list.addElement(n, m);
                    break;
                case 2:
                    System.out.println("������� ������� ������� ���������� �������");
                    m = in.nextInt();
                    list.deleteElement(m);
                    break;
                case 3:
                    System.out.println("������� ������� ������� ���������� �����");
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
