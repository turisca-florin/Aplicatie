package com.example.proiectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proiectandroid.databinding.ActivityRecyclerViewBinding

class RecyclerView : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RVAdapter(this, addList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val item = menu?.findItem(R.id.searchView_MenuMain)
        val searchView: SearchView = item?.actionView as SearchView

        val btnprev3 = findViewById<Button>(R.id.btn_prev3)
        btnprev3.setOnClickListener {
            val intent = Intent(this, ShareSheet::class.java)
            startActivity(intent)
        }

        searchView.imeOptions = EditorInfo.IME_ACTION_DONE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return true
    }

    private fun addList(): ArrayList<Content> {
        val list = ArrayList<Content>()
        list.add(Content("Laptop", "Asus ROG"))
        list.add(Content("Laptop", "Asus TUF"))
        list.add(Content("Telefon", "Iphone 13 PRO"))
        list.add(Content("Telefon", "Samsung Galaxy S21"))
        list.add(Content("Laptop", "Lenovo Legion"))
        list.add(Content("Telefon", "Iphone 13 PRO MAX"))
        list.add(Content("Telefon", "Huawei P50 PRO"))
        return list
    }
}