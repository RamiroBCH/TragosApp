package com.g.tragosapp.data

import com.g.tragosapp.data.model.Drink
import com.g.tragosapp.vo.Resource

class Datasource {
    val generateTragosList = Resource.Success(listOf(
        Drink("https://cdn5.recetasdeescandalo.com/wp-content/uploads/2018/09/Coctel-margarita-como-prepararlo.-Receta-e-ingredientes.jpg","Margarita","Con azucar, vodka y nueces"),
        Drink("https://www.recetas-argentinas.com/base/stock/Recipe/2-image/2-image_web.jpg","Fernet","Fernet con coca y 2 hielos"),
        Drink("https://pbs.twimg.com/media/CERSHJwXIAATqjl.jpg","Toro","Toro con pritty"),
        Drink("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ76Mpj47jE9UPHpspDqtM8qAjvDIFetCdNxQ&usqp=CAU","Gancia","Gancia con sprite")
    ))


}