package main.java.gojek.model;

import java.util.List;

public class User {
    private int userId;

    private int balanceDollars;
    private int balanceCents;
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBalanceDollars() {
        return this.balanceDollars;
    }

    public void setBalanceDollars(int balanceDollars) {
        this.balanceDollars = balanceDollars;
    }

    public int getBalanceCents() {
        return this.balanceCents;
    }

    public void setBalanceCents(int balanceCents) {
        this.balanceCents = balanceCents;
    }

    public User(int userId){
        this.setBalanceDollars(0);
        this.setBalanceCents(0);
        this.setUserId(userId);
    }

    public User(int dollars, int cents, int userId){
        this.setBalanceDollars(dollars);
        this.setBalanceCents(cents);
        this.setUserId(userId);
    }

    public void credit(List<Integer> amount) {
        int dollars = amount.get(0);
        int cents = amount.get(1);
        this.balanceCents += cents;
        int carry = 0;
        if (Math.abs(this.balanceCents) >= 100) {
            carry = this.balanceCents / 100;
        }
        this.balanceCents %= 100;
        this.balanceDollars = this.balanceDollars + dollars + carry;
        sanitizeBalance();
    }

    public void debit(List<Integer> amount) {
        int dollars = amount.get(0);
        int cents = amount.get(1);
        this.balanceCents -= cents;
        int carry = 0;
        if (Math.abs(this.balanceCents) >= 100) {
            carry = this.balanceCents / 100;
        }
        this.balanceCents %= 100;
        this.balanceDollars = this.balanceDollars - dollars + carry;
        sanitizeBalance();
    }

    public void sanitizeBalance() {
        if (this.balanceDollars > 0 && this.balanceCents < 0) {
            this.balanceDollars -= 1;
            this.balanceCents += 100;
        } else if (this.balanceDollars < 0 && this.balanceCents > 0) {
            this.balanceDollars += 1;
            this.balanceCents -= 100;
        }
    }

    public String getBalance() {
        sanitizeBalance();
        return String.format("%dD %dC", this.getBalanceDollars(), this.getBalanceCents());
    }
}
