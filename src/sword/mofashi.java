package sword;

import java.util.ArrayList;

class mofashi{
	public void mofa(int group,int[][] array){
		if (group*2 != array.length){
			System.out.println("please check your input");
		}
		for (int start = 0; start<array.length-1;start=start+2 ) {
			System.out.println(check_square(start,start+1,array));
		}
	}

	public boolean check_square(int start,int end,int[][] array){
		ArrayList x1 = new ArrayList(); //存放第一组横坐标相同的点
		x1.add(0);
		ArrayList x2 = new ArrayList();//存放第二组横坐标相同的点
		//遍历横坐标数组，和第一个横坐标不同的丢到x2集合中，相同的丢到x1集合中
		for (int i = 1; i<array[start].length ; i++ ) {
			if (array[start][i] != array[start][0] ) {
				x2.add(i);
			}else{
				x1.add(i);
			}			
		}
		if (x1.size()!=x2.size()) return false;
		// 纵坐标的差异 两组应该一样，并且大的应该一样，否则平行四边形情况
		int max1 = array[end][(int) x1.get(0)] > array[end][(int) x1.get(1)]?0:1;
		int max2 = array[end][(int) x2.get(0)] > array[end][(int) x2.get(1)]?0:1;
		return ((array[end][(int) x1.get(max1)] - array[end][(int) x1.get(1 - max1)])
				== (array[end][(int) x2.get(max2)] - array[end][(int) x2.get(1-max2)]))
				&& (array[end][(int) x1.get(max1)] == array[end][(int) x2.get(max2)]);
	}

	public static void main(String[] args) {
		mofashi m = new mofashi();
		int[][] a = new int[][]{{0,0,1,1},{0,1,0,1},{0,0,1,1},{0,1,5,1}};
		m.mofa(1,a);
	
	}
}
