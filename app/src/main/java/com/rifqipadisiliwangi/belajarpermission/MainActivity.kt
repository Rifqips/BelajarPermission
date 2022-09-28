package com.rifqipadisiliwangi.belajarpermission

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun toast(msg:String){
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        }

        fun CheckConnectionType()
        {
            val connectionManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val wifi_Connection = connectionManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            val mobile_data_connection = connectionManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)

            if (wifi_Connection != null) {
                if (wifi_Connection.isConnectedOrConnecting) {
                    toast("WIFI Connection is on")
                } else {
                    if (mobile_data_connection != null) {
                        if (mobile_data_connection.isConnectedOrConnecting) {
                            toast("Mobile Data Connection is on")
                        } else {
                            toast("No Network Connection")
                        }
                    }
                }
            }
        }

        btnCheckInternet.setOnClickListener {
            CheckConnectionType()
        }

        btnShowImg.setOnClickListener {
            Glide.with(this)
                .load("https://cdn.oneesports.id/cdn-data/sites/2/2022/03/Naruto-Uzumaki-1024x576.webp")
                .circleCrop()
                .into(ivLoad)
        }

        val gas = findViewById<ImageView>(R.id.ivNext)
        gas.setOnClickListener{
            val a = Intent(this,LocationPermissionActivity::class.java)
            startActivity(a)
        }

    }
}