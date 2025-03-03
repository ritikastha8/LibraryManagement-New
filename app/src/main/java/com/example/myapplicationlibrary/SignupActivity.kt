package com.example.myapplicationlibrary

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationlibrary.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    lateinit var bind : ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bind = ActivitySignupBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_signup)

        setContentView(bind.root)


        bind.signupbtn.setOnClickListener {
            val username: String=bind.name.text.toString()
            val email: String=bind.email.text.toString()
            val password: String=bind.password.text.toString()
            val conpassword: String=bind.confirmpassword.text.toString()
            if (username.isEmpty()){
                Toast.makeText(this@SignupActivity,"Username can't be empty", Toast.LENGTH_LONG).show()
            }else if(email.isEmpty()){
                Toast.makeText(this@SignupActivity,"Email can't be empty", Toast.LENGTH_LONG).show()
            }else if(password.isEmpty()){
                Toast.makeText(this@SignupActivity,"Password can't be empty", Toast.LENGTH_LONG).show()
            }else if(conpassword.isEmpty()){
                Toast.makeText(this@SignupActivity,"Confirm Password can't be empty", Toast.LENGTH_LONG).show()
            }else if(password!=conpassword){
                Toast.makeText(this@SignupActivity,"Password and Confirm Password should be same",
                    Toast.LENGTH_LONG).show()
//
            }
//            else{
//                val intent =Intent(this@SignupActivity,LoginActivityyy::class.java)
//                startActivity(intent)
//            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}