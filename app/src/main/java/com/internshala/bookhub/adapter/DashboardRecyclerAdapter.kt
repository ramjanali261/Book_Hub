package com.internshala.bookhub.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.internshala.bookhub.R
import com.internshala.bookhub.activity.DescriptionActivity
import com.internshala.bookhub.model.Book
import com.squareup.picasso.Picasso

class DashboardRecyclerAdapter(val context:Context,val itemList:ArrayList<Book>) : RecyclerView.Adapter<DashboardRecyclerAdapter.DashBoardViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)
        return DashBoardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashBoardViewHolder, position: Int) {
        val book=itemList[position]
        holder.textBookName.text=book.bookname
        holder.textBookAuthor.text=book.bookAuthor
        holder.textBookRating.text=book.bookRating
        holder.textBookCost.text=book.bookPrice
        /*holder.imgBookImage.setImageResource(book.bookImage)*/
        Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.imgBookImage)

        holder.llContent.setOnClickListener{
            val intent=Intent(context,DescriptionActivity::class.java)
            intent.putExtra("book_id",book.bookId)
            context.startActivity(intent)
        }

    }
      class DashBoardViewHolder(view:View):RecyclerView.ViewHolder(view){
          val textBookName:TextView=view.findViewById(R.id.txtBookName)
          val textBookAuthor:TextView=view.findViewById(R.id.txtBookAuthor)
          val textBookCost:TextView=view.findViewById(R.id.txtBookPrice)
          val textBookRating:TextView=view.findViewById(R.id.txtBookRating)
          val imgBookImage:ImageView=view.findViewById(R.id.imgBookImage)
          val llContent:LinearLayout=view.findViewById(R.id.llContent)
      }
}

