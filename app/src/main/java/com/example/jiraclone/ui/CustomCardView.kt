package com.example.jiraclone.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.example.jiraclone.R
import kotlinx.android.synthetic.main.view_card.view.*

class CustomCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : CardView(context, attrs, defStyleAttr){

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.view_card, this, true)
        this.radius = 20F
    }

    fun setCardText(value : String){
        card_text.text = value
    }

   @BindingAdapter("textInput")
    fun setCardTextBinding(cardView : CustomCardView, textInput: String){
       cardView.card_text.text = textInput
    }
}
