package io.github.sahalnazar.collapsingtoolbar


data class Data(
    val id: Int,
    val helloString: String,
    val image: Int
)


fun getData(): List<Data> {
    return listOf(
        Data(
            0,
            "Hello Universe!",
            R.drawable.ic_infinity
        ),
        Data(
            1,
            "Hello World!",
            R.drawable.ic_infinity
        ),
        Data(2,
            "Hello Earth!",
            R.drawable.ic_infinity
        ),
        Data(3,
            "Hello Mars!",
            R.drawable.ic_infinity
        ),
        Data(4,
            "Hello Mercury",
            R.drawable.ic_infinity
        ),
        Data(5,
            "Hello Venus",
            R.drawable.ic_infinity
        ),
        Data(6,
            "Hello Jupiter",
            R.drawable.ic_infinity
        ),
        Data(7,
            "Hello Saturn",
            R.drawable.ic_infinity
        )
    )
}
