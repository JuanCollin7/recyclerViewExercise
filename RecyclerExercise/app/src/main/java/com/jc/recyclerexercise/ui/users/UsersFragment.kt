package com.jc.recyclerexercise.ui.users

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.R
import com.jc.recyclerexercise.databinding.UsersFragmentBinding
import com.jc.recyclerexercise.models.User

class UsersFragment : Fragment(), ItemClickListener<User> {

    private var _binding: UsersFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter = UserListAdapter(this)

    companion object {
        fun newInstance() = UsersFragment()
    }

    private val viewModel: UsersViewModel by lazy {
        ViewModelProvider(this)[UsersViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding = UsersFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.userList.adapter = adapter

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.users.observe(viewLifecycleOwner) { users ->
            users.let {
                adapter.data = users
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(item: User) {
        startActivity(UserDetailActivity.getInstance(requireContext(), item))
    }
}