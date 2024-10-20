package com.devspace.recyclerview

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)

        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }
        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }
        
        adapter.setOnclickListener { contact ->

        }


    }

    private val contacts = listOf(
        Contact(
            name = "Marcos",
            phone = "(55) 21 965889957",
            icon = R.drawable.sample12
        ),
        Contact(
            name = "Nicole",
            phone = "(55) 21 985689043",
            icon = R.drawable.sample1
        ),
        Contact(
            name = "Melissa",
            phone = "(55) 21 967945876",
            icon = R.drawable.sample3
        ),
        Contact(
            name = "Rogerio",
            phone = "(55) 21 9808957894",
            icon = R.drawable.sample2
        ),
        Contact(
            name = "Vivian",
            phone = "(55) 21 967438905",
            icon = R.drawable.sample6
        ),
        Contact(
            name = "Roberta",
            phone = "(55) 21 968547890",
            icon = R.drawable.sample16
        ),
        Contact(
            name = "Carlos",
            phone = "(55) 21 978459607",
            icon = R.drawable.sample8
        ),
        Contact(
            name = "Shirley",
            phone = "(55) 21 968945635",
            icon = R.drawable.sample7
        ),
        Contact(
            name = "Manuel",
            phone = "(55) 21 973690469",
            icon = R.drawable.sample10
        ),)}