package com.remotejobs.android.util

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.remotejobs.android.R

object AdMobUtil {
    @Composable
    fun getAdViewForBannerAd(context: Context, adUnit: String) : AdView{
        val adView = remember {
            AdView(context).apply {
                adUnitId = adUnit
                setAdSize(AdSize.FULL_BANNER)
                loadAd(AdRequest.Builder().build())
            }
        }

        return adView
    }

    fun showInterstitialAd(context: Context, adUnit: String){
        InterstitialAd.load(
            context,
            adUnit,
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    interstitialAd.show(context as Activity)
                }
            }
        )
    }

}