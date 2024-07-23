package com.example.yomicepa.homeScreen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yomicepa.databinding.ReturnRequestCardBinding
import com.example.yomicepa.models.ReturnRequestListResponse
import kotlinx.coroutines.CoroutineScope
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ReturnRequestAdapter(private val returnRequestListResponse: ReturnRequestListResponse,
                           val delegation: Delegation
): RecyclerView.Adapter<ReturnRequestAdapter.ReturnRequestHolder>(){
    private lateinit var cardRequestBinding:ReturnRequestCardBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ReturnRequestHolder {
        cardRequestBinding = ReturnRequestCardBinding.inflate( LayoutInflater.from(parent.context),parent,false)
        return ReturnRequestHolder(cardRequestBinding)
    }

    override fun onBindViewHolder(holder: ReturnRequestHolder, position: Int) {
        var content = returnRequestListResponse.content[position]
        holder.cardBinding.id.text = content.returnRequest.id.toString()
        holder.cardBinding.createdAt.text = convertTimeStampToDateFormat(content.returnRequest.createdAt)
        holder.cardBinding.noOfItems.text = content.numberOfItems.toString()
        holder.cardBinding.status.text = content.returnRequest.returnRequestStatus
        holder.cardBinding.serviceType.text = content.returnRequest.serviceType
        holder.cardBinding.noOfItems.setOnClickListener{
            delegation.gotoItemsScreen(content.returnRequest.id)
        }
    }

    override fun getItemCount(): Int {
        return returnRequestListResponse.content.size
    }
    private fun convertTimeStampToDateFormat(timestamp:String): String {
        val timestampMillis = timestamp.toLong()
        val date = Date(timestampMillis)
        val dateFormat = SimpleDateFormat("HH:mm:ss dd-MM-yyyy", Locale.getDefault())
        return dateFormat.format(date)
    }
    class ReturnRequestHolder(val cardBinding: ReturnRequestCardBinding) : RecyclerView.ViewHolder(cardBinding.root)
}

