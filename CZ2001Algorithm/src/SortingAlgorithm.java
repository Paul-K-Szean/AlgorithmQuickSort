import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class SortingAlgorithm {
	static int[] array = null;
	static ArrayList<Long> startTimeArray = null;
	static ArrayList<Long> endTimeArray = null;
	static ArrayList<Long> resultArray = null;
	static ArrayList<Integer> resultCompareArray = null;
	static long result = 0;
	// number of samples to test
	static int comparison = 0;
	static int sampleNumber = 1;
	static int dataMultiplier = 10;
	static int[] dataSize = { (2 * dataMultiplier), (4 * dataMultiplier), (6 * dataMultiplier), (8 * dataMultiplier),
			(10 * dataMultiplier) };

	static BufferedWriter writer = null;

	public static void main(String args[]) {

		startTimeArray = new ArrayList<>();
		endTimeArray = new ArrayList<>();
		resultArray = new ArrayList<>();
		resultCompareArray = new ArrayList<>();
		dataSetAscending();
		startTimeArray = new ArrayList<>();
		endTimeArray = new ArrayList<>();
		resultArray = new ArrayList<>();
		resultCompareArray = new ArrayList<>();
		dataSetDescending();
	}

	public static int[] getRandomIntArray(int size) {
		int[] randomInteger = new int[size];
		for (int i = 0; i < size; i++) {
			randomInteger[i] = new Random().nextInt(size * 2) + 1;
		}
		return randomInteger;
	}

	public static String formatNumberWithComma(double numbers) {
		return NumberFormat.getNumberInstance(Locale.US).format(numbers);
	}

	public static void dataSetAscending() {

		try {
			// create a temporary file
			String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			File logFile = new File(timeLog + "-Ascending.txt");
			writer = new BufferedWriter(new FileWriter(logFile));

			// test algorithm ascending mode
			System.out.println("Started quick sort in ascending mode");
			writer.write("Started quick sort in ascending mode");
			for (int index = 0; index < dataSize.length; index++) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "Data Size: " + dataSize[index]
						+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				writer.newLine();
				writer.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "Data Size: " + dataSize[index]
						+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				for (int sampleCount = 1; sampleCount <= sampleNumber; sampleCount++) {
					dataSizeAscending(dataSize[index], sampleCount);
				}
				System.out.println();
				System.out.println();
			}

			// The full file path
			System.out.println(logFile.getCanonicalPath());
			writer.newLine();
			writer.write(logFile.getCanonicalPath());
			// print result
			printResult("ascending mode");

			System.out.println("Ended quick sort in ascending mode");
			writer.newLine();
			writer.write("Ended quick sort in ascending mode");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} catch (Exception e) {
			}
		}

	}

	public static void dataSetDescending() {

		try {
			// create a temporary file
			String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			File logFile = new File(timeLog + "-Descending.txt");
			writer = new BufferedWriter(new FileWriter(logFile));

			// test algorithm ascending mode
			System.out.println("Started quick sort in descending mode");
			writer.write("Started quick sort in ascending mode");
			for (int index = 0; index < dataSize.length; index++) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "Data Size: " + dataSize[index]
						+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				writer.newLine();
				writer.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "Data Size: " + dataSize[index]
						+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				for (int sampleCount = 1; sampleCount <= sampleNumber; sampleCount++) {
					dataSizeDescending(dataSize[index], sampleCount);
				}
				System.out.println();
				System.out.println();
			}

			// The full file path
			System.out.println(logFile.getCanonicalPath());
			writer.newLine();
			writer.write(logFile.getCanonicalPath());
			// print result
			printResult("descending mode");

			System.out.println("Ended quick sort in descending mode");
			writer.newLine();
			writer.write("Ended quick sort in descending mode");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} catch (Exception e) {
			}
		}

	}

	public static void dataSizeAscending(int size, int sampleCount) {
		try {

			long startedTime, endedTime, timeDff;
			System.out.println("Unsorted Array");
			writer.newLine();
			writer.write("Unsorted Array");
			writer.newLine();
			array = getRandomIntArray(size);
			// array = new int[] { 5, 4, 9, 8, 10, 4 };
			printArray(array);

			comparison = 1;
			startTimeArray.add(startedTime = System.nanoTime());
			quickSortAscending(0, array.length - 1);
			endTimeArray.add(endedTime = System.nanoTime());

			timeDff = (endedTime - startedTime);
			resultArray.add(timeDff);
			resultCompareArray.add(comparison);
			System.out.println("Sorted Array");
			writer.newLine();
			writer.write("Sorted Array");
			writer.newLine();
			printArray(array);

			System.out.println("***************************************************************************");
			writer.newLine();
			writer.write("***************************************************************************");
			System.out.println("Sample No \t Start Time \t End Time \t\t Result,Comparison");
			writer.newLine();
			writer.write("Sample No \t Start Time \t End Time \t\t Result,Comparison");
			System.out.println("***************************************************************************");
			writer.newLine();
			writer.write("***************************************************************************");
			System.out.println(
					sampleCount + "\t\t" + startedTime + "\t " + endedTime + "\t" + timeDff + "," + comparison);
			writer.newLine();
			writer.write(sampleCount + "\t\t" + startedTime + "\t " + endedTime + "\t" + timeDff + "," + comparison);
			System.out.println("---------------------------------------------------------------------------");
			writer.newLine();
			writer.write("---------------------------------------------------------------------------");

		} catch (Exception ex) {
		}

	}

	public static void dataSizeDescending(int size, int sampleCount) {
		try {

			long startedTime, endedTime, timeDff;
			System.out.println("Unsorted Array");
			writer.newLine();
			writer.write("Unsorted Array");
			writer.newLine();
			array = getRandomIntArray(size);
			// array = new int[] { 6, 3, 10, 9, 4, 11 };
			printArray(array);

			comparison = 1;
			startTimeArray.add(startedTime = System.nanoTime());
			quickSortDescending(0, array.length - 1);
			endTimeArray.add(endedTime = System.nanoTime());

			timeDff = (endedTime - startedTime);
			resultArray.add(timeDff);
			resultCompareArray.add(comparison);
			System.out.println("Sorted Array");
			writer.newLine();
			writer.write("Sorted Array");
			writer.newLine();
			printArray(array);

			System.out.println("***************************************************************************");
			writer.newLine();
			writer.write("***************************************************************************");
			System.out.println("Sample No \t Start Time \t End Time \t\t Result,Comparison");
			writer.newLine();
			writer.write("Sample No \t Start Time \t End Time \t\t Result,Comparison");
			System.out.println("***************************************************************************");
			writer.newLine();
			writer.write("***************************************************************************");
			System.out.println(
					sampleCount + "\t\t" + startedTime + "\t " + endedTime + "\t" + timeDff + "," + comparison);
			writer.newLine();
			writer.write(sampleCount + "\t\t" + startedTime + "\t " + endedTime + "\t" + timeDff + "," + comparison);
			System.out.println("---------------------------------------------------------------------------");
			writer.newLine();
			writer.write("---------------------------------------------------------------------------");

		} catch (Exception ex) {
		}

	}

	public static void quickSortAscending(int low, int high) {
		int pivot;
		if (low >= high)
			return;
		else {
			pivot = partitionAscending(low, high);
			quickSortAscending(low, pivot - 1);
			quickSortAscending(pivot + 1, high);
		}
	}

	public static int partitionAscending(int low, int high) {
		int i, last_small, pivot;
		int mid = (low + high) / 2;
		swap(low, mid);
		pivot = array[low];
		last_small = low;

		for (i = low + 1; i <= high; i++) {
			if (array[i] < pivot) {
				comparison++;
				swap(++last_small, i);
			}
		}
		comparison++;
		swap(low, last_small);
		return last_small;

	}

	public static void quickSortDescending(int low, int high) {
		int pivot;
		if (low >= high)
			return;
		else {
			pivot = partitionDescending(low, high);
			quickSortDescending(low, pivot - 1);
			quickSortDescending(pivot + 1, high);
		}
	}

	public static int partitionDescending(int low, int high) {
		int i, last_small, pivot;
		int mid = (low + high) / 2;
		swap(low, mid);
		pivot = array[low];
		last_small = low;

		for (i = low + 1; i <= high; i++) {
			if (array[i] > pivot) {
				comparison++;
				swap(++last_small, i);
			}
		}
		comparison++;
		swap(low, last_small);
		return last_small;

	}

	public static void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

	}

	// printing
	public static void printArray(int[] array) {
		try {
			int index = 1;
			for (int number : array) {
				System.out.print(number + "\t");
				writer.write(number + "\t");
				if (index % 10 == 0) {
					System.out.println();
					writer.newLine();
				}

				index++;
			}
			System.out.println();
		} catch (Exception ex) {
		}

	}

	// printing
	public static void printResult(String orderMode) {

		long sum = 0;
		ArrayList<Long> sumResultArray = new ArrayList<>();
		ArrayList<Long> compareResultArray = new ArrayList<>();

		try {

			System.out.println("Results for quick sort in " + orderMode);
			writer.newLine();
			writer.write("Results for quick sort in " + orderMode);

			// sum up the time for each data size
			for (int index = 1; index <= resultArray.size(); index++) {
				sum += resultArray.get(index - 1);
				if (index % sampleNumber == 0) {
					sumResultArray.add(sum);
					sum = 0;
				}
			}

			// sum up the result of comparison
			for (int index = 1; index <= resultCompareArray.size(); index++) {
				sum += resultCompareArray.get(index - 1);
				if (index % sampleNumber == 0) {
					compareResultArray.add(sum);
					sum = 0;
				}
			}

			// print and write result
			System.out.println("***************************************************************************");
			System.out.println("Sample Size:\t" + sampleNumber);
			System.out.println("Data Size: \t " + dataSize[0] + "\t" + dataSize[1] + "\t" + dataSize[2] + "\t"
					+ dataSize[3] + "\t" + dataSize[4]);
			System.out.print("Avg Time(ns):");
			writer.newLine();
			writer.write("***************************************************************************");
			writer.newLine();
			writer.write("Sample Size:\t" + sampleNumber);
			writer.newLine();
			writer.write("Data Size: \t " + dataSize[0] + "\t" + dataSize[1] + "\t" + dataSize[2] + "\t" + dataSize[3]
					+ "\t" + dataSize[4]);
			writer.newLine();
			writer.write("Avg Time(ns):");

			for (long time : sumResultArray) {
				System.out.print("\t" + time / sampleNumber);
				writer.write("\t" + time / sampleNumber);
			}
			System.out.println();
			writer.newLine();
			writer.write("Avg Comparison:");
			System.out.print("Avg Comparison:");
			for (long compare : compareResultArray) {
				System.out.print("\t" + compare / sampleNumber);
				writer.write("\t" + compare / sampleNumber);
			}
			System.out.println();
			System.out.println("***************************************************************************");
			writer.newLine();
			writer.write("***************************************************************************");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
