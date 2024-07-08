public class RunningInCircle {
    public static void main(String[] args) {
        RunningInCircle runningInCircle = new RunningInCircle();

        System.out.println(runningInCircle.getPosition(4,1));
    }

    public int getPosition(int n,int x){
        //x是秒
        int pos = 1;//当前位置
        boolean flag = true;//前进
        int time = 1;//当前秒数
        while (x-->0){
            if (flag){
                pos = ((pos+time-1)%n)+1;
            }else{
                //后退
                pos = (pos-time)<=1?1:pos-time;
            }
            if (flag) flag = false;
            else flag = true;
            time++;
        }
        return pos;
    }
}
