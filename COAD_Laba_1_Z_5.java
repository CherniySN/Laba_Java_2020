/*
������� 5. 

    ����������� ���������, ����������� ����������� ����� �������� � 
��������� (����������� ��� ��������� �����) �������� �� ������ �������:
�	�������� ������� �������
�	�������� ������������� �������
�	���������� �������� � ����� �������
�	�������� �������� �� ������ �������
�	����� �������� ��������� ������� �� �����
    ���������� � ���������:
�	��� �������� ������ ���� ��������� ��� ��������� ��� �������
�	����������/�������� ������ �������������� �������� ����������� ���������� ���� ��������
�	������� ��������� ��������� ��������� ����� ��������:
o	������������� ������ �������
o	����������� ����������� ����� � �������������

 */
package coad_laba_1_z_5;
import java.util.Scanner;
//------------------------������ ������ Queue-----------------------------------
class Queue{
    private int maxSaize;
    private long [] queArray;
    private int front;
    private int rear;
    private int nItems;

//------------------------------------------------------------------------------
public Queue (int s){//�����������
    maxSaize = s;
    queArray = new long [maxSaize];
    front = 0;
    rear = -1;
    nItems = 0;
}
//------------------------------------------------------------------------------
public void insert (long j){//������� ��������� � ����� �������
    if (rear == maxSaize - 1)//����������� �������
        rear = -1;
        queArray[++rear] = j;// ���������� rear � �������
        nItems++;// ���������� ���������� ���������
}
//------------------------------------------------------------------------------
public long remove(){// ���������� �������� � ������ �������
    long temp = queArray[front++];// ������� � ���������� front
    if (front == maxSaize)// ����������� �������
        front = 0;
        nItems--;
        return temp; // ���������� ���������� ���������
}
//------------------------------------------------------------------------------
public long peekFront(){// ������ �������� � ������ �������
    return queArray[front];
}
//------------------------------------------------------------------------------
public boolean isEmpty(){// true, ���� ������� �����
    return (nItems==0);
}
//------------------------------------------------------------------------------
public boolean isFull(){// true, ���� ������� ���������
    return (nItems==maxSaize);
}
//------------------------------------------------------------------------------
public int size(){// ���������� ��������� � �������
    return nItems;
} 
//------------------------------------------------------------------------------
}
//----------------------------����� ������ Queue--------------------------------

public class COAD_Laba_1_Z_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Queue theQueue = new Queue (5); //������� �� ���� �����
    Scanner input = new Scanner(System.in);
    
    int UserInput;
    long UserInpuForPush;
    
    theQueue.insert(10);            // ������� 4 ���������
    theQueue.insert(20);      
    theQueue.insert(30);      
    theQueue.insert(40);
//---------------------------������ � �������������-----------------------------
    while (true){
        System.out.println("����� �������� ���������?");
        System.out.println(" 1 - �������� ; 2 - ������� ��������; 3 - ����� �� �����;");
        System.out.println("4 - �������� �������; 5 - �������� �������������; 6 - ���������� ��������� � �������");
        switch (UserInput=input.nextInt()){
            case 1:
                System.out.println("������ ������� �� ������� "+theQueue.remove());
                break;
            case 2:
                System.out.println("������� ������� ��� ���������� � �������");
                UserInpuForPush = input.nextLong();
                theQueue.insert(UserInpuForPush);
                break;
            case 3:
                System.out.println("������� �������� � ������ ");
                System.out.println(theQueue.peekFront());
                break;
            case 4:
                System.out.println("������� ����� " + theQueue.isEmpty());
                break;
            case 5:
                System.out.println("������� ��������� " +theQueue.isFull());
                break;
            case 6:
                System.out.println("���������� ��������� � ������� " + theQueue.size());
                break; 
            default:
                break;           
        }        
    System.out.println("");
    }
    }
}
