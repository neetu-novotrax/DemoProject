package com.example.praticaldemo.data

import androidx.room.Entity
import com.google.gson.annotations.SerializedName


data class User (

  @SerializedName("status"  ) var status  : String? = null,
  @SerializedName("message" ) var message : String? = null,
  @SerializedName("data"    ) var data    : Data?   = Data()

)