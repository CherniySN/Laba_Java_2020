/*
Задание 1. Реализовать линейный динамический двунаправленный (двусвязный) список со следующим набором операций:
•	просмотр списка в прямом и обратном направлениях
•	поиск заданного элемента в прямом и обратном направлениях
•	добавление элемента перед или после заданного
•	удаление заданного элемента
Список должен иметь заголовок и быть кольцевым. Пустой список содержит только заголовок, оба 
ссылочных поля которого указывают на сам заголовок. Адрес заголовка задается глобальной ссылочной
переменной. Все операции оформляются как подпрограммы. Добавление нового элемента после заданного 
должно работать и для пустого списка (см. задание 4 из предыдущей темы).
 */
package coad_laba_3_z_1;

import java.util.Scanner;

class Link{
    public long dData;//Данные
    public Link next;//Следующий элемент в списке
    public Link previous;//Предыдущий элемент в списке
//------------------------------------------------------------------------------
    public Link(long d){//Конструктор
        dData=d;
    }
//------------------------------------------------------------------------------
    public void displayLink(){//Вывод содержимого элемента
        System.out.println(dData + "");
    }
}
//---------------------------- конец класса Link -------------------------------

//---------------------------- Класс DoublyLinkedList  -------------------------

class DoublyLinkedList {
    private Link first;//Ссылка на первый элемент списка
    private Link last;//Ссылка на последний элемент списка
//------------------------------------------------------------------------------
    public DoublyLinkedList(){
        first = null;//Список пока не содержит элемнтов
        last = null;
    }
//------------------------------------------------------------------------------
    public boolean isEmpty(){//true, если список пуст
        return (first == null);
    }
//------------------------------------------------------------------------------
    public void insertFirst(long dd){//Вставка элемента в начало списка
        Link newLink = new Link (dd);//Создание нового элемента
        if (isEmpty())//Если список не содержит элементов
            last = newLink;//newLink <-- last
        else
            first.previous = newLink;//newLink <-- старое значение first
        newLink.next = first; //newLink <-- старое значение first
        first = newLink;//first --> newLink
    }
//------------------------------------------------------------------------------
    public void insertLast(long dd){// элемент в конец списка
        Link newLink = new Link(dd);// Создание нового элемента
        if( isEmpty() )                // Если список не содержит элементов
            first = newLink;            // first --> newLink
        else{
            last.next = newLink;// старое значение last --> newLink
            newLink.previous = last;    // старое значение last <-- newLink
        }
        last = newLink;// newLink <-- last
    }
// -----------------------------------------------------------------------------
     public Link deleteFirst(){// Удаление первого элемента(предполагается, что список не пуст)
         Link temp = first;
         if(first.next == null)         // Если только один элемент
             last = null;                // null <-- last
         else
             first.next.previous = null; // null <-- старое значение next
         first = first.next;            // first --> старое значение next
         return temp;
     }
// -----------------------------------------------------------------------------
     public Link deleteLast(){// Удаление последнего элемента (предполагается, что список не пуст)
         Link temp = last;
         if(first.next == null)         // Если только один элемент
             first = null;               // first --> null
         else
             last.previous.next = null;  // старое значение previous --> null
         last = last.previous;          // старое значение previous <-- last
         return temp;
     }
// -----------------------------------------------------------------------------
     public boolean insertAfter(long key, long dd){// (предполагается, что список не пуст)
         Link current = first;          // От начала списка
         while(current.dData != key){    // Пока не будет найдено совпадение
             current = current.next;     // Переход к следующему элементу
             if(current == null)
                 return false;            // Ключ не найден
         }
         Link newLink = new Link(dd);   // Создание нового элемента
         if(current==last){              // Для последнего элемента списка
             newLink.next = null;        // newLink --> null
             last = newLink;             // newLink <-- last
         }
         else                           // Не последний элемент
         {
             newLink.next = current.next;// newLink --> старое значение next newLink <-- старое значение next
             current.next.previous = newLink;
         }
         newLink.previous = current;    // старое значение current <-- newLink
         current.next = newLink;        // старое значение current --> newLink
         return true;                   // Ключ найден, вставка выполнена
     }
// -----------------------------------------------------------------------------

    public Link deleteKey (long key){ //Удаление элемента с заданным ключем 
        Link current = first;//От начала списка
        while (current.dData != key){
            current = current.next;//Переход к следующему элементу
            if (current == null)
                return null;//Ключ не найден
        }
        if (current == first)//Ключ найден; это первый элемент?
            first = current.next;//first-->старое значение next
        else//Не первый элемент
            current.previous.next = current.next;// старое значение previous --> старое значение next
        if (current == last)//Последний элемент?
            last = current.previous;//старое значение previous <-- last
        else //Не последний элемент
            current.next.previous = current.previous;// Старое значение previous <-- старое значение next
        return current;// Возвращение удаленного элемента
    }
//------------------------------------------------------------------------------
    public void displayForward(){
        System.out.println("Список (first --> last): ");
        Link current = first;//От начала списка
        while (current != null){//Перемещение доконца списка
            current.displayLink();//Вывод данных
            current = current.next;//Переход к следующему элементу
        }
        System.out.println("");
    }
//------------------------------------------------------------------------------
    public void displayBackward(){
        System.out.println("List (last-->first): ");
        Link current = last;//От начала списка
        while (current != null){//Перемещение доконца списка
            current.displayLink();//Вывод данных
            current = current.previous;//Переход к следующему элементу
        }
        System.out.println("");
    }
//------------------------------------------------------------------------------
}
//-------------------------- конец класса DoublyLinkedList ---------------------
public class COAD_Laba_3_Z_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DoublyLinkedList theList = new DoublyLinkedList();
        
        int input = 0;
        Scanner in = new Scanner(System.in);
        
        while (true) {
            System.out.println("1.Вставка в начале\n2.Вставка в конце\n3.Вставка после...\n4.Удаление первого элемента\n5.Удаление последнего элемента\n6.Удаление элемента с ключом\n7.Вывод в прямом направлении\n8.Вывод в обратном направлени\n9.выход");
            if (in.hasNextInt()) {
                input = in.nextInt();
            } else {
                System.out.println("Ошибка. Введенный символ не является числом");
                in.close();
                System.exit(0);
            }

            switch (input) {
                case 1:
                    
                    System.out.println("Введите Значение");
                    int m = in.nextInt();
                    theList.insertFirst(m);// Вставка элемента
                    break;
                case 2:
                    System.out.println("Введите Значение");
                    int n = in.nextInt();
                    theList.insertLast(n);// Вставка элемента
                    break;
                case 3:
                    System.out.println("Введите Значение");
                    int q = in.nextInt();
                    System.out.println("Введите после какого элемента вставить?");
                    int w = in.nextInt();
                    theList.insertAfter(q, w);// Вставка элемента
                    break;                    
                case 4:
                    theList.deleteFirst();
                    break;
                case 5:
                    theList.deleteLast();
                    break;
                case 6:
                    System.out.println("Удаление элемента с ключом...");
                    int r = in.nextInt();
                    theList.deleteKey(r);// Вставка элемента
                    break;
                case 7:
                    theList.displayForward();
                    break;
                case 8:
                    theList.displayBackward();
                    break;
                case 9:
                    in.close();
                    System.exit(0);
            }
        }
 
    }
    
}
