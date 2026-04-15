package java_collection;

import java.util.Arrays;

interface Filter<T> {
    T apply(T object);
}

class SquareFilter implements Filter<Integer> {

    @Override
    public Integer apply(Integer object) {
        return (object) * object;
    }
}

class DoubleFilter implements Filter<Integer> {

    @Override
    public Integer apply(Integer object) {
        return 2 * object;
    }
}

public class FilterMethodPractice<T> {

    public static <T> T[] filter(T arr[], Filter<T> fitler) {
        T[] cArr = arr.clone();

        for (int i = 0; i < arr.length; i++) {
            // arr[i] = fitler.apply(arr[i]); // not recommeded to change instead creat copy
            cArr[i] = fitler.apply(arr[i]);
        }
        return cArr;
    }

    public static void main(String[] args) {
        Integer arr[] = { 1, 2, 3, 3 };
        SquareFilter filter = new SquareFilter();
        DoubleFilter doubleFilter = new DoubleFilter();

        Integer squareArray[] = filter(arr, filter);

        Integer doubleArray[] = filter(arr, doubleFilter);

        // using the lambda expression
        Integer cutSalaryArray[] = filter(arr, x -> x - 1);

        Arrays.stream(squareArray).forEach(x -> {
            System.out.print(x + " ");
        });

        System.out.println();

        Arrays.stream(doubleArray).forEach(x -> {
            System.out.print(x + " ");
        });

        System.out.println();

        Arrays.stream(cutSalaryArray).forEach(System.out::println);
    }
}