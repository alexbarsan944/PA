/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

/**
 *
 * @author School
 */
public class Player {
    public int simbol;
    public boolean turn;

    public Player(int simbol) {
        this.turn = false;
        this.simbol=simbol;
    }

    public int getSimbol() {
        return simbol;
    }

    @Override
    public String toString() {
        return "Player"  + simbol + "{";
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }
    
        
}
