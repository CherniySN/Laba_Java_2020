/*
Задание 3. Реализовать набор подпрограмм для выполнения основных операций со списком списков.
Требования аналогичны предыдущему заданию.
 */
package coad_laba_3_z_3;

import java.util.Scanner;


public class COAD_Laba_3_Z_3 {
    public static void main(String[] args) {
        boolean indicatorDialog = true;

        OutDoublyLinkedList outDoublyLinkedList = new OutDoublyLinkedList();
        Scanner intIndexOutList = new Scanner(System.in);
        while (indicatorDialog) {
            System.out.println("Меню пользователя.\n" +
                    "Введите цифру из меню для выполнения действия:\n" +
                    "1) Полный проход по структуре;\n" +
                    "2) Поиск заданного элемента;\n" +
                    "3) Добавление нового элемента в базовый список с пустым связанным списком;\n" +
                    "4) Добавление нового элемента в связанный список;\n" +
                    "5) Удаление элемента из связанного списка;\n" +
                    "6) Удаление элемента из базового массива;\n" +
                    "7) Выход.\n");
            Scanner input = new Scanner(System.in);
            if (!input.hasNextInt())
                System.out.println("Вы ввели не число!");
            else {
                switch (input.nextInt()) {
                    case 1:
                        outDoublyLinkedList.show();
                        break;
                    case 2:
			if (!outDoublyLinkedList.outListIsEmpty()) {
                        System.out.println("Введите значение, которое нужно найти:");
                        Scanner intValueForSearch = new Scanner(System.in);
                        if (!intValueForSearch.hasNextInt())
                            System.out.println("Вы ввели не число!");
                        else
                            outDoublyLinkedList.searchElement(intValueForSearch.nextInt());
			}
                        break;
                    case 3:
                        outDoublyLinkedList.addOutList();
                        break;
                    case 4:
                        if (!outDoublyLinkedList.outListIsEmpty()) {
                            System.out.println("Введите индекс базового списка, в который надо добавить элемент:");
                            intIndexOutList = new Scanner(System.in);
                            if (!intIndexOutList.hasNextInt()) {
                                System.out.println("Вы ввели не число!");
                            } else {
                                int intIndexOutListForMethod = intIndexOutList.nextInt();
                                if(outDoublyLinkedList.checkElement(intIndexOutListForMethod))
                                    continue;
                                System.out.println("Введите число, которое надо добавить:");
                                Scanner intValueForInnerList = new Scanner(System.in);
                                if (!intValueForInnerList.hasNextInt())
                                    System.out.println("Вы ввели не число!");
                                else {
                                    outDoublyLinkedList.addElementInInnerList(intIndexOutListForMethod, intValueForInnerList.nextInt());
                                }
                            }
                        }
                        break;
                    case 5:
                        if (!outDoublyLinkedList.outListIsEmpty()) {
                            System.out.println("Введите индекс базового списка, в котором надо удалить элемент:");
                            Scanner IndexOutList = new Scanner(System.in);
                            if (!IndexOutList.hasNextInt()) {
                                System.out.println("Вы ввели не число!");
                            }
                            else {
                                int intIndex = IndexOutList.nextInt();
                                if (outDoublyLinkedList.checkElement(intIndex))
                                    continue;
                                System.out.println("Введите число, которое надо удалить:");
                                Scanner intValueForInnerList = new Scanner(System.in);
                                if (!intValueForInnerList.hasNextInt())
                                    System.out.println("Вы ввели не число!");
                                else {
                                    outDoublyLinkedList.deleteElementInInnerList(intIndexOutList.nextInt(), intValueForInnerList.nextInt());
                                }
                            }
                        }
                        break;
                    case 6:
                        if (!outDoublyLinkedList.outListIsEmpty()) {
                            System.out.println("Введите индекс базового списка, который надо удалить:");
                            Scanner intIndexOutLIst = new Scanner(System.in);
                            if (!intIndexOutLIst.hasNextInt()) {
                                System.out.println("Вы ввели не число!");
                            } else {
                                outDoublyLinkedList.deleteOutListElement(intIndexOutLIst.nextInt());
                            }
                        }
                        break;
                    case 7:
                        indicatorDialog = false;
                        break;
                    default:
                        System.out.println("Введенное число не соответствует пункту меню. Введите цисру 1 - 7.");
                        break;
                }
            }
        }
    }
}
//--Элемент внутреннего списка//
class DoublyNode {
    public int Value; //Информационная часть
    public coad_laba_3_z_3.DoublyNode Previous;//Предыдущий элемент
    public coad_laba_3_z_3.DoublyNode Next;//Следующий элемент
    //Контруктор
    public DoublyNode(int value) {
        Value = value;
    }
}//Элемент внутреннего списка --//

