package com.example.a086_roomdatabase.view.route

import com.example.a086_roomdatabase.R

object DestinasiEditSiswa: DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "idSiswa"
    val routeWithIdArgs = "$route/{$itemIdArg}"
}