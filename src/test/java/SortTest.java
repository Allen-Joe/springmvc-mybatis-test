
public class SortTest {
	
	public static void bubbleSort(int[] datas){
		 int tempData;
		 int size=datas.length;
		 for (int i = 0; i < size-1; i++) {
			for(int j=i+1;j<size;j++){
				if(datas[i]>datas[j]){
					tempData=datas[i];
					datas[i]=datas[j];
					datas[j]=tempData;
				}
			}
		 }
	}
	
	public static void selectSort(int[] numbers) {   
	    int size = numbers.length, temp;   
	    for (int i = 0; i < size; i++) {   
	        int k = i;   
	        for (int j = size - 1; j >i; j--)  {   
	            if (numbers[j] > numbers[k])  k = j;   
	        }   
	        temp = numbers[i];   
	        numbers[i] = numbers[k];   
	        numbers[k] = temp;   
	    }   
	}  
	
	public static void main(String[] args) {
		int[] datas={5,1,6,8,3,9,4};
		//bubbleSort(datas);
		selectSort(datas);
		for (int i = 0; i < datas.length; i++) {
			System.out.print(datas[i]);
		}
	}

}
