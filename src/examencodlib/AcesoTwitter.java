/*
 * timeLine() --> Mostrar la linea de tiempo
 * buscar() --> Buscar los twitter que contengan una 'string' introducida
 * tweet() --> Twittear
 */
package examencodlib;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author @FranJAbrilA <ffrannabril@gmail.com>
 */
public class AcesoTwitter {

// Se crea el objeto cb (Constructor de configuración)
    ConfigurationBuilder cb = new ConfigurationBuilder();
    Twitter twitter;

    /**
     * Constructor, da acceso a nuestra cuenta en twitter.
     */ 
    public AcesoTwitter() {
        /*
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("NkvozDqjKCytO9gasFi2CClHP")
                .setOAuthConsumerSecret("i4K8l4aw3gWJwKU7unAg8flYQ1trf4gLIytbuh8ys4wVSDpeV6")
                .setOAuthAccessToken("3055204857-FWSLAe2lGRONftA76dlLYVJ06WnK5XulciQigYq")
                .setOAuthAccessTokenSecret("LTS4udyKZWJvTE3vIUgdag6QxH9AfPWziyoFQosKNAbIq");
        twitter = new TwitterFactory(cb.build()).getInstance();*/
    }
    
    /**
     * Mostrar la linea de tiempo.
     */
    public void timeLine() {

        try {
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing home timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText());
            }
        } catch (TwitterException ex) {
            Logger.getLogger(AcesoTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Buscar los twitter que contengan una 'string' introducida.
     */
    public void search() {

        try {
            String preg = JOptionPane.showInputDialog("Buscar:");
            Query query = new Query(preg);
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }
        } catch (TwitterException ex) {
            Logger.getLogger(AcesoTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * postear un tweet desede nuestra aplicación.
     */
    public void tweet() {

        try {
            String twet = JOptionPane.showInputDialog("Tweett:");
            Status status = twitter.updateStatus(twet);
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
        } catch (TwitterException ex) {
            Logger.getLogger(AcesoTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
