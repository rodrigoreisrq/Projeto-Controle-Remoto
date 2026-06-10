# 📺 ControleRemoto — Exercício de Encapsulamento

Projeto desenvolvido como exercício prático da aula de **Encapsulamento** do curso de **Programação Orientada a Objetos** do professor [Gustavo Guanabara](https://www.cursoemvideo.com/).

---

## 📚 Conceitos Aplicados

### Encapsulamento
O encapsulamento é um dos quatro pilares da POO. Ele consiste em **proteger os dados internos de uma classe**, expondo apenas o que for necessário para o mundo externo.

Neste projeto, os atributos da classe são declarados como `private` — nenhum código externo consegue acessá-los diretamente:

```java
private int volume;
private boolean ligado;
private boolean tocando;
```

O acesso a esses dados é feito exclusivamente através de **getters e setters**, que também são `private` neste caso — reforçando que a manipulação do estado interno acontece apenas dentro da própria classe, via seus métodos públicos.

### Interface (`Controlador`)
A classe `ControleRemoto` implementa a interface `Controlador`, o que garante um **contrato de comportamento**: qualquer controle remoto que implemente essa interface precisa obrigatoriamente definir todos os métodos listados nela (`ligar`, `desligar`, `play`, `pause`, etc.).

Isso representa o conceito de **abstração** — o mundo externo sabe *o que* o controle faz, mas não *como* ele faz internamente.

---

## 🗂️ Estrutura do Projeto

```
encapsulamentoguanabara/
├── Controlador.java       # Interface com os métodos abstratos
└── ControleRemoto.java    # Implementação concreta da interface
```

---

## ⚙️ Como Funciona

### Estado inicial
Ao instanciar um `ControleRemoto`, ele começa com valores padrão definidos no construtor:

| Atributo  | Valor inicial |
|-----------|---------------|
| `volume`  | 50            |
| `ligado`  | `false`       |
| `tocando` | `false`       |

### Métodos disponíveis

| Método          | Comportamento                                                              |
|-----------------|----------------------------------------------------------------------------|
| `ligar()`       | Liga o controle (`ligado = true`)                                          |
| `desligar()`    | Desliga o controle (`ligado = false`)                                      |
| `abrirMenu()`   | Exibe o estado atual (volume, ligado, tocando) — só funciona se ligado     |
| `fecharMenu()`  | Imprime mensagem de fechamento                                              |
| `maisVolume()`  | Incrementa o volume em 1 — só funciona se ligado                           |
| `menosVolume()` | Decrementa o volume em 1 — só funciona se ligado                           |
| `ligarMudo()`   | Zera o volume — só funciona se ligado e volume > 0                         |
| `desligarMudo()`| Restaura o volume para 50 — só funciona se ligado e volume == 0            |
| `play()`        | Inicia a reprodução — só funciona se ligado e não estiver tocando          |
| `pause()`       | Pausa a reprodução — só funciona se ligado e estiver tocando               |

### Visualização do volume (`abrirMenu`)
O menu exibe uma barra de volume visual usando um loop `for`:

```
--------MENU---------
Esta ligado? true
Esta tocando? false
Volume: 50
||||||||||||||||||||||||||||||||||||||||||||||||||||||
```

---

## 💡 Decisões de Design

- **Getters e setters `private`**: diferente do padrão mais comum (onde são `public`), aqui eles são privados de propósito. Isso impede que qualquer código de fora da classe leia ou altere o estado diretamente — nem mesmo via getters. A única porta de entrada é pelos métodos de comportamento (`ligar()`, `play()`, etc.).

- **Guardas de estado nos métodos**: cada ação verifica se a operação faz sentido antes de executar (ex: não dá para dar `play` se o controle estiver desligado). Isso mantém o objeto sempre em um estado consistente.

- **Comentários `//else { }`**: os blocos `else` comentados indicam que o comportamento para casos inválidos foi intencionalmente omitido no exercício, deixando o código mais limpo durante o aprendizado.

---

## 🛠️ Tecnologias

- **Java** (JDK 8+)
- **IntelliJ IDEA** (recomendado)
- **Maven** (opcional para gerenciamento de dependências)

---

## ▶️ Como Executar

1. Clone o repositório ou copie os arquivos para seu projeto Java.
2. Certifique-se de que `Controlador.java` e `ControleRemoto.java` estão no mesmo pacote (`encapsulamentoguanabara`).
3. Crie uma classe `Main.java` no mesmo pacote para testar:

```java
package encapsulamentoguanabara;

public class Main {
    public static void main(String[] args) {
        ControleRemoto controle = new ControleRemoto();

        controle.ligar();
        controle.maisVolume();
        controle.maisVolume();
        controle.play();
        controle.abrirMenu();
        controle.pause();
        controle.ligarMudo();
        controle.abrirMenu();
    }
}
```

---

## 📝 Referências

- Curso de POO — Gustavo Guanabara · [cursoemvideo.com](https://www.cursoemvideo.com/)
- Documentação oficial Java: [docs.oracle.com](https://docs.oracle.com/en/java/)
