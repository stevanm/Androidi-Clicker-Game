package rs.pparadigme.matf.funnyclicker.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.photo_item.view.*
import rs.pparadigme.matf.funnyclicker.R
import rs.pparadigme.matf.funnyclicker.utils.Item


class ItemAdapter : BaseAdapter {

    val TAG:String = this.javaClass.toString()

    var itemsList = ArrayList<Item>()
    var context: Context? = null

    constructor(context: Context, itemsList: ArrayList<Item>) : super() {
        this.context = context
        this.itemsList = itemsList
    }

    override fun getCount(): Int {
        return itemsList.size
    }

    override fun getItem(position: Int): Any {
        return itemsList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = this.itemsList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var itemView = inflator.inflate(R.layout.photo_item, null)

        itemView.itemImage.setImageResource(item.image!!)
        itemView.itemName.text = item.name!!

        return itemView
    }
}