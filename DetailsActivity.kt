package com.modos.persianflix

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_photo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailsActivity : FragmentActivity() {

    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val intent: Intent = getIntent()
        val bundle  = intent.getBundleExtra("bundle")

        val text: TextView = findViewById(R.id.text_detail)

        val bio: String = bundle?.getParcelable<ParcelableObject>("key")?.bio.toString()
        name = bundle?.getParcelable<ParcelableObject>("key")?.name.toString()

        text.setText(bio)

        getAlbum()

    }

    private fun getAlbum(){

        val call: Call<List<PhotoModel>> = ApiClient.getClient.getPhoto()
        call.enqueue(object : Callback<List<PhotoModel>> {

            override fun onResponse(
                call: Call<List<PhotoModel>>?,
                response: Response<List<PhotoModel>>?
            ) {
                for (item in response?.body()!!){
                    if (item.name.equals(name)){

                        Picasso.get()
                            .load(item.url)
                            .placeholder(R.color.colorPrimary)
                            .error(R.color.colorAccent)
                            .fit()
                            .into(photo_frag)
                    }
                }

            }

            override fun onFailure(call: Call<List<PhotoModel>>?, t: Throwable?) {
            }
        })
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.no_animation, R.anim.slide_down)
    }
}
