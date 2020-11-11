package com.example.jiraclone.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.jiraclone.R
import kotlinx.android.synthetic.main.view_card.view.*

class CustomCardView (context: Context, attrs: AttributeSet):
    LinearLayout(context, attrs){

    init {
        inflate(context, R.layout.view_card, this)

        val cardText : TextView = findViewById(R.id.card_text)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomCardView)
        cardText.text = attributes.getString(R.styleable.CustomCardView_text)
        attributes.recycle()
    }

    fun setCardText(value : String){
        card_text.text = value
    }

   @BindingAdapter("textInput")
    fun setCardTextBinding(cardView : CustomCardView, textInput: String){
       cardView.card_text.text = textInput
    }
}
