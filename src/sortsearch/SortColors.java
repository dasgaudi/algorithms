package sortsearch;

class SortColors {

    void sortColors(int[] arr) {
        // 2 passes
        int red=0, white=0, blue=0; 
        for (int i=0; i < arr.length; i++) {
            if (arr[i] == 0) red ++;
            else if (arr[i] == 1) white++;
            else blue++;
        }

        int i=0; 

        while (red > 0) { arr[i++] = 0; red--;}
        while (white > 0) { arr[i++] = 1; white--; }
        while (blue > 0) { arr[i++] = 2; blue--; }
    }

    public static void main(String[] args) {
        SortColors ob = new SortColors();
        int[] arr = new int[] { 0, 2, 1, 2, 1};
        ob.sortColors(arr);

        for (int i=0; i < arr.length; i++) System.out.print(arr[i] + ", ");
    }
}
