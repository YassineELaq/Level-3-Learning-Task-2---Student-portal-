package com.example.level_3_learning_task_2_student_portalapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.*

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

const val ADD_WEB_REQUEST_CODE = 100

class MainActivity : AppCompatActivity() {

    private val websites = arrayListOf<Website>()
    private val websiteAdapter = WebsiteAdapter(websites,{ website : Website -> partItemClicked(website) })

    private fun partItemClicked(website: Website ) {
        val openURL = Intent(android.content.Intent.ACTION_VIEW)
        openURL.data = Uri.parse(website.websiteURL)
        startActivity(openURL)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        websites.add(Website("Vlo","https://home.informatica.hva.nl/vlo"))
        websites.add(Website("dlo","https://dlo.mijnhva.nl/d2l/home"))
        websites.add(Website("Sis","www.sis.hva.nl"))
        websites.add(Website("Rooster","www.roosters.hva.nl"))


        initViews()


        fab.setOnClickListener { startAddActivity() }
    }

    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
        rvWebsite.layoutManager = GridLayoutManager(this@MainActivity, 2)
        rvWebsite.adapter = websiteAdapter
        rvWebsite.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
    }

    private fun startAddActivity() {
        val intent = Intent(this, AddWebActivity::class.java)
        startActivityForResult(intent,ADD_WEB_REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                ADD_WEB_REQUEST_CODE -> {
                    data?.let {
                        val reminder = data!!.getParcelableExtra<Website>(EXTRA_WEBSITE)
                        websites.add(reminder)
                        websiteAdapter.notifyDataSetChanged()
                    }?: run {
                        Log.e("MainActivity", "empty intent data received. Please try again")
                    }

                }
            }
        }
    }



}
