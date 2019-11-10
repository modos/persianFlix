package com.modos.persianflix

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : FragmentActivity() {

    lateinit var progressBar: ProgressBar
    var dataList = ArrayList<DataModel>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter= DataAdapter(dataList,this)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        progressBar = findViewById(R.id.progress_bar)
        progressBar.visibility = View.VISIBLE
        getData()


    }

    private fun getData(){
        val call: Call<List<DataModel>> = ApiClient.getClient.getFile()
        call.enqueue(object : Callback<List<DataModel>>{

            override fun onResponse(
                call: Call<List<DataModel>>?,
                response: Response<List<DataModel>>?
            ) {
                progressBar.visibility = View.INVISIBLE
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                progressBar.visibility = View.GONE
            }
        })
    }

    fun onAboutButtonClick() {
        startActivity(Intent(this, AboutActivity::class.java))
        overridePendingTransition(R.anim.no_animation, R.anim.slide_down)
    }

}
