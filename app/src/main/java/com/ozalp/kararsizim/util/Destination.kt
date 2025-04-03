package com.ozalp.kararsizim.util

interface Destination {
    val title: String
    val route: String
    val routeWithArgs: String
}

object CategoryScreenDestination : Destination {
    override val title: String
        get() = "Kategoriler"
    override val route: String
        get() = "categories"
    override val routeWithArgs: String
        get() = route

}

object CategoryDetailScreenDestination : Destination {
    override val title: String
        get() = "Kategori"
    override val route: String
        get() = "category_detail"

    const val argCategoryId = "categoryId"

    override val routeWithArgs: String
        get() = "$route/{$argCategoryId}"

}