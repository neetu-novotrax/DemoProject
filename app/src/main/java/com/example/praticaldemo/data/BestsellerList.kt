package com.example.praticaldemo.data

import com.google.gson.annotations.SerializedName


data class BestsellerList (

  @SerializedName("product_id"       ) var productId      : String? = null,
  @SerializedName("sku"              ) var sku            : String? = null,
  @SerializedName("mgs_brand"        ) var mgsBrand       : String? = null,
  @SerializedName("name"             ) var name           : String? = null,
  @SerializedName("url"              ) var url            : String? = null,
  @SerializedName("image"            ) var image          : String? = null,
  @SerializedName("price"            ) var price          : String? = null,
  @SerializedName("special_price"    ) var specialPrice   : String? = null,
  @SerializedName("final_price"      ) var finalPrice     : String? = null,
  @SerializedName("discount"         ) var discount       : String? = null,
  @SerializedName("currency_code"    ) var currencyCode   : String? = null,
  @SerializedName("is_wishlisted"    ) var isWishlisted   : Int?    = null,
  @SerializedName("wishlist_item_id" ) var wishlistItemId : String? = null,
  @SerializedName("wishlist_id"      ) var wishlistId     : String? = null

)