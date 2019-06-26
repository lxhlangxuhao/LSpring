package arithmetic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 10:13 2019/6/26
 */
public class TwoListMinus {

	public static void main(String[] args) {

		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		list1.add(1);list1.add(2);list1.add(3);list1.add(4);list1.add(8);
		list2.add(1);list2.add(2);list2.add(5);
		list2.add(null);list2.add(null);list2.add(null);


		HashSet minus = minus(list2, list1);
	}


	private static HashSet minus(ArrayList<Integer> list1, ArrayList<Integer> list2) {

		list1.addAll(list2);
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < list1.size(); i++) {
			if (!hashSet.add(list1.get(i))) {
				hashSet.remove(list1.get(i));
			}
		}
		return hashSet;
	}





}
