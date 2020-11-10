package com.example.jiraclone.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.R
import com.example.jiraclone.databinding.ItemCardBinding

class CustomCard @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : CardView(context, attrs, defStyleAttr) {

    var cardTextView : TextView?= null

    init {
         DataBindingUtil.inflate<ItemCardBinding>(LayoutInflater.from(context),
             R.layout.item_card, this, true) .apply {
             cardTextView = cardTextId
         }
    }
}

@BindingAdapter("cardText")
fun setCardText(customCard: CustomCard, cardText: String? ="") {
    customCard.cardTextView?.text = cardText
}
