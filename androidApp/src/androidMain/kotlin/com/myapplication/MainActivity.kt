package com.myapplication

import App
import MainView
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import presentation.navigation.NavHomeScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //MainView()
            App(
                darkTheme = true,
                dynamicColor = true)
        }
    }
}