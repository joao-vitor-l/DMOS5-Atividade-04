package com.example.dmos5_a04

import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var cpfEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var cityEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameEditText)
        cpfEditText = findViewById(R.id.cpfEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        addressEditText = findViewById(R.id.addressEditText)
        cityEditText = findViewById(R.id.cityEditText)

        val saveButton: Button = findViewById(R.id.saveButton)
        saveButton.setOnClickListener(View.OnClickListener {
            var client = retrieveClientData()
            var validated = validateClientData(client)
            if(validated) {
                saveClientData(client)
                navigateToClientDetails()
            } else {
                Toast.makeText(this, "Preencha todos os campos corretamente.", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun retrieveClientData(): Client {
        var name = nameEditText.text.toString()
        var cpf = cpfEditText.text.toString()
        var email = emailEditText.text.toString()
        var phone = phoneEditText.text.toString()
        var address = addressEditText.text.toString()
        var city = cityEditText.text.toString()

        var client = Client(name, cpf, email, phone, address, city)
        return client
    }

    private fun validateClientData(client: Client): Boolean {
        return client.name.isNotEmpty() &&
                client.cpf.isNotEmpty() && isCPFValid(client.cpf) &&
                client.email.isNotEmpty() && isEmailValid(client.email) &&
                client.phone.isNotEmpty() && isPhoneValid(client.phone) &&
                client.address.isNotEmpty() &&
                client.city.isNotEmpty()
    }

    private fun isCPFValid(cpf: String): Boolean {
        return cpf.length == 11
    }

    private fun isEmailValid(email: String): Boolean {
        val regex = Regex("""^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}$""")
        return regex.matches(email)
    }

    private fun isPhoneValid(phone: String): Boolean {
        return phone.length == 9
    }

    private fun saveClientData(client: Client) {
        ClientData.client = client
    }

    private fun navigateToClientDetails() {
        val intent = Intent(this, ClientDetailsActivity::class.java)
        startActivity(intent)
    }
}