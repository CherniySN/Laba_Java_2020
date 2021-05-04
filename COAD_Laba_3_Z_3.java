/*
������� 3. ����������� ����� ����������� ��� ���������� �������� �������� �� ������� �������.
���������� ���������� ����������� �������.
 */
package coad_laba_3_z_3;

import java.util.Scanner;


public class COAD_Laba_3_Z_3 {
    public static void main(String[] args) {
        boolean indicatorDialog = true;

        OutDoublyLinkedList outDoublyLinkedList = new OutDoublyLinkedList();
        Scanner intIndexOutList = new Scanner(System.in);
        while (indicatorDialog) {
            System.out.println("���� ������������.\n" +
                    "������� ����� �� ���� ��� ���������� ��������:\n" +
                    "1) ������ ������ �� ���������;\n" +
                    "2) ����� ��������� ��������;\n" +
                    "3) ���������� ������ �������� � ������� ������ � ������ ��������� �������;\n" +
                    "4) ���������� ������ �������� � ��������� ������;\n" +
                    "5) �������� �������� �� ���������� ������;\n" +
                    "6) �������� �������� �� �������� �������;\n" +
                    "7) �����.\n");
            Scanner input = new Scanner(System.in);
            if (!input.hasNextInt())
                System.out.println("�� ����� �� �����!");
            else {
                switch (input.nextInt()) {
                    case 1:
                        outDoublyLinkedList.show();
                        break;
                    case 2:
			if (!outDoublyLinkedList.outListIsEmpty()) {
                        System.out.println("������� ��������, ������� ����� �����:");
                        Scanner intValueForSearch = new Scanner(System.in);
                        if (!intValueForSearch.hasNextInt())
                            System.out.println("�� ����� �� �����!");
                        else
                            outDoublyLinkedList.searchElement(intValueForSearch.nextInt());
			}
                        break;
                    case 3:
                        outDoublyLinkedList.addOutList();
                        break;
                    case 4:
                        if (!outDoublyLinkedList.outListIsEmpty()) {
                            System.out.println("������� ������ �������� ������, � ������� ���� �������� �������:");
                            intIndexOutList = new Scanner(System.in);
                            if (!intIndexOutList.hasNextInt()) {
                                System.out.println("�� ����� �� �����!");
                            } else {
                                int intIndexOutListForMethod = intIndexOutList.nextInt();
                                if(outDoublyLinkedList.checkElement(intIndexOutListForMethod))
                                    continue;
                                System.out.println("������� �����, ������� ���� ��������:");
                                Scanner intValueForInnerList = new Scanner(System.in);
                                if (!intValueForInnerList.hasNextInt())
                                    System.out.println("�� ����� �� �����!");
                                else {
                                    outDoublyLinkedList.addElementInInnerList(intIndexOutListForMethod, intValueForInnerList.nextInt());
                                }
                            }
                        }
                        break;
                    case 5:
                        if (!outDoublyLinkedList.outListIsEmpty()) {
                            System.out.println("������� ������ �������� ������, � ������� ���� ������� �������:");
                            Scanner IndexOutList = new Scanner(System.in);
                            if (!IndexOutList.hasNextInt()) {
                                System.out.println("�� ����� �� �����!");
                            }
                            else {
                                int intIndex = IndexOutList.nextInt();
                                if (outDoublyLinkedList.checkElement(intIndex))
                                    continue;
                                System.out.println("������� �����, ������� ���� �������:");
                                Scanner intValueForInnerList = new Scanner(System.in);
                                if (!intValueForInnerList.hasNextInt())
                                    System.out.println("�� ����� �� �����!");
                                else {
                                    outDoublyLinkedList.deleteElementInInnerList(intIndexOutList.nextInt(), intValueForInnerList.nextInt());
                                }
                            }
                        }
                        break;
                    case 6:
                        if (!outDoublyLinkedList.outListIsEmpty()) {
                            System.out.println("������� ������ �������� ������, ������� ���� �������:");
                            Scanner intIndexOutLIst = new Scanner(System.in);
                            if (!intIndexOutLIst.hasNextInt()) {
                                System.out.println("�� ����� �� �����!");
                            } else {
                                outDoublyLinkedList.deleteOutListElement(intIndexOutLIst.nextInt());
                            }
                        }
                        break;
                    case 7:
                        indicatorDialog = false;
                        break;
                    default:
                        System.out.println("��������� ����� �� ������������� ������ ����. ������� ����� 1 - 7.");
                        break;
                }
            }
        }
    }
}
//--������� ����������� ������//
class DoublyNode {
    public int Value; //�������������� �����
    public coad_laba_3_z_3.DoublyNode Previous;//���������� �������
    public coad_laba_3_z_3.DoublyNode Next;//��������� �������
    //����������
    public DoublyNode(int value) {
        Value = value;
    }
}//������� ����������� ������ --//

//--���������� ������//
class DoublyLinkedList {
    public DoublyNode TopDLL = new DoublyNode(-1);//�������� �������
    public DoublyNode BottomDLL;//�������� �������
    public int Count = 0;//��������� �������� � ������
    //����������
    public DoublyLinkedList() {
        TopDLL.Next = TopDLL;
        TopDLL.Previous = TopDLL;
    }
//--���������� ��������//
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
    //���������� ��������--//
//--�������� ��������
    public void Delete(int deleteValue) {
        DoublyNode current = TopDLL;
        DoublyNode tempNode = null;
        if (Count == 0)
            System.out.println("������ ����!");
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
                System.out.println("��������� �������� ��� � ������!");
        }
    }
    //�������� ��������--//
