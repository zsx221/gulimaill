public class topic672 {
    /*房间中有n只已经打开的灯泡，编号从 1 到 n 。墙上挂着 4 个开关 。

这 4 个开关各自都具有不同的功能，其中：
开关 1 ：反转当前所有灯的状态（即开变为关，关变为开）
开关 2 ：反转编号为偶数的灯的状态（即 2, 4, ...）
开关 3 ：反转编号为奇数的灯的状态（即 1, 3, ...）
开关 4 ：反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...）
你必须 恰好 按压开关 presses 次。每次按压，你都需要从 4 个开关中选出一个来执行按压操作。

给你两个整数 n 和 presses ，执行完所有按压之后，返回 不同可能状态 的数量。
来源：力扣（LeetCode）
。*/
    public final static int lenth=4;
    public int flipLights(int n, int presses) {
        int a[]=new int[lenth];
        int status=0;
        for (int i : a) {//初始化灯泡，默认是亮的
            i=1;
        }

        return status;
    }
    public void switch1(int a[]){//开关 1 ：反转当前所有灯的状态（即开变为关，关变为开）

    }
    public void switch2(int a[]){//开关 2 ：反转编号为偶数的灯的状态（即 2, 4, ...）

    }
    public void switch3(int a[]){//开关 3 ：反转编号为奇数的灯的状态（即 1, 3, ...）

    }
    public void switch4(int a[]){//开关 4 ：反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...）

    }
    public boolean isequals(int []a,int []b){
        return true;
    }
}
