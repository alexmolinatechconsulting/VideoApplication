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

class RegisterActivity : AppCompatActivity() {

    val auth = VideoApplication.instance.container!!.auth
    val store = VideoApplication.instance.container!!.store

    override fun onCreate(savedInstanceState: Bundle?){

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val firstName = findViewById<EditText>(R.id.firstName)
        val lastName = findViewById<EditText>(R.id.lastName)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)

        val registerButton = findViewById<Button>(R.id.button)
        val loginButton = findViewById<TextView>(R.id.loginText)

        registerButton.setOnClickListener {

            val firstNameString = firstName.text.toString()
            val lastNameString = lastName.text.toString()
            val emailString = email.text.toString()
            val passwordString = password.text.toString()

            auth.createUserWithEmailAndPassword(emailString, passwordString)
                .addOnCompleteListener {

                    if (it.isSuccessful) {

                        val toast = Toast.makeText(
                            this@RegisterActivity,
                            "Register User Successful",
                            Toast.LENGTH_LONG
                        )
                        toast.show()

                        val userId = auth.currentUser!!.uid
                        val document = store.collection("registeredUsers").document(userId)

                        val documentData = mapOf(
                            "firstName" to firstNameString,
                            "lastName" to lastNameString,
                            "emailAddress" to emailString
                        )

                        document.set(documentData).addOnCompleteListener{
                            if(it.isSuccessful){
                                val toast = Toast.makeText(
                                    this@RegisterActivity,
                                    "Store User Successful",
                                    Toast.LENGTH_LONG
                                )
                                toast.show()
                            }
                            else{
                                //maybe a log
                                val toast = Toast.makeText(
                                    this@RegisterActivity,
                                    "Store User Was Unsuccessful : ${it.exception}",
                                    Toast.LENGTH_LONG
                                )
                                toast.show()
                            }
                        }

                        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                        finish()
                    }
                    else {

                        val toast = Toast.makeText(
                            this@RegisterActivity,
                            "Register User Unsuccessful : ${it.exception}",
                            Toast.LENGTH_LONG
                        )
                        toast.show()
                    }
                }
        }

        loginButton.setOnClickListener{
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            finish()
        }
    }
}