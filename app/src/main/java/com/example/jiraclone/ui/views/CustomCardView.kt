package com.example.jiraclone.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.R
import com.example.jiraclone.databinding.ViewCardBinding

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
    cardView.binding?.cardText?.text = textInput
}