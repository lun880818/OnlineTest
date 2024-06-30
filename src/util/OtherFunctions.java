package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import dao.table.impl.TestDaoImpl;
import model.table.Test;

public class OtherFunctions {

	public static void main(String[] args) {
		//test RandomSelect
//		ArrayList<Integer> al =new OtherFunctions().RandomSelect(0, 4, 1);
//		for(int a:al) {
//			System.out.println(a);
//		}
		
		//test setTestNumber
		System.out.println(new OtherFunctions().setTestNumber());

	}
	
	public ArrayList<Integer> RandomSelect(int start, int end, int select) {
		Random r = new Random();
		Set<Integer> uniqueNumbers = new HashSet<>();
		
		while(uniqueNumbers.size()<select) {
			int j = r.nextInt((end-start+1)+start);
			uniqueNumbers.add(j);
		}
		
		ArrayList<Integer> Numbers = new ArrayList<Integer>();
		for(int a : uniqueNumbers) {
			Numbers.add(a);
		}
				
		return Numbers;
	}
	
	
	public String setTestNumber() {
		/*流水號*/
		Test sq =null;
		Integer count=0;
		String testNo;
		do{
			count++;
			String no = String.format("%04d", count);
			testNo = "T"+ no;
			sq = new TestDaoImpl().selectByTestNo(testNo);
		}while(sq!=null);
		return testNo;
	}
	

}
