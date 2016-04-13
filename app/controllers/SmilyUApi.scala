package controllers

import services.SmilyUServices
import models.SmilyU

import java.io.File
import play.Logger
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._

/**
 * Controller for smilyU getting
 *
 */
class SmilyUApi extends Controller {
    
    implicit val smilyUToJson = new Writes[SmilyU] {
        def writes(u: SmilyU) = Json.obj(
            "id"    -> u.id, 
            "login" -> u.username
        )
    }

    /** 
     * Retieve all cats! 
     */
    def list = WithCors("GET") { 
        Action {
            Ok(Json.obj(
                "status" -> "success",
                "data" -> SmilyUServices.users
            ))
        }
    }
    
    /** 
     * Retieve a random user! 
     */
    def getRandomSmilyU = WithCors("GET") { 
        Action {
            Ok(Json.obj(
                "status" -> "success",
                "data" -> SmilyUServices.randomSmilyDestination
            ))
        }
    }
    
    /**
     * Receives a face and stores it
     */
    def postFace = Action(parse.multipartFormData) { request =>
        request.body.file("picture").map { 
            picture =>
            
            // Retrieve photo file
            import java.io.File
            val filename = picture.filename
            val contentType = picture.contentType
            val file = new File(s"/tmp/$filename")
            // Place photo in good place 
            picture.ref.moveTo(file)
                                          
            Ok.sendFile(file)
        }.getOrElse {
            Redirect(controllers.routes.Api.index)
        }
    }
    
    def getFace = WithCors("GET") { 
        Action {
            val file = new File("/tmp/photo-1433155327100-12aac6a14ff1.jpeg")
            
            //NEED TO GET A RANDOM ONE
            
            Ok.sendFile(file)
        }
    
    }
}