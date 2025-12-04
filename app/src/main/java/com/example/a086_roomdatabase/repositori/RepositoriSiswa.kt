package com.example.a086_roomdatabase.repositori

import com.example.a086_roomdatabase.room.Siswa
import com.example.a086_roomdatabase.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>

    suspend fun insertSiswa(siswa: Siswa)

    fun getSiswaStream(id:Int): Flow<Siswa?>

    suspend fun deleteSiswa(siswa: Siswa)
}

class OffLineRepositoriSiswa(
    private val siswaDao: SiswaDao
): RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao
        .getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao
        .insert(siswa)
}
