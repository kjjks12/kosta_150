package test.exam;

public class MainApp {

	public static void main(String[] args) {
		// Tv 2대 , Audio 2대 저장하고 그 정보를 출력한다.
		ElecFunction elec[] = new ElecFunction[5];

		elec[0] = new Tv("A01", 500000, 12);
		elec[1] = new Tv("A02", 2500, 20);
		elec[2] = new Tv("A03", 3000, 30);

		elec[3] = new Audio("A04", 8500, 200);
		elec[4] = new Audio("A05", 700, 100);

		for (ElecFunction e : elec) {
			 e.start();
			//System.out.println(e);
		}

	}
}

/*
A01제품 TV를 12을 본다
A02제품 TV를 20을 본다
A03제품 TV를 30을 본다
A04의 Audio를 200으로 듣는다.
A05의 Audio를 100으로 듣는다.
*/