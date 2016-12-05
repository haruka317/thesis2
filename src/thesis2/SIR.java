package thesis2;

import java.util.ArrayList;



public class SIR {
	City[] city;

	public SIR(City[] city){
		this.city = city;
	}

	public  void calc(int init, int nm, double b, double g, double h, double t) {
		double p; //感染確率
		Virus v = new Virus(b,g);
		Functions f = new Functions(v);
		ArrayList<Integer> x = new ArrayList<Integer>();
		int count = 0;

		city[init].processing = true;
		city[init].i += v.i;
		city[init].s -= v.i;

		System.out.println("-------計算開始------");
		for(double k = 0; k < t; k += h){
			for(City c: city){
				c.sc.add(c.s);
				c.ic.add(c.i );
				c.rc.add(c.r);
				if(c.processing){
					//processing = true の都市のみ計算
					c.s = c.s + (h/6)*(c.k1[0] + 2*c.k2[0] + 2*c.k3[0] + c.k4[0]);
					c.i = c.i + (h/6)*(c.k1[1] + 2*c.k2[1] + 2*c.k3[1] + c.k4[1]);
					c.r = Math.max(0,1 - ( c.s + c.i ));
					c.S = (int) (c.s * c.pop);
					c.I = (int) (c.i * c.pop * h);
					c.R = c.pop - (c.S + c.I);

					c.k1[0] = f.dS(c.s,c.i,c.r,t);
					c.k1[1] = f.dI(c.s,c.i,c.r,t);
					c.k1[2] = f.dR(c.s,c.i,c.r,t);

					c.k2[0] = f.dS(c.s+(h/2)*c.k1[0],
										c.i+(h/2)*c.k1[0],
										c.r+(h/2)*c.k1[0],
										t+(h/2));
					c.k2[1] = f.dI(c.s+(h/2)*c.k1[1],
										c.i+(h/2)*c.k1[1],
										c.r+(h/2)*c.k1[1],
										t+(h/2));
					c.k2[2] = f.dR(c.s+(h/2)*c.k1[2],
										c.i+(h/2)*c.k1[2],
										c.r+(h/2)*c.k1[2],
										t+(h/2));

					c.k3[0] = f.dS(c.s+(h/2)*c.k2[0],
										c.i+(h/2)*c.k2[0],
										c.r+(h/2)*c.k2[0],
										t+(h/2));
					c.k3[1] = f.dI(c.s+(h/2)*c.k2[1],
										c.i+(h/2)*c.k2[1],
										c.r+(h/2)*c.k2[1],
										t+(h/2));
					c.k3[2] = f.dR(c.s+(h/2)*c.k2[2],
										c.i+(h/2)*c.k2[2],
										c.r+(h/2)*c.k2[2],
										t+(h/2));

					c.k4[0] = f.dS(c.s+(h/2)*c.k3[0],
										c.i+(h/2)*c.k3[0],
										c.r+(h/2)*c.k3[0],
										t+(h/2));
					c.k4[1] = f.dI(c.s+(h/2)*c.k3[1],
										c.i+(h/2)*c.k3[1],
										c.r+(h/2)*c.k3[1],
										t+(h/2));
					c.k4[2] = f.dR(c.s+(h/2)*c.k3[2],
										c.i+(h/2)*c.k3[2],
										c.r+(h/2)*c.k3[2],
										t+(h/2));

					x.add(count);
					count++;

					for(int j = 0; j < c.nc.length; j++){
						p = Math.random();
						if( p < c.mR[j]){
							if(!city[c.nc[j]].processing){
								city[c.nc[j]].processing = true;
								city[c.nc[j]].i += c.i * 0.01;
								city[c.nc[j]].s -= c.i * 0.01;
							}
						}
					}
				}
			}
		}

		int S,I,R;
		for(int gg = 0; gg < city[nm].ic.size(); gg++){
			S = (int) (city[nm].sc.get(gg) * city[nm].pop);
			I = (int) (city[nm].ic.get(gg) * city[nm].pop);
			R = city[nm].pop - (S + I);
			System.out.println(city[nm].name + "|" + S +"|" + I +"|" + R + "|" + gg);
		}
	}
	public void clear(City[] city){
		for(City c: city){
			c.ic.clear();
		}
	}
}

