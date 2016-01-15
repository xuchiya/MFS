package com.xuchiya.version1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class getAllFS {
	// 得到测试用例集合的所有子故障模式
	public Set<List<Integer>> getAllFailureSchemas(Set<List<Integer>> mSet) {
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		Iterator<List<Integer>> itSet = mSet.iterator();
		while (itSet.hasNext()) {
			getFS per_FailureSchemas = new getFS();
			per_FailureSchemas.getFailureSchemas(itSet.next(), 0);
			result.addAll(per_FailureSchemas.FailSchema);
		}
		return result;
	}

	// 从故障模式中 约减父故障模式
	public Set<List<Integer>> reduceParent(Set<List<Integer>> parent) {
		getFS testFStemp = new getFS();
		Iterator<List<Integer>> itparent1 = parent.iterator();
		Set<List<Integer>> tempParent = new HashSet<List<Integer>>();
		Iterator<List<Integer>> itparent2;
		// for (; it1.hasNext(); it2.hasNext())
		// {
		// it2 = parent.iterator();
		// List<Integer> temp1 = it1.next();
		// continue;
		//
		// List<Integer> temp2 = (List)it2.next();
		// if ((temp1 != temp2) &&
		// (testFStemp.IsSubSchema(temp1, temp2))) {
		// temp111.add(temp2);
		// }
		// }
//这边需要优化一下
		while (itparent1.hasNext()) {
			itparent2 = parent.iterator();
			List<Integer> temp1 = itparent1.next();
			while (itparent2.hasNext()) {
				List<Integer> temp2 = itparent2.next();
				if (temp1 != temp2 ) {
					if(testFStemp.IsSubSchema(temp1, temp2)==true)
					tempParent.add(temp2);
				}

			}

		}

		parent.removeAll(tempParent);
		return parent;
	}

//	public static void main(String[] args) {
//		getAllFS test = new getAllFS();
//		getFS tttt = new getFS();
//		Set<List<Integer>> sample = new HashSet<List<Integer>>();
//		List<Integer> a1 = Arrays.asList(-1, -1, -1, 1, 600, 2, -1, 499, 500, 1, -1, 1);
//		sample.add(a1);
//		List<Integer> a2 = Arrays.asList(-1, -1, 1, -1, 600, -1, 0, 740, 400, 0, 2, 0);
//		sample.add(a2);
//		List<Integer> a3 = Arrays.asList(-1, -1, 1, -1, 600, -1, 0, 740, 400, 0, 2, 1);
//		sample.add(a3);
//		List<Integer> a4 = Arrays.asList(-1, -1, 1, -1, 600, -1, 0, 740, 400, 0, 2, -1);
//		sample.add(a4);
//		List<Integer> a5 = Arrays.asList(-1, 1, 1, -1, 600, 2, -1, -1, 640, -1, -1, 1);
//		sample.add(a5);
//		List<Integer> a6 = Arrays.asList(601, -1, -1, -1, -1, 2, -1, 740, 740, 2, 2, 1);
//		sample.add(a6);
//		List<Integer> a7 = Arrays.asList(601, -1, -1, -1, -1, 2, -1, 740, 740, 2, 2, -1);
//		sample.add(a7);
//		List<Integer> a8 = Arrays.asList(-1, 1, 1, -1, 600, 2, -1, -1, 640, -1,
//				-1, -1);
//		sample.add(a8);
//		List<Integer> a9 = Arrays.asList(-1, 1, 1, -1, 600, 2, -1, -1, 640, -1,
//				-1, 0);
//		sample.add(a9);
//		List<Integer> a10 = Arrays.asList(601, 1, 0, -1, 600, -1, -1, 840, 500,
//				2, 2, 1);
//		sample.add(a10);
//		List<Integer> a11 = Arrays.asList(601, -1, 0, -1, -1, 2, -1, 399, 400,
//				2, -1, -1);
//		sample.add(a11);
//		List<Integer> a12 = Arrays.asList(601, 1, 0, -1, 600, -1, -1, 840, 500,
//				2, 2, 0);
//		sample.add(a12);
//		List<Integer> a13 = Arrays.asList(-1, 1, -1, -1, -1, -1, -1, 400, 400,
//				-1, 2, 1);
//		sample.add(a13);
//		List<Integer> a14 = Arrays.asList(601, -1, 0, -1, 600, -1, 2, 739, -1,
//				2, -1, 1);
//		sample.add(a14);
//		List<Integer> a15 = Arrays.asList(601, -1, 0, -1, 600, -1, 2, 739, -1,
//				2, -1, 0);
//		sample.add(a15);
//		List<Integer> a16 = Arrays.asList(601, 1, 0, -1, 600, -1, -1, 840, 500,
//				2, 2, -1);
//		sample.add(a16);
//		List<Integer> a17 = Arrays.asList(601, -1, 0, -1, -1, 2, -1, 399, 400,
//				2, -1, 1);
//		sample.add(a17);
//		List<Integer> a18 = Arrays.asList(-1, 1, -1, -1, -1, -1, -1, 400, 400,
//				-1, 2, -1);
//		sample.add(a18);
//		List<Integer> a19 = Arrays.asList(601, -1, 0, -1, 600, -1, 2, 739, -1,
//				2, -1, -1);
//		sample.add(a19);
//		List<Integer> a20 = Arrays.asList(-1, -1, -1, 1, 600, 2, -1, 499, 500,
//				1, -1, -1);
//		sample.add(a20);
//
//		System.out.println(tttt.IsSubSchema(a7, a6));
//
//		Set<List<Integer>> son = test.reduceParent(sample);
//		System.out.println(son.size());
//	}
}
