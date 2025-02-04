package com.lagacy.datastructure.recursion;

//8皇后问题
public class Queen {

    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.check(0);
        System.out.println("一共有" + count +"解法");
    }

    //放置第n个皇后
    //特别注意：check时每一次递归时，进入到check中都有for(int i = 0; i < max; i++),因此会有回溯
    private void check(int n) {
        if (n == max) { //n = 8, 8个皇后就已经放好了
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n放到该的第一列
            array[n] = i;

            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {//不冲突

                check(n + 1);

            }
            //如果冲突，就继续执行array[n] = i;即将第n个皇后，放置在本行的后移的一个位置
        }

    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突

    /**
     * @param n 表示第几个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //1. array[i]==array[n] 表示同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 斜率公式
            //3. 判断是否在同一行：n在递增，没有必要
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }


    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
