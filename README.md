# GloboEsporte-Scrapper
Scrapper para obter dados do Globo Esporte

## O quê é isto?
Um Web Scrapper, em Java, para obter dados do Globo Esporte.

Em outras palavras, ele abre uma conexão com o Globo Esporte, e varre o HTML em busca dos dados, e te retorna um POJO com os dados.

## Exemplos
Crie uma instância:
```java
GloboEsporte ge = new Scrapper();
```

Obter todas as rodadas do Brasileirão:
```java
ArrayList<Rodada> rodadas = new ArrayList<>();
        
for(int i = 1; i <= 38; i++) {
  try {
    System.out.println("Obtendo rodada "+ i);
    rodadas.add(ge.getRodada("http://globoesporte.globo.com/servico/esportes_campeonato/responsivo/widget-uuid/c6008860-b121-40a5-afe6-3bae9af08a32/fases/fase-unica-seriea-2017/rodada/"+i+"/jogos.html"));
  } catch(IOException e) {
    e.printStackTrace();
  }
}
```
