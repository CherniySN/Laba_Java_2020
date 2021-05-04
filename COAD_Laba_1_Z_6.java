/*
������� 6. ����������� ��� �� ����� �������� �� ������ ������������� 
������������� ������.

���������� ���������� ������� 1, �� ����������� ����, ��� �������� 
������������� ������� ��������� �� ����. ������ ������� �������� ������ 
������������ �������

 */
package coad_laba_1_z_6;
import java.util.Scanner;
//----------------------------������ ������ Link--------------------------------
class Link{
    public long dData;//������
    public Link next;//��������� ������� � ������
//------------------------------------------------------------------------------
    public Link (long d){//�����������
        dData=d;
    }
//------------------------------------------------------------------------------
    public void displayLink(){
        System.out.println(dData + " ");
    }
}
//--------------------- ����� ������ Link --------------------------------------
//----------------------����� FirstLastList-------------------------------------
class FirstLastList{
    private Link first;//������ �� ������ �������
    private Link last;//������ �� ������ �������
//------------------------------------------------------------------------------
    public FirstLastList(){//�����������
        first=null;//������ ���� �� �������� ���������
        last=null;
    }
//------------------------------------------------------------------------------
    public boolean isEmpty(){//true ���� ������ ����
        return first == null;
    }
//------------------------------------------------------------------------------
     public void insertLast(long dd){   // ������� �������� � ����� ������
         Link newLink = new Link(dd);   // �������� ������ ��������
         if( isEmpty())// ���� ������ ����,
             first = newLink;// first --> newLink
         else
             last.next = newLink;// ������ �������� last --> newLink
         last = newLink;// newLink <-- last
     } 
// -----------------------------------------------------------------------------
      public long deleteFirst(){// �������� ������� ��������(��������������, ��� ������ �� ����)
          long temp = first.dData;
          if(first.next == null)// ���������� ������
              last = null;// null <-- last
          first = first.next;// first --> ������ �������� next
          return temp;
      }
// -----------------------------------------------------------------------------
      public void displayList(){
          Link current = first;//�� ������ ������
          while (current !=null){
              current.displayLink();//����� �����
              current = current.next;//������� � ���������� ��������
          }
          System.out.println();
      }
}
//-------------------------- ����� ������ FirstLastList ------------------------

//---------------------------������ ������ LinkQueue----------------------------
class LinkQueue{
    private FirstLastList theList;
//------------------------------------------------------------------------------
    public LinkQueue(){// �����������
      theList = new FirstLastList();// �������� 2-���������� ������
    }
//------------------------------------------------------------------------------
    public boolean isEmpty(){// true, ���� ������� �����
      return theList.isEmpty();
    }
//------------------------------------------------------------------------------
    public void insert(long j){// ������� �������� � ����� �������
        theList.insertLast(j);
    } 
//------------------------------------------------------------------------------
    public long remove(){// �������� �������� � ������ �������
       return theList.deleteFirst();
    }
//------------------------------------------------------------------------------
    public void displayQueue(){//����� �� �����
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }
}
//---------------------------����� ������ LinkQueue-----------------------------
    
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
        
         theQueue.insert(20);// ������� ���������
         theQueue.insert(40);
         
          while (true){
              System.out.println("����� �������� ���������?");
              System.out.println(" 1 - �������� ; 2 - ������� ��������; 3 - ����� �� �����;");
              System.out.println("4 - �������� �������;");
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
                theQueue.displayQueue();
                break;
              case 4:
                System.out.println("������� ����� " + theQueue.isEmpty());
                break;
              default:
                break;           
            }        
    System.out.println("");
        }
    }
}
    

