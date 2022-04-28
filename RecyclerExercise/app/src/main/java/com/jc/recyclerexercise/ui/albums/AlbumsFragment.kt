package com.jc.recyclerexercise.ui.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.databinding.AlbumsFragmentBinding
import com.jc.recyclerexercise.models.Album

class AlbumsFragment : Fragment(), ItemClickListener<Album> {

    private var _binding: AlbumsFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter = AlbumListAdapter(this)

    companion object {
        fun newInstance() = AlbumsFragment()
    }

    private val viewModel: AlbumsViewModel by lazy {
        ViewModelProvider(this)[AlbumsViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding = AlbumsFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.albumList.adapter = adapter

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.albums.observe(viewLifecycleOwner) { items ->
            items.let {
                adapter.data = items
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(item: Album) {
        startActivity(AlbumDetailActivity.getInstance(requireContext(), item))
    }
}