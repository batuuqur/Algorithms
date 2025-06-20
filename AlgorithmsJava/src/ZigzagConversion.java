public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows)
            return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int curRow = 0;
        boolean goingDown = false;
        System.out.println(s.toCharArray());
        for (char c : s.toCharArray()) {
            rows[curRow].append(c);
            System.out.println(s.toCharArray());

            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }

            curRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion converter = new ZigzagConversion();

        String input = "PAYPALISHIRING";
        int numRows = 3;
        String output = converter.convert(input, numRows);
        System.out.println("Output for numRows = 3: " + output); // PAHNAPLSIIGYIR

        numRows = 4;
        output = converter.convert(input, numRows);
        System.out.println("Output for numRows = 4: " + output); // PINALSIGYAHRPI

        input = "A";
        numRows = 1;
        output = converter.convert(input, numRows);
        System.out.println("Output for numRows = 1: " + output); // A
    }
}

/*

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        int len = s.length();
        char[][] grid = new char[numRows][len]; // Make it big with len, for worst case scenario
        for (char[] row : grid)
            java.util.Arrays.fill(row, '\0'); // put /0 for each row fill them

        int row = 0, col = 0;
        int i = 0;

        while (i < len) {
            // ↓ Down we go
            for (row = 0; row < numRows && i < len; row++) {
                grid[row][col] = s.charAt(i++);
            }

            // ↗️ Upward cross
            for (row = numRows - 2; row > 0 && i < len; row--) {
                col++;
                grid[row][col] = s.charAt(i++);
            }
            col++; // Start a new column
        }

        // Add all rows together get the result.
        StringBuilder result = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < len; c++) {
                if (grid[r][c] != '\0') {
                    result.append(grid[r][c]);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversionGrid zcg = new ZigzagConversionGrid();
        System.out.println(zcg.convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
    }
}

 */
