public class Main {
    public static void main(String[] args) {
        

        BinaryTree tree = new BinaryTree();

        // Inserir valores na árvore
        tree.insert(22);
        tree.insert(31);
        tree.insert(27);
        tree.insert(29);
        tree.insert(13);

        tree.printTreeStructure(tree.root, "");
        System.out.println("deletando valor 22");
        tree.delete(27);
        System.out.println(" ");
        tree.printTreeStructure(tree.root, "");
        System.out.println();


        }}
            /*BinaryTree tree = new BinaryTree();

            tree.insert(17);
            tree.insert(20);
            tree.insert(28);
            tree.insert(14);
            tree.insert(16);
            tree.insert(21);
            tree.insert(22);


            System.out.println("In-order traversal:");
            tree.inorderTraversal(tree.root);
            System.out.println();
            System.out.println();
            System.out.println("Pre-order traversal:");
            tree.preorderTraversal(tree.root);
            System.out.println();
            System.out.println();
            System.out.println("Post-order traversal");
            tree.postorderTraversal(tree.root);
            System.out.println();
            System.out.println();
            System.out.println("Tree structure:");
            tree.printTreeStructure(tree.root, "");
            System.out.println();
            System.out.println();
            int param = 8555;
            int result = tree.search(param).element;
            if (param == result) System.out.println("Valor encontrado na árvore: " + result);
        }catch (Exception ex){
            System.out.println("Valor não encontrado na árvore.");
        }
        System.out.println();

            BinaryTree tree = new BinaryTree();

            // Inserir valores na árvore
            tree.insert(50);
            tree.insert(30);
            tree.insert(70);
            tree.insert(20);
            tree.insert(40);
            tree.insert(60);
            tree.insert(80);
            tree.insert(10);
            tree.insert(25);
            tree.insert(35);
            tree.insert(45);
            tree.insert(55);
            tree.insert(65);
            tree.insert(75);
            tree.insert(85);

            System.out.println("Árvore antes da remoção:");
            tree.printTreeStructure(tree.root, "");
            System.out.println();


            int valueToDelete1 = 25;
            tree.delete(valueToDelete1);

            System.out.println("Árvore após a remoção do valor " + valueToDelete1 + ":");
            tree.printTreeStructure(tree.root, "");
            System.out.println();
            System.out.println();


            int valueToDelete2 = 80;
            tree.delete(valueToDelete2);

            System.out.println("Árvore após a remoção do valor " + valueToDelete2 + ":");
            tree.printTreeStructure(tree.root, "");
            System.out.println();
            System.out.println();


            int valueToDelete3 = 20;
            tree.delete(valueToDelete3);

            System.out.println("Árvore após a remoção do valor " + valueToDelete3 + ":");
            tree.printTreeStructure(tree.root, "");
            System.out.println();
            System.out.println();

            int valueToDelete4 = 30;
            tree.delete(valueToDelete4);

            System.out.println("Árvore após a remoção do valor " + valueToDelete4 + ":");
            tree.printTreeStructure(tree.root, "");
            System.out.println();
            System.out.println();

            int valueToDelete5 = 70;
            tree.delete(valueToDelete5);

            System.out.println("Árvore após a remoção do valor " + valueToDelete5 + ":");
            tree.printTreeStructure(tree.root, "");
            System.out.println();
            System.out.println();
        }



    }*/
