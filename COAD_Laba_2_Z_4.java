/*

 */
package coad_laba_2_z_4;
//------------------------------Class Link--------------------------------------

import java.util.Scanner;

class Link{
    public int iData;// ������ (����)   
    public double dData;// ������
    public Link next;// ��������� ������� � ������
// -----------------------------------------------------------------------------
    public Link(int id, double dd){ // �����������
        iData = id;// ������������� ������
        dData = dd;// ('next' ������������� ������������� null)
    }        
// -----------------------------------------------------------------------------
    public void displayLink(){// ����� ����������� ��������
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}
//----------------------- ����� ������ Link ------------------------------------

//------------------------class LinkList----------------------------------------
class LinkList{
    private Link first;// ������ �� ������ ������� ������ 
// -----------------------------------------------------------------------------
    public LinkList(){// �����������
        first = null;// ������ ���� �� �������� ���������
    }
//------------------------------------------------------------------------------
    public boolean isEmpty(){// true, ���� ������ ����
        return (first==null);
    }
// -----------------------------------------------------------------------------
// ������� �������� � ������ ������ 
    public void insertFirst(int id, double dd){// �������� ������ ��������
        
            Link newLink = new Link(id, dd);
            newLink.next = first;// newLink --> ������ �������� first
            first = newLink;// first --> newLink
        
    }
// -----------------------------------------------------------------------------
    public Link deleteFirst(){// �������� ������� �������� (��������������, ��� ������ �� ����)
        Link temp = first;// ���������� ������
        first = first.next;// ��������: first-->������ �� ������ �������
        return temp;// ����� ���������� ������ �� ��������� �������
    }
// -----------------------------------------------------------------------------
      public void displayList(){
          System.out.print("List (first-->last): ");
          Link current = first;// �� ������ ������
          while(current != null){// ����������� �� ����� ������
              current.displayLink();// ����� ������
              current = current.next;// ������� � ���������� ��������
          }
          System.out.println("");
      }
}
//----------------------------- ����� ������ LinkList --------------------------

public class COAD_Laba_2_Z_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkList theList = new LinkList();  // �������� ������ ������
        
        theList.insertFirst(33, 2.65);      // ������� ���� ���������
        theList.insertFirst(32, 3.65);
        theList.insertFirst(31, 4.65);
              
        int input = 0;
        Scanner in = new Scanner(System.in);
        
        while (true) {
            System.out.println("1.���������� �������� � ������\n2.�������� �������� �� ������\n3.����� ������\n4.�������� �� �������\n5.�����");
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
                    theList.insertFirst(n, m);// ������� ��������
                    break;
                case 2:
                    Link aLink = theList.deleteFirst();   // �������� ��������
                    System.out.print("Deleted ");         // ����� ���������� ��������
                    aLink.displayLink();
                    System.out.println("");
                    break;
                case 3:
                    theList.displayList();              // ����� ����������� ������
                    break;
                case 4:
                    theList.isEmpty();             // �������� �� �������
                    break;
                case 5:
                    in.close();
                    System.exit(0);
            }
        }
    }    
}
