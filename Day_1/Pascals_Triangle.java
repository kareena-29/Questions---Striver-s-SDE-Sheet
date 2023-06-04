package Day_1;


import java.util.*;
public class Pascals_Triangle {
    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> al = new ArrayList<>();
        ArrayList<Long> row, pre = null;

        for (int i = 0; i < n; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add((long) 1);
                } else {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = row;
            al.add(row);
        }
        return al;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Long>> temp = printPascal(6);

        for(int i=0; i<temp.size(); i++){
            for (int j = 0; j < temp.get(i).size(); j++) {
                System.out.print(temp.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}