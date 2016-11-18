package kata4;

import java.util.ArrayList;

public class MailHistogramBuilder {

    public static Histogram<String> build(ArrayList<String> mails) {
        Histogram<String> histo = new Histogram<>();
        for (String mail : mails) {
            histo.increment(new Mail(mail).getDomain());
        }
        
        return histo;
    }
}
