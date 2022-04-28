package com.jc.recyclerexercise.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.databinding.MainFragmentBinding
import com.jc.recyclerexercise.databinding.UsersFragmentBinding
import com.jc.recyclerexercise.ui.albums.AlbumsActivity
import com.jc.recyclerexercise.ui.comments.CommentsActivity
import com.jc.recyclerexercise.ui.photos.PhotosActivity
import com.jc.recyclerexercise.ui.posts.PostsActivity
import com.jc.recyclerexercise.ui.todos.ToDosActivity
import com.jc.recyclerexercise.ui.users.UsersActivity

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.comments.setOnClickListener {
            startActivity(CommentsActivity.getInstance(requireContext()))
        }
        binding.posts.setOnClickListener {
            startActivity(PostsActivity.getInstance(requireContext()))
        }
        binding.todos.setOnClickListener {
            startActivity(ToDosActivity.getInstance(requireContext()))
        }
        binding.users.setOnClickListener {
            startActivity(UsersActivity.getInstance(requireContext()))
        }
        binding.albums.setOnClickListener {
            startActivity(AlbumsActivity.getInstance(requireContext()))
        }
        binding.photos.setOnClickListener {
            startActivity(PhotosActivity.getInstance(requireContext()))
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.users.observe(viewLifecycleOwner) { users ->
            Log.v("Bandalhera", users.toString())
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}