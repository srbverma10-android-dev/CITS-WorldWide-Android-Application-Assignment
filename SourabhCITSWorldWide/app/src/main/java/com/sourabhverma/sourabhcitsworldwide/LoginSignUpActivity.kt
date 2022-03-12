package com.sourabhverma.sourabhcitsworldwide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sourabhverma.sourabhcitsworldwide.databinding.ActivityLoginSignUpBinding
import android.preference.PreferenceManager

import android.content.SharedPreferences
import android.graphics.Color
import android.text.Spannable

import android.text.style.ForegroundColorSpan

import android.text.SpannableString
import android.widget.Toast

class LoginSignUpActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginSignUpBinding

    private lateinit var sp : SharedPreferences
    private lateinit var e : SharedPreferences.Editor

    private var showedError = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_sign_up)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_sign_up)

        sp = getSharedPreferences("User_Details", MODE_PRIVATE)
        e = sp.edit()

        setSpannable()

        if(!sp.getBoolean("IsLoggedIn", false)){
            binding.signUpInclude.root.visibility = View.VISIBLE
        } else {
            binding.logInInclude.root.visibility = View.VISIBLE
        }

        clickListeners()

    }

    private fun clickListeners() {

        binding.signUpInclude.forgotPassword.setOnClickListener {
            binding.signUpInclude.root.visibility = View.GONE
            binding.forgotPasswordInclude.root.visibility = View.VISIBLE
        }

        binding.signUpInclude.signUpButton.setOnClickListener {
            showedError = false
            if(binding.signUpInclude.nameEditText.text.toString() == ""){
                binding.signUpInclude.nameEditText.error = "Please Enter Your Name"
                showedError = true
            } else {
                binding.signUpInclude.nameEditText.error = null
            }
            if(binding.signUpInclude.emailEditText.text.toString() == ""){
                binding.signUpInclude.emailEditText.error = "Please Enter Your Email"
                showedError = true
            }else {
                binding.signUpInclude.emailEditText.error = null
            }
            if(binding.signUpInclude.passwordEditText.text.toString() == ""){
                binding.signUpInclude.passwordEditText.error = "Please Enter Your Password"
                showedError = true
            }else {
                binding.signUpInclude.passwordEditText.error = null
            }
            if(binding.signUpInclude.confirmPasswordEditText.text.toString() == ""){
                binding.signUpInclude.confirmPasswordEditText.error = "Please Confirm Your Password"
                showedError = true
            } else {
                binding.signUpInclude.confirmPasswordEditText.error = null
            }
            if(binding.signUpInclude.confirmPasswordEditText.text.toString() != binding.signUpInclude.passwordEditText.text.toString()){
                showedError = true
                Toast.makeText(this, "Password is Different", Toast.LENGTH_SHORT).show()
            }

            if (!showedError){
                e.putString("Name", binding.signUpInclude.nameEditText.text.toString())
                e.putString("Email", binding.signUpInclude.emailEditText.text.toString())
                e.putString("Password", binding.signUpInclude.passwordEditText.text.toString())
                e.putBoolean("IsLoggedIn", true)
                if(e.commit()){
                    var intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                    finish()
                }
            }

        }

        binding.logInInclude.signUpButton.setOnClickListener {
            showedError = false

            if(binding.logInInclude.nameEditText.text.toString() == ""){
                binding.logInInclude.nameEditText.error = "Please Enter Your Name"
                showedError = true
            } else {
                binding.logInInclude.nameEditText.error = null
            }
            if(binding.logInInclude.passwordEditText.text.toString() == ""){
                binding.logInInclude.passwordEditText.error = "Please Enter Your Password"
                showedError = true
            }else {
                binding.logInInclude.passwordEditText.error = null
            }

            if(!showedError&& binding.logInInclude.passwordEditText.text.toString() == sp.getString("Password","")){
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            } else{
                Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show()
            }

        }


    }

    private fun setSpannable() {
        val wordtoSpan: Spannable =
            SpannableString("Don't have an account? Login")
        wordtoSpan.setSpan(
            ForegroundColorSpan(Color.BLUE),
            22,
            27,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.signUpInclude.spannableText.text = wordtoSpan
    }

    override fun onBackPressed() {
        if(binding.forgotPasswordInclude.root.visibility == View.VISIBLE){
            binding.forgotPasswordInclude.root.visibility = View.GONE
            binding.signUpInclude.root.visibility = View.VISIBLE
        } else {
            super.onBackPressed()
        }

    }

}