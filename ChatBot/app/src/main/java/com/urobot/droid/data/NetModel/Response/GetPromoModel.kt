package com.urobot.droid.data.NetModel.Response

import com.google.gson.annotations.SerializedName

data class GetPromoModel(

        @field:SerializedName("promo_code")
        val promoCode: String? = null

)