package com.dyah.dailyprojectresume.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class SeriesModel(
        val coverSingleBook: Int?, //drawable integer  , server : string harus nullable
        val title: String?,
        val author: String?,
        val synopsis: String?,
        val price: String?,
        val read : String?,
        val rating : String?,
        val genre : String?
    ) : Parcelable
