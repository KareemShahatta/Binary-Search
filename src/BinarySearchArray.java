import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BinarySearchArray implements BinarySearch
{
    int[] array;

    @Override
    public int binarySearch(int value)
    {
        return Arrays.binarySearch(array , value);
    }

    @Override
    public void add(int value)
    {
        int index = binarySearch(0);
        if(index > -1)
        {
            array[index] = value;
            sort();
            printElements();
        }
        else
        {
            System.out.println("no space available");
        }
    }

    @Override
    public void remove(int index) {
        array[index] = 0;
        sort();
        printElements();
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == value)
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public void printElements() {
        for (int number : array)
        {
            System.out.print(number + " ");
        }

        System.out.println();
    }

    @Override
    public void initializeArray() {
        array = new int[10];
        for(int i = 0 ; i < 10 ; i++)
        {
            array[i] = ((int) (Math.random() *100));
        }
    }

    @Override
    public void sort()
    {
        Arrays.sort(array);
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
