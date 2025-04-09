const API_URL = "http://localhost:8080/produto";

async function enviarProduto(event) {
    event.preventDefault(); 
        
    let produto = {
        nome: document.getElementById('nome').value,
        valor: parseFloat(document.getElementById('valor').value),
        saldo: parseInt(document.getElementById('saldo').value),
        saldoMin: parseInt(document.getElementById('saldoMin').value)
    };
     
    try{
        let response = await fetch(API_URL + "/adicionar", {
            method: "POST",
                headers: { "Content-Type": "application/json"},

                body: JSON.stringify(produto)
        });

        if(!response.ok){
            alert("Erro do back-end"+response.status)
            return
        }

        let data = await response.json()
   
        alert("Sucesso: "+ data.nome);
        carregarProdutos();
        console.log(saldoMin.value)
        
        nome.value = "";
        valor.value = "";
        saldo.value = "";
        saldoMin.value = "";

    } catch (error){
        alert("Erro na requisição: "+error.message)
    }
}

    // Função para carregar produtos
async function carregarProdutos() {
    try {
        const response = await fetch(API_URL + "/buscar", {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        });
        
        let data = await response.json()

        let lista = document.getElementById("listaProdutos")
        lista.innerHTML = "";
        data.forEach(produto => {
            let item = document.createElement("li")
            item.textContent = `ID: ${produto.id} - ${produto.nome} - R$ ${produto.valor} - Saldo: ${produto.saldo} - Saldo Mínimo: ${produto.saldoMin}`
            
            let btnDeletar = document.createElement("button")
            btnDeletar.textContent = "Deletar"
            btnDeletar.onclick = function(){
                deletarProduto(produto.id)
            }
            item.appendChild(btnDeletar)

            let btnAtulizar = document.createElement("button")
            btnAtulizar.textContent = "Atualizar"
            btnAtulizar.onclick = function(){
                window.location.href = `indexPut.html?id=${produto.id}`
            }
            item.appendChild(btnAtulizar)
            
            lista.appendChild(item)
        })
    } catch (error) {
        console.error('Erro:', error);
        listaProdutos.innerHTML = '<li>Erro ao carregar produtos</li>';
    }
}


    async function deletarProduto(id) {
        if (confirm("Tem certeza que deseja deletar esse produto?")){
            try{
                let response = await fetch(`${API_URL}/deletar/${id}`, {
                    method: 'DELETE',
                    headers: {'Content-Type': 'application/json'},
                });

                if (!response.ok){
                    alert("Erro do back-end"+response.status)
                }

              alert("Produto deletado com sucesso!");
                    carregarProdutos();
                } catch (error) {
                    alert("Erro na requisição: " + error.message)
        }
    }
}
     



document.addEventListener("DOMContentLoaded", ()=>{
    document.getElementById("produtoForm").addEventListener("submit", enviarProduto);
    document.getElementById("carregarBtn").addEventListener("click", carregarProdutos);
});