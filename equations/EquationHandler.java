package equations;

import java.util.ArrayList;

import Numbers.ComplexNum;

public class EquationHandler {
	private final Equation eq1;
	private final Equation eq2;
	
	public EquationHandler(Equation eq1,Equation eq2) {
		this.eq1=eq1;
		this.eq2=eq2;
	}
	
	private ComplexNum FFT(int j, ComplexNum c, int n) {
//		System.out.print(n);
//		System.out.print(" ");
//		System.out.print(j);
//		System.out.print(" ");
		c=c.sqrt();
//		System.out.println(c.getReal());
		if (n==1) {
			ComplexNum P_positive=eq1.getValueAtPoint(c).multiply(eq2.getValueAtPoint(c));
//			System.out.print(P_positive.getReal());
//			System.out.print(", ");
//			System.out.print(P_positive.getImg());
//			System.out.println("i");
			ComplexNum P_negative=eq1.getValueAtPoint(c.multiplyBy(-1)).multiply(eq2.getValueAtPoint(c.multiplyBy(-1)));
//			System.out.print(P_negative.getReal());
//			System.out.print(", ");
//			System.out.print(P_negative.getImg());
//			System.out.println("i");
			if (j==0) 
				return (P_positive.add(P_negative).divideBy(2.0));
			else
				return (P_positive.add(P_negative.multiplyBy(-1))).divideBy(c.multiplyBy(2));	
		}
		
		if (j/n==0)
			return ((FFT(j%n,c,n/2).add(FFT(j%n,c.multiplyBy(-1),n/2))).divideBy(2.0));
		
		return ((FFT(j%n,c,n/2).add(FFT(j%n,c.multiplyBy(-1),n/2).multiplyBy(-1))).divideBy(c.multiplyBy(2)));
	}
	
	public Equation multiply() {
		int resultDim=eq1.getDimensions()+eq2.getDimensions()-1;
		//closest n to result's dimension
		int n=(int) Math.ceil(Math.log(resultDim)/Math.log(2));
		n=(int)Math.pow(2, n-1);
		Equation result=new Equation(resultDim, new ArrayList<Integer>(0));
		
		for (int i=0;i<resultDim;i++) {
			int newCoefficient=(int)Math.round(FFT(i, new ComplexNum(1, 0), n).getReal()) ;
//			System.out.print("new Stuff: ");
//			System.out.println(newCoefficient);
			result.setNewCoefficient(newCoefficient);
		}
		
		return result;
	}
}
