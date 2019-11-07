package leetcode203;

public class Sum {
    // 使用者:,传入一个arr数组即可求和
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 实现者:
    public static int sum(int[] arr, int l) {
        // 求解最基本的问题
        if (l == arr.length)
            return 0;

        // 把原问题转化成更小的问题
        // arr[l] 加上的其实是一个过程,不是一个具体的值, 展开来说就是 arr[1] + sum()这个函数计算出来的一个值 和另外一个过程,
        // 而这个过程的值是arr[2] + 这个过程,这样一直展开下去到最后 l == arr.length 返回一个 0, 然后将从这个结果开始向上开始计算
        // 假设这个数组的长度是100(长度是length = 100 侧到arr[99]结束, l == arr.length 的值是不存在的则 arr[100] = 0),
        // 则从 0 + arr[99] + arr[98]... + arr[2] + arr[1] + arr[0],
        return arr[l] + sum(arr, l + 1);
    }


    public static void main(String[] args) {
        int arr[] = new int[100];
        for (int i = 0; i < 8; i++) {
            arr[i] = i+1;
        }

        System.out.println(sum(arr));
    }
}
