package com.example.nasawalebhaiya

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nasawalebhaiya.adapter.RecyclerViewAdapter
import com.example.nasawalebhaiya.models.RecyclerData
import com.example.nasawalebhaiya.viewModel.MainActivityViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [RecyclerListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecyclerListFragment : Fragment() {
    private lateinit var recyclerAdapter: RecyclerViewAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_recycler_list, container, false)
        initViewModel(view)
        initViewModel()
        return view
    }
    private fun initViewModel(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)
        recyclerAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerAdapter
    }
    @SuppressLint("FragmentLiveDataObserve")
    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecyclerListObserver().observe(this, Observer<RecyclerData> {
            if(it!=null){
                recyclerAdapter.setUpdateData(it.photos)
            }else{
                Toast.makeText(activity, "Error in getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            RecyclerListFragment()
    }
}