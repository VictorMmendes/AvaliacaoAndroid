package br.edu.ifpr.paranagua.tadsprova.entidades

import java.time.LocalDate

// Construtor primário (genérico)
data class Evento(var data: LocalDate,
                  var nome: String,
                  var local: String,
                  var cidade: String?,
                  var estado: String?,
                  var tipo: Tipo) {
    // Construtor secundário para Reuniões Virtuais
    constructor(data: LocalDate,
                nome: String,
                site: String) :
            this(data, nome, site, null, null, Tipo.REUNIAO_VIRTUAL)
}

// Enum com os Tipos possíveis
enum class Tipo {
    CONVENCAO, SEMINARIO, REUNIAO_VIRTUAL
}