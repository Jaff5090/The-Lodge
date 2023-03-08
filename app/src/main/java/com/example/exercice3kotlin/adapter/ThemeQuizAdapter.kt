package com.example.exercice3kotlin.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exercice3kotlin.activities.QuizThemeViewModel
import com.example.exercice3kotlin.R
import com.example.exercice3kotlin.activities.QuestionsActivity

class ThemeQuizAdapter(private val mList: List<QuizThemeViewModel>) : RecyclerView.Adapter<ThemeQuizAdapter.ViewHolder>() {
    private lateinit var onClickListener: OnClickListener

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_theme_quiz, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, QuestionsActivity::class.java)
            intent.putExtra("themeName", ItemsViewModel.themeName)
            holder.itemView.context.startActivity(intent)
        }


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imagethemequiz)
        val textView: TextView = itemView.findViewById(R.id.TypeOfQuizz)
    }

    fun setOnClickListener(listener: OnClickListener) {
        onClickListener = listener
    }

    interface OnClickListener {
        fun onClick(position: Int)
    }
}
