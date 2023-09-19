enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val id: Long, var nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        val estaInscrito = inscritos.filter{it.id == (usuario.id)}

        if (estaInscrito.isNotEmpty()){
            println("Esse aluno já está cadastrado")
        }
        else{
            inscritos.add(usuario)

            println("Aluno cadastrado com sucesso")
        }
    }

    fun matricularListaAlunos(vararg novosInscritos:Usuario){

        val inscritosValidos = novosInscritos.filter{it.id !=(inscritos.iterator().next().id)}

        inscritos.addAll(inscritosValidos)

        println("Lista de novos alunos cadastrados: ")

        inscritosValidos.forEach { usuario -> println("${usuario.nome}")}

    }
}

fun main() {
    val exemplo = Formacao(
        "Abstraindo Formações da DIO Usando Orientação a Objetos com Kotlin", 
        listOf<ConteudoEducacional>(ConteudoEducacional("Formações Educacionais da DIO")), 
        Nivel.BASICO
    )

    exemplo.matricular(Usuario(1L,"Maria"))

    exemplo.matricular(Usuario(1L,"Maria"))

    exemplo.matricularListaAlunos(
        Usuario(1L,"Maria"),
        Usuario(2L,"João"), 
        Usuario(3L,"José")
    )
}