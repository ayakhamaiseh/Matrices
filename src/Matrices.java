import java.util.ArrayList;
import java.util.Scanner;

public class Matrices {

    Scanner sc = new Scanner(System.in);
    int row1, row2, column1, column2;
    int rows, columns;


    public void multiplication() {
        while (true) {
            System.out.print("Enter # of rows for 1st array: ");
            row1 = sc.nextInt();
            System.out.print("Enter # of columns for 1st array: ");
            column1 = sc.nextInt();
            System.out.print("Enter # of rows for 2nd array: ");
            row2 = sc.nextInt();
            System.out.print("Enter # of columns for 2nd array: ");
            column2 = sc.nextInt();

            if (row1 == column2 || column1 == row2) {
                break;
            } else {
                System.out.println("Arrays dimensions mismatch. Please re-enter the dimensions.");
            }
        }

        int[][] array1 = new int[row1][column1];
        int[][] array2 = new int[row2][column2];
        int[][] mul = new int[row1][column2];

        System.out.println("Enter contents of 1st array");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                System.out.print("Array1 [" + i + "][" + j + "]: ");
                array1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter contents of 2nd array");
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < column2; j++) {
                System.out.print("Array2 [" + i + "][" + j + "]: ");
                array2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column2; j++) {
                for (int k = 0; k < column1; k++) {
                    mul[i][j] += array1[i][k] * array2[k][j];
                }
            }
        }
        System.out.println("The product of both arrays is:");
        for (int[] row : mul) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        sc.close();


    }

    public void sum() {
        while (true) {
            System.out.print("Enter # of rows for 1st array: ");
            row1 = sc.nextInt();
            System.out.print("Enter # of columns for 1st array: ");
            column1 = sc.nextInt();
            System.out.print("Enter # of rows for 2nd array: ");
            row2 = sc.nextInt();
            System.out.print("Enter # of columns for 2nd array: ");
            column2 = sc.nextInt();

            if (row1 == row2 && column1 == column2) {
                break;
            } else {
                System.out.println("Arrays dimensions mismatch. Please re-enter the dimensions.");
            }
        }

        int[][] array1 = new int[row1][column1];
        int[][] array2 = new int[row2][column2];
        int[][] sum = new int[row2][column2];

        System.out.println("Enter contents of 1st array");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                System.out.print("Array1 [" + i + "][" + j + "]: ");
                array1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter contents of 2nd array");
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < column2; j++) {
                System.out.print("Array2 [" + i + "][" + j + "]: ");
                array2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                sum[i][j] = array1[i][j] + array2[i][j];
            }
        }

        System.out.println("The Summation of both arrays is:");
        for (int[] row : sum) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        sc.close();

    }

    public void scalar() {
        System.out.print("Enter # of rows for 1st array: ");
        row1 = sc.nextInt();
        System.out.print("Enter # of columns for 1st array: ");
        column1 = sc.nextInt();


        int[][] array1 = new int[row1][column1];
        int[][] mul = new int[row1][column1];
        int number;
        System.out.println("Enter the number you want to multiply the array with:");
        number = sc.nextInt();
        System.out.println("Enter contents of the array array");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                System.out.print("Array1 [" + i + "][" + j + "]: ");
                array1[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                mul[i][j] = array1[i][j] * number;
            }
        }

        System.out.println("The product arrays is:");
        for (int[] row : mul) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        sc.close();

    }

    public void submatrix() {
        System.out.print("Enter # of rows for the array: ");
        rows = sc.nextInt();
        System.out.print("Enter # of columns for the array: ");
        columns = sc.nextInt();

        int[][] array1 = new int[rows][columns];
        System.out.println("Enter contents of the array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Array1 [" + i + "][" + j + "]: ");
                array1[i][j] = sc.nextInt();
            }
        }
        System.out.println("The matrix you created is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array1[i][j] + " ");
            }
            System.out.println();

        }

        System.out.print("Enter # of rows for the subarray: ");
        int subRows = sc.nextInt();
        System.out.print("Enter # of columns for the subarray: ");
        int subColumns = sc.nextInt();

        if (subRows > rows || subColumns > columns) {
            System.out.println("Submatrix dimensions must be smaller than original matrix dimensions.");
            return;
        }

        int RowsDiff = rows - subRows;
        int ColumnsDiff = columns - subColumns;

        ArrayList<Integer> skipColumn = new ArrayList<>(); // those are the column and row indices to remove from the original array
        ArrayList<Integer> skipRow = new ArrayList<>();
        if (ColumnsDiff != 0) {
            while (ColumnsDiff > 0) {  // this is to keep asking the user to specify which column(s) to remove
                System.out.print("Enter the column number to remove (0-based index): ");
                int columnToRemove = sc.nextInt();
                skipColumn.add(columnToRemove);
                ColumnsDiff--;
            }
        }
        if (RowsDiff != 0) {
            while (RowsDiff > 0) {
                System.out.print("Enter the row number to remove (0-based index): ");
                int rowToRemove = sc.nextInt();
                skipRow.add(rowToRemove);
                RowsDiff--;
            }
        }

        int[][] subarray = new int[subRows][subColumns];

        int subRow = 0;
        for (int i = 0; i < rows; i++) {
            if (skipRow.contains(i)) continue;
            int subCol = 0;
            for (int j = 0; j < columns; j++) {
                if (skipColumn.contains(j)) continue;
                subarray[subRow][subCol] = array1[i][j];
                subCol++;
            }
            subRow++;
        }
        System.out.println("The resulting submatrix is:");
        for (int i = 0; i < subRows; i++) {
            for (int j = 0; j < subColumns; j++) {
                System.out.print(subarray[i][j] + " ");
            }
            System.out.println();

        }
        sc.close();


    }

    public void transpose() {
        System.out.print("Enter # of rows for the array: ");
        row1 = sc.nextInt();
        System.out.print("Enter # of columns for the array: ");
        column1 = sc.nextInt();


        int[][] array1 = new int[row1][column1];
        int[][] transpose = new int[column1][row1];

        System.out.println("Enter contents of the array");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                System.out.print("Array1 [" + i + "][" + j + "]: ");
                array1[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                transpose[j][i] = array1[i][j];
            }
        }

        System.out.println("The transpose of the array is");
        for (int[] row : transpose) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        sc.close();

    }


    public void squareOp() {
        while (true) {
            System.out.print("Enter # of rows for the array: ");
            rows = sc.nextInt();
            System.out.print("Enter # of columns for the array: ");
            columns = sc.nextInt();
            if (rows != columns) {
                System.out.println("The array is not square");
            } else break;
        }
        int[][] array1 = new int[rows][columns];
        System.out.println("Enter contents of the array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Array1 [" + i + "][" + j + "]: ");
                array1[i][j] = sc.nextInt();
            }
        }
        int[][] array2 = new int[rows][columns];
        System.out.println("What operation do you want to make: 0:Diagonal , 1:Lower , 2:Upper");
        int operation = sc.nextInt();
        switch (operation) {
            case 0:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (i == j) {
                            array1[i][j] = 0;
                        }
                        array2[i][j] = array1[i][j];
                    }
                }
                System.out.println("The diagonal arrays is:");
                for (int[] row : array2) {
                    for (int element : row) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                }

            case 1:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (i > j) {
                            array1[i][j] = 0;
                        }
                        array2[i][j] = array1[i][j];
                    }
                }

                System.out.println("The lower tri arrays is:");
                for (int[] row : array2) {
                    for (int element : row) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                }
            case 2:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (i < j) {
                            array1[i][j] = 0;
                        }
                        array2[i][j] = array1[i][j];
                    }
                }

                System.out.println("The upper tri arrays is:");
                for (int[] row : array2) {
                    for (int element : row) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                }
                sc.close();

        }

    }

    // this determinant only works for 2 by 2 array
    public void determinant() {
        while (true) {
            System.out.print("Enter # of rows for the array: ");
            rows = sc.nextInt();
            System.out.print("Enter # of columns for the array: ");
            columns = sc.nextInt();
            if(rows!=columns){
                System.out.println("The array is not 2by2, try again!");
            }
            else break;
            }
            int[][] array1 = new int[rows][columns];
            System.out.println("Enter contents of the array");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print("Array1 [" + i + "][" + j + "]: ");
                    array1[i][j] = sc.nextInt();
                }
            }
            int det = array1[0][0] * array1[1][1] - array1[0][1] * array1[1][0];
            System.out.println("The determinant of the 2by2 Array is: " + det);
            sc.close();
    }


}

