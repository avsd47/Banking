package main.java.gojek.Model;


public class Balance {
    private int dollars;
    private int cents;

    public int getDollars() {
        return this.dollars;
    }

    public int getCents() {
        return this.cents;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }

    public void credit(Balance balance){
        this.cents += balance.getCents();
        int carry = 0;
        if(Math.abs(this.cents) > 100 ){
            carry = cents/100;
        }
        this.cents %= 100;
        this.dollars = this.dollars + balance.getDollars() + carry;
        sanitizeBalance();
    }

    // TODO : try catch for input(custom exceptions), Unit tests, Add User Model
    public void debit(Balance balance){
        this.cents -= balance.getCents();
        int carry = 0;
        if(Math.abs(this.cents) > 100 ){
            carry = cents/100;
        }
        this.cents %= 100;
        this.dollars = this.dollars - balance.getDollars() + carry;
        sanitizeBalance();
    }

    public void sanitizeBalance(){
        if(this.dollars > 0 && this.cents < 0){
            this.dollars -= 1;
            this.cents += 100;
        }
        else if(this.dollars < 0 && this.cents > 0){
            this.dollars += 1;
            this.cents -= 100;
        }
    }

    public String getBalance(){
        return String.format("%dD %dC",this.getDollars(), this.getCents());
    }
}
