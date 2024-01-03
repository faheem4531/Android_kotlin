package com.example.navmanuapp.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    //declearation
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private val dataList = mutableListOf("")

    private lateinit var dbRef : DatabaseReference

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

        Log.d("YourFragment", "onCreateView")

        //Add hobby
        val btnAddHoby = root.findViewById<Button>(R.id.btnAddHobby)
        val hobby = root.findViewById<EditText>(R.id.addHobby)

        val userId=FirebaseAuth.getInstance().currentUser?.uid
        dbRef=FirebaseDatabase.getInstance().getReference("Signup").child(userId.toString()).child("hobbies")


        btnAddHoby.setOnClickListener {
            val newHobby = hobby.text.toString().trim()
            if (newHobby.isNotEmpty()) {

                dbRef.push().setValue(newHobby)
                    .addOnSuccessListener {
                        Toast.makeText(requireContext(), "sucess", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(requireContext(), "fail", Toast.LENGTH_SHORT).show()
                    }

                dataList.add(newHobby)
                adapter.notifyDataSetChanged() // Update the ListView
                hobby.text.clear()
            }
            else{
                Toast.makeText(requireContext(), "Enter you hobby", Toast.LENGTH_SHORT).show()
            }
        }

        //fetch hobbies from db and store in an array
       if (userId != null){

           dbRef.addValueEventListener(object : ValueEventListener {
               override fun onDataChange(snapshot: DataSnapshot) {
                   dataList.clear()
                   for (hobbySnapshot in snapshot.children) {
                       val currentHobby = hobbySnapshot.getValue(String::class.java)
                       if (currentHobby != null ) {
                           dataList.add(currentHobby)
                       }
                   }
                   adapter.notifyDataSetChanged()
               }


               override fun onCancelled(error: DatabaseError) {
                   // Handle onCancelled
                   Log.e("Firebase", "Error: ${error.message}")
               }

           })
       }


        //Apply Adapter
        listView = root.findViewById(R.id.hobbiesList) // Using the ID from your XML layout
        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, dataList)
        listView.adapter = adapter


        return root
    }

//    override fun onStart() {
//        super.onStart()
//        Log.d("YourFragment", "onStart")
//    }

    override fun onResume() {
        super.onResume()
        Log.d("YourFragment", "onResume")
    }

//    override fun onPause() {
//        super.onPause()
//        Log.d("YourFragment", "onPause")
//    }

//    override fun onStop() {
//        super.onStop()
//        Log.d("YourFragment", "onStop")
//    }

//    override fun onDetach() {
//        super.onDetach()
//        Log.d("YourFragment", "onDetach")
//    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        Log.d("YourFragment", "onDestroy")
//        _binding = null
//    }
}


