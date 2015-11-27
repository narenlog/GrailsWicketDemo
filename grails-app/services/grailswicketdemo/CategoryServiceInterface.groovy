/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package grailswicketdemo


interface CategoryServiceInterface {
    def getCount()
         
    def findAll()

    def save(Category category)
}

