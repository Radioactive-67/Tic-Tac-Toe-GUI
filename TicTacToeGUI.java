/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttt;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashish Anand
 */
public class TicTacToeGUI extends javax.swing.JFrame {
    private String player1="Player 1";
    private String player2="Player 2";
    private int score1=0;
    private int score2=0;
    private String whoseTurn="";
    private String turn = "X";
    private char arr[]=new char[9];
    private boolean draw = false;
    private boolean gameOver = false;
    private boolean Xwins = false;
    private boolean Owins = false;
    /**
     * Creates new form TicTacToeGUI
     */
    public TicTacToeGUI() {
        initComponents();
        setSize(720,720);
        setLocationRelativeTo(null);
        playerName();
        setScore();
    }
    
    private void setScore(){
        
                
        jLabel_Score.setText(player1 + "'s Score: "+ String.valueOf(score1) + "        "+ whoseTurn + "'s move"+ "        "+ player2+ "'s Score: "+ String.valueOf(score2));
        
    }
    
    private void setMove(){
        if(turn=="X"){
            whoseTurn = player1;
        }
        else{
            whoseTurn = player2;
        }
        jLabel_Score.setText(player1 + "'s Score: "+ String.valueOf(score1) + "        "+ whoseTurn + "'s move"+ "        "+ player2+ "'s Score: "+ String.valueOf(score2));

    }
    
    private void playerName(){
        player1=JOptionPane.showInputDialog(this,
                "Enter Name of Player 1 : ",
                "Player Name",
                JOptionPane.INFORMATION_MESSAGE);
        
        
        player2=JOptionPane.showInputDialog(this,
                "Enter Name of Player 2 : ",
                "Player Name",
                JOptionPane.INFORMATION_MESSAGE);
        
        
        if(player1.equals("") || player1.equals(" ")){
            player1="Player 1";
        }
        if(player2.equals("") || player2.equals(" ")){
            player2="Player 2";
        }
        whoseTurn=player1;
    }
    
    private void determineTurn(){
        if(turn.equalsIgnoreCase("x")){
            turn= "O";
        }
        else{
            turn="X";
        }
    }
    
    // X wins the game
    private boolean winner1(char[] arr){
        //X wins horizontally
        if(arr[0]=='X' && arr[1]=='X' && arr[2]=='X' ){
            Xwins=true;
        }
        else if(arr[3]=='X' && arr[4]=='X' && arr[5]=='X' ){
            Xwins=true;
        }
        else if(arr[6]=='X' && arr[7]=='X' && arr[8]=='X' ){
            Xwins=true;
        }
        //X wins vertically
        
        else if(arr[0]=='X' && arr[3]=='X' && arr[6]=='X' ){
            Xwins=true;
        }
        else if(arr[1]=='X' && arr[4]=='X' && arr[7]=='X' ){
            Xwins=true;
        }
        else if(arr[2]=='X' && arr[5]=='X' && arr[8]=='X' ){
            Xwins=true;
        }
        //X wins diagonally
        
        else if(arr[0]=='X' && arr[4]=='X' && arr[8]=='X' ){
            Xwins=true;
        }
        else if(arr[6]=='X' && arr[4]=='X' && arr[2]=='X' ){
            Xwins=true;
        }
        else{
            Xwins=false;
        }
        return Xwins;
    }
    
    //pop up for X win
    private void xPop(){
        JOptionPane.showMessageDialog(this,
        player1 + " Wins",
        "Winner",
        JOptionPane.INFORMATION_MESSAGE);
        score1++;
        reset();
        
    }
    
    //pop up for O win
    private void oPop(){
        JOptionPane.showMessageDialog(this,
        player2 + " Wins",
        "Winner",
        JOptionPane.INFORMATION_MESSAGE);
        score2++;
        reset();
        
    }
    //pop up for draw
    private void drawPop(){
        JOptionPane.showMessageDialog(this,
        "Game Tied",
        "Draw",
        JOptionPane.INFORMATION_MESSAGE);
        reset();
    }
    
