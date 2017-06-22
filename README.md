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

## LICENSE
```
The MIT License (MIT)

Copyright (c) 2017 Victor Santiago

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
