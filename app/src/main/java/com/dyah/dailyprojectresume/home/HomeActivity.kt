package com.dyah.dailyprojectresume.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dyah.dailyprojectresume.DetailSeriesBookActivity
import com.dyah.dailyprojectresume.DetailSingleBookActivity
import com.dyah.dailyprojectresume.R
import com.dyah.dailyprojectresume.adapter.HomeMainAdapter
import com.dyah.dailyprojectresume.adapter.SingleBookAdapter
import com.dyah.dailyprojectresume.databinding.ActivityHomeFullBinding
import com.dyah.dailyprojectresume.helper.Constant
import com.dyah.dailyprojectresume.helper.PreferenceHelper
import com.dyah.dailyprojectresume.login.LoginActivity
import com.dyah.dailyprojectresume.model.SeriesModel
import com.dyah.dailyprojectresume.model.SingleBookModel
import com.dyah.dailyprojectresume.profile.ProfileActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeFullBinding
    lateinit var pref: PreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeFullBinding.inflate(layoutInflater)

//        binding.rvNews.adapter = HomeMainAdapter() //bisa ini cara ambil data
        setContentView(binding.root)
        pref = PreferenceHelper(this)

        binding.tvName.text = pref.getString(Constant.PREF_EMAIL)

        supportActionBar?.hide()
        binding.ivProfile.setOnClickListener {
            val intent = Intent (applicationContext, ProfileActivity::class.java)
            startActivity(intent)
        }
//        binding.componentAppBar.ivBack.visibility = View.GONE

        val mainAdapter = HomeMainAdapter(
            dataNews = populateData(),
            onClickNews = { dataNews ->
//                Toast.makeText(applicationContext,it.toString, Toast.LENGTH_LONG).show()//bikin object dul harus tring

               DetailSeriesBookActivity.navigateToActivityDetail(this, dataNews)
            })


        val categoryMainAdapter = SingleBookAdapter(
            dataCategory = populateDataForCategory(),
            onClickCategory = { dataCategory ->
               DetailSingleBookActivity.navigateToActivityDetailCategory(this, dataCategory)
            })

        binding.rvListHorizontal.adapter = categoryMainAdapter
        binding.rvNews.adapter = mainAdapter
    }


    private fun populateData(): List<SeriesModel> {
        //dibuat list 3
        val listData = listOf(
           SeriesModel(
               coverSingleBook = R.drawable.single1,
               title = "The Day I Left You",
               author = "Diana Ross",
               synopsis = "Lorem Ipsum is simply has been the industry's standard dummy text ever since the 1500s",
               price = "Rp.90.000",
               read = "Read By 2 People",
               rating = "4.5",
               genre = "Drama"
            ),
                   SeriesModel(
                   coverSingleBook = R.drawable.single2,
            title = "The Day I Left You",
            author = "Diana Ross",
            synopsis = "Lorem Ipsum is simply has been the industry's standard dummy text ever since the 1500s",
            price = "Rp.90.000",
            read = "Read By 2 People",
            rating = "4.5",
            genre = "Drama"
        ),
            SeriesModel(
                coverSingleBook = R.drawable.single3,
                title = "The Day I Left You",
                author = "Diana Ross",
                synopsis = "Lorem Ipsum is simply has been the industry's standard dummy text ever since the 1500s",
                price = "Rp.90.000",
                read = "Read By 2 People",
                rating = "4.5",
                genre = "Drama"
            ),
            SeriesModel(
                coverSingleBook = R.drawable.single4,
                title = "The Day I Left You",
                author = "Diana Ross",
                synopsis = "Lorem Ipsum is simply has been the industry's standard dummy text ever since the 1500s",
                price = "Rp.90.000",
                read = "Read By 2 People",
                rating = "4.5",
                genre = "Drama"
            )

        )
        //4 membutuhkan return, kalau pake api tinggal ditampilkan sesuai respon
        return listData
    }

    private fun populateDataForCategory(): List<SingleBookModel> {
        val listData = listOf(
            SingleBookModel(
                coverSingleBook = R.drawable.single1,
                title = "The Day I Left You",
                author = "Diana Ross",
                synopsis = "Lorem Ipsum is simply has been the industry's standard dummy text ever since the 1500s",
                price = "Rp.90.000",
                read = "Read By 2 People",
                rating = "4.5",
                genre = "Drama"
            ),
            SingleBookModel(
                coverSingleBook = R.drawable.single2,
                title = "The Day I Left You",
                author = "Diana Ross",
                synopsis = "Lorem Ipsum is simply has been the industry's standard dummy text ever since the 1500s",
                price = "Rp.90.000",
                read = "Read By 2 People",
                rating = "4.5",
                genre = "Drama"
            ),
            SingleBookModel(
                coverSingleBook = R.drawable.single3,
                title = "The Day I Left You",
                author = "Diana Ross",
                synopsis = "Lorem Ipsum is simply has been the industry's standard dummy text ever since the 1500s",
                price = "Rp.90.000",
                read = "Read By 2 People",
                rating = "4.5",
                genre = "Drama"
            ),
            SingleBookModel(
                coverSingleBook = R.drawable.single4,
                title = "The Day I Left You",
                author = "Diana Ross",
                synopsis = "Lorem Ipsum is simply has been the industry's standard dummy text ever since the 1500s",
                price = "Rp.90.000",
                read = "Read By 2 People",
                rating = "4.5",
                genre = "Drama"
            ),
            SingleBookModel(
                coverSingleBook = R.drawable.single5,
                title = "The Day I Left You",
                author = "Diana Ross",
                synopsis = "Lorem Ipsum is simply has been the industry's standard dummy text ever since the 1500s",
                price = "Rp.90.000",
                read = "Read By 2 People",
                rating = "4.5",
                genre = "Drama"
            ),
            SingleBookModel(
                coverSingleBook = R.drawable.single6,
                title = "The Day I Left You",
                author = "Diana Ross",
                synopsis = "Lorem Ipsum is simply has been the industry's standard dummy text ever since the 1500s",
                price = "Rp.90.000",
                read = "Read By 2 People",
                rating = "4.5",
                genre = "Drama"
            ),
            SingleBookModel(
                coverSingleBook = R.drawable.single7,
                title = "The Day I Left You",
                author = "Diana Ross",
                synopsis = "Lorem Ipsum is simply has been the industry's standard dummy text ever since the 1500s",
                price = "Rp.90.000",
                read = "Read By 2 People",
                rating = "4.5",
                genre = "Drama"
            ),
        )
        return listData
    }
}