package ge.shualeduri.shualeduri_apkhazava

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_meoregverdi.*

class meoregverdi : AppCompatActivity() {
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meoregverdi)
        preferences=getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val name=preferences.getString("name","")
        placeofname.text=name
        val surname=preferences.getString("surname","")
        placeofsurname.text=surname

        logout.setOnClickListener {
           // val editor:SharedPreferences.Editor=preferences.edit()
           // editor.clear()
           // editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}