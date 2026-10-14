# ☕ Cafeteria

Sistema de cafeteria em linha de comando, feito em **Java** para praticar orientação a objetos e controle de estoque.

## Funcionalidades

- Menu interativo no console
- Pedido com vários itens e quantidades
- Soma automática quando o mesmo café é pedido mais de uma vez
- Controle de estoque, com bloqueio quando não há quantidade suficiente
- Aviso quando um produto acaba
- Cálculo do total e do troco, com validação do valor pago
- Validação de entradas inválidas (letras, opções fora do menu, quantidades negativas)


## Estrutura do projeto

```
Cafeteria/
├── Cafeteria_main.java
  └── cafeteria/
    ├── Cafe.java
    ├── ItemPedido.java
    └── Pedido.java
```

| Classe | Responsabilidade |
|--------|------------------|
| `Cafe` | Representa o produto: nome, preço e estoque |
| `ItemPedido` | Guarda um café e a quantidade pedida |
| `Pedido` | Lista de itens e cálculo do total |
| `Cafeteria_main` | Menu e fluxo do programa |


## O que pratiquei

- Classes, objetos e encapsulamento (getters e setters)
- `ArrayList` e laços de repetição
- Validação de entrada com `Scanner` e tratamento de exceções
- Organização do código em pacotes
- Depuração: corrigi um bug na soma de itens repetidos no pedido

## Autora

**Leticia** · [LinkedIn](https://www.linkedin.com/in/SEU_PERFIL) · [GitHub](https://github.com/SEU_USUARIO)
