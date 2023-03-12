package com.dyah.dailyprojectresume.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dyah.dailyprojectresume.databinding.ItemBookBinding
import com.dyah.dailyprojectresume.model.SeriesModel


class HomeMainAdapter(

    private val dataNews: List<SeriesModel>,
    private val onClickNews : (SeriesModel) -> Unit  //untuk ambil details

//    mengembalikan suatu hal atau tidak = lamda

) : RecyclerView.Adapter<HomeMainAdapter.HomeViewHolder>() {
    inner class HomeViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bindView(data: SeriesModel, onClickNews: (SeriesModel) -> Unit){
            binding.ivCover.setImageResource( data.coverSingleBook?:0)
            binding.tvTitleCard.text = data.title
            binding.tvDescCard.text = data.synopsis
            binding.lvBook.setOnClickListener{
                onClickNews(data) //kalau data diserver ga ada dikasih default apa
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
        HomeViewHolder(
           ItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindView(dataNews[position],onClickNews) //slot keseluruhan tangga, jd array harus ada object

    }

    override fun getItemCount(): Int = dataNews.size


}