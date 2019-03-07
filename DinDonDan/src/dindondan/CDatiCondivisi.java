/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondan;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Princess Joy Padua
 *
 */
public class CDatiCondivisi {

    /**
     * @author Princess Joy Padua
     *
     * Creo variabili di tipo int che mi vanno a contare i suoni effettuati dai
     * thread.
     *
     */
    int contaDIN = 0, contaDON = 0, contaDAN = 0;

    int maxElem = 10000000;
    String schermo[];
    int p;
    String campana;

    private Semaphore semDIN;
    private Semaphore semDON;
    private Semaphore semDAN;

    private Semaphore SynchDin;
    private Semaphore SynchDon;
    private Semaphore SynchDan;

    private Semaphore semVisualizza1;
    private Semaphore semVisualizza2;

    public CDatiCondivisi() {
        this.schermo = new String[maxElem];
        this.p = 0;

        semDIN = new Semaphore(0);
        semDON = new Semaphore(0);
        semDAN = new Semaphore(0);

        SynchDin = new Semaphore(1);
        SynchDon = new Semaphore(0);
        SynchDan = new Semaphore(0);

        semVisualizza1 = new Semaphore(0);
        semVisualizza2 = new Semaphore(1);
        
        campana="";
    }

    public CDatiCondivisi(int contaDIN, int contaDON, int contaDAN) {
        this.contaDIN = contaDIN;
        this.contaDON = contaDON;
        this.contaDAN = contaDAN;
        this.schermo = new String[maxElem];
        this.p = 0;

    }
    
    public String getCampana() {
        return campana;
    }
    
    public void setCampana(String campana) {
        this.campana=campana;
    }
    
    public void semVisualizza1Wait() throws InterruptedException {
        semVisualizza1.acquire();
    }
    
    public void semVisualizza2Wait() throws InterruptedException {
        semVisualizza2.acquire();
    }

    public void WaitSynchDin() throws InterruptedException {
        SynchDin.acquire();
    }

    public void WaitSynchDon() throws InterruptedException {
        SynchDon.acquire();
    }

    public void WaitSynchDan() throws InterruptedException {
        SynchDan.acquire();
    }

    public void WaitDIN() throws InterruptedException {
        semDIN.acquire();
    }

    public void WaitDON() throws InterruptedException {
        semDON.acquire();
    }

    public void WaitDAN() throws InterruptedException {
        semDAN.acquire();
    }
    
    public void semVisualizza1Signal() throws InterruptedException {
        semVisualizza1.release();
    }
    
    public void semVisualizza2Signal() throws InterruptedException {
        semVisualizza2.release();
    }

    public void SignalSynchDin() {
        SynchDin.release();
    }

    public void SignalSynchDon() {
        SynchDon.release();
    }

    public void SignalSynchDan() {
        SynchDan.release();
    }

    public void SignalDIN() {
        semDIN.release();
    }

    public void SignalDON() {
        semDON.release();
    }

    public void SignalDAN() {
        semDAN.release();
    }

    public synchronized int getContaDIN() {
        return contaDIN;
    }

    public synchronized void setContaDIN(int contaDIN) {
        this.contaDIN = contaDIN;
    }

    public synchronized int getContaDON() {
        return contaDON;
    }

    public synchronized void setContaDON(int contaDON) {
        this.contaDON = contaDON;
    }

    public synchronized int getContaDAN() {
        return contaDAN;
    }

    public synchronized void setContaDAN(int contaDAN) {
        this.contaDAN = contaDAN;
    }
    
    

    /**
     *
     * @param c Indico la scelta effettuata dall'untete fatta nel main
     *
     * @return indica se hai vinto o no.
     *
     */
    public synchronized String verificaSeHaiVinto(int c) {
        String x = "Hai Perso";
        if (c == 1 && contaDIN > contaDON && contaDIN > contaDAN) {
            x = "Hai Vinto!";
        }
        if (c == 2 && contaDON > contaDIN && contaDON > contaDAN) {
            x = "Hai Vinto!";
        }
        if (c == 3 && contaDAN > contaDON && contaDAN > contaDON) {
            x = "Hai Vinto!";
        }
        return x;
    }

    public synchronized void aggiungi(String x) {
        if (p >= maxElem) {
            p = 0;
        }
        schermo[p] = x;
        p += 1;
    }

    public synchronized void printSchermo() {
        System.out.println("----------------------------");
        for (int i = 0; i < p; i++) {
            System.out.print(schermo[i] + " ");
            if (i % 20 == 19) {
                System.out.println("");
            }
        }
        System.out.println("\n----------------------------");
    }
}
