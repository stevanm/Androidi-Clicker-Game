package rs.pparadigme.matf.funnyclicker.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView
import rs.pparadigme.matf.funnyclicker.*
import rs.pparadigme.matf.funnyclicker.fragments.MainFragment
import rs.pparadigme.matf.funnyclicker.fragments.ResourcesFragment
import rs.pparadigme.matf.funnyclicker.fragments.ScienceFragment
import rs.pparadigme.matf.funnyclicker.fragments.UpgradesFragment

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
                counter.setText("Ticks: " + globalCounter)
                stringTest = stringTest +globalCounter
                Calculate()
                //scienceString =" ScienceFragment:"+ ((scienceAm * 1000).toInt())/1000.0
                foodString = " Food: "+ foodAm +"/"+ foodCap
                peopleString = "People: " + peopleAm +"/"+ peopleCap
                //statistic.setText( peopleString + foodString + scienceString)
                statistic.setText( peopleString + foodString)

                findViewById<TextView>(R.id.FoodVal)?.setText(foodString)
                findViewById<TextView>(R.id.scienceVal)?.setText(scienceString)
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
        val fragment = ScienceFragment()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        FragmentLoaded = Fragments.SCIENCE
    }
    fun ShowResourcesFragment (){
        val transaction = manager.beginTransaction()
        val fragment = ResourcesFragment()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        FragmentLoaded = Fragments.RESOURCES
    }
    fun ShowUpgradesFragment (){
        val transaction = manager.beginTransaction()
        val fragment = UpgradesFragment()
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

