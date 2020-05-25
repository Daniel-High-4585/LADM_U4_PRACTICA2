package mx.edu.ittepic.ladm_u4_practica2

import android.graphics.*
import android.widget.Toast
import kotlin.random.Random

class Figura(){
    //Esta clase es la abstraccion/objeto de una figura geometrica
    //en el cual, las variables de una figura aqui son

    var x = 0f  //las cordenadas 'x' y 'y' para definir donde
    var y = 0f  //empiza la figura

    var radio = 0f  //En el caso de dibujar un circulo, necesitamos un radio

    var alto = 0f   //En el caso de un rectangulo, necesitaremos
    var ancho = 0f  //lo largo de sus lados

    var tipo = 0    //Esta var nos dira de que figura se trata
    //siendo 0 para circulo, 1 para rectangulo y 2 para triangulo

    var bitmap : Bitmap?=null

    var movimiento = 0 //0 no se mueve, 1 a la izq, 2 a la der

    //En donde empieza en x, en donde empieza en y, cuanta profundidad le quieres dar, cuanta anchura le quieres dar
    constructor(corX:Int,corY:Int,altura:Int,anchura:Int):this(){
        x = corX.toFloat()
        y = corY.toFloat()
        alto = altura.toFloat()
        ancho = anchura.toFloat()
        tipo = 1
    }//constructor para rectangulos

    constructor(corX: Int,corY: Int,radiotl:Int):this(){
        x = corX.toFloat()
        y = corY.toFloat()
        radio = radiotl.toFloat()
    }//contructor del circulo

   /* constructor(a:Point,b:Point,c: Point,path:Path):this(){
        tipo = 2
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(a.x.toFloat(), a.y.toFloat());
        path.lineTo(b.x.toFloat(), b.y.toFloat());
        path.moveTo(b.x.toFloat(), b.y.toFloat());
        path.lineTo(c.x.toFloat(), c.y.toFloat());
        path.moveTo(c.x.toFloat(), a.y.toFloat());
        path.lineTo(a.x.toFloat(), a.y.toFloat());
        path.close();
    }//Constructor de Triangulo*/

    constructor(x:Int, y:Int, imagen: Bitmap):this(){
        bitmap=imagen
        this.x=x.toFloat()
        this.y=y.toFloat()
        ancho = bitmap!!.width.toFloat()
        alto = bitmap!!.width.toFloat()
        this.tipo=3
    }//-----------------------------------------------------//contructor imagen

    fun dibujar(c:Canvas,p:Paint){
        //con un canvas y "la brocha" como parametros de entrada
        //segun el tipo, vamos a dibujar
        when(tipo){
            0 -> {//un circulo
                c.drawCircle(x,y,radio,p)

            }

            1 -> {//un rectangulo
                c.drawRect(x,y,x+ancho,y+alto,p)
            }
            3 ->{
                c.drawBitmap(bitmap!!,x,y,p)
            }
        }

    }

    fun dibujarTriangulo(c:Canvas,p:Paint,path:Path){
        c.drawPath(path,p)
    }

    fun seMueve(){
        if(movimiento==1){
            if(x<=0f){

            }else{
                x-=50}
        }else{
            if(movimiento==2){
                if(x>=780f){

                }else {
                    x += 50
                }
            }
        }
    }


    fun seMueve2(){
        if(movimiento==1){
            if(x<=0f){

            }else{
                x-=50}
        }else{
            if(movimiento==2){
                if(x>=780f){

                }else {
                    x += 50
                }
            }
        }
    }
}