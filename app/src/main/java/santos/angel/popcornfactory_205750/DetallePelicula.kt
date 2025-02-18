package santos.angel.popcornfactory_205750

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras
        var nseats = 0
        val seatLeft: TextView = findViewById(R.id.seatLeft)

        if (bundle != null) {
             nseats = bundle.getInt("numberSeats")

            findViewById<TextView>(R.id.tv_nombre_pelicula).text = bundle.getString("nombre")
            findViewById<ImageView>(R.id.iv_pelicula_imagen).setImageResource(bundle.getInt("header"))
            findViewById<TextView>(R.id.tv_pelicula_desc).text = bundle.getString("sinopsis")
            seatLeft.setText("$nseats seats available")
        }
        if(nseats == 0){
            findViewById<Button>(R.id.buyTickets).isEnabled = false
        }else{
            findViewById<Button>(R.id.buyTickets).isEnabled = true
            findViewById<Button>(R.id.buyTickets).setOnClickListener{
                var intent = Intent(this, SeatSelection::class.java)
                startActivity(intent)
            }
        }

    }
}