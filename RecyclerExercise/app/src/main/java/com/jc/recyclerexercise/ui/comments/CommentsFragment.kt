package com.jc.recyclerexercise.ui.comments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.databinding.CommentsFragmentBinding
import com.jc.recyclerexercise.models.Comment
import com.jc.recyclerexercise.ui.posts.PostDetailActivity

class CommentsFragment : Fragment(), ItemClickListener<Comment> {

    private var _binding: CommentsFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter = CommentListAdapter(this)

    companion object {
        fun newInstance() = CommentsFragment()
    }

    private val viewModel: CommentsViewModel by lazy {
        ViewModelProvider(this)[CommentsViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding = CommentsFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.commentList.adapter = adapter

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.comments.observe(viewLifecycleOwner) { comments ->
            comments.let {
                adapter.data = comments
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(item: Comment) {
        startActivity(CommentDetailActivity.getInstance(requireContext(), item))
    }
}