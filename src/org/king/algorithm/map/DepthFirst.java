package org.king.algorithm.map;

public class DepthFirst {
	private String[] V = {"s","1","2","3","4","5","6","7","8"};
	private int[] d = new int[V.length];
	private int[] f = new int[V.length];
	private int[] pred = new int[V.length];
	Color[] color = new Color[V.length];
	
	private int[][] u = new int[V.length][V.length];
	
    int counter;
    DepthFirst(){
    	init();
    }
    
    public static void main(String[] args) {
    	DepthFirst map = new DepthFirst();
    	map.depthFirstSearch();
	}
    
    
    void init(){
    	u[0][1]=u[1][2]=u[2][3]=u[3][4]=u[4][5]=u[0][4]=u[2][6]=u[7][8]=1;
    	for(int i =0;i<V.length;i++){
    		for(int j=i;j<V.length;j++){
    			if( u[i][j] == 1 ){
    				u[j][i] = 1;
    			}
    		}
    	}
    	
    	
    	/*for(int i =0;i<V.length;i++){
    		for(int j=0;j<V.length;j++){
    			if( u[i][j] == 1 ){
    				System.out.println(V[i] + " >>> " + V[j]);
    			}
    		}
    	}*/
    	
    }
    
    void depthFirstSearch(){
    	for(int i = 0;i< V.length;i++){
    		d[i] = f[i] = pred[i] = -1;
    		color[i] = Color.WHITE;
    	}
    	counter = 0;
    	visit(0);
    	for(int i = 0;i< V.length;i++){
    		if(color[i] == Color.WHITE){
    			visit(i);
    		}
    	}
    }
	private void visit(int index) {
		color[index] = Color.GRAY;
		d[index] = ++counter;
		for(int i =0;i<V.length;i++){
			if(u[index][i] == 1 && color[i] == Color.WHITE){
				pred[i] = index;
				visit(i);
			}
		}
		
		color[index] = Color.BLACK;
		f[index] = ++counter;
		
	}
    

}
enum Color{
	WHITE,GRAY,BLACK
}