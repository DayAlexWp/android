package com.wccnet.addnamesavedata2.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.wccnet.addnamesavedata2.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private var names: String = ""

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.submitButton.setOnClickListener { //when submit button is pressed
            viewModel.addName(binding.nameInput.text.toString() ) //adds user input to viewModel
        }

        val resultObserver = Observer<String> {
            result -> binding.namesBox.text = result.toString()
        }

        viewModel.getNames().observe(viewLifecycleOwner, resultObserver)

        return binding.root
    }

    //the internet nerds say you need this :)
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}