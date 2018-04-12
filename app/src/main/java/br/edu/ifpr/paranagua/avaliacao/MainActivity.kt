package br.edu.ifpr.paranagua.avaliacao

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.StaggeredGridLayoutManager
import br.edu.ifpr.paranagua.tadsprova.entidades.Evento
import br.edu.ifpr.paranagua.tadsprova.entidades.Tipo
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.time.Month

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eventos = listOf<Evento>(
                Evento(LocalDate.of(2018, Month.APRIL, 1),"Convenção do IFPR","expo Renault Barigui","Curitiba","PR", Tipo.CONVENCAO),
                Evento(LocalDate.of(2018, Month.APRIL, 2),"Seminário de TADS","IFPR","Paranaguá","PR", Tipo.SEMINARIO),
                Evento(LocalDate.of(2018, Month.APRIL, 3),"1°Reunião Virtual de Abril","http://paranagua.ifpr.edu.br/reuniao"),
                Evento(LocalDate.of(2018, Month.APRIL, 4),"2°Reunião Virtual de Abril","http://paranagua.ifpr.edu.br/reuniao"),
                Evento(LocalDate.of(2018, Month.APRIL, 5),"Seminário de informática", "IFPR","Paranaguá","PR", Tipo.SEMINARIO),
                Evento(LocalDate.of(2018, Month.APRIL, 6),"Seminário sobre Jogos","Isupar", "Paranaguá", "PR", Tipo.SEMINARIO),
                Evento(LocalDate.of(2018, Month.APRIL, 7),"3°Reunião Virtual de Abril","http://paranagua.ifpr.edu.br/reuniao"),
                Evento(LocalDate.of(2018, Month.APRIL, 8),"Seminário sobre Java","IFPR", "Paranaguá", "PR", Tipo.SEMINARIO)
            )

        val adapter = ListAdapter(eventos)
        listEventos.adapter = adapter
        val layout = StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.VERTICAL)
        listEventos.layoutManager = layout
    }
}
