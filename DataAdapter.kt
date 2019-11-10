package com.modos.persianflix

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class DataAdapter (private var dataList: List<DataModel>, private val context: Context): RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: DataAdapter.ViewHolder, position: Int) {
        val dataModel = dataList.get(position)

        holder.titleTextView.text = dataModel.name

        Picasso.get()
            .load(dataModel.photo)
            .placeholder(R.color.colorPrimary)
            .error(R.color.colorAccent)
            .fit()
            .into(holder.photo)

        Log.d("photo", holder.photo.toString())

        holder.photo.setOnClickListener{
            val intent:Intent = Intent(context, DetailsActivity::class.java)
            val bundle = Bundle()
            val parcel = ParcelableObject(dataModel.name, dataModel.photo, dataModel.bio)

            bundle.putParcelable("key", parcel)
            intent.putExtra("bundle", bundle)
            context.startActivity(intent)
        }

    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView){
         var titleTextView: TextView
         var photo: ImageView

        init {
            titleTextView = itemLayoutView.findViewById(R.id.text)
            photo = itemLayoutView.findViewById(R.id.photo)

        }
    }
}