package com.stephen.study.test;

public class NLogNSort {

	public static int data[] = new int[] { 72, 6, 57, 88, 60, 42, 83, 73, 48, 85 };

	public static void printAll(int[] data) {
		for (int e : data) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

	public static void quickSort(int low, int high, int[] data) {
		int temp = 0;
		int i = low, j = high;
		int key = data[i];

		while (true) {
			while (true) {
				if (data[j] < key) {
					temp = data[j];
					data[j] = data[i];
					data[i] = temp;
					break;
				} else if (i >= j) {
					break;
				} else {
					j--;
				}
			}

			while (true) {
				if (data[i] > key) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
					break;
				} else if (i >= j) {
					break;
				} else {
					i++;
				}
			}

			if (i == j) {
				break;
			}
		}
		
		printAll(data);
		if (low < i - 1) {
			quickSort(low, i - 1, data);
		}
		if (i + 1 < high) {
			quickSort(i + 1, high, data);
		}
	}

	public static void main(String[] args) {
		printAll(data);
		NLogNSort.quickSort(0, data.length - 1, data);
	}
}
