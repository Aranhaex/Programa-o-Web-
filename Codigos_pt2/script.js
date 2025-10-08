    function adicionarItem() {
        //entrada dos itens
        let inputItem = document.getElementById("inputItem")
        let item = inputItem.value.trim() //Evita a entrada de espaços via teclado
        let mensagem = document.getElementById("mensagem")

        if(item==""){
            let mensagemErro ="Por favor digite um item valido"
            mensagem.textContent = mensagemErro
        }else if(!/^[a-zA-Z0-9À-ÿ\s]+$/.test(item)){
           let mensagemErro ="Por favor digite um item valido"
            mensagem.textContent = mensagemErro 
        } 
        
        else {

             //Armazenamento dos itens
             let mensagemOK ="Item adicionado"
            mensagem.textContent = mensagemOK
        let listaItens = document.getElementById("listaItens")
        let novoItem = document.createElement("li")
        novoItem.textContent = item
        listaItens.appendChild(novoItem)

        }
       
        
       
        
        //limpar o campo de entrada
        inputItem.value ="";
    }
