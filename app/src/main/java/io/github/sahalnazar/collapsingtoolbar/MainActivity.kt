package io.github.sahalnazar.collapsingtoolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.appbar.AppBarLayout
import io.github.sahalnazar.collapsingtoolbar.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var simpleAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        setupRecyclerItemClickListener()

        setAppBarChangeListener()

    }

    private fun setAppBarChangeListener() {
        var isShow = true
        var scrollRange = -1
        binding.appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->

            if (scrollRange == -1) {
                scrollRange = barLayout?.totalScrollRange!!
            }

            if (scrollRange + verticalOffset == 0) {
                binding.collapsingToolbarLayout.title = "Helloo!"
                isShow = true
            } else if (isShow) {
                binding.collapsingToolbarLayout.title =
                    " " //careful there should a space between double quote otherwise it wont work
                isShow = false
            }

            binding.detailDescription.alpha = 1.0f - abs(
                verticalOffset / binding.appBarLayout.totalScrollRange
                    .toFloat()
            )

            binding.detailTitle.alpha = 1.0f - abs(
                verticalOffset / binding.appBarLayout.totalScrollRange
                    .toFloat()
            )
        })
    }

    private fun setupRecyclerItemClickListener() {
        simpleAdapter.onClickListener { position ->

            when (position) {

                0 -> {
                    Toast.makeText(this, "Clicked Position: 0", Toast.LENGTH_SHORT)
                        .show()
                }

                1 -> {
                    Toast.makeText(this, "Clicked Position: 1", Toast.LENGTH_SHORT)
                        .show()
                }

                2 -> {
                    Toast.makeText(this, "Clicked Position: 2", Toast.LENGTH_SHORT)
                        .show()
                }
                3 -> {
                    Toast.makeText(this, "Clicked Position: 3", Toast.LENGTH_SHORT)
                        .show()
                }
                4 -> {
                    Toast.makeText(this, "Clicked Position: 4", Toast.LENGTH_SHORT)
                        .show()
                }
                5 -> {
                    Toast.makeText(this, "Clicked Position: 5", Toast.LENGTH_SHORT)
                        .show()
                }
                6 -> {
                    Toast.makeText(this, "Clicked Position: 6", Toast.LENGTH_SHORT)
                        .show()
                }
                7 -> {
                    Toast.makeText(this, "Clicked Position: 7", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun setupRecyclerView() {
        simpleAdapter = RecyclerViewAdapter(this)
        binding.recyclerView.apply {
            adapter = simpleAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }

        simpleAdapter.differ.submitList(getData())
    }
}