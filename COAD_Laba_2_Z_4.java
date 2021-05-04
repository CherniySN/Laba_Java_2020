/*

 */
package coad_laba_2_z_4;
//------------------------------Class Link--------------------------------------

import java.util.Scanner;

class Link{
    public int iData;// Данные (ключ)   
    public double dData;// Данные
    public Link next;// Следующий элемент в списке
// -----------------------------------------------------------------------------
    public Link(int id, double dd){ // Конструктор
        iData = id;// Инициализация данных
        dData = dd;// ('next' автоматически присваивается null)
    }        
// -----------------------------------------------------------------------------
    public void displayLink(){// Вывод содержимого элемента
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}
//----------------------- Конец класса Link ------------------------------------

//------------------------class LinkList----------------------------------------
class LinkList{
    private Link first;// Ссылка на первый элемент списка 
// -----------------------------------------------------------------------------
    public LinkList(){// Конструктор
        first = null;// Список пока не содержит элементов
    }
//------------------------------------------------------------------------------
    public boolean isEmpty(){// true, если список пуст
        return (first==null);
    }
// -----------------------------------------------------------------------------
// Вставка элемента в начало списка 
    public void insertFirst(int id, double dd){// Создание нового элемента
        
            Link newLink = new Link(id, dd);
            newLink.next = first;// newLink --> старое значение first
            first = newLink;// first --> newLink
        
    }
// -----------------------------------------------------------------------------
    public Link deleteFirst(){// Удаление первого элемента (предполагается, что список не пуст)
        Link temp = first;// Сохранение ссылки
        first = first.next;// Удаление: first-->ссылка на второй элемент
        return temp;// Метод возвращает ссылку на удаленный элемент
    }
// -----------------------------------------------------------------------------
      public void displayList(){
          System.out.print("List (first-->last): ");
          Link current = first;// От начала списка
          while(current != null){// Перемещение до конца списка
              current.displayLink();// Вывод данных
              current = current.next;// Переход к следующему элементу
          }
          System.out.println("");
      }
}
//----------------------------- Конец класса LinkList --------------------------

public class COAD_Laba_2_Z_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkList theList = new LinkList();  // Создание нового списка
        
        theList.insertFirst(33, 2.65);      // Вставка трех элементов
        theList.insertFirst(32, 3.65);
        theList.insertFirst(31, 4.65);
              
        int input = 0;
        Scanner in = new Scanner(System.in);
        
        while (true) {
            System.out.println("1.Добавление элемента в список\n2.Удаление элемента из списка\n3.Вывод списка\n4.Проверка на пустоту\n5.Выход");
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
                    theList.insertFirst(n, m);// Вставка элемента
                    break;
                case 2:
                    Link aLink = theList.deleteFirst();   // Удаление элемента
                    System.out.print("Deleted ");         // Вывод удаленного элемента
                    aLink.displayLink();
                    System.out.println("");
                    break;
                case 3:
                    theList.displayList();              // Вывод содержимого списка
                    break;
                case 4:
                    theList.isEmpty();             // Проверка на пустоту
                    break;
                case 5:
                    in.close();
                    System.exit(0);
            }
        }
    }    
}
