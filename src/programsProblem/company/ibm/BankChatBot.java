package programsProblem.company.ibm;

import programsProblem.utils.DriverClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface IBankAccountOperation {
    void deposit(double d);
    void withdraw(double d);
    double processOperation(String message);
}

//Create the BankOperations class by implementing the IBankAccountOperation interface
class BankOperations implements IBankAccountOperation {
    double balance;

    public BankOperations() {
        this.balance = 0;
    }

    @Override
    public void deposit(double d) {
        this.balance += d;
    }

    @Override
    public void withdraw(double d) {
        if(d <= this.balance) {
            this.balance -= d;
        }
    }

    @Override
    public double processOperation(String message) {
        message = message.toLowerCase();
        if(message.contains("see") || message.contains("show")) {
            return this.balance;
        }
        else if(message.contains("deposit") || message.contains("put") || message.contains("invest") || message.contains("transfer")) {
            List<Integer> integers = getIntegers(message);
            deposit(integers.get(0));
        }
        else if(message.contains("withdraw") || message.contains("pull")) {
            List<Integer> integers = getIntegers(message);
            withdraw(integers.get(0));
        }

        return this.balance;
    }

    private List<Integer> getIntegers(String message) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(message);

        List<Integer> integers = new ArrayList<>();
        while(matcher.find())
            integers.add(Integer.parseInt(matcher.group()));

        return integers;
    }
}

public class BankChatBot implements DriverClass<Integer> {
    /**
     * Input should be: 1st line as integer for transactions. and from second line onward all line
     * will be a sentence for bank transaction as below:
     *
     * Eg 1:
     * 5
     * Deposit 2396
     * I want to transfer 3017 dollars to my account
     * I want to pull 2300 dollars
     * I want to deposit 3980 dollars
     * I want to transfer 2811 dollars to my account
     *
     * Eg 2:
     * 5
     * I want to invest 4410
     * I want to withdraw 161 dollars
     * I want to Withdraw 443
     * I want to pull 4272 dollars
     * pull 375
     */
    @Override
    public void driverMethod() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = 0;
        List<String> inputs = new ArrayList<>();

        try {
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                inputs.add(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BankOperations opt = new BankOperations();
        for (String item : inputs) {
            pw.println((int)opt.processOperation(item));
        }
        pw.flush();
        pw.close();
    }
}