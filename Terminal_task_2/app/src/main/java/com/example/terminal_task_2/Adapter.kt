package com.example.terminal_task_2

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
internal class Adapter (private var List: List<Model>) :
    RecyclerView.Adapter<Adapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>("R.id.button")
        var title: TextView = view.findViewById(R.id.title)
        var product: TextView = view.findViewById(R.id.product)
        var quantity: TextView = view.findViewById(R.id.quantity)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = List[position]
        holder.title.text = movie.getTitle()
        holder.product.text = movie.getProduct()
        holder.quantity.text = movie.getQuantity()
        holder.button.setOnClickListener{

            val smsUri = Uri.parse("tel:123")
            val intent = Intent(Intent.ACTION_VIEW, smsUri)
            intent.putExtra("address", 123)
            intent.putExtra("sms_body", "message")
            intent.type = "vnd.android-dir/mms-sms" // here setType will set the previous data to null.
                startActivity(intent)

            }
        }
    }
    override fun getItemCount(): Int {
        return List.size
    }
}