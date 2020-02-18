package com.example.android_basic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_integer.view.*

class DataAdapter(val list: List<Int>): RecyclerView.Adapter<DataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_integer, parent, false)
        view.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val id: Any? = v?.tag
                if(selectionList.contains(id)) selectionList.remove(id)
                else selectionList.add(id as Long)
                notifyDataSetChanged()
                onItemSelectionChangedListener?.let { it(selectionList) }
            }

        })
        return DataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.containerView.integerText.text = list[position].toString()
        holder.containerView.tag = getItemId(position)
        holder.containerView.isActivated = selectionList.contains(getItemId(position))
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    val selectionList = mutableListOf<Long>()
    var onItemSelectionChangedListener: ((MutableList<Long>)->Unit)? = null

}