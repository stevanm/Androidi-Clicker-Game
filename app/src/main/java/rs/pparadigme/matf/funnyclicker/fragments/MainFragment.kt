package rs.pparadigme.matf.funnyclicker.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.main_fragment.*
import rs.pparadigme.matf.funnyclicker.*
import rs.pparadigme.matf.funnyclicker.utils.AppUtils

class MainFragment : Fragment(){

    val TAG:String = this.javaClass.toString()

    var mFoodVal:TextView? = null

    override fun onAttach(context: Context?) {
        Log.d(TAG, "onAttach")
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        return inflater!!.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activity?.findViewById<TextView>(R.id.FoodVal)?.setText(""+ AppUtils.foodAm)
        activity?.findViewById<TextView>(R.id.scienceVal)?.setText(""+ AppUtils.scienceAm)

        /* TODO: Add onClick playgame logics */
        foodPlus.setOnClickListener(View.OnClickListener {
            if(AppUtils.villagers + AppUtils.miners + AppUtils.scientists < AppUtils.peopleAm){
                AppUtils.villagers++
                Toast.makeText(context, "You have assigned one man to produce food", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "There are no idle people", Toast.LENGTH_SHORT).show()
            }
        })

        foodMinus.setOnClickListener(View.OnClickListener {
            if(AppUtils.villagers > 0){
                AppUtils.villagers--;
                Toast.makeText(context, "One villager became idle", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "There are no villagers", Toast.LENGTH_SHORT).show()
            }
        })

        sciencePlus.setOnClickListener(View.OnClickListener {
            if(AppUtils.villagers + AppUtils.miners + AppUtils.scientists < AppUtils.peopleAm){
                AppUtils.scientists++
                Toast.makeText(context, "You have assigned one man to produce science", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "There are no idle people", Toast.LENGTH_SHORT).show()
            }})

        scienceMinus.setOnClickListener(View.OnClickListener {
            if(AppUtils.scientists > 0){
                AppUtils.scientists--;
                Toast.makeText(context, "One scientist became idle", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "There are no scientists", Toast.LENGTH_SHORT).show()
            }
        })

        resourcePlus.setOnClickListener(View.OnClickListener {
            if(AppUtils.villagers + AppUtils.miners + AppUtils.scientists < AppUtils.peopleAm){
                AppUtils.miners++
                Toast.makeText(context, "You have assigned one man to produce gold", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "There are no idle people", Toast.LENGTH_SHORT).show()
            }
        })

        resourceMinus.setOnClickListener(View.OnClickListener {
            if(AppUtils.miners > 0){
                AppUtils.miners--;
                Toast.makeText(context, "One miner became idle", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "There are no miners", Toast.LENGTH_SHORT).show()
            }
        })

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(TAG, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()

        makeFood.setOnClickListener {
            if (AppUtils.foodAm + AppUtils.foodCl <= AppUtils.foodCap){
                AppUtils.foodAm += AppUtils.foodCl
            }
            else {
                AppUtils.foodAm = AppUtils.foodCap
            }

            Toast.makeText(activity, "+1 click", Toast.LENGTH_SHORT).show()
        }
        makeScience.setOnClickListener {
            AppUtils.scienceAm += AppUtils.scienceCl
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