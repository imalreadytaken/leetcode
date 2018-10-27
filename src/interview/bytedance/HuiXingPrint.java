package interview.bytedance;

public class HuiXingPrint {

    public void solution(int n){
        int[][] res = new int[n][n];
        int rowUp = n - 1, rowDown = 1, colUp = n-1, colDown = 1, rowCur = 0, colCur = 0;
        int dest = 0;
        int t = 1, max = n * n;
        while(t <= max){
            res[rowCur][colCur] = t;
            switch(dest){
                case 0:
                    if(colCur < colUp)
                        colCur++;
                    else{
                        rowDown--;
                        dest++;
                    }
                    break;
                case 1:
                    if(rowCur < rowUp)
                        rowCur++;
                    else{
                        colUp--;
                        dest++;
                    }
                    break;
                case 2:
                    if(colCur > colDown)
                        colCur--;
                    else{
                        rowUp--;
                        dest++;
                    }
                    break;
                case 3:
                    if(rowCur > rowUp)
                        rowCur--;
                    else{
                        colDown++;
                        dest = 0;
                    }
            }
            t++;
        }
    }

}
