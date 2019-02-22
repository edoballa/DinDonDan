/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondan;

/**
 *
 * @author Ballabio Edoardo
 */
public class CDatiCondivisi {
    private int contDin;
    private int contDon;
    private int contDan;
    private String [] schermo;
    private int primoElem;
    
    public CDatiCondivisi(int ContDin,int ContDon,int ContDan) {
        this.contDin = ContDin;
        this.contDon = ContDon;
        this.contDan = ContDan;
    }
    
    public CDatiCondivisi() {
        contDin = 0;
        contDon = 0;
        contDan = 0;
    }

    public synchronized int getContDin() {
        return contDin;
    }

    public synchronized void setContDin(int contDin) {
        this.contDin = contDin;
    }

    public synchronized int getContDon() {
        return contDon;
    }

    public synchronized void setContDon(int contDon) {
        this.contDon = contDon;
    }

    public synchronized int getContDan() {
        return contDan;
    }

    public synchronized void setContDan(int contDan) {
        this.contDan = contDan;
    }
    
    public synchronized String VisualizzaSchermo() {
       String risultato = "";
       for(int i=0; i<1000; i++) {
           if(schermo[i].equals("")) {
               i=1000;
           }
           else {
               return risultato = risultato + schermo[i];
           }
       }
       return risultato;
    }
    
    public synchronized void AggiungiStringa(String s) {
        schermo[primoElem]=s;
        primoElem++;
    }   
}