//--Внутренний список//
class DoublyLinkedList {
    public DoublyNode TopDLL = new DoublyNode(-1);//Головной элемент
    public DoublyNode BottomDLL;//Конечный элемнет
    public int Count = 0;//Количесто элментов в списке
    //Контруктор
    public DoublyLinkedList() {
        TopDLL.Next = TopDLL;
        TopDLL.Previous = TopDLL;
    }
//--Добавление элемента//
    public void Add(int insertValue) {
        DoublyNode addNode = new DoublyNode(insertValue);

        if (Count == 0) {
            //Top = node;
            TopDLL.Next = addNode;
            TopDLL.Previous = addNode;
            BottomDLL = addNode;
            BottomDLL.Next = TopDLL;
            BottomDLL.Previous = TopDLL;
        } else {
            BottomDLL.Next = addNode;
            addNode.Previous = BottomDLL;
            addNode.Next = TopDLL;
            BottomDLL = addNode;
        }
        Count++;
    }
    //Добавление элемнета--//
//--Удаление элемента
    public void Delete(int deleteValue) {
        DoublyNode current = TopDLL;
        DoublyNode tempNode = null;
        if (Count == 0)
            System.out.println("Список пуст!");
        else {
            do {
                if (current.Value == deleteValue) {
                    tempNode = current;
                    break;
                }
                current = current.Next;
            }
            while (current != TopDLL);

            if (tempNode != null) {
                if (Count == 1) {
                    TopDLL = new DoublyNode(-1);
                    TopDLL.Next = TopDLL;
                    TopDLL.Previous = TopDLL;
                    BottomDLL = null;
                } else {
                    tempNode.Previous.Next = tempNode.Next;
                    tempNode.Next.Previous = tempNode.Previous;

                    if (tempNode.Next == TopDLL)
                        BottomDLL = tempNode;
                }
                Count--;
            } else
                System.out.println("Заданного значения нет в списке!");
        }
    }
    //Удаление элемента--//
//--Поиск элемента в списке//
    public boolean SearchValue(int IndexOutList, int searchValue) {

        boolean indicator = false;
        DoublyNode current = TopDLL;
        DoublyNode tempNode = null;
        int tempCount = 0;

        do {
            if (current.Value == searchValue) {
                tempNode = current;
                break;
            }
            current = current.Next;
            tempCount++;
        }
        while (current != TopDLL);
        if (tempNode != null) {
            System.out.println("Искомое значение есть в " + IndexOutList + "-м внешнем списке списке. Порядковый номер с начала списка: " + tempCount);
            indicator = true;
        }
        return indicator;
    }
}
    //Поиск элемента в списке--//
//Внутренний список--//

//--Элемент внешнего(базового списка)//
class OutDoublyNode {
    public DoublyLinkedList ValueInnerList; //Информационная часть
    public coad_laba_3_z_3.OutDoublyNode Previous;//Предыдущее значение
    public coad_laba_3_z_3.OutDoublyNode Next;//Следующее значение
    //Конструктор не пустого элемента
    public OutDoublyNode(DoublyLinkedList innerList) {
        ValueInnerList = innerList;
    }
    //Конструктор пустой
    public OutDoublyNode() {
        ValueInnerList = new DoublyLinkedList();
    }
}
//Элемент внешнего(базового списка)--//

//--Внешний(базовый список)//
class OutDoublyLinkedList {
    public OutDoublyNode Top = new OutDoublyNode();//Головной элемент
    public OutDoublyNode Bottom;//Конечный элемент
    private int CountOut = 0;//Количество элементов(закрытый)

