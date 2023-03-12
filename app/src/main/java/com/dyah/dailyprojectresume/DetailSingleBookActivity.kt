package com.dyah.dailyprojectresume

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dyah.dailyprojectresume.databinding.ActivityDetailSingleBookBinding
import com.dyah.dailyprojectresume.model.SingleBookModel

class DetailSingleBookActivity  : AppCompatActivity() {
    private lateinit var binding: ActivityDetailSingleBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityDetailSingleBookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setDataToViewDetail()
    }

    //membuat kunci pada setiap page

    private fun setDataToViewDetail(){
        val data = intent.getParcelableExtra<SingleBookModel>(DATA_CATEGORY)
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
        private const val DATA_CATEGORY = "dataCategory"
        fun navigateToActivityDetailCategory(
            activity: Activity, dataCategory: SingleBookModel
        ) = Intent().apply { //scoping function, lamda mengembalikan objek
            //tidak usah pake intent.putextra
//            putExtra(DATA_NEWS, dataNews ) //key
            val intent = Intent(activity, DetailSingleBookActivity::class.java)
            intent.putExtra(DATA_CATEGORY,dataCategory)
            activity.startActivity(intent)
        }
    }
}