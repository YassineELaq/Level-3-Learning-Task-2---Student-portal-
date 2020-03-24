package com.example.level_3_learning_task_2_student_portalapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_website.view.*

class WebsiteAdapter(private val websites: List<Website>, val clickListener: (Website) -> Unit) : RecyclerView.Adapter<WebsiteAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(website: Website, clickListener: (Website) -> Unit) {
            itemView.tvWebsite.text = website.websiteTitel + "\n"+website.websiteURL
            itemView.setOnClickListener { clickListener(website)}

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_website, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return websites.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.bind(websites[position])
        (holder as ViewHolder).bind(websites[position], clickListener)

    }

}
