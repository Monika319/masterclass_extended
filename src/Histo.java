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

    private JInternalFrame jInternalFrame1;
    private JTabbedPane jTabbedPane1;
    private JTabbedPane jTabbedPane2;
    private JTabbedPane jTabbedPane3;
    private JTabbedPane jTabbedPane4;
    private Container jPanel1;
    private JPanel jPanel2;
    // private JDesktopPane jDesktopPane1;
    private JTabbedPane jTabbedPane5;
    private CheckBoxList list;
    private JCheckBox[] boxes;
    private FileReader fr;
    private String name;
    private double wartosc;
    private HPlot c1;
    private HFitter polynomialfitter;
    private HFitter functionFitter;
    private F1D fFitGaus;
    private F1D fFitPolynomial;
    private int TotalFit;
    private int signalFit;
    private int BckFit;
    private double[] Pars;
    H1D h1;
    private JLayeredPane jLayeredPane1;
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

        jTabbedPane5.addTab("Invariant Mass", c1.getCanvasPanel());

        read();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jTabbedPane6 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        list = new CheckBoxList();
        boxes = new JCheckBox[12];
        boxes[0] = new JCheckBox("pp", true);

        boxes[1] = new JCheckBox("PbPb", true);

        boxes[2] = new JCheckBox("PbPb-0-10%", true);

        boxes[3] = new JCheckBox("PbPb-10-20%", true);
        boxes[4] = new JCheckBox("PbPb-20-30%", true);
        boxes[5] = new JCheckBox("PbPb-30-40%", true);
        boxes[6] = new JCheckBox("PbPb-40-50%", true);
        boxes[7] = new JCheckBox("PbPb-50-60%", true);
        boxes[8] = new JCheckBox("PbPb-60-70%", true);
        boxes[9] = new JCheckBox("PbPb-70-80%", true);
        boxes[10] = new JCheckBox("PbPb-80-90%", true);
        boxes[11] = new JCheckBox("PbPb-90-100%", true);
        list.setListData(boxes);

        list2 = new CheckBoxList();
        boxes2 = new JCheckBox[12];
        boxes2[0] = new JCheckBox("pp", true);

        boxes2[1] = new JCheckBox("PbPb", true);

        boxes2[2] = new JCheckBox("PbPb-0-10%", true);

        boxes2[3] = new JCheckBox("PbPb-10-20%", true);
        boxes2[4] = new JCheckBox("PbPb-20-30%", true);
        boxes2[5] = new JCheckBox("PbPb-30-40%", true);
        boxes2[6] = new JCheckBox("PbPb-40-50%", true);
        boxes2[7] = new JCheckBox("PbPb-50-60%", true);
        boxes2[8] = new JCheckBox("PbPb-60-70%", true);
        boxes2[9] = new JCheckBox("PbPb-70-80%", true);
        boxes2[10] = new JCheckBox("PbPb-80-90%", true);
        boxes2[11] = new JCheckBox("PbPb-90-100%", true);
        list2.setListData(boxes2);
        jTabbedPane1.addTab("K0", list);
        jTabbedPane1.addTab("Lambda", list2);
        jTabbedPane1.addTab("AntiLambda", jTabbedPane5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 264,
                javax.swing.GroupLayout.PREFERRED_SIZE));

        jTabbedPane6.setBackground(new java.awt.Color(144, 56, 48));
        // jTabbedPane5.addTab("tab1", c1.getCanvasPanel());

        jTabbedPane5.setBounds(20, 0, 600, 500);
        jLayeredPane1.add(jTabbedPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 242, Short.MAX_VALUE))
                .addComponent(jLayeredPane1));

        pack();
    }// </editor-fold>

    public void read() {
        int i;
        // final String nazwa;
        // final H1D h1 = new H1D("Histogram", 25, 0.0D, 2.5D);
        // Random r = new Random();
        // // h1.setFill(true);
        // h1.setFillColor(new Color(r.nextFloat(), r.nextFloat(),
        // r.nextFloat(), 0.5F));
        // h1.setErrX(false);
        // h1.setErrY(true);
        // h1.setPenWidthErr(2);
        boxes[0].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(0.0D, 1.0D, "pp-K0.txt", 110);
            }
        });
        // nazwa="/home/rafal/pp-K0.txt";
        boxes[1].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(0.0D, 1.0D, "PbPb-K0.txt", 1450);
            }
        });
        boxes[2].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(0.0D, 1.0D, "dataset11.txt", 2600);
                FunctionFitter(0.487, 0.508, 0.3, 1D);
            }
        });
        boxes[3].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(0.0D, 1.0D, "dataset12.txt", 2000);
            }
        });
        boxes[4].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(0.0D, 1.0D, "dataset13.txt", 1400);
            }
        });
        boxes[5].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(0.0D, 1.0D, "dataset14.txt", 850);
            }
        });
        boxes[6].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(0.0D, 1.0D, "dataset15.txt", 420);
            }
        });
        boxes[7].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(0.0D, 1.0D, "dataset16.txt", 220);
            }
        });
        boxes[8].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(0.0D, 1.0D, "dataset17.txt", 140);
            }
        });
        boxes[9].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(0.0D, 1.0D, "dataset18.txt", 60);
            }
        });
        boxes[10].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(0.0D, 1.0D, "dataset19.txt", 35);
            }
        });
        boxes[11].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(0.0D, 1.0D, "dataset20.txt", 2.2);
            }
        });
        boxes2[0].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(1.0D, 2.0D, "pp-Lambda.txt", 150);
            }
        });
        // nazwa="/home/rafal/pp-K0.txt";
        boxes2[1].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(1.0D, 2.0D, "PbPb-Lambda.txt", 820);
            }
        });
        boxes2[2].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(1.0D, 2.0D, "dataset21.txt", 1200);
            }
        });
        boxes2[3].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(1.0D, 2.0D, "dataset22.txt", 1150);
            }
        });
        boxes2[4].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(1.0D, 2.0D, "dataset23.txt", 850);
            }
        });
        boxes2[5].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(1.0D, 2.0D, "dataset24.txt", 500);
            }
        });
        boxes2[6].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(1.0D, 2.0D, "dataset25.txt", 300);
            }
        });
        boxes2[7].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(1.0D, 2.0D, "dataset26.txt", 150);
            }
        });
        boxes2[8].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(1.0D, 2.0D, "dataset27.txt", 60);
            }
        });
        boxes2[9].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(1.0D, 2.0D, "dataset28.txt", 35);
            }
        });
        boxes2[10].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(1.0D, 2.0D, "dataset29.txt", 10);
            }
        });
        boxes2[11].addItemListener(new ItemListener() {
            // private String nazwa;

            // @Override

            public void itemStateChanged(ItemEvent ev) {

                JCheckBox src = (JCheckBox) ev.getSource();
                // System.out.println(src.isSelected());
                plot_hist(1.0D, 2.0D, "/home/rafal/datasets/dataset30.txt", 8);
            }
        });

        // System.out.println("Wczytano liczbÄ: "+wartosc);

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

