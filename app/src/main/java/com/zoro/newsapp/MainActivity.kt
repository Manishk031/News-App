package com.zoro.newsapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), NewsItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleView: RecyclerView = findViewById(R.id.recycleView)
        val layoutManger = LinearLayoutManager(this)
        recycleView.layoutManager = layoutManger

        val item = fetchData()
        val adapter: NewListAdapter =
            NewListAdapter(item, this)
        recycleView.adapter = adapter
    }

    private fun fetchData(): ArrayList<String> {

        val list = ArrayList<String>()
        for (i in 0 until 100) {
            list.add("Item $i")
        }
        return list
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this, "clicked item is $item", Toast.LENGTH_LONG).show()
    }

}
