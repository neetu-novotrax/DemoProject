package com.example.praticaldemo.data

import com.google.gson.annotations.SerializedName


data class MuumyMeCategory (

  @SerializedName("category_id"   ) var categoryId   : String?         = null,
  @SerializedName("category_name" ) var categoryName : String?         = null,
  @SerializedName("list"          ) var list         : ArrayList<List> = arrayListOf()

)