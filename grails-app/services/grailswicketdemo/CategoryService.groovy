package grailswicketdemo

class CategoryService implements CategoryServiceInterface {

    static transactional = true

   def getCount() {

        return Category.count().toString()
    }

    def findAll(){
        return Category.findAll()
    }
  
    //TODO : If and when the Wicket plugin in updated in the future see if you can get this service injected into Wicket
    //http://grails.org/Services : Warning: dependency injection is the only way that declarative transactions work. You will not get a transactional service if you use the new operator such as new BookService()
    //http://grails.1312388.n4.nabble.com/Wicket-and-Spring-dependency-injection-td1364002.html
    def save(Category category){
        //Category.withTransaction(){
            category.save()
        //}
    }
}