    // O wins the game
    private boolean winner2(boolean Owins, char[] arr){
        
         //O wins horizontally
        if(arr[0]=='O' && arr[1]=='O' && arr[2]=='O' ){
            Owins=true;
        }
        else if(arr[3]=='O' && arr[4]=='O' && arr[5]=='O' ){
            Owins=true;
        }
        else if(arr[6]=='O' && arr[7]=='O' && arr[8]=='O' ){
            Owins=true;
        }
        //O wins vertically
        
        else if(arr[0]=='O' && arr[3]=='O' && arr[6]=='O' ){
            Owins=true;
        }
        else if(arr[1]=='O' && arr[4]=='O' && arr[7]=='O' ){           
            Owins=true;
        }
        else if(arr[2]=='O' && arr[5]=='O' && arr[8]=='O' ){
            Owins=true;
        }
        //O wins diagonally
        
        else if(arr[0]=='O' && arr[4]=='O' && arr[8]=='O' ){
            Owins=true;
        }
        else if(arr[6]=='O' && arr[4]=='O' && arr[2]=='O' ){
            Owins=true;
        }
        else{
            Owins=false;
        }
        return Owins;
    }
    
    
    private void status(){
        setMove();
        draw = false;
        gameOver = false;
        //Xwins = false;
        //Owins = false;
        String s1 = jButton1.getText();
        String s2 = jButton2.getText();
        String s3 = jButton3.getText();
        String s4 = jButton4.getText();
        String s5 = jButton5.getText();
        String s6 = jButton6.getText();
        String s7 = jButton7.getText();
        String s8 = jButton8.getText();
        String s9 = jButton9.getText();

        
        
        arr[0]=s1.charAt(0);
        arr[1]=s2.charAt(0);
        arr[2]=s3.charAt(0);
        arr[3]=s4.charAt(0);
        arr[4]=s5.charAt(0);
        arr[5]=s6.charAt(0);
        arr[6]=s7.charAt(0);
        arr[7]=s8.charAt(0);
        arr[8]=s9.charAt(0);

        Xwins = winner1(arr);
        Owins = winner2(Owins,arr);
        
        if(Xwins==true){
            gameOver=true;
            xPop();
            
        }
        else if(Owins==true){
            gameOver=true;
            oPop();
        }
        
        for(char c : arr){
            if(c == 'X'||c == 'O'){
                gameOver=true;
            }
            else{
                gameOver=false;
                break;
            }
        }  
        if(Xwins == false && Owins == false && gameOver == true){
            draw = true;
            drawPop();
                
        }
        else{
            draw = false;
        }
        
        
        
        
        
        
    }
    
    private void reset(){
        
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jButton7.setEnabled(true);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);
        
        
        jButton1.setText(" ");
        jButton2.setText(" ");
        jButton3.setText(" ");
        jButton4.setText(" ");
        jButton5.setText(" ");
        jButton6.setText(" ");
        jButton7.setText(" ");
        jButton8.setText(" ");
        jButton9.setText(" ");
        setScore();
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel_Score = new javax.swing.JLabel();
        GridPannel = new javax.swing.JPanel();
        Box_1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Box_2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        Box_3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        Box_4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        Box_5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        Box_6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        Box_7 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        Box_8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        Box_9 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe - by Radioactive_67");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setForeground(new java.awt.Color(255, 0, 51));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel_Score.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Score.setFont(new java.awt.Font("DejaVu Serif", 3, 14)); // NOI18N
        jLabel_Score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Score.setText("Place holder for scores");
        jPanel1.add(jLabel_Score, java.awt.BorderLayout.PAGE_END);

