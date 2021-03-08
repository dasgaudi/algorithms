package sortsearch;

class MergeSortArray {
    void sort(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return;
        }
         
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }
        sort(l);
        sort(r);
        // length of each sub arrays
        merge(arr, l, r);
    }


    void merge(int[] arr, int[] l, int[] r) {

        int i = 0, j = 0, k = 0;
        while (i < l.length && j < r.length) {
            if (l[i] < r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }

        while (i < l.length) arr[k++] = l[i++];
        while (j < r.length) arr[k++] = r[j++];
    }
}
