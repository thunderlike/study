package com.stephen.study.test;

public class MergeSort {
	
	public static int[] data = new int[]{36,20,17,13,28,14,23,15};
	
	public static int[] mergeSort(int[] a, int b[]){
		int[] c = new int[a.length+b.length];
		int i=0,j=0,k=0;
		while(i<a.length && j<b.length){
			if(a[i]<b[j]){
				c[k++] = a[i++];
			}else{
				c[k++] = b[j++];
			}
		}
		for(;i<a.length;i++){
			c[k++] = a[i++];
		}
		for(;j<b.length;j++){
			c[k++] = a[j++];
		}
		return c;
	}
	
	public static int[] dealData(int[] data,int low,int high){
		if(high-low>0){
			int middle = (high+low)/2;
			int[] a = dealData(data, low, middle);
			int[] b = dealData(data, middle+1, high);
			return mergeSort(a, b);
		}else{
			return new int[]{data[low]};
		}
	}
	
	public static void printAll(int[] data) {
		for (int e : data) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		printAll(data);
		int[] rs = MergeSort.dealData(data, 0, data.length-1);
		printAll(rs);
	}
}
