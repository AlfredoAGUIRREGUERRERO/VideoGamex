package com.tallercmovil.videogames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.tallercmovil.videogames.adapter.GamesAdapter
import com.tallercmovil.videogames.databinding.ActivityMainBinding
import com.tallercmovil.videogames.db.DBHelper
import com.tallercmovil.videogames.db.DbGames
import com.tallercmovil.videogames.model.Game

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listGames: ArrayList<Game>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //probando la generación de la bd
        /*val dbHelper = DBHelper(this)
        val db = dbHelper.writableDatabase

        if(db != null){
            Toast.makeText(this, "La bd fue creada exitosamente", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Error al crear la bd", Toast.LENGTH_LONG).show()
        }*/

        val dbGames = DbGames(this)

        listGames = dbGames.getGames()

        if(listGames.size == 0) binding.tvSinRegistros.visibility = View.VISIBLE
        else binding.tvSinRegistros.visibility = View.INVISIBLE


        val gamesAdapter = GamesAdapter(this, listGames)

        binding.lvGames.adapter = gamesAdapter

        binding.lvGames.setOnItemClickListener { adapterView, view, i, l ->
            //l es el id
            //i es la posición
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("ID", l.toInt())

            startActivity(intent)
            finish()
        }

    }

    fun click(view: View) {
        //eventos del click del botón flotante
        startActivity(Intent(this, InsertActivity::class.java))
        finish()
    }
}