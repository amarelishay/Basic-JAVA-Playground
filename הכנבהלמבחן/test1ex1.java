import java.util.Scanner;

/**
 * Write a description of class test1ex1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test1ex1
{
    public static int road=1;
    static Scanner scanner=new Scanner(System.in);
    private static boolean isSum(int[]a,int num,int i,int sum,int lencounter)
    {
        if (sum==num&&lencounter<=1) return true; 
        if (i>=a.length)return false;
        if (a[i]==num) return true;
        return isSum(a,num,i+1,sum+a[i],lencounter+1)||isSum(a,num,i+1,sum,0);
    }

    public static boolean isSum(int[]a,int num)
    {
        return isSum(a,num,0,0,0);
    }

    public static int shortestRoad(int [] road1,int [] road2){
        int sumroad1left=0,sumroad1right=0,sumroad2left=0,sumroad2right=0,res=0;
        for (int i=0;i<road1.length;i++){
            sumroad1right+=road1[i];
            sumroad2right+=road2[i];
        }
        res=Math.min(sumroad1right,sumroad2right);
        for (int i=0;i<road1.length;i++){
            sumroad1left+=road2[i];
            sumroad1right-=road1[i];
            sumroad2left+=road1[i];
            sumroad2right-=road2[i];
            res=Math.min(sumroad1right+sumroad1left,Math.min(sumroad2right+sumroad2left,res));
        }

        return res;
    }

    public static int turnCheck (int [] [] mat,int k){
        return  turnCheck(mat,k,1,0,true)+turnCheck(mat,k,0,1,false);
    }

    private static int turnCheck (int [] [] mat,int k,int row,int col,boolean top)
    {
        if (row==mat.length-1&&col==mat[0].length-1){
            if (k==0)
                return 1;
            else 
                return 1;
        }
        if (row==mat.length||col==mat[0].length)
            return 0;

        if (top==true)
            return turnCheck(mat,k,row+1,col,true)+turnCheck(mat,k-1,row,col+1,false);
        else
            return turnCheck(mat,k,row,col+1,false)+turnCheck(mat,k-1,row+1,col,true);

    }

    public static int longestPalindrome(int[] arr){
        return longestPalindrome(arr,0,0);
    }

    public static int longestPalindrome(int[] arr,int i,int bigger){
        if (i==arr.length-1)
            return bigger;
        if (arr[i]==arr[i+1])
            bigger = Math.max(bigger,checklength(arr,i,i+1,0));
        else if (i!=0){
            if (arr[i-1]==arr[i+1])
                bigger = Math.max(bigger,checklength(arr,i-1,i+1,1));
        }
        return longestPalindrome(arr,i+1,bigger); 
    }

    public static int checklength(int [] arr,int i,int k,int counter){
        if (k>=arr.length-1||i<0)
            return counter; 

        if (arr[i]==arr[k])
        {
            return checklength(arr,i-1,k+1,counter+2);
        }
        return counter ;

    }

    public static int missingValue (int [] arr){
        if (arr.length<4)
            return -1;
        int a=arr[1]-arr[0],b=arr[2]-arr[1],c=arr[3]-arr[2],jump;
        if (a==b)
            jump=a;
        else if (b==c)
            jump=b;
        else
            jump=c;
        boolean founded=false;
        int i=0;
        while (i<arr.length&&founded==false)
        {
            if (i<arr.length-1&&arr[i]+jump!=arr[i+1])
                founded =true ;
            else
                i++;
        }
        if (founded==true)
            return arr[i]+jump;

        System.out.println("didnt found missing");
        return -1;
    }

    public static int howManySorted(int n, int max){
        if (n==1)
            return max;
        if(max==1)
            return 1;
        return howManySorted(n-1,max)+howManySorted(n,max-1);
    }

    public static int edit (String str1, String str2,int counter){
        if (str1.length()==0){
            return str2.length();
        }
        if (str2.length()==0){
            return str1.length();
        }
        if (str1.charAt(0)==str2.charAt(0)){
            return edit (str1.substring(1),str2.substring(1),counter);
        }
        return Math.min(edit (str1.substring(1),str2,counter+1)+1,edit(str1,str2.substring(1),counter+1)+1);

    }

    public static boolean isValid(char [][]arr,int i,int j){
        if (i<arr.length&&j<arr[0].length&&i>=0&&j>=0)
            return true;

        return false;

    }

    public static void findword(char[][] arr,String word,int col,int row,int counter,String origword){
        if (word.equalsIgnoreCase("")){
            System.out.println("founded");
        }
        if (col==arr.length&&row==arr[0].length){
            System.out.println("not founded"); 
        }
        if (isValid(arr,col,row)){
            if (arr[col][row]==word.charAt(0)){
                arr[col][row]='0';
                findword(arr,word.substring(1),col+1,row,counter,origword);
                findword(arr,word.substring(1),col,row+1,counter,origword);      
            }
            else {
                findword(arr,origword,col-1,row,counter,origword);
                findword(arr,origword,col,row-1,counter,origword);

            }

        }      

    }

    public static int cntTrueReg(boolean[][] mat) {
        return cntTrueReg(mat, 0,0);
    }

    private static int cntTrueReg(boolean[][] mat, int i, int j){
        if (i == mat.length)
            return cntTrueReg(mat, 0, j+1);

        if (j == mat[0].length)
            return 0;

        if (mat[i][j] == true) {
            toFalse(mat, i, j);
            return 1 + cntTrueReg(mat, i+1, j);
        }
        return cntTrueReg(mat, i+1, j);
    }

    private static void toFalse(boolean[][] mat, int i, int j) {

        if (i>=0&&i<mat.length&&j>=0&&j<mat.length){
            if(mat[i][j]==true){
                mat[i][j]=false;
                toFalse(mat,i-1,j);
                toFalse(mat,i+1,j);
                toFalse(mat,i,j+1);
            }
        }

    }   

    public static String get2DArrayPrint(boolean [][] matrix) {
        String output = new String();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output = output + (matrix[i][j] + "\t");
            }
            output = output + "\n";
        }
        return output;
    }

    public static String get2DArrayPrint(int [][] matrix) {
        String output = new String();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output = output + (matrix[i][j] + "\t");
            }
            output = output + "\n";
        }
        return output;
    }

    public static int countTriplets(int[] arr, int num) {
        int counter = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            int right=0,left=arr.length-1;
            while (right < left) {
                {
                    if (i==right){
                        right++;
                    }
                    if (i==left){
                        left--;
                    }
                    if (arr[i] + arr[right] + arr[left] >= num) {
                        left--;
                    }
                    else if (arr[i] + arr[right] + arr[left] < num) {
                        counter++;
                        right++;
                    }
                }
            }
        }

        return counter/2;
    }

    public static void printPathWeights(int [][] m){
        printPathWeights(m,new int [m.length][m[0].length],0,0,0);
    }

    public static void printPathWeights(int [][] m,int [][] soFar,int row,int col,int counter) {

        if (row==m.length-1&&col==m.length-1){
            System.out.println ("road "+(road++)+":"+(counter+m[row][col]));
            return;
        }
        if(row>=0&&row<m.length&&col>=0&&col<m[0].length&&soFar[row][col]!=-1){

            counter+=m[row][col];
            soFar[row][col]=-1;
            printPathWeights(m,soFar,row,col-1,counter);
            printPathWeights(m,soFar,row+1,col,counter);
            printPathWeights(m,soFar,row,col+1,counter);
            printPathWeights(m,soFar,row-1,col,counter);  

            soFar[row][col]=0;

        }

    }

    public static boolean isSumOf(int[] s, int n){
        return isSumOf(s,0,n,0,new int [20]);
    }

    public static boolean isSumOf(int[] arr, int sum,int n,int i,int [] see) {
        if(i>=arr.length){
            return false;
        }
        if(sum>n){
            return false;
        }
        see[i]=arr[i];
        if (arr[i]+sum==n){
            return true;
        }
        if (arr[i]==0){
            return isSumOf(arr,sum,n,i+1,see);   
        }
        return isSumOf(arr,sum+arr[i],n,i,see)||isSumOf(arr,sum+arr[i],n,i+1,see)||isSumOf(arr,sum,n,i+1,see);
    }

    public static int binarySerchFirst(int [] arr, int num){
        int right =arr.length-1 ;
        int left=0;
        if (arr[0]==num){
            return 0;
        }
        if (arr[arr.length-1]==num&&arr[arr.length-2]!=num){
            return arr.length-1;
        }
        while (right>left&&right-left>1){
            if (arr[(right + left)/2]==num&&arr[((right+left)/2)-1]!=num)
            {
                return (right+left)/2;
            }

            else if (arr[(right+left)/2]<num){
                left=(right+left)/2;
            }
            else {
                right=(right+left)/2;
            }
        }
        return -1;
    }

    public static int binarySerchLast(int [] arr,int num){
        int right =arr.length-1 ;
        int left=0;
        if (arr[0]==num&&arr[1]!=num){
            return 0;
        }
        if (arr[arr.length-1]==num){
            return arr.length-1;
        }
        while (right>left&&right-left>1){
            if (arr[(right + left)/2]==num&&arr[((right+left)/2)+1]!=num)
            {
                return (right+left)/2;
            }

            else if (arr[(right+left)/2]<=num){
                left=(right+left)/2;
            }
            else {
                right=(right+left)/2;
            }
        }
        return -1;
    }

    public static int count (int[] a, int x){
        int big=binarySerchLast(a,x);
        int small=binarySerchFirst(a,x);
        if(small==-1||big==-1){
            return 0;
        }
        return 1+big-small;
    }

    public static boolean isSubstring (String s1, String s2){
        return isSubstring (s1,s2,s2,0);

    }

    public static boolean isSubstring (String s1, String s2,String origin,int i) {
        if (s2.equals("")){
            return true;
        }
        if (i>=s1.length()){
            return false;
        }
        if (s1.charAt(i)==s2.charAt(0)){
            return isSubstring (s1,s2.substring(1),origin,i+1);
        }
        return isSubstring (s1,origin,origin,i+1);
    }

    public static int totalways(int[][] mat,int k){
        return totalways(mat,k,1,0,true)+totalways(mat,k,0,1,false);
    }

    public static int totalways(int[][] mat,int k,int row,int col,boolean top){
        if(row==mat.length-1&&col==mat.length-1){
            if(k==0)
                return 1;
            else 
                return 0;
        }
        if (row>=mat.length||col>=mat[0].length){
            return 0;
        }
        if (top==true){
            return totalways(mat,k,row+1,col,true)+ totalways(mat,k-1,row,col+1,false);
        }
        return totalways(mat,k-1,row+1,col,true)+totalways(mat,k,row,col+1,false);
    }

    public static void crossSort (int []arr)
    {
        int [] temp = new int [arr.length];
        int i=0;
        int j;
        if (arr.length %2 == 0)
            j = arr.length-1;
        else
            j = arr.length-2;
        for (int k=0; k<temp.length; k++)
        {
            if (i<arr.length && j>-1) {
                if (arr[i]<=arr[j]) {
                    temp[k] = arr[i];
                    i+=2;
                }
                else {
                    temp[k] = arr[j];
                    j-=2;
                }
            }
            else if (i>=arr.length) {
                temp[k] = arr[j];
                j-=2;
            }
            else {
                temp[k] = arr[i];
                i+=2;
            }
        }

        for (int ind = 0; ind < temp.length; ind++) {
            arr[ind]=temp[ind];
        }
    } 

    public static boolean isPythagorean(int [] arr){
        for (int i=0;i<arr.length;i++){
            int left=0;
            int right=arr.length-1;
            while (right-left>=1){
                if (right==i){
                    right--;
                }
                else if(left==i){
                    left++;
                }
                else if(Math.pow(arr[left],2)+Math.pow(arr[right],2)>Math.pow(arr[i],2)){
                    right--;

                }
                else if(Math.pow(arr[left],2)+Math.pow(arr[right],2)<Math.pow(arr[i],2)){
                    left++;
                }
                else if(Math.pow(arr[left],2)+Math.pow(arr[right],2)==Math.pow(arr[i],2)){
                    return true;
                }
            }
        }
        return false;

    }

    public static void findWord(char[][] arr, String word) {
        findWord(arr, word, 0, 0, new int[arr.length][arr[0].length]);
    }

    public static void findWord(char[][] arr, String word, int row, int col, int[][] mat) {
        if (checkWord(row, col, mat, word, arr, 1)) {
            System.out.println(get2DArrayPrint(mat));

        } else if (row >= 0 && row < arr.length && col >= 0 && col < arr.length) {
            if (row == arr.length - 1 && col == arr.length - 1) {
                System.out.println("No Such Word");

            }
            if (col >= arr[0].length - 1) {
                findWord(arr, word, row + 1, 0, mat);
            }
            findWord(arr, word, row, col + 1, mat);
        }
    }

    public static boolean checkWord(int row, int col, int[][] mat, String word, char[][] arr, int counter) {
        if (word.equals("")) {
            return true;
        }
        if (row >= 0 && row < arr.length && col >= 0 && col < arr.length&&mat[row][col]==0) {
            if (arr[row][col] == word.charAt(0)) {
                mat[row][col] = counter;

                return checkWord(row , col+1, mat, word.substring(1), arr, counter + 1) ||
                checkWord(row - 1, col, mat, word.substring(1), arr, counter + 1) ||
                checkWord(row, col + 1, mat, word.substring(1), arr, counter + 1) ||
                checkWord(row+1, col , mat, word.substring(1), arr, counter + 1);

            }
            else
            if (mat[row][col]>=counter)
                mat[row][col] = 0;
        }

        return false;
    }

    public static boolean match(int[] a, int[] pattern){
        return match(a,pattern,0,0);
    }

    public static boolean match(int[] a, int[] pattern, int i, int j) {
        if (pattern.length == 0 && a.length != 0) {
            return true;
        }

        if (j >= pattern.length) {
            return true;
        }
        if (i >= a.length) {
            return false;
        }
        if ((pattern[j] == 0 || pattern[j] == 2) && (a[i] < 100 && a[i] > 9)) {
            return match(a, pattern, i + 1, j + 1);
        }
        if ((pattern[j] == 0 || pattern[j] == 1) && a[i] < 10) {
            return match(a, pattern, i + 1, j + 1);
        }
        return match(a, pattern, i + 1, 0);
    }

    public static void main (String [] args) {
        int a[] ={150,150,7,4,2,1,4,5,8,4,5,8,4,25,5,5,400};
        //int a[] ={150,1,150};
        boolean test=isSum(a,307);
        System.out.println (test);
        int b[] ={5,4,5,8,12,9,9,3};
        int c[]={7,3,3,12,10,2,10,7};
        int test2=shortestRoad(b,c);
        System.out.println(test2);
        int [][] mat =new int[3][3];
        System.out.println(turnCheck(mat,4));
        int []d={1,3,2,3,10,10,3,2,4};
        System.out.println(longestPalindrome(d));
        int e[]={7,10,13,16,19,22,25};
        System.out.println(missingValue(e));
        int r=howManySorted(3,2);
        System.out.println(edit("sunday","saturday",0));
        char arr [][]={{'t','z','x','c','d'},{'s','h','a','z','x'},{'h','w','l','o','m'},{'o','r','n','t','n'},{'a','b','r','i','n'}};
        findword(arr,"shalom",0,0,0,"shalom");
        boolean [][]mat2={{false,false,true,false,true},{false,true,true,true,false},{false,false,true,true,false},{true,false,false,false,false},{true,true,false,false,false}};
        boolean [][]mat3={{true,false,true},{true,false,false},{false,false,false}};
        System.out.println( get2DArrayPrint(mat2)); 
        System.out.println(cntTrueReg (mat2));
        System.out.println(countTriplets(new int [] {-2,0,1,3},2));
        //crossSort(new int[] {1,9,2,8,4,7,7,4,12});
        //printPathWeights(new int [][]{{8,4,2,4,3},{6,3,8,4,5},{1,4,9,9,7},{2,1,7,6,5}});
        System.out.println(isSumOf(new int [] {4,5},13));
        System.out.println(count(new int[]{-5,-5,1,1,1,1,1,1,1,1,2,2,2,2,2,3,3,3,67,67,99},8));
        System.out.println(isSubstring("”program","gram"));
        System.out.println(isPythagorean(new int [] {1,2,3,4,5,7,8,10,12}));
        char arr8[][] = new char[][]{{'t', 'z', 'x', 'c', 'd'}, {'s', 'h', 'a', 'z', 'x'}, {'h', 'w', 'l', 'o', 'm',}, {'o', 'r', 'n', 't', 'n'}, {'a', 'b', 'r', 'i', 'n'}};
        findWord(arr8, "shalom");
        System.out.println(match(new int[]{2,3},new int[]{1,0,2}));
    }
}

