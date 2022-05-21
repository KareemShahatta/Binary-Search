import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BinarySearchArrayList implements BinarySearch
{

    ArrayList<Integer> arrayList= new ArrayList<>();

    @Override
    public int binarySearch(int value)
    {
        return Collections.binarySearch(arrayList , value);
    }

    @Override
    public void add(int value) {
        arrayList.add(value);
        sort();
        printElements();
    }

    @Override
    public void remove(int value) {
        arrayList.remove(value);
        sort();
        printElements();
    }

    @Override
    public boolean contains(int value)
    {
        return arrayList.contains(value);
    }

    @Override
    public void printElements() {
        for (int number : arrayList)
        {
            System.out.print(number + " ");
        }

        System.out.println();
    }

    @Override
    public void initializeArray() {
        for(int i = 0 ; i < 10 ; i++)
        {
            arrayList.add((int) (Math.random() *100));
        }
    }

    @Override
    public void sort()
    {
        Collections.sort(arrayList);
    }

    public void testBinarySearchArray(BinarySearch searchObject) {
        Scanner scanner = new Scanner(System.in);
        int value = 0;

        try {
            System.out.print("Enter an integer to search (or -1 to quit): ");
            String ss = scanner.nextLine();
            if (ss.equals("-1"))
                return;
            value = Integer.parseInt(ss);
            do {
                int index;
                if ((index = searchObject.binarySearch(value)) >= 0) {
                    System.out.println("Value " + value + " found." + " Do you want to remove it? y/n? ");
                    String answer = scanner.nextLine();
                    if (answer.equals("y")) {
                        searchObject.remove(index);
                    }
                } else {
                    System.out.println("Value " + value + " not found." + " Do you want to add it? y/n? ");
                    String answer = scanner.nextLine();
                    if (answer.equals("y"))
                        searchObject.add(value);
                }
                System.out.print("Enter an integer to search (or -1 to quit): ");
                ss = scanner.nextLine();
                value = Integer.parseInt(ss);
            }
            while (value != -1);
            System.out.println("Goodbye...");
        } catch (NoSuchElementException e) {
            System.out.println("Goodbye..");
        }
    }
}
