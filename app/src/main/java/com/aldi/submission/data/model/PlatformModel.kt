package com.aldi.submission.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlatformModel(
	val name: String? = null,
	val id: Int? = null,
	val slug: String? = null,
	val platforms: List<PlatformItem?>? = null
) : Parcelable

@Parcelize
data class PlatformItem(
	val image: String? = null,
	val gamesCount: Int? = null,
	val year_start: Int? = null,
	val year_end: Int? = null,
	val name: String? = null,
	val id: Int? = null,
	val imageBackground: String? = null,
	val slug: String? = null
) : Parcelable
