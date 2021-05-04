/*
Задание 6. Реализовать тот же набор действий на основе динамического 
распределения памяти.

Требования аналогичны заданию 1, за исключением того, что проверку 
заполненности очереди проводить не надо. Пустая очередь содержит только 
заголовочный элемент

 */
package coad_laba_1_z_6;
import java.util.Scanner;
//----------------------------Начало класса Link--------------------------------
class Link{
    public long dData;//Данные
    public Link next;//Следующий элемент в списке
//------------------------------------------------------------------------------
    public Link (long d){//Конструктор
        dData=d;
    }
//------------------------------------------------------------------------------
    public void displayLink(){
        System.out.println(dData + " ");
    }
}
//--------------------- Конец класса Link --------------------------------------
//----------------------Класс FirstLastList-------------------------------------
class FirstLastList{
    private Link first;//Ссылка на первый элемент
    private Link last;//Ссылка на второй элемент
//------------------------------------------------------------------------------
    public FirstLastList(){//Конструктор
        first=null;//Список пока не содержит элементов
        last=null;
    }
//------------------------------------------------------------------------------
    public boolean isEmpty(){//true если список пуст
        return first == null;
    }
//------------------------------------------------------------------------------
     public void insertLast(long dd){   // Вставка элемента в конец списка
         Link newLink = new Link(dd);   // Создание нового элемента
         if( isEmpty())// Если список пуст,
             first = newLink;// first --> newLink
         else
             last.next = newLink;// Старое значение last --> newLink
         last = newLink;// newLink <-- last
     } 
// -----------------------------------------------------------------------------
      public long deleteFirst(){// Удаление первого элемента(предполагается, что список не пуст)
          long temp = first.dData;
          if(first.next == null)// Сохранение ссылки
              last = null;// null <-- last
          first = first.next;// first --> старое значение next
          return temp;
      }
// -----------------------------------------------------------------------------
      public void displayList(){
          Link current = first;//От начала списка
          while (current !=null){
              current.displayLink();//Вывод даных
              current = current.next;//Переход к следующему элементу
          }
          System.out.println();
      }
}
//-------------------------- Конец класса FirstLastList ------------------------

//---------------------------Начало класса LinkQueue----------------------------
class LinkQueue{
    private FirstLastList theList;
//------------------------------------------------------------------------------
    public LinkQueue(){// Конструктор
      theList = new FirstLastList();// Создание 2-стороннего списка
    }
//------------------------------------------------------------------------------
    public boolean isEmpty(){// true, если очередь пуста
      return theList.isEmpty();
    }
//------------------------------------------------------------------------------
    public void insert(long j){// Вставка элемента в конец очереди
        theList.insertLast(j);
    } 
//------------------------------------------------------------------------------
    public long remove(){// Удаление элемента в начале очереди
       return theList.deleteFirst();
    }
//------------------------------------------------------------------------------
    public void displayQueue(){//Вывод на экран
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }
}
//---------------------------Клнец класса LinkQueue-----------------------------
    
public class COAD_Laba_1_Z_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkQueue theQueue = new LinkQueue();
        Scanner input = new Scanner(System.in);
        
        int UserInput;
        long UserInpuForPush;
        
         theQueue.insert(20);// Вставка элементов
         theQueue.insert(40);
         
          while (true){
              System.out.println("Какую операцию выполнить?");
              System.out.println(" 1 - Удаление ; 2 - Вставка элемента; 3 - Вывод на экран;");
              System.out.println("4 - Проверка пустоты;");
              switch (UserInput=input.nextInt()){
                case 1:
                System.out.println("Удален элемент из очереди "+theQueue.remove());
                break;
              case 2:
                System.out.println("Введите элемент для добавления в очередь");
                UserInpuForPush = input.nextLong();
                theQueue.insert(UserInpuForPush);
                break;
              case 3:
                System.out.println("Очередь содержит в начале ");
                theQueue.displayQueue();
                break;
              case 4:
                System.out.println("Очередь пуста " + theQueue.isEmpty());
                break;
              default:
                break;           
            }        
    System.out.println("");
        }
    }
}
    

