package eu.tutorials.investlink.LoginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import eu.tutorials.investlink.R

class RegisterNama : AppCompatActivity() {
    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var backPage : ImageView
    private lateinit var getNamaDepan : TextView
    private lateinit var getNamaBelakang : TextView
    private lateinit var btnNext : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registernama)

        firebaseAuth = FirebaseAuth.getInstance()

        backPage = findViewById(R.id.backPage)
        getNamaDepan = findViewById(R.id.namaDepan)
        getNamaBelakang = findViewById(R.id.namaBelakang)
        btnNext = findViewById(R.id.btnNext)

        buttonNext()
        backPage()
    }

    private fun backPage() {
        backPage.setOnClickListener {
            onBackPressed()
        }
    }

    private fun buttonNext() {
        val namaDepan = getNamaDepan.text
        val namaBelakang = getNamaBelakang.text

        btnNext.setOnClickListener{
            if(namaDepan.isNotEmpty() && namaBelakang.isNotEmpty()) {
                startActivity(Intent(this, RegisterEmail::class.java))
            } else{
                Toast.makeText(this,"Isi nama depan dan nama belakang terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}