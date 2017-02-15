package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 2. ArrayList를 상속받아서 로또번호 6개를 중복 없이 올림차순으로 정렬!
 *
 */
public class Lotto extends ArrayList<Integer> {

	public Lotto() {
		// TODO Auto-generated constructor stub
		this.makeRandom();

	}

	public void makeRandom() {
		while (this.size() != 6) {
			this.addLotto((int) (Math.random() * 43) + 1);
		}
	}

	public void addLotto(Integer num) {
		if (!super.contains(num)) {// 만약 값을 포함 하고 있지 않으면
			super.add(num);
		}
	}

	public void print() {
		for (Integer i : this) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public void ascendingSort() {
		Collections.sort(this);
		Collections.sort(this,Collections.reverseOrder());
		
	}

}
