package com.sourabhverma.sourabhcitsworldwide

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.auth.FirebaseAuth
import java.util.*


class SplashScreenActivity : AppCompatActivity() {

    private val handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        if (ConnectionManager.checkConnection(baseContext)) {
            handler.postDelayed({
                val intent = Intent(this@SplashScreenActivity, LoginSignUpActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            }, 1500)
        } else {
            Toast.makeText(this,"No Internet, Please restart application.", Toast.LENGTH_SHORT).show();
        }

    }
}