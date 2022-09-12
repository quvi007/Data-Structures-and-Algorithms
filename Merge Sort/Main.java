import java.util.ArrayList;
import java.util.Scanner;

abstract class MergeSort {
    private static <T extends Comparable<T>> void merge(ArrayList<T> a, int lx, int rx, int ly, int ry) {
        int n = rx - lx + 1, m = ry - ly + 1, i = 0, j = 0, k = 0;
        ArrayList<T> b = new ArrayList<>(n + m);
        while (k < (n + m)) {
            if (j == m || i < n && a.get(lx + i).compareTo(a.get(ly + j)) < 0)
                b.add(a.get(lx + i++));
            else b.add(a.get(ly + j++));
            k++;
        }
        for (k = 0; k < n + m; ++k)
            a.set(lx + k, b.get(k));
    }
    public static <T extends Comparable<T>> void mergeSort(ArrayList<T> a) {
        mergeSort(a, 0, a.size() - 1);
    }   

    public static <T extends Comparable<T>> void mergeSort(ArrayList<T> a, int l, int r) {
        if (l == r) return;
        int mid = (l + r) >> 1;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, mid + 1, r);
    }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        ArrayList<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; ++i)
            a.add(scanner.nextInt());
        MergeSort.mergeSort(a);
        for (int i = 0; i < n; ++i)
            System.out.print(a.get(i) + Character.toString(" \n".charAt((i == n - 1) ? 1 : 0)));

        n = scanner.nextInt();
        ArrayList<String> b = new ArrayList<>(n);
        for (int i = 0; i < n; ++i)
            b.add(scanner.next());
        MergeSort.mergeSort(b);
        for (int i = 0; i < n; ++i)
            System.out.print(b.get(i) + Character.toString(" \n".charAt((i == n - 1) ? 1 : 0)));
    }
}