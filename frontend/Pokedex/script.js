async function buscarPokemon() {

    const nomePokemon = document
        .getElementById("nomePokemon")
        .value
        .trim();


    if (nomePokemon === "") {

        alert("Digite o nome de um Pokémon.");

        return;
    }


    try {

        const resposta = await fetch(
            "http://localhost:7000/pokemon/" + nomePokemon
        );


        if (!resposta.ok) {

            alert("Pokémon não encontrado!");

            return;
        }


        const pokemon = await resposta.json();


        document.getElementById("imagemPokemon").src =
            pokemon.imagem;


        document.getElementById("nome").innerText =
            pokemon.nome;


        document.getElementById("numero").innerText =
            pokemon.numeroPokedex;


        document.getElementById("tipo").innerText =
            pokemon.tipo;


        document.getElementById("altura").innerText =
            pokemon.altura;


        document.getElementById("peso").innerText =
            pokemon.peso;


        document.getElementById("descricao").innerText =
            pokemon.descricao;





        document.getElementById("hp").innerText =
            pokemon.hp;


        document.getElementById("ataque").innerText =
            pokemon.ataque;


        document.getElementById("defesa").innerText =
            pokemon.defesa;


        document.getElementById("ataqueEspecial").innerText =
            pokemon.ataqueEspecial;


        document.getElementById("defesaEspecial").innerText =
            pokemon.defesaEspecial;


        document.getElementById("velocidade").innerText =
            pokemon.velocidade;





        document.getElementById("habilidade").innerText =
            pokemon.habilidades;


    } catch (erro) {

        console.error(erro);

        alert("Erro ao conectar com o servidor.");

    }

}