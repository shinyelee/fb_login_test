package com.shinyelee.fb_login_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/lNGf0ef7vT",
                "https://mp-seoul-image-production-s3.mangoplate.com/495395_1631411614563619.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "비비비당"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/lNGf0ef7vT",
                "https://mp-seoul-image-production-s3.mangoplate.com/495395_1631411614563619.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "비비비당"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/lNGf0ef7vT",
                "https://mp-seoul-image-production-s3.mangoplate.com/495395_1631411614563619.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "비비비당"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/lNGf0ef7vT",
                "https://mp-seoul-image-production-s3.mangoplate.com/495395_1631411614563619.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "비비비당"
            )
        )

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(items)
        recyclerview.adapter = rvAdapter

        recyclerview.layoutManager = GridLayoutManager(this, 2)
    }
}