package com.amg.task1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amg.task1.model.Movie
import com.amg.task1.databinding.ListItemHorBinding
import com.amg.task1.databinding.ListItemVerBinding

class MoviesAdapter(
    private val movies: List<Movie>,
    private val orientation: ListOrientation,
    private val interaction: Interaction
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class HorizontalItemViewHolder(
        private val binding: ListItemHorBinding,
        private val interaction: Interaction
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                interaction.onItemSelected(movie, binding.root)
            }
        }
    }


    class VerticalItemViewHolder(
        private val binding: ListItemVerBinding,
        private val interaction: Interaction
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                interaction.onItemSelected(movie, binding.root)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        if (orientation == ListOrientation.HORIZONTAL)
            return HorizontalItemViewHolder(
                ListItemHorBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                ), interaction
            )
        else //VERTICAL
        {
            return VerticalItemViewHolder(
                ListItemVerBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                ), interaction
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is VerticalItemViewHolder)
            holder.bind(movies[position])
        else if (holder is HorizontalItemViewHolder)
            holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }


    enum class ListOrientation {
        HORIZONTAL, VERTICAL
    }

    //We use interface to notify the activity with every selection like onItemSelected , onBookmarkSelected
    interface Interaction {
        fun onItemSelected(item: Movie, view: View)
    }
}