package com.example.nasawalebhaiya.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nasawalebhaiya.R
import com.example.nasawalebhaiya.models.Photos
import com.example.nasawalebhaiya.models.RecyclerData

import com.squareup.picasso.Picasso

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    var items = ArrayList<Photos>()
    fun setUpdateData(items: ArrayList<Photos>){
        this.items =items
        notifyDataSetChanged()
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageThumb = view.findViewById<ImageView>(R.id.imagethumb)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvDesc = view.findViewById<TextView>(R.id.tvDesc)
        fun bind(data: Photos){
            tvTitle.text = data.rover.name
            tvDesc.text = data.camera.full_name

            val url  = data.img_src

            Picasso.get().load(url).into(imageThumb)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}