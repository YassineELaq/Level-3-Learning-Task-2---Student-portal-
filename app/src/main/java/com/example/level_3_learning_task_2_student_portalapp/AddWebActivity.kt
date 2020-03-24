package com.example.level_3_learning_task_2_student_portalapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_add_web.*
import kotlinx.android.synthetic.main.content_add_web.*

const val EXTRA_WEBSITE = "EXTRA_WEBSITE"

class AddWebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_web)
        setSupportActionBar(toolbar)
        getSupportActionBar()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        addButton.setOnClickListener {onSaveClick()
        }



    }
    private fun onSaveClick() {
        val websiteTextTitel = tiTitel.text.toString()
        val websiteTextUrl = tiUrl.text.toString()

        if(websiteTextTitel.isNotBlank() && websiteTextUrl.isNotBlank() ){

            val website = Website(websiteTextTitel, websiteTextUrl)
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_WEBSITE, website)
            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        }else{
            Toast.makeText(this, R.string.notEmpty, Toast.LENGTH_SHORT).show()

        }


    }


}
