package homefinance.model;

import homefinance.exception.ModelException;
import homefinance.saveload.SaveData;

import java.util.Date;

public class Transaction extends Common{

    private Account account;
    private Article article;
    private double amount;
    private String notes;
    private Date date;

    public Transaction() { }

    public Transaction(Account account, Article article, double amount, String notes, Date date) throws ModelException{
        if(account==null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if(article==null) throw new ModelException(ModelException.ARTICLE_EMPTY);
        this.account = account;
        this.article = article;
        this.amount = amount;
        this.notes = notes;
        this.date = date;
    }

    public Transaction(Account account, Article article, double amount, String notes) throws ModelException{
        this(account, article, amount, notes, new Date());
    }

    public Transaction(Account account, Article article, double amount, Date date) throws ModelException{
        this(account, article, amount, "", date);
    }

    public Transaction(Account account, Article article, double amount) throws ModelException{
        this(account, article, amount, "", new Date());
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "account=" + account +
                ", article=" + article +
                ", amount=" + amount +
                ", notes='" + notes + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public void postAdd(SaveData sd){
        setAmounts(sd);
    }

    @Override
    public void postEdit(SaveData sd){
        setAmounts(sd);
    }

    @Override
    public void postDelete(SaveData sd){
        setAmounts(sd);
    }

    private void setAmounts(SaveData sd){
        for (Account a : sd.getAccounts())
            a.setAmountForTransactionAndTransfers(sd.getTransactions(), sd.getTransfers());
    }

}
