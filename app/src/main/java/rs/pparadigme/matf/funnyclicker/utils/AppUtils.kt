package rs.pparadigme.matf.funnyclicker.utils

/* Singleton class shared between all objects */

object AppUtils {

    var foodAm:Int = 0
    var foodCap:Int = 50
    var foodString:String = ""
    var foodPerSec:Int = 0

    var scienceAm: Float = 0.0F
    var scienceString:String = ""

    var peopleAm:Int = 0
    var peopleCap:Int = 50
    var peopleString:String = ""

    var foodCl:Int = 1
    var scienceCl: Float = 0.1F

    var globalCounter:Int = 0

    /* resart all app data */
    fun restartAppData(){

        foodAm = 0
        foodCap = 50
        foodString = ""
        foodPerSec = 0

        scienceAm = 0.0F
        scienceString = ""

        peopleAm = 0
        peopleCap = 50
        peopleString = ""

        foodCl = 1
        scienceCl = 0.1F

        globalCounter = 0

    }

}
