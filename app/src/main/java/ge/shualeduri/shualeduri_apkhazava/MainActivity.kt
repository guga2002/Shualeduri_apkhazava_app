package ge.shualeduri.shualeduri_apkhazava

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    var isremebered=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        isremebered = sharedPreferences.getBoolean("CHECKBOX", false)
        if (isremebered) {
            val intent = Intent(this, meoregverdi::class.java)
            startActivity(intent)
            finish()
        }
     btn1.setOnClickListener {
         val name:String=nameofuser.text.toString()
         val surname:String=surnameofuser.text.toString()
         val checked:Boolean=checkboxi.isChecked

         val editor:SharedPreferences.Editor=sharedPreferences.edit()
         editor.putString("name",name)
         editor.putString("surname",surname)
         editor.putBoolean("CHECKBOX",checked)
         editor.apply()
         Toast.makeText(this,"informacia gadaeca",Toast.LENGTH_LONG).show()

         val intent = Intent(this, meoregverdi::class.java)
         startActivity(intent)
         finish()
     }
        buttonofnext.setOnClickListener { //aq davwer kods im shemtxvevashi roca next daachers
            val editor:SharedPreferences.Editor=sharedPreferences.edit()
            editor.putString("name","")//amshemtxvevashi vawvdit cariel strings
            editor.putString("surname","")//aqac vawvdit cariel strings
            editor.apply()
            Toast.makeText(this,"informacia sheinaxa  next-is tvis",Toast.LENGTH_LONG).show()
            val intent = Intent(this, meoregverdi::class.java)
            startActivity(intent)
            finish()
        }
    }


}