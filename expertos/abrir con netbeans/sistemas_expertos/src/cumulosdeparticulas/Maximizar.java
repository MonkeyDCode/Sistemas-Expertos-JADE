package cumulosdeparticulas;

import java.awt.Color;

public class Maximizar extends javax.swing.JFrame {
int[][] mat={{0,0,1,0,1,0},
                 {0,0,0,0,0,1},
                 {1,0,0,1,0,0},
                 {0,0,1,0,1,0},
                 {1,0,0,1,0,1},
                 {0,1,0,0,1,0}};
    int valorPar0;
    int valorPar1;
    int valorPar2;
    int valorPar3;
    int[] particula0;
    int[] particula1;
    int[] particula2;
    int[] particula3;
    int cambiar1;   // Elemento a Cambiar en la Particula
    int cambiar2;   // Elemento a Cambiar en la Particula
    int parMenor;   // Particula Menor (Indica que vector hay que conservar)
    int parMayor;   // Particula Mayor (Indica que vector hay que conservar)
    int pos1;       // Posición de la partiucla c1
    int pos2;
    int[] vecAux = {0,0,0,0,0,0};
    int bandera =0;
    public Maximizar(int c1,int pos1, int c2, int pos2, int pM){
        this.cambiar1 = c1;
        this.cambiar2 = c2;
        this.parMenor = pM;
        this.pos1 = pos1;
        this.pos2 = pos2;
        initComponents();
    }
        // Minimizar(cambiar1,posicion1,cambiar2,posicion2,particulaMenor,variablesUsadas)
    public Maximizar(int c1,int pos1, int c2, int pos2, int pM,int[] vUsadas,int b){
        this.cambiar1 = c1;
        this.cambiar2 = c2;
        this.parMenor = pM;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.vecAux = vUsadas;
        this.bandera=b;
        initComponents();
    }
    public void variablesUsadas(){  // Identificar las variables que ya se usaron
        for(int i=0;i<6;i++){
            if(this.vecAux[i]==0 && i==this.cambiar1){
                this.vecAux[i]=1;
            }
            if(this.vecAux[i]==0 && i==this.cambiar2){
                this.vecAux[i]=1;
            }
        }
        this.siguienteRonda();      //Asignar la nuevas cariables a intercabmiar
    }
    public void setParticulas(int[] p0,int[] p1,int[] p2,int[] p3){
        this.particula0=p0;
        this.particula1=p1;
        this.particula2=p2;
        this.particula3=p3;        
    }
    public void trabaja(){
        switch(this.parMenor){
            case 0:                
                this.particula1=this.intercambiarParticula(pos1, this.particula1, this.cambiar1);
                this.particula1=this.intercambiarParticula(pos2, this.particula1, this.cambiar2);
                this.particula2=this.intercambiarParticula(pos1, this.particula2, this.cambiar1);
                this.particula2=this.intercambiarParticula(pos2, this.particula2, this.cambiar2);
                this.particula3=this.intercambiarParticula(pos1, this.particula3, this.cambiar1);
                this.particula3=this.intercambiarParticula(pos2, this.particula3, this.cambiar2);
                jLabel4.setBackground(Color.CYAN);
                break;
            case 1:
                this.particula0=this.intercambiarParticula(pos1, this.particula0, this.cambiar1);
                this.particula0=this.intercambiarParticula(pos2, this.particula0, this.cambiar2);
                this.particula2=this.intercambiarParticula(pos1, this.particula2, this.cambiar1);
                this.particula2=this.intercambiarParticula(pos2, this.particula2, this.cambiar2);
                this.particula3=this.intercambiarParticula(pos1, this.particula3, this.cambiar1);
                this.particula3=this.intercambiarParticula(pos2, this.particula3, this.cambiar2);
                jLabel6.setBackground(Color.CYAN);
                break;
            case 2:
                this.particula1=this.intercambiarParticula(pos1, this.particula1, this.cambiar1);
                this.particula1=this.intercambiarParticula(pos2, this.particula1, this.cambiar2);
                this.particula0=this.intercambiarParticula(pos1, this.particula0, this.cambiar1);
                this.particula0=this.intercambiarParticula(pos2, this.particula0, this.cambiar2);
                this.particula3=this.intercambiarParticula(pos1, this.particula3, this.cambiar1);
                this.particula3=this.intercambiarParticula(pos2, this.particula3, this.cambiar2);
                jLabel8.setBackground(Color.CYAN);
                break;
            case 3:
                this.particula1=this.intercambiarParticula(pos1, this.particula1, this.cambiar1);
                this.particula1=this.intercambiarParticula(pos2, this.particula1, this.cambiar2);
                this.particula2=this.intercambiarParticula(pos1, this.particula2, this.cambiar1);
                this.particula2=this.intercambiarParticula(pos2, this.particula2, this.cambiar2);
                this.particula0=this.intercambiarParticula(pos1, this.particula0, this.cambiar1);
                this.particula0=this.intercambiarParticula(pos2, this.particula0, this.cambiar2);
                jLabel10.setBackground(Color.CYAN);
                break;
        }
        this.verParticulaObjeto(0);
        this.verParticulaObjeto(1);
        this.verParticulaObjeto(2);
        this.verParticulaObjeto(3);
        this.verEvaluar();
        this.variablesUsadas();
    }
    public int[] intercambiarParticula(int pos, int[] par, int var){
        int aux=par[pos];
        int indice=0;
        for(int i=0;i<6;i++){
            if(par[i]==var){
                indice=i;
            }
        }
        par[pos]=var;
        par[indice]=aux;
        return par;
    }
    public void verParticulaObjeto(int pOb){
        switch(pOb){
            case 0:
                jLabel4.setText(convTexto(this.particula0));
                break;
            case 1:
                jLabel6.setText(convTexto(this.particula1));
                break;
            case 2:
                jLabel8.setText(convTexto(this.particula2));
                break;
            case 3:
                jLabel10.setText(convTexto(this.particula3));
                break;
        }
    }
    public String convTexto(int[] vec){
        String text = "";
        for(int i=0;i<6;i++){
            if(vec[i]==0){
                text = text+"A"+" ";
            }
            if(vec[i]==1){
                text = text+"B"+" ";
            }
            if(vec[i]==2){
                text = text+"C"+" ";
            }
            if(vec[i]==3){
                text = text+"D"+" ";
            }
            if(vec[i]==4){
                text = text+"E"+" ";
            }
            if(vec[i]==5){
                text = text+"F"+" ";
            }
        }
        return text;
    }
    public void verEvaluar(){
        jLabel20.setText(Integer.toString(evaluarFuncion(particula0)));
        this.valorPar0 = evaluarFuncion(particula0);
        jLabel21.setText(Integer.toString(evaluarFuncion(particula1)));
        this.valorPar1 = evaluarFuncion(particula1);
        jLabel22.setText(Integer.toString(evaluarFuncion(particula2)));
        this.valorPar2 = evaluarFuncion(particula2);
        jLabel23.setText(Integer.toString(evaluarFuncion(particula3)));
        this.valorPar3 = evaluarFuncion(particula3);
        switch(cambiar1){
            case 0:
                jLabel2.setText("A");
                break;
            case 1:
                jLabel2.setText("B");
                break;
            case 2:
                jLabel2.setText("C");
                break;
            case 3:
                jLabel2.setText("D");
                break;
            case 4:
                jLabel2.setText("E");
                break;
            case 5:
                jLabel2.setText("F");
                break;
        }
        switch(cambiar2){
            case 0:
                jLabel19.setText("A");
                break;
            case 1:
                jLabel19.setText("B");
                break;
            case 2:
                jLabel19.setText("C");
                break;
            case 3:
                jLabel19.setText("D");
                break;
            case 4:
                jLabel19.setText("E");
                break;
            case 5:
                jLabel19.setText("F");
                break;
        }
    }
    public int evaluarFuncion(int[] vec){
        int num=0;
        for(int i=0;i<6;i++){
            num=num+identificar(vec[i],i);
        }
        return num;
    }    
    public int identificar(int val, int pos){
        int num=0;
        if(mat[val][pos]==1){
            num=num+(val+1);
        }
        return num;
    }
    public int elegirMayor(){
        int b=0;
        int mayor = this.valorPar0;
        if(this.valorPar1>mayor){
            mayor=this.valorPar1;
            b=1;
        }
        if(this.valorPar2>mayor){
            mayor=this.valorPar2;
            b=2;
        }
        if(this.valorPar3>mayor){
            mayor=this.valorPar3;
            b=3;
        }
        jLabel4.setBackground(Color.WHITE);
        jLabel6.setBackground(Color.WHITE);
        jLabel8.setBackground(Color.WHITE);
        jLabel10.setBackground(Color.WHITE);
        switch(b){
            case 1:
                jLabel6.setBackground(Color.CYAN);
                return 1;
            case 2:
                jLabel8.setBackground(Color.CYAN);
                return 2;
            case 3:
                jLabel10.setBackground(Color.CYAN);
                return 3;
            default:
                jLabel4.setBackground(Color.CYAN);
                return 0;
        }        
    }
    public int buscarPosicion(int var,int[] par){
        int pos=0;
        for(int i=0;i<6;i++){
            if(par[i]==var){
                pos=i;
                break;
            }
        }
        return pos;
    }
    public int[] particulaMenor(int opc){
        switch(opc){
            case 0:
                return this.particula0;
            case 1:
                return this.particula1;
            case 2:
                return this.particula2;
            default:
                return this.particula3;
        }
    }
    public void siguienteRonda(){
        for(int i=0;i<6;i++){   // Elegir Variables a Intercambiar1
            if(this.vecAux[i]==0){
                this.cambiar1=i;
                break;
            }            
        }
        for(int i=0;i<6;i++){   // Elegir Variables a Intercambiar2
            if(this.vecAux[i]==0 && i>this.cambiar1){
                this.cambiar2=i;
                break;
            }
        }
        if(this.bandera==0){
            Maximizar vMini = new Maximizar(this.cambiar1,
                    this.buscarPosicion(this.cambiar1, this.particulaMenor(this.elegirMayor())),
                    this.cambiar2,
                    this.buscarPosicion(this.cambiar2, this.particulaMenor(this.elegirMayor())),
                    this.elegirMayor(),
                    this.vecAux,
                    1);                
            vMini.setParticulas(this.particula0, this.particula1, this.particula2, this.particula3);
            vMini.trabaja();
            vMini.setDefaultCloseOperation(1);
            vMini.setLocation(400, 300);
            vMini.setTitle("SEGUNDA: "+this.cambiar1+" "+this.cambiar2);
            vMini.setVisible(true);
        }else if(this.bandera==1){
            Maximizar vMini = new Maximizar(this.cambiar1,
                    this.buscarPosicion(this.cambiar1, this.particulaMenor(this.elegirMayor())),
                    this.cambiar2,
                    this.buscarPosicion(this.cambiar2, this.particulaMenor(this.elegirMayor())),
                    this.elegirMayor(),
                    this.vecAux,
                    2);
            vMini.setParticulas(this.particula0, this.particula1, this.particula2, this.particula3);
            vMini.trabaja();
            vMini.setDefaultCloseOperation(1);
            vMini.setLocation(400, 500);
            vMini.setTitle("TERCERA: "+this.cambiar1+" "+this.cambiar2);
            vMini.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Partícula_0:");

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MAXIMIZAR");
        jLabel1.setOpaque(true);

        jLabel7.setText("Partícula_2:");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setOpaque(true);

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setOpaque(true);

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setOpaque(true);

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setOpaque(true);

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setOpaque(true);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setOpaque(true);

        jLabel5.setText("Partícula_1:");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setOpaque(true);

        jLabel16.setText("f(3):");
        jLabel16.setToolTipText("");

        jLabel9.setText("Partícula_3:");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setOpaque(true);

        jLabel13.setText("f(1):");
        jLabel13.setToolTipText("");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setOpaque(true);

        jLabel15.setText("f(0):");
        jLabel15.setToolTipText("");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setOpaque(true);

        jLabel11.setText("f(2):");
        jLabel11.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
