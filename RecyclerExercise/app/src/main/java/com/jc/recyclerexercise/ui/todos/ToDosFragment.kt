package com.jc.recyclerexercise.ui.todos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jc.recyclerexercise.ItemClickListener
import com.jc.recyclerexercise.databinding.TodosFragmentBinding
import com.jc.recyclerexercise.models.ToDoItem

class ToDosFragment : Fragment(), ItemClickListener<ToDoItem> {

    private var _binding: TodosFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter = ToDoListAdapter(this)

    companion object {
        fun newInstance() = ToDosFragment()
    }

    private val viewModel: ToDosViewModel by lazy {
        ViewModelProvider(this)[ToDosViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding = TodosFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.todoList.adapter = adapter

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.items.observe(viewLifecycleOwner) { items ->
            items.let {
                adapter.data = items
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(item: ToDoItem) {
        startActivity(ToDoDetailActivity.getInstance(requireContext(), item))
    }
}