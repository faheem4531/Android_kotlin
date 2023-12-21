package com.example.navmanuapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navmanuapp.R
import com.example.navmanuapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    //declearation
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private val dataList = mutableListOf("")


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Add hobby
        val btnAddHoby = root.findViewById<Button>(R.id.btnAddHobby)
        val hobby = root.findViewById<EditText>(R.id.addHobby)

        btnAddHoby.setOnClickListener {
            val newHobby = hobby.text.toString().trim()
            if (newHobby.isNotEmpty()) {
                dataList.add(newHobby)
                adapter.notifyDataSetChanged() // Update the ListView
                hobby.text.clear()
            }
            else{
                Toast.makeText(requireContext(), "Enter you hobby", Toast.LENGTH_SHORT).show()
            }
        }


        //Apply Adapter
        listView = root.findViewById(R.id.hobbiesList) // Using the ID from your XML layout
        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, dataList)
        listView.adapter = adapter



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


