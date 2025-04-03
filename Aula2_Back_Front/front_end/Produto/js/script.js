document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    const carregarBtn = document.getElementById('carregarBtn');
    const listaProdutos = document.getElementById('listaProdutos');

    // URL base da API - altere conforme necessário
    const API_URL = 'http://localhost:8080/produto';

    // Evento de submit do formulário
    form.addEventListener('submit', async function(event) {
        event.preventDefault();
        
        let produto = {
            nome: document.getElementById('nome').value,
            valor: parseFloat(document.getElementById('valor').value),
            saldo: parseInt(document.getElementById('saldo').value),
            saldoMin: parseInt(document.getElementById('saldoMin').value)
        };
        await cadastrarProduto(produto);
    });

    // Evento do botão Carregar Produto
    carregarBtn.addEventListener('click', async function() {
        await carregarProdutos();
    });

    // Função para cadastrar produto
    async function cadastrarProduto(produto) {
        console.log(produto)
        try {
            const response = await fetch(API_URL + "/adicionar", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(produto)
            });

            if (!response.ok) {
                const errorData = await response.json();
                throw new Error(errorData.message || 'Erro ao cadastrar produto');
            }

            form.reset();
            await carregarProdutos();
            alert('Produto cadastrado com sucesso!');
        } catch (error) {
            console.error('Erro:', error);
            alert(`Falha ao cadastrar produto: ${error.message}`);
        }
    }

    // Função para carregar produtos
    async function carregarProdutos() {
        try {
            const response = await fetch(API_URL + "/buscar");
            
            if (!response.ok) {
                throw new Error('Erro ao carregar produtos');
            }

            const produtos = await response.json();
            exibirProdutos(produtos);
        } catch (error) {
            console.error('Erro:', error);
            listaProdutos.innerHTML = '<li>Erro ao carregar produtos</li>';
        }
    }

    // Função para exibir produtos na lista
    function exibirProdutos(produtos) {
        listaProdutos.innerHTML = '';
        
        if (produtos.length === 0) {
            listaProdutos.innerHTML = '<li>Nenhum produto cadastrado</li>';
            return;
        }

        produtos.forEach(produto => {
            const li = document.createElement('li');
            li.innerHTML = `
                <strong>${produto.nome}</strong> - 
                Valor: R$${produto.valor.toFixed(2)} - 
                Saldo: ${produto.saldo} - 
                Mínimo: ${produto.saldoMin}
            `;
            listaProdutos.appendChild(li);
        });
    }
});