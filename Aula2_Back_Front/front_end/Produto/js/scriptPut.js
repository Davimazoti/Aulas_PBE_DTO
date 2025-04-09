const API_URL = "http://localhost:8080/produto";

async function getProdutoPorId() {
    try {

        const params = new URLSearchParams(window.location.search)
        const id = params.get('id');

        console.log(id)

        const response = await fetch(`${API_URL}/buscar/${id}`, {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' }
        });


        if (!response.ok) {
            throw new Error(`Erro HTTP: ${response.status}`);
        }

        const produto = await response.json();
     
        document.getElementById('nome').value = produto.nome
        document.getElementById('valor').value = produto.valor
        document.getElementById('saldo').value = produto.saldo
        document.getElementById('saldoMin').value = produto.saldoMin
    

    } catch (error) {
        alert("Erro na busca: " + error.message);
    }
}



async function atualizarProduto(event) {
    event.preventDefault();

    const params = new URLSearchParams(window.location.search)
    const id = params.get('id');
    const produtoAtualizado = {
        nome: document.getElementById("nome").value,
        valor: parseFloat(document.getElementById("valor").value),
        saldo: parseInt(document.getElementById("saldo").value),
        saldoMin: parseInt(document.getElementById("saldoMin").value),
    };

    try {
        const response = await fetch(`${API_URL}/atualizar/${id}`, {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(produtoAtualizado),
        });
    
        if (!response.ok) {
          throw new Error(`Erro HTTP: ${response.status}`);
        }
    
        alert(`Produto ID ${id} atualizado com sucesso.`);
  
        window.history.back(); // Redireciona o usuário para a pagina anterior
      
    } catch (error) {
        console.error("Erro ao atualizar produto:", error);
        alert("Erro ao atualizar produto. Verifique o ID e tente novamente.");
    }    
}



document.addEventListener("DOMContentLoaded", ()=>{
    getProdutoPorId();

    const formAtulaizar = document.getElementById("formAtualizar")
    if(formAtulaizar){
        formAtulaizar.addEventListener("submit", atualizarProduto)
    }
})
