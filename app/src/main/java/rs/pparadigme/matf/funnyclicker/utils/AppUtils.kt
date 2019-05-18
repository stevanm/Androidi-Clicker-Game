package rs.pparadigme.matf.funnyclicker.utils

import java.util.*

/* Singleton class shared between all objects */

object AppUtils {

    var foodAm:Int = 0
    var foodCap:Int = 50
    var foodString:String = ""
    var foodPerSec:Int = 0

    var scienceAm = 0
    var scienceString:String = ""
    var sciencePerSec = 0

    var peopleAm:Int = 0
    var peopleCap:Int = 50
    var peopleString:String = ""
    var villagers = 0
    var scientists = 0
    var miners = 0
    var gold = 0

    var villagersEff = 1.0
    var scientistsEff = 1.0
    var minersEff = 1.0

    var foodCl:Int = 1
    var scienceCl = 1

    var costCoef = 1.5
    var goldGoal = 100
    var globalCounter:Int = 0

    var upgradeCosts = ArrayList<Int>()
    var scienceResearched = ArrayList<Int>(Collections.nCopies(8, 0))
    /* resart all app data */
    fun restartAppData(){
        if(gold > goldGoal){
            if(costCoef > 1.3) {
                costCoef -= 0.05
                goldGoal *= 3
            }
            else {
                goldGoal = goldGoal + goldGoal / 2
                costCoef -=0.005
            }
        }

        foodAm = 0
        foodCap = 50
        foodString = ""
        foodPerSec = 0

        scienceAm = 0
        scienceString = ""

        peopleAm = 0
        peopleCap = 50
        peopleString = ""
        villagers = 0
        scientists = 0
        miners = 0
        gold = 0

        villagersEff = 1.0
        scientistsEff = 1.0
        minersEff = 1.0

        foodCl = 1
        scienceCl = 1
        sciencePerSec = 0

        globalCounter = 0

        upgradeCosts = ArrayList<Int>()
        upgradeCosts.add(5)
        upgradeCosts.add(5)
        upgradeCosts.add(5)
        upgradeCosts.add(5)
        upgradeCosts.add(5)
        upgradeCosts.add(100)
        upgradeCosts.add(1000)
        upgradeCosts.add(2000)

        scienceResearched = ArrayList<Int>(   Collections.nCopies(8,0))
    }

}
