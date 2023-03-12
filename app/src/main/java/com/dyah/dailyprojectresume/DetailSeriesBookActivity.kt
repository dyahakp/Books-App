package com.dyah.dailyprojectresume

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dyah.dailyprojectresume.databinding.ActivityDetailSeriesBookBinding
import com.dyah.dailyprojectresume.model.SeriesModel

class DetailSeriesBookActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDetailSeriesBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSeriesBookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setDataToViewDetail()
    }

    //membuat kunci pada setiap page

    private fun setDataToViewDetail(){
        val data = intent.getParcelableExtra<SeriesModel>(DATA_NEWS)
        binding.ivCover.setImageResource(data?.coverSingleBook?:0)
        binding.tvTitle.text = data?.title
        binding.tvAuthor.text = data?.author
        binding.tvGenre.text = data?.genre
        binding.tvPrice.text = data?.price
        binding.tvRating.text = data?.rating
        binding.tvSynopsisDesc.text = data?.synopsis
        binding.includeAppbar.ivArrow.setOnClickListener{
            onBackPressed()

        }

    }


    companion object {
        //kuncinya untuk page ini aja
        private const val DATA_NEWS = "dataNews"
        fun navigateToActivityDetail(
            activity: Activity, datanews: SeriesModel) = Intent().apply { //scoping function, lamda mengembalikan objek
            //tidak usah pake intent.putextra
//            putExtra(DATA_NEWS, dataNews ) //key
            val intent = Intent(activity, DetailSeriesBookActivity::class.java)
            intent.putExtra(DATA_NEWS,datanews)
            activity.startActivity(intent)
        }
    }
}