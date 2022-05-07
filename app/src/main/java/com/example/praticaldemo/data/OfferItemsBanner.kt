package com.example.praticaldemo.data

import com.google.gson.annotations.SerializedName


data class OfferItemsBanner (

  @SerializedName("category_id"  ) var categoryId  : String? = null,
  @SerializedName("banner_image" ) var bannerImage : String? = null

)