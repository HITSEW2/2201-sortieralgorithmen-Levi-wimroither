import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] freunde = {"levi", "felix", "linus", "fin", "david"};
        String[] tmp = {"z", "a", "c", "abc"};

        bubbleSort(tmp);
        System.out.println("Bubble sorted: " + Arrays.toString(tmp));

        selectionSort(freunde);
        System.out.println("Selection sorted: " + Arrays.toString(freunde));


        int index = binarySearch(tmp, "c");
        System.out.println("Found 'c' at index: " + index);
    }

    static void bubbleSort(String[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    String temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    static void selectionSort(String[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            String temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }

    static int binarySearch(String[] sortedList, String target) {
        int left = 0;
        int right = sortedList.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int result = sortedList[middle].compareTo(target);

            if (result == 0) {
                return middle;
            } else if (result < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1; // not found
    }
}
