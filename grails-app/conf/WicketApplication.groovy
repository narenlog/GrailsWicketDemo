import org.apache.wicket.protocol.http.WebApplication;

import grails.util.*
import org.apache.wicket.Application
import home.HomePage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector
import org.apache.wicket.RuntimeConfigurationType;

//import home.HomePage
/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 *
 * @see wicket.myproject.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{

    public void init() {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));

    }
    /**
	 * @see wicket.Application#getHomePage()
	 */

	Class getHomePage() { HomePage.class }


    /**
     * If we're running in Grails development environment use Wicket development environment
     */
    public RuntimeConfigurationType getConfigurationType() {
        if(GrailsUtil.isDevelopmentEnv()) {
            return RuntimeConfigurationType.DEVELOPMENT
        }
        return RuntimeConfigurationType.DEPLOYMENT
    }




}