package com.example.my_finance.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.my_finance.R
import com.example.my_finance.model.Portfolio

class PortfolioAdapter(context: Context, resource: Int) : ArrayAdapter<Portfolio?>(context, resource) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.portfolio_item, parent, false)
        }

        val portfolio = getItem(position)
        val nameTextView = itemView!!.findViewById<TextView>(R.id.text_view_portfolio_name)
        val costTextView = itemView.findViewById<TextView>(R.id.text_view_portfolio_cost)
        val quantityTextView = itemView.findViewById<TextView>(R.id.text_view_portfolio_quantity)

        nameTextView.text = portfolio?.name
        costTextView.text = portfolio?.value.toString()
        quantityTextView.text = portfolio?.stocks?.size.toString()

        return itemView
    }
}
