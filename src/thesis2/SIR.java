package thesis2;

import java.util.ArrayList;



public class SIR {
	City[] city = new City[47];

	public  void calc(int init, int nm, double b, double g, double h, double t) {
		double p; //感染確率
		Virus v = new Virus(b,g);
		Functions f = new Functions(v);

		int[] c0 = {1};
		city[0] = new City("北海道",5383579,c0);

		int[] c1 = {0,2,4};
		city[1] = new City("青森",1308649,c1);

		int[] c2 = {1,3,4};
		city[2] = new City("岩手",1279814,c2);

		int[] c3 = {2,4,5,6};
		city[3] = new City("宮城",2334215,c3);

		int[] c4 = {1,2,3,5};
		city[4] = new City("秋田",1022839,c4);

		int[] c5 = {3,4,6,14};
		city[5] = new City("山形",1122957,c5);

	 	int[] c6 = {3,5,7,8,9,14};
	 	city[6] = new City("福島",1913606,c6);

		int[] c7 = {6,8,10,11};
		city[7] = new City("茨城",2917857,c7);

		int[] c8 = {6,7,9,10};
		city[8] = new City("栃木",1974671,c8);

		int[] c9 = {6,8,10,14,19};
		city[9] = new City("群馬",1973476,c9);

		int[] c10 = {7,8,9,11,12,18,19};
		city[10] = new City("埼玉",7261271,c10);

		int[] c11 = {7,10,12,13};
		city[11] = new City("千葉",6224027,c11);

		int[] c12 = {10,11,13,18};
		city[12] = new City("東京",13513734,c12);

	 	int[] c13 = {11,12,18,21};
	 	city[13] = new City("神奈川",9127323,c13);

		int[] c14 = {5,6,9,15,19};
		city[14] = new City("新潟",2305098,c14);

		int[] c15 = {14,16,19,20};
		city[15] = new City("富山",1066883,c15);

		int[] c16 = {15,17,20};
		city[16] = new City("石川",1154343,c16);

		int[] c17 = {16,20,24,25};
		city[17] = new City("福井",787099,c17);

		int[] c18 = {10,12,13,19,21};
		city[18] = new City("山梨",835165,c18);

		int[] c19 = {9,10,14,15,18,20,21,22};
		city[19] = new City("長野",2099759,c19);

		int[] c20 = {15,16,17,19,22,23,24};
		city[20] = new City("岐阜",2032533,c20);

	 	int[] c21 = {13,18,19,22};
	 	city[21] = new City("静岡",3701181,c21);

		int[] c22 = {19,20,21,23};
	 	city[22] = new City("愛知",7484094,c22);

	 	int[] c23 = {20,22,24,25,28,29};
	 	city[23] = new City("三重",1815827,c23);

		int[] c24 = {17,20,23,25};
		city[24] = new City("滋賀",1413184,c24);

		int[] c25 = {17,23,24,26,27,28};
		city[25] = new City("京都",2610140,c25);

		int[] c26 = {25,27,28,29};
		city[26] = new City("大阪",8838908,c26);

		int[] c27 = {25,26,29,30,32,35,36};
		city[27] = new City("兵庫",5536989,c27);

		int[] c28 = {23,25,26,29};
		city[28] = new City("奈良",1365008,c28);

		int[] c29 = {23,26,27,28,35};
		city[29] = new City("和歌山",963850,c29);

		int[] c30 = {27,31,32,33};
		city[30] = new City("鳥取",573648,c30);

		int[] c31 = {30,33,34};
		city[31] = new City("島根",694188,c31);

		int[] c32 = {27,30,33,36,37};
		city[32] = new City("岡山",1922181,c32);

		int[] c33 = {30,31,32,34,36,37};
		city[33] = new City("広島",2844963,c33);

		int[] c34 = {31,33,37,39,43};
		city[34] = new City("山口",1405007,c34);

		int[] c35 = {27,29,36,37,38};
		city[35] = new City("徳島",756063,c35);

		int[] c36 = {27,32,33,35,37};
		city[36] = new City("香川",976756,c36);

		int[] c37 = {32,33,34,35,36,38,43};
		city[37] = new City("愛媛",1385840,c37);

		int[] c38 = {35,37};
		city[38] = new City("高知",728461,c38);

		int[] c39 = {34,40,41,42,43};
		city[39] = new City("福岡",5102871,c39);

		int[] c40 = {39,41,42};
		city[40] = new City("佐賀",833245,c40);

		int[] c41 = {39,40,42};
		city[41] = new City("長崎",1377780,c41);

		int[] c42 = {39,40,41,43,44,45};
		city[42] = new City("熊本",1786969,c42);

		int[] c43 = {34,37,39,42,44};
		city[43] = new City("大分",1166729,c43);

		int[] c44 = {43,42,45};
		city[44] = new City("宮崎",1104377,c44);

		int[] c45 = {42,44,46};
		city[45] = new City("鹿児島",1648752,c45);

		int[] c46 = {45};
		city[46] = new City("沖縄",1434138,c46);

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
				}else{
				//飛ばす
				}
			}
		}

		int S,I,R;
		for(int gg = 0; gg < city[nm].ic.size(); gg++){
			S = (int) (city[nm].sc.get(gg) * city[nm].pop);
			I = (int) (city[nm].ic.get(gg) * city[nm].pop);
			R = city[nm].pop - (S + I);
			System.out.println(city[nm].name + "|" + S +"|" + I +"|" + R);
		}
	}
}

