package Numbers;

public class ComplexNum {

	private final double realPart;
	private final double imgPart;
	private final double norm;
	private final double arg;
	
	public ComplexNum(double realPart,double imgPart) {
//		if (Math.abs(realPart)<0.000001)
//			realPart=0;
//		if (Math.abs(imgPart)<0.000001)
//			imgPart=0;
		this.realPart=realPart;
		this.imgPart=imgPart;
		this.norm=Math.sqrt(Math.pow(realPart, 2)+Math.pow(imgPart, 2));
		if (realPart==0) {
			if (imgPart>0)
				this.arg=Math.PI/2.0;
			else
				this.arg=-Math.PI/2.0;
		}
		else if (realPart<0)
			this.arg=Math.PI+Math.atan(imgPart/realPart);
		else
			this.arg=Math.atan(imgPart/realPart);
	}
	
	public double getReal() {return realPart;}
	public double getImg() {return imgPart;}
	public double getNorm() {return norm;}
	public double getArg() {return arg;}
	
	public ComplexNum add (ComplexNum c) {
		return (new ComplexNum(realPart+c.getReal(), imgPart+c.getImg()));
	}
	
	public ComplexNum multiply (ComplexNum c) {
		double newNorm=this.norm*c.getNorm();
		double newArg=this.arg+c.getArg();
		
		return (new ComplexNum(newNorm*Math.cos(newArg), newNorm*Math.sin(newArg)));
	}
	
	public ComplexNum multiplyBy(int x) {return(new ComplexNum(this.realPart*x, this.imgPart*x));}
	
	public ComplexNum pow (int i) {
		if (i==0)
			return (new ComplexNum(1, 0));
		
		ComplexNum result=this;
		for (int j=1;j<i;j++)
			result=multiply(result);
		
		return result;
	}
	
	public ComplexNum sqrt() {
		double newNorm=Math.sqrt(norm);
		double newArg=this.arg/2.0;
		return (new ComplexNum(newNorm*Math.cos(newArg), newNorm*Math.sin(newArg)));
	}
	
	public ComplexNum divideBy (ComplexNum c) {
		double newNorm=this.norm/c.getNorm();
		double newArg=this.arg-c.getArg();
		
		return (new ComplexNum(newNorm*Math.cos(newArg), newNorm*Math.sin(newArg)));
	}

	public ComplexNum divideBy(double x) {return(new ComplexNum(this.realPart/x, this.imgPart/x));}
}
