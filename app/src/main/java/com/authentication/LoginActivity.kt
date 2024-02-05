package com.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.VideoApplication
import com.videoapplication.R
import com.VideoApplicationActivity

class LoginActivity : AppCompatActivity() {

    val auth = VideoApplication.instance.container!!.auth

    override fun onCreate(savedInstanceState: Bundle?){

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)

        val loginButton = findViewById<Button>(R.id.button)
        val registerButton = findViewById<TextView>(R.id.registerText)

        if(auth.currentUser != null){
            startActivity(Intent(this@LoginActivity, VideoApplicationActivity::class.java))
            finish()
        }

        loginButton.setOnClickListener {

                val emailString = email.text.toString()
                val passwordString = password.text.toString()

                auth.signInWithEmailAndPassword(emailString, passwordString)
                    .addOnCompleteListener {

                        if (it.isSuccessful) {

                            val toast = Toast.makeText(
                                this@LoginActivity,
                                "Login Successful",
                                Toast.LENGTH_LONG
                            )
                            toast.show()

                            startActivity(Intent(this@LoginActivity, VideoApplicationActivity::class.java))
                            finish()
                        }
                        else {
                            //maybe a log
                            val toast = Toast.makeText(
                                this@LoginActivity,
                                "Login Unsuccessful : ${it.exception}",
                                Toast.LENGTH_LONG
                            )
                            toast.show()
                        }
                    }
        }

        registerButton.setOnClickListener{

            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            finish()
        }
    }
}