package mx.edu.ittepic.ladm_u4_practica2

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo (p:MainActivity): View(p){

    var puntero = p
    var altoCanvas =0
    var anchoCanvas =0

    // Objetos/Figuras

    var sol = Figura(1080,0,200)
    var icono = Figura(400,1150,BitmapFactory.decodeResource(resources,R.drawable.gato))

    override fun onDraw(c: Canvas) { //Funcion para dibujar

        super.onDraw(c) //el lienzo para dibujar
        var p = Paint() //la brocha para pintar

        altoCanvas = c.height //alto y ancho maximo del canvas
        anchoCanvas = c.width

        //--------------------------------------------------------------------Fondo/Cielo
        var fondo = Figura(0, 0, altoCanvas, anchoCanvas)//definimos tamaño
        p.color = Color.rgb(132, 178, 189)//selec color
        fondo.dibujar(c, p)  //Dibujamos el fondo

        p.color = Color.YELLOW
        sol.dibujar(c,p) //Dibujar sol

        //-------------------------------------------------------------------//Suelo/Hills
        var suelo = Figura(0, 1300, altoCanvas, anchoCanvas - 300)
        var cir1 = Figura(anchoCanvas - 300, altoCanvas - 105, 150)
        var cir2 = Figura(-100, altoCanvas - 250, 500)
        var cir3 = Figura(400, altoCanvas - 250, 200)
        var cir4 = Figura(anchoCanvas - 150, altoCanvas, 150)
        var cir5 = Figura(600, altoCanvas - 250, 50)
        p.color = Color.rgb(20, 104, 26)
        suelo.dibujar(c, p)
        cir1.dibujar(c, p)//400/1542
        cir2.dibujar(c, p)
        cir3.dibujar(c, p)
        cir4.dibujar(c, p)
        cir5.dibujar(c, p)

        //--------------------------Icono
        icono.dibujar(c,p)
    }

    fun mover(){
        icono.seMueve()
        invalidate()
    }
}