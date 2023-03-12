package com.dyah.dailyprojectresume.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dyah.dailyprojectresume.databinding.ItemSingleBookBinding
import com.dyah.dailyprojectresume.model.SingleBookModel

class SingleBookAdapter (
    private val dataCategory: List<SingleBookModel>,
    private val onClickCategory : (SingleBookModel) -> Unit
) : RecyclerView.Adapter<SingleBookAdapter.SingleBookViewHolder>() {
    inner class SingleBookViewHolder(val binding: ItemSingleBookBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun bindingData(data: SingleBookModel, onClickCategory: (SingleBookModel) -> Unit) {
            binding.ivCover.setImageResource(data.coverSingleBook?:0)
            binding.tvTitleCategory.text = data.title
            binding.tvDesc.text = data.synopsis
            binding.cvCategory.setOnClickListener{
                onClickCategory(data) //kalau data diserver ga ada dikasih default apa
            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleBookViewHolder =
        SingleBookViewHolder(
            ItemSingleBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    override fun onBindViewHolder(holder:SingleBookViewHolder, position: Int) {
        holder.bindingData(dataCategory[position], onClickCategory)
    }
    override fun getItemCount(): Int = dataCategory.size



}
