
package home
import admin.AdminPage;
import common.BaseWebPage
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.util.value.ValueMap
import org.apache.wicket.model.PropertyModel
import org.apache.wicket.markup.html.form.TextField
import admin.CategoriesPage
import org.apache.wicket.request.mapper.parameter.PageParameters
/**
 * Homepage
 */
public class HomePage extends BaseWebPage {

     public HomePage(final PageParameters parameters) {

        add(new LoginForm("loginForm"));
    }
  
}

  public class LoginForm extends Form{

        ValueMap properties = new ValueMap();
        public LoginForm(String id){
            super(id);

            TextField passwordField = new TextField("password", new PropertyModel(properties,"password"));
            add(passwordField);
        }

        @Override
        public void onSubmit(){
            String passwordText = properties.getString("password");
            System.out.println("PASSWORD TEXT ENTERED: " + passwordText);
            if(passwordText != null && passwordText.equalsIgnoreCase("testing")){
                   setResponsePage(CategoriesPage.class);
            } else{
               error("BOING!");
            }
        }
    }