package thesis2;

public class Virus {
	String name;	//ウイルス名
	double b;		//感染率
	double g;		//除外率
	double i; 		//初期感染者数
	static int count;

	public Virus(){
		this.name = "インフル";
		this.b = 0.45;
		this.g = 1/3.5;
		this.i = 0.001;
		count ++;
	}

	public Virus(double a, double b, double c){
		this.name = "インフル";
		this.b = a;
		this.g = b;
		this.i = c;
		count ++;
	}

	public Virus(double a, double b){
		this.b = a;
		this.g = b;
		this.i = 0.001;
		count ++;
	}
}


