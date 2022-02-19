package com.shinyelee.fb_login_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookmarkButton = findViewById<TextView>(R.id.bookmarkBtn)
        bookmarkButton.setOnClickListener {

            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/lNGf0ef7vT",
                "https://mp-seoul-image-production-s3.mangoplate.com/495395_1631411614563619.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "비비비당"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/TXkjVTA_MXiL",
                "https://mp-seoul-image-production-s3.mangoplate.com/978259_1609066259920123.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "톤쇼우"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/eLq_Q72bscee",
                "https://mp-seoul-image-production-s3.mangoplate.com/1129699_1620482534399327.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "해목"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/s3HTCj99t-",
                "https://mp-seoul-image-production-s3.mangoplate.com/577068_1506913302368580.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "신발원"
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
                "https://www.mangoplate.com/restaurants/TXkjVTA_MXiL",
                "https://mp-seoul-image-production-s3.mangoplate.com/978259_1609066259920123.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "톤쇼우"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/eLq_Q72bscee",
                "https://mp-seoul-image-production-s3.mangoplate.com/1129699_1620482534399327.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "해목"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/s3HTCj99t-",
                "https://mp-seoul-image-production-s3.mangoplate.com/577068_1506913302368580.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "신발원"
            )
        )

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, items)
        recyclerview.adapter = rvAdapter

        rvAdapter.itemClick = object: RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {

                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url", items[position].url)
                intent.putExtra("title", items[position].titleText)
                intent.putExtra("imageUrl", items[position].imageUrl)

                startActivity(intent)
            }
        }

        recyclerview.layoutManager = GridLayoutManager(this, 2)
    }
}