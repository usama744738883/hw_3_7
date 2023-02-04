package com.example.homework7_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework7_3.databinding.ItemListBinding

class RmAdapter(val RmList: List<Rm>, val onClick: (rm: Rm) -> Unit) :
    RecyclerView.Adapter<RmAdapter.RmViewHolder>() {

    inner class RmViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = RmList[adapterPosition]

            binding.apply {
                tvLife.text = item.life
                tvName.text = item.name
                imgPicture.setImageResource(item.picture)
            }
            itemView.setOnClickListener {
                onClick.invoke(item)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RmViewHolder {
        return RmViewHolder(
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RmViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return RmList.size
    }
}


