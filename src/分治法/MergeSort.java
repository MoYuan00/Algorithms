package ·ÖÖÎ·¨;
/**
 *  merge sort
 */
public class MergeSort{
    /**
     *  
     * array: wait to sort
     * tempArray: temp to sort
     * l: left for array bound limit
     * m: left end
     * r: right end
     */
    public static void merge(int array[], int tempArray[], int l, int m, int r) {
        for(int i = l; i <= r; i++)//  copy elements of array to tempArray 
            tempArray[i] = array[i];
        int i = l; int j = m + 1; int k = l;
        while(i <= m && j <= r){
            if(tempArray[i] < tempArray[j]){
                array[k] = tempArray[i]; i++;
            }else{
                array[k] = tempArray[j]; j++;
            }
            k++;
        }
        while(i <= m){
            array[k] = tempArray[i]; i++; k++;
        }
        while(j <= r){
            array[k] = tempArray[j]; j++; k++;
        }
    }
    /**
     * 
     */
    public static void mergeSort(int array[], int tempArray[], int l, int r) {
        if(l < r){
            int m = ((l + r) >> 1);
            mergeSort(array, tempArray, l, m);
            mergeSort(array, tempArray, m + 1, r); // rigth start with m+1
            merge(array, tempArray, l, m, r);
        }
    }
    public static void main(String[] args) {
        int len = 333345;
        int array[] = new int[len + 1];
        for(int i = 1; i <= len; i++){
            array[i] = i * 17 % 3333173;
        }
        // for(int i = 1; i <= len; i++){
        //     System.out.print(array[i] + ",");// = i * 17 % 31;
        // }
        // System.out.print("\n");
        int tempArray[] = new int[len + 1];
        mergeSort(array, tempArray, 1, len);
        // for(int i = 1; i <= len; i++){
        //     System.out.print(array[i] + ",");// = i * 17 % 31;
        // }
    }

}