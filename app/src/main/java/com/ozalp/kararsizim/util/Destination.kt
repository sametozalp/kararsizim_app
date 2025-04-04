package com.ozalp.kararsizim.util

interface Destination {
    val route: String
    val routeWithArgs: String
}

object CategoryScreenDestination : Destination {
    override val route: String
        get() = "categories"
    override val routeWithArgs: String
        get() = route

}

object CategoryDetailScreenDestination : Destination {
    override val route: String
        get() = "category_detail"

    const val argCategoryId = "categoryId"

    override val routeWithArgs: String
        get() = "$route/{$argCategoryId}"

}

object HaveAProblemDestination : Destination {
    override val route: String
        get() = "have_a_problem"
    override val routeWithArgs: String
        get() = route

}