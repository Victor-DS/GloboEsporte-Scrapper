/*
 * The MIT License
 *
 * Copyright 2017 Victor Santiago.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package globoesportescrapper.model.scrapper;

import globoesportescrapper.model.objects.Partida;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Victor Santiago
 */
public class PartidaScrapper {
    
    private String html;

    public PartidaScrapper(String html) {
        this.html = html;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
    
    public List<Partida> scrap() {
        List<Partida> partidas = new ArrayList<>();
        
        Document doc = Jsoup.parse(html);
        
        Partida p;
        for(Element e : doc.select("li.lista-de-jogos-item")) {
            p = new Partida();
            
            try {
                p.setDate(e.select("meta[itemprop=startDate]").attr("content"));
            } catch (ParseException ex) {
                Logger.getLogger(PartidaScrapper.class.getName()).log(Level.WARNING, null, ex);
            }
            
            p.setHome(e.select("span.placar-jogo-equipes-nome").first().text());
            p.setAway(e.select("span.placar-jogo-equipes-nome").last().text());
            
            String hGoals, aGoals;
            hGoals = e.select("span.placar-jogo-equipes-placar-mandante").text();
            aGoals = e.select("span.placar-jogo-equipes-placar-visitante").text();
            
            try {
                p.setHomeGoals(Integer.parseInt(hGoals));                
            } catch(NumberFormatException ex) {
                p.setHomeGoals(-1);
            }
            
            try {
                p.setAwayGoals(Integer.parseInt(aGoals));                
            } catch(NumberFormatException ex) {
                p.setAwayGoals(-1);
            }

            partidas.add(p);
        }
        
        return partidas;
    }
    
    public static List<Partida> scrapIt(String html) {
        return new PartidaScrapper(html).scrap();
    }
    
}
