package com.tallercmovil.videogames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.tallercmovil.videogames.databinding.ActivityInsertBinding
import com.tallercmovil.videogames.db.DbGames

class InsertActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInsertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun click(view: View) {

        val dbGames = DbGames(this)

        with(binding){

            if(!tietTitulo.text.toString().isEmpty() && !tietGenre.text.toString().isEmpty() && !tietDeveloper.text.toString().isEmpty()){
                val id = dbGames.insertGame(tietTitulo.text.toString(), tietGenre.text.toString(), tietDeveloper.text.toString())

                if(id > 0) { //el registro se insertó correctamente
                    Toast.makeText(this@InsertActivity, "Registro guardado exitosamente", Toast.LENGTH_LONG).show()

                    //Reiniciamos las cajas de texto
                    tietTitulo.setText("")
                    tietGenre.setText("")
                    tietDeveloper.setText("")
                    tietTitulo.requestFocus()
                }else{
                    Toast.makeText(this@InsertActivity, "Error al guardar el registro", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this@InsertActivity, "Por favor llene todos los campos", Toast.LENGTH_LONG).show()

                //Para mandar un error en una caja de texto especíica
                //tietTitulo.text = "Por favor agrega un título"
            }

        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
    }
}