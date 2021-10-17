package com.navigationplayground

sealed class Screens(val route:String){
    object ScreenHome:Screens("home")
    object ScreenDetail:Screens("detail")
}