    public int getCountOut() {//Количество элементов(для чтения)
        return CountOut;
    }
//Конструктор
    public OutDoublyLinkedList() {
        Top.Next = Top;
        Top.Previous = Top;
    }
//--Проверка на пустоту (тру если пуст)//
    public boolean outListIsEmpty() {
        if (CountOut == 0) {
            System.out.println("Базовый список пуст!");
            return true;
        } else
            return false;
    }
    //Проверка на пустоту (тру если пуст)--//
//--Добавление во внешний базовый список//
    public void addOutList() {
        OutDoublyNode addNode = new OutDoublyNode();

        if (CountOut == 0) {
            Top.Next = addNode;
            Top.Previous = addNode;
            Bottom = addNode;
            Bottom.Next = Top;
            Bottom.Previous = Top;
        } else {
            Bottom.Next = addNode;
            addNode.Previous = Bottom;
            addNode.Next = Top;
            Bottom = addNode;
        }
        CountOut++;
    }//Добавление во внешний базовый список--//

//--Добавление во внутренний список//
    public void addElementInInnerList(int indexInsert, int insertValue) {

        if (CountOut < indexInsert) {
            System.out.println("В списке меньше элементов!");
        } else if (indexInsert <= 0) {
            System.out.println("Значение должно быть больше нуля!");
        } else if (CountOut == indexInsert) {
            Bottom.ValueInnerList.Add(insertValue);
        } else {
            OutDoublyNode current = Top;

            for (int i = 0; i < indexInsert; i++) {
                current = current.Next;
            }

            current.ValueInnerList.Add(insertValue);
        }
    }
//Добавление во внутренний список--//
//--Поиск элемента//
    public void searchElement(int searchElement) {
        int IndexOutList = 0;
        int indicator = 0;
        if (CountOut == 0) {
            System.out.println("Нет ниодного списка для поиска!");
        } else if (searchElement == -1) {
            System.out.println("Данное число является элементом заголовка списка. Введите отличное от него число!");
        } else {
            OutDoublyNode current = Top;

            for (int i = 0; i < CountOut; i++) {
                current = current.Next;
                IndexOutList++;
                if (current.ValueInnerList.SearchValue(IndexOutList, searchElement)) {
                    indicator++;
                }
            }
            if (indicator == 0)
                System.out.println("Ни один список не содержит искомое значение.");
        }
    }//--Поиск элемента--//
//--Проверка элементов//
    public boolean checkElement(int Value) {
        if (CountOut < Value) {
            System.out.println("В списке меньше элементов!");
            return true;
        } else if (Value <= 0) {
            System.out.println("Значение должно быть больше нуля!");
            return true;
        } else
            return false;
    }//Проверка элементов--//

//--Удаление элемента из внутреннего списка//
    public void deleteElementInInnerList(int indexInsert, int DeleteValue) {

        if (DeleteValue == -1) {
            System.out.println("Данное число является элементом заголовка списка. Необходимо вводить отличное от него число!");
        }
        if (CountOut < indexInsert) {
            System.out.println("В списке меньше элементов!");
        } else if (indexInsert <= 0) {
            System.out.println("Значение должно быть больше нуля!");
        } else {
            OutDoublyNode current = Top;

            for (int i = 0; i < indexInsert; i++) {
                current = current.Next;
            }
            current.ValueInnerList.Delete(DeleteValue);
        }
    }//Удаление элемента из внутреннего списка--//

//--Удаление элемента из внешнего базового списка//
    public void deleteOutListElement(int indexDeleteValue) {
        OutDoublyNode current = Top;
        OutDoublyNode tempNode = null;

        if (indexDeleteValue <= 0) {
            System.out.println("Значение должно быть больше нуля!");
        } else if (indexDeleteValue > CountOut) {
            System.out.println("Значение больше количества элементов списка!");
        } else if (indexDeleteValue == 1 && CountOut == 1) {
            Top.Next = Top;
            Top.Previous = Top;
            CountOut--;
        } else if (CountOut == indexDeleteValue) {
            Bottom = Bottom.Previous;
            Bottom.Next = Top;

            CountOut--;
        } else {
            for (int i = 0; i < indexDeleteValue; i++) {
                current = current.Next;

            }
            tempNode = current;

            tempNode.Previous.Next = tempNode.Next;
            tempNode.Next.Previous = tempNode.Previous;

            CountOut--;
        }
    }//Удаление элемента из внешнего базового списка--//

//--Проход по списку//
    public void show() {

        OutDoublyNode current = Top.Next;
        int outIndexList = 0;
        int innerIndexList;

        do {
            if (CountOut == 0)
                System.out.println("Нет ниодного списка!");
            else {
                DoublyNode currenInner = current.ValueInnerList.TopDLL.Next;

                outIndexList++;
                System.out.println(outIndexList + "-й элемент внешнего списка:");
                innerIndexList = 0;
                do {
                    if (CountOut == 0)
                        System.out.println("Нет ниодного списка!");
                    if (currenInner.Value == -1 && currenInner.Value == -1) {
                        System.out.println("Список пуст!");
                        break;
                    } else {
                        innerIndexList++;
                        System.out.println("\t" + innerIndexList + "-й элемент внутреннего списка: " + currenInner.Value);
                        currenInner = currenInner.Next;
                    }
                } while (currenInner != current.ValueInnerList.TopDLL);
                current = current.Next;
            }
        } while (current != Top);
    }
}//Проход по списку--//
//Внешний(базовый список)--//
