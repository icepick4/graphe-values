package graphe.values;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

public class ClickEdge implements MouseListener, MouseMotionListener{
    private GUI gui;

    public ClickEdge(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        GrapheDraw Canvas = gui.getCanvas();
        if (this.gui.getRb_selectEdge().isSelected()) {
            int x = e.getX();
            int y = e.getY();
            //check if the click is on an edge drawn, with the begin and the end of the edge
            for (int i = 0; i < Canvas.getNbEdges(); i++) {
                double posDebX, posDebY, posFinX, posFinY;
                if (Canvas.getEdges().get(i).getPos1X() < Canvas.getEdges().get(i).getPos2X()) {
                    posDebX = Canvas.getEdges().get(i).getPos1X();
                    posFinX = Canvas.getEdges().get(i).getPos2X();
                    posDebY = Canvas.getEdges().get(i).getPos1Y() + 25;
                    posFinY = Canvas.getEdges().get(i).getPos2Y() + 25;
                } else {
                    posDebX = Canvas.getEdges().get(i).getPos2X();
                    posFinX = Canvas.getEdges().get(i).getPos1X();
                    posDebY = Canvas.getEdges().get(i).getPos2Y() + 25;
                    posFinY = Canvas.getEdges().get(i).getPos1Y() + 25;
                }
    
                double largeur = Math.abs((posFinY - posDebY)*x - (posFinX - posDebX)*y + posFinX*posDebY - posFinY*posDebX);
                double longueur = Math.sqrt((posFinX - posDebX)*(posFinX - posDebX) + (posFinY - posDebY)*(posFinY - posDebY));
                if(largeur/longueur < 7 && x > posDebX && x < posFinX){
                    Canvas.getEdges().get(i).setWidth(7);
                    int I = Canvas.getEdges().get(i).getNodeI();
                    int J = Canvas.getEdges().get(i).getNodeJ();
                    //display names of the nodes in the JOptionPane
                    String nameI = Canvas.getNodes().get(I).getName();
                    String nameJ = Canvas.getNodes().get(J).getName();
                    //display the JOptionPane
                    JOptionPane.showMessageDialog(null, "Noeud I : " + nameI + "\nNoeud J : " + nameJ);
                    //repaint the canvas
                    Canvas.repaint();
                }
                else{
                    //decrease width of the edge
                    Canvas.getEdges().get(i).setWidth(1);
                    //repaint the canvas
                    Canvas.repaint();
                }
            }    
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        GrapheDraw Canvas = gui.getCanvas();
        if (this.gui.getRb_selectEdge().isSelected()) {
            int x = e.getX();
            int y = e.getY();
            for (int i = 0; i < Canvas.getNbEdges(); i++) {
                double posDebX, posDebY, posFinX, posFinY;
                //set the pos which is on the left
                if (Canvas.getEdges().get(i).getPos1X() < Canvas.getEdges().get(i).getPos2X()) {
                    posDebX = Canvas.getEdges().get(i).getPos1X();
                    posFinX = Canvas.getEdges().get(i).getPos2X();
                    posDebY = Canvas.getEdges().get(i).getPos1Y() + 25;
                    posFinY = Canvas.getEdges().get(i).getPos2Y() + 25;
                } else {
                    posDebX = Canvas.getEdges().get(i).getPos2X();
                    posFinX = Canvas.getEdges().get(i).getPos1X();
                    posDebY = Canvas.getEdges().get(i).getPos2Y() + 25;
                    posFinY = Canvas.getEdges().get(i).getPos1Y() + 25;
                }

                double largeur = Math.abs((posFinY - posDebY)*x - (posFinX - posDebX)*y + posFinX*posDebY - posFinY*posDebX);
                double longueur = Math.sqrt((posFinX - posDebX)*(posFinX - posDebX) + (posFinY - posDebY)*(posFinY - posDebY));
                if(largeur/longueur < 7 && x > posDebX && x < posFinX){
                    Canvas.getEdges().get(i).setWidth(7);
                    //repaint the canvas
                    Canvas.repaint();
                }
                else{
                    //decrease width of the edge
                    Canvas.getEdges().get(i).setWidth(1);
                    //repaint the canvas
                    Canvas.repaint();
                }
            }
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
