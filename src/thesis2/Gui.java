package thesis2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Gui extends JFrame{
	//ウィンドウ本体
	JButton btn1;

	JPanel p1;
	JPanel p2;

	JComboBox combo1;
	JComboBox combo2;

	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;

	JTextField text1;
	JTextField text2;
	JTextField text3;
	JTextField text4;

	int init;
	int nm;
	double b;
	double g;
	double h;
	double t;
	Virus v;

	public Gui(){
		SIR sir = new SIR();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1700, 1200);

		this.btn1 = new JButton("開始");
		BevelBorder border1 = new BevelBorder(BevelBorder.RAISED);
		BevelBorder border2 = new BevelBorder(BevelBorder.LOWERED);

	    this.p1 = new JPanel();	//Map描画用パネル
	    p1.setBackground(Color.WHITE);
	    p1.setBounds(0, 0, 1100, 800);
	    p1.setBorder(border1);

	    this.p2 = new JPanel();	//パラメータ設定用パネル
	    p2.setBackground(Color.GRAY);
	    p2.setBounds(1400, 0, 300, 1200);
	    p2.setBorder(border2);

	    String[] city = {"北海道","青森県","岩手県","宮城県","秋田県","山形県",
	    		"福島県","茨城県","栃木県","群馬県","埼玉","千葉","東京","神奈川",
	    		"新潟県","富山県","石川県","福井県","山梨県","長野県","岐阜県",
	    		"静岡県","愛知県","三重県","滋賀県","京都府","大阪府","兵庫県",
	    		"奈良県","和歌山県","鳥取県","島根県","岡山県","広島県","山口県",
	    		"徳島県","香川県","愛媛県","高知県","福岡県","佐賀県","長崎県",
	    		"熊本県","大分県","宮崎県","鹿児島県","沖縄県" };

	    this.combo1 = new JComboBox(city);
	    combo1.setBounds(1300, 150, 200, 50);

	    this.combo2 = new JComboBox(city);
	    combo2.setBounds(1300, 300, 200, 50);

	    this.label1 = new JLabel("感染率=");
	    label1.setBounds(170, 880, 200, 50);

	    this.text1 = new JTextField("0.45");
	    text1.setBounds(230, 880, 200, 50);

	    this.label2 = new JLabel("回復率=");
	    label2.setBounds(170, 1030, 200, 50);

	    this.text2 = new JTextField("0.29");
	    text2.setBounds(230, 1030, 200, 50);

	    this.label3 = new JLabel("刻み幅=");
	    label3.setBounds(620, 1030, 200, 50);

	    this.text3 = new JTextField("1.0");
	    text3.setBounds(680, 1030, 200, 50);

	    this.label4 = new JLabel("観察日数=");
	    label4.setBounds(620, 880, 200, 50);

	    this.text4 = new JTextField("200.0");
	    text4.setBounds(680, 880, 200, 50);


	    ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
	    JFreeChart chart =
		  	      ChartFactory.createLineChart("感染者割合の推移",
                          "経過日数",
                          "割合",
                          createData(),
                          PlotOrientation.VERTICAL,
                          true,
                          false,
                          false);

		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.ORANGE);

		ChartPanel cpanel = new ChartPanel(chart);
		//cpanel.setBounds(100, 100, 1000, 1000);
		p1.add(cpanel,BorderLayout.CENTER);

	    Virus v = new Virus();

		add(btn1);
		btn1.setBounds(1200,1000,400,75);
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int init = combo1.getSelectedIndex();
				int nm = combo2.getSelectedIndex();
				String str1 = text1.getText();
			    Double b = Double.parseDouble(str1);
				String str2 = text2.getText();
			    Double g = Double.parseDouble(str2);
				String str3 = text3.getText();
			    Double h = Double.parseDouble(str3);
				String str4 = text4.getText();
			    Double t = Double.parseDouble(str4);
				sir.calc(init, nm, b, g, h, t);
			}
		});

	    Container contentPane = getContentPane();
	    contentPane.add(label1);
	    contentPane.add(text1);
	    contentPane.add(label2);
	    contentPane.add(text2);
	    contentPane.add(label3);
	    contentPane.add(text3);
	    contentPane.add(label4);
	    contentPane.add(text4);
	    contentPane.add(btn1);
	    contentPane.add(combo1);
	    contentPane.add(combo2);
	    contentPane.add(p1);
	    contentPane.add(p2);
	}
 /*
	  private DefaultCategoryDataset createData(){
		    DefaultCategoryDataset data = new DefaultCategoryDataset();
		    String[] series = {"米国", "中国", "インド"};
		    String[] category = {"2005年", "2006年", "2007年"};

		    data.addValue(300, series[0], category[0]);
		    data.addValue(500, series[0], category[1]);
		    data.addValue(400, series[0], category[2]);
		    data.addValue(200, series[1], category[0]);
		    data.addValue(600, series[1], category[1]);
		    data.addValue(200, series[1], category[2]);
		    data.addValue(100, series[2], category[0]);
		    data.addValue(150, series[2], category[1]);
		    data.addValue(700, series[2], category[2]);

		    return data;


		  String str;
		  DefaultCategoryDataset data = new DefaultCategoryDataset();
		  String[] series = {"北海道","青森県","岩手県","宮城県","秋田県","山形県",
	    		"福島県","茨城県","栃木県","群馬県","埼玉","千葉","東京","神奈川",
	    		"新潟県","富山県","石川県","福井県","山梨県","長野県","岐阜県",
	    		"静岡県","愛知県","三重県","滋賀県","京都府","大阪府","兵庫県",
	    		"奈良県","和歌山県","鳥取県","島根県","岡山県","広島県","山口県",
	    		"徳島県","香川県","愛媛県","高知県","福岡県","佐賀県","長崎県",
	    		"熊本県","大分県","宮崎県","鹿児島県","沖縄県" };

		  for(int i = 0; i < c.ic.size() ; i++){
			  str = String.valueOf(i*h);
			  data.addValue(c.ic.get(i), series[c.id], str);

		  return data;
	  }
		  }*/

	  private DefaultCategoryDataset createData(){
		    DefaultCategoryDataset data = new DefaultCategoryDataset();
		    String[] series = {"米国", "中国", "インド"};
		    String[] category = {"2005年", "2006年", "2007年"};

		    data.addValue(300, series[0], category[0]);
		    data.addValue(500, series[0], category[1]);
		    data.addValue(400, series[0], category[2]);
		    data.addValue(200, series[1], category[0]);
		    data.addValue(600, series[1], category[1]);
		    data.addValue(200, series[1], category[2]);
		    data.addValue(100, series[2], category[0]);
		    data.addValue(150, series[2], category[1]);
		    data.addValue(700, series[2], category[2]);
		    return data;
		 }
}