        GridPannel.setBackground(new java.awt.Color(204, 204, 204));
        GridPannel.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        Box_1.setBackground(new java.awt.Color(255, 255, 255));
        Box_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Box_1.setLayout(new java.awt.BorderLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("DejaVu Serif", 3, 100)); // NOI18N
        jButton1.setText(" ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Box_1.add(jButton1, java.awt.BorderLayout.CENTER);

        GridPannel.add(Box_1);

        Box_2.setBackground(new java.awt.Color(255, 255, 255));
        Box_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Box_2.setLayout(new java.awt.BorderLayout());

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("DejaVu Serif", 3, 100)); // NOI18N
        jButton2.setText(" ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Box_2.add(jButton2, java.awt.BorderLayout.CENTER);

        GridPannel.add(Box_2);

        Box_3.setBackground(new java.awt.Color(255, 255, 255));
        Box_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Box_3.setLayout(new java.awt.BorderLayout());

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("DejaVu Serif", 3, 100)); // NOI18N
        jButton3.setText(" ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Box_3.add(jButton3, java.awt.BorderLayout.CENTER);

        GridPannel.add(Box_3);

        Box_4.setBackground(new java.awt.Color(255, 255, 255));
        Box_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Box_4.setLayout(new java.awt.BorderLayout());

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("DejaVu Serif", 3, 100)); // NOI18N
        jButton4.setText(" ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Box_4.add(jButton4, java.awt.BorderLayout.CENTER);

        GridPannel.add(Box_4);

        Box_5.setBackground(new java.awt.Color(255, 255, 255));
        Box_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Box_5.setLayout(new java.awt.BorderLayout());

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("DejaVu Serif", 3, 100)); // NOI18N
        jButton5.setText(" ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Box_5.add(jButton5, java.awt.BorderLayout.CENTER);

        GridPannel.add(Box_5);

        Box_6.setBackground(new java.awt.Color(255, 255, 255));
        Box_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Box_6.setLayout(new java.awt.BorderLayout());

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("DejaVu Serif", 3, 100)); // NOI18N
        jButton6.setText(" ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Box_6.add(jButton6, java.awt.BorderLayout.CENTER);

        GridPannel.add(Box_6);

        Box_7.setBackground(new java.awt.Color(255, 255, 255));
        Box_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Box_7.setLayout(new java.awt.BorderLayout());

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setFont(new java.awt.Font("DejaVu Serif", 3, 100)); // NOI18N
        jButton7.setText(" ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        Box_7.add(jButton7, java.awt.BorderLayout.CENTER);

        GridPannel.add(Box_7);

        Box_8.setBackground(new java.awt.Color(255, 255, 255));
        Box_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Box_8.setLayout(new java.awt.BorderLayout());

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setFont(new java.awt.Font("DejaVu Serif", 3, 100)); // NOI18N
        jButton8.setText(" ");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        Box_8.add(jButton8, java.awt.BorderLayout.CENTER);

        GridPannel.add(Box_8);

        Box_9.setBackground(new java.awt.Color(255, 255, 255));
        Box_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Box_9.setLayout(new java.awt.BorderLayout());

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setFont(new java.awt.Font("DejaVu Serif", 3, 100)); // NOI18N
        jButton9.setText(" ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        Box_9.add(jButton9, java.awt.BorderLayout.CENTER);

        GridPannel.add(Box_9);

        jPanel1.add(GridPannel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jButton8.setText(turn);
        if(turn.equalsIgnoreCase("x")){
            jButton8.setForeground(Color.orange);
        }
        else{
           jButton8.setForeground(Color.green); 
        }
        determineTurn();
        jButton8.setEnabled(false);
        status();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setText(turn);
        if(turn.equalsIgnoreCase("x")){
            jButton1.setForeground(Color.orange);
        }
        else{
           jButton1.setForeground(Color.green); 
        }
        determineTurn();
        jButton1.setEnabled(false);
        status();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton2.setText(turn);
        if(turn.equalsIgnoreCase("x")){
            jButton2.setForeground(Color.orange);
        }
        else{
           jButton2.setForeground(Color.green); 
        }
        determineTurn();
        jButton2.setEnabled(false);
        status();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton3.setText(turn);
        if(turn.equalsIgnoreCase("x")){
            jButton3.setForeground(Color.orange);
        }
        else{
           jButton3.setForeground(Color.green); 
        }
        determineTurn();
        jButton3.setEnabled(false);
        status();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton4.setText(turn);
        if(turn.equalsIgnoreCase("x")){
            jButton4.setForeground(Color.orange);
        }
        else{
           jButton4.setForeground(Color.green); 
        }
        determineTurn();
        jButton4.setEnabled(false);
        status();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton5.setText(turn);
        if(turn.equalsIgnoreCase("x")){
            jButton5.setForeground(Color.orange);
        }
        else{
           jButton5.setForeground(Color.green); 
        }
        determineTurn();
        jButton5.setEnabled(false);
        status();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jButton6.setText(turn);
        if(turn.equalsIgnoreCase("x")){
            jButton6.setForeground(Color.orange);
        }
        else{
           jButton6.setForeground(Color.green); 
        }
        determineTurn();
        jButton6.setEnabled(false);
        status();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jButton7.setText(turn);
        if(turn.equalsIgnoreCase("x")){
            jButton7.setForeground(Color.orange);
        }
        else{
           jButton7.setForeground(Color.green); 
        }
        determineTurn();
        jButton7.setEnabled(false);
        status();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jButton9.setText(turn);
        if(turn.equalsIgnoreCase("x")){
            jButton9.setForeground(Color.orange);
        }
        else{
           jButton9.setForeground(Color.green); 
        }
        determineTurn();
        jButton9.setEnabled(false);
        status();
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Box_1;
    private javax.swing.JPanel Box_2;
    private javax.swing.JPanel Box_3;
    private javax.swing.JPanel Box_4;
    private javax.swing.JPanel Box_5;
    private javax.swing.JPanel Box_6;
    private javax.swing.JPanel Box_7;
    private javax.swing.JPanel Box_8;
    private javax.swing.JPanel Box_9;
    private javax.swing.JPanel GridPannel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Score;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
