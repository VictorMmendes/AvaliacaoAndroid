package br.edu.ifpr.paranagua.avaliacao

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.ifpr.paranagua.tadsprova.entidades.Evento
import br.edu.ifpr.paranagua.tadsprova.entidades.Tipo
import kotlinx.android.synthetic.main.convencao_item.view.*
import android.support.v4.content.ContextCompat.startActivity



/**
 * Created by aluno on 12/04/18.
 */
class ListAdapter(val eventos: List<Evento>) :
        RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun getItemViewType(position: Int): Int
    {
        if(eventos[position].tipo == Tipo.CONVENCAO)
        {
            return 0
        } else if(eventos[position].tipo == Tipo.SEMINARIO){
            return 1
        } else {
            return 2
        }
    }

    override fun onCreateViewHolder(
            parent: ViewGroup?, viewType: Int): ViewHolder {

        if(viewType == 0)
        {
            val view = LayoutInflater
                    .from(parent?.context)
                    .inflate(R.layout.convencao_item,
                            parent, false)
            return ViewHolder(view)
        } else if(viewType == 1){
            val view = LayoutInflater
                    .from(parent?.context)
                    .inflate(R.layout.seminario_item,
                            parent, false)
            return ViewHolder(view)
        } else {
            val view = LayoutInflater
                    .from(parent?.context)
                    .inflate(R.layout.reuniao_item,
                            parent, false)
            return ViewHolder(view)
        }
    }

    override fun getItemCount() = eventos.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(
            holder: ViewHolder?, position: Int) {
        val animal = eventos[position]
        holder?.let {
            it.preencherView(animal)
        }
    }

    class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {

        val vw = view

        @RequiresApi(Build.VERSION_CODES.O)
        fun preencherView(evento: Evento)
        {
            itemView.nomeTf.text = evento.nome
            itemView.mesTf.text = evento.data.month.toString().substring(0,3)
            itemView.diaTf.text = evento.data.dayOfMonth.toString()
            if(evento.tipo == Tipo.REUNIAO_VIRTUAL)
            {
                itemView.infoTf.text = evento.local
                itemView.setOnClickListener({ openBrowser(evento.local) })
            } else {
                itemView.infoTf.text = "${evento.local} - ${evento.cidade} - ${evento.estado}"
            }
        }

        private fun openBrowser(local: String)
        {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(local))
            vw.context.startActivity(browserIntent)
        }
    }
}
