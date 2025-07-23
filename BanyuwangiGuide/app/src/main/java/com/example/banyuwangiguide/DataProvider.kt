package com.example.banyuwangiguide

object DataProvider {
    val placeList = listOf(
        Place(
            1,
            "Kawah Ijen",
            "Gunung dengan fenomena blue fire yang langka di dunia",
            "Kecamatan Licin",
            R.drawable.ijen,
            "attraction"
        ),
        Place(
            2,
            "Pantai Pulau Merah",
            "Pantai dengan bukit kecil berwarna merah di tengahnya",
            "Kecamatan Pesanggaran",
            R.drawable.pulau_merah,
            "attraction"
        ),
        Place(
            3,
            "Taman Nasional Baluran",
            "Padang savana dengan panorama eksotis seperti Afrika",
            "Banyuputih",
            R.drawable.baluran,
            "attraction"
        ),
        Place(
            4,
            "Pantai Plengkung",
            "Pantai terkenal dengan ombaknya yang cocok untuk surfing",
            "Taman Nasional Alas Purwo",
            R.drawable.plengkung,
            "attraction"
        ),
        Place(
            5,
            "Air Terjun Kembar Tirtopuro",
            "Air terjun tersembunyi dengan pemandangan alam yang indah",
            "Kecamatan Licin",
            R.drawable.air_terjun_kembar,
            "hidden_gem"
        ),
        Place(
            6,
            "Teluk Ijo",
            "Pantai dengan air laut hijau jernih dan pasir putih alami",
            "Kecamatan Pesanggaran",
            R.drawable.teluk_ijo,
            "hidden_gem"
        ),
        Place(
            7,
            "Watu Dodol",
            "Batu besar di tepi jalan dengan mitos unik",
            "Jalan Banyuwangi - Situbondo",
            R.drawable.watu_dodol,
            "hidden_gem"
        ),
        Place(
            8,
            "Warung Sego Tempong Mbok Darmi",
            "Tempat makan legendaris dengan sambal super pedas",
            "Jalan Diponegoro",
            R.drawable.sego_tempong,
            "culinary"
        ),
        Place(
            9,
            "Rujak Soto Pak Udin",
            "Perpaduan unik antara rujak dan soto khas Banyuwangi",
            "Jalan Basuki Rahmat",
            R.drawable.rujak_soto,
            "culinary"
        ),
        Place(
            10,
            "Pecel Rawon Bu Joyo",
            "Kombinasi pecel dan rawon yang menggugah selera",
            "Jalan Ahmad Yani",
            R.drawable.pecel_rawon,
            "culinary"
        ),
        Place(
            11,
            "Festival Gandrung Sewu",
            "Pertunjukan tari massal Gandrung khas Banyuwangi",
            "Pantai Boom",
            R.drawable.gandrung_sewu,
            "event"
        ),
        Place(
            12,
            "Banyuwangi Ethno Carnival",
            "Karnaval budaya dengan kostum megah dan unik",
            "Kota Banyuwangi",
            R.drawable.ethno_carnival,
            "event"
        ),
        Place(
            13,
            "Tour de Ijen",
            "Ajang balap sepeda internasional dengan rute menantang",
            "Kawah Ijen",
            R.drawable.tour_de_ijen,
            "event"
        )
    )


    fun getPlacesByCategory(category: String) = placeList.filter { it.category == category }
}