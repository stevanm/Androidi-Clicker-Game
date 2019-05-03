package rs.pparadigme.matf.funnyclicker.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.upgrades_fragment.*
import rs.pparadigme.matf.funnyclicker.R
import rs.pparadigme.matf.funnyclicker.foodAm
import rs.pparadigme.matf.funnyclicker.foodPerSec

class UpgradesFragment : Fragment(){
    val TAG = "UpgradesFragment"

    override fun onAttach(context: Context?) {
        Log.d(TAG, "onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }

    fun onWheelClick(){
        textUpgradeCostAm.setText("30 food")
        textUpgradeInfo.setText("This upgrade provide 1 food per second")
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        return inflater!!.inflate(R.layout.upgrades_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(TAG, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()

        imageButtonWheel.setOnClickListener {
            onWheelClick()
        }

        buttonBuyUpgrade.setOnClickListener {
            if (foodAm > 30){
                foodAm -= 30
                foodPerSec++
            }
            else{
            }
        }
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
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