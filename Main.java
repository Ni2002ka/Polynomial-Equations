import java.util.ArrayList;

import equations.Equation;
import equations.EquationHandler;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> coe1=new ArrayList<>(0);
		coe1.add(-4);
		coe1.add(1);
		coe1.add(-3);
		coe1.add(2);
		Equation e1=new Equation(4, coe1);
		ArrayList<Integer> coe2=new ArrayList<>(0);
		coe2.add(2);
		coe2.add(-7);
		coe2.add(4);
		Equation e2=new Equation(3, coe2);
		
		EquationHandler lol=new EquationHandler(e1, e2);
		Equation result=lol.multiply();
		
		for (Integer i: result.getCoefficients()) {
			System.out.println(i);
		}
	}

}
