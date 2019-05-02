package rs.pparadigme.matf.funnyclicker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.os.HandlerCompat.postDelayed
import kotlinx.android.synthetic.main.main_fragment.*

class MainActivity : AppCompatActivity() {
    enum class Fragments {
        MAIN, SCIENCE, UPGRADES, RESOURCES
    }
    var FragmentLoaded = Fragments.MAIN
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mApp = MyApplication()

        ShowMainFragment()

        mainButton.setOnClickListener {
            onClickMain()
        }
        resourcesButton.setOnClickListener {
            onClickResources()
        }
        scienceButton.setOnClickListener {
            onClickScience()
        }
        upgradeButton.setOnClickListener {
            onClickUpgrades()
        }

        val handler = Handler()
        val delay = 1000 //milliseconds

        handler.postDelayed(object : Runnable {
            override fun run() {
                globalCounter++
                handler.postDelayed(this, delay.toLong())
                textView2.setText("Ticks: " + globalCounter)
                stringTest = stringTest +globalCounter
                Calculate()
                scienceString =" Science:"+ ((scienceAm * 1000).toInt())/1000.0
                foodString = " Food:"+ foodAm +"/"+ foodCap
                peopleString = "People:" + peopleAm +"/"+ peopleCap
                Statistic.setText( peopleString + foodString + scienceString)

                //Somehow these aren't updated on the MainFragment
                ScienceVal.setText(scienceString)
                FoodVal.setText(""+ foodAm+"/"+ foodCap)
            }
        }, delay.toLong())
    }
    fun Calculate(){
        if (foodAm + foodPerSec <= foodCap) {
            foodAm += foodPerSec
        }
        else {
            foodAm = foodCap
        }

    }
    fun ShowMainFragment (){
        val transaction = manager.beginTransaction()
        val fragment = MainFragment()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        FragmentLoaded = Fragments.MAIN
    }
    fun ShowScienceFragment (){
        val transaction = manager.beginTransaction()
        val fragment = Science()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        FragmentLoaded = Fragments.SCIENCE
    }
    fun ShowResourcesFragment (){
        val transaction = manager.beginTransaction()
        val fragment = Resources()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        FragmentLoaded = Fragments.RESOURCES
    }
    fun ShowUpgradesFragment (){
        val transaction = manager.beginTransaction()
        val fragment = Upgrades()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        FragmentLoaded = Fragments.UPGRADES
    }
    fun onClickMain()
    {
        if(FragmentLoaded != Fragments.MAIN)
            ShowMainFragment()
        Toast.makeText(this@MainActivity, "+1 click", Toast.LENGTH_SHORT).show()
    }
    fun onClickUpgrades()
    {
        if(FragmentLoaded != Fragments.UPGRADES)
            ShowUpgradesFragment()
        Toast.makeText(this@MainActivity, "+1 click", Toast.LENGTH_SHORT).show()
    }
    fun onClickScience()
    {
        if(FragmentLoaded != Fragments.SCIENCE)
            ShowScienceFragment()
        Toast.makeText(this@MainActivity, "+1 click", Toast.LENGTH_SHORT).show()
    }
    fun onClickResources()
    {
        if(FragmentLoaded != Fragments.RESOURCES)
            ShowResourcesFragment()
        Toast.makeText(this@MainActivity, "+1 click", Toast.LENGTH_SHORT).show()
    }

    fun onClickMe()
    {
        Toast.makeText(this@MainActivity, "+1 click", Toast.LENGTH_SHORT).show()
        globalCounter++

    }

    var stringTest = "asd"
    var globalCounter = 0
}

