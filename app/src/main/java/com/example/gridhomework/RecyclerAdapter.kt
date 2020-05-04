
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gridhomework.ItemModel
import com.example.gridhomework.R
import kotlinx.android.synthetic.main.item_recyclerview_layout.view.*
import kotlinx.android.synthetic.main.item_second_recyclerview_layout.view.*

class RecyclerAdapter(private val items: ArrayList<ItemModel>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val MAIN_ITEM = 1
        const val SECONDARY_ITEM = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == MAIN_ITEM)
            return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_layout, parent, false))
        else
            return SecondaryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_second_recyclerview_layout, parent, false))
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MainViewHolder)
            holder.onBind()
        else if(holder is SecondaryViewHolder)
            holder.onBind()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var model: ItemModel

        fun onBind() {
            model = items[adapterPosition]
            itemView.imageView.setImageResource(model.image)
            itemView.titleTextView.text = model.title
        }
    }

    inner class SecondaryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private lateinit var model: ItemModel

        fun onBind() {
            model = items[adapterPosition]
            itemView.secondaryImageView.setImageResource(model.image)
            itemView.secondTitleTextView.text = model.title
        }
    }

    override fun getItemViewType(position: Int): Int {
        val model = items[position]

        if(model.title == "different") {
            return SECONDARY_ITEM
        }

        return MAIN_ITEM
    }
}