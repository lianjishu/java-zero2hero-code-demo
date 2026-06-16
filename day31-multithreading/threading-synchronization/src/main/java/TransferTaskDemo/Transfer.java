package TransferTaskDemo;

public class Transfer {

    private Account from; //转出方
    private Account to; //转入方
    private int amount; //转账金额

    public Transfer() {
    }

    public Transfer(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }



    public Account getFrom() {
        return from;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return String.format(
                """
                        Transfer{
                                    %s => %s | Amount=%d
                        }
                """,
                from.toString(),
                to.toString(),
                amount
        );
    }
}
