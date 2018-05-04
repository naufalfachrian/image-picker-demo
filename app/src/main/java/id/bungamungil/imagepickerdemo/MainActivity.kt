package id.bungamungil.imagepickerdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ImageAdapter.OnItemViewClicked {

    private val adapter = ImageAdapter(this)

    private val imagePickerRequest = 42

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }

    override fun onItemViewClicked(position: Int, itemView: View) {
        if (position == adapter.itemCount - 1) {
            val imagePicker = Intent(Intent.ACTION_PICK)
            imagePicker.type = "image/*"
            startActivityForResult(imagePicker, imagePickerRequest)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            imagePickerRequest -> handleImagePickerResult(resultCode, data)
        }
    }

    private fun handleImagePickerResult(resultCode: Int, data: Intent?) {
        val contentUrl = data?.data
        if (resultCode != Activity.RESULT_OK || contentUrl == null) return
        adapter.items.add(contentUrl)
        adapter.notifyDataSetChanged()
    }
}
