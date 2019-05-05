package rs.pparadigme.matf.funnyclicker.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.upgrades_fragment.*
import rs.pparadigme.matf.funnyclicker.R
import rs.pparadigme.matf.funnyclicker.adapters.ItemAdapter
import rs.pparadigme.matf.funnyclicker.utils.AppUtils
import rs.pparadigme.matf.funnyclicker.utils.Item

class UpgradesFragment : Fragment(){

    val TAG:String = this.javaClass.toString()

    var adapter: ItemAdapter? = null
    var itemsList = ArrayList<Item>()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        /* load items - images */
        itemsList.add(Item("Name 1", R.drawable.ic_wheel))
        itemsList.add(Item("Name 2", R.drawable.ic_wheel))
        itemsList.add(Item("Name 3", R.drawable.ic_wheel))
        itemsList.add(Item("Name 4", R.drawable.ic_wheel))
        itemsList.add(Item("Name 5", R.drawable.ic_wheel))

        adapter = ItemAdapter(activity!!.applicationContext, itemsList)
        gvImages.adapter = adapter

        gvImages.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(activity!!.applicationContext, "Clicked on position " + position, Toast.LENGTH_SHORT).show()
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(TAG, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()

/*
        imageButtonWheel.setOnClickListener {
            onWheelClick()
        }
*/
        buttonBuyUpgrade.setOnClickListener {
            if (AppUtils.foodAm > 30){
                AppUtils.foodAm -= 30
                AppUtils.foodPerSec++
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