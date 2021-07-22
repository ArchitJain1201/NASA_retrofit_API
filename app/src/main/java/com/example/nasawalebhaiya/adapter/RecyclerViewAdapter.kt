package com.example.nasawalebhaiya.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nasawalebhaiya.R
import com.example.nasawalebhaiya.models.RecyclerData
import com.example.nasawalebhaiya.models.RecyclerList
import com.squareup.picasso.Picasso

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    var items = ArrayList<RecyclerData>()
    fun setUpdateData(items: ArrayList<RecyclerData>){
        this.items =items
        notifyDataSetChanged()
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageThumb = view.findViewById<ImageView>(R.id.imagethumb)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvDesc = view.findViewById<TextView>(R.id.tvDesc)
        fun bind(data: RecyclerData){
            tvTitle.text = data.photo.camera.full_name
            tvDesc.text = data.photo.rover.name

            val url  = data.photo.img_src

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