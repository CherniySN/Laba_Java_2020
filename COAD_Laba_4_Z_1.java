package coad_laba_4_z_1;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

class Node {

    public int data;
    public Node left;
    public Node right;
}

class Tree {

    Random random_value = new Random();

    public Node treeCreate(int n) {
        int nl, nr;
        Node current = new Node();

        if (n == 0) {
            current = null;
        } else {
            nl = n / 2;
            nr = n - nl - 1;
            current.data = random_value.nextInt(99);
            current.left = treeCreate(nl);
            current.right = treeCreate(nr);

        }

        return current;
    }

    public void displayTree(Node root) {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 50;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++) {
                System.out.print(" ");
            }
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if (temp.left != null || temp.right != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println("......................................................");
    }

    public void traverse(int traverseType, Node localRoot) {
        switch (traverseType) {
            case 1:
                System.out.print("Обход дерева в прямом порядк: \n");
                preOrder(localRoot, 0);
                break;
            case 2:
                System.out.print("Обход дерева в семмитричном порядке:  \n");
                inOrder(localRoot, 0);
                break;
            case 3:
                System.out.print("Обход дерева в обратно-семмитричном порядке: \n");
                postOrder(localRoot, 0);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot, int level) {
        if (localRoot != null) {
            for (int i = 0; i < level * 5; i++) {
                System.out.print(" ");
            }
            System.out.print(localRoot.data + "\n");
            level++;
            preOrder(localRoot.left, level);
            preOrder(localRoot.right, level);

        }
    }

    private void inOrder(Node localRoot, int level) {
        if (localRoot != null) {
            level++;
            inOrder(localRoot.left, level);
            for (int i = 0; i < (level - 1) * 5; i++) {
                System.out.print(" ");
            }
            System.out.print(localRoot.data + "\n");
            inOrder(localRoot.right, level);

        }
    }

    private void postOrder(Node localRoot, int level) {
        if (localRoot != null) {
            level++;
            postOrder(localRoot.right, level);
            for (int i = 0; i < (level - 1) * 5; i++) {
                System.out.print(" ");
            }
            System.out.print(localRoot.data + "\n");
            postOrder(localRoot.left, level);

        }
    }

}

public class COAD_Laba_4_Z_1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = 0; //Количество Вершин
        int v = 0;

        System.out.println("Введите количество вершин дерева: ");
        n = in.nextInt();

        Tree tree = new Tree();
        Node balancedTree = tree.treeCreate(n);

        while (true) {
            System.out.println("Введите 1 для показа дерева\n"
                    + "Введите 2 для обхода дерева в прямом порядке\n"
                    + "Введите 3 для обхода дерева в семмитричном порядке\n"
                    + "Введите 4 для обхода дерева в обратно-семмитричном порядке\n"
                    + "Введите 5 для выхода");

            v = in.nextInt();

            switch (v) {
                case 1:
                    tree.displayTree(balancedTree);
                    break;
                case 2:
                    tree.traverse(1, balancedTree);
                    break;
                case 3:
                    tree.traverse(2, balancedTree);
                    break;
                case 4:
                    tree.traverse(3, balancedTree);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Введенно некоректное значение");
                    break;
            }
        }

    }
}
