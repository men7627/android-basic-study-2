package com.example.android_basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = listOf(
            SampleModel(R.drawable.iu1, "아이유"),
            SampleModel(R.drawable.iu2, "IU"),
            SampleModel(R.drawable.iu3, "이지은"),
            SampleModel(R.drawable.iu4, "신봉선"),
            SampleModel(R.drawable.iu5, "이지안"),
            SampleModel(R.drawable.iu6, "달봉")
        )

        val adapter = SampleDataAdapter(list, R.layout.item_box_3)

        sampleListView.adapter = adapter

        sampleListView.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
    }
}
