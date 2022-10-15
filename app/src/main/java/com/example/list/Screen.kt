package com.example.list

import androidx.core.graphics.rotationMatrix

sealed class Screen(val route:String) {
    object  Home:Screen(route = "home_screen")
    object  Atten:Screen(route="atten_screen")
    object  ShowList:Screen(route = "Show_details/{ip}")
    object  option:Screen(route="option")
}