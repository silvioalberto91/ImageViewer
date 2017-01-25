package moneycalculator;

import moneycalculator.control.CalculateCommand;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.persistence.web.WebExchangeRateLoader;

public class Main {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        ExchangeRateLoader loader = new WebExchangeRateLoader();
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), loader));
    }
}
