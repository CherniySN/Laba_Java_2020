/*
������� 1. ����������� �������� ������������ ��������������� (����������) ������ �� ��������� ������� ��������:
�	�������� ������ � ������ � �������� ������������
�	����� ��������� �������� � ������ � �������� ������������
�	���������� �������� ����� ��� ����� ���������
�	�������� ��������� ��������
������ ������ ����� ��������� � ���� ���������. ������ ������ �������� ������ ���������, ��� 
��������� ���� �������� ��������� �� ��� ���������. ����� ��������� �������� ���������� ���������
����������. ��� �������� ����������� ��� ������������. ���������� ������ �������� ����� ��������� 
������ �������� � ��� ������� ������ (��. ������� 4 �� ���������� ����).
 */
package coad_laba_3_z_1;

import java.util.Scanner;

class Link{
    public long dData;//������
    public Link next;//��������� ������� � ������
    public Link previous;//���������� ������� � ������
//------------------------------------------------------------------------------
    public Link(long d){//�����������
        dData=d;
    }
//------------------------------------------------------------------------------
    public void displayLink(){//����� ����������� ��������
        System.out.println(dData + "");
    }
}
//---------------------------- ����� ������ Link -------------------------------

//---------------------------- ����� DoublyLinkedList  -------------------------

class DoublyLinkedList {
    private Link first;//������ �� ������ ������� ������
    private Link last;//������ �� ��������� ������� ������
//------------------------------------------------------------------------------
    public DoublyLinkedList(){
        first = null;//������ ���� �� �������� ��������
        last = null;
    }
//------------------------------------------------------------------------------
    public boolean isEmpty(){//true, ���� ������ ����
        return (first == null);
    }
//------------------------------------------------------------------------------
    public void insertFirst(long dd){//������� �������� � ������ ������
        Link newLink = new Link (dd);//�������� ������ ��������
        if (isEmpty())//���� ������ �� �������� ���������
            last = newLink;//newLink <-- last
        else
            first.previous = newLink;//newLink <-- ������ �������� first
        newLink.next = first; //newLink <-- ������ �������� first
        first = newLink;//first --> newLink
    }
//------------------------------------------------------------------------------
    public void insertLast(long dd){// ������� � ����� ������
        Link newLink = new Link(dd);// �������� ������ ��������
        if( isEmpty() )                // ���� ������ �� �������� ���������
            first = newLink;            // first --> newLink
        else{
            last.next = newLink;// ������ �������� last --> newLink
            newLink.previous = last;    // ������ �������� last <-- newLink
        }
        last = newLink;// newLink <-- last
    }
// -----------------------------------------------------------------------------
     public Link deleteFirst(){// �������� ������� ��������(��������������, ��� ������ �� ����)
         Link temp = first;
         if(first.next == null)         // ���� ������ ���� �������
             last = null;                // null <-- last
         else
             first.next.previous = null; // null <-- ������ �������� next
         first = first.next;            // first --> ������ �������� next
         return temp;
     }
// -----------------------------------------------------------------------------
     public Link deleteLast(){// �������� ���������� �������� (��������������, ��� ������ �� ����)
         Link temp = last;
         if(first.next == null)         // ���� ������ ���� �������
             first = null;               // first --> null
         else
             last.previous.next = null;  // ������ �������� previous --> null
         last = last.previous;          // ������ �������� previous <-- last
         return temp;
     }
// -----------------------------------------------------------------------------
     public boolean insertAfter(long key, long dd){// (��������������, ��� ������ �� ����)
         Link current = first;          // �� ������ ������
         while(current.dData != key){    // ���� �� ����� ������� ����������
             current = current.next;     // ������� � ���������� ��������
             if(current == null)
                 return false;            // ���� �� ������
         }
         Link newLink = new Link(dd);   // �������� ������ ��������
         if(current==last){              // ��� ���������� �������� ������
             newLink.next = null;        // newLink --> null
             last = newLink;             // newLink <-- last
         }
         else                           // �� ��������� �������
         {
             newLink.next = current.next;// newLink --> ������ �������� next newLink <-- ������ �������� next
             current.next.previous = newLink;
         }
         newLink.previous = current;    // ������ �������� current <-- newLink
         current.next = newLink;        // ������ �������� current --> newLink
         return true;                   // ���� ������, ������� ���������
     }
// -----------------------------------------------------------------------------

    public Link deleteKey (long key){ //�������� �������� � �������� ������ 
        Link current = first;//�� ������ ������
        while (current.dData != key){
            current = current.next;//������� � ���������� ��������
            if (current == null)
                return null;//���� �� ������
        }
        if (current == first)//���� ������; ��� ������ �������?
            first = current.next;//first-->������ �������� next
        else//�� ������ �������
            current.previous.next = current.next;// ������ �������� previous --> ������ �������� next
        if (current == last)//��������� �������?
            last = current.previous;//������ �������� previous <-- last
        else //�� ��������� �������
            current.next.previous = current.previous;// ������ �������� previous <-- ������ �������� next
        return current;// ����������� ���������� ��������
    }
//------------------------------------------------------------------------------
    public void displayForward(){
        System.out.println("������ (first --> last): ");
        Link current = first;//�� ������ ������
        while (current != null){//����������� ������� ������
            current.displayLink();//����� ������
            current = current.next;//������� � ���������� ��������
        }
        System.out.println("");
    }
//------------------------------------------------------------------------------
    public void displayBackward(){
        System.out.println("List (last-->first): ");
        Link current = last;//�� ������ ������
        while (current != null){//����������� ������� ������
            current.displayLink();//����� ������
            current = current.previous;//������� � ���������� ��������
        }
        System.out.println("");
    }
//------------------------------------------------------------------------------
}
//-------------------------- ����� ������ DoublyLinkedList ---------------------
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
            System.out.println("1.������� � ������\n2.������� � �����\n3.������� �����...\n4.�������� ������� ��������\n5.�������� ���������� ��������\n6.�������� �������� � ������\n7.����� � ������ �����������\n8.����� � �������� ����������\n9.�����");
            if (in.hasNextInt()) {
                input = in.nextInt();
            } else {
                System.out.println("������. ��������� ������ �� �������� ������");
                in.close();
                System.exit(0);
            }

            switch (input) {
                case 1:
                    
                    System.out.println("������� ��������");
                    int m = in.nextInt();
                    theList.insertFirst(m);// ������� ��������
                    break;
                case 2:
                    System.out.println("������� ��������");
                    int n = in.nextInt();
                    theList.insertLast(n);// ������� ��������
                    break;
                case 3:
                    System.out.println("������� ��������");
                    int q = in.nextInt();
                    System.out.println("������� ����� ������ �������� ��������?");
                    int w = in.nextInt();
                    theList.insertAfter(q, w);// ������� ��������
                    break;                    
                case 4:
                    theList.deleteFirst();
                    break;
                case 5:
                    theList.deleteLast();
                    break;
                case 6:
                    System.out.println("�������� �������� � ������...");
                    int r = in.nextInt();
                    theList.deleteKey(r);// ������� ��������
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
