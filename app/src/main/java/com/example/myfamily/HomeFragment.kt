package com.example.myfamily

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemMember = listOf<MemberModel>(
            MemberModel("Saurav Kumar","89%","123M"),
            MemberModel("Ashutosh Dubey","54%","143M"),
            MemberModel("Shubham Kumar","87%","432M"),
            MemberModel("Himanshu Kumar","7%","765M"),
            MemberModel("Raushan Kumar", "89%","54M")
        )
        val adapter = MemberAdapter(itemMember)
        val recycler = requireView().findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()

    }
}