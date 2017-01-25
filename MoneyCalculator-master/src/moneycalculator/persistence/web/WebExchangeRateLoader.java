package moneycalculator.persistence.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.persistence.ExchangeRateLoader;

public class WebExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Currency from, Currency to) {
       
       
        
        /*THE CODE BELOW WORKS, BUT RETURN -3 BECAUSE TO IMPLEMENT IN OUR PROGRAM WE NEED TO PAY. IT'S A SUBSCRIPTION PAYAMENT API.
        
        try {
URL convert = new URL("https://www.exchangerate-api.com/usd/gbp/12.50?k=API_KEY");
BufferedReader in = new BufferedReader(new InputStreamReader(convert.openStream()));
String answer = in.readLine();
in.close();
}
catch (MalformedURLException mue) {
System.exit(1);
}	 
catch (IOException ioe) {
System.exit(1);
}
        
        */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
    
    }
    

