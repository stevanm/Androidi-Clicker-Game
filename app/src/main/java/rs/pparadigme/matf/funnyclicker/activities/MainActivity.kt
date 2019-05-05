package rs.pparadigme.matf.funnyclicker.activities

import android.content.DialogInterface
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.Gravity.getAbsoluteGravity
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.TextView
import kotlinx.android.synthetic.main.content_main.*
import rs.pparadigme.matf.funnyclicker.*
import rs.pparadigme.matf.funnyclicker.fragments.MainFragment
import rs.pparadigme.matf.funnyclicker.fragments.ResourcesFragment
import rs.pparadigme.matf.funnyclicker.fragments.ScienceFragment
import rs.pparadigme.matf.funnyclicker.fragments.UpgradesFragment
import android.view.Gravity.CENTER as CENTER

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    val TAG:String = this.javaClass.toString()

    enum class Fragments {
        MAIN, SCIENCE, UPGRADES, RESOURCES
    }

    var FragmentLoaded = Fragments.MAIN
    val manager = supportFragmentManager

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    var globalCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

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
                Calculate()
                //scienceString =" ScienceFragment:"+ ((scienceAm * 1000).toInt())/1000.0
                foodString = " Item: "+ foodAm +"/"+ foodCap
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

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_restart -> Toast.makeText(this, "Clicked item Restart Game", Toast.LENGTH_SHORT).show()
            R.id.nav_close -> finish()
            R.id.nav_about -> basicAlert()
                //Toast.makeText(this, "Clicked item About Game", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun basicAlert(){

        val builder = AlertDialog.Builder(this, R.style.AlertDialogTheme)

        with(builder) {
            setTitle("About FunnyClicker Game")
            //setMessage("Stevan Milic: stevanmilic@gmail.com\nIvan Nedic: xxx@gamil.com")
            setMessage(R.string.about_gameplay).
            setPositiveButton("OK", null)
            create()
            show()
        }


    }

}

