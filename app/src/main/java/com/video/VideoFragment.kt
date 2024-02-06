package com.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.video.data.VideoData
import com.videoapplication.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {

    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!
    private var adapter : VideoAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val viewModel = ViewModelProvider(this)[VideoViewModel::class.java]

        viewModel.videos.observe(viewLifecycleOwner) {
            updateAdapter(it)
        }

        setupRecyclerView()

        val searchView: SearchView = binding.fragmentVideoSearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.getVideos(query!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.getVideos(newText!!)
                return true
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        val rv: RecyclerView = binding.rvVideo
        rv.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false
        )
        rv.adapter = adapter
    }

    private fun updateAdapter(deals: List<VideoData>) {
        adapter?.updateDataSet(deals)
    }
}