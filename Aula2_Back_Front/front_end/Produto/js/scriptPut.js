async function getProdutoPorId(id) {
    try {
        const response = await fetch(`${API_URL}/buscar/${id}`, {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' }
        });

        if (!response.ok) {
            alert(`Produto não encontrado! Erro: ${response.status}`);
            return null;
        }

        const produto = await response.json();
        return produto;

    } catch (error) {
        alert("Erro na busca: " + error.message);
        return null;
    }
}

