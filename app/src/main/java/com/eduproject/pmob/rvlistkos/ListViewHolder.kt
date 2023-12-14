package com.eduproject.pmob.rvlistkos

import androidx.recyclerview.widget.RecyclerView
import com.eduproject.pmob.data.entity.MainEntity
import com.eduproject.pmob.databinding.ItemlistBinding

class ListViewHolder(
    private val binding: ItemlistBinding,
    private val onItemClick: (MainEntity) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: MainEntity) {
        binding.name.text = data.name
        binding.alamat.text = data.alamat
        binding.fasilitas.text = data.fasilitas

        val resources = binding.root.context.resources
        val imageId = resources.getIdentifier(data.images, "drawable", binding.root.context.packageName)
        binding.PosterIV.setImageResource(imageId)
        binding.maps.setOnClickListener { onItemClick(data) }
    }
}