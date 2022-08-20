package com.youtube.geekific;

@SuppressWarnings("unchecked")
public record MergeSort<T extends Comparable<T>>(T[] arr) {

    public void sort() {
        mergesort(0, arr.length - 1);
    }

    private void mergesort(int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        mergesort(low, middle);
        mergesort(middle + 1, high);
        merge(low, middle, high);
    }

    void merge(int low, int middle, int high) {

        T[] leftArray = (T[]) new Comparable[middle - low + 1];
        T[] rightArray = (T[]) new Comparable[high - middle];

        System.arraycopy(arr, low, leftArray, 0, leftArray.length);
        System.arraycopy(arr, middle + 1, rightArray, 0, rightArray.length);

        int leftSubArrCounter = 0;
        int rightSubArrCounter = 0;
        int arrCounter = low;
        while (leftSubArrCounter < leftArray.length && rightSubArrCounter < rightArray.length) {
            arr[arrCounter++] = leftArray[leftSubArrCounter].compareTo(rightArray[rightSubArrCounter]) <= 0
                    ? leftArray[leftSubArrCounter++]
                    : rightArray[rightSubArrCounter++];
        }

        while (leftSubArrCounter < leftArray.length) {
            arr[arrCounter++] = leftArray[leftSubArrCounter++];
        }

        while (rightSubArrCounter < rightArray.length) {
            arr[arrCounter++] = rightArray[rightSubArrCounter++];
        }

    }

}
