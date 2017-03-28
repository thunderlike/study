package com.stephen.study.test;

public class BinSearch {
	public static int[] data =new int[]{1,3,8,14,32,44,78,81,99,105,301};
	public static int search(int key, int[] data){
		int i=0;
		int j=data.length-1;
		int position = (i+j)/2;
		while(i<=j){
			if(key==data[position]){
				return position;
			}else if(key<data[position]){
				j = position-1;
			}else if(key>data[position]){
				i = position+1;
			}
			position = (i+j)/2;
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(BinSearch.search(9, BinSearch.data));
	}
}
