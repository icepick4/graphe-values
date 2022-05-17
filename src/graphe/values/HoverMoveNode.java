package graphe.values;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Classe qui gère les mouvements et l'effet de hover des noeuds
 */
public class HoverMoveNode implements MouseListener, MouseMotionListener{
    private boolean clicked = false;
    private int node = -2;
    private GUI gui;

    public HoverMoveNode(GUI gui){
        this.gui = gui;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        GrapheDraw Canvas = this.gui.getCanvas();
        int lastNode = this.node;
        for(int i = 0; i < Canvas.getNbNodes(); i++){
            if(x >= Canvas.getNodes().get(i).getPosX() - 50 && x <= Canvas.getNodes().get(i).getPosX() + 50 && y >= Canvas.getNodes().get(i).getPosY() + 10 && y <= Canvas.getNodes().get(i).getPosY() + 50){
                lastNode = i;
            }
        }
        if(lastNode == node){
            this.node = -1;
        }
        else{
            this.node = lastNode;
        }
        if(this.clicked){
            this.clicked = false;
        }
        else if (this.node != -1){
            this.clicked = true;
        }
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
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        GrapheDraw Canvas = this.gui.getCanvas();
        for(int i = 0; i < Canvas.getNbNodes(); i++){
            if(x >= Canvas.getNodes().get(i).getPosX() - 50 && x <= Canvas.getNodes().get(i).getPosX() + 50 && y >= Canvas.getNodes().get(i).getPosY() + 10 && y <= Canvas.getNodes().get(i).getPosY() + 50){
                try{
                    if(Canvas.getNodes().get(this.node).getHeight() < 75){
                        Canvas.getNodes().get(i).setHeight(Canvas.getNodes().get(i).getHeight() + 5);
                    }
                    if (Canvas.getNodes().get(this.node).getWidth() < 90){
                        Canvas.getNodes().get(i).setWidth(Canvas.getNodes().get(i).getWidth() + 5);
                    }   
                }
                catch(IndexOutOfBoundsException ee){
                    //pas de noeud selectionné
                }
                if(!this.clicked || this.node == -1){
                    if(Canvas.getNodes().get(i).getHeight() < 75){
                        Canvas.getNodes().get(i).setHeight(Canvas.getNodes().get(i).getHeight() + 5);
                    }
                    if (Canvas.getNodes().get(i).getWidth() < 90){
                        Canvas.getNodes().get(i).setWidth(Canvas.getNodes().get(i).getWidth() + 5);
                    }
                } 
            }
            else if (this.clicked){
                try{
                    if(Canvas.getNodes().get(this.node).getHeight() < 75){
                        Canvas.getNodes().get(i).setHeight(75);
                    }
                    if (Canvas.getNodes().get(this.node).getWidth() < 90){
                        Canvas.getNodes().get(i).setWidth(90);
                    }
                }
                catch(IndexOutOfBoundsException ee){
                    //pas de noeud selectionné
                }
                Canvas.getNodes().get(i).resetSize();
            }
            else{
                Canvas.getNodes().get(i).resetSize();
            }
        }
        if(clicked){
            try{
                Canvas.getNodes().get(this.node).setPosX(x);
                Canvas.getNodes().get(this.node).setPosY(y - 35);
            }
            catch(IndexOutOfBoundsException ee){
                //pas de noeud selectionné
            }
        }  
        Canvas.repaint();     
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
}
