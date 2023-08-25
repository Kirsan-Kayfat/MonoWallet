package com.shuchenysh.monowallet.screens.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shuchenysh.monowallet.RecyclerViewAdapter
import com.shuchenysh.monowallet.WalletsActivity
import com.shuchenysh.monowallet.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var months: List<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        months = listOf(
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        )

        adapter = RecyclerViewAdapter()
        with(binding) {
            transactionsHomeList.adapter = adapter
            openWalletsHomeButton.setOnClickListener {
                val intent = Intent(this@HomeFragment.context, WalletsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}