package com.example.dmos5_a04

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ClientDetailsActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var cpfTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var addressTextView: TextView
    private lateinit var cityTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_details)

        nameTextView = findViewById(R.id.nameTextView)
        cpfTextView = findViewById(R.id.cpfTextView)
        emailTextView = findViewById(R.id.emailTextView)
        phoneTextView = findViewById(R.id.phoneTextView)
        addressTextView = findViewById(R.id.addressTextView)
        cityTextView = findViewById(R.id.cityTextView)

        populateClientDetails()

        val returnButton: Button = findViewById(R.id.returnButton)
        returnButton.setOnClickListener {
            finish()
        }
    }

    private fun populateClientDetails() {
        var client = ClientData.client
        client?.let {
            nameTextView.text = it.name
            cpfTextView.text = it.cpf
            emailTextView.text = it.email
            phoneTextView.text = it.phone
            addressTextView.text = it.address
            cityTextView.text = it.city
        }
    }
}