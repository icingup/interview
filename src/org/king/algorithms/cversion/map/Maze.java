package org.king.algorithms.cversion.map;

public class Maze {
	private String[] V = {"s","1","2","3","4","5","6","7","8","9","10","11","12","13","14","t"};
	private int[] d = new int[V.length];
	private int[] f = new int[V.length];
	private int[] pred = new int[V.length];
	Color[] color = new Color[V.length];
	
	private int[][] u = new int[V.length][V.length];
	
    int counter;
    Maze(){
    	init();
    }
    
    public static void main(String[] args) {
    	Maze map = new Maze();
    	map.depthFirstSearch();
    	map.printResult(15);
	}
    
	void init(){
    	u[0][1]=u[0][6]=u[0][8]=
    	u[1][2]=u[1][3]=
    	u[2][10]=u[2][11]=
    	u[3][4]=u[3][12]=
    	u[4][5]=u[4][13]=
    	u[5][6]=u[5][9]=
    	u[6][7]=
    	u[7][8]=u[7][9]=
    	u[8][14]=
    	u[9][15]=
    	1;
    	
    	
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
    	}
    	*/
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
	//打印结果
	 private void printResult(int target) {
		 	int _post = target;
		 	while(true){
		 		System.out.print(V[_post]);
		 		if(pred[_post] == -1){
			    	break;
			    }else{
			    	System.out.print("<--");
			    	_post = pred[_post];
			    }
		 	}
		}

}