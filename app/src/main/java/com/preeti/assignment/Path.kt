package com.preeti.assignment

sealed class Path(val route: String) {
    object SignUp : Path("SignUp")
    object Login : Path("Login")
    object Dashboard : Path("Dashboard")
   /* object UserScreen : Path("users")
    object SearchScreen: Path("search")*/

}
