package models


/** A Smily User
  *
  * @param id       User identifier
  * @param login    User's login
  */
class SmilyU(val guid: String, val uName: String){
    var id : String = guid
    var username : String = uName
}