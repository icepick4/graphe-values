package graphe.values;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*
* Classe permettant de gérer les évènements de la souris sur le graphe (déplacement, clic, ...)
* Actions entre les noeuds
*/
public class ClickNode implements MouseListener, MouseMotionListener {
    private int[] nodesSelected = { -1, -1 };
    private int stateNode = 0;
    private GrapheApp app;
    private GUI gui;

    public ClickNode(GrapheApp app, GUI gui) {
        this.app = app;
        this.gui = gui;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        GrapheDraw Canvas = this.gui.getCanvas();
        int lastNode = -1;
        for (int i = 0; i < Canvas.getNbNodes(); i++) {
            if (x >= Canvas.getNodes().get(i).getPosX() - 50 && x <= Canvas.getNodes().get(i).getPosX() + 50
                    && y >= Canvas.getNodes().get(i).getPosY() + 10 && y <= Canvas.getNodes().get(i).getPosY() + 50) {
                lastNode = i;
            }
        }
        if (lastNode == -1) {
            this.nodesSelected[0] = -1;
            this.nodesSelected[1] = -1;
            this.stateNode = 0;
            this.resetSelections(Canvas);
            Canvas.repaint();
        }
        if (this.stateNode == 1 && lastNode == this.nodesSelected[0]) {
            this.nodesSelected[0] = -1;
            this.nodesSelected[1] = -1;
            this.stateNode = 0;
            this.resetSelections(Canvas);
            Canvas.repaint();
        }
        if (lastNode != -1) {
            if (this.stateNode == 0) {
                // reset node
                this.nodesSelected[0] = -1;
                this.nodesSelected[1] = -1;
                this.nodesSelected[this.stateNode] = lastNode;
                this.stateNode = 1;
                this.setSelections(Canvas);
            } else if (this.stateNode == 1) {
                this.nodesSelected[this.stateNode] = lastNode;
                this.setSelections(Canvas);
                this.stateNode = 0;
                if (this.gui.getRb_plusCulturel().isSelected()) {
                    // print return of the function plusCulturelle in Graphe in a new messageDialog
                    int result = this.app.getGraphe().plusCulturelle(Canvas.getNodes().get(this.nodesSelected[0]).getName(),
                            Canvas.getNodes().get(this.nodesSelected[1]).getName());
                    if (result == 1) {
                        JOptionPane.showMessageDialog(null, Canvas.getNodes().get(this.nodesSelected[0]).getName()
                                + " est plus culturel que " + Canvas.getNodes().get(this.nodesSelected[1]).getName());
                    } else if (result == 0) {
                        JOptionPane.showMessageDialog(null, Canvas.getNodes().get(this.nodesSelected[0]).getName()
                                + " n'est pas plus culturel que " + Canvas.getNodes().get(this.nodesSelected[1]).getName());
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Les noeuds " + Canvas.getNodes().get(this.nodesSelected[0]).getName() + " et "
                                        + Canvas.getNodes().get(this.nodesSelected[1]).getName()
                                        + " ne sont pas à 2 distance d'au moins un centre de loisir");
                    }
                } else if (this.gui.getRb_plusGastro().isSelected()) {
                    // print return of the function plusGastro in Graphe in a new messageDialog
                    int result = this.app.getGraphe().plusGastronomique(Canvas.getNodes().get(this.nodesSelected[0]).getName(),
                            Canvas.getNodes().get(this.nodesSelected[1]).getName());
                    if (result == 1) {
                        JOptionPane.showMessageDialog(null, Canvas.getNodes().get(this.nodesSelected[0]).getName()
                                + " est plus gastronomique que " + Canvas.getNodes().get(this.nodesSelected[1]).getName());
                    } else if (result == 0) {
                        JOptionPane.showMessageDialog(null, Canvas.getNodes().get(this.nodesSelected[0]).getName()
                                + " n'est pas plus gastronomique que " + Canvas.getNodes().get(this.nodesSelected[1]).getName());
                    } else {
                        JOptionPane.showMessageDialog(null, "Les noeuds " + Canvas.getNodes().get(this.nodesSelected[0]).getName()
                                + " et " + "ne sont pas à 2 distance d'au moins un restaurant");
                    }
                } else if (this.gui.getRb_plusOuvert().isSelected()) {
                    // print return of the function plusOuverte in Graphe in a new messageDialog
                    int result = this.app.getGraphe().plusOuverte(Canvas.getNodes().get(this.nodesSelected[0]).getName(),
                            Canvas.getNodes().get(this.nodesSelected[1]).getName());
                    if (result == 1) {
                        JOptionPane.showMessageDialog(null, Canvas.getNodes().get(this.nodesSelected[0]).getName()
                                + " est plus ouvert que " + Canvas.getNodes().get(this.nodesSelected[1]).getName());
                    } else if (result == 0) {
                        JOptionPane.showMessageDialog(null, Canvas.getNodes().get(this.nodesSelected[0]).getName()
                                + " n'est pas plus ouvert que " + Canvas.getNodes().get(this.nodesSelected[1]).getName());
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Les noeud s" + Canvas.getNodes().get(this.nodesSelected[0]).getName() + " et "
                                        + Canvas.getNodes().get(this.nodesSelected[1]).getName()
                                        + " ne sont pas à 2 distance d'au moins une ville");
                    }
                } else if (this.gui.getRb_plusCourteDistance().isSelected()) {
                    // print return of the function plusCourtChemin in Graphe in a new messageDialog
                    double result = this.app.getGraphe().plusCourtChemin(this.nodesSelected[0], this.nodesSelected[1]);
                    // cast result to String and if it ends with .0, remove it
                    String resultString = String.valueOf(result);
                    if (resultString.endsWith(".0")) {
                        resultString = resultString.substring(0, resultString.length() - 2);
                    }
                    if (result != 0) {
                        JOptionPane.showMessageDialog(null,
                                "Le plus court chemin entre " + Canvas.getNodes().get(this.nodesSelected[0]).getName() + " et "
                                        + Canvas.getNodes().get(this.nodesSelected[1]).getName() + " est de " + resultString);
                    } else {
                        JOptionPane.showMessageDialog(null, "Les noeuds " + Canvas.getNodes().get(this.nodesSelected[0]).getName()
                                + " et " + Canvas.getNodes().get(this.nodesSelected[1]).getName() + " ne sont pas reliés");
                    }
                } else if (this.gui.getRb_plusCourtChemin().isSelected()) {
                    // print return of the function floydWarshallChemin in Graphe in a new
                    // messageDialog
                    ArrayList<Integer> result = this.app.getGraphe().floydWarshallChemin(this.nodesSelected[0], this.nodesSelected[1]);
                    // browse result and print the path
                    if (result.size() != 0) {
                        String path = "Le plus court chemin entre " + Canvas.getNodes().get(this.nodesSelected[0]).getName() + " et "
                                + Canvas.getNodes().get(this.nodesSelected[1]).getName() + " est : " + "\n";
                        for (int i = 0; i < result.size() - 1; i++) {
                            path += Canvas.getNodes().get(result.get(i)).getName() + " -> ";
                        }
                        path += Canvas.getNodes().get(result.get(result.size() - 1)).getName();
                        JOptionPane.showMessageDialog(null, path);
                    } else {
                        JOptionPane.showMessageDialog(null, "Les noeuds " + Canvas.getNodes().get(this.nodesSelected[0]).getName()
                                + " et " + Canvas.getNodes().get(this.nodesSelected[1]).getName() + " ne sont pas reliés");
                    }
                } else if (this.gui.getRb_est2Distance().isSelected()) {
                    // print return of distance2 in Graphe in a new messageDialog
                    boolean result = this.app.getGraphe().distance2(this.nodesSelected[0], this.nodesSelected[1]);
                    if (result) {
                        JOptionPane.showMessageDialog(null,
                                "Les noeuds " + Canvas.getNodes().get(this.nodesSelected[0]).getName() + " et "
                                        + Canvas.getNodes().get(this.nodesSelected[1]).getName()
                                        + " sont à 2 distance l'un de l'autre");
                    } else if (!result) {
                        JOptionPane.showMessageDialog(null,
                                "Les noeuds " + Canvas.getNodes().get(this.nodesSelected[0]).getName() + " et "
                                        + Canvas.getNodes().get(this.nodesSelected[1]).getName()
                                        + " ne sont pas à 2 distance l'un de l'autre");
                    }
                }
                this.resetSelections(Canvas);
                Canvas.repaint();
            }
        }
        if (lastNode != -1) {
            int oneNodeState;
            if (this.stateNode == 1) {
                oneNodeState = 2;
            } else {
                oneNodeState = 3;
            }
            this.setSelections(Canvas, oneNodeState);
            if (this.gui.getRb_resto1Distance().isSelected()) {
                // print ArrayList of the function rDistance1 in Graphe in a new messageDialog
                ArrayList<String> result = this.app.getGraphe()
                        .Rdistance1(Canvas.getNodes().get(this.nodesSelected[oneNodeState - 2]).getName());
                if (result.size() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Le noeud " + Canvas.getNodes().get(this.nodesSelected[oneNodeState - 2]).getName()
                                    + " n'est pas à 1 distance d'au moins un restaurant");
                } else {
                    String message = "";
                    message += "Le(s) restaurant(s) relié(s) à "
                            + Canvas.getNodes().get(this.nodesSelected[oneNodeState - 2]).getName() + " est/sont : " + "\n\n";
                    for (int i = 0; i < result.size(); i++) {
                        message += "-" + result.get(i) + "\n";
                    }
                    JOptionPane.showMessageDialog(null, message);
                }
                this.resetSelections(Canvas);
                Canvas.repaint();
            } else if (this.gui.getRb_ville1Distance().isSelected()) {
                // print ArrayList of the function vDistance1 in Graphe in a new messageDialog
                ArrayList<String> result = this.app.getGraphe()
                        .Vdistance1(Canvas.getNodes().get(this.nodesSelected[oneNodeState - 2]).getName());
                if (result.size() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Le noeud " + Canvas.getNodes().get(this.nodesSelected[oneNodeState - 2]).getName()
                                    + " n'est pas à 1 distance d'au moins une ville");
                } else {
                    String message = "";
                    message += "La(les) ville(s) relié(s) à " + Canvas.getNodes().get(this.nodesSelected[oneNodeState - 2]).getName()
                            + " est/sont : " + "\n\n";
                    for (int i = 0; i < result.size(); i++) {
                        message += "-" + result.get(i) + "\n";
                    }
                    JOptionPane.showMessageDialog(null, message);
                }
                this.resetSelections(Canvas);
                Canvas.repaint();
            } else if (this.gui.getRb_loisir1Distance().isSelected()) {
                // print ArrayList of the function lDistance1 in Graphe in a new messageDialog
                ArrayList<String> result = this.app.getGraphe()
                        .Ldistance1(Canvas.getNodes().get(this.nodesSelected[oneNodeState - 2]).getName());
                if (result.size() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Le noeud " + Canvas.getNodes().get(this.nodesSelected[oneNodeState - 2]).getName()
                                    + " n'est pas à 1 distance d'au moins un centre de loisir");
                } else {
                    String message = "";
                    message += "Le(s) centre(s) de loisir relié(s) à "
                            + Canvas.getNodes().get(this.nodesSelected[oneNodeState - 2]).getName() + " est/sont : " + "\n\n";
                    for (int i = 0; i < result.size(); i++) {
                        message += "-" + result.get(i) + "\n";
                    }
                    JOptionPane.showMessageDialog(null, message);
                }
                this.resetSelections(Canvas);
                Canvas.repaint();
            }
            else if(this.gui.getRb_selectNoeudInfos().isSelected()){
                //display infos about the node selected in a new messageDialog
                String message = "";
                message += "Nom : " + Canvas.getNodes().get(this.nodesSelected[oneNodeState - 2]).getName() + "\n";
                String type = Canvas.getNodes().get(this.nodesSelected[oneNodeState - 2]).getType();
                if(type.equals("V")){
                    message += "Type : Ville" + "\n";
                }
                else if(type.equals("R")){
                    message += "Type : Restaurant" + "\n";
                }
                else if(type.equals("L")){
                    message += "Type : Centre de loisir" + "\n";
                }
                //display degres with method degre in graphe : first value is global degre, second value is indegre, third value is outdegre
                int[] degres = this.app.getGraphe().degre(Canvas.getNodes().get(this.nodesSelected[oneNodeState - 2]).getName());
                message += "Degré : " + degres[0] + "\n";
                JOptionPane.showMessageDialog(null, message);
                this.resetSelections(Canvas);
                Canvas.repaint();
            }
            if (this.stateNode == 0) {
                this.resetSelections(Canvas);
            }
        }
    }

    public void resetNodes() {
        this.nodesSelected[0] = -1;
        this.nodesSelected[1] = -1;
        this.stateNode = 0;
    }

    /**
     * Sélectionne le noeud sélectionné (action où 1 noeud est sélectionné)
     * 
     * @param Canvas
     * @param oneNodeState
     */
    private void setSelections(GrapheDraw Canvas) {
        // set selected true to the node in node and set selected false to the other
        // nodes
        for (int i = 0; i < Canvas.getNodes().size(); i++) {
            if (i == this.nodesSelected[0] || i == this.nodesSelected[1]) {
                Canvas.getNodes().get(i).setSelected(true);
            } else {
                Canvas.getNodes().get(i).setSelected(false);
            }
        }
        Canvas.repaint();
    }

    /**
     * Sélectionne le noeud sélectionné (actions où deux noeuds sont sélectionnés)
     * 
     * @param Canvas
     * @param oneNodeState
     */
    private void setSelections(GrapheDraw Canvas, int oneNodeState) {
        // set selected true to the node in node and set selected false to the other
        // nodes
        for (int i = 0; i < Canvas.getNodes().size(); i++) {
            if (i == this.nodesSelected[oneNodeState - 2]) {
                Canvas.getNodes().get(i).setSelected(true);
            } else {
                Canvas.getNodes().get(i).setSelected(false);
            }
        }
        Canvas.repaint();
    }

    /**
     * Déselectionne tous les noeuds
     * 
     * @param Canvas
     */
    public void resetSelections(GrapheDraw Canvas) {
        // set selected false to all nodes
        for (int i = 0; i < Canvas.getNodes().size(); i++) {
            Canvas.getNodes().get(i).setSelected(false);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        GrapheDraw Canvas = this.gui.getCanvas();
        int x = e.getX();
        int y = e.getY();
        for (int i = 0; i < Canvas.getNbNodes(); i++) {
            if (x >= Canvas.getNodes().get(i).getPosX() - 50 && x <= Canvas.getNodes().get(i).getPosX() + 50
                    && y >= Canvas.getNodes().get(i).getPosY() + 10 && y <= Canvas.getNodes().get(i).getPosY() + 50) {
                //this node is selected
                Canvas.getNodes().get(i).setSelected(true);
                Canvas.repaint();
            }
            else{
                //if the node is not clicked
                if(Canvas.getNodes().get(i).isSelected() && (this.nodesSelected[0] == -1 || i != this.nodesSelected[0])){
                    //if the node is not selected
                    Canvas.getNodes().get(i).setSelected(false);
                    Canvas.repaint();
                }
                Canvas.repaint();
            }
        }
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
    @Override
    public void mouseDragged(MouseEvent e) {
    }
}
