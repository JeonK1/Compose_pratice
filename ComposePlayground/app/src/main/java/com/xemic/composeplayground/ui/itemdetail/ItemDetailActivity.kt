package com.xemic.composeplayground.ui.itemdetail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import com.xemic.composeplayground.data.ItemInfoListSample

class ItemDetailActivity : ComponentActivity() {
    companion object {
        const val ITEM_NO = "item_no"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val intent = (LocalContext.current as ItemDetailActivity).intent
            val itemNo = intent.getIntExtra(ITEM_NO, -1)
            ItemInfoListSample.find { it.itemNo == itemNo }?.let { itemInfo ->
                ItemDetailScreen(itemInfo = itemInfo)
            }
        }
    }
}