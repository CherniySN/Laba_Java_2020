
/*
������� 3. �������� � ���������� ��������� ����������� ��������� � ���� ����� 
���������� ��������. ���������� �������� �������� ������ ������������� � 
������������, � ���� �������� ����� ����������� ��������� ������� � ������� 
������� Random (�� ������ �������������� ������� ������� Randomize). ���������
����������������� ��������� ��� ��������� ����������� �������� ���������, � ���
����� � ��� ������� �������� (������� ����� ���������).
 */
package coad_laba_1_z_3;
import java.util.Scanner;
import java.lang.Math;
/*
��������� ���� � ���� ������ � ������ Link �� ���� ���������� ������
 */

//------------------------------������ ������ StackX----------------------------
class Link{
    public long dData;//������
    public Link next;//��������� ������� � ������
//------------------------------------------------------------------------------
    public Link (long dd){//�����������
    dData = dd;
    }
//------------------------------------------------------------------------------
    public void displayLink(){//����� ����������� ��������
        System.out.print(dData + " ");
    }
}
//-------------------------����� ������ Link------------------------------------
//--------------------------����� LinkList--------------------------------------
    class LinkList{
        private Link first;//������ �� ������ ������� � ������
//------------------------------------------------------------------------------
    public LinkList(){//�����������
        first = null; //������ ���� �� �������� ���������
    }
//------------------------------------------------------------------------------
    public boolean isEmpty (){//true ���� ������ ����
        return (first == null);
    }
//------------------------------------------------------------------------------
    public void insertFirst(int dd){ // ������� �������� � ������ ������
        long past;
        for (int i =0; i < dd; i++){
            past = (long)(Math.random()*200-100);
            Link newLink = new Link (past);
            newLink.next=first; //newLink - ������ �������� first
            first = newLink; //first - newlink
            System.out.println("� ���� �������� ������� " + past);
        }
    }
//------------------------------------------------------------------------------
    public long deleteFirst(){//�������� ������� �������� (��������������, ��� ������ �� ������!!!)
        Link temp = first;//���������� ������
        first = first.next;//��������: first - ������ �� ������ �������
        return temp.dData;//���������� ������ ���������� �������� 
    }
//------------------------------------------------------------------------------
    public void displayList(){
        Link current = first; // �� ������ ������
        while (current != null){//����������� ������� ������
            current.displayLink();//����� ������
            current = current.next;//������� � ��������� ��������
        }
        System.out.println("");
    }
}
//----------------------------����� ������ LinkList-------------------------------
//----------------------------����� LinkStack-------------------------------------     
    class LinkStack{
        private LinkList theList;
//--------------------------------------------------------------
        public LinkStack(){ // �����������
            theList = new LinkList();
        }
//--------------------------------------------------------------
        public void push(int j){ // ���������� �������� �� ������� �����
            theList.insertFirst(j);
        }
//--------------------------------------------------------------
        public long pop(){ // ���������� �������� � ������� �����
            return theList.deleteFirst();
        }
//--------------------------------------------------------------
        public boolean isEmpty(){ // true, ���� ���� ����
            return ( theList.isEmpty() );
        }
//--------------------------------------------------------------
        public void displayStack(){
            System.out.print("Stack (top-->bottom): ");
            theList.displayList();
        }
    }
//---------------------------- ����� ������ LinkStack ----------------------------------

public class COAD_Laba_1_Z_3 {

    /*
    ���������� �������� ����. �.�. �� ����!!!!!!!!!!!!!!!
    ������ �������� - 2 �������!!!!!!!!!!!!!!!!!!
     */
public static void main(String[] args) {
        // TODO code application logic here
        int UserInput;
        int UserInpuForPush;
        Scanner input = new Scanner (System.in);
        LinkStack theStack = new LinkStack();//�������� ������ ����
        
//---------------------------������ � �������������-----------------------------
        while (true){
            System.out.println("����� �������� ���������? 1 - �������� ; 2 - ������� N ���������; 3 - ����� �� �����;");
            switch (UserInput=input.nextInt()){
                case 1:
                    System.out.println("������ ������� �� top "+theStack.pop());
                    break;
                case 2:
                    System.out.println("������� ���������� ��������� ��� ���������� � ����");
                    UserInpuForPush = input.nextInt();
                    theStack.push(UserInpuForPush);
                    break;
                case 3:
                    System.out.println("���� �������� ");
                    theStack.displayStack();
                    break;
                default:
                    break;           
            }        
        System.out.println("");
        }
    }
}
/* ����� ������� 100 000 ���������. �����:

������� � �������� � ������ ���������� ������ ����������� ����� ������. 
�������� �������� � ��������� ����� ��� ���� ������, ������������ �� ����� O(1).
�����, �������� � ������� ����� � ���������� ��������� ������� ��������
� ������� �������� ��������� ������, ��� �������� ���������� O(N) ���������.
� ������� ��� �������� ���� ����������� �� ����� O(N), �� ��������� ������ ���
����� �������� �������, ������ ��� �� �� ������� ����������� ��������� ��� 
������� ��� ��������. ��������� ������������� ����� ���� ������ ������������,
�������� ���� ����������� �������� ����������� ������ �������, ��� ���������.
������ ������ ������������ ��������� ������� ����� ��������� ����������� � ���,
��� ��������� ������ ������ ���������� ����� ������� ������, �������
����������, � ����� ����������� ������ �� ���� ��������� ������. 
*/