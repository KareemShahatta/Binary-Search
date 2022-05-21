public class Main
{
    public static void main(String[] args)
    {
        Main main = new Main();
        main.testArray();
        main.testArrayList();
    }


    void testArray()
    {
        System.out.println("\nWelcome to the Binary Search Test ( SimpleArray ):\n");
        BinarySearchArray bsArr = new BinarySearchArray();
        bsArr.initializeArray();
        bsArr.sort();
        bsArr.printElements();
        bsArr.testBinarySearchArray(bsArr);
    }

    void testArrayList()
    {
        System.out.println("\nWelcome to the Binary Search Test ( ArrayList ):\n");
        BinarySearchArrayList bsArrList = new BinarySearchArrayList();
        bsArrList.initializeArray();
        bsArrList.sort();
        bsArrList.printElements();
        bsArrList.testBinarySearchArray(bsArrList);
    }
}
