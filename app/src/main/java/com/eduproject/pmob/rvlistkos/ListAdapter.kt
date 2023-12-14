package com.eduproject.pmob.rvlistkos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eduproject.pmob.data.entity.MainEntity
import com.eduproject.pmob.databinding.ItemlistBinding

class ListAdapter(
    private val list: List<MainEntity>,
    private val onItemClick: (MainEntity) ->Unit
): RecyclerView.Adapter<ListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
       return ListViewHolder(
           ItemlistBinding.inflate(
               LayoutInflater.from(parent.context), parent, false
           ),
           onItemClick
       )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = list[position]

        holder.bind(data)
    }
}