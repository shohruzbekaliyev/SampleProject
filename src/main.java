public class main {
    public static void main(String[] args) {



            MyLinkedList myList = new MyLinkedList();

            String testData = "2 3 1 2 5 6 7 4 9 8 7 4";
            String[] dataArray =  testData.split(" ");
            for (String data : dataArray) {
                myList.addItem(new Node(data));
            }

            myList.traverse(myList.getRoot());

            myList.removeItem(new Node("7"));
            myList.traverse(myList.getRoot());
            myList.removeItem(new Node("7"));
            myList.traverse(myList.getRoot());
            myList.removeItem(new Node("9"));
            myList.traverse(myList.getRoot());
            myList.removeItem(new Node("5"));
            myList.traverse(myList.getRoot());
            myList.removeItem(myList.getRoot());
            myList.traverse(myList.getRoot());
            myList.removeItem(myList.getRoot());
            myList.traverse(myList.getRoot());
            myList.removeItem(myList.getRoot());
            myList.traverse(myList.getRoot());
            myList.removeItem(myList.getRoot());
            myList.traverse(myList.getRoot());

    }
}
