package org.king.algorithms.cversion.map;

import java.util.LinkedList;
import java.util.Queue;

public class BreadFirst {
	private String[] V = {"s","1","2","3","4","5","6","7","8","9","10","11","12","13","14","t"};
	private int[] dist = new int[V.length];
	private int[] pred = new int[V.length];
	private Color[] color = new Color[V.length];
	private Queue<Integer> queue = null;
	
	private boolean[][] u = new boolean[V.length][V.length];
	
    int counter;
    BreadFirst(){
    	init();
    }
    
    public static void main(String[] args) {
    	BreadFirst map = new BreadFirst();
    	map.breadFirstSearch();
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
    	    	true;
    	
    	for(int i =0;i<V.length;i++){
    		for(int j=i;j<V.length;j++){
    			if( u[i][j] == true ){
    				u[j][i] = true;
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
    
    void breadFirstSearch(){
    	for(int i = 0;i< V.length;i++){
    		pred[i] = -1;
    		dist[i] = -1;
    		color[i] = Color.WHITE;
    	}
		
    	
    	//遍历第一个点
    	color[0] = Color.WHITE;
    	dist[0] = 0;
    	queue = new LinkedList<Integer>();  
    	queue.offer(0);
    	
    	while(!queue.isEmpty()){
    		int h = queue.poll();
    		for(int i =0;i<V.length;i++){
    			//如果存在 h 到 i 的边 并且 i 没有被访问
    			if( u[h][i] && color[i] == Color.WHITE){
    				dist[i] = dist[h] + 1;
    				pred[i] = h;
    				color[i] = Color.GRAY;
    				queue.offer(i);
    			}
    		}
    		//queue.clear();
    		color[h] = Color.BLACK;
    	}
    	
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