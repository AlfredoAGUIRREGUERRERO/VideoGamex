package com.tallercmovil.videogames.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.tallercmovil.videogames.databinding.ListItemBinding
import com.tallercmovil.videogames.model.Game

class GamesAdapter(contexto: Context, listGames: ArrayList<Game>): BaseAdapter() {

    private val listGames = listGames
    private val layoutInflater = LayoutInflater.from(contexto)

    override fun getCount(): Int {
        return listGames.size
    }

    override fun getItem(p0: Int): Any {
        return listGames[p0]
    }

    override fun getItemId(p0: Int): Long {
        return listGames[p0].id.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding = ListItemBinding.inflate(layoutInflater)

        with(binding){
            tvTitle.text = listGames[p0].title
            tvGenre.text = listGames[p0].genre
            tvDeveloper.text = listGames[p0].developer
        }

        return binding.root
    }
}