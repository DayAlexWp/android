package com.wccnet.addnamesavedata.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.wccnet.addnamesavedata.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var debugNameList: String

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        //draws names to namesBox. pulls data from viewModel
        fun drawNames() {
            var formattedNames = formatNames(viewModel.getNames())
            binding.namesBox.text = formattedNames
            debugNameList = formattedNames
        }

        drawNames() //ensures that data is on screen after rotate

        binding.submitButton.setOnClickListener { //when submit button is pressed
            viewModel.addName(binding.nameInput.text.toString() ) //adds user input to viewModel
            drawNames()
        }

        return binding.root
    }

    //formats inputted array list as element + new line character
    private fun formatNames(names: ArrayList<String>): String {
        var formattedNames = ""
        for (eachName in names) formattedNames += "$eachName\n"
        return formattedNames
    }

    //the internet nerds say you need this :)
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}