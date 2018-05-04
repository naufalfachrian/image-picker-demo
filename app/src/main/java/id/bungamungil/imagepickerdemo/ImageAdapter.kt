package id.bungamungil.imagepickerdemo

import android.net.Uri
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_image.view.*

class ImageAdapter(private val onItemViewClicked: OnItemViewClicked? = null) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    val items = ArrayList<Uri>()

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_image
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count() + 1
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val url = items.getOrNull(position)
        if (url != null) {
            Picasso.get().load(url).resize(120, 120).centerCrop().into(holder.itemView.image)
        } else {
            holder.itemView.image.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context, R.drawable.ic_add_circle_outline_black_24dp))
        }
        holder.itemView.setOnClickListener {
            onItemViewClicked?.onItemViewClicked(position, it)
        }
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface OnItemViewClicked {
        fun onItemViewClicked(position: Int, itemView: View)
    }

}
