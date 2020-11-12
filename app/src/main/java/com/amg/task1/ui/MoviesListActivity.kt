package com.amg.task1.ui

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amg.task1.model.Movie
import com.amg.task1.R
import com.amg.task1.adapter.MoviesAdapter
import com.amg.task1.databinding.ActivityItemListBinding
import com.amg.task1.model.getDummyMoviesList1
import com.amg.task1.model.getDummyMoviesList2
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class MoviesListActivity : AppCompatActivity(), MoviesAdapter.Interaction {

    private lateinit var binding: ActivityItemListBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_list)


        binding.listHor.adapter =
            MoviesAdapter(getDummyMoviesList1(), MoviesAdapter.ListOrientation.HORIZONTAL, this)
        binding.listVer.adapter =
            MoviesAdapter(getDummyMoviesList2(), MoviesAdapter.ListOrientation.VERTICAL, this)

    }

    override fun onItemSelected(item: Movie, view: View) {
        val options = ActivityOptions.makeSceneTransitionAnimation(
            this,
            view,
            item.title // The transition name to be matched in Activity B.
        )

        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("movie", item)
        startActivity(intent, options.toBundle())
    }
}