package com.example.gridhomework

import RecyclerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val items = ArrayList<ItemModel>()
    lateinit var adapter : RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUp()
    }

    private fun setUp() {
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = RecyclerAdapter(items)
        recyclerView.adapter = adapter
        setData()

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = true
            refresh()

            Handler().postDelayed({
                swipeRefreshLayout.isRefreshing = false
                setData()
                adapter.notifyDataSetChanged()
            }, 2000)
        }
    }

    private fun refresh() {
        items.clear()
        adapter.notifyDataSetChanged()
    }

    private fun setData(){
        items.add(ItemModel(R.mipmap.first, "title"))
        items.add(ItemModel(R.mipmap.first, "title"))
        items.add(ItemModel(R.mipmap.secondary, "different"))
        items.add(ItemModel(R.mipmap.first, "title"))
        items.add(ItemModel(R.mipmap.first, "title"))
        items.add(ItemModel(R.mipmap.secondary, "different"))
        items.add(ItemModel(R.mipmap.first, "title"))
        items.add(ItemModel(R.mipmap.first, "title"))
        items.add(ItemModel(R.mipmap.first, "title"))
        items.add(ItemModel(R.mipmap.secondary, "different"))
        items.add(ItemModel(R.mipmap.first, "title"))
        items.add(ItemModel(R.mipmap.first, "title"))
        items.add(ItemModel(R.mipmap.first, "title"))
        items.add(ItemModel(R.mipmap.secondary, "different"))
    }
}