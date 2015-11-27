/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;


import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.CompoundPropertyModel;
import grailswicketdemo.Category
import grailswicketdemo.CategoryService
import grailswicketdemo.CategoryServiceInterface
import org.apache.wicket.spring.injection.annot.SpringBean


public class CategoriesPage extends AdminPage {


    @SpringBean(name="categoryService")
    CategoryServiceInterface categoryService
    //replaces "CategoryService categoryService = new CategoryService()"

    public CategoriesPage() {


       final RepeatingView repeating = new RepeatingView("repeating");
        add(repeating);


        for (final Category category : categoryService.findAll()) {
            WebMarkupContainer item = new WebMarkupContainer(repeating.newChildId());

            item.add(new CategoriesForm("categoriesForm", category, false).setOutputMarkupId(true));
            repeating.add(item);
        }




        Link newCategoryLink = new Link("newCategoryLink"){

            public void onClick(){
                WebMarkupContainer item = new WebMarkupContainer(repeating.newChildId());

                item.add(new CategoriesForm("categoriesForm", new Category(), true).setOutputMarkupId(true));
                repeating.add(item);
            }
        }
        add(newCategoryLink);



    }

}


    public class CategoriesForm extends Form {
         
        @SpringBean(name="categoryService")
        final CategoryServiceInterface categoryService

        public CategoriesForm(String id, final Category category, final boolean create) {
            super(id, new CompoundPropertyModel(category));

              

            final TextField firstLevel = new TextField("firstLevel");
            firstLevel.setOutputMarkupId(true);
            add(firstLevel);

            final TextField secondLevel = new TextField("secondLevel");
            secondLevel.setOutputMarkupId(true);
            add(secondLevel);

            final TextField thirdLevel = new TextField("thirdLevel");
            thirdLevel.setOutputMarkupId(true);
            add(thirdLevel);

          

            AjaxSubmitLink submitLink = new AjaxSubmitLink("submitLink") {
                @SpringBean(name="categoryService")
                CategoryServiceInterface categoryService

                @Override
                protected void onSubmit(AjaxRequestTarget target, Form form) {

                    target.addComponent(firstLevel);
                    target.addComponent(secondLevel);
                    target.addComponent(thirdLevel);

                    target.addComponent(this);

                    if(create){
                        categoryService.save(category)
                    } else{
                        categoryService.save(category)
                    }
                    setResponsePage(CategoriesPage.class);
                }

                @Override
                protected void onError(AjaxRequestTarget target, Form form) {
                }
            };


            submitLink.setOutputMarkupId(true);
            add(submitLink);



        }
    }