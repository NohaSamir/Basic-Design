package com.amg.task1.ui

import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amg.task1.model.Movie
import com.amg.task1.R
import com.amg.task1.databinding.ActivityItemDetailBinding
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        val movie = intent.getParcelableExtra("movie") as Movie

        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

        findViewById<View>(android.R.id.content).transitionName = movie.title

        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementEnterTransition = MaterialContainerTransform()
            .apply {
                addTarget(android.R.id.content)
                duration = 300
            }
        window.sharedElementReturnTransition = MaterialContainerTransform()
            .apply {
                addTarget(android.R.id.content)
                duration = 250
            }

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_detail)
        binding.movie = movie

        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
}