//--����� �������� � ������//
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
            System.out.println("������� �������� ���� � " + IndexOutList + "-� ������� ������ ������. ���������� ����� � ������ ������: " + tempCount);
            indicator = true;
        }
        return indicator;
    }
}
    //����� �������� � ������--//
//���������� ������--//

//--������� ��������(�������� ������)//
class OutDoublyNode {
    public DoublyLinkedList ValueInnerList; //�������������� �����
    public coad_laba_3_z_3.OutDoublyNode Previous;//���������� ��������
    public coad_laba_3_z_3.OutDoublyNode Next;//��������� ��������
    //����������� �� ������� ��������
    public OutDoublyNode(DoublyLinkedList innerList) {
        ValueInnerList = innerList;
    }
    //����������� ������
    public OutDoublyNode() {
        ValueInnerList = new DoublyLinkedList();
    }
}
//������� ��������(�������� ������)--//

//--�������(������� ������)//
class OutDoublyLinkedList {
    public OutDoublyNode Top = new OutDoublyNode();//�������� �������
    public OutDoublyNode Bottom;//�������� �������
    private int CountOut = 0;//���������� ���������(��������)

    public int getCountOut() {//���������� ���������(��� ������)
        return CountOut;
    }
//�����������
    public OutDoublyLinkedList() {
        Top.Next = Top;
        Top.Previous = Top;
    }
//--�������� �� ������� (��� ���� ����)//
    public boolean outListIsEmpty() {
        if (CountOut == 0) {
            System.out.println("������� ������ ����!");
            return true;
        } else
            return false;
    }
    //�������� �� ������� (��� ���� ����)--//
//--���������� �� ������� ������� ������//
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
    }//���������� �� ������� ������� ������--//

//--���������� �� ���������� ������//
    public void addElementInInnerList(int indexInsert, int insertValue) {

        if (CountOut < indexInsert) {
            System.out.println("� ������ ������ ���������!");
        } else if (indexInsert <= 0) {
            System.out.println("�������� ������ ���� ������ ����!");
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
//���������� �� ���������� ������--//
//--����� ��������//
    public void searchElement(int searchElement) {
        int IndexOutList = 0;
        int indicator = 0;
        if (CountOut == 0) {
            System.out.println("��� �������� ������ ��� ������!");
        } else if (searchElement == -1) {
            System.out.println("������ ����� �������� ��������� ��������� ������. ������� �������� �� ���� �����!");
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
                System.out.println("�� ���� ������ �� �������� ������� ��������.");
        }
    }//--����� ��������--//
//--�������� ���������//
    public boolean checkElement(int Value) {
        if (CountOut < Value) {
            System.out.println("� ������ ������ ���������!");
            return true;
        } else if (Value <= 0) {
            System.out.println("�������� ������ ���� ������ ����!");
            return true;
        } else
            return false;
    }//�������� ���������--//

//--�������� �������� �� ����������� ������//
    public void deleteElementInInnerList(int indexInsert, int DeleteValue) {

        if (DeleteValue == -1) {
            System.out.println("������ ����� �������� ��������� ��������� ������. ���������� ������� �������� �� ���� �����!");
        }
        if (CountOut < indexInsert) {
            System.out.println("� ������ ������ ���������!");
        } else if (indexInsert <= 0) {
            System.out.println("�������� ������ ���� ������ ����!");
        } else {
            OutDoublyNode current = Top;

            for (int i = 0; i < indexInsert; i++) {
                current = current.Next;
            }
            current.ValueInnerList.Delete(DeleteValue);
        }
    }//�������� �������� �� ����������� ������--//

//--�������� �������� �� �������� �������� ������//
    public void deleteOutListElement(int indexDeleteValue) {
        OutDoublyNode current = Top;
        OutDoublyNode tempNode = null;

        if (indexDeleteValue <= 0) {
            System.out.println("�������� ������ ���� ������ ����!");
        } else if (indexDeleteValue > CountOut) {
            System.out.println("�������� ������ ���������� ��������� ������!");
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
    }//�������� �������� �� �������� �������� ������--//

//--������ �� ������//
    public void show() {

        OutDoublyNode current = Top.Next;
        int outIndexList = 0;
        int innerIndexList;

        do {
            if (CountOut == 0)
                System.out.println("��� �������� ������!");
            else {
                DoublyNode currenInner = current.ValueInnerList.TopDLL.Next;

                outIndexList++;
                System.out.println(outIndexList + "-� ������� �������� ������:");
                innerIndexList = 0;
                do {
                    if (CountOut == 0)
                        System.out.println("��� �������� ������!");
                    if (currenInner.Value == -1 && currenInner.Value == -1) {
                        System.out.println("������ ����!");
                        break;
                    } else {
                        innerIndexList++;
                        System.out.println("\t" + innerIndexList + "-� ������� ����������� ������: " + currenInner.Value);
                        currenInner = currenInner.Next;
                    }
                } while (currenInner != current.ValueInnerList.TopDLL);
                current = current.Next;
            }
        } while (current != Top);
    }
}//������ �� ������--//
//�������(������� ������)--//
