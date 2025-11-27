package com.example.a086_roomdatabase.room

interface SiswaDao {
    @Query("SELECT * from tblSiswa ORDER BY nama ASC")
}