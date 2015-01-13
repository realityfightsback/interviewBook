package chap1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class MatrixUtils {
/**
 * Just accept matrix as matrix[y][x]. It makes life so much easier when reading them in. And visualizing
 * @param args
 */
	public static void main(String[] args) {

		int[][] s = new int[5][5];

		s[0] = new int[] { 1, 1, 1, 2, 3 };
		s[1] = new int[] { 1, 0, 1, 0, 3 };
		s[2] = new int[] { 1, 1, 1, 2, 3 };
		s[3] = new int[] { 1, 1, 1, 2, 3 };
		s[4] = new int[] { 1, 1, 1, 2, 3 };
		printOutMatrix(s);

		s = zeroOutRowsAndColumnsWithZeroes(s);

		printOutMatrix(s);

	}

	/**
	 * Read in a file that has a matrix present in standard format (rows and
	 * columns). Space delimited. Expects all rows are the same length, all
	 * columns are the same too. Rows does not have to equal column length
	 * 
	 * @param string
	 * @return
	 * @throws IOException
	 */
	private static int[][] readInMatrix(String string) throws IOException {
		List<String> lines = FileUtils.readLines(new File(string));

		Integer numOfRows = lines.size();

		int[][] result = new int[lines.size()][];

		int rowIndex = 0; // Y
		for (String line : lines) {
			String[] rowValues = line.split(" ");
			int[] column = new int[rowValues.length];
			int colIndex = 0; // X
			for (String rowVal : rowValues) {
				column[colIndex++] = Integer.parseInt(rowVal);
			}
			result[rowIndex++] = column;
		}

		return null;
	}

	private static void printOutMatrix(int[][] s) {

		for (int m = 0; m < s.length; m++) {
			for (int n = 0; n < s.length; n++) {

				System.out.print(s[m][n] + " ");
			}
			System.out.print("\n");

		}

	}

	public static int[][] zeroOutRowsAndColumnsWithZeroes(int[][] matrix) {
		// Assuming that the 2nd dimension of the array is consistent (meaning
		// on column isn't 5 deep, the other 3, 3, w/e, all the same). Not
		// checking.
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[0][0];
		}

		int[] zeroFilledRow = new int[matrix[0].length];

		HashSet<Integer> columnIndices = new HashSet<Integer>();

		// Check each row, going column by column
		for (int m = 0; m < matrix.length; m++) {
			boolean zeroFoundInRow = false;
			for (int n = 0; n < matrix[0].length; n++) {
				if (matrix[m][n] == 0) {
					// Record any column indices that had a zero
					zeroFoundInRow = true;
					columnIndices.add(n);
				}

			}

			// If we find a zero in the row, zero out the whole
			if (zeroFoundInRow) {
				matrix[m] = zeroFilledRow;
			}
		}

		ArrayList<Integer> l = new ArrayList<Integer>();
		l.addAll(columnIndices);

		for (int i = 0; i < matrix.length; i++) {
			for (Integer integer : l) {
				matrix[i][integer] = 0;
			}
		}

		return matrix;
	}

}
