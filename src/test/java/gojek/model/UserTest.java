package test.java.gojek.model;


import main.java.gojek.model.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testCredit(){
        User user = new User();
        user.credit(Arrays.asList(10,5));
        assertEquals("10D 5C", user.getBalance());
        user.credit(Arrays.asList(-9,-105));
        assertEquals("0D 0C", user.getBalance());
        user.credit(Arrays.asList(-5,10));
        assertEquals("-4D -90C", user.getBalance());
    }

    @Test
    public void testDebit(){
        User user = new User();
        user.debit(Arrays.asList(10,5));
        assertEquals("-10D -5C", user.getBalance());
        user.debit(Arrays.asList(-9,-105));
        assertEquals("0D 0C", user.getBalance());
        user.debit(Arrays.asList(-5,10));
        assertEquals("4D 90C", user.getBalance());
    }

    @Test
    public void testBalance(){
        User user = new User(10, -90);
        assertEquals("9D 10C",user.getBalance());
    }
}
