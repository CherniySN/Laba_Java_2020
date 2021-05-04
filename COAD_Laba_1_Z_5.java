/*
Задание 5. 

    Реализовать программу, выполняющую стандартный набор операций с 
кольцевой (циклической или кольцевой буфер) очередью на основе массива:
•	проверку пустоты очереди
•	проверку заполненности очереди
•	добавление элемента в конец очереди
•	удаление элемента из начала очереди
•	вывод текущего состояния очереди на экран
    Требования к программе:
•	все действия должны быть оформлены как процедуры или функции
•	добавлению/удалению должна предшествовать проверка возможности выполнения этих операций
•	главная программа реализует следующий набор действий:
o	инициализация пустой очереди
o	организация диалогового цикла с пользователем

 */
package coad_laba_1_z_5;
import java.util.Scanner;
//------------------------Начало класса Queue-----------------------------------
class Queue{
    private int maxSaize;
    private long [] queArray;
    private int front;
    private int rear;
    private int nItems;

//------------------------------------------------------------------------------
public Queue (int s){//Конструктор
    maxSaize = s;
    queArray = new long [maxSaize];
    front = 0;
    rear = -1;
    nItems = 0;
}
//------------------------------------------------------------------------------
public void insert (long j){//Вставка элементов в конец очереди
    if (rear == maxSaize - 1)//Циклический перенос
        rear = -1;
        queArray[++rear] = j;// Увеличение rear и вставка
        nItems++;// Увеличение количества элементов
}
//------------------------------------------------------------------------------
public long remove(){// Извлечение элемента в начале очереди
    long temp = queArray[front++];// Выборка и увеличение front
    if (front == maxSaize)// Циклический перенос
        front = 0;
        nItems--;
        return temp; // Уменьшение количества элементов
}
//------------------------------------------------------------------------------
public long peekFront(){// Чтение элемента в начале очереди
    return queArray[front];
}
//------------------------------------------------------------------------------
public boolean isEmpty(){// true, если очередь пуста
    return (nItems==0);
}
//------------------------------------------------------------------------------
public boolean isFull(){// true, если очередь заполнена
    return (nItems==maxSaize);
}
//------------------------------------------------------------------------------
public int size(){// Количество элементов в очереди
    return nItems;
} 
//------------------------------------------------------------------------------
}
//----------------------------КОНЕЦ КЛАССА Queue--------------------------------

public class COAD_Laba_1_Z_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Queue theQueue = new Queue (5); //Очередь из пяти ячеек
    Scanner input = new Scanner(System.in);
    
    int UserInput;
    long UserInpuForPush;
    
    theQueue.insert(10);            // Вставка 4 элементов
    theQueue.insert(20);      
    theQueue.insert(30);      
    theQueue.insert(40);
//---------------------------Диалог с пользователем-----------------------------
    while (true){
        System.out.println("Какую операцию выполнить?");
        System.out.println(" 1 - Удаление ; 2 - Вставка элемента; 3 - Вывод на экран;");
        System.out.println("4 - Проверка пустоты; 5 - Проверка заполненности; 6 - Количество элементов в очереди");
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
                System.out.println(theQueue.peekFront());
                break;
            case 4:
                System.out.println("Очередь пуста " + theQueue.isEmpty());
                break;
            case 5:
                System.out.println("Очередь заполнена " +theQueue.isFull());
                break;
            case 6:
                System.out.println("Количество элементов в очереди " + theQueue.size());
                break; 
            default:
                break;           
        }        
    System.out.println("");
    }
    }
}
