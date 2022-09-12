#include <bits/stdc++.h>
using namespace std;

class MergeSort {
private:
    template<class T>
    static void merge(vector<T> &a, int lx, int rx, int ly, int ry) {
        int n = rx - lx + 1, m = ry - ly + 1, i = 0, j = 0, k = 0;
        vector<T> b(n + m);
        while (k < (n + m)) {
            if (j == m || i < n && a[lx + i] < a[ly + j])
                b[k++] = a[lx + i++];
            else b[k++] = a[ly + j++];
        }
        for (k = 0; k < n + m; ++k)
            a[lx + k] = b[k];
    }
public:
    template<class T>
    static void mergeSort(vector<T> &a, int l, int r) {
        if (l == r) return;
        int mid = (l + r) >> 1;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, mid + 1, r);
    }

    template<class T>
    static void mergeSort(vector<T> &a) {
        mergeSort(a, 0, a.size() - 1);
    }
    virtual ~MergeSort() = 0;
};

int main() {
    int n;
    cin >> n;
    vector<int> a(n);
    for (int &x : a) 
        cin >> x;
    MergeSort::mergeSort(a);
    for (int i = 0; i < n; ++i) 
        cout << a[i] << " \n"[i == n - 1];

    cin >> n;
    vector<string> b(n);
    for (string &x : b)
        cin >> x;
    MergeSort::mergeSort(b);
    for (int i = 0; i < n; ++i)
        cout << b[i] << " \n"[i == n - 1];
    return 0;
}