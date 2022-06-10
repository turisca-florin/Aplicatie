package com.example.proiectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class ShareSheet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_sheet2)


        val btnnext3 = findViewById<Button>(R.id.btn_next3)
        btnnext3.setOnClickListener {
            val intent = Intent(this, RecyclerView::class.java)
            startActivity(intent)
        }

        val btnprev2 = findViewById<Button>(R.id.btn_prev2)
        btnprev2.setOnClickListener {
            val intent = Intent(this, BottomNavigation::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share_menu, menu)
        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item?.itemId == R.id.share_menu){
            var shareIntent = Intent().apply {
                this.action = Intent.ACTION_SEND
                this.putExtra(Intent.EXTRA_TEXT, "We are sharing data")
                this.type = "text/plain"
            }
            startActivity(shareIntent)
        }else{
            return super.onOptionsItemSelected(item)
        }
        return true
    }

}