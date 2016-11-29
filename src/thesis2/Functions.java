package thesis2;


public class Functions {
	Virus v;

	public Functions(Virus v){
		this.v = v;
	}

	public double dS(double s,double i,double r,double t){
		return -v.b*s*i;
	}

	public double dI(double s,double i,double r,double t){
		return v.b*s*i - v.g*i;
	}

	public double dR(double s,double i,double r,double t){
		return v.g*i;
	}
}
