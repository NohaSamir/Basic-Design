package com.amg.task1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.amg.task1.adapter.MoviesAdapter
import com.amg.task1.databinding.FragmentMoviesBinding
import com.amg.task1.model.Movie
import com.amg.task1.model.getDummyMoviesList1
import com.amg.task1.model.getDummyMoviesList2

class MoviesListFragment : Fragment(), MoviesAdapter.Interaction {

    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)

        binding.listHor.adapter =
            MoviesAdapter(getDummyMoviesList1(), MoviesAdapter.ListOrientation.HORIZONTAL, this)
        binding.listVer.adapter =
            MoviesAdapter(getDummyMoviesList2(), MoviesAdapter.ListOrientation.VERTICAL, this)

        return binding.root
    }

    override fun onItemSelected(movie: Movie, imageView: ImageView) {

        //Add the sharedElement  view.poster, whose transitionName is “movie_title”.
        val extras = FragmentNavigatorExtras(
            imageView to movie.title
        )

        val action =
            MoviesListFragmentDirections.actionMoviesListFragmentToMovieDetailsFragment(movie)
        findNavController().navigate(action, extras)
    }
}