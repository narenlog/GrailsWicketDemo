/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;


public class BaseWebPage extends WebPage {

    public BaseWebPage(){
        add(new FeedbackPanel("feedbackPanel"));
    }

}
