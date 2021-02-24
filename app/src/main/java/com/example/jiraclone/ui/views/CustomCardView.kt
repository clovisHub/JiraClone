package com.example.jiraclone.ui.views

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.R
import com.example.jiraclone.databinding.ViewCardBinding
import com.example.jiraclone.models.Task

class CustomCardView  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : CardView(context, attrs, defStyleAttr) {

    var binding: ViewCardBinding? = null

    init {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_card, this, true)
    }

    fun setCardText(value : String){
        binding?.cardText?.text = value
    }
}

@BindingAdapter("textInput")
fun setCardTextBinding(cardView : CustomCardView, textInput: String){
    cardView.binding?.cardText?.visibility = if (textInput.isEmpty()) View.GONE else View.VISIBLE
    cardView.binding?.cardText?.text = textInput
}

@BindingAdapter("imageInput")
fun setCardImageBinding(cardView : CustomCardView, imageInput: Drawable?){
    cardView.binding?.cardImage?.visibility = if (imageInput == null) View.GONE else View.VISIBLE
    cardView.binding?.cardImage?.setImageDrawable(imageInput)
}

@BindingAdapter("textSize")
fun setCardTextSizeBinding(cardView : CustomCardView, textInput: Int){
    cardView.binding?.cardText?.textSize = textInput.toFloat()
}

@BindingAdapter("trash")
fun setCardImageBinding(cardView : CustomCardView, isVisibleNot: Boolean = false){
    cardView.binding?.trashDelete?.visibility  = if (isVisibleNot) View.VISIBLE else View.GONE
}

@BindingAdapter("item", "task")
fun setCardBinding(cardView : CustomCardView, item: Trashable, task: Task){
    cardView.binding?.trashDelete?.setOnClickListener {
        item.onTrashClick(task)
    }
}

interface Trashable {
    fun onTrashClick(task: Task)
}
//@BindingAdapter("imageInput")
//fun setCardImageBinding(cardView : CustomCardView, imageInput: Drawable?){
//    cardView.binding?.
//}