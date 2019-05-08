package rs.pparadigme.matf.funnyclicker.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.science_fragment.*
import rs.pparadigme.matf.funnyclicker.R
import rs.pparadigme.matf.funnyclicker.utils.AppUtils
import rs.pparadigme.matf.funnyclicker.utils.Item

class ScienceFragment : Fragment(){

    val TAG:String = this.javaClass.toString()
    var selected = -1

    override fun onAttach(context: Context?) {
        Log.d(TAG, "onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        return inflater!!.inflate(R.layout.science_fragment, container, false)
    }

    fun updateView(){
        if(AppUtils.scienceResearched[0] > 0) {
            fireLeft.setImageResource(R.drawable.ic_green_left)
            fireRight.setImageResource(R.drawable.ic_green_right)
        }
        if(AppUtils.scienceResearched[1] > 0) {
            potteryLeft.setImageResource(R.drawable.ic_green_left)
        }
        if(AppUtils.scienceResearched[2] > 0) {
            wheelLeft.setImageResource(R.drawable.ic_green_left)
            wheelRight.setImageResource(R.drawable.ic_green_right)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated")
        var itemsList = ArrayList<Item>()
        itemsList.add(Item("Fire", 5, "Fire is very important.", AppUtils.scienceResearched[0]))
        itemsList.add(Item("Pottery", 25, "Enables storing more food.", AppUtils.scienceResearched[1]))
        itemsList.add(Item("Wheel", 30, "Wheel is the first step toward civilization.", AppUtils.scienceResearched[2]))
        itemsList.add(Item("Cultivation", 80, "Villagers produce more food.", AppUtils.scienceResearched[3]))
        itemsList.add(Item("Housing", 100, "Simple houses to increase population.", AppUtils.scienceResearched[4]))
        itemsList.add(Item("Tools", 120, "Enables various upgrades.", AppUtils.scienceResearched[5]))
        var selected = -1

        buttonBuyScience.setOnClickListener {
            if(selected > -1) {
                if (itemsList[selected].bought!! > 0) {
                    Toast.makeText(activity!!.applicationContext, "Already researched", Toast.LENGTH_SHORT).show()
                } else if (AppUtils.scienceAm >= itemsList[selected].image!!) {
                    itemsList[selected].bought = 1
                    AppUtils.scienceResearched[selected] = 1
                    AppUtils.scienceAm -= itemsList[selected].image!!
                    updateView()
                    Toast.makeText(
                        activity!!.applicationContext,
                        "Well done! You researched: " + itemsList[selected].name,
                        Toast.LENGTH_SHORT
                    ).show()
                    if (selected == 3) {
                        AppUtils.villagersEff = 2.0
                    }
                } else {
                    Toast.makeText(
                        activity!!.applicationContext,
                        "Not enough science for this research",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        fireSc0.setOnClickListener {
            selected = 0
            researchInfo.setText("Cost: " + itemsList[selected].image + ";  " + itemsList[selected].info)
            Toast.makeText(activity!!.applicationContext, itemsList[selected].name, Toast.LENGTH_SHORT).show()
        }

        potterySc1.setOnClickListener {
            selected = 1
            researchInfo.setText("Cost: " + itemsList[selected].image + ";  " + itemsList[selected].info)
            Toast.makeText(activity!!.applicationContext, itemsList[selected].name, Toast.LENGTH_SHORT).show()
        }

        wheelSc2.setOnClickListener {
            selected = 2
            researchInfo.setText("Cost: " + itemsList[selected].image + ";  " + itemsList[selected].info)
            Toast.makeText(activity!!.applicationContext, itemsList[selected].name, Toast.LENGTH_SHORT).show()
        }

        cultivationSc3.setOnClickListener {
            selected = 3
            researchInfo.setText("Cost: " + itemsList[selected].image + ";  " + itemsList[selected].info)
            Toast.makeText(activity!!.applicationContext, itemsList[selected].name, Toast.LENGTH_SHORT).show()
        }

        houseSc4.setOnClickListener {
            selected = 4
            researchInfo.setText("Cost: " + itemsList[selected].image + ";  " + itemsList[selected].info)
            Toast.makeText(activity!!.applicationContext, itemsList[selected].name, Toast.LENGTH_SHORT).show()
        }

        toolsSc5.setOnClickListener {
            selected = 5
            researchInfo.setText("Cost: " + itemsList[selected].image + ";  " + itemsList[selected].info)
            Toast.makeText(activity!!.applicationContext, itemsList[selected].name, Toast.LENGTH_SHORT).show()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(TAG, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        updateView()
        super.onStart()

    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        updateView()
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }


    override fun onDetach() {
        Log.d(TAG, "onDetach")
        super.onDetach()
    }
}