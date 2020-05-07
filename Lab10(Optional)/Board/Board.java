import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Board {
    public JPanel boardView;

    private JButton btn00;
    private JButton btn01;
    private JButton btn02;
    private JButton btn03;
    private JButton btn04;
    private JButton btn05;
    private JButton btn06;
    private JButton btn07;
    private JButton btn08;
    private JButton btn09;
    private JButton btn10;
    private JButton btn11;
    private JButton btn12;
    private JButton btn13;
    private JButton btn14;
    private JButton btn15;
    private JButton btn16;
    private JButton btn17;
    private JButton btn18;
    private JButton btn19;
    private JLabel jLabelMSG;
    private JButton btn20;
    private JButton btn21;
    private JButton btn22;
    private JButton btn23;
    private JButton btn24;
    private JButton btn25;
    private JButton btn26;
    private JButton btn27;
    private JButton btn28;
    private JButton btn29;
    private JButton btn30;
    private JButton btn31;
    private JButton btn32;
    private JButton btn33;
    private JButton btn34;
    private JButton btn35;
    private JButton btn36;
    private JButton btn37;
    private JButton btn38;
    private JButton btn39;
    private JButton btn40;
    private JButton btn41;
    private JButton btn42;
    private JButton btn43;
    private JButton btn44;
    private JButton btn45;
    private JButton btn46;
    private JButton btn47;
    private JButton btn48;
    private JButton btn49;
    private JButton btn50;
    private JButton btn51;
    private JButton btn52;
    private JButton btn53;
    private JButton btn54;
    private JButton btn55;
    private JButton btn56;
    private JButton btn57;
    private JButton btn58;
    private JButton btn59;
    private JButton btn60;
    private JButton btn61;
    private JButton btn62;
    private JButton btn63;
    private JButton btn64;
    private JButton btn65;
    private JButton btn66;
    private JButton btn67;
    private JButton btn68;
    private JButton btn69;
    private JButton btn70;
    private JButton btn71;
    private JButton btn72;
    private JButton btn73;
    private JButton btn74;
    private JButton btn75;
    private JButton btn76;
    private JButton btn77;
    private JButton btn78;
    private JButton btn79;
    private JButton btn80;
    private JButton btn81;
    private JButton btn82;
    private JButton btn83;
    private JButton btn84;
    private JButton btn85;
    private JButton btn86;
    private JButton btn87;
    private JButton btn88;
    private JButton btn89;
    private JButton btn90;
    private JButton btn91;
    private JButton btn92;
    private JButton btn93;
    private JButton btn94;
    private JButton btn95;
    private JButton btn96;
    private JButton btn97;
    private JButton btn98;
    private JButton btn99;
    private JButton jButtonReplay;
    private JButton button1;
    private JButton button2;
    private JButton button4;
    private JButton button5;

    public void setX_or_o(int x_or_o) {
        this.x_or_o = x_or_o;
    }

    public void setjLabelMSG(String s) {
        this.jLabelMSG.setText(s);
    }

    private String response = "X turn now";
    private String ij = null;

    public String getIj() {
        return ij;
    }

    public void setIj(String ij) {
        this.ij = ij;
    }


    int[][] matrix = new int[10][10];
    public String getResponse()
    {
        return response;
    }
    public void setResponse(String response)
    {
        this.response=response;
    }

    public int getX_or_o() {
        return x_or_o;
    }

    public static void printMatrix(int mat[][])
    {
        // Loop through all rows
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }


    public void initReplayButton(){
        jButtonReplay.setBackground(Color.YELLOW);
        jButtonReplay.setText("Replay");
        jButtonReplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonReplayActionPerformed(e);
            }
        });
    }
    public void initButtons(){
        initReplayButton();
        jLabelMSG.setText("Play");
        btn00.setActionCommand("00");
        btn01.setActionCommand("01");
        btn02.setActionCommand("02");
        btn03.setActionCommand("03");
        btn04.setActionCommand("04");
        btn05.setActionCommand("05");
        btn06.setActionCommand("06");
        btn07.setActionCommand("07");
        btn08.setActionCommand("08");
        btn09.setActionCommand("09");
        btn10.setActionCommand("10");
        btn11.setActionCommand("11");
        btn12.setActionCommand("12");
        btn13.setActionCommand("13");
        btn14.setActionCommand("14");
        btn15.setActionCommand("15");
        btn16.setActionCommand("16");
        btn17.setActionCommand("17");
        btn18.setActionCommand("18");
        btn19.setActionCommand("19");
        btn20.setActionCommand("20");
        btn21.setActionCommand("21");
        btn22.setActionCommand("22");
        btn23.setActionCommand("23");
        btn24.setActionCommand("24");
        btn25.setActionCommand("25");
        btn26.setActionCommand("26");
        btn27.setActionCommand("27");
        btn28.setActionCommand("28");
        btn29.setActionCommand("29");
        btn30.setActionCommand("30");
        btn31.setActionCommand("31");
        btn32.setActionCommand("32");
        btn33.setActionCommand("33");
        btn34.setActionCommand("34");
        btn35.setActionCommand("35");
        btn36.setActionCommand("36");
        btn37.setActionCommand("37");
        btn38.setActionCommand("38");
        btn39.setActionCommand("39");
        btn40.setActionCommand("40");
        btn41.setActionCommand("41");
        btn42.setActionCommand("42");
        btn43.setActionCommand("43");
        btn44.setActionCommand("44");
        btn45.setActionCommand("45");
        btn46.setActionCommand("46");
        btn47.setActionCommand("47");
        btn48.setActionCommand("48");
        btn49.setActionCommand("49");
        btn50.setActionCommand("50");
        btn51.setActionCommand("51");
        btn52.setActionCommand("52");
        btn53.setActionCommand("53");
        btn54.setActionCommand("54");
        btn55.setActionCommand("55");
        btn56.setActionCommand("56");
        btn57.setActionCommand("57");
        btn58.setActionCommand("58");
        btn59.setActionCommand("59");
        btn60.setActionCommand("60");
        btn61.setActionCommand("61");
        btn62.setActionCommand("62");
        btn63.setActionCommand("63");
        btn64.setActionCommand("64");
        btn65.setActionCommand("65");
        btn66.setActionCommand("66");
        btn67.setActionCommand("67");
        btn68.setActionCommand("68");
        btn69.setActionCommand("69");
        btn70.setActionCommand("70");
        btn71.setActionCommand("71");
        btn72.setActionCommand("72");
        btn73.setActionCommand("73");
        btn74.setActionCommand("74");
        btn75.setActionCommand("75");
        btn76.setActionCommand("76");
        btn77.setActionCommand("77");
        btn78.setActionCommand("78");
        btn79.setActionCommand("79");
        btn80.setActionCommand("80");
        btn81.setActionCommand("81");
        btn82.setActionCommand("82");
        btn83.setActionCommand("83");
        btn84.setActionCommand("84");
        btn85.setActionCommand("85");
        btn86.setActionCommand("86");
        btn87.setActionCommand("87");
        btn88.setActionCommand("88");
        btn89.setActionCommand("89");
        btn90.setActionCommand("90");
        btn91.setActionCommand("91");
        btn92.setActionCommand("92");
        btn93.setActionCommand("93");
        btn94.setActionCommand("94");
        btn95.setActionCommand("95");
        btn96.setActionCommand("96");
        btn97.setActionCommand("97");
        btn98.setActionCommand("98");
        btn99.setActionCommand("99");
    }
    public void setButton(JButton button)
    {
        button.setText("X");
        button.setForeground(Color.BLUE);
    }
    int x_or_o = 0;
    public ActionListener createAction(JButton button)
    {
        ActionListener al = e -> {
            if(button.getText().equals("") && !button.getActionCommand().equals("Replay")){
                String nume = button.getActionCommand();
                ij = nume;

                if((x_or_o % 2) == 0)
                {
                    int iTemp = nume.charAt(0)-'0';
                    int jTemp = nume.charAt(1)-'0';
                    //System.out.println(iTemp +  "-i j-" + jTemp);
                    matrix[iTemp][jTemp]=1; //1 for X
                    button.setText("X");
                    button.setForeground(Color.BLUE);
                    setResponse("O turn now");
                 }else{
                    // System.out.println("actionCMD = " + nume);
                    int iTemp = nume.charAt(0)-'0';
                    int jTemp = nume.charAt(1)-'0';
                    matrix[iTemp][jTemp]=2; //2 for O
                    button.setText("O");
                    button.setForeground(Color.RED);
                    button.setSize(20,20);
                    setResponse("X turn now");
                }

                x_or_o ++;
            }

        };
        return al;
    }
    public void addAction(){

        Component[] comps = boardView.getComponents();
        int number = 0;
        for(Component comp : comps){
            if(comp instanceof JButton){
                JButton button = (JButton)comp;
                button.addActionListener(createAction(button));
                number++;
            }
        }

    }
    public void initMatrix()
    {
        for(int i = 0; i<10;i++)
            for(int j = 0; j<10; j++)
            {
                matrix[i][j] = 0;
            }
    }

    public Board() {
        initButtons();
        initMatrix();
        addAction();
    }

    private void jButtonReplayActionPerformed(ActionEvent evt) {
        Component[] comps = boardView.getComponents();

        for(Component comp : comps){
            if((comp instanceof JButton) ){
                JButton button = (JButton)comp;
                button.setText("");
                button.setBackground(Color.WHITE);
                jLabelMSG.setText("Play");
            }
        }

        initButtons();
        initMatrix();
        addAction();
    }




}
