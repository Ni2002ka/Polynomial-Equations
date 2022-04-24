package equations;

import java.util.ArrayList;

import Numbers.ComplexNum;

public class Equation {

	private int dimensions;
	private ArrayList<Integer> coefficients;
	
	public Equation(int dimensions,ArrayList<Integer> coefficients) {
		this.dimensions=dimensions;
		this.coefficients=coefficients;
	}
	
	public int getDimensions() {
		return dimensions;
	}
	
	//add complex numbers
	public ComplexNum getValueAtPoint(ComplexNum x) {
		ComplexNum sum=new ComplexNum(0, 0);
		
		for (int i=0;i<dimensions;i++) {
			sum=sum.add(x.pow(i).multiplyBy(coefficients.get(i)));
		}
		
		return sum;
	}
	
	public void setNewCoefficient(int newCoefficient) {
		coefficients.add(newCoefficient);
	}

	public ArrayList<Integer> getCoefficients(){
		return coefficients;
	}
}
