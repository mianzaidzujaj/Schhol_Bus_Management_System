class Account {
    protected String accountNo;
    protected int yearOfOpening;
    protected double balance;

    public Account(String accountNo, int yearOfOpening, double balance) {
        this.accountNo = accountNo;
        this.yearOfOpening = yearOfOpening;
        this.balance = balance;
    }

    public void applyInterest() {
        // Default implementation for applying interest
        // Can be overridden by child classes
        System.out.println("Applying interest on the account");
    }
}

class BusinessAccount extends Account {
    private static final double INTEREST_RATE = 0.15;

    public BusinessAccount(String accountNo, int yearOfOpening, double balance) {
        super(accountNo, yearOfOpening, balance);
    }

    @Override
    public void applyInterest() {
        double interest = balance * INTEREST_RATE;

        balance += interest;
        System.out.println("Applied " + (INTEREST_RATE * 100) + "% interest on BusinessAccount. New balance: " + balance);
    }
}
class SavingAccount extends Account {
    private static final double INTEREST_RATE = 0.10;

    public SavingAccount(String accountNo, int yearOfOpening, double balance) {
        super(accountNo, yearOfOpening, balance);
    }

    @Override
    public void applyInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Applied " + (INTEREST_RATE * 100) + "% interest on SavingAccount. New balance: " + balance);
    }
}

