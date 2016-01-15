package com.xuchiya.version1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class computeFS {
	public static void main(String[] args) throws IOException {
//		for (int number = 12; number <= 12; number++) {
//			System.out.println(number + "started");
			getAllFS tt = new getAllFS();
			getFS ee = new getFS();
			computeFS qqq = new computeFS();
//			Set<List<Integer>> rsCorrect = qqq.getSet("diffcorrectcase"
//					+ number);
			Set<List<Integer>> rsCorrect = qqq.getSet("correctCase");
			Set<List<Integer>> rsFail = qqq.getSet("faultCase");

			Set<List<Integer>> parent = new HashSet<List<Integer>>();

			Iterator<List<Integer>> it = rsCorrect.iterator();
			parent = tt.getAllFailureSchemas(rsFail);
			while (it.hasNext()) {
				Set<List<Integer>> result = new HashSet<List<Integer>>();
				result.add(it.next());
				parent = ee.ExtractFailureSchemas(parent, result);
			}
//			FileWriter writer = new FileWriter("E://shecdule//schedule1//outputs//correctAndFault//son4");
//			FileWriter writer2 = new FileWriter("E://shecdule//schedule1//outputs//correctAndFault//parent4");
			FileWriter writer = new FileWriter("D:\\cygwin\\home\\BinaryTest\\son");
			FileWriter writer2 = new FileWriter("D:\\cygwin\\home\\BinaryTest\\parent");
			
			
			
			BufferedWriter bw = new BufferedWriter(writer);
			BufferedWriter bw2 = new BufferedWriter(writer2);
			bw2.write("parent:");
			bw2.write("\n");
			Iterator<List<Integer>> parentop = parent.iterator();
			while (parentop.hasNext()) {
				bw2.write((parentop.next()).toString());
				bw2.write("\n");
			}
			bw2.close();
			writer2.close();

			Set<List<Integer>> son = tt.reduceParent(parent);
			Iterator<List<Integer>> op = son.iterator();
			bw.write("son:");
			bw.write("\n");
			while (op.hasNext()) {
				bw.write((op.next()).toString());
				bw.write("\n");
			}
			bw.close();
			writer.close();
//			System.out.println(number + "completed");
//		}
		
//		getAllFS tt = new getAllFS();
//		getFS ee = new getFS();
//		Set<List<Integer>> fail = new HashSet<List<Integer>>();
//		fail.add(Arrays.asList(0,0,1));
//		fail.add(Arrays.asList(0,1,0));
//		fail.add(Arrays.asList(0,1,1));
//		fail.add(Arrays.asList(1,0,1));
//		fail.add(Arrays.asList(1,1,0));
//		fail.add(Arrays.asList(1,1,1));
//		Set<List<Integer>> correct = new HashSet<List<Integer>>();
//		correct.add(Arrays.asList(0,0,0));
//		correct.add(Arrays.asList(1,0,0));
//		Set<List<Integer>> parent;
//		parent = ee.ExtractFailureSchemas(tt.getAllFailureSchemas(fail), tt.getAllFailureSchemas(correct));
//		System.out.println(parent);
//		System.out.println("\n");
//		System.out.println("-------");
//		System.out.println(tt.reduceParent(parent));
		
	}

	public Set<List<Integer>> getSet(String path) throws IOException {
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		String pathroot = "D:\\cygwin\\home\\BinaryTest\\";
		String filepath = pathroot + path;
		FileReader reader = new FileReader(filepath);
		BufferedReader bufreader = new BufferedReader(reader);
		String str = null;
		while ((str = bufreader.readLine()) != null) {
			List<Integer> temp = new ArrayList<Integer>();
			String[] s = str.split(" ");
			for (String perStr : s) {
				temp.add(Integer.parseInt(perStr));
			}
			result.add(temp);
		}
		bufreader.close();
		return result;
	}
}
