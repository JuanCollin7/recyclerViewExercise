package com.jc.recyclerexercise.ui.photos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.databinding.PhotosFragmentBinding
import com.jc.recyclerexercise.models.Photo

class PhotosFragment : Fragment(), ItemClickListener<Photo> {

    private var _binding: PhotosFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter = PhotoListAdapter(this)

    companion object {
        fun newInstance() = PhotosFragment()
    }

    private val viewModel: PhotosViewModel by lazy {
        ViewModelProvider(this)[PhotosViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding = PhotosFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.photoList.adapter = adapter

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.photos.observe(viewLifecycleOwner) { photos ->
            photos.let {
                adapter.data = photos
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(item: Photo) {
        startActivity(PhotoDetailActivity.getInstance(requireContext(), item))
    }
}