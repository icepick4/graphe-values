package graphe.values;

import java.io.IOException;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JRadioButton;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Desktop;
import java.awt.Color;

/**
 *
 * @author matisse
 * @author Rémi JARA
 * @version 1.0
 */
public class GUI extends javax.swing.JFrame {
    private GrapheApp app;
    private Graphe graphe;
    private String fileName;
    public boolean opened;
    private HoverMoveNode click;
    private ClickNode twoNode;
    private ClickEdge clickEdge;
    /**
     * Creates new form GUI
     */
    public GUI(GrapheApp graphe) {
        this.app = graphe;
        this.graphe = this.app.getGraphe();

        this.initComponents();
        this.fileName = null;
        this.opened = false;
    }

    public String getFileName(){
        return this.fileName;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        this.setMinimumSize(new Dimension(1400, 850));
        this.click = new HoverMoveNode(this);
        this.twoNode = new ClickNode(this.app, this);
        this.clickEdge = new ClickEdge(this);
        this.addMouseMotionListener(click);
        this.addMouseListener(click);

        jFrame1 = new javax.swing.JFrame();
        jFileChooser1 = new javax.swing.JFileChooser();
        jToolBar1 = new javax.swing.JToolBar();
        toolBarPan = new javax.swing.JPanel();
        lbl_affichage = new javax.swing.JLabel();
        nbVille = new javax.swing.JLabel();
        nbRestaurant = new javax.swing.JLabel();
        nbLoisir = new javax.swing.JLabel();
        nbDepartementale = new javax.swing.JLabel();
        nbNationale = new javax.swing.JLabel();
        nbAutoroute = new javax.swing.JLabel();
        cb_ville = new javax.swing.JCheckBox();
        cb_restaurant = new javax.swing.JCheckBox();
        cb_loisirs = new javax.swing.JCheckBox();
        cb_autoroute = new javax.swing.JCheckBox();
        cb_nationale = new javax.swing.JCheckBox();
        cb_departementale = new javax.swing.JCheckBox();
        labelAction = new javax.swing.JLabel();
        selectNoeud = new javax.swing.JRadioButton();
        resto1Distance = new javax.swing.JRadioButton();
        ville1Distance = new javax.swing.JRadioButton();
        loisir1Distance = new javax.swing.JRadioButton();
        plusCulturel = new javax.swing.JRadioButton();
        plusOuvert = new javax.swing.JRadioButton();
        plusGastro = new javax.swing.JRadioButton();
        plusCourteDistance = new javax.swing.JRadioButton();
        plusCourtChemin = new javax.swing.JRadioButton();
        est2Distance = new javax.swing.JRadioButton();
        selectEdge = new javax.swing.JRadioButton();
        selectNoeudInfos = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        Canvas = new GrapheDraw(this);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openFile = new javax.swing.JMenuItem();
        modifyFile = new javax.swing.JMenuItem();
        newWindow = new javax.swing.JMenuItem();
        closeFile = new javax.swing.JMenuItem();
        quitter = new javax.swing.JMenuItem();
        affichage_menu = new javax.swing.JMenu();
        options_menu = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        couleur_fond = new javax.swing.JMenuItem();
        
        jFileChooser1.setCurrentDirectory(new java.io.File("./inputFiles"));
        jFileChooser1.setDialogTitle("Choisissez un fichier de Graphe");
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("TXT File","txt"));
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("CSV File","csv"));
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jFileChooser1ActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        //this.setResizable(false);
        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        jToolBar1.setRollover(true);


        lbl_affichage.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        lbl_affichage.setText("Noeuds :");

        cb_ville.setSelected(true);
        cb_ville.setText("Villes");
        cb_ville.setForeground(Color.GREEN);
        cb_ville.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_villeActionPerformed(evt);
            }
        });

        cb_restaurant.setSelected(true);
        cb_restaurant.setText("Restaurants");
        cb_restaurant.setForeground(Color.RED);
        cb_restaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_restaurantActionPerformed(evt);
            }
        });

        cb_loisirs.setSelected(true);
        cb_loisirs.setText("Loisirs");
        cb_loisirs.setForeground(Color.YELLOW);
        cb_loisirs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_loisirsActionPerformed(evt);
            }
        });

        //increase the size of jLabel1
        jLabel1.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        jLabel1.setText("Liens :");

        cb_autoroute.setSelected(false);
        cb_autoroute.setText("Autoroutes");
        cb_autoroute.setForeground(Color.MAGENTA);
        cb_autoroute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_autorouteActionPerformed(evt);
            }
        });

        cb_nationale.setSelected(false);
        cb_nationale.setText("Nationales");
        cb_nationale.setForeground(Color.cyan);
        cb_nationale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_nationaleActionPerformed(evt);
            }
        });

        cb_departementale.setSelected(true);
        cb_departementale.setText("Departementales");
        cb_departementale.setForeground(Color.BLUE);
        cb_departementale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_departementaleActionPerformed(evt);
            }
        });

        selectNoeud.setSelected(true);
        selectNoeud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectNoeudActionPerformed(evt);
            }
        });

        plusCulturel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                twoNodeListener();
            }
        });

        plusGastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                twoNodeListener();
            }
        });

        plusOuvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                twoNodeListener();
            }
        });

        resto1Distance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                twoNodeListener();
            }
        });

        ville1Distance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                twoNodeListener();
            }
        });

        loisir1Distance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {                
                twoNodeListener();
            }
        });

        plusCourteDistance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                twoNodeListener();
            }
        });

        plusCourtChemin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                twoNodeListener();
            }
        });

        est2Distance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                twoNodeListener();
            }
        });

        selectEdge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                clickEdgeListener();
            }
        });

        selectNoeudInfos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                twoNodeListener();
            }
        });

        nbVille.setText("Nombre : 0");
        nbRestaurant.setText("Nombre : 0");
        nbLoisir.setText("Nombre : 0");
        nbAutoroute.setText("Nombre : 0");
        nbNationale.setText("Nombre : 0");
        nbDepartementale.setText("Nombre : 0");

        ButtonGroup group = new ButtonGroup();
        group.add(selectNoeud);
        group.add(resto1Distance);
        group.add(ville1Distance);
        group.add(loisir1Distance);
        group.add(plusCulturel);
        group.add(plusGastro);
        group.add(plusOuvert);
        group.add(plusCourteDistance);
        group.add(plusCourtChemin);
        group.add(est2Distance);
        group.add(selectEdge);
        group.add(selectNoeudInfos);

        labelAction.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        labelAction.setText("Actions :");
        selectNoeud.setText("Bouger les noeuds");
        resto1Distance.setText("Resto 1 Distance");
        ville1Distance.setText("Ville 1 Distance");
        loisir1Distance.setText("Loisir 1 Distance");
        plusCulturel.setText("Plus Culturel");
        plusGastro.setText("Plus Gastronomique");
        plusOuvert.setText("Plus Ouvert");
        plusCourteDistance.setText("Plus Courte Distance (valeur)");
        plusCourtChemin.setText("Plus Court Chemin");
        est2Distance.setText("Est 2 Distance ?");
        selectEdge.setText("Infos arêtes");
        selectNoeudInfos.setText("Infos noeuds");

  
        jScrollPane1.setViewportView(jToolBar1);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        javax.swing.GroupLayout toolBarPanLayout = new javax.swing.GroupLayout(toolBarPan);
        toolBarPan.setLayout(toolBarPanLayout);
        toolBarPanLayout.setHorizontalGroup(
            toolBarPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolBarPanLayout.createSequentialGroup()
                .addGroup(toolBarPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_loisirs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_restaurant, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(cb_ville, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_affichage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nbVille, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nbRestaurant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nbLoisir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nbDepartementale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nbAutoroute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nbNationale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                ))
                        .addComponent(cb_autoroute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_nationale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_departementale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selectNoeud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resto1Distance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ville1Distance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loisir1Distance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plusCulturel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plusGastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plusOuvert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plusCourteDistance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plusCourtChemin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(est2Distance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selectEdge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selectNoeudInfos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        toolBarPanLayout.setVerticalGroup(
            toolBarPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolBarPanLayout.createSequentialGroup()
                .addComponent(lbl_affichage)
                .addComponent(cb_ville)
                .addComponent(nbVille)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_restaurant)
                .addComponent(nbRestaurant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_loisirs)
                .addComponent(nbLoisir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGap(18, 18, 18)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addComponent(cb_autoroute)
                .addComponent(nbAutoroute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_nationale)
                .addComponent(nbNationale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_departementale)
                .addComponent(nbDepartementale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGap(18, 18, 18)
                .addGap(18, 18, 18)
                .addComponent(labelAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(selectNoeud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resto1Distance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ville1Distance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loisir1Distance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plusCulturel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plusGastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plusOuvert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plusCourteDistance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plusCourtChemin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(est2Distance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectEdge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectNoeudInfos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(421, Short.MAX_VALUE))
                
        );

        jToolBar1.add(toolBarPan);

        javax.swing.GroupLayout CanvasLayout = new javax.swing.GroupLayout(Canvas);
        Canvas.setLayout(CanvasLayout);
        CanvasLayout.setHorizontalGroup(
            CanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 864, Short.MAX_VALUE)
        );
        CanvasLayout.setVerticalGroup(
            CanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu1.setText("Fichier");
        openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openFile.setText("Ouvrir");
        openFile.setToolTipText("");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });

        newWindow.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newWindow.setText("Nouvelle fenêtre");
        newWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newWindowActionPerformed(evt);
            }
        });

        closeFile.setText("Fermer le fichier actuel");
        closeFile.setEnabled(false);
        closeFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFileActionPerformed(evt);
            }
        });

        quitter.setText("Quitter");
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterActionPerformed(evt);
            }
        });
        
        jMenu1.add(openFile);
        jMenu1.add(newWindow);
        jMenu1.add(closeFile);
        jMenu1.add(quitter);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Modifier");
        jMenu2.add(modifyFile);
        jMenuBar1.add(jMenu2);
        modifyFile.setText("Ouvrir avec le Bloc-Notes");
        modifyFile.setToolTipText("");
        modifyFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    menuModifActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        setJMenuBar(jMenuBar1);
        affichage_menu.setText("Affichage");
        options_menu.setSelected(true);
        options_menu.setText("Menu d'options");
        options_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                options_menuActionPerformed(evt);
            }
        });
        affichage_menu.add(options_menu);

        couleur_fond.setText("Couleur de fond");
        couleur_fond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                couleur_fondActionPerformed(evt);
            }
        });
        affichage_menu.add(couleur_fond);
        
        jMenuBar1.add(affichage_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                //add jscrollpane1

        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, this.getHeight(), javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jToolBar1.revalidate();

        this.pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_jFileChooser1ActionPerformed
        this.fileName = jFileChooser1.getSelectedFile().getAbsolutePath();
        this.opened = true;
        try{
            this.app.initApp();
            this.closeFile.setEnabled(true);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Le graphe ne correspond pas au format attendu (erreur de synthaxe)");
            //open a new message dialog
            JOptionPane.showMessageDialog(null, "Le graphe ne correspond pas au format attendu (erreur de synthaxe)", "Erreur", JOptionPane.ERROR_MESSAGE);
            this.setTitle("Le graphe ne correspond pas au format attendu (erreur de synthaxe)");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Le graphe ne correspond pas au format attendu : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            System.out.println("Le graphe ne correspond pas au format attendu, erreur inconnu : " + e.getMessage());
            this.setTitle("Le graphe ne correspond pas au format attendu");
        }
        setNombres();
        jFrame1.dispose();
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void options_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_options_menuActionPerformed
        this.jToolBar1.setVisible(this.options_menu.isSelected());
    }
    
    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        Canvas.clear();
        try{
            this.graphe = app.getGraphe();
            Canvas.drawGraph(graphe);
            Canvas.changePos();
            Canvas.repaint();
        }
        catch(NullPointerException e){
            //pas de graphe chargé
        }
    }//GEN-LAST:event_formComponentResized

    private void couleur_fondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choisir_fontActionPerformed
        //open jColorChooser and get the color
        Color color = JColorChooser.showDialog(this, "Choisir une couleur pour le fond", this.Canvas.getBackground());
        //set the color
        this.Canvas.setBackground(color);
    }

    private void selectNoeudActionPerformed(java.awt.event.ActionEvent evt){
        this.removeListeners();
        this.addMouseListener(click);
        this.addMouseMotionListener(click);
    }

    private void clickEdgeListener(){
        this.removeListeners();
        this.addMouseListener(clickEdge);
        this.addMouseMotionListener(clickEdge);
    }

    private void twoNodeListener(){
        this.removeListeners();
        this.addMouseListener(twoNode);
        this.addMouseMotionListener(twoNode);
    }

    private void removeListeners(){
        this.removeMouseListener(click);
        this.removeMouseMotionListener(click);
        this.removeMouseListener(twoNode);
        this.removeMouseMotionListener(twoNode);
        this.removeMouseListener(clickEdge);
        this.removeMouseMotionListener(clickEdge);
        this.twoNode.resetNodes();
        this.twoNode.resetSelections(Canvas);
        this.Canvas.repaint();
    }

    private void cb_villeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_villeActionPerformed
        try{
            this.Canvas.clear();
            this.graphe = this.app.getGraphe();
            this.Canvas.drawGraph(graphe);
        }
        catch(NullPointerException e){
            //open new message dialog
            JOptionPane.showMessageDialog(null, "Aucun graphe n'est ouvert", "Erreur", JOptionPane.ERROR_MESSAGE);
            System.out.println("Pas de graphe");
        }
    }//GEN-LAST:event_cb_villeActionPerformed

    private void cb_restaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_restaurantActionPerformed
        try{
            this.Canvas.clear();
            graphe = this.app.getGraphe();
            this.Canvas.drawGraph(graphe);
        }
        catch(NullPointerException e){
            //open new message dialog
            JOptionPane.showMessageDialog(null, "Aucun graphe n'est ouvert", "Erreur", JOptionPane.ERROR_MESSAGE);
            System.out.println("Pas de graphe");
        }
    }//GEN-LAST:event_cb_restaurantActionPerformed

    private void cb_loisirsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_loisirsActionPerformed
        try{
            Canvas.clear();
            graphe = this.app.getGraphe();
            Canvas.drawGraph(graphe);
        }
        catch(NullPointerException e){
            //open new message dialog
            JOptionPane.showMessageDialog(null, "Aucun graphe n'est ouvert", "Erreur", JOptionPane.ERROR_MESSAGE);
            System.out.println("Pas de graphe");
        }
    }//GEN-LAST:event_cb_loisirsActionPerformed

    private void cb_autorouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_autorouteActionPerformed
        try{
            Canvas.clear();
            graphe = this.app.getGraphe();
            Canvas.drawGraph(graphe);
        }
        catch(NullPointerException e){
            //open new message dialog
            JOptionPane.showMessageDialog(null, "Aucun graphe n'est ouvert", "Erreur", JOptionPane.ERROR_MESSAGE);
            System.out.println("Pas de graphe");
        }
    }//GEN-LAST:event_cb_autorouteActionPerformed

    private void cb_nationaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_nationalesActionPerformed
        try{
            Canvas.clear();
            graphe = this.app.getGraphe();
            Canvas.drawGraph(graphe);
        }
        catch(NullPointerException e){
            //open new message dialog
            JOptionPane.showMessageDialog(null, "Aucun graphe n'est ouvert", "Erreur", JOptionPane.ERROR_MESSAGE);
            System.out.println("Pas de graphe");
        }
    }//GEN-LAST:event_cb_nationalesActionPerformed

    private void cb_departementaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_departementaleActionPerformed
        try{
            Canvas.clear();
            graphe = this.app.getGraphe();
            Canvas.drawGraph(graphe);
        }
        catch(NullPointerException e){
            //open new message dialog
            JOptionPane.showMessageDialog(null, "Aucun graphe n'est ouvert", "Erreur", JOptionPane.ERROR_MESSAGE);
            System.out.println("Pas de graphe");
        }
    }//GEN-LAST:event_cb_departementaleActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {
        jFrame1.pack();
        jFrame1.setVisible(true);
    }

    private void newWindowActionPerformed(java.awt.event.ActionEvent evt) {
        new GrapheApp();
    }

    private void closeFileActionPerformed(java.awt.event.ActionEvent evt) {
        this.closeFile.setEnabled(false);
        //reset the graph
        this.graphe = null;
        this.fileName = null;
        this.app.graphe = null;
        this.Canvas.clear();
    }

    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterActionPerformed
        //close the jFrame
        this.dispose();
    }
    

    private void setNombres(){
        try{
            nbVille.setText("Nombre : " + this.app.getGraphe().getNbVille());
            nbRestaurant.setText("Nombre : " +  this.app.getGraphe().getNbRestaurant());
            nbLoisir.setText("Nombre : " +  this.app.getGraphe().getNbLoisir());
            nbAutoroute.setText("Nombre : " +  this.app.getGraphe().getNbAutoroutes());
            nbNationale.setText("Nombre : " +  this.app.getGraphe().getNbNationales());
            nbDepartementale.setText("Nombre : " +  this.app.getGraphe().getNbDepartementales());
        }
        catch(NullPointerException e){
            nbVille.setText("Nombre : 0");
            nbRestaurant.setText("Nombre : 0");
            nbLoisir.setText("Nombre : 0");
            nbAutoroute.setText("Nombre : 0");
            nbNationale.setText("Nombre : 0");
            nbDepartementale.setText("Nombre : 0");
        }
    }

    private void menuModifActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_menuModifActionPerformed
        try{
            //constructor of file class having file as argument  
            File file = new File(this.getFileName());   
            if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
            {  
                JOptionPane.showMessageDialog(null, "Desktop n'est pas supporté", "Erreur", JOptionPane.ERROR_MESSAGE);  
                return;  
            }  
            Desktop desktop = Desktop.getDesktop();  
            if(file.exists()){         //checks file exists or not  
                desktop.open(file);
            }              //opens the specified file  
        }
        catch(NullPointerException e){
            //open new message dialog
            JOptionPane.showMessageDialog(null, "Pas de graphe chargé", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            //open new message dialog
            JOptionPane.showMessageDialog(null, "Erreur dans l'ouverture du fichier", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        
    }//GEN-LAST:event_menuModifActionPerformed
    //getter cb
    public JCheckBox getCb_ville() {
        return cb_ville;
    }

    public JCheckBox getCb_restaurant() {
        return cb_restaurant;
    }

    public JCheckBox getCb_autoroute() {
        return cb_autoroute;
    }

    public JCheckBox getCb_nationale() {
        return cb_nationale;
    }

    public JCheckBox getCb_departementale() {
        return cb_departementale;
    }

    public JCheckBox getCb_loisirs() {
        return cb_loisirs;
    }

    public JRadioButton getRb_resto1Distance(){
        return resto1Distance;
    }

    public JRadioButton getRb_ville1Distance(){
        return ville1Distance;
    }

    public JRadioButton getRb_loisir1Distance(){
        return loisir1Distance;
    }

    public JRadioButton getRb_selectNoeud(){
        return selectNoeud;
    }

    public JRadioButton getRb_plusGastro(){
        return plusGastro;
    }

    public JRadioButton getRb_plusOuvert(){
        return plusOuvert;
    }

    public JRadioButton getRb_plusCulturel(){
        return plusCulturel;
    }

    public JRadioButton getRb_plusCourteDistance(){
        return plusCourteDistance;
    }

    public JRadioButton getRb_plusCourtChemin(){
        return plusCourtChemin;
    }

    public JRadioButton getRb_est2Distance(){
        return est2Distance;
    }

    public GrapheDraw getCanvas() {
        return Canvas;
    }

    public JRadioButton getRb_selectEdge(){
        return selectEdge;
    }

    public JRadioButton getRb_selectNoeudInfos(){
        return selectNoeudInfos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GrapheDraw Canvas;
    private javax.swing.JCheckBox cb_loisirs;
    private javax.swing.JCheckBox cb_restaurant;
    private javax.swing.JCheckBox cb_ville;
    private javax.swing.JCheckBox cb_departementale;
    private javax.swing.JCheckBox cb_nationale;
    private javax.swing.JCheckBox cb_autoroute;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem newWindow;
    private javax.swing.JMenuItem closeFile;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_affichage;
    private javax.swing.JLabel nbVille;
    private javax.swing.JLabel nbRestaurant;
    private javax.swing.JLabel nbAutoroute;
    private javax.swing.JLabel nbNationale;
    private javax.swing.JLabel nbDepartementale;
    private javax.swing.JLabel nbLoisir;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem modifyFile;
    private javax.swing.JMenuItem quitter;
    private javax.swing.JPanel toolBarPan;
    private javax.swing.JLabel labelAction;
    private javax.swing.JCheckBoxMenuItem options_menu;
    private javax.swing.JMenu affichage_menu;
    private javax.swing.JRadioButton selectNoeud;
    private javax.swing.JRadioButton resto1Distance;
    private javax.swing.JRadioButton ville1Distance;
    private javax.swing.JRadioButton loisir1Distance;
    private javax.swing.JRadioButton est2Distance;
    private javax.swing.JRadioButton plusGastro;
    private javax.swing.JRadioButton plusOuvert;
    private javax.swing.JRadioButton plusCulturel;
    private javax.swing.JRadioButton plusCourteDistance;
    private javax.swing.JRadioButton plusCourtChemin;
    private javax.swing.JRadioButton selectEdge;
    private javax.swing.JRadioButton selectNoeudInfos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem couleur_fond;

    // End of variables declaration//GEN-END:variables
}



