package com.dino.unsplash.shared.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.dino.unsplash.shared.android.presentation.NavGraphs
import com.dino.unsplash.shared.android.theme.UnplashTheme
import com.ramcosta.composedestinations.DestinationsNavHost


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnplashTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
