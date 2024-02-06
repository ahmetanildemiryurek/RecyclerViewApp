package com.example.recyclerviewandcardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewandcardview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var countriesList: ArrayList<Countries>
    private lateinit var adapter: RVAdapter
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //RecyclerView'ın boyutlarındaki değişikliklere karşı optimize edilmesini sağlar.
        //Bu metodu kullanarak RecyclerView'a, içindeki item'ların boyutları değişmeyecekse, yani sabit ve belirli bir boyutta kalacaksa bunu bildirebiliriz.
        binding.rv.setHasFixedSize(true)
        //LayoutManager -> türleri
        binding.rv.layoutManager = LinearLayoutManager(this)
        //rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        //rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)

        val c1 = Countries(1, "TURKEY")
        val c2 = Countries(2, "ITALY")
        val c3 = Countries(3, "ABD")
        val c4 = Countries(4, "GERMANY")
        val c5 = Countries(5, "PORTUGAL")

        countriesList = ArrayList<Countries>()
        countriesList.add(c1)
        countriesList.add(c2)
        countriesList.add(c3)
        countriesList.add(c4)
        countriesList.add(c5)

        //oluşturduğumuz adapterin içine arraylist olarak tanımladıklarımızı eşlemiş ve eklemiş olduk
        adapter = RVAdapter(this,countriesList,10)

        binding.rv.adapter=adapter


    }
}