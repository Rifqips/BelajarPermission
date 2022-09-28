package com.rifqipadisiliwangi.belajarpermission

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_location_permission.*
import kotlinx.android.synthetic.main.activity_main.*

class LocationPermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_permission)

        val gas = findViewById<ImageView>(R.id.ivNext)
        gas.setOnClickListener {
            val a = Intent(this,DangerousActivity::class.java)
            startActivity(a)
        }

        btnGallery.setOnClickListener {
            intentCamera()

        }

        btnCapture.setOnClickListener {
            intentCamera()
        }
    }

    private fun intentCamera(){
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(cameraIntent,1)
        }catch (exception : ActivityNotFoundException){
//            kalo error akan terdeteksi disini gaes
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1 && resultCode == RESULT_OK){
            val bitmap = data?.extras?.get("data") as Bitmap
            imgGallery.setImageBitmap(bitmap)
        }else if (requestCode == 1 && resultCode == RESULT_OK) {
            imgGallery.setImageURI(data?.data)
        }else{

        }
    }


}