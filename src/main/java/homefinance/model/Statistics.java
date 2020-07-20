package homefinance.model;

import homefinance.saveload.SaveData;

import java.util.HashMap;
import java.util.List;

public class Statistics {
//Sum all money from all accounts
    public static double getBalanceCurrency(Currency currency){
        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for (Account account : sd.getAccounts()){
            if(currency.equals(account.getCurrency())) amount += account.getAmount();
        }
        return amount;
    }
//Converts all currencies from accounts to one currency
    public static double getBalance(Currency currency){
        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for (Account account : sd.getAccounts()){
            amount += account.getAmount() * account.getCurrency().getRateByCurrency(currency);
        }
        return amount;
    }
//Bar chart
    private static HashMap<String, Double> getDataForChartArticles(boolean income){
        List<Transaction> transactionList = SaveData.getInstance().getTransactions();
        HashMap<String, Double> data = new HashMap<>();
        for (Transaction t : transactionList){
            if ((income && t.getAmount() > 0) || (!income && t.getAmount() < 0)){
                String key = t.getArticle().getTitle();
                double sum = 0;
                double amount = t.getAmount();
                if (!income) amount *= -1;
                if (data.containsKey(key)) sum = data.get(key);
                sum += amount * t.getAccount().getCurrency().getRateByCurrency(SaveData.getInstance().getBaseCurrency());
                data.put(key, round(sum));
            }
        }
        return data;
    }

    private static double round(double value){
        return (double) Math.round(value * 100) / 100;
    }

    public static HashMap<String, Double> getDataForChartIncomeArticles() {
        return getDataForChartArticles(true);
    }

    public static HashMap<String, Double> getDataForChartExpenseArticles() {
        return getDataForChartArticles(false);
    }
}
