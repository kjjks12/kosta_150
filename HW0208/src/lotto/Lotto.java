package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 2. ArrayList�� ��ӹ޾Ƽ� �ζǹ�ȣ 6���� �ߺ� ���� �ø��������� ����!
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
		if (!super.contains(num)) {// ���� ���� ���� �ϰ� ���� ������
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
