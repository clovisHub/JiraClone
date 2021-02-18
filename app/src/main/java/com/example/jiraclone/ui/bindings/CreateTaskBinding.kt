package com.example.jiraclone.ui.bindings

import android.widget.AdapterView
import android.widget.Spinner
import androidx.databinding.BindingAdapter

@BindingAdapter("entries")
fun Spinner.setEntries(entries: List<Any>?) {
    //setSpinnerEntries(entries)
}

//@BindingAdapter("onItemSelected")
//fun Spinner.setItemSelectedListener(itemSelectedListener: AdapterView.OnItemSelectedListener?) {
//    setSpinnerItemSelectedListener(itemSelectedListener)
//}

@BindingAdapter("newValue")
fun Spinner.setNewValue(newValue: Any?) {
    //this.setValue(selectedValue)
}