 package com.example.music

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    lateinit var etname: EditText
    lateinit var spcountry: Spinner
    lateinit var etphone:EditText
    lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
    }
    fun castViews(){
        etname=findViewById(R.id.etname)
        spcountry=findViewById(R.id.spcountry)
        etphone=findViewById(R.id.etphone)
        button=findViewById(R.id.button)

        var country= arrayOf("Kenya","Uganda","Tanzania")
        var countryAdapter=ArrayAdapter(baseContext,android.R.layout.simple_dropdown_item_1line,country)
        countryAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spcountry.adapter=countryAdapter
        clickSignUp()
    }
    fun clickSignUp(){
        button.setOnClickListener {
            var name=etname.text.toString()
            var country=""
            var phone=etphone.text.toString()

            var details=Details(name, country, phone)
            var intent=Intent(baseContext,Home::class.java)
            startActivity(intent)
        }

    }

}

data class Details(var name:String,var country:String,var phone:String)