//         //OTWIERANIE PLIKU:
//         try {
//         fr = new FileReader(name);
//         } catch (FileNotFoundException e) {
//         System.out.println("BÅ?ÄD PRZY OTWIERANIU PLIKU!");
//         System.exit(1);
//         }
//
//         StreamTokenizer st = new StreamTokenizer(fr);
//         ODCZYT KOLEJNYCH "TOKENÃW" Z PLIKU:
//         try {
//         while ((wartosc = st.nextToken()) != StreamTokenizer.TT_EOF) {
//         if (wartosc == StreamTokenizer.TT_WORD)
//         System.out.println("Wczytano sÅowo: " + st.sval);
//         else if (wartosc == StreamTokenizer.TT_NUMBER)
//         System.out.println("Wczytano liczbÄ: " + st.nval);
//         //h1.fill(st.nval);
//
//         }
//
//
//
//
//         } catch (IOException e) {
//         System.out.println("BÅ?ÄD ODCZYTU Z PLIKU!");
//         System.exit(2);
//         }
            // c1.setLegendPos(WIDTH, HIDE_ON_CLOSE);
            //
            // c1.draw(h1);
            // c1.drawStatBox(h1);
            // c1.refreshFrame();

//         ZAMYKANIE PLIKU:
//         try {
//         fr.close();
//         } catch (IOException e) {
//         System.out.println("BÅ?ÄD PRZY ZAMYKANIU PLIKU!");
//         System.exit(3);
//         }
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
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

		/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
            }
        });
    }
}
