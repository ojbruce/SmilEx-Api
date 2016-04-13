package services

import models.SmilyU

import play.Logger
import play.api.Play.{configuration, current}
import scala.util.Random


/**
 * Services that does operation on users
 * 
 * Gothat
*/
object SmilyUServices {
    
    lazy val users = createUsers()

    
    /**
     * Method creating users
     *
     * @return (Array(SmilyU))
     */
    def createUsers(): Array[SmilyU] = {
      Logger.info("[UserService] Fetching users...")

      val users = Array(new SmilyU("1","pedro"), new SmilyU("2","carlito"),new SmilyU("3","cochella"),new SmilyU("4","gabriella"))

      Logger.info("[UserService] Users fetched!")

      users
    }
    
    /**
     * Method returning a random user
     *
     * @return (SmilyU)
     */
    def randomSmilyDestination(): SmilyU = {

        val r   = scala.util.Random
        val nbU = users.length
        
        val user = users(r.nextInt(nbU))

         user
    }
    
}