package grailswicketdemo

class Category implements Serializable {


    String id
    String firstLevel
    String secondLevel
    String thirdLevel


    String toString(){
	"$firstLevel, $secondLevel, $thirdLevel"
    }

    //mapping to legacy tables
     static mapping = {
        id column:'categoryID'
        id generator: 'uuid'
        columns {
            firstLevel column:'firstLevel'
            secondLevel column:'secondLevel'
            thirdLevel column:'thirdLevel'
        }
       
    }

    static constraints = {
    }
}
