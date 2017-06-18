/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globoesportescrapper;

import globoesportescrapper.model.interfaces.GloboEsporte;
import globoesportescrapper.model.objects.Partida;
import globoesportescrapper.model.objects.Rodada;
import globoesportescrapper.model.scrapper.Scrapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Santiago
 */
public class GloboEsporteScrapper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GloboEsporte ge = new Scrapper();
        
        Rodada r = new Rodada();
        try {
            r = ge.getRodada("http://globoesporte.globo.com/servico/esportes_campeonato/responsivo/widget-uuid/c6008860-b121-40a5-afe6-3bae9af08a32/fases/fase-unica-seriea-2017/rodada/4/jogos.html");
        } catch (IOException ex) {
            Logger.getLogger(GloboEsporteScrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Rodada " + r.getNumber());
        
        for(Partida p : r.getPartidas())
            System.out.println(p.getHome() + " " + p.getHomeGoals() + "x" + 
                    p.getAwayGoals() + " " + p.getAway());
    }
    
}
