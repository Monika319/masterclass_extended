package mc;

import hep.aida.IFitResult;
import hep.aida.IFunction;
import jhplot.*;

import org.apache.commons.math3.special.Erf;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Histo extends JFrame implements ActionListener {

    public static void main(String args[]) {
        double wartosc;
        new Histo();
    }
    private Box.Filler filler1;
    private JComboBox jComboBox1;
    private JComboBox jComboBox2;
    private JComboBox jComboBox4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLayeredPane jLayeredPane1;
    private JLayeredPane jLayeredPane2;
    //ivate JLayeredPane jLayeredPane31;
    private JMenu jMenu1 ;
    private JMenu jMenu2;
    private JLayeredPane jLayeredPane3;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JPanel load_histo_panel;
    private JPanel fit_panel;
    private JInternalFrame jInternalFrame1;
  //  private JTabbedPane jTabbedPane1;
    //private JTabbedPane jTabbedPane2;
   // private JTabbedPane jTabbedPane3;
    private JTabbedPane jTabbedPane4;
    private JTabbedPane jTabbedPane5;
    private Container jPanel1;
    private JPanel jPanel2;
    // private JDesktopPane jDesktopPane1;
   // private JTabbedPane jTabbedPane5;
    //private CheckBoxList list;
   // private JCheckBox[] boxes;
    private FileReader fr;
    private String name;
    private double wartosc;
    private static HPlot c1;
    private HFitter polynomialfitter;
    private HFitter functionFitter;
    private F1D fFitGaus;
    private F1D fFitPolynomial;
    private int TotalFit;
    private int signalFit;
    private int BckFit;
    private double[] Pars;
    static H1D h1;
   // private JLayeredPane jLayeredPane1;
    private JTabbedPane jTabbedPane6;
    private CheckBoxList list2;
    private JCheckBox[] boxes2;

    public Histo() {

        initComponents();

        String nazwa = null;
        c1 = new HPlot("Canvas", 600, 400);

        c1.setLegendFont(new Font("Lucida Sans", 1, 18));
        this.c1.getAntiAlias();
        this.c1.setGTitle("Title of the Graph");
        this.c1.setAutoRange();
        this.c1.setNameX("Invariant Mass[GeV]");
        this.c1.setNameY("Counts");
        this.c1.setName("Invariant Mass spectra");
        jLayeredPane3.add(c1.getCanvasPanel());
       // jTabbedPane5.addTab("Invariant Mass", c1.getCanvasPanel());

        read();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
    	jLayeredPane1 = new JLayeredPane();
        jLayeredPane2 = new JLayeredPane();
        load_histo_panel = new JPanel();
        jComboBox1 = new JComboBox();
        jComboBox2 = new JComboBox();
        filler1 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(0, 32767));
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jComboBox4 = new JComboBox();
        fit_panel = new JPanel();
        jLayeredPane3 = new JLayeredPane();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenuItem3 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jMenu2 = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        load_histo_panel.setBorder(BorderFactory.createTitledBorder("V0 histograms"));


        jLabel1.setText("K0");
        jLabel1.setToolTipText("");

        jLabel2.setText("Lambda");
        jLabel3.setText("AntiLambda");


        		jComboBox1.addItem("pp");
      		jComboBox1.addItem("PbPb");
      		jComboBox1.addItem("PbPb-0-10%");
      		jComboBox1.addItem("PbPb-10-20%");
      		jComboBox1.addItem("PbPb-20-30%");
      		jComboBox1.addItem("PbPb-30-40%");
      		jComboBox1.addItem("PbPb-40-50%");
      		jComboBox1.addItem("PbPb-50-60%");
      		jComboBox1.addItem("PbPb-60-70%");
      		jComboBox1.addItem("PbPb-70-80%");
      		jComboBox1.addItem("PbPb-80-90%");
      		jComboBox1.addItem("PbPb-90-100%");
      		jComboBox2.addItem("pp");
      		jComboBox2.addItem("PbPb");
      		jComboBox2.addItem("PbPb-0-10%");
      		jComboBox2.addItem("PbPb-10-20%");
      		jComboBox2.addItem("PbPb-20-30%");
      		jComboBox2.addItem("PbPb-30-40%");
      		jComboBox2.addItem("PbPb-40-50%");
      		jComboBox2.addItem("PbPb-50-60%");
      		jComboBox2.addItem("PbPb-60-70%");
      		jComboBox2.addItem("PbPb-70-80%");
      		jComboBox2.addItem("PbPb-80-90%");
      		jComboBox2.addItem("PbPb-90-100%");
      		jComboBox4.addItem("pp");
      		jComboBox4.addItem("PbPb");
      		jComboBox4.addItem("PbPb-0-10%");
      		jComboBox4.addItem("PbPb-10-20%");
      		jComboBox4.addItem("PbPb-20-30%");
      		jComboBox4.addItem("PbPb-30-40%");
      		jComboBox4.addItem("PbPb-40-50%");
      		jComboBox4.addItem("PbPb-50-60%");
      		jComboBox4.addItem("PbPb-60-70%");
      		jComboBox4.addItem("PbPb-70-80%");
      		jComboBox4.addItem("PbPb-80-90%");
      		jComboBox4.addItem("PbPb-90-100%");
      		
        GroupLayout load_histo_panelLayout = new GroupLayout(load_histo_panel);
        load_histo_panel.setLayout(load_histo_panelLayout);
        load_histo_panelLayout.setHorizontalGroup(
            load_histo_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(load_histo_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(load_histo_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(load_histo_panelLayout.createSequentialGroup()
                        .addGroup(load_histo_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, load_histo_panelLayout.createSequentialGroup()
                        .addGroup(load_histo_panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox4, GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                            .addComponent(jComboBox2, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.LEADING, load_histo_panelLayout.createSequentialGroup()
                                .addComponent(filler1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBox1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        load_histo_panelLayout.setVerticalGroup(
            load_histo_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(load_histo_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(filler1, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fit_panel.setBorder(BorderFactory.createTitledBorder("Fitting panel"));

        GroupLayout fit_panelLayout = new GroupLayout(fit_panel);
        fit_panel.setLayout(fit_panelLayout);
        fit_panelLayout.setHorizontalGroup(
            fit_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fit_panelLayout.setVerticalGroup(
            fit_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jLayeredPane2Layout = new GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(load_histo_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fit_panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addComponent(load_histo_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fit_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jLayeredPane2.setLayer(load_histo_panel, JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(fit_panel, JLayeredPane.DEFAULT_LAYER);

        GroupLayout jLayeredPane3Layout = new GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("jMenuItem3");
        jMenu1.add(jMenuItem3);

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLayeredPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane2)
                    .addComponent(jLayeredPane3))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>

    public void read() {
        int i;
    	jComboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				jComboBox1= (JComboBox)e.getSource();
			     String s = (String)jComboBox1.getSelectedItem();
			     
			   System.out.print(s);
			     
				if (s == "pp"){
					plot_hist(0.0D, 1.0D, "pp-K0.txt", 2600);
				}
				else if (s == "PbPb"){
					  plot_hist(0.0D, 1.0D, "PbPb-K0.txt", 2600);
				}
				else if (s == "PbPb-0-10%"){
					  plot_hist(0.0D, 1.0D, "dataset11.txt", 2600);
				}	
				else if (s == "PbPb-10-20%"){
					  plot_hist(0.0D, 1.0D, "dataset12.txt", 2600);
				}	
				else if (s == "PbPb-20-30%"){
					  plot_hist(0.0D, 1.0D, "dataset13.txt", 2600);
				}	
				else if (s == "PbPb-30-40%"){
					  plot_hist(0.0D, 1.0D, "dataset14.txt", 2600);
				}	
				else if (s == "PbPb-40-50%"){
					  plot_hist(0.0D, 1.0D, "dataset15.txt", 2600);
				}	
				else if (s == "PbPb-50-60%"){
					plot_hist(0.0D, 1.0D, "dataset15.txt", 2600);
				}	
				else if (s == "PbPb-60-70%"){
					plot_hist(0.0D, 1.0D, "dataset15.txt", 2600);
				}	
				else if (s == "PbPb-70-80%"){
					plot_hist(0.0D, 1.0D, "dataset15.txt", 2600);
				}	
				else if (s == "PbPb-80-90%"){
					plot_hist(0.0D, 1.0D, "dataset15.txt", 2600);
				}	
				else if (s == "PbPb-90-100%"){
					plot_hist(0.0D, 1.0D, "dataset15.txt", 2600);
				}	
		}
	});
  
  jComboBox2.addActionListener(new ActionListener() {
	
		
			public void actionPerformed(ActionEvent e){
				jComboBox2= (JComboBox)e.getSource();
			     String s = (String)jComboBox2.getSelectedItem();
			     
			   System.out.print(s);
			     
				if (s == "pp"){
					plot_hist(0.0D, 1.0D, "dataset15.txt", 2600);
				}
				else if (s == "PbPb"){
				//	Histo.this.plot_hist("./PbPb-Lambda.txt", 0.0D, 2.0D);
				}
				else if (s == "PbPb-0-10%"){
				//	Histo.this.plot_hist("dataset21.txt", 0.0D, 2.0D);
				}	
				else if (s == "PbPb-10-20%"){
				//	Histo.this.plot_hist("dataset22.txt", 0.0D, 2.0D);
				}	
				else if (s == "PbPb-20-30%"){
				//	Histo.this.plot_hist("dataset23.txt", 0.0D, 2.0D);
				}	
				else if (s == "PbPb-30-40%"){
					//Histo.this.plot_hist("dataset24.txt", 0.0D, 2.0D);
				}	
				else if (s == "PbPb-40-50%"){
					//Histo.this.plot_hist("dataset25.txt", 0.0D, 2.0D);
				}	
				else if (s == "PbPb-50-60%"){
					//Histo.this.plot_hist("dataset26.txt", 0.0D, 2.0D);
				}	
				else if (s == "PbPb-60-70%"){
					//Histo.this.plot_hist("dataset27.txt", 0.0D, 2.0D);
				}	
				else if (s == "PbPb-70-80%"){
					//Histo.this.plot_hist("dataset28.txt", 0.0D, 2.0D);
				}	
				else if (s == "PbPb-80-90%"){
					//Histo.this.plot_hist("dataset29.txt", 0.0D, 2.0D);
				}	
				else if (s == "PbPb-90-100%"){
					//Histo.this.plot_hist("dataset30.txt", 0.0D, 2.0D);
				}	
		}
	});
		
  jComboBox4.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent e){
			jComboBox4= (JComboBox)e.getSource();
		     String s = (String)jComboBox4.getSelectedItem();
		     
		   System.out.print(s);
		     
			if (s == "pp"){
				//Histo.plot_hist("./pp-AntiLambda.txt", 0.0D, 2.0D);
			}
			else if (s == "PbPb"){
			//	Histo.this.plot_hist("./PbPb-AntiLambda.txt", 0.0D, 2.0D);
			}
			else if (s == "PbPb-0-10%"){
				//Histo.this.plot_hist("dataset31.txt", 0.0D, 2.0D);
			}	
			else if (s == "PbPb-10-20%"){
				//Histo.this.plot_hist("dataset32.txt", 0.0D, 2.0D);
			}	
			else if (s == "PbPb-20-30%"){
				//Histo.this.plot_hist("dataset33.txt", 0.0D, 2.0D);
			}	
			else if (s == "PbPb-30-40%"){
				//Histo.this.plot_hist("dataset34.txt", 0.0D, 2.0D);
			}	
			else if (s == "PbPb-40-50%"){
				//Histo.this.plot_hist("dataset35.txt", 0.0D, 2.0D);
			}	
			else if (s == "PbPb-50-60%"){
				//Histo.this.plot_hist("dataset36.txt", 0.0D, 2.0D);
			}	
			else if (s == "PbPb-60-70%"){
				//Histo.this.plot_hist("dataset37.txt", 0.0D, 2.0D);
			}	
			else if (s == "PbPb-70-80%"){
				//Histo.this.plot_hist("dataset38.txt", 0.0D, 2.0D);
			}	
			else if (s == "PbPb-80-90%"){
				//Histo.this.plot_hist("dataset39.txt", 0.0D, 2.0D);
			}	
			else if (s == "PbPb-90-100%"){
				//Histo.this.plot_hist("dataset40.txt", 0.0D, 2.0D);
			}	
	}
});
    	
 }


   

    public void plot_hist(double xminrange, double xmaxrange, String fileName, double yAxisMax)  {
        name = fileName;


        c1.clearData();
        c1.clearAllLabels();

        c1.setGrid(getY(), true);
        int number = c1.getNumberOfTics(getY());
        //c1.setNumberOfTics(MAXIMIZED_VERT, 5);
        //	c1.setTicLength(getY(), 50D);
        //	c1.setTextRotationLeft(90);
        System.out.println(Integer.toString(number));
        //this.c1.setMarginSizeLeft(0.1);
//		this.c1.setNumberOfTics(1, 100);
//		this.c1.setTicsRotate(getY(), true);
//		c1.setTextPosTopY(0.01);
//		c1.getTextPosLeftY();
//		c1.getCdY();
        //c1.setMarginSizeLeft(0.3);
        //c1.setAttResizableAll(true);

        //	c1.setLegend(false);
        // c1.clearData();
        try {
            fr = new FileReader(name);
        } catch (FileNotFoundException e) {
            System.out.println("BÅ?ÄD PRZY OTWIERANIU PLIKU!");
            System.exit(1);
        }
        StreamTokenizer st = new StreamTokenizer(fr);
        // ODCZYT KOLEJNYCH "TOKENÃW" Z PLIKU:
        try {
            while ((wartosc = st.nextToken()) != StreamTokenizer.TT_EOF) {
                if (wartosc == StreamTokenizer.TT_WORD)
                    System.out.println("Wczytano sÅowo: " + st.sval);
                else if (wartosc == StreamTokenizer.TT_NUMBER)
                    System.out.println("Wczytano liczbÄ: " + st.nval);
                //h1.fill(st.nval);

            }
        } catch (IOException e) {
         System.out.println("BÅ?ÄD ODCZYTU Z PLIKU!");
         System.exit(2);
         }


            P0D list_data = new P0D("Histogram", fileName);
      //  ZAMYKANIE PLIKU:
         try {
         fr.close();
         } catch (IOException e) {
         System.out.println("BÅ?ÄD PRZY ZAMYKANIU PLIKU!");
         System.exit(3);
         }

            h1 = list_data.getH1D(400, xminrange, xmaxrange);
            // H1D h1 = new H1D("Histogram", 100, minx, maxx);

            // Random r = new Random();
            // h1.setFill(true);
            // h1.setFillColor(new Color(r.nextFloat(), r.nextFloat(),
            // r.nextFloat(), 0.5F));
            // h1.setErrX(true);
            // h1.setErrY(true);
            // h1.setPenWidthErr(3);

            // FileReader fr = null;
            // String linia = "";
            // File file = null;

            // h1.setTitle(file.getName());

            // //OTWIERANIE PLIKU:


            // StreamTokenizer st = new StreamTokenizer(fr);
            // ODCZYT KOLEJNYCH "TOKENÃW" Z PLIKU:
            // try {
            // while ((wartosc = st.nextToken()) != StreamTokenizer.TT_EOF) {
            // if (wartosc == StreamTokenizer.TT_WORD)
            // System.out.println("Wczytano sÅowo: " + st.sval);
            // else if (wartosc == StreamTokenizer.TT_NUMBER)
            // System.out.println("Wczytano liczbÄ: " + st.nval);
            // //h1.fill(st.nval);
            //
            // }
//		this.c1.getAntiAlias();
//		this.c1.setAutoRange();
//		this.c1.setNameX("Invariant Mass[GeV]");
//		this.c1.setNameY("Counts");
//		this.c1.setName("Invariant Mass spectra");
            this.c1.setGTitle("Title of the Graph");
            this.c1.setRange(xminrange, xmaxrange, 0, yAxisMax);
            this.c1.setLegendPos(WIDTH, HIDE_ON_CLOSE);
            this.c1.draw(h1);
            this.c1.drawStatBox(h1, 300, 50);
            this.c1.refreshFrame();

	}

	

    void FunctionFitter(double minGaus, double maxGaus, double minPoly,
                        double maxPoly) {
        this.c1.clearLabels();// clearing data from histogram and plotting data from fit
        polynomialfitter = new HFitter();
        functionFitter = new HFitter();

        functionFitter
                .setFunc("fitGaus", 1, "a* exp(-0.5*((x[0]-mean)/s0)*((x[0]-mean)/s0))+p2*x[0]*x[0]+p1*x[0]+p0", "a,mean,s0,p2,p1,p0");
        functionFitter.setPar("a", 80D);
        functionFitter.setPar("mean", 0.5 * (minGaus + maxGaus));// 0.5*(fitrangegaus.min+fitrangegaus.max)
        functionFitter.setPar("s0", 0.01);
        functionFitter.setRange(minPoly, maxPoly);// tutaj daję range
        // najmniejszy-największy
        functionFitter.setParRange("a", 0D, Math.pow(10, 9));
        functionFitter.setParRange("mean", minGaus, maxGaus);
        functionFitter.setParRange("s0", 0D, (maxGaus - minGaus) / 2D);

        functionFitter.fit(h1);

        IFunction ff = functionFitter.getFittedFunc();
        IFitResult r = functionFitter.getResult();
        Pars = r.fittedParameters();
        double[] Errors = r.errors();
        String[] Names = r.fittedParameterNames();
        System.out.println("Fitted parameters: " + Arrays.toString(r.fittedParameters()));

        polynomialfitter.setFunc("fitPoly", 1, "p2*x[0]*x[0]+p1*x[0]+p0", "p2,p1,p0");
        ;
        polynomialfitter.setPar("p2", Pars[3]);
        polynomialfitter.setPar("p1", Pars[4]);
        polynomialfitter.setPar("p0", Pars[5]);
        polynomialfitter.setRange(minPoly, maxPoly);
        polynomialfitter.fit(h1);

        IFunction ffp = polynomialfitter.getFittedFunc();

        fFitGaus = new F1D("Gauss", ff, minGaus, maxGaus);
        fFitPolynomial = new F1D("Poly", ffp, minPoly, maxPoly);
        fFitGaus.setColor(Color.green);
        fFitGaus.setPenWidth(3);
        fFitPolynomial.setColor(Color.blue);
        fFitPolynomial.setPenWidth(3);

        BckFit = (int) (BackgroundIntegral(minGaus, maxGaus) / (this.h1.binLowerEdge(1) - this.h1.binLowerEdge(0)));
        System.out.println("BckFit: " + Integer.toString(BckFit));

        c1.draw(fFitPolynomial);
        c1.draw(fFitGaus);

        double errorFuntion1 = Erf.erf((minGaus - Pars[1]) / (Pars[2] * Math.sqrt(2)));
        double errorFuntion2 = Erf.erf((maxGaus - Pars[1]) / (Pars[2] * Math.sqrt(2)));
        signalFit = (int) (Math.sqrt(Math.PI / 2.) * Pars[0] * Pars[2] * (errorFuntion2 - errorFuntion1) / (this.h1.binLowerEdge(1) - this.h1
                .binLowerEdge(0)));
        TotalFit = (signalFit + BckFit);

        fFitGaus.eval(minGaus, maxGaus);

        System.out.println("signalfit " + signalFit);
        System.out.println("totalfit " + TotalFit);

        for (int i = 0; i < ff.numberOfParameters(); i++) {
            System.out.println(Names[i] + ":" + (Pars[i]));
        }
        System.out.println("fitted mean: " + Double.toString(1000D * Pars[1]));
        System.out.println("fitted sigma: " + Double.toString(1000D * Pars[2]));
        DecimalFormat df = new DecimalFormat("0.000000");
        String[] parsData = {"Total:" + TotalFit, "Background:" + BckFit, "Signal:" + signalFit,
                "Mean:" + df.format(1000D * Pars[1]) + "\u00B1" + df.format(Errors[1] * 1000.),
                "\u03c3:" + df.format(1000D * Pars[2]) + "\u00B1" + df.format(Errors[2] * 1000.)};
        this.c1.drawTextBox(parsData);

    }

    double BackgroundIntegral(Double xmin, Double xmax) {

        return ((xmax - xmin) * Pars[5] + Pars[4] * (Math.pow(xmax, 2) - Math.pow(xmin, 2)) / 2.)
                + (Pars[3] * (Math.pow(xmax, 3) - Math.pow(xmin, 3)) / 3.);

    }

    private static final long serialVersionUID = 1L;
    // JButton button;

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Histo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Histo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Histo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Histo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

		/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Histo().setVisible(true);
            }
        });
    }
}


