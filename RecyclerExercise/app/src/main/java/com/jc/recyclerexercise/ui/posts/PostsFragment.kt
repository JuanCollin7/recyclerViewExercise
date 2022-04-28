package com.jc.recyclerexercise.ui.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.databinding.PostsFragmentBinding
import com.jc.recyclerexercise.models.Post
import com.jc.recyclerexercise.ui.photos.PhotoDetailActivity

class PostsFragment : Fragment(), ItemClickListener<Post> {

    private var _binding: PostsFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter = PostListAdapter(this)

    companion object {
        fun newInstance() = PostsFragment()
    }

    private val viewModel: PostsViewModel by lazy {
        ViewModelProvider(this)[PostsViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding = PostsFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.postList.adapter = adapter

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.posts.observe(viewLifecycleOwner) { posts ->
            posts.let {
                adapter.data = posts
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(item: Post) {
        startActivity(PostDetailActivity.getInstance(requireContext(), item))
    }
}