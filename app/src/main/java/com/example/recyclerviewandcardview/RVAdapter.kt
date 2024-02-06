package com.example.recyclerviewandcardview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

//androide özgü işlemleri classlara bağımlı kalmadan kullanmak için bunu parametre olarak verdik (toast msg. gibi vb.)
class RVAdapter (private val mContext : Context, private val countryList : List<Countries>,private val spaceBetweenItems: Int)
    :RecyclerView.Adapter<RVAdapter.CardViewDesignObjectHolder>(){
//bu aşamada ise adapter ile malum RV yapımızı eşlemiş olduk. Bunu farklı class üzerinde de yapabilirdik ancak kod ve class kalabalıklığı olmasın diye böyle yaptık!



    //viewler arası eşlemeyi böylece yapmış olduk
    inner class CardViewDesignObjectHolder(view: View):RecyclerView.ViewHolder(view){
        var cardView : CardView
        var textView : TextView
        var moreIcon : ImageView

        //kullanacağımız görsel nesneleri (java constructor this yapısına bezner şekilde) tanımladık
        init {
            cardView = view.findViewById(R.id.cardView)
            textView = view.findViewById(R.id.textView)
            moreIcon = view.findViewById(R.id.moreIcon)
        }

    }
    //RV yapısında kullanacağımız görsel neslere erişmek istiyor.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewDesignObjectHolder {

        //inflate --> 3 parametre ister, 1- tasarımın dosyası, 2-yazılımsal tasarımı ister, 3- başka tasarım bağlanacak mı bağlanmayacak mı
        val design = LayoutInflater.from(mContext).inflate(R.layout.cardview_design, parent, false)

        return CardViewDesignObjectHolder(design)
    }

    //kullanacağım tasarımdan kaç tane görünüm kullanacağımızı belirtmeliyiz --> ona göre RV yapısı kuran
    override fun getItemCount(): Int {
        return  countryList.size
    }

    //hangi veriyi hangi tasarım üzerindeki görsel nesneye aktaracağımızı belirlediğimiz kısım da burada ayarlanıyor (veri kümeleri aktarma işlemleri)
    override fun onBindViewHolder(holder: CardViewDesignObjectHolder, position: Int) {
        //holder : sınıftan aldığımız görsel nesneleri tutacak
        //position ise bir döngü gibi indeksleri içerik miktarına göre dönmektedir
        val country = countryList[position]
        holder.textView.text = country.countryName

        // itemler arasına boşluk eklemek için aşağıdaki kodu kullandım
        val layoutParams = holder.itemView.layoutParams as RecyclerView.LayoutParams
        layoutParams.bottomMargin = spaceBetweenItems

        // İlk item'e boşluk eklemek istemedim
        if (position == 0) {
            layoutParams.topMargin = 0
        } else {
            layoutParams.topMargin = spaceBetweenItems
        }

        holder.itemView.layoutParams = layoutParams

        //tıklanınca gerçekleşmesini istediğimiz özellikleri de burada belirtiyoruz.
        holder.cardView.setOnClickListener{
            Toast.makeText(mContext , "Chosen Country : ${country.countryName}" , Toast.LENGTH_SHORT).show()
        }



    }


}