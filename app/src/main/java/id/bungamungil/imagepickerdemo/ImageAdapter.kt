package id.bungamungil.imagepickerdemo

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_image.view.*

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_image
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.itemView.image.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context, R.drawable.ic_add_circle_outline_black_24dp))
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
