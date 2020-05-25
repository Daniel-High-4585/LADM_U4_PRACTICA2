package mx.edu.ittepic.ladm_u4_practica2

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SensorEventListener{

    //declaracion peresosa, no esta inicializada
    lateinit var sm: SensorManager
    var sensorProximidad: Sensor? = null
    var sensorAcel : Sensor? = null

    var lienzo: Lienzo? = null //crearemos una variable de tipo Lienzo
    var lienzoN: LienzoNoche? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorProximidad = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        sensorAcel = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sm.registerListener(this,sensorProximidad,SensorManager.SENSOR_DELAY_NORMAL)
        sm.registerListener(this,sensorAcel,SensorManager.SENSOR_DELAY_NORMAL)

        lienzo=Lienzo(this)//para asignar el lienzo
        lienzoN=LienzoNoche(this)//para asignar el lienzo

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        var sensorEnt = event!!.sensor

        if(sensorEnt.type == Sensor.TYPE_ACCELEROMETER) {

            //textView.setTextColor(Color.BLACK)
            //textView.setText("Coordenadas:\nX: ${event.values[0]}\nY: ${event.values[1]}\nZ: ${event.values[2]}")

            if (event.values[0] > 4) {
                //textView2.setText("A la Izq")
                lienzo!!.icono.movimiento = 1
                lienzoN!!.icono.movimiento = 1
                lienzo!!.mover()
                lienzoN!!.mover()
            } else {
                if (event.values[0] < -4) {
                    //textView2.setText("A la Der")
                    lienzo!!.icono.movimiento = 2
                    lienzoN!!.icono.movimiento = 2
                    lienzo!!.mover()
                    lienzoN!!.mover()
                } else {
                    //textView2.setText("no se mueve")
                    lienzo!!.icono.movimiento = 0
                    lienzoN!!.icono.movimiento = 0
                    lienzo!!.mover()
                    lienzoN!!.mover()
                }
            }
        }

        if(sensorEnt.type == Sensor.TYPE_PROXIMITY){
            if(event.values[0]<sensorProximidad!!.maximumRange){// Detecta que algo esta cercas


                setContentView(lienzoN)//a este Main Activity de nochetl)

            }else {                                             // No hay nada cerca


                setContentView(lienzo)//a este Main Activity)
            }
        }

    }


}
