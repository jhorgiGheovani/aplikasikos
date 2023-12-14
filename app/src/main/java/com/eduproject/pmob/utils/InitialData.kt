package com.eduproject.pmob.utils

import com.eduproject.pmob.data.entity.MainEntity

object InitialData {

    fun listKosan(): List<MainEntity>{
        return listOf(
            MainEntity(
                1,
                "Kosan Delima",
                "Jalan beringharso no 13",
                "AC, Kulkas, Ruang Jemur",
                "gambar1",
                -7.8256995,
                110.3904599
            ),
            MainEntity(
                2,
                "Kost Melati",
                "Jalan cendana no 11",
                "AC, Tv, Kulkas",
                "img_2",
                -7.8256995,
                110.3904599
            ),
            MainEntity(
                3,
                "Kost Arjuna",
                "Jalan kasihan no 2",
                "AC, Halaman",
                "img_3",
                -7.8256995,
                110.3904599
            ),
            MainEntity(
                4,
                "Kost Pakde",
                "Jalan Samudra no 32",
                "AC, Tv, Kulkas",
                "img_4",
                -7.8256995,
                110.3904599
            ),
            MainEntity(
                5,
                "Kost Dwi",
                "Gang Delima no 3",
                "Kipas, Kulkas",
                "img_5",
                -7.8256995,
                110.3904599
            ),
            MainEntity(
                6,
                "Kost Dea",
                "Ringroad utara Jogja",
                "Tv, Parkiran",
                "img_6",
                -7.8256995,
                110.3904599
            )
        )
    }